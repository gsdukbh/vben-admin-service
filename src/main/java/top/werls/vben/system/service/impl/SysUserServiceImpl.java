package top.werls.vben.system.service.impl;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.werls.vben.common.utils.JwtTokenUtils;
import top.werls.vben.common.utils.crypto.asymmetric.RSA;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.repository.UserRepository;
import top.werls.vben.system.service.SysUserRoleService;
import top.werls.vben.system.service.SysUserService;
import top.werls.vben.system.vo.LoginVo;
import top.werls.vben.system.vo.UserInfoVo;

import java.security.interfaces.RSAPrivateKey;
import java.util.List;

@Service
@Slf4j
public class SysUserServiceImpl  implements SysUserService {

    @Value("${env.jwt.privateKey}")
    private RSAPrivateKey key;

    private final UserDetailsServiceImpl userDetailsService;

    private final SysUserRoleService sysUserRoleService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenUtils tokenUtils;


    private  final UserRepository userRepository;

    public SysUserServiceImpl(UserDetailsServiceImpl userDetailsService,
        SysUserRoleService sysUserRoleService, PasswordEncoder passwordEncoder,
        JwtTokenUtils tokenUtils, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.sysUserRoleService = sysUserRoleService;
        this.passwordEncoder = passwordEncoder;
        this.tokenUtils = tokenUtils;
        this.userRepository = userRepository;
    }

    /**
     * 登录
     *
     * @param param
     * @return
     */
    @Override
    public LoginVo login(LoginParam param) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(param.getUsername());

        SysUser user = getByUsername(param.getUsername());

        if (!passwordEncoder.matches(user.getSalt() + param.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(tokenUtils.generateToken(userDetails.getUsername()));
        return loginVo;
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public SysUser getByUsername(String username) {
      return userRepository.findByUsername(username);
    }

    /**
     * 用户信息
     *
     * @param username name
     * @return {@link UserInfoVo}
     */
    @Override
    public UserInfoVo getUserInfo(String username) {
        SysUser user = getByUsername(username);
        List<SysRole> roles = sysUserRoleService.getByUid(user.getUid());
        return new UserInfoVo(user, roles);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(SysUser user) {
        try {
            var salt = RSA.signToBase64(user.getUsername() + System.currentTimeMillis(), key);
            user.setSalt(salt);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

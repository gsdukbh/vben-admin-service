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
import top.werls.vben.system.mapper.SysUserMapper;
import top.werls.vben.system.param.LoginParam;
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
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    @Resource
    private SysUserRoleService sysUserRoleService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtils tokenUtils;

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
//        var  user = new  QueryWrapper<SysUser>();
//        user.lambda().eq(SysUser::getUsername,username);
//        return super.getOne(user);
        return null;
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
            // todo
//            save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

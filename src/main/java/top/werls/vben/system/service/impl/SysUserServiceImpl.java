package top.werls.vben.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.werls.vben.common.utils.JwtTokenUtils;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.mapper.SysUserMapper;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.service.SysUserService;
import top.werls.vben.system.vo.LoginVo;

import javax.annotation.Resource;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {


    @Resource
    private UserDetailsServiceImpl userDetailsService;

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

        if (!passwordEncoder.matches(param.getPassword(), userDetails.getPassword())) {
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
        return baseMapper.getByUsername(username);
    }

}

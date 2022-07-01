package top.werls.vben.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.mapper.SysUserMapper;
import top.werls.vben.system.service.SysUserRoleService;
import top.werls.vben.system.service.SysUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getByUsername(username);

        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SysRole> roles = sysUserRoleService.getByUid(sysUser.getUid());
        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(() -> "ROLE_USER");
        for (SysRole role : roles) {
            authorities.add(role::getValue);
        }
        User user = new User(username, sysUser.getPassword(), sysUser.isEnabled()
                , sysUser.isAccountNonExpired(), sysUser.isCredentialsNonExpired(), sysUser.isAccountNonLocked(), authorities);
        return user;
    }


}

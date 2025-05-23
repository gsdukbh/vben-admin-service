package top.werls.vben.system.service;



import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.dto.LoginVo;
import top.werls.vben.system.dto.UserInfoVo;

public interface SysUserService  {


    /**
     *
     * 登录
     * @param param
     * @return
     */
    LoginVo login(LoginParam param);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getByUsername(String username);

    /**
     * 用户信息
     * @param username name
     * @return {@link UserInfoVo}
     */
    UserInfoVo getUserInfo(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(SysUser user);
}

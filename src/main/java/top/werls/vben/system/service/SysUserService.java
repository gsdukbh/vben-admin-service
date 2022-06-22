package top.werls.vben.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.vo.LoginVo;
import top.werls.vben.system.vo.UserInfoVo;

public interface SysUserService extends IService<SysUser> {


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

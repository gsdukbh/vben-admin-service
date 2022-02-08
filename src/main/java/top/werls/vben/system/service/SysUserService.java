package top.werls.vben.system.service;


import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.vo.LoginVo;

public interface SysUserService {


    /**
     *
     * 登录
     * @param param
     * @return
     */
    LoginVo login(LoginParam param);

}

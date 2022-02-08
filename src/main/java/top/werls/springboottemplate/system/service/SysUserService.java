package top.werls.springboottemplate.system.service;


import top.werls.springboottemplate.system.param.LoginParam;
import top.werls.springboottemplate.system.vo.LoginVo;

public interface SysUserService {


    /**
     *
     * 登录
     * @param param
     * @return
     */
    LoginVo login(LoginParam param);

}

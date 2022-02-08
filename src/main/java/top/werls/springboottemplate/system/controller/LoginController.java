package top.werls.springboottemplate.system.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.werls.springboottemplate.common.ResultData;
import top.werls.springboottemplate.system.param.LoginParam;
import top.werls.springboottemplate.system.service.SysUserService;
import top.werls.springboottemplate.system.vo.LoginVo;

import javax.annotation.Resource;


@Slf4j
@RestController
public class LoginController {


    @Resource
    private SysUserService userService;

    @PostMapping("/login")
    public ResultData<LoginVo> login(@RequestBody LoginParam param) {
        return ResultData.success(userService.login(param));
    }
}

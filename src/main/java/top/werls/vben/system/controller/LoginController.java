package top.werls.vben.system.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.werls.vben.common.utils.ResultData;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.service.SysUserService;
import top.werls.vben.system.vo.LoginVo;
import top.werls.vben.system.vo.UserInfoVo;

import javax.annotation.Resource;


@Slf4j
@RestController
public class LoginController {


    @Resource
    private SysUserService userService;

    @PostMapping("/login")
    public ResultData<LoginVo> login(@RequestBody @Validated LoginParam param) {
        return ResultData.success(userService.login(param));
    }

    @GetMapping("/getUserInfo")
    public ResultData<UserInfoVo> getUserInfo() {
        return ResultData.success(new UserInfoVo());
    }




}

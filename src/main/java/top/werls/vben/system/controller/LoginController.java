package top.werls.vben.system.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.werls.vben.common.utils.ResultData;
import top.werls.vben.config.SwaggerConfig;
import top.werls.vben.system.param.LoginParam;
import top.werls.vben.system.service.SysUserService;
import top.werls.vben.system.dto.LoginVo;
import top.werls.vben.system.dto.UserInfoVo;


import java.security.Principal;


@Tag(name = "登录处理")
@Slf4j
@RestController
@SecurityRequirement(name = SwaggerConfig.TOKEN_HEADER)
public class LoginController {


    @Resource
    private SysUserService userService;

    @Operation(summary = "login", description = "登录")
    @PostMapping("/login")
    public ResultData<LoginVo> login(@RequestBody @Validated LoginParam param) {
        return ResultData.success(userService.login(param));
    }

    @GetMapping("/getUserInfo")
    public ResultData<UserInfoVo> getUserInfo(Principal principal) {
        return ResultData.success(userService.getUserInfo(principal.getName()));
    }

    @GetMapping("/getPermCode")
    public ResultData<String[]> getPermCode() {
        return ResultData.success(new String[]{"1000", "2000", "3000"});
    }

}

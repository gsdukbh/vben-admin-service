package top.werls.springboottemplate.system.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(name = "LoginParam",description = "登录参数")
public class LoginParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;
    @Schema(description = "用户名", required = true, example = "admin")
    private String username;
    @Schema(description = "密码", required = true, example = "admin")
    private String password;
}


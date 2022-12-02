package top.werls.vben.system.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;


@Data
@Schema(name = "LoginParam", description = "登录参数")
public class LoginParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;
    @NotNull(message = "不能为空")
    @Schema(description = "用户名", required = true, example = "vben")
    private String username;
    @NotNull(message = "不能为空")
    @Schema(description = "密码", required = true, example = "123456")
    private String password;
}


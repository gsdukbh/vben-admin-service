package top.werls.vben.system.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.werls.vben.system.entity.SysUser;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author leejiawei
 */
@Data
@Schema(name = "登录信息")
public class LoginVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 12L;
    @Schema(description = "用户信息")
    SysUser user;
    @Schema(description = "token")
    String token;
}

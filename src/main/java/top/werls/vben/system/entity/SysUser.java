package top.werls.vben.system.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "用户实体类")

public class SysUser extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long uid;

    @Schema(description = "用户名", example = "admin")
    private String username;

    @Schema(description = "密码", example = "123456")

    private String password;
    @Schema(name = "加密盐")
    private String salt;

    @Schema(description = "电话", example = "1231")
    private String phone;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "昵称", example = "admin")
    private String nickname;
    @Schema(description = "真名", example = "admin")
    private String realName;
    @Schema(description = "是否启用")
    private boolean enabled;
    @Schema(description = "主页")
    private String  homePath;
    @Schema(description = "账户未过期")
    private boolean accountNonExpired;
    @Schema(description = "凭据未过期")
    private boolean credentialsNonExpired;
    @Schema(description = "账户未锁定")
    private boolean accountNonLocked;
    private Integer deptId;

}

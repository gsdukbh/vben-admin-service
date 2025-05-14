package top.werls.vben.system.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serial;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

@Getter
@Setter
@Schema(description = "用户实体类")
@Entity
@Table(name = "SysUser", uniqueConstraints = {
    @UniqueConstraint(name = "uc_sysuser_username", columnNames = {"username"})
})
public class SysUser {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

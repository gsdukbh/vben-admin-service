package top.werls.vben.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;

import java.io.Serial;
import java.util.List;

/**
 * @author leejiawei
 * @version TODO
 * @since on 2022/2/15
 **/
@Data
@Schema(name = "用户信息VO")
public class UserInfoVo implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -72618660139164414L;

    @Schema(description = "用户信息")
    private SysUser user;
    @Schema(description = "角色信息")
    private List<SysRole> roles;
}

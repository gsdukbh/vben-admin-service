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

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userId;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String realName;
    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatar;
    /**
     * 用户主页
     */
    @Schema(description = "用户主页")
    private String homePath;
    @Schema(description = "介绍")
    private String desc;
    /**
     * 角色列表
     */
    @Schema(description = "角色信息")
    private List<SysRole> roles;

    public UserInfoVo() {
    }

    public UserInfoVo(SysUser user) {
        this.userId = user.getUid();
        this.username = user.getUsername();
        this.realName = user.getRealName();
        this.avatar = user.getAvatar();
    }
    public UserInfoVo(SysUser user, List<SysRole> roles) {
        this.userId = user.getUid();
        this.username = user.getUsername();
        this.realName = user.getRealName();
        this.avatar = user.getAvatar();
        this.homePath = user.getHomePath();
        this.roles = roles;
    }
}

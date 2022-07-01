package top.werls.vben.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("vben_sys_role")
@Schema(title = "role",description = "角色")
public class SysRole extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 211L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long rid;
    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;
    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String value;
    /**
     * 角色描述
     */
    @Schema(description = "角色描述")
    private String description;
    
}

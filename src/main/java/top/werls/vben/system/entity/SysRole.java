package top.werls.vben.system.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "role",description = "角色")
@Entity
public class SysRole extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 211L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

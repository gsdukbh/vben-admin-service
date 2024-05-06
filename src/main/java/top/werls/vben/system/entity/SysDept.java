package top.werls.vben.system.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(title = "SysDept",description = "部门")
public class SysDept extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String deptName;
    private String remark;
    private Integer parentId;
    private Integer orderNo;



}

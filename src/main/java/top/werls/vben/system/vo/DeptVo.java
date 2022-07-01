package top.werls.vben.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.werls.vben.system.entity.SysDept;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/7/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "部门")
public class DeptVo extends SysDept {
    private List<DeptVo> children;

    public DeptVo() {
    }

    public DeptVo(SysDept dept) {
        this.setId(dept.getId());
        this.setDeptName(dept.getDeptName());
        this.setOrderNo(dept.getOrderNo());
        this.setRemark(dept.getRemark());
        this.setParentId(dept.getParentId());
        this.children = new ArrayList<>();
    }

}

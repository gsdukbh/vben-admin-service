package top.werls.vben.system.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import top.werls.vben.system.entity.SysDept;

/** DTO for {@link SysDept} */
@Data
public class SysDeptDto implements Serializable {

  private Date createTime;
  private Date updateTime;
  private Integer id;
  private String deptName;
  private String remark;
  private Integer parentId;
  private Integer orderNo;
  private List<SysDeptDto> children;
}

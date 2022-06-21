package top.werls.vben.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */
@TableName("vben_sys_user_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends BaseEntity {
    private static final long serialVersionUID = -898410089841008984L;
    private Long uid;
    private Long rid;
}

package top.werls.vben.system.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -898410089841008984L;
    private Long uid;
    private Long rid;
}

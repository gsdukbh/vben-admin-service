package top.werls.vben.system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */

@Setter
@Getter
@Entity
public class SysUserRole extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -898410089841008984L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Long uid;
    private Long rid;
}

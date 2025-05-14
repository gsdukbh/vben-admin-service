package top.werls.vben.system.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1123123L;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间", example = "2019-12-12 12:12:12")
    private Date createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间", example = "2019-12-12 12:12:12")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @PrePersist
    protected void onCreate() {
        this.createTime = new Date();
        this.updateTime = new Date(); //  通常创建时，更新时间也设为当前时间
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateTime = new Date();
    }

}

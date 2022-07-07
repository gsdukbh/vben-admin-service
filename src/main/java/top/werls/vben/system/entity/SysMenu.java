package top.werls.vben.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-07-01
 */
@Getter
@Setter
@TableName("vben_sys_menu")
@Schema(name = "SysMenu对象", description = "")
public class SysMenu extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @Schema(name = "导航路径")
    private String path;

    @Schema(name = "组件路径")
    private String component;
    @Schema(name = "重定向")
    private String redirect;

    private String title;

    private String icon;

    @Schema(description = "排序,越小越靠前")
    private Integer orderNo;

    @Schema(description = "启用")
    private Boolean status;

    @Schema(description = "类型")
    private Integer type;

    /**
     * 隐藏菜单
     */
    @Schema(description = "隐藏菜单")
    private Boolean hideMenu;

    @Schema(description = "父目录id")
    private Integer parentId;

    /**
     * 固定标签
     */
    @Schema(description = "固定标签")
    private Boolean affix;

    /**
     *如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true
     */
    @Schema(description = "如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true")
    private Boolean carryAram;

    /**
     * 内嵌iframe的地址
     */
    @Schema(description = "内嵌iframe的地址")
    private String frameSrc;

    /**
     * 当前路由不再标签页显示
     */
    @Schema(description = "当前路由不再标签页显示")
    private Boolean hideTab;
    /**
     * 隐藏该路由在面包屑上面的显示
     */
    @Schema(description = "隐藏该路由在面包屑上面的显示")
    private Boolean hideBreadcrumb;

    /**
     * 忽略keep alive 缓存
     */
    @Schema(description = "忽略keep alive 缓存")
    private Boolean ignoreKeepAlive;


}

package top.werls.vben.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.werls.vben.system.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiawei Lee
 * @version TODO
 * @date created 2022/7/4
 * @since on
 */
@Data
public class MenuVo {
    @Schema(name = "导航路径")
    private String path;
    private String name;
    @Schema(name = "组件路径")
    private String component;
    private String redirect;
    private Integer orderNo;
    private Boolean disabled;
    @Schema(description = "父目录id")
    private Integer parentId;
    private List<MenuVo> children;

    private Meta meta;
    public MenuVo(){}
    public MenuVo(SysMenu menu){
        this.path = menu.getPath();
        this.name =menu.getName();
        this.component = menu.getComponent();
        this.redirect = menu.getRedirect();
        this.orderNo = menu.getOrderNo();
        this.disabled =  menu.getStatus();
        this.parentId = menu.getParentId();
        this.children = new ArrayList<>();
        this.meta = new Meta(menu);
    }
    @Data
    static class Meta {
        private String title;
        private String icon;
        @Schema(description = "固定标签")
        private Boolean affix;
        @Schema(description = "忽略keep alive 缓存")
        private Boolean ignoreKeepAlive;
        @Schema(description = "内嵌iframe的地址")
        private String frameSrc;
        @Schema(description = "当前路由不再标签页显示")
        private Boolean hideTab;
        @Schema(description = "隐藏该路由在面包屑上面的显示")
        private Boolean hideBreadcrumb;
        @Schema(description = "如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true")
        private Boolean carryAram;
        @Schema(description = "隐藏菜单")
        private Boolean hideMenu;

        public Meta(){}
        public Meta(SysMenu menu) {
            this.title= menu.getTitle();
            this.icon = menu.getIcon();
            this.affix=menu.getAffix();
            this.ignoreKeepAlive= menu.getIgnoreKeepAlive();
            this.frameSrc= menu.getFrameSrc();
            this.hideTab =menu.getHideTab();
            this.hideBreadcrumb =menu.getHideBreadcrumb();
            this.carryAram =menu.getCarryAram();
            this.hideMenu =menu.getHideMenu();

        }
    }
}

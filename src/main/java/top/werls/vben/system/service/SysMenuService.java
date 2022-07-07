package top.werls.vben.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.werls.vben.system.entity.SysMenu;
import top.werls.vben.system.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-07-01
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取所有菜单
     * @return {@link List<MenuVo>} 菜单目录树
     */
    List<MenuVo> getMenuVoList();
}

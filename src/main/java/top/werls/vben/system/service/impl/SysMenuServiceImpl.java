package top.werls.vben.system.service.impl;

import org.springframework.stereotype.Service;
import top.werls.vben.system.repository.SysMenuRepository;
import top.werls.vben.system.service.SysMenuService;
import top.werls.vben.system.dto.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-07-01
 */
@Service
public class SysMenuServiceImpl  implements SysMenuService {


    private SysMenuRepository sysMenuRepository;

    public SysMenuServiceImpl(SysMenuRepository sysMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
    }

    /**
     * 获取所有菜单
     *
     * @return {@link List < MenuVo >} 菜单目录树
     */
    @Override
    public List<MenuVo> getMenuVoList() {
        return null;
    }
}

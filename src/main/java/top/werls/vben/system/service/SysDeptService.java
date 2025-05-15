package top.werls.vben.system.service;



import top.werls.vben.system.dto.DeptVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-06-30
 */
public interface SysDeptService  {
    /**
     * 获取部门目录
     *
     * @return {@link List<DeptVo>} 部门树目录
     */
    List<DeptVo> getListVo();

    /**
     * 获取此部门 下属目录
     * @param id 部门id
     * @return {@link List<DeptVo>} 部门树目录
     */
    List<DeptVo> getListVoById(Integer id);
}

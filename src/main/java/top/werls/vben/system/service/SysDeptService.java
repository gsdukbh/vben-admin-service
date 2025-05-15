package top.werls.vben.system.service;



import java.util.List;
import top.werls.vben.system.dto.DeptVo;
import top.werls.vben.system.dto.SysDeptDto;

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
     * @return {@link List< DeptVo >} 部门树目录
     */
    List<SysDeptDto> getListVo();

    /**
     * 获取此部门 下属目录
     * @param id 部门id
     * @return {@link List<SysDeptDto>} 部门树目录
     */
    List<SysDeptDto> getListVoById(Integer id);
}

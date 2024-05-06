package top.werls.vben.system.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.werls.vben.system.entity.SysRole;

import java.util.List;


/**
 * @author Jiawei Lee
 * @version TODO
 * @since on 2022/6/17
 */
@Mapper
public interface SysRoleMapper  {

  /**
   * 根据角色id获取角色
   *
   * @param rid 角色id
   * @return 角色
   */
  SysRole getByRid(@Param("rid") String rid);

  /**
   * 根据角色名获取角色
   *
   * @param name 角色名
   * @return 角色列表
   */
  List<SysRole> getByName(@Param("name") String name);
}

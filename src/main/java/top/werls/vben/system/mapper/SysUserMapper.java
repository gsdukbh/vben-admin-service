package top.werls.vben.system.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.werls.vben.system.entity.SysUser;


@Mapper
public interface SysUserMapper  {


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getByUsername(@Param("username") String username);
}

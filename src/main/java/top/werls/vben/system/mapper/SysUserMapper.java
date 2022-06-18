package top.werls.vben.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.werls.vben.system.entity.SysUser;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/16
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户
     *
     * @param uid
     * @return
     */
    SysUser getByUid(@Param("uid") String uid);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    SysUser getByUsername(@Param("username") String username);
}

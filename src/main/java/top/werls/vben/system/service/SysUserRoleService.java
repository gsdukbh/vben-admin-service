package top.werls.vben.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.entity.SysUserRole;

import java.util.List;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/18
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    /**
     * 通过 角色id 获取用户
     * @param rid 角色id
     * @return 用户列表
     */
    List<SysUser> getByRid(@Param("rid") Long rid);

    /**
     * 通过 用户id 获取角色
     * @param uid 用户id
     * @return 角色列表
     */
    List<SysRole> getByUid(@Param("uid") Long uid);
}

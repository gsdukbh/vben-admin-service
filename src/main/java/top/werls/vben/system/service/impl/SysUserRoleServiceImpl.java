package top.werls.vben.system.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;
import top.werls.vben.system.entity.SysUserRole;
import top.werls.vben.system.mapper.SysUserRoleMapper;
import top.werls.vben.system.service.SysUserRoleService;

import java.util.List;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/21
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    /**
     * 通过 角色id 获取用户
     *
     * @param rid 角色id
     * @return 用户列表
     */
    @Override
    public List<SysUser> getByRid(Long rid) {
        return null;
    }

    /**
     * 通过 用户id 获取角色
     *
     * @param uid 用户id
     * @return 角色列表
     */
    @Override
    public List<SysRole> getByUid(Long uid) {
        return null;
    }
}

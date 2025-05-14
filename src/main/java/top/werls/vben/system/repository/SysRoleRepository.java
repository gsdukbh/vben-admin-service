package top.werls.vben.system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.werls.vben.system.entity.SysRole;
import top.werls.vben.system.entity.SysUser;

/**
 * 角色
 *
 * @author JiaWei Lee
 * @version 1
 * @since on   14 5月 2025
 */
@Repository
public interface SysRoleRepository extends CrudRepository<SysRole, Integer> {

    SysRole findByName(String name);

    SysRole findByValue(String code);

    SysRole findByRid(Long rid);

    @Query("select r from SysRole r left  join  SysUserRole ur on r.rid = ur.rid where ur.uid = ?1")
    List<SysRole> findByUserId(Long userId);

    @Query("select u from SysUser u  left  join SysUserRole ur on u.uid =ur.uid where ur.rid = ?1")
    List<SysUser> findByRoleId(Integer rid);

}

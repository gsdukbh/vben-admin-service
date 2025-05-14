package top.werls.vben.system.repository;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.werls.vben.system.entity.SysUser;

/**
 * 用户，
 *
 * @author JiaWei Lee
 * @version 1
 * @since on   14 5月 2025
 */
@Repository
public interface UserRepository extends CrudRepository<SysUser, Integer> {

  SysUser findByUsername(String username);
}

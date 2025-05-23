package top.werls.vben.system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.werls.vben.system.entity.SysDept;

@Repository
public interface SysDeptRepository extends CrudRepository<SysDept, Integer> {


  List<SysDept> id(Integer id);
}

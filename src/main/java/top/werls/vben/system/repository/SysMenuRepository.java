package top.werls.vben.system.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import top.werls.vben.system.entity.SysMenu;

@Repository
public interface SysMenuRepository extends ListPagingAndSortingRepository<SysMenu, Integer> {

}
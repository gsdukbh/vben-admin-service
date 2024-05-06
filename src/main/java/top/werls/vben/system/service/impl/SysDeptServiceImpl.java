package top.werls.vben.system.service.impl;



import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import top.werls.vben.system.entity.SysDept;
import top.werls.vben.system.mapper.SysDeptMapper;
import top.werls.vben.system.service.SysDeptService;
import top.werls.vben.system.vo.DeptVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jiawei Lee
 * @since 2022-06-30
 */
@Service
public class SysDeptServiceImpl  implements SysDeptService {
    /**
     * 获取部门目录
     *
     * @return {@link List<DeptVo>} 部门树目录
     */
    @Override
    public List<DeptVo> getListVo() {
        // todo
    List<SysDept> list = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return null;
        }
        var result = new ArrayList<DeptVo>();
        list.forEach(dept -> {
            if (dept.getParentId() == 0) {
                DeptVo item = new DeptVo(dept);
                result.add(item);
                generateChildren(item, list);
            }
        });
        return result;
    }

    /**
     * 获取此部门 下属目录
     *
     * @param id 部门id
     * @return {@link List<DeptVo>} 部门树目录
     */
    @Override
    public List<DeptVo> getListVoById(Integer id) {
//        DeptVo item = new DeptVo(getById(id));
//        QueryWrapper<SysDept> query = new QueryWrapper<>();
//        generateChildren(item, list());
//        return item.getChildren();
        // todo
        return null;
    }

    /**
     * 生成 子部门
     *
     * @param dept 当前部门
     * @param list 所有的部门信息
     */
    private void generateChildren(DeptVo dept,  List<SysDept> list) {
        list.forEach(i -> {
            if (Objects.equals(dept.getId(), i.getParentId())) {
                DeptVo item = new DeptVo(i);
                dept.getChildren().add(item);
                generateChildren(item, list);
            }
        });
    }
}

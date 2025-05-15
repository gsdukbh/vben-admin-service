package top.werls.vben.system.service.impl;

import org.springframework.stereotype.Service;
import top.werls.vben.system.dto.DeptVo;
import top.werls.vben.system.dto.SysDeptDto;
import top.werls.vben.system.entity.SysDept;
import top.werls.vben.system.repository.SysDeptRepository;
import top.werls.vben.system.service.SysDeptService;
import top.werls.vben.system.mapper.SysDeptMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 服务实现类
 *
 * @author Jiawei Lee
 * @since 2022-06-30
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

  private final SysDeptRepository sysDeptRepository;
  private SysDeptMapper sysDeptMapper;

  public SysDeptServiceImpl(SysDeptRepository sysDeptRepository, SysDeptMapper sysDeptMapper) {
    this.sysDeptRepository = sysDeptRepository;
    this.sysDeptMapper = sysDeptMapper;
  }

  /**
   * 获取部门目录
   *
   * @return {@link SysDeptDto>} 部门树目录
   */
  @Override
  public List<SysDeptDto> getListVo() {
    // todo
    List<SysDept> list = (List<SysDept>) sysDeptRepository.findAll();
    return getSysDeptDtoTree(list);
  }

  /**
   * 获取此部门 下属目录
   *
   * @param id 部门id
   * @return {@link List< SysDeptDto >} 部门树目录
   */
  @Override
  public List<SysDeptDto> getListVoById(Integer id) {
    List<SysDept> list = (List<SysDept>) sysDeptRepository.findAllById(List.of(id));
    return getSysDeptDtoTree(list);
  }

  private List<SysDeptDto> getSysDeptDtoTree(List<SysDept> list) {
    if (list.isEmpty()) {
      return new ArrayList<>();
    }
    var result = new ArrayList<SysDeptDto>();
    list.forEach(
        dept -> {
          if (dept.getParentId() == 0) {
            SysDeptDto item = sysDeptMapper.toDto(dept);
            result.add(item);
            generateChildren(item, list);
          }
        });
    return result;
  }

  /**
   * 生成 子部门
   *
   * @param dept 当前部门
   * @param list 所有的部门信息
   */
  private void generateChildren(SysDeptDto dept, List<SysDept> list) {
    list.forEach(
        i -> {
          if (Objects.equals(dept.getId(), i.getParentId())) {
            SysDeptDto item = sysDeptMapper.toDto(i);
            dept.getChildren().add(item);
            generateChildren(item, list);
          }
        });
  }
}

package top.werls.vben.system.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import top.werls.vben.system.entity.SysDept;
import top.werls.vben.system.dto.SysDeptDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface SysDeptMapper {


  SysDept toEntity(SysDeptDto sysDeptDto);

  SysDeptDto toDto(SysDept sysDept);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  SysDept partialUpdate(SysDeptDto sysDeptDto, @MappingTarget SysDept sysDept);
}

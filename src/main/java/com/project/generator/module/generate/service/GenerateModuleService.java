package com.project.generator.module.generate.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.project.generator.module.generate.entity.GenerateModule;
import com.project.generator.module.generate.pojo.GenerateModuleDTO;
import com.project.generator.module.generate.pojo.GenerateModuleQO;
import com.project.generator.module.generate.pojo.GenerateModuleVO;

public interface GenerateModuleService extends IService<GenerateModule> {

	GenerateModuleVO getVOById(Long id);

	List<GenerateModuleVO> getVOList(GenerateModuleQO qo);

	Page<GenerateModuleVO> getVOPage(GenerateModuleQO qo);

	GenerateModule create(GenerateModuleDTO dto);

	GenerateModule update(Long id, GenerateModuleDTO dto);

}

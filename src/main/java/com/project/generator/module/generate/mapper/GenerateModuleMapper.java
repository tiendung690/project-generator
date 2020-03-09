package com.project.generator.module.generate.mapper;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.project.generator.module.generate.entity.GenerateModule;
import com.project.generator.module.generate.pojo.GenerateModuleQO;
import com.project.generator.module.generate.pojo.GenerateModuleVO;
import com.project.generator.mybatis.mapper.SuperMapper;

public interface GenerateModuleMapper extends SuperMapper<GenerateModule> {

	List<GenerateModuleVO> getVOList(GenerateModuleQO qo);

	List<GenerateModuleVO> getVOList(Page page, GenerateModuleQO qo);

}

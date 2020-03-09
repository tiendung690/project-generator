package com.project.generator.module.generate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.project.generator.module.generate.entity.GenerateModule;
import com.project.generator.module.generate.mapper.GenerateModuleMapper;
import com.project.generator.module.generate.pojo.GenerateModuleDTO;
import com.project.generator.module.generate.pojo.GenerateModuleQO;
import com.project.generator.module.generate.pojo.GenerateModuleVO;
import com.project.generator.module.generate.service.GenerateModuleService;
import com.project.generator.mybatis.entity.SuperEntity;
import com.project.generator.mybatis.service.SuperService;

import ma.glasnost.orika.MapperFacade;

@Service
public class GenerateModuleServiceImpl extends SuperService<GenerateModuleMapper, GenerateModule>
		implements GenerateModuleService {

	@Autowired
	private MapperFacade mapper;

	@Override
	public GenerateModuleVO getVOById(Long id) {
		GenerateModule obj = selectById(id);
		return convertToVO(obj);
	}

	@Override
	public List<GenerateModuleVO> getVOList(GenerateModuleQO qo) {
//        return selectList(new EntityWrapper<>()).stream().map(this::convertToVO).collect(Collectors.toList());
		return baseMapper.getVOList(qo);
	}

	@Override
	public Page<GenerateModuleVO> getVOPage(GenerateModuleQO qo) {
		Page<GenerateModuleVO> pages = qo.getPage();
		pages.setRecords(baseMapper.getVOList(pages, qo));
		return pages;
	}

	@Override
	public GenerateModule create(GenerateModuleDTO dto) {
		GenerateModule obj = mapper.map(dto, GenerateModule.class);
		obj.setCreateDate(new Date());
		obj.setUpdateDate(new Date());
		insert(obj);
		return obj;
	}

	@Override
	public GenerateModule update(Long id, GenerateModuleDTO dto) {
		GenerateModule obj = selectById(id);
		mapper.map(dto, obj);
		obj.setDeleteFlag(SuperEntity.DEL_FLAG_NORMAL);
		obj.setUpdateDate(new Date());
		updateById(obj);
		return obj;
	}

	private GenerateModuleVO convertToVO(GenerateModule obj) {
		GenerateModuleVO vo = mapper.map(obj, GenerateModuleVO.class);
		return vo;
	}

}

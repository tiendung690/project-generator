package com.project.generator.module.generate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.project.generator.MpGenerator;
import com.project.generator.module.generate.pojo.GenerateModuleDTO;
import com.project.generator.module.generate.pojo.GenerateModuleQO;
import com.project.generator.module.generate.pojo.GenerateModuleVO;
import com.project.generator.module.generate.service.GenerateModuleService;

@RestController
@RequestMapping("/service/generate/module")
public class GenerateModuleController {

	@Autowired
	private GenerateModuleService baseService;

	@GetMapping("/list")
	public List<GenerateModuleVO> getVOList(GenerateModuleQO qo) {
		return baseService.getVOList(qo);
	}

	@GetMapping("/page")
	public Page<GenerateModuleVO> getVOPage(GenerateModuleQO qo) {
		return baseService.getVOPage(qo);
	}

	@PostMapping("/create")
	public void create(@RequestBody GenerateModuleDTO dto) {
		try {
			baseService.create(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable Long id, @RequestBody GenerateModuleDTO dto) {
		baseService.update(id, dto);
	}

	@DeleteMapping("/delete/{id}")
	public void update(@PathVariable Long id) {
		baseService.deleteById(id);
	}

	@GetMapping("/{id}")
	public GenerateModuleVO getById(@PathVariable Long id) {
		return baseService.getVOById(id);
	}

	@PostMapping("/{id}/execute")
	public void execute(@PathVariable Long id) {
		GenerateModuleVO vo = baseService.getVOById(id);
		new MpGenerator().generate(vo);
	}

}

package com.project.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.project.generator.module.generate.pojo.GenerateModuleVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MpGenerator {

	private static final ResourceBundle generator = ResourceBundle.getBundle("generate");

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("actor");
		list.add("address");
		for (int i = 0; i < list.size(); i++) {
			GenerateModuleVO generateModuleVO = new GenerateModuleVO();
			generateModuleVO.setTbNames(list.get(i));
			generateModuleVO.setTbPrefix(generator.getString("TB_PREFIX"));
			generateModuleVO.setTbPackage(generator.getString("PACKAGE"));
			generateModuleVO.setTbModule(generator.getString("MODULE"));
			generateModuleVO.setAuthor(generator.getString("AUTHOR"));
			generateModuleVO.setFileOverride(1);

			generate(generateModuleVO, generator);
		}
	}

	public static void generate(GenerateModuleVO generateModuleVO) {
		generate(generateModuleVO, generator);
	}

	public static void generate(GenerateModuleVO generateModuleVO, ResourceBundle generator) {
		final String JAVA_FILE_OUTPUT = generator.getString("JAVA_FILE_OUTPUT");
		final String MAPPER_FILE_OUTPUT = generator.getString("MAPPER_FILE_OUTPUT");

		// pojo path
		String packagePojo = generateModuleVO.getTbPackage() + "." + generateModuleVO.getTbModule() + ".pojo";
		String POJO_FILE_OUTPUT = JAVA_FILE_OUTPUT + "/" + packagePojo.replace(".", "/") + "/";

		AutoGenerator mpg = new AutoGenerator();

		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(JAVA_FILE_OUTPUT);
		gc.setFileOverride(generateModuleVO.getFileOverride() == 1);
		gc.setActiveRecord(false);
		gc.setEnableCache(false);
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);
		gc.setAuthor(generateModuleVO.getAuthor());
		gc.setServiceName("%sService");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);

		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setUrl(generator.getString("DB_URL"));
		dataSourceConfig.setDriverName(generator.getString("DB_DRIVER"));
		dataSourceConfig.setUsername(generator.getString("DB_USERNAME"));
		dataSourceConfig.setPassword(generator.getString("DB_PASSWORD"));
		dataSourceConfig.setDbType(DbType.MYSQL);
		dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);
				return super.processTypeConvert(fieldType);
			}
		});
		mpg.setDataSource(dataSourceConfig);

		StrategyConfig strategy = new StrategyConfig();
		strategy.setCapitalMode(true);
		strategy.setTablePrefix(generateModuleVO.getTbPrefix());
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setInclude(generateModuleVO.getTbNames().split(","));
		strategy.setSuperEntityClass("SuperEntity");
		strategy.setSuperEntityColumns(new String[] { "DELETED" });
		strategy.setSuperMapperClass("SuperMapper");
		strategy.setSuperControllerClass("SuperController");
		mpg.setStrategy(strategy);

		PackageConfig pc = new PackageConfig();
		pc.setParent(generateModuleVO.getTbPackage());
		pc.setModuleName(generateModuleVO.getTbModule());
		pc.setController("controller");
		mpg.setPackageInfo(pc);

		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("packagePojo", packagePojo);
				map.put("superDTO", "SuperDTO");
				map.put("superVO", "SuperVO");
				map.put("superQO", "SuperQO");
				this.setMap(map);
			}
		};

		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/code_template/entity.dto.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "DTO.java";
			}
		});
		focList.add(new FileOutConfig("/code_template/entity.vo.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "VO.java";
			}
		});
		focList.add(new FileOutConfig("/code_template/entity.qo.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "QO.java";
			}
		});

		focList.add(new FileOutConfig("/code_template/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return MAPPER_FILE_OUTPUT + "/" + tableInfo.getEntityName() + "Mapper.xml";
			}
		});

		cfg.setFileOutConfigList(focList);

		mpg.setCfg(cfg);

		TemplateConfig tc = new TemplateConfig();
		tc.setController("/code_template/controller.java.vm");
		tc.setService("/code_template/service.java.vm");
		tc.setServiceImpl("/code_template/serviceImpl.java.vm");
		tc.setEntity("/code_template/entity.java.vm");
		tc.setMapper("/code_template/mapper.java.vm");
		tc.setXml(null);
		mpg.setTemplate(tc);

		mpg.execute();
	}

}
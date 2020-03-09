package com.project.generator.module.generate.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.project.generator.mybatis.entity.SuperEntity;

@TableName("tb_project_module")
public class GenerateModule extends SuperEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.ID_WORKER)
	private Long id;
	@TableField("tb_module")
	private String tbModule;
	@TableField("tb_names")
	private String tbNames;
	@TableField("file_override")
	private Integer fileOverride;
	@TableField("tb_prefix")
	private String tbPrefix;
	@TableField("create_date")
	private Date createDate;
	@TableField("update_date")
	private Date updateDate;
	private String author;
	@TableField("tb_package")
	private String tbPackage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTbModule() {
		return tbModule;
	}

	public void setTbModule(String tbModule) {
		this.tbModule = tbModule;
	}

	public String getTbNames() {
		return tbNames;
	}

	public void setTbNames(String tbNames) {
		this.tbNames = tbNames;
	}

	public Integer getFileOverride() {
		return fileOverride;
	}

	public void setFileOverride(Integer fileOverride) {
		this.fileOverride = fileOverride;
	}

	public String getTbPrefix() {
		return tbPrefix;
	}

	public void setTbPrefix(String tbPrefix) {
		this.tbPrefix = tbPrefix;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTbPackage() {
		return tbPackage;
	}

	public void setTbPackage(String tbPackage) {
		this.tbPackage = tbPackage;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "GenerateModule{" + ", id=" + id + ", tbModule=" + tbModule + ", tbNames=" + tbNames + ", fileOverride="
				+ fileOverride + ", tbPrefix=" + tbPrefix + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", author=" + author + ", tbPackage=" + tbPackage + "}";
	}
}

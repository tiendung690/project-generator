package com.project.generator.module.generate.pojo;

import java.io.Serializable;
import java.util.Date;

public class GenerateModuleVO implements Serializable {

	private static final long serialVersionUID = -8091525120610872178L;

	private Long id;
	private String tbModule;
	private String tbNames;
	private Integer fileOverride;
	private String tbPrefix;
	private Date createDate;
	private Date updateDate;
	private String author;
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
	public String toString() {
		return "GenerateModule{" + ", id=" + id + ", tbModule=" + tbModule + ", tbNames=" + tbNames + ", fileOverride="
				+ fileOverride + ", tbPrefix=" + tbPrefix + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", author=" + author + ", tbPackage=" + tbPackage + "}";
	}

}

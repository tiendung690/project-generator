package com.project.generator.mybatis.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;

@SuppressWarnings("rawtypes")
public abstract class SuperEntity<T extends Model> extends Model<T> {

	private static final long serialVersionUID = 1L;
	public static final Integer DEL_FLAG_NORMAL = 0;
	public static final Integer DEL_FLAG_DELETE = 1;
	public static final Integer DEL_FLAG_AUDIT = 2;
	public static final Long NULL_OBJECT_LONG_PK = 0L;
	@TableLogic
	@TableField(value = "delete_flag")
	private Integer deleteFlag = DEL_FLAG_NORMAL;

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}

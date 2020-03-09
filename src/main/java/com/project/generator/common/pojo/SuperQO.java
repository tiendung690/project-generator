package com.project.generator.common.pojo;

import java.io.Serializable;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.project.generator.common.util.MapUtils;

public class SuperQO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer current = 1;
	private Integer size = 10;

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Map<String, Object> toMap() {
		try {
			return MapUtils.objectToMap(this);
		} catch (Exception e) {
			return null;
		}
	}

	public Page getPage() {
		return new Page(current, size);
	}

	public Map<String, Object> getCondition() {
		try {
			return MapUtils.objectToMap(this, "current", "size");
		} catch (Exception e) {
			return null;
		}

	}
}

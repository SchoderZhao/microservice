package com.msunsoft.spt.server.hncollection.utils;

import java.io.Serializable;

/**
 * @author 作者 xucl
 * @version 创建时间：2015年11月10日 下午2:14:29 封装返回JSON格式数据
 */
public class JsonMsunModel<T> implements Serializable {

	private static final long serialVersionUID = -692492052222268168L;

	// 结果数据
	private T data;

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int status;

	public T getdata() {
		return data;
	}

	public void setdata(T data) {
		this.data = data;
	}

	public JsonMsunModel(T updateRowNums, int count, int status) {
		this.data = updateRowNums;
		this.count = count;
		this.status = status;
	}

}

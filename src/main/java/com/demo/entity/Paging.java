/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.entity;

/**
 * 分页
 * 
 * @author Mosaico
 */
public class Paging {

	private int page = 1; // 页码
	private int limit = 15; // 条数
	private int start = 0; // 起始条数

	public Paging() {
		calculateStart();
	}

	public Paging(int page, int limit) {
		this.page = page;
		this.limit = limit;
		calculateStart();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			return;
		}
		this.page = page;
		calculateStart();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit <= 0) {
			return;
		}
		this.limit = limit;
		calculateStart();
	}

	public int getStart() {
		return start;
	}

	private void calculateStart() {
		start = (page - 1) * limit;
	}

}

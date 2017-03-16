/**
 * *****************************************************
 * Copyright (C) Kongtrolink techology Co.ltd - All Rights Reserved
 *
 * This file is part of Kongtrolink techology Co.Ltd property.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************
 */
package com.demo.common;

/**
 * 前端显示冗余
 * @author Mosaico
 */
public class FacadeView {
    
    private String strId;
    private String name;

    public FacadeView() {
    }

    public FacadeView(String strId, String name) {
	this.strId = strId;
	this.name = name;
    }

    public String getStrId() {
	return strId;
    }

    public void setStrId(String strId) {
	this.strId = strId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

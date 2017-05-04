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
package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.demo.common.FacadeView;
import com.demo.util.DateUtil;

/**
 *
 * @author Mosaico
 */
public class Alarm implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4839953781820463795L;
	private String _id;
    private String state;	    // 实时性状态
    private String value;
    private String level;
    private String details;
    private Date tReport;
    private Date tRecover;
    private FacadeView signal;
    private FacadeView device;
    private FacadeView site;
    private String tierCode;
    private TierInfo[] siteTier;
    private int serialNo;
    
    private Date tCheck;	    // 确认时间
    private FacadeView checkOperator;   // 确认操作人
    private Date tClear;	    // 清除时间
    private FacadeView clearOperator;	// 清除操作人
    private Boolean shield;	    // 是否被屏蔽

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }


	public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

   
    public Date gettReport() {
		return tReport;
	}

	public void settReport(Date tReport) {
		this.tReport = tReport;
	}

	public void settRecord(String tRecord) {
	this.tReport = DateUtil.getInstance().parse(tRecord);
    }

    public Date gettRecover() {
	return tRecover;
    }

    public void settRecover(Date tRecover) {
	this.tRecover = tRecover;
    }
    
    public void settRecover(String tRecover) {
	this.tRecover = DateUtil.getInstance().parse(tRecover);
    }
    
    public FacadeView getSignal() {
        return signal;
    }

    public void setSignal(FacadeView signal) {
        this.signal = signal;
    }

    public FacadeView getDevice() {
        return device;
    }

    public void setDevice(FacadeView device) {
        this.device = device;
    }

    public FacadeView getSite() {
        return site;
    }

    public void setSite(FacadeView site) {
        this.site = site;
    }

    public String getTierCode() {
        return tierCode;
    }

    public void setTierCode(String tierCode) {
        this.tierCode = tierCode;
    }

    public TierInfo[] getSiteTier() {
        return siteTier;
    }

    public void setSiteTier(TierInfo[] siteTier) {
        this.siteTier = siteTier;
    }

    public String getSiteTierString() {
        if (siteTier == null) {
            return null;
        }
        
        String strSiteTier = "";
        TierInfo tempTierInfo;
        for (int i = 0; i < siteTier.length; i ++) {
            tempTierInfo = siteTier[i];
            strSiteTier += tempTierInfo.getName();
            if (i == siteTier.length - 1) {
                break;
            }
            strSiteTier += "-";
        }
        return strSiteTier;
    }

    public int getSerialNo() {
	return serialNo;
    }

    public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
    }

    public Date gettCheck() {
	return tCheck;
    }

    public void settCheck(Date tCheck) {
	this.tCheck = tCheck;
    }

    public FacadeView getCheckOperator() {
	return checkOperator;
    }

    public void setCheckOperator(FacadeView checkOperator) {
	this.checkOperator = checkOperator;
    }

    public Date gettClear() {
	return tClear;
    }

    public void settClear(Date tClear) {
	this.tClear = tClear;
    }

    public FacadeView getClearOperator() {
	return clearOperator;
    }

    public void setClearOperator(FacadeView clearOperator) {
	this.clearOperator = clearOperator;
    }

    public Boolean isShield() {
	return shield == null ? false : shield;
    }

    public void setShield(Boolean shield) {
	this.shield = shield;
    }

    @Override
    public String toString() {
	return "Alarm{" + "_id=" + _id + ", state=" + state + ", value=" + value + ", level=" + level + ", details=" + details + ", tReport=" + tReport + ", tRecover=" + tRecover + ", signal=" + signal + ", device=" + device + ", site=" + site + ", tierCode=" + tierCode + ", siteTier=" + siteTier + ", tCheck=" + tCheck + ", checkOperator=" + checkOperator + ", tClear=" + tClear + ", clearOperator=" + clearOperator + ", shield=" + shield + '}';
    }

}

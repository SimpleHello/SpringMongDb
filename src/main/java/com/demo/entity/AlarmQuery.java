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

import java.util.List;


/**
 *
 * @author Mosaico
 */
public class AlarmQuery extends Paging {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7617931135400136496L;
	
	private List<String> siteIds;
    private String alarmName;
    private String alarmLevel;
    private String alarmState;
    private String deviceName;
    private Long tStart;
    private Long tEnd;

    public List<String> getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(List<String> siteIds) {
        this.siteIds = siteIds;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long gettStart() {
        return tStart;
    }

    public void settStart(Long tStart) {
        this.tStart = tStart;
    }

    public Long gettEnd() {
        return tEnd;
    }

    public void settEnd(Long tEnd) {
        this.tEnd = tEnd;
    }

}

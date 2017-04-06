package com.demo.entity;

import java.util.Date;

/**
 * 定时任务 保存
 * 
 * @author John
 *
 */
public class JobEntity {
	
	public static final String namespace = "quartz_job_detail";
	
	
	private String id;// 主键ID
	private String jobDescript;//任务描述
	private String jobName;// 任务名
	private String jobGroupName; // 任务组名  --给与默认
	private String triggerName; // 触发器名 --给与默认
	private String triggerGroupName; // 触发器组名 --给与默认
	private String jobClass; // 任务 类
	private String cron;// 时间设置，参考quartz说明文档
	private Date lastTime;// 最新一次执行时间
	private Date firstTime;// 第一次执行时间
	private String status;// 运行状态 停止 / 启动

	public JobEntity(String jobName,String jobDescript, String cron) {
		this.jobDescript= jobDescript;
		this.jobName = jobName;
		this.jobGroupName = jobName+"Group";
		this.triggerName = jobName+"Trigger";
		this.triggerGroupName = jobName+"TriggerGroup";
		this.jobClass = "quertz.demo.test."+jobName;
		this.cron = cron;
		this.lastTime= new Date();
		this.status = "启动";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobDescript() {
		return jobDescript;
	}

	public void setJobDescript(String jobDescript) {
		this.jobDescript = jobDescript;
	}
	
}

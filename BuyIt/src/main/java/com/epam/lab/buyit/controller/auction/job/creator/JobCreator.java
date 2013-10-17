package com.epam.lab.buyit.controller.auction.job.creator;

import org.quartz.JobDetail;
import org.quartz.Scheduler;

public abstract class JobCreator {
	protected String groupName = Scheduler.DEFAULT_GROUP;
	protected String jobName = "Job";
	
	public abstract JobDetail create();
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}

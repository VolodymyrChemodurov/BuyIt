package com.epam.lab.buyit.controller.auction.job.creator;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import com.epam.lab.buyit.controller.auction.job.ServeAuctionJob;

public class ServeAuctionJobCreator extends JobCreator{
	private static int jobId = 0;
	
	{
		this.jobName = "Serve Auction Job";
	}
	
	public ServeAuctionJobCreator() {}
	
	public ServeAuctionJobCreator(String groupName) {
		this.groupName = groupName;
	}
	
	public ServeAuctionJobCreator(String jobName, String groupName) {
		this.groupName = groupName;
		this.jobName = jobName;
	}
	
	@Override
	public JobDetail create() {
		JobDetail job = JobBuilder.newJob(ServeAuctionJob.class)
				.withIdentity(jobName + jobId, groupName)
				.build();
		nextId();
		return job;
	}

	private void nextId() {
		if(Integer.MAX_VALUE < jobId + 1)
			jobId = 0;
		else jobId++;
	}
}

package com.epam.lab.buyit.controller.auction.job.creator;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import com.epam.lab.buyit.controller.auction.job.FindSoonEndingAuctionsJob;

public class FindSoonEndingAuctionsJobCreator extends JobCreator {
	private static int jobId = 0;

	{
		this.jobName = "Find Soon Ending Auctions Job";
	}

	public FindSoonEndingAuctionsJobCreator() {
	}

	public FindSoonEndingAuctionsJobCreator(String groupName) {
		this.groupName = groupName;
	}

	public FindSoonEndingAuctionsJobCreator(String jobName, String groupName) {
		this.groupName = groupName;
		this.jobName = jobName;
	}

	@Override
	public JobDetail create() {
		JobDetail job = JobBuilder.newJob(FindSoonEndingAuctionsJob.class)
				.withIdentity(jobName + jobId, groupName).build();
		nextId();
		return job;
	}

	private void nextId() {
		if (Integer.MAX_VALUE < jobId + 1)
			jobId = 0;
		else
			jobId++;
	}

}

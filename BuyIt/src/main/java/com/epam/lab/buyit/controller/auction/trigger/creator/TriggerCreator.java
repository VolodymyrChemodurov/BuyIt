package com.epam.lab.buyit.controller.auction.trigger.creator;

import org.quartz.Scheduler;
import org.quartz.Trigger;

public abstract class TriggerCreator {
	protected String groupName = Scheduler.DEFAULT_GROUP;
	protected String triggerName = "Trigger";
	
	public abstract Trigger create(long time);
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	
	protected int nextId(int id) {
		if(Integer.MAX_VALUE < id + 1)
			id = 0;
		else id++;
		return id;
	}
}

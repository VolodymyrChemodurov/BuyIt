package com.epam.lab.buyit.controller.auction.trigger.creator;

import java.util.Date;

import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class DisposableTriggerCreator extends TriggerCreator {
	private static int triggerId = 0;

	{
		this.triggerName =  "Disposable Trigger";
	}

	public DisposableTriggerCreator() {
	};

	public DisposableTriggerCreator(String groupName) {
		this.groupName = groupName;
	};

	public DisposableTriggerCreator(String triggerName, String groupName) {
		this.groupName = groupName;
		this.triggerName = triggerName;
	}

	@Override
	public Trigger create(long date) {
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(triggerName + triggerId, groupName).startAt(new Date(date))
				.build();
		triggerId = nextId(triggerId);
		return trigger;
	}
	
	public String getNextId() {
		return triggerName + nextId(triggerId);
	}

}

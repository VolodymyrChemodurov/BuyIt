package com.epam.lab.buyit.controller.auction.trigger.creator;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class PeriodicalTriggerCreator extends TriggerCreator {
	private static int triggerId = 0;
	
	{
		this.triggerName = "Periodical Trigger";
	}
	
	public PeriodicalTriggerCreator() {
	};
	
	public PeriodicalTriggerCreator(String groupName) {
		this.groupName = groupName;
	};
	
	public PeriodicalTriggerCreator(String triggerName, String groupName) {
		this.groupName = groupName;
		this.triggerName = triggerName;
	}
	
	@Override
	public Trigger create(long period) {
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(triggerName + triggerId, groupName)
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInMinutes((int)period)
						.repeatForever())
				.build();
		triggerId = nextId(triggerId);
		return trigger;
	}
	
	public String getNextId() {
		return triggerName + nextId(triggerId);
	}
}

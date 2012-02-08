package pt.ist.socialframework.domain;

import org.joda.time.DateTime;

public class EffectivePeriod extends EffectivePeriod_Base {
	
	public void init(DateTime startTime) {
		setStartTime(startTime);
	}
	
	public void terminate(DateTime endTime) {
		setEndTime(endTime);
	}
}
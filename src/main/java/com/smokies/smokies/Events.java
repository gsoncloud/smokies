package com.smokies.smokies;

public class Events {

	private Event[] event;

	public Event[] getEvent() {
		return event;
	}

	public void setEvent(Event[] event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "ClassPojo [event = " + event + "]";
	}
}

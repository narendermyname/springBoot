package com.naren.rest.model.websocket;

import java.util.Date;

public class Message {

    private String from;
    
    private Destination dest;
    
    private String message;
    
    private String topic;
    
    private Date time;

    public Message() {
    }

    public Message(String from, String message) {
    	this.from = from;
        this.message = message;
    }

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the dest
	 */
	public Destination getDest() {
		return dest;
	}

	/**
	 * @param dest the dest to set
	 */
	public void setDest(Destination dest) {
		this.dest = dest;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [from=" + from + ", dest=" + dest + ", message=" + message + ", topic=" + topic + ", time="
				+ time + "]";
	}

}

enum Destination{
	TO, ALL
}

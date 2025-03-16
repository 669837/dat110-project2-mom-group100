package no.hvl.dat110.messages;

import no.hvl.dat110.common.TODO;

public class PublishMsg extends Message {
	
	// message sent from client to create publish a message on a topic

	// Implement object variables - a topic and a message is required
	private String topic;
	private String message;

	/**
	 * constructs a new PublishMsg
	 * @param user	  user publishing the message
	 * @param topic	  topic of the message
	 * @param message message to be published
	 */
	public PublishMsg(String user, String topic, String message) {
		super(user, MessageType.PUBLISH);
		this.topic = topic;
		this.message = message;
	}

	// TODO:
	// Complete the constructor, get/set-methods, and toString method
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 *
	 * @return	returns a string representation of PublishMsg
	 */
	@Override
	public String toString() {
		return "PublishMsg [user=" + getUser() + ", topic=" + topic + ", message=" + message + "]";
	}
	// as described in the project text
}

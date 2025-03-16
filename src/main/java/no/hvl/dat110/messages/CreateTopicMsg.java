package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	// message sent from client to create topic on the broker
    // Implement object variables - a topic is required
    //topic
    private String topic;

    /**
     * constructs a new CreateTopicMsg with the specified user and topic
     * @param user  the client identifier sending the request
     * @param topic the topic name to be created
     */
    public CreateTopicMsg(String user, String topic) {
        super(user, MessageType.CREATETOPIC);
        this.topic = topic;
    }

	// TODO:
	
	// Complete the constructor, get/set-methods, and toString method
    // as described in the project text

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     *
     * @return  Returns a string representation of the CreateTopicMsg
     */
    @Override
    public String toString() {
        return "CreateTopicMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
}

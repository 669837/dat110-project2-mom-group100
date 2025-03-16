package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker

    // Implement object variables - a topic is required
    //topic
    private String topic;

    /**
     * constructs a bew DeleteTopicMsg
     * @param user  the user sending the request
     * @param topic the topic to be deleted
     */
    public DeleteTopicMsg(String user, String topic) {
        super(user, MessageType.DELETETOPIC);
        this.topic = topic;
    }

	// TODO:
	// Complete the constructor, get/set-methods, and toString method
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     *
     * @return  Returns a string representation of the DeleteTopicMsg
     */
    @Override
    public String toString() {
        return "DeleteTopicMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
	// as described in the project text

}

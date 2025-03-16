package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic

    // Implement object variables - a topic is required
    private String topic;

    /**
     * constructes a new UnsubscribeMsg
     * @param user
     * @param topic
     */
    public UnsubscribeMsg(String user, String topic) {
        super(user, MessageType.UNSUBSCRIBE);
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
     * @return  returns a string representation of UnsubscribeMsg
     */
    @Override
    public String toString() {
        return "UnsubscribeMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
	// as described in the project text
	
}

package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic

    // Implement object variables - a topic is required
    private String topic;

    /**
     * contructs a new SubscribeMsg
     * @param user  user to subscribe
     * @param topic topic to subscribe to
     */
    public SubscribeMsg(String user, String topic) {
        super(user, MessageType.SUBSCRIBE);
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
     * @return  returns a string representation of SubscribeMsg
     */
    @Override
    public String toString() {
        return "SubscribeMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
	// as described in the project text
		
}

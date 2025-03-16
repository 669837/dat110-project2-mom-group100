package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<>();
		clients = new ConcurrentHashMap<>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {
		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {
		return clients.get(user);
	}

	public Set<String> getSubscribers(String topic) {
		return subscriptions.get(topic);

	}

	public void addClientSession(String user, Connection connection) {
		// TODO: add corresponding client session to the storage
		// See ClientSession class
		ClientSession session = new ClientSession(user, connection);
		clients.put(user, session);
		Logger.log("Client session added for user: " + user);
		
	}

	public void removeClientSession(String user) {
		// TODO: disconnet the client (user) 
		// and remove client session for user from the storage
		ClientSession session = clients.remove(user);
		if (session != null) {
			session.disconnect();
			Logger.log("Client session removed for user: " + user);
		}
		for (Set<String> subscribers : subscriptions.values()) {
			subscribers.remove(user);
		}
		
	}

	public void createTopic(String topic) {
		// TODO: create topic in the storage
		subscriptions.putIfAbsent(topic, ConcurrentHashMap.newKeySet());
		Logger.log("Topic created: " + topic);
		Logger.log("Current topics: " + subscriptions.keySet());
	}

	public void deleteTopic(String topic) {
		// TODO: delete topic from the storage
		subscriptions.remove(topic);
		Logger.log("Topic deleted: " + topic);
		Logger.log("Current topics: " + subscriptions.keySet());
	}

	public void addSubscriber(String user, String topic) {
		// TODO: add the user as subscriber to the topic
		subscriptions.putIfAbsent(topic, ConcurrentHashMap.newKeySet());
		Set<String> subscribers = subscriptions.get(topic);
		subscribers.add(user);
		Logger.log("User " + user + " subscribed to topic " + topic);
		Logger.log("Subscribers for " + topic + ": " + subscribers);
	}

	public void removeSubscriber(String user, String topic) {
		// TODO: remove the user as subscriber to the topic
		Set<String> subscribers = subscriptions.get(topic);
		if (subscribers != null) {
			subscribers.remove(user);
		}
		Logger.log("User " + user + " unsubscribed to topic " + topic);
		Logger.log("Subscribers for " + topic + ": " + subscribers);
	}
}

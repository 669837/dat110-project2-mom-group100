package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sensor = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		// - connect to the broker - user "sensor" as the user name
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();

		// - publish the temperature(s)
		for (int i = 0; i < COUNT; i++) {
			int temp = sensor.read();
			System.out.println("READING: " + temp);
			client.publish(Common.TEMPTOPIC, String.valueOf(temp));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// - disconnect from the broker
		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}

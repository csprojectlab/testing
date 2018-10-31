package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] send = new byte[1024];
		byte[] receive = new byte[1024];
		String message = "This is the message from the client.";
		send = message.getBytes();
		DatagramPacket sendPacket = new DatagramPacket (send, send.length, IPAddress, 8000);
		System.out.println("Sending the message to the server.");
		socket.send(sendPacket);
		//------------------------------------------------------------
		// Receiving the message from the client.
		DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
		socket.receive(receivePacket);
		message = receivePacket.getData().toString();
		System.out.println("Client receiving message from the server: " + message);
		//  HElow this is just for the testing purpose.
		// These changes are from some another computer.
		// Again  aaa
		// Check the pull request casse.
	}
}

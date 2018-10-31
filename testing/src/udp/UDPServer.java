package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer extends Thread {

	public void run() {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(8000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] receive = new byte[1024];
		byte[] send = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
			try {
				socket.receive(receivePacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String data = new String(receivePacket.getData());
			System.out.println("Received Data from client: " + data);
			// --------------------------------------------------
			// Sending the data back.
			String sendData = "This is hello from the server";
			send = sendData.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(send, send.length, receivePacket.getAddress(),
					receivePacket.getPort());
			try {
				socket.send(sendPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Thread server = new UDPServer();
		server.start();
		// This is a merging testss
	}

}

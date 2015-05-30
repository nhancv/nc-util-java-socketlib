import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;
		/*
		 * Open a server socket on port 2222. Note that we cant't choose a post
		 * less than 1023 if we are not privileged users (root).
		 */
		try {
			echoServer = new ServerSocket(2222);
		} catch (IOException e) {
			System.out.println(e);
		}

		/*
		 * Create a socket object from the ServerSocket to listen to and accept
		 * connections. Open input and output streams.
		 */
		System.out.println("The server started. To stop it press <CTRL><C>.");
		try {
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			/* As long as we receive data, echo data back to the client. */
			while (true) {
				line = is.readLine();
				os.println("From server: " + line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}

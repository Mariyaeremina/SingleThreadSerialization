package client;
import data.Product;
import data.Serialization;
import data.Stack;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket;
    private DataOutputStream outStream;

    public Client()
    {
        try
        {
            socket = new Socket("localhost", 3345);
            outStream = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void Run(Stack<Product> myStack) throws InterruptedException
    {
        try
        {
            byte[] byteArray = Serialization.Serialize(myStack);
            outStream.write(byteArray);
            outStream.flush();
            System.out.println("Client sent message to server.");
            System.out.println("Client sent message & start waiting for data from server...");
            Thread.sleep(2000);
            System.out.println("Closing connections");

        }
        catch (UnknownHostException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
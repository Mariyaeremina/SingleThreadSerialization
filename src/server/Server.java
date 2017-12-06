package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import data.*;

public class Server
{
    private ServerSocket server;
    private Socket client;
    public void Run()
    {
        try
        {
            server = new ServerSocket(3345);
            client = server.accept();

            System.out.print("Connection accepted.");

            DataInputStream in = new DataInputStream(client.getInputStream());

            while(!client.isClosed())
            {
                System.out.println("Server reading from channel");
                byte[] byteArray = new byte[10000];
                in.read(byteArray);
                Stack<Product> myStack = Serialization.Deserialize(byteArray);
                System.out.println("Read from client, 1 element: ");
                while (!myStack.IsEmpty())
                {
                    Product temp = myStack.Pop();
                    System.out.println(temp.Id + " " + temp.Name + " " + temp.Price);
                }
            }

            System.out.println("Client disconnected");
            in.close();
            client.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
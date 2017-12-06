package client;

import data.*;

public class Main {
    public static void main(String[] args)
    {
        Client client = new Client();
        Stack<Product> stack = Db.GetStackFromDB();
        try
        {
            client.Run(stack);
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}

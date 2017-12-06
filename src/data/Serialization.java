package data;

import java.io.*;

public class Serialization
{
    public static <T> byte[] Serialize(T obj) throws IOException
    {
        ByteArrayOutputStream bOutStream = new ByteArrayOutputStream();
        ObjectOutputStream oOutStream = new ObjectOutputStream(bOutStream);
        oOutStream.writeObject(obj);
        oOutStream.flush();
        oOutStream.close();
        return bOutStream.toByteArray();
    }

    public static <T> T Deserialize(byte[] array) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream bOutStream = new ByteArrayInputStream(array);
        ObjectInputStream ois = new ObjectInputStream(bOutStream);
        return (T) ois.readObject();
    }
}

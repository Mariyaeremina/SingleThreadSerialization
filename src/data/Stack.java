package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Stack<T> implements Serializable
{
    private ArrayList<T> array;
    private int count;

    public Stack()
    {
        array = new ArrayList<T>();
        count = 0;
    }

    public void Push(T elem){
        if (count >= 100000)
        {
            throw new IllegalArgumentException("Стек пуст");
        }
        else {
            array.add(count, elem);
            count++;
        }
    }

    public boolean IsEmpty()
    {
        return (count == 0);
    }

    public T Pop(){
        if (!IsEmpty())
        {
            return array.get(--count);
        }
        else
        {
            throw new IllegalArgumentException("Стек пуст");
        }
    }

    public T Top(){
        if (!IsEmpty())
        {
            return array.get(count - 1);
        }
        else
        {
            throw new IllegalArgumentException("Стек пуст");
        }
    }

    public int Size()
    {
        return count;
    }

    public void Clear()
    {
        array.clear();
        count = 0;
    }
}

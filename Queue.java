package datastructures;
/**
 * 
 * @author ibagr
 *
 *
 */
public class Queue {

    private Vector data;

    public Queue() {
        data = new Vector(10);
    }

    public void push(Object o) {
        Vector v = (Vector)o;
        Clients c = (Clients)v.get(1);
        if (c.getClass().getSimpleName().equals("VIP") && data.size() != 0) {
            System.out.println("Prioritise VIP in  queue.");
            data.addLast(o);
            return;
        }
        data.addFirst(o);

    }

    public Object pop() {
        Object x = data.getLast();
        data.removeLast();
        return x;
    }

    public Object top() {
        return data.getLast();
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        if (data.size() == 0) {
            return true;
        }
        return false;
    }

    public void printQueue() {
        for (int i = data.size() - 1; i >= 0; i--) {
            System.out.println(data.get(i).toString());
        }
    }
}

package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 功能说明：队列
 *
 * @auther liubf
 * @date 2018/12/24
 * @throws
 */
public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node{
        //定义了节点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){  return first == null; }

    public int size(){ return N; }

    public void enqueue(Item item){
        //向表尾添加元素
        Node oldlast = last;

        last = new Node();
        last.item = item;

        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        //从表头删除
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N++;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){}
    }

    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue");
    }
}

package algorithm4.com.lbf.test;

import java.util.Iterator;

/**
 * 功能说明：下压栈
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first; //栈顶（最近添加的元素）
    private int N;      //元素数量

    private class Node{
        //定义了节点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){ return first == null;}

    public int size(){ return N;}

    public void push(Item item){
        //向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        //从栈顶删除元素
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}

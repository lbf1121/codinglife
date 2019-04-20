package algorithm4.com.lbf.test;

/**
 * 功能说明：定容字符串栈的抽象数据类型
 *
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop(){
       return a[N--];
    }
}

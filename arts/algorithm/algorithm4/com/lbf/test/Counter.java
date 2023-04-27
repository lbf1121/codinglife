package algorithm4.com.lbf.test;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class Counter {
    private String id;
    private int counter;

    public Counter(String id){
        this.id = id;
        this.counter = 0;
    }

    public void increment(){
        this.counter++;
    }

    public int tally(){
        return this.counter;
    }

    public String toString(){
        return this.counter+"  "+this.id;
    }
}

package off9;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
         stack1.push(value);
    }

    public int deleteHead() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()){
            return -1;
        }
        int t = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return t;
    }
}
public class Main {
}

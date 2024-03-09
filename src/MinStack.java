package src;

// Beats 96% users in one attempt.
public class MinStack {
    public int[] data;
    public int size = 0;
    public int minelement = Integer.MAX_VALUE;
    public final int DEFAULT_SIZE = 2;

    public MinStack(int size){
        this.data = new int[size];
    }

    public MinStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void push(int val) {
        if (this.size-1==this.data.length){
            System.out.println("Can't push into a already filled stack");
            return;
        }
        this.data[size] = val;
        this.size++;
        if (this.minelement>val){
            this.minelement = val;
        }
        if (size == 0.5* data.length){
            rehash();
        }
    }

    private void rehash() {
        int[] temp = new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void pop() {
        if (size==0) {
            System.out.println("Can't Remove from an empty stack.");
            return;
        }
        if (minelement==data[size-1]){
            getMinimum();
        }else {
            data[size - 1] = 0;
            size--;
        }
        if (size==0) minelement = Integer.MAX_VALUE;
    }

    public void getMinimum() {
        this.data[size - 1] = 0;
        size--;
        minelement = data[0];
        for (int i = 1; i <this.size; i++) {
            if (data[i] < minelement)
                minelement = data[i];
        }
    }

    public int top() {
         return data[size-1];
    }

    public int getMin() {
        return minelement;
    }
}

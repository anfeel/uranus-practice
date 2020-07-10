package problems.dataStructure.array;

/**
 * 数组模拟队列
 * @author anfeel
 * @version $ Id:ArrayQueue, v 0.1 2020年07月10日 16:18 anfeel Exp $
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int size) {
        array = new int[size];
        maxSize = size;
        front = -1; //指向队列头部
        rear = -1;
    }

    public boolean isFull() {
        if (rear == maxSize - 1)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (rear == front)
            return true;
        return false;
    }

    public int push(int data) {
        if (isFull())
            throw new RuntimeException("队列已满");
        rear++;
        array[rear] = data;
        return rear;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("空队列");
        front++;
        return array[front];
    }

    public void printQueue() {
        if (isEmpty())
            throw new RuntimeException("空队列");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

    public int printFront() {
        if (isEmpty())
            throw new RuntimeException("空队列");
        return array[front + 1];
    }
}

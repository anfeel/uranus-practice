package problems.dataStructure.array;

/**
 * 数组模拟环形队列
 * @author anfeel
 * @version $ Id:CircularQueue, v 0.1 2020年07月13日 9:48 anfeel Exp $
 */
public class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public CircularQueue(int size) {
        this.maxSize = size;
        array = new int[size];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        if ((rear + 1) % maxSize == front)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (rear == front)
            return true;
        return false;
    }

    public void enQueue(int e) {
        if (isFull())
            throw new RuntimeException("队列满");
        array[rear] = e;
        rear = (rear + 1) % maxSize;
    }

    public int deQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        int e = array[front];
        front = (front + 1) % maxSize;
        return e;
    }

    public int getLength() {
        return rear >= front ? rear - front : rear + maxSize - front;
    }
}

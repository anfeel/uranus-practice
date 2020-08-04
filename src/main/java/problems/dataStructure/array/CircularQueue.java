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

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println(queue.getLength());
        queue.deQueue();
        queue.enQueue(5);
        queue.enQueue(6);
        queue.headQueue();
    }

    public CircularQueue(int size) {
        this.maxSize = size;
        array = new int[size];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
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
//        return rear >= front ? rear - front : rear + maxSize - front;
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        for (int i = front; i < front + getLength(); i++) {
            System.out.printf("array[%d]=%d \n", i % maxSize, array[i % maxSize]);
        }
    }

    public void headQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空");
        System.out.printf("head = %d", array[front]);
    }

}

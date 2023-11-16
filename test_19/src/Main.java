import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        ArrayQueue arrayQueue = new ArrayQueue(maxSize);
        while(true) {
            int cho = scanner.nextInt();

            switch(cho){
                case 1:int a = scanner.nextInt(); arrayQueue.addQueue(a);break;
                case 2:
                    System.out.println(arrayQueue.outQueue());break;
                case 3: arrayQueue.showQueue();break;
                default: return;
            }
        }

    }
}

class ArrayQueue {
    private int maxSize = 10;
    private int[] queue;
    private int front,rear;
    private int n = (rear - front + maxSize) % maxSize;

    public ArrayQueue() {
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue =  new int[maxSize];
        this.front = 0;//指向队列头的前一个位置；
        this.rear = 0;//指先队列的尾部；

    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    public boolean isEmpty() {
        return rear == front;
    }
    public void addQueue(int n) {
        if(isFull()) return;
        rear = (rear + 1) % maxSize;
        this.queue[rear] = n;
    }
    public int outQueue() {
        if(isEmpty()) return -1;
        front = (front + 1) % maxSize;
        return this.queue[front];
    }
/*    public void showQueue() {
        if(isEmpty()) return;
        for(int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.println(queue[i]);
        }
    }*/
public void showQueue() {
    if(isEmpty()) return;
    for(int i = front + 1; i <= n + front; i++) {
        System.out.println(queue[i % maxSize]);
    }
}
    /**
     * 获取
     * @return queue
     */
    public int[] getQueue() {
        return queue;
    }

    /**
     * 设置
     * @param queue
     */
    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    /**
     * 获取
     * @return front
     */
    public int getFront() {
        return front;
    }

    /**
     * 设置
     * @param front
     */
    public void setFront(int front) {
        this.front = front;
    }

    /**
     * 获取
     * @return rear
     */
    public int getRear() {
        return rear;
    }

    /**
     * 设置
     * @param rear
     */
    public void setRear(int rear) {
        this.rear = rear;
    }

    public String toString() {
        return "ArrayQueue{MAXSIZE = " + maxSize + ", queue = " + queue + ", front = " + front + ", rear = " + rear + "}";
    }
}
public class Q0622 {
}


class MyCircularQueue {

    public int capacity;
    public int size;
    public int head;
    public int tail;
    public int[] payload;


    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = 0;
        this.tail = -1;
        this.payload = new int[k];
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        size++;
        tail = (tail + 1) % capacity;
        payload[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        size--;
        head = (head + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return payload[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return payload[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
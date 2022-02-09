package com.practice.queue;

/**
 * I had a hard time thinking about how to create isEmpty and isFull function took over 2 days LOL
 * imp point that helped is we need to proactively set queue in empty or full state by setting pointers
 * we know as soon as we enqueue, its not empty, so make sure isEmpty can not return true.
 * isFull is easy cause when tail pointer is going to step on to head pointer its full
 */
class MyCircularQueue {

    int[] q;
    int tail = -1;
    int head = -1;

    public MyCircularQueue(int k) {
        // this a queue, circular queue
        //  could it be an array? or list?
        // empty head and tail pointing at the same location?
        // (tail+1)%k==head  isFull
        q = new int[k];
    }

    public boolean enQueue(int value) {

        if (isFull())
            return false;

        tail = (tail + 1) % q.length;
        q[tail] = value;

        if (head == -1) {
            head += 1;
        }
        return true;

    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = -1;
            tail = -1;
        } else
            head = (head + 1) % q.length;

        return true;
    }


    public boolean isEmpty() {
        if (head == -1 && tail == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (tail == -1)
            return false;

        return (tail + 1) % q.length == head;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return q[head];
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return q[tail];

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

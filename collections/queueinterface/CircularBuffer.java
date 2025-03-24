package collections.queueinterface;
import java.util.Arrays;
public class CircularBuffer {
        private int[] buffer;
        private int size;
        private int front, rear;
        private boolean isFull;

        public CircularBuffer(int capacity) {
            buffer = new int[capacity];
            size = capacity;
            front = 0;
            rear = 0;
            isFull = false;
        }

        // Insert element into the circular buffer
        public void insert(int value) {
            buffer[rear] = value;
            rear = (rear + 1) % size;

            if (isFull) {
                front = (front + 1) % size; // Move front forward when full
            }

            if (rear == front) {
                isFull = true; // Mark buffer as full
            }
        }

        // Display buffer elements in circular order
        public void display() {
            if (!isFull && front == rear) {
                System.out.println("Buffer is empty.");
                return;
            }

            System.out.print("Buffer: [");
            int i = front;
            while (true) {
                System.out.print(buffer[i]);
                i = (i + 1) % size;
                if (i == rear && !isFull) break; // Stop when we reach the last inserted element
                if (i == front && isFull) break; // Stop when we've wrapped around
                System.out.print(", ");
            }
            System.out.println("]");
        }

        public static void main(String[] args) {
            CircularBuffer cb = new CircularBuffer(3);

            cb.insert(1);
            cb.insert(2);
            cb.insert(3);
            cb.display();  // Output: [1, 2, 3]

            cb.insert(4);  // Overwrites 1
            cb.display();  // Output: [2, 3, 4]

            cb.insert(5);  // Overwrites 2
            cb.display();  // Output: [3, 4, 5]

            cb.insert(6);  // Overwrites 3
            cb.display();  // Output: [4, 5, 6]
        }
    }



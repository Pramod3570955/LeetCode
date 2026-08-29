class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        int size = queue.size();

        queue.offer(x);

        // Rotate old elements
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {

        // Remove newest element
        return queue.poll();
    }

    public int top() {

        // Return newest element
        return queue.peek();
    }

    public boolean empty() {

        // Check if empty
        return queue.isEmpty();
    }
}
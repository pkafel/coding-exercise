import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {
    private Queue<Integer> stream;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.stream = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            stream.add(nums[i]);
            if (stream.size() > k) stream.poll();
        }
        this.k = k;
    }

    public int add(int val) {
        stream.add(val);
        if(stream.size() > k) stream.poll();
        return stream.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        System.out.println(kthLargest.add(4));

    }
}
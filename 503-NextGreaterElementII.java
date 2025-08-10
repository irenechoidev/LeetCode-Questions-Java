class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
        }

        return res;
    }
}

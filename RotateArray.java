import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



/**
 * 
 */
public class RotateArray {


    /**
     * Rotate the array to the right by k steps, 
     * where k is non-negative.
     * 
     * 38 / 38 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 56.4 MB
     * 
     * Runtime: O(n)  - Space: O(1)
     */
    static public void rotate0(int[] nums, int k) {
       
        // // **** sanity check(s) ****
        // if (k == 0 || nums.length == k) return;
        // if (nums.length == 1) return;

        // **** initialization ****
        k  %= nums.length;

        // ???? ????
        System.out.println("<<< k: " + k);

        // **** reverse entire array - O(n) ****
        reverse0(nums, 0, nums.length - 1);

        // ???? ????
        System.out.println("<<< nums: " + Arrays.toString(nums));   

        // **** reverse front sub array - O(k)****
        reverse0(nums, 0, k - 1);

        // ???? ????
        System.out.println("<<< nums: " + Arrays.toString(nums));   

        // **** reverse back sub array - O(n - k) ****
        reverse0(nums, k, nums.length - 1);

        // ???? ????
        System.out.println("<<< nums: " + Arrays.toString(nums));   
    }


    /**
     * Reverse elements in specified array and range.
     */
    static private void reverse0(int[] arr, int s, int e) {
        while (s < e) {
            int tmp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = tmp;

            // // **** update start and end indices ****
            // s++;
            // e--;
        }
    }


    /**
     * Rotate the array to the right by k steps, 
     * where k is non-negative.
     * 
     * Using auxiliary array.
     * 
     * 38 / 38 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 56.4 MB
     * 
     * Runtime: O(n) - Space: O(n)
     */
    static public void rotate1(int[] nums, int k) {
        
        // **** sanity check(s) ****
        if (nums.length == 1) return;

        // **** initialization ****
        k           %= nums.length;
        int[] arr   = new int[nums.length];

        // ???? ????
        System.out.println("<<< k: " + k);

        // **** copy back sub array - O(k) ****
        for (int i = 0; i < k; i++)
            arr[i] = nums[nums.length - k  + i];

        // ???? ????
        System.out.println("<<< arr: " + Arrays.toString(arr));

        // **** copy front sub array - O(n - k) ****
        for (int i = 0; i < nums.length - k; i++)
            arr[k + i] = nums[i];

        // ???? ????
        System.out.println("<<< arr: " + Arrays.toString(arr));

        // **** copy arr to nums ****
        for (int i = 0; i < arr.length; i++)
            nums[i] = arr[i];
    }


    /**
     * Rotate the array to the right by k steps, 
     * where k is non-negative.
     * 
     * Brute force approach.
     * 
     * 37 / 38 test cases passed.
     * Status: Time Limit Exceeded
     * Submitted: 0 minutes ago
     *
     * Runtime: O(k * n) - Space: O(1)
     */
    static public void rotate2(int[] nums, int k) {

        // **** initialization ****
        k %= nums.length;

        // ???? ????
        System.out.println("<<< k: " + k);
        
        // **** loop once per rotation ****
        for (int i = 0; i < k; i++) {

            // **** save last element ****
            int tmp = nums[nums.length - 1];

            // **** rotate array right to left ****
            for (int j = nums.length - 1; j > 0; j--)
                nums[j] = nums[j - 1];

            // **** restore last element ****
            nums[0] = tmp;
        }
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] nums ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read k ****
        int k = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));
        System.out.println("main <<< k: " + k);

        // **** call function of interest ****
        rotate0(nums, k);
        // rotate1(nums, k);
        // rotate2(nums, k);

        // **** display result ****
        System.out.println("main <<< output: " + Arrays.toString(nums));
    }
}
// 70. Climbing Stairs
//
// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
// climb to the top?
//
// Note: Given n will be a positive integer.
//
// Example 1:
//
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
//
// Example 2:
//
// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

class ClimbingStairs_070E {
    // This implementation is correct but it is slow for large values of n. It will
    // timeout when running the LeetCode test cases.
    public int climbStairs(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 1) {
            return climbStairs(n - 1);
        } else if (n >= 2) {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

        return 1;       // (n == 0), so we return 1 and sum the result to get the answer
    }

    // If we look at the output for any integer sequence [1,...,x,...,n], the value for
    // the xth integer in the sequence is the value of climbStairs(x-1) + climbStairs(x-2).
    //      climbStairs(x) = climbStairs(x-1) + climbStairs(x-2)
    // This looks very similar to the Fibonacci sequence and we will use this to build the
    // algorithm.
    public int climbStairs_fibonacci(int n) {
        if (n <= 0) {
            return -1;
        }

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int n_minus1 = 2;
        int n_minus2 = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = n_minus1 + n_minus2;
            n_minus2 = n_minus1;
            n_minus1 = current;
        }

        return current;
    }

    public void test() {
        System.out.println("Testing climbStairs(int n)...\n");

        int n;
        int result;

        n = 1;
        result = climbStairs(n);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        n = 2;
        result = climbStairs(n);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        n = 3;
        result = climbStairs(n);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        n = 4;
        result = climbStairs(n);
        System.out.println("Expected:  5");
        System.out.println("Output:    " + result + "\n");

        n = 5;
        result = climbStairs(n);
        System.out.println("Expected:  8");
        System.out.println("Output:    " + result + "\n");

        n = 6;
        result = climbStairs(n);
        System.out.println("Expected:  13");
        System.out.println("Output:    " + result + "\n");

        n = 7;
        result = climbStairs(n);
        System.out.println("Expected:  21");
        System.out.println("Output:    " + result + "\n");

        n = 8;
        result = climbStairs(n);
        System.out.println("Expected:  34");
        System.out.println("Output:    " + result + "\n");

        n = 9;
        result = climbStairs(n);
        System.out.println("Expected:  55");
        System.out.println("Output:    " + result + "\n");
         
        n = 10;
        result = climbStairs(n);
        System.out.println("Expected:  89");
        System.out.println("Output:    " + result + "\n");
        
        n = 44;
        result = climbStairs(n);
        System.out.println("Expected:  1134903170");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_fibonacci() {
        System.out.println("Testing climbStairs_fibonacci(int n)...\n");

        int n;
        int result;

        n = 1;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        n = 2;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        n = 3;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        n = 4;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  5");
        System.out.println("Output:    " + result + "\n");

        n = 5;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  8");
        System.out.println("Output:    " + result + "\n");

        n = 6;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  13");
        System.out.println("Output:    " + result + "\n");

        n = 7;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  21");
        System.out.println("Output:    " + result + "\n");

        n = 8;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  34");
        System.out.println("Output:    " + result + "\n");

        n = 9;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  55");
        System.out.println("Output:    " + result + "\n");
         
        n = 10;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  89");
        System.out.println("Output:    " + result + "\n");
        
        n = 44;
        result = climbStairs_fibonacci(n);
        System.out.println("Expected:  1134903170");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        ClimbingStairs_070E solution = new ClimbingStairs_070E();
        solution.test();
        solution.test_fibonacci();
    }
}
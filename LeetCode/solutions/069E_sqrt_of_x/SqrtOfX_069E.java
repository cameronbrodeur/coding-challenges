// 69. Sqrt(x)
//
// Implement integer_sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a 
// non-negative integer.
//
// Since the return type is an integer, the decimal digits are truncated and only 
// the integer part of the result is returned.
//
// Example 1:
//
// Input: 4
// Output: 2
//
// Example 2:
//
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since 
//              the decimal part is truncated, 2 is returned.

class SqrtOfX_069E {
    // Calculate integer_sqrt(n) using Newton's method:
    // x_k+1 = floor(0.5 * (x_k + (n/x_k))), where k >= 0, x_0 > 0
    // x_k approaches sqrt(n) as k -> infinity
    public int mySqrt(int x) {
        if (x < 0) 
            return -1;

        double EPSILON = 1E-15;
        double root = x;

        while (Math.abs(root - x / root) > EPSILON * root)
            root = (x / root + root) / 2.0;

        return (int) root;
    }

    // Calculate integer_sqrt(n) using Newton's method w/o the use of 
    // floating point arithmetic
    public int mySqrt_simplified(int x) {
        if (x < 0) 
            return -1;

        long root = x;
        while ((root * root) > x)
            root = (root + x / root) / 2;

        return (int) root;
    }

    // Calculate integer_sqrt(x) using binary search
    public int mySqrt_binarySearch(int x) {
        // Special cases: x < 0
        if (x < 0)
            return -1;

        long lowerBound = 0;
        long upperBound = 2 + (x / 2);
        long root;
        long sq;

        // Calculate the sq root of x with binary search
        while (true) {
            root = (lowerBound + upperBound) / 2;
            sq = root * root;

            if ((x >= root * root) && (x < (root + 1) * (root + 1)))
                return (int) root;

            if (sq < x)
                lowerBound = root;
            else if (sq > x)
                upperBound = root;
        }
    }

    public void test() {
        System.out.println("Testing mySqrt(int x)...\n");

        int x;
        int result;

        x = 4;
        result = mySqrt(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 8;
        result = mySqrt(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 12;
        result = mySqrt(x);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        x = 2147395599;
        result = mySqrt(x);
        System.out.println("Expected:  46339");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_simplified() {
        System.out.println("Testing mySqrt_simplified(int x)...\n");

        int x;
        int result;

        x = 4;
        result = mySqrt_simplified(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 8;
        result = mySqrt_simplified(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 12;
        result = mySqrt_simplified(x);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        x = 2147395599;
        result = mySqrt_simplified(x);
        System.out.println("Expected:  46339");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_binarySearch() {
        System.out.println("Testing mySqrt_binarySearch(int x)...\n");

        int x;
        int result;

        x = -1;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  -1");
        System.out.println("Output:    " + result + "\n");

        x = 0;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        x = 1;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        x = 4;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 5;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 6;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 8;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        x = 9;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        x = 12;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        x = 16;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  4");
        System.out.println("Output:    " + result + "\n");

        x = 8192;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  90");
        System.out.println("Output:    " + result + "\n");

        x = 2147395599;
        result = mySqrt_binarySearch(x);
        System.out.println("Expected:  46339");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        SqrtOfX_069E solution = new SqrtOfX_069E();
        solution.test();
        solution.test_simplified();
        solution.test_binarySearch();
    }
}
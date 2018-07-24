// 9. Palindrome Number
//
// Determine whether an integer is a palindrome. An integer is a palindrome when 
// it reads the same backward as forward.
//
// Example 1:
//
// Input: 121
// Output: true
//
// Example 2:
//
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it 
// becomes 121-. Therefore it is not a palindrome.
//
// Example 3:
//
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// Follow up:
//
// Coud you solve it without converting the integer to a string?

class PalindromeNumber_009E {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        if (s.length() <= 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    // <TO DO>
    // Solve without converting the int to a string. Perform using O(1) space complexity,
    // O(n) time complexity.
    public boolean isPalindrome_improved(int x) {
        return true;
    }

    public void test() {
        System.out.println("Testing isPalindrome(int x)...\n");

        int x;
        boolean result;

        x = 121;
        result = this.isPalindrome(x);
        System.out.println("Expected: true");
        System.out.println("Output:   " + result);

        x = -121;
        result = this.isPalindrome(x);
        System.out.println("Expected: false");
        System.out.println("Output:   " + result);

        x = 10;
        result = this.isPalindrome(x);
        System.out.println("Expected: false");
        System.out.println("Output:   " + result);
    }

    public static void main(String[] args) {
        PalindromeNumber_009E solution = new PalindromeNumber_009E();
        solution.test();
    }
}
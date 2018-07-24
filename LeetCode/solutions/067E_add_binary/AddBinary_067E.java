// 67. Add Binary
//
// Given two binary strings, return their sum (also a binary string).
//
// The input strings are both non-empty and contains only characters 1 or 0.
//
// Example 1:
//
// Input: a = "11", b = "1"
// Output: "100"
//
// Example 2:
//
// Input: a = "1010", b = "1011"
// Output: "10101"

class AddBinary_067E {
    // This solution *does not* make use of parseInt() or integer addition. The binary
    // sum of a+b is calculated directly from the characters in strings a and b.
    // Time complexity: O(n)
    // Space complexity: O(n)
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        char aChar, bChar;
        boolean carry = false;
        StringBuilder s = new StringBuilder("");

        while (true) {
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex);
            } else {
                aChar = '0';
            }

            if (bIndex >= 0) {
                bChar = b.charAt(bIndex);
            } else {
                bChar = '0';
            }

            if ((aChar == '0') && (bChar == '0') && (carry == false)) {
                s.append("0");
            } else if (((aChar == '1') && (bChar == '0') && (carry == false)) || 
                       ((aChar == '0') && (bChar == '1') && (carry == false)) ||
                       ((aChar == '0') && (bChar == '0') && (carry == true))) {
                s.append("1");
                carry = false;
            } else if (((aChar == '1') && (bChar == '1') && (carry == false)) || 
                       ((aChar == '1') && (bChar == '0') && (carry == true)) ||
                       ((aChar == '0') && (bChar == '1') && (carry == true))) {
                s.append("0");
                carry = true;
            } else if ((aChar == '1') && (bChar == '1') && (carry == true)) {
                s.append("1");
                carry = true;
            }
            aIndex--;
            bIndex--;

            if ((aIndex < 0) && (bIndex < 0)) {
                if (carry == true) {
                    s.append("1");
                }
                break;
            }
        }
        return s.reverse().toString();
    }

    // Another solution which incorporates several optimizations that improve
    // speed and readability. 
    public String addBinary_improved(String a, String b) {
        if(a == null || a.isEmpty())
            return b;
        if(b == null || b.isEmpty())
            return a;
        
        StringBuilder s = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        
        while (j >= 0 || i >= 0 || carry == 1) {
            int cA = (i >= 0) ? a.charAt(i--) - '0' : 0;        // Here is i-- to avoid later subtraction
            int cB = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = (cA + cB + carry) % 2;                    // == cA ^ cB ^ carry , choose whatever you want :)
            carry = (cA + cB + carry) / 2;                      // Better readability than ((aByte + bByte + carry) >= 2) ? 1 : 0;
            
            s.append(sum);
        }
    
        return s.reverse().toString();
    }

    public void test() {
        System.out.println("Testing addBinary(String a, String b)...\n");

        String a, b, result;

        a = new String("11");
        b = new String("1");
        result = addBinary(a, b);
        System.out.println("Expected:  100");
        System.out.println("Output:    " + result + "\n");

        a = new String("1010");
        b = new String("1011");
        result = addBinary(a, b);
        System.out.println("Expected:  10101");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_improved() {
        System.out.println("Testing addBinary_improved(String a, String b)...\n");

        String a, b, result;

        a = new String("11");
        b = new String("1");
        result = addBinary_improved(a, b);
        System.out.println("Expected:  100");
        System.out.println("Output:    " + result + "\n");

        a = new String("1010");
        b = new String("1011");
        result = addBinary_improved(a, b);
        System.out.println("Expected:  10101");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        AddBinary_067E solution = new AddBinary_067E();
        solution.test();
        solution.test_improved();
    }
}
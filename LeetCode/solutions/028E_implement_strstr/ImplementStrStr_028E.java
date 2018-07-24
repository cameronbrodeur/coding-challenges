// 28. Implement strStr()
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle 
// is not part of haystack.
//
// Example 1:
//
// Input: haystack = "hello", needle = "ll"
// Output: 2
//
// Example 2:
//
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great question to 
// ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty string. 
// This is consistent to C's strstr() and Java's indexOf().

class ImplementStrStr_028E {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int haystackIndex = 0;
        int needleIndex = 0;
        int needleStartIndex = 0;

        while (haystackIndex < haystack.length() - needle.length()) {
            if (haystack.charAt(haystackIndex) == needle.charAt(0)) {
                needleStartIndex = haystackIndex;
                while ((haystackIndex < haystack.length()) && (needleIndex < needle.length()) && (haystack.charAt(haystackIndex) == needle.charAt(needleIndex))) {
                    haystackIndex++;
                    needleIndex++;
                }
                if (needleIndex == needle.length()) {
                    return needleStartIndex;
                } else {
                    haystackIndex = needleStartIndex;
                    needleIndex = 0;
                }
            }
            haystackIndex++;
        }

        return -1;
    }

    public int strStr_improved(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    public void test() {
        System.out.println("Testing strStr(String haystack, String needle)...\n");

        String haystack, needle;
        int result;

        haystack = new String("");
        needle = new String("");
        result = strStr(haystack, needle);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("a");
        needle = new String("");
        result = strStr(haystack, needle);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("hello");
        needle = new String("ll");
        result = strStr(haystack, needle);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("aaaaa");
        needle = new String("bba");
        result = strStr(haystack, needle);
        System.out.println("Expected:  -1");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("the quick brown fox jumps over the lazy dog");
        needle = new String("the lazy");
        result = strStr(haystack, needle);
        System.out.println("Expected:  31");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("the quick brown fox jumps over the lazy dog");
        needle = new String("dogs");
        result = strStr(haystack, needle);
        System.out.println("Expected:  -1");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("mississippi");
        needle = new String("pi");
        result = strStr(haystack, needle);
        System.out.println("Expected:  9");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_improved() {
        System.out.println("Testing strStr_improved(String haystack, String needle)...\n");

        String haystack, needle;
        int result;

        haystack = new String("");
        needle = new String("");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("a");
        needle = new String("");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("hello");
        needle = new String("ll");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("aaaaa");
        needle = new String("bba");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  -1");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("the quick brown fox jumps over the lazy dog");
        needle = new String("the lazy");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  31");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("the quick brown fox jumps over the lazy dog");
        needle = new String("dogs");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  -1");
        System.out.println("Output:    " + result + "\n");

        haystack = new String("mississippi");
        needle = new String("pi");
        result = strStr_improved(haystack, needle);
        System.out.println("Expected:  9");
        System.out.println("Output:    " + result + "\n");
    }
    
    public static void main(String[] args) {
        ImplementStrStr_028E solution = new ImplementStrStr_028E();
        solution.test();
        solution.test_improved();
    }
}
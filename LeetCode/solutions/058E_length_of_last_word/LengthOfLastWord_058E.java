// 58. Length of Last Word
//
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space characters only.
//
// Example:
//
// Input: "Hello World"
// Output: 5

class LengthOfLastWord_058E {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean inWord = false;
        int index = s.length() - 1;

        while (index >= 0) {
            if ((inWord == true) && (s.charAt(index) == ' ')) {
                return length;
            } else if (s.charAt(index) != ' ') {
                inWord = true;
                length++;
            }
            index--;
        }
        return length;
    }

    public int lengthOfLastWord_oneLineSolution(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }

    public void test() {
        System.out.println("Testing lengthOfLastWord(String s)...\n");

        String s;
        int result;

        s = new String("Hello World");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  5");
        System.out.println("Output:    " + result + "\n");

        s = new String("");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        s = new String("         ");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        s = new String("    You said Hello but     I  get the last    word    ");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  4");
        System.out.println("Output:    " + result + "\n");

        s = new String("A");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        s = new String("A    ");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        s = new String("    A");
        result = lengthOfLastWord(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_oneLineSolution() {
        System.out.println("Testing lengthOfLastWord_oneLineSolution(String s)...\n");

        String s;
        int result;

        s = new String("Hello World");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  5");
        System.out.println("Output:    " + result + "\n");

        s = new String("");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        s = new String("         ");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        s = new String("    You said Hello but     I  get the last    word    ");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  4");
        System.out.println("Output:    " + result + "\n");

        s = new String("A");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        s = new String("A    ");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        s = new String("    A");
        result = lengthOfLastWord_oneLineSolution(s);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        LengthOfLastWord_058E solution = new LengthOfLastWord_058E();
        solution.test();
        solution.test_oneLineSolution();
    }
}
// 38. Count and Say
//
// The count-and-say sequence is the sequence of integers with the first 
// five terms as following:
//
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth term of the count-and-say sequence.
//
// Note: Each term of the sequence of integers will be represented as a string.
//
// Example 1:
//
// Input: 1
// Output: "1"
//
// Example 2:
//
// Input: 4
// Output: "1211"

class CountAndSay_038E {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String currentCountAndSay = "1";

        for (int currentTerm = 1; currentTerm < n; currentTerm++) {
            int index = 0;
            String nextCountAndSay = "";

            while (index < currentCountAndSay.length()) {
                Integer count = 0;
                char say = currentCountAndSay.charAt(index);

                while ((index < currentCountAndSay.length()) && (currentCountAndSay.charAt(index) == say)) {
                    count++;
                    index++;
                }
                nextCountAndSay += count.toString() + say;
            }
            currentCountAndSay = nextCountAndSay;
        }
        return currentCountAndSay;
    }

    public void test() {
        System.out.println("Testing countAndSay(int n)...\n");

        String result;

        result = this.countAndSay(0);
        System.out.println("Expected:  ");
        System.out.println("Output:    " + result);

        result = this.countAndSay(1);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result);

        result = this.countAndSay(2);
        System.out.println("Expected:  11");
        System.out.println("Output:    " + result);

        result = this.countAndSay(3);
        System.out.println("Expected:  21");
        System.out.println("Output:    " + result);

        result = this.countAndSay(4);
        System.out.println("Expected:  1211");
        System.out.println("Output:    " + result);

        result = this.countAndSay(5);
        System.out.println("Expected:  111221");
        System.out.println("Output:    " + result);

        result = this.countAndSay(10);
        System.out.println("Expected:  13211311123113112211");
        System.out.println("Output:    " + result);

        result = this.countAndSay(20);
        System.out.println("Expected:  To long to print");
        System.out.println("Output:    " + result);
    }

    public static void main(String[] args) {
        CountAndSay_038E solution = new CountAndSay_038E();
        solution.test();
    }
}
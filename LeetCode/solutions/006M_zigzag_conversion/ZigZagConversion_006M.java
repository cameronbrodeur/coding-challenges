// 6. ZigZag Conversion
//
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
// of rows like this: (you may want to display this pattern in a fixed font for 
// better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a number 
// of rows:
//
// string convert(string s, int numRows);
//
// Example 1:
//
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
//
// Example 2:
//
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
//
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
//
// Example 3:
//
// Input: s = "PAYPALISHIRINGETLBDSAR", numRows = 5
// Output: ""
// Explanation:
//
// P       H       L
// A     S I     T B
// Y   I   R   E   D
// P L     I G     S R
// A       N       A


class ZigZagConversion_006M {
    public String convert(String s, int numRows) {
        if (numRows <= 0 || s.isEmpty()) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder("");
        }

        int strIndex = 0;
        int rowIndex = 0;
        boolean directionDown = true;
        while (strIndex < s.length()) {
            rows[rowIndex].append(s.charAt(strIndex));
            strIndex++;
            if (directionDown == true) {
                if (rowIndex == (numRows - 1)) {
                    directionDown = false;
                    rowIndex--;
                } else {
                    rowIndex++;
                }
            } else {
                if (rowIndex == 0) {
                    directionDown = true;
                    rowIndex++;
                } else {
                    rowIndex--;
                }
            }
        }

        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }

    public void test() {
        System.out.println("Testing convert(String s, int numRows)...\n");

        String result;
        String input;
        int numRows;

        input = "";
        numRows = 1;
        result = this.convert(input, numRows);
        System.out.println("Expected:  ");
        System.out.println("Output:    " + result);

        input = "PAYPALISHIRING";
        numRows = 0;
        result = this.convert(input, numRows);
        System.out.println("Expected:  ");
        System.out.println("Output:    " + result);

        input = "PAYPALISHIRING";
        numRows = 1;
        result = this.convert(input, numRows);
        System.out.println("Expected:  PAYPALISHIRING");
        System.out.println("Output:    " + result);

        input = "PAYPALISHIRING";
        numRows = 3;
        result = this.convert(input, numRows);
        System.out.println("Expected:  PAHNAPLSIIGYIR");
        System.out.println("Output:    " + result);

        input = "PAYPALISHIRING";
        numRows = 4;
        result = this.convert(input, numRows);
        System.out.println("Expected:  PINALSIGYAHRPI");
        System.out.println("Output:    " + result);

        input = "PAYPALISHIRINGETLBDSAR";
        numRows = 5;
        result = this.convert(input, numRows);
        System.out.println("Expected:  PHLASITBYIREDPLIGSRANA");
        System.out.println("Output:    " + result);
    }

    public static void main(String[] args) {
        ZigZagConversion_006M solution = new ZigZagConversion_006M();
        solution.test();
    }
}
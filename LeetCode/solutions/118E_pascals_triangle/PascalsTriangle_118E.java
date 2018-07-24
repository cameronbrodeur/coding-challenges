// 118. Pascal's Triangle
//
// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
// Example:
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PascalsTriangle_118E {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();

        if (numRows <= 0) {                             // Check that numRows value is valid; return empty triangle for numRows <= 0
            return triangle;
        }

        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);                         // This is the base case for numRows == 1

        int row = 1;
        while (row < numRows) {
            int rowLength = triangle.get(row - 1).size();
            triangle.add(new ArrayList<Integer>());
            triangle.get(row).add(1);                   // Left edge element (outside edges of Pascal's Triangle are always 1)
            for (int i = 1; i < rowLength; i++) {
                triangle.get(row).add(triangle.get(row - 1).get(i - 1) + triangle.get(row - 1).get(i)); // Inner element generation
            }
            triangle.get(row).add(1);                   // Right edge element
            row++;
        }

        return triangle;
    }

    // Pretty-print Pascal's Triangle
    public String prettyPrint(List<List<Integer>> pascalTriangle) {
        String s = "";
        List<Integer> row = pascalTriangle.get(pascalTriangle.size() - 1);  // Get the last row in the triangle
        String rowAsString = row.toString();
        int maxRowLength = rowAsString.length();                            // Store the max string length for later

        for (int i = 0; i < pascalTriangle.size(); i++) {
            row = pascalTriangle.get(i);
            rowAsString = row.toString();
            String pad = "";
            pad = padLeft(pad, (maxRowLength / 2) - (rowAsString.length() / 2));
            s += pad + rowAsString + "\n";
        }
        return s;
    }

    public static String padLeft(String s, int n) {
        if (n <= 0) {
            return "";
        }
        return String.format("%" + n + "s", s);
    }

    public void test() {
        System.out.println("Testing generate(int numRows)...\n");

        int numRows;
        List<List<Integer>> result;

        numRows = 1;
        result = generate(numRows);
        System.out.println(prettyPrint(result));

        numRows = 2;
        result = generate(numRows);
        System.out.println(prettyPrint(result));

        numRows = 5;
        result = generate(numRows);
        System.out.println(prettyPrint(result));

        numRows = 15;
        result = generate(numRows);
        System.out.println(prettyPrint(result));

        numRows = 20;
        result = generate(numRows);
        System.out.println(prettyPrint(result));
    }

    public static void main(String[] args) {
        PascalsTriangle_118E solution = new PascalsTriangle_118E();
        solution.test();
    }
}
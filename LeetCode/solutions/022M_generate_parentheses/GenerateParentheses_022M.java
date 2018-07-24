// 22. Generate Parentheses
//
// Given n pairs of parentheses, write a function to generate all combinations 
// of well-formed parentheses.
//
// For example, given n = 3, a solution set is:
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

class GenerateParentheses_022M {
    // Iterative, dynamic programming solution
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result;
        Stack current = new Stack<String>();

        if (n <= 0) {
            result = new ArrayList(current);
            return result;
        }

        String s = "()";                                    // Base case: n == 1
        current.push(s);

        Stack next;
        String temp;
        int parenCount = 2;
        while (parenCount <= n) {                           // Main loop to calculate n >= 2
            next = new Stack<String>();
            while (current.empty() == false) {
                s = (String) current.pop();
                int openParenIndex = s.indexOf('(');
                while (openParenIndex > -1) {               // Splice "()" into string at every valid location
                    temp = s.substring(0, openParenIndex + 1) + "()" + s.substring(openParenIndex + 1);
                    if (next.search(temp) == -1) {          // Avoid adding a duplicate string to the list
                        next.push(temp);
                    }
                    openParenIndex = s.indexOf('(', openParenIndex + 1); // Find next valid index in string
                }
                temp = s + "()";                            // Special case: append "()" to the end of string
                if (next.search(temp) == -1) {
                    next.push(temp);
                }                
            }
            current = next;
            parenCount++;
        }
        result = new ArrayList(current);
        return result;
    }

    // Recursive, backtracking solution
    public List<String> generateParenthesis_recursiveBacktracking(int n) {
        List<String> result = new ArrayList<String>();

        if (n <= 0) {
            return result;
        }

        generate(result, "", 0, 0, n);
        return result;
    }

    public void generate(List<String> list, String str, int open, int closed, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
        }

        if (open < max) {
            generate(list, str + "(", open + 1, closed, max);
        }
        if (closed < open) {
            generate(list, str + ")", open, closed + 1, max);
        }
    }

    public void test() {
        System.out.println("Testing generateParenthesis(int n)...\n");

        int n;
        List<String> result;

        n = 0;
        result = generateParenthesis(n);
        System.out.println("Expected:  []");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 1;
        result = generateParenthesis(n);
        System.out.println("Expected:  [()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 2;
        result = generateParenthesis(n);
        System.out.println("Expected:  [(()), ()()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 3;
        result = generateParenthesis(n);
        System.out.println("Expected:  [((())), (())(), (()()), ()(()), ()()()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 4;
        result = generateParenthesis(n);
        System.out.println("Output:    " + result.toString() + "\n");

        n = 5;
        result = generateParenthesis(n);
        System.out.println("Output:    " + result.toString() + "\n");
    }

    public void test_recursiveBacktracking() {
        System.out.println("Testing generateParenthesis_recursiveBacktracking(int n)...\n");

        int n;
        List<String> result;

        n = 0;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Expected:  []");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 1;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Expected:  [()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 2;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Expected:  [(()), ()()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 3;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Expected:  [((())), (())(), (()()), ()(()), ()()()]");
        System.out.println("Output:    " + result.toString() + "\n");

        n = 4;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Output:    " + result.toString() + "\n");

        n = 5;
        result = generateParenthesis_recursiveBacktracking(n);
        System.out.println("Output:    " + result.toString() + "\n");
    }

    public static void main(String[] args) {
        GenerateParentheses_022M solution = new GenerateParentheses_022M();
        solution.test();
        solution.test_recursiveBacktracking();
    }
}
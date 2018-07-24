// 17. Letter Combinations of a Phone Number
//
// Given a string containing digits from 2-9 inclusive, return all possible letter 
// combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
// below. Note that 1 does not map to any letters.
//
// {
//     '0' : ['0'],
//     '1' : ['1'],
//     '2' : ['a', 'b', 'c'],
//     '3' : ['d', 'e', 'f'],
//     '4' : ['g', 'h', 'i'],
//     '5' : ['j', 'k', 'l'],
//     '6' : ['m', 'n', 'o'],
//     '7' : ['p', 'q', 'r', 's'],
//     '8' : ['t', 'u', 'v'],
//     '9' : ['w', 'x', 'y', 'z']
// }
//
// Example:
//
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
// Note:
// Although the above answer is in lexicographical order, your answer could be in 
// any order you want.

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class LetterCombinationsOfAPhoneNumber_017M {
    private Map<Character, List<Character>> numToLetterMap;

    LetterCombinationsOfAPhoneNumber_017M() {
        this.numToLetterMap = new HashMap<Character, List<Character>>();
        this.numToLetterMap.put('0', Arrays.asList('0'));
        this.numToLetterMap.put('1', Arrays.asList('1'));
        this.numToLetterMap.put('2', Arrays.asList('a', 'b', 'c'));
        this.numToLetterMap.put('3', Arrays.asList('d', 'e', 'f'));
        this.numToLetterMap.put('4', Arrays.asList('g', 'h', 'i'));
        this.numToLetterMap.put('5', Arrays.asList('j', 'k', 'l'));
        this.numToLetterMap.put('6', Arrays.asList('m', 'n', 'o'));
        this.numToLetterMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        this.numToLetterMap.put('8', Arrays.asList('t', 'u', 'v'));
        this.numToLetterMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    // This solution makes use of Java collection iterators for practice/fun. 
    public List<String> letterCombinations(String digits) {
        List<String> lastCombinations = new ArrayList<String>();
        List<String> currentCombinations;

        if (digits.isEmpty() == true) {
            return lastCombinations;
        }

        int index = 0;
        while (index < digits.length()) {
            currentCombinations = new ArrayList<String>();
            List<Character> letters = this.numToLetterMap.get(digits.charAt(index));
            Iterator<Character> iterateLetters = letters.iterator();

            while (iterateLetters.hasNext()) {
                Iterator<String> iterateLastCombinations = lastCombinations.iterator();
                Character c = iterateLetters.next();
                if (iterateLastCombinations.hasNext() == false) {       // The list of letter combos is empty so this must be the first digit processed
                    currentCombinations.add(c.toString());
                } else {
                    while (iterateLastCombinations.hasNext()) {         // Add this letter to each string of letter combos in the list
                        String s = iterateLastCombinations.next();
                        currentCombinations.add(s + c.toString());
                    }
                }
            }
            lastCombinations = currentCombinations;
            index ++;
        }
        return lastCombinations;
    }

    public void test() {
        System.out.println("Testing letterCombinations(String digits)...\n");

        String digits;
        List<String> result;

        digits = "23";
        result = this.letterCombinations(digits);
        System.out.println("Expected: [ad, bd, cd, ae, be, ce, af, bf, cf]");
        System.out.println("Output:   " + result);

        digits = "3227448";
        result = this.letterCombinations(digits);
        System.out.println("Expected: Too long to print");
        System.out.println("Output:   " + result);
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_017M solution = new LetterCombinationsOfAPhoneNumber_017M();
        solution.test();
    }
}
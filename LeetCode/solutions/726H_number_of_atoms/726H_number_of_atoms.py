# 726. Number of Atoms
# 
# Given a chemical formula (given as a string), return the count of each atom.
# 
# An atomic element always starts with an uppercase character, then zero or more 
# lowercase letters, representing the name.
# 
# 1 or more digits representing the count of that element may follow if the count 
# is greater than 1. If the count is 1, no digits will follow. For example, H2O 
# and H2O2 are possible, but H1O2 is impossible.
# 
# Two formulas concatenated together produce another formula. For example, 
# H2O2He3Mg4 is also a formula.
# 
# A formula placed in parentheses, and a count (optionally added) is also a 
# formula. For example, (H2O2) and (H2O2)3 are formulas.
# 
# Given a formula, output the count of all elements as a string in the following 
# form: the first name (in sorted order), followed by its count (if that count is 
# more than 1), followed by the second name (in sorted order), followed by its 
# count (if that count is more than 1), and so on.
# 
# Example 1:
# Input: 
# formula = "H2O"
# Output: "H2O"
# Explanation: 
# The count of elements are {'H': 2, 'O': 1}.
# 
# Example 2:
# Input: 
# formula = "Mg(OH)2"
# Output: "H2MgO2"
# Explanation: 
# The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
# 
# Example 3:
# Input: 
# formula = "K4(ON(SO3)2)2"
# Output: "K4N2O14S4"
# Explanation: 
# The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
# 
# Note:
# - All atom names consist of lowercase letters, except for the first character 
#     which is uppercase.
# - The length of formula will be in the range [1, 1000].
# - Formula will only consist of letters, digits, and round parentheses, and is a 
#     valid formula as defined in the problem.
#
# Companies asking this question: Google
# Topics: Hash table, stack, recursion
# Similar questions: Decode String, Encode String with Shortest Length, Parse Lisp Expression

class Solution(object):
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        if len(formula) == 0:
            return ''

        atoms = {}
        formulaCount = 1
        stack = [(formula, formulaCount)]

        while len(stack) > 0:
            (currentFormula, formulaCount) = stack.pop()
            index = 0

            while index < len(currentFormula):
                char = currentFormula[index]

                # Find the bounds of the 'subformula' in the currentFormula. Subformulas
                # are enclosed in '()' within the currentFormula. Once we have found
                # the bounds, put the subformula on the stack to process later.
                if char == '(':
                    parenCount = 1
                    rIndex = index
                    while parenCount > 0:
                        rIndex += 1
                        if currentFormula[rIndex] == '(':
                            parenCount += 1
                        elif currentFormula[rIndex] == ')':
                            parenCount -= 1
                        
                    subformula = currentFormula[index + 1:rIndex]
                    index = rIndex + 1

                    subformulaCount = 1
                    subformulaCountStr = ''
                    while index < len(currentFormula) and currentFormula[index].isdigit() == True:
                        subformulaCountStr += currentFormula[index]
                        index += 1
                    if len(subformulaCountStr) > 0:
                        subformulaCount = int(subformulaCountStr)

                    stack.append((subformula, subformulaCount * formulaCount))

                # Parse the next atom in the formula
                elif char.isupper():
                    atom = char
                    index += 1

                    while index < len(currentFormula) and currentFormula[index].islower() == True:
                        atom += currentFormula[index]
                        index += 1

                    atomCount = 1
                    atomCountStr = ''
                    while index < len(currentFormula) and currentFormula[index].isdigit() == True:
                        atomCountStr += currentFormula[index]
                        index += 1
                    if len(atomCountStr) > 0:
                        atomCount = int(atomCountStr)

                    if atom not in atoms:
                        atoms[atom] = (atomCount * formulaCount)
                    else:
                        atoms[atom] +=  (atomCount * formulaCount)
        
        atomsStr = ''
        for atom, count in iter(sorted(atoms.iteritems())):
            atomsStr += atom
            if count > 1:
                atomsStr += str(count)

        return atomsStr

def test():
    print('Testing countOfAtoms(self, formula)...\n')

    s = Solution()

    formula = 'H2O'
    result = s.countOfAtoms(formula)
    print('Expected:  H2O')
    print('Output:    ' + result + '\n')

    formula = 'Mg(OH)2'
    result = s.countOfAtoms(formula)
    print('Expected:  H2MgO2')
    print('Output:    ' + result + '\n')

    formula = 'K4(ON(SO3)2)2'
    result = s.countOfAtoms(formula)
    print('Expected:  K4N2O14S4')
    print('Output:    ' + result + '\n')

    formula = "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"
    result = s.countOfAtoms(formula)
    print('Expected:  B18900Be18984C4200H5446He1386Li33894N50106O22638')
    print('Output:    ' + result + '\n')

test()
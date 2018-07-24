# 399. Evaluate Division
#
# Equations are given in the format A / B = k, where A and B are variables 
# represented as strings, and k is a real number (floating point number). Given 
# some queries, return the answers. If the answer does not exist, return -1.0.
#
# Example:
#
# Given a / b = 2.0, b / c = 3.0. 
# queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
# return [6.0, 0.5, -1.0, 1.0, -1.0 ].
#
# The input is: vector<pair<string, string>> equations, vector<double>& values, 
# vector<pair<string, string>> queries , where equations.size() == values.size(), 
# and the values are positive. This represents the equations. Return vector<double>.
#
# According to the example above:
#
# equations = [ ["a", "b"], ["b", "c"] ],
# values = [2.0, 3.0],
# queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
#
# The input is always valid. You may assume that evaluating the queries will result 
# in no division by zero and there is no contradiction.
#
# Companies asking this question:
#   Google - Editor's choice: Frequently asked in Google onsite interview

import copy

class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        
        # We can represent this problem as a directed graph, where each variable in each
        # equation represents a vertex in the graph, and the equation's value is the weight on
        # the edge connecting the two vertices. Find a path in the graph connecting the verticies
        # in the query. The value of the query is equal to the product of the the graph edges
        # connecting the vertices.

        # Store each equation in a dictionary of dictionaries as:
        #   e.g. if equations[i] = A / B = 2.0, then vertexMap {A: {B: 2.0}, B: {A: 0.5}, etc...}
        # We will use this structure to find neighbors to a given node and the weight of the
        # edge connecting the nodes.

        vertexMap = {}
        for i in range(len(equations)):
            if equations[i][0] not in vertexMap:
                vertexMap[equations[i][0]] = {}
            vertexMap[equations[i][0]][equations[i][1]] = values[i] 
            vertexMap[equations[i][0]][equations[i][0]] = 1.0
            if equations[i][1] not in vertexMap:
                vertexMap[equations[i][1]] = {}
            vertexMap[equations[i][1]][equations[i][0]] = 1 / values[i] 
            vertexMap[equations[i][1]][equations[i][1]] = 1.0

        # For each query (X / Y = ?), find the path from the starting vertex (let's call this X) to the end vertex 
        # (let's call this Y) in the graph. The product of the edge weights from X to Y is equal to 
        # the query value we are calculating. Add this product to the results list, or -1
        # if no path exists.
        results = []
        resultPath = []

        for i in range(0, len(queries)):
            if (queries[i][0] not in vertexMap) or (queries[i][1] not in vertexMap):
                results.append(-1)
                continue

            qBFS = []
            qBFS.append({ 'path': [ queries[i][0] ], 'neighbors': vertexMap[queries[i][0]].keys() })
            unvisitedVertex = set(vertexMap.keys())
            unvisitedVertex.remove(queries[i][0])

            while len(qBFS) != 0:
                currentVertex = qBFS.pop(0)
                pathLen = len(currentVertex['path'])
                if currentVertex['path'][pathLen - 1] == queries[i][1]:
                    resultPath = copy.copy(currentVertex['path'])
                for neighbor in currentVertex['neighbors']:
                    if neighbor in unvisitedVertex:
                        unvisitedVertex.remove(neighbor)
                        nextVertex = copy.deepcopy(currentVertex)
                        nextVertex['path'].append(neighbor)
                        nextVertex['neighbors'] = vertexMap[neighbor].keys()
                        qBFS.append(nextVertex)
        
            # Check if we found a path from X -> Y. If we found a path, traverse the path 
            # and calculate the product of the edge weights. Otherwise the result is -1.
            if (len(resultPath) == 0):
                results.append(-1)
            else:
                result = 1.0
                for j in range(1, len(resultPath)):
                    result *= vertexMap[resultPath[j - 1]][resultPath[j]]
                results.append(result)

        return results

def test():
    print('Testing calcEquation(equations, values, queries)...\n')
    
    s = Solution();

    equations = [ ["a", "b"], ["b", "c"] ]
    values = [2.0, 3.0]
    queries = [ ["b", "a"] ]
    result = s.calcEquation(equations, values, queries)
    print('Expected:  [0.5]')
    print('Output:    ' + str(result) + '\n')

    equations = [ ["a", "b"], ["b", "c"] ]
    values = [2.0, 3.0]
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]
    result = s.calcEquation(equations, values, queries)
    print('Expected:  [6.0, 0.5, -1.0, 1.0, -1.0 ]')
    print('Output:    ' + str(result) + '\n')

    equations = [["a", "b"],["c", "d"]]
    values = [1.0, 1.0]
    queries = [["a", "c"], ["b", "d"], ["b", "a"], ["d", "c"]]
    result = s.calcEquation(equations, values, queries)
    print('Expected:  [-1.0, -1.0, 1.0, 1.0]')
    print('Output:    ' + str(result) + '\n')

test()
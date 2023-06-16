package com.D4_Recursion_Backtraking;

public class Q13_M_ColoringProblem {
    public static void main(String[] args) {

    }
    static boolean isPossible(boolean[][] graph, int[] color, int node, int col, int n) {
        for(int i = 0; i < n; i++) {
            //if it is connected to another node and both colors are same
            if(graph[node][i] && color[i] == col) {
                return false;
            }
        }
        return true;
    }
    static boolean solve(int node, boolean[][] graph, int[] color, int m, int n) {
        // if all nodes all color
        if(node == n) return true;
        // color this current node with all posibile colors
        for(int i = 1; i <= m; i++) {
            // check whether it can be filled by color i ?
            if(isPossible(graph, color, node, i, n)) {
                // if possible then color it
                color[node] = i;
                // color to the next node
                if(solve(node + 1, graph, color, m, n)) return true;
                color[node] = 0;
            }
        }
        //if any one node are not coloured by 1 to m colors
        return false;
    }
    static boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        return solve(0, graph, color, m, n);
    }
}

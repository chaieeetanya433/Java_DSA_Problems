import java.util.*;

public class Solution {
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for(int i=0; i<V; i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            //node is in topo sort
            //so need to remove it from indegree

            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }

    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<dictionary.length-1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr<len; ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(k, adj);
        String ans = "";
        for(int it: topo) {
            ans = ans+(char)(it + (int)('a'));
        }
        return ans;
    }
}

/*
Time Complexity:

Constructing the Graph (adj):

Iterating through the dictionary requires going through each character of each word, which takes O(N), where N is the total number of characters in the dictionary.
Constructing the adjacency list (adj) involves adding edges between vertices based on the differing characters, which also takes O(N).
Topological Sorting:

The topological sorting process uses BFS and processes each vertex and edge once, resulting in O(V + E), where V is the number of vertices (k in this case) and E is the number of edges.
The overall time complexity is O(N + V + E), where N is the total number of characters in the dictionary.

Space Complexity:

adj (Adjacency List):

The space required for storing the adjacency list is O(V + E), where V is the number of vertices (k in this case) and E is the number of edges.
indegree array:

An array to store in-degrees for each vertex, requiring O(V) space.
q (Queue):

The queue used in the topological sorting process, requiring O(V) space in the worst case.
topo (Topological Order List):

The list to store the topological order, requiring O(V) space.
The overall space complexity is O(V + E).
*/

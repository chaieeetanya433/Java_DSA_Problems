import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int findTheCity(int n, ArrayList<ArrayList<Integer>> edges, int distanceThreshold) {
		// Write your code here
		int[][] dist = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		int m = edges.get(0).size();

		for(int i=0; i<m; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			int wt = edges.get(i).get(2);
			dist[u][v] = wt;
			dist[u][v] = wt;
		}

		for(int i=0; i<n; i++) dist[i][i] = 0;
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int cntCity = n;
		int cityNo = -1;
		for(int city=0; city<n; city++) {
			int cnt = 0;
			for(int adjCity = 0; adjCity < n; adjCity++) {
				if(dist[city][adjCity] <= distanceThreshold) cnt++;
			}

			if(cnt <= cntCity) {
				cntCity = cnt;
				cityNo = city;
			}
		}
		return cityNo;
	}
}

/*
Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.

Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.
*/
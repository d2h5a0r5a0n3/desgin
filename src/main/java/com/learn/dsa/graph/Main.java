package com.learn.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.bfs(sol.dummyAdj(), 5));
		System.out.println(sol.dfs(sol.dummyAdj(), 5));
	}
}

class Solution {
	public List<List<Integer>> dummyAdj() {
		List<List<Integer>> list = new ArrayList<>();
		//   1---2 \
		//   |   |  5
		//   3---4 /
		list.add(new ArrayList<>());
		list.add(new ArrayList<>(List.of(2, 3)));
		list.add(new ArrayList<>(List.of(1, 4, 5)));
		list.add(new ArrayList<>(List.of(1, 4)));
		list.add(new ArrayList<>(List.of(2, 3, 5)));
		list.add(new ArrayList<>(List.of(2, 4)));

		return list;
	}

	public List<Integer> bfs(List<List<Integer>> adj, Integer startNode) {
		List<Integer> bfs = new ArrayList<>();
		int v = adj.size();
		boolean[] vis = new boolean[v];
		Queue<Integer> q = new LinkedList<>();


		q.add(startNode);
		vis[startNode] = true;

		while (!q.isEmpty()) {
			Integer node = q.poll();
			bfs.add(node);

			for (Integer iNode : adj.get(node)) {
				if (!vis[iNode]) {
					q.add(iNode);
					vis[iNode] = true;
				}
			}
		}

		return bfs;
	}

	public List<Integer> dfs(List<List<Integer>> adj, Integer startNode) {
		List<Integer> dfs = new ArrayList<>();
		int v = adj.size();
		boolean[] vis = new boolean[v];
		vis[startNode] = true;
		dfs(startNode, vis, adj, dfs);
		return dfs;
	}

	private void dfs(Integer node, boolean[] vis, List<List<Integer>> adj, List<Integer> list) {
		vis[node] = true;
		list.add(node);
		for (Integer iNode : adj.get(node)) {
			if (!vis[iNode]) {
				dfs(iNode, vis, adj, list);
			}
		}
	}
}

package com.learn.dsa.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
	public static void main(String[] args) {
		int n = 5, m = 6;
		int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		List<Integer> ans = Solution.shortestPath(n, m, edges);
		ans.forEach(System.out::println);
	}
}

class Solution {
	public static List<Integer> shortestPath(int n, int m, int[][] edges) {
		List<List<Node>> adj = adjList(n+1,edges);
		PriorityQueue<Node> pq = new PriorityQueue<>(getComparator());
		int[] dist = new int[n+1];
		int[] parent = new int[n+1];
		List<Integer> ans = new ArrayList<>();
		Arrays.fill(dist,Integer.MAX_VALUE);
		for (int i = 0; i < n+1; i++) parent[i] = i;

		dist[1] = 0;
		pq.add(new Node(1,0));

		while(!pq.isEmpty()){
			Node node = pq.poll();
			if(dist[node.item] < node.dist) continue;
			for(Node next:adj.get(node.item)){
				int distance = node.dist + next.dist;
				if(distance < dist[next.item]){
					dist[next.item] = distance;
					pq.add(new Node(next.item,distance));
					parent[next.item] = node.item;
				}
			}
		}

		int idx = n;
		while(parent[idx] != idx){
			ans.add(idx);
			idx = parent[idx];
		}
		ans.add(1);
		Collections.reverse(ans);
		return ans;
	}

	private static Comparator<Node> getComparator() {
		return (a, b) -> {
			if (a.dist == b.dist)
				return a.item - b.item;
			return a.dist - b.dist;
		};
	}

	private static List<List<Node>> adjList(int V, int[][] edges) {
		List<List<Node>> list = new ArrayList<>();
		for (int i = 0; i < V; i++)
			list.add(new ArrayList<>());
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int d = edge[2];
			list.get(u)
					.add(new Node(v, d));
			list.get(v)
					.add(new Node(u, d));
		}
		return list;
	}

	private static class Node {
		int item;
		int dist;

		Node(int item, int dist) {
			this.item = item;
			this.dist = dist;
		}
	}
}
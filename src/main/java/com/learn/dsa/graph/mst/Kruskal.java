package com.learn.dsa.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
	public int spanningTree(int V, int[][] edges) {
		List<Node> list = new ArrayList<>();

		for (int[] edge : edges) {
			list.add(new Node(edge[0], edge[1], edge[2]));
		}
		Collections.sort(list,getComparator());

		DisjointSet ds = new DisjointSet(V);
		int wt = 0;
		for(Node node:list){
			if(ds.findParent(node.u) != ds.findParent(node.v)){
				wt += node.wt;
				ds.unionByRank(node.u,node.v);
			}
		}
		return wt;
	}

	private static Comparator<Node> getComparator() {
		return (a, b) -> {
			return a.wt - b.wt;
		};
	}



	private static class Node {
		int u;
		int v;
		int wt;

		Node(int u,int v, int wt) {
			this.v = v;
			this.u= u;
			this.wt = wt;
		}
	}
}


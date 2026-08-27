package com.learn.dsa.graph.mst;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	List<Integer> parent = new ArrayList<>();
	List<Integer> rank = new ArrayList<>();

	DisjointSet(int n){
		for(int i=0;i<=n;i++){
			parent.add(i);
			rank.add(0);
		}
	}

	public int findParent(int node){
		if(node == parent.get(node)) return node;
		int ultimateParent = findParent(parent.get(node));
		parent.set(node, ultimateParent);
		return parent.get(node);
	}

	public void unionByRank(int u, int v){
		int ultimateParentU = findParent(u);
		int ultimateParentV = findParent(v);
		if(ultimateParentU == ultimateParentV) return;
		if(rank.get(ultimateParentU) > rank.get(ultimateParentV)){
			parent.set(ultimateParentV, ultimateParentU);
		} else if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
			parent.set(ultimateParentU, ultimateParentV);
		} else{
			parent.set(ultimateParentU,ultimateParentV);
			int rankV = rank.get(ultimateParentV);
			rank.set(ultimateParentV,rankV+1);
		}
	}
}

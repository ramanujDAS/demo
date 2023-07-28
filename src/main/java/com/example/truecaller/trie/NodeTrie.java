package com.example.truecaller.trie;

import java.util.Arrays;

public  class NodeTrie {
    public static final int alphabetSize=256;
    private char character;
    private NodeTrie[] children;
    private boolean isLeaf;
    private boolean isVisited;

   public NodeTrie(char character)
   {
       this.character=character;
       children= new NodeTrie[alphabetSize];
   }
   public void setChild(int index,NodeTrie node)
   {
       children[index]=node;
   }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public NodeTrie[] getChildren() {
        return children;
    }

    public void setChildren(NodeTrie[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    @Override
    public String toString() {
        return "NodeTrie{" +
                "character=" + character +
                ", children=" + Arrays.toString(children) +
                ", isLeaf=" + isLeaf +
                ", isVisited=" + isVisited +
                '}';
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public NodeTrie getChild(int  index){
       return children[index];
    }
}

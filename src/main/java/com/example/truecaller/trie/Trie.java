package com.example.truecaller.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private NodeTrie root;

    public Trie(NodeTrie node) {
        this.root = node;
    }
    public void insert(String word){
       NodeTrie tempNode=root;
       for (int i = 0; i < word.length(); i++) {
           int indexAscii = word.charAt(i);
            if(tempNode.getChild(indexAscii)==null)
            {
              NodeTrie node= new NodeTrie((char)indexAscii);
              tempNode.setChild(indexAscii,node);
              tempNode=tempNode.getChild(indexAscii);
            }else{
                tempNode=tempNode.getChild(indexAscii);
            }
       }

      tempNode.setLeaf(true);
   }

    public boolean search(String word) {
        NodeTrie tempNode = root;
        for (int i = 0; i < word.length(); i++) {
            int indexAscii = word.charAt(i);
            if (tempNode.getChild(indexAscii) == null) return false;
            tempNode = tempNode.getChild(indexAscii);
        }
        return true;
    }
   public List<String> getWordWithPrefix(String prefix)
   {
       NodeTrie tempNode = root;
       List<String> stringList = new ArrayList<>();

       for (int i = 0; i < prefix.length(); i++) {
           int indexAscii = prefix.charAt(i);
           if (tempNode.getChild(indexAscii) == null) continue;

           tempNode = tempNode.getChild(indexAscii);
       }

       addSuffix(tempNode,prefix ,stringList);
       return stringList;
   }
    private void addSuffix(NodeTrie trieNode, String prefix, List<String> allWords) {
        if (trieNode == null) return;
        if (trieNode.isLeaf()) {
            allWords.add(prefix);
        }
        for (NodeTrie childTrieNode : trieNode.getChildren()) {
            if (childTrieNode == null) continue;
            char childCharacter = childTrieNode.getCharacter();
            addSuffix(childTrieNode, prefix + childCharacter, allWords);
        }
    }
}
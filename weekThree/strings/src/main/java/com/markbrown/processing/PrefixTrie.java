package com.markbrown.processing;

/**
 * Simplifying assumption: case-insensitive
 */
public class PrefixTrie {

    private class TrieNode {

        private TrieNode[] alphabet;
        private boolean isWordEnd;

        public TrieNode() {
            this.alphabet = new TrieNode[radix];
            this.isWordEnd = false;
        }

    }

    private static final int radix = 26;
    private TrieNode root;

    public PrefixTrie() {
        root = new TrieNode();
    }

    public boolean search(String input) {

        int i = -1;
        TrieNode node = root;

        while (node != null) {
            i++;
            if (i >= input.length() && node.isWordEnd) return true;
            else if (i >= input.length()) return false;
            else {
                int index = input.charAt(i) - 'a';
                node = node.alphabet[index];
            }
        }
        return false;

    }

    public void insert(String input) {
        insert(input, root);
    }

    private void insert(String input, TrieNode node) {
        int index = input.charAt(0) - 'a';
        if (input.length() <= 1) {
            if (node.alphabet[index] == null) node.alphabet[index] = new TrieNode();
            node.alphabet[index].isWordEnd = true;
            return;
        } else {
            if (node.alphabet[index] == null) {
                node.alphabet[index] = new TrieNode();
            }
            insert(input.substring(1, input.length()), node.alphabet[index]);
        }
    }

}
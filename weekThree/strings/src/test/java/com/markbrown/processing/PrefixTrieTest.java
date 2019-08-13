package com.markbrown.processing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrefixTrieTest {

    @Test
    public void testTrie() {

        // Setup
        PrefixTrie trie = new PrefixTrie();

        // Testing
        trie.insert("their");
        trie.insert("there");
        trie.insert("answer");
        trie.insert("any");
        trie.insert("bye");
        trie.insert("baby");

        assertTrue(trie.search("their"));
        assertFalse(trie.search("theire"));
        assertFalse(trie.search("thiir"));
     
        assertTrue(trie.search("there"));
        assertFalse(trie.search("the"));

        assertTrue(trie.search("answer"));
        assertFalse(trie.search("answed"));
        assertFalse(trie.search("answ"));

        assertTrue(trie.search("any"));
        assertFalse(trie.search("ane"));
        assertFalse(trie.search("anyy"));

        assertTrue(trie.search("bye"));
        assertFalse(trie.search("by"));
        assertFalse(trie.search("byee"));

        assertTrue(trie.search("baby"));
        assertFalse(trie.search("babe"));
        assertFalse(trie.search("bab"));
    }

}
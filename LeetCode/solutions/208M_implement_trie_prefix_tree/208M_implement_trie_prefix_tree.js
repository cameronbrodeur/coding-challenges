// 208. Implement Trie (Prefix Tree)
//
// Implement a trie with insert, search, and startsWith methods.
//
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

/**
 * A single character node in the Trie data structure
 */
var TrieNode = function(char) {
    this.char = char;
    this.isLeaf = false;
    this.children = {};
};

/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.root = new TrieNode(null);
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    if (word.length === 0) {
        return;
    }

    let runner = this.root;
    for (let i = 0; i < word.length; i++) {
        if (word[i] in runner.children) {
            runner = runner.children[word[i]];
        } else {
            var node = new TrieNode(word[i]);
            runner.children[word[i]] = node;
            runner = runner.children[word[i]];
        }
    }

    runner.isLeaf = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    if (word.length === 0) {
        return false;
    }

    let runner = this.root;
    let i = 0;
    while ((word[i] in runner.children) && (i < word.length)) {
        runner = runner.children[word[i]];
        i++;
    }

    if ((i === word.length) && (runner.isLeaf === true)) {
        return true;
    } else {
        return false;
    }
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    if (prefix.length === 0) {
        return false;
    }

    let runner = this.root;
    let i = 0;
    while ((prefix[i] in runner.children) && (i < prefix.length)) {
        runner = runner.children[prefix[i]];
        i++;
    }

    if (i === prefix.length) {
        return true;
    } else {
        return false;
    }
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie();
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

function test() {
    console.log("Testing implementation of Trie...\n");

    let word, result;
    let obj = new Trie();

    obj.insert('hello');

    obj.insert('world');

    obj.insert('worlds');

    obj.insert('');

    result = obj.search('world');
    console.log('Expected: true');
    console.log('Output:   ' + result);

    result = obj.search('worl');
    console.log('Expected: false');
    console.log('Output:   ' + result);

    result = obj.search('worldly');
    console.log('Expected: false');
    console.log('Output:   ' + result);

    result = obj.startsWith('worl');
    console.log('Expected: true');
    console.log('Output:   ' + result);

    result = obj.startsWith('word');
    console.log('Expected: false');
    console.log('Output:   ' + result);

    result = obj.startsWith('a');
    console.log('Expected: false');
    console.log('Output:   ' + result);
}

test();
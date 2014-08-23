BuildTree
==========

BuildTree is an academic exercise that builds trees out of node relations.

* Assumptions: 
** Considering the tree has n nodes, to build a valid tree, the number of relations passed must be n-1. 
** All node values must go in one and only on of the relations passed as the child node, except the root node.
** In all relations, a node value must not appear more than twice as a parent. i.e. The 
** The tree is complete with no isolated subtrees.
** values are [1 .. n].

* Approach: The constructTree() method creates an array for all the nodes. Then it is just a matter of going through all relations to build the tree adding relations.

* Complexity:
The time complexity of generating a tree is O(n), because it is linear on the number of relations.

* Structures: 
** Node. Represents a node in the tree. A tree is just a reference to the root node,

License
=======

Apache License, Version 2.0.

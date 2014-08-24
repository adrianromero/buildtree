BuildTree
==========

BuildTree is an academic exercise that builds trees out of node relations.

The following call:

```
Node tree = BuildTree.reconstructTree(
        new int[]{2, 4},
        new int[]{1, 2},
        new int[]{3, 6},
        new int[]{1, 3},
        new int[]{2, 5});
```

Generates the following tree

```
        1
     2     3
    4 5   6
```

Assumptions
-----------

* Considering the tree has n nodes, the number of relations passed must be n-1. 
* Node values are [1 .. n].
* All node values must go in one and only on of the relations passed as the child node, except the root node.
* In all relations, a node value must not appear more than twice as a parent.
* The method assumes the relations passed builds a valid tree.

Approach
--------

The `reconstructTree()` method creates first creates an array for all the nodes based on the number of relations, then it is just a matter of going through all relations to build the tree adding relations. To find the root node, when a new relation is added, if the root node has not been initalized or the current root node is equals to the child node of the new relation added, the current root node is updated with the parent of the new relation added.

Complexity
----------

The time complexity of generating a tree is O(n), because it is linear on the number of relations.

Structures
----------

Node. Represents a node in the tree. It contains the node value, a reference to the left child and a reference to the right child. A tree is represented as a reference to the root node of the tree.

License
=======

Apache License, Version 2.0.

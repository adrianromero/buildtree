BuildTree
==========

BuildTree is an academic exercise that builds trees out of node relations.

* Approach: The BuilderTree class contains a Map with all the nodes of the tree and a reference to the root or one of the root nodes at any moment. When a relation of this tree is added: a parent and a child, Both nodes are search in the Map and the relation is established. The reference to the root node is updated to the parent node if the child node was the previous root node.

* Complexity: If not considering the use of a hash map for storing nodes, the complexity of adding a new relation is constant O(1), because it does not depend on the number of nodes previously added.

* Structures: Node. Represents a node in the tree. BuildTree.Relation. Represents a relation between nodes.

License
=======

Apache License, Version 2.0.

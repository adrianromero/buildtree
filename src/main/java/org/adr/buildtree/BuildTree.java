//    BuildTree is an academic exercise that builds trees out of node relations.
//    Copyright (C) 2014 Adrián Romero Corchado.
//
//    This file is part of Data BuildTree
//
//     Licensed under the Apache License, Version 2.0 (the "License");
//     you may not use this file except in compliance with the License.
//     You may obtain a copy of the License at
//     
//         http://www.apache.org/licenses/LICENSE-2.0
//     
//     Unless required by applicable law or agreed to in writing, software
//     distributed under the License is distributed on an "AS IS" BASIS,
//     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//     See the License for the specific language governing permissions and
//     limitations under the License.

package org.adr.buildtree;

/**
 *
 * @author adrian
 */
public class BuildTree {

    public static Node reconstructTree(Relation... relations) throws BuildTreeException {

        // Create initial structure
        Node[] all = new Node[relations.length + 1];
        int root = 0;
        for (int i = 0; i < all.length; i++) {
            all[i] = new Node(i + 1);
        }

        // Build tree
        for (Relation r : relations) {

            // Sanity check for input
            if (r.getParent() <= 0 || r.getParent() > all.length
                    || r.getChild() < 0 || r.getChild() > all.length) {
                throw new BuildTreeException("Relation nodes does not exist in tree.");
            }

            // assign a new root
            if (root == 0 || r.getChild() == root) {
                root = r.getParent();
            }

            Node parentNode = all[r.getParent() - 1];

            if (parentNode.getChild1() == null) {
                parentNode.setChild1(all[r.getChild() - 1]);
            } else if (parentNode.getChild2() == null) {
                parentNode.setChild2(all[r.getChild() - 1]);
            } else {
                throw new BuildTreeException("Nodes cannot have more than two children.");
            }
        }

        if (root == 0) {
            throw new BuildTreeException("Tree has no nodes.");
        }

        return all[root - 1];
    }

    public static class Relation {

        private final int parent;
        private final int child;

        public Relation(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }

        public int getParent() {
            return parent;
        }

        public int getChild() {
            return child;
        }
    }
}

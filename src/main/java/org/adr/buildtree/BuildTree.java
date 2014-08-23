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

    public static Node reconstructTree(int[] ... relations) {

        // Create initial structure
        Node[] all = new Node[relations.length + 1];
        int root = 0;
        for (int i = 0; i < all.length; i++) {
            all[i] = new Node(i + 1);
        }

        // Build tree
        for (int[] r : relations) {

            // assign a new root
            if (root == 0 || r[1] == root) {
                root = r[0];
            }

            Node parentNode = all[r[0] - 1];

            if (parentNode.getChild1() == null) {
                parentNode.setChild1(all[r[1] - 1]);
            } else if (parentNode.getChild2() == null) {
                parentNode.setChild2(all[r[1] - 1]);
            }
        }

        return all[root - 1];
    }
}

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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adrian
 */
public class BuildTree {

    private final Map<Integer, Node> allnodes = new HashMap<Integer, Node>();
    private Node root = null;

    public static Node reconstructTree(Relation... relations) throws BuildTreeException {
        
        BuildTree builder = new BuildTree();
        for (Relation r : relations) {
            builder.addRelation(r.getParent(), r.getChild());            
        }
        return builder.getRoot();
    }

    public Node getRoot() {
        return root;
    }

    public void addRelation(int parent, int child) throws BuildTreeException {
        
        Node parentNode = findNode(parent);
        Node childNode = findNode(child);
        
        if (root == null || childNode == root) {
            root = parentNode;
        }
        
        if (parentNode.getChild1() == null) {
            parentNode.setChild1(childNode);
            return;
        }
        
        if (parentNode.getChild2() == null) {
            parentNode.setChild2(childNode);
            return;
        }
        
        throw new BuildTreeException("Nodes cannot have more than two children.");  
    }
    
    private Node findNode(int value) {
        Node n = allnodes.get(value);
        if (n == null) {
            n = new Node(value);
            allnodes.put(value, n);
        }
        return n;
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

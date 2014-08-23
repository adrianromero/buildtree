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

import java.util.Objects;

/**
 *
 * @author adrian
 */
public class Node {

    private final int value;

    private Node child1;
    private Node child2;

    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node child1, Node child2) {
        this.value = value;
        this.child1 = child1;
        this.child2 = child2;
    }

    public int getValue() {
        return value;
    }

    public Node getChild1() {
        return child1;
    }

    public void setChild1(Node child1) {
        this.child1 = child1;
    }

    public Node getChild2() {
        return child2;
    }

    public void setChild2(Node child2) {
        this.child2 = child2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.child1, other.child1)) {
            return false;
        }
        if (!Objects.equals(this.child2, other.child2)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.value;
        hash = 17 * hash + Objects.hashCode(this.child1);
        hash = 17 * hash + Objects.hashCode(this.child2);
        return hash;
    }

    @Override
    public String toString() {
        String str1 = child1 == null ? "_" : child1.toString();
        String str2 = child2 == null ? "_" : child2.toString();
        
        return (Integer.toString(value) + "("  + str1 + ", " + str2 + ")");
    }
}

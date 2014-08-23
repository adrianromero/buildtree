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

package org.adr.buildtree.test;

import junit.framework.Assert;
import org.adr.buildtree.BuildTree;
import org.adr.buildtree.BuildTreeException;
import org.adr.buildtree.Node;
import org.junit.Test;

/**
 *
 * @author adrian
 */
public class SampleTest {

    @Test
    public void buildSampleTree() throws BuildTreeException {
        
        // Build the tree using BuildTree
        BuildTree builder = new BuildTree();
        builder.addRelation(2, 4);
        builder.addRelation(1, 2);
        builder.addRelation(3, 6);
        builder.addRelation(1, 3);
        builder.addRelation(2, 5);
        Node tree = builder.getRoot();
        
        Assert.assertEquals(getExpectedTree(), tree);
    }
    
    @Test
    public void buildSampleTree2() throws BuildTreeException {
        
        // Build the tree using BuildTree static method
        Node tree = BuildTree.reconstructTree(
                new BuildTree.Relation(2, 4),
                new BuildTree.Relation(1, 2),
                new BuildTree.Relation(3, 6),
                new BuildTree.Relation(1, 3),
                new BuildTree.Relation(2, 5));
        
        Assert.assertEquals(getExpectedTree(), tree);
    }
    
    private Node getExpectedTree() {
        return new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), null));
    }
}

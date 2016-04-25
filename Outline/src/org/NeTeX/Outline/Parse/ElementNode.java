/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.NeTeX.Outline.Parse;
import javax.swing.tree.DefaultMutableTreeNode;
import org.NeTeX.Outline.Parse.ElementBean;
/**
 *
 * @author Jeremy
 */
public class ElementNode extends DefaultMutableTreeNode {
    private ElementBean element;
    
    ElementNode(ElementBean bean){
        this.element = bean;
    }
    
    public String getDescription(){
        return this.element.toString();
    }
}



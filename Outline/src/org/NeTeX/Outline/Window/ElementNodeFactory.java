/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.NeTeX.Outline.Window;

import org.NeTeX.Outline.Parse.ParserUtilities;

/**
 *
 * @author Jeremy
 */
public class ElementNodeFactory {
    
    public ElementNode createNode(String value, String name, int start, boolean complete){
        ElementNode.ElementType type = ParserUtilities.getEnumValue(value);
        ElementNode element = new ElementNode(type, name, start, complete);
        return element;
    }
}

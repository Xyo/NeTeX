/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.NeTeX.Outline.Parse;
/**
 *
 * @author Jeremy
 */
public class ElementBean implements Comparable {
    public enum ElementType{
        PART, CHAPTER, SECTION, SUBSECTION, SUBSUBSECTION, PARAGRAPH, 
        SUBPARAGRAPH, DESCRIPTION, FIGURE, LIST, TABLE
    }
    
    private ElementType type;
    private String name;
    private Integer start;
    private Integer end;
    private boolean complete = false;
    
    
    ElementBean(ElementType type, String name, int start, boolean complete ) {
        this.type = type;
        this.name = name;
        this.start = (Integer)start;
        this.complete = complete;
    }
    
    
    @Override
    public int compareTo(Object other) {
        if( !(other instanceof ElementBean) ) return 0;
        return this.start.compareTo( ((ElementBean)other).getStart() );
    }
    
    @Override
    public boolean equals(Object seg) {
        if( seg == null || !(seg instanceof ElementNode) ) return false;
        
        return this.start == ((ElementBean)seg).getStart();
    }

    @Override
    public String toString(){
        return name + ": " + start + " - " + end + "\t(" + complete + ")";
    }


    
    // Getters and Setters
    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
    
    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}



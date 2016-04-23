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
public class ElementBean {
    
    public enum ElementType{
    SECTION, SUBSECTION, SUBSUBSECTION, PARAGRAPH, SUBPARAGRAPH
    }
    
    private String type;
    private String name;
    private Integer start;
    private Integer end;
    private boolean complete;
    private ElementType type;
    
    ElementBean(String name, ElementType type, int start ){
        this.name = name;
        this.name = name;
        this.start = (Integer)start;
        this.type = type;
    }    
    
    
    @Override
    public int compareTo(Object seg) {
        return this.start.compareTo( (((ElementBean)seg).getStart()) );
    }
    
    @Override
    public boolean equals(Object seg) {
        if( seg == null || !(seg instanceof ElementBean) ) return false;
        
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
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
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

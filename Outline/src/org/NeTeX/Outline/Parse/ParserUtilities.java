/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.NeTeX.Outline.Parse;

/**
 * Created by Jeremy on 4/18/16.
 */

public class ParserUtilities {

    public static boolean partFound( String line ){
        if( line.contains("\\part")
                || line.contains("\\chapter")
                || line.contains("\\section")
                || line.contains("\\subsection")
                || line.contains("\\subsubsection")
                || line.contains("\\paragraph")
                || line.contains("\\subparagraph")
//                || line.contains("\\backmatter")
//                || line.contains("\\frontmatter")
//                || line.contains("\\appendix")
//                || line.contains("\\backmatter")
//                || line.contains("\\appendix")
//                || line.contains("\\closing")
//                || line.contains("\\glossary{")
//                || line.contains("\\end{")
//                || line.contains("\\bibliography{")
                || beginFound(line)     ){

            return true;
        }
        return false;
    }

    public static boolean beginFound( String line ){
        if( line.contains("\\begin{description}")
                || line.contains("\\begin{document}")
                || line.contains("\\begin{figure")
                || line.contains("begin{list}")
                || line.contains("begin{table")
                || line.contains("begin{titlepage") ){
            return true;
        }
        return false;
    }
    
    public static boolean isEndingElement( String element ){
        if( element.contains("\\end")) return true;
        return false;
    }

    public static boolean isStartingElement( String element ){
        if( element.contains("\\begin") ) return true;
        return false;
    }

    public static String parseName(String line){
        
        int start = line.indexOf("{") + 1;
        int end = line.indexOf("}") - 1;
        return line.substring( start, end );
    }
    
    public static String parseType(String line) throws IllegalArgumentException {
        if( beginFound(line) ) throw new IllegalArgumentException(line + "is not a type");
        int start = line.indexOf("/") + 1;
        int end = line.indexOf("{") - 1;
        return line.substring( start, end );
    }

    public static ElementBean.ElementType getEnumValue(String value){
        String type = value.toUpperCase();
        switch(type){
            case("PART"):
                return ElementBean.ElementType.PART;
            case("CHAPTER"):
                return ElementBean.ElementType.CHAPTER;
            case("SECTION"):
                return ElementBean.ElementType.SECTION;
            case("SUBSECTION"):
                return ElementBean.ElementType.SUBSECTION;
            case("SUBSUBSECTION"):
                return ElementBean.ElementType.SUBSUBSECTION;
            case("PARAGRAPH"):
                return ElementBean.ElementType.PARAGRAPH;
            case("SUBPARAGRAPH"):
                return ElementBean.ElementType.SUBPARAGRAPH;
            case("FIGURE"):
                return ElementBean.ElementType.FIGURE;
            case("LIST"):
                return ElementBean.ElementType.LIST;
            case("TABLE"):
                return ElementBean.ElementType.TABLE;
            
                
        }
        throw new IllegalArgumentException(value + " is not a supported type");
    }
}

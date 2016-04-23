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
        int end = line.indexOf("}") + 1;

        return line.substring( start, end );
    }

    public static ElementNode.ElementType getEnumValue(String value){
        String type = value.toUpperCase();
        switch(type){
            case("PART"):
                return ElementNode.ElementType.PART;
            case("CHAPTER"):
                return ElementNode.ElementType.CHAPTER;
            case("SECTION"):
                return ElementNode.ElementType.SECTION;
            case("SUBSECTION"):
                return ElementNode.ElementType.SUBSECTION;
            case("SUBSUBSECTION"):
                return ElementNode.ElementType.SUBSUBSECTION;
            case("PARAGRAPH"):
                return ElementNode.ElementType.PARAGRAPH;
            case("SUBPARAGRAPH"):
                return ElementNode.ElementType.SUBPARAGRAPH;
            case("FIGURE"):
                return ElementNode.ElementType.FIGURE;
            case("LIST"):
                return ElementNode.ElementType.LIST;
            case("TABLE"):
                return ElementNode.ElementType.TABLE;
            
                
        }
        throw new IllegalArgumentException(value + " is not a supported type");
    }
}

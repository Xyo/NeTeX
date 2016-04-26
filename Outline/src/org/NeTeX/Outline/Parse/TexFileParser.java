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

import java.io.*;

public class TexFileParser {
    private TexFile doc;
    private BufferedReader br;
    private int lineCounter = 0;

    TexFileParser( TexFile doc ) throws FileNotFoundException {
        if( doc == null ) throw new FileNotFoundException( "The file " + doc.getFilePath() + " is missing" );
        this.doc = doc;
    }
    
    public ElementNode newNode(String type, String name, int start, boolean complete) throws IllegalArgumentException {
        ElementNodeFactory factory = new ElementNodeFactory();
        ElementNode newNode = factory.createNode(type, name, start, complete);
        if( newNode == null ) throw new IllegalArgumentException("Invalid paramaters here... " + type + name + start + complete );
        return newNode;
    }
 
    // parses the tex file to build the tree structure
    public void beginParse() {
        
        try( BufferedReader br = 
                new BufferedReader(new FileReader(doc.getFilePath()))   ){

            String documentClass = getDocClass(br);

            // todo: get ending line now, or set ending line when next section is added to tree?
            // check if the line contains an important element
            String line = nextLine(br);
            if( ParserUtilities.partFound(line) ){
                String name = ParserUtilities.parseName(line);

                if( ParserUtilities.isStartingElement(line) ){
                }else if( ParserUtilities.isEndingElement(line) ){
                }
            }
        }catch( IOException e ){}  
    }
    


    //get document class type to name tex tree
    public String getDocClass(BufferedReader br) throws IOException {
        String line = "";
        do{
            ++lineCounter;
            br.readLine();
        }while(!line.contains("\\documentclass{"));
        // parse name between { }
        return ParserUtilities.parseName(line);
    }

    // get end of preamble (and beginning of doc)
    public void toBeginOfDoc( BufferedReader br ) throws IOException {
        String line = "";
        do{
            ++lineCounter;
            br.readLine();
        }while(!line.contains("\\documentclass{"));
    }
    
    // Gets the next non-empty line in the document
    public String nextLine( BufferedReader br ) throws IOException {
        String line;
        do{
            line = br.readLine();
            ++lineCounter;
        }while(line.isEmpty());
        return line;
    }
}



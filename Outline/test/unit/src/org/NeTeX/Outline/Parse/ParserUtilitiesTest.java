/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.NeTeX.Outline.Parse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jeremy
 */
public class ParserUtilitiesTest {
    
    public ParserUtilitiesTest() {
        testPartFound();
        testBeginFound();
        testIsEndingElement();
        testIsStartingElement();
        testParseType();
        testParseName();
    }
    
    public static void main(String[] args){
        ParserUtilitiesTest test = new ParserUtilitiesTest();
    }
   
    @Test
    public void testPartFound() {
        System.out.println("partFound");
        String line = "\\chapter{The First}";
        boolean result1 = ParserUtilities.partFound(line);
        assertEquals(result1, true);
        
        String badLine = "chapter{The First}";
        boolean result2  = ParserUtilities.partFound(badLine);
        assertEquals(result2, false);
    }

  
    @Test
    public void testBeginFound() {
        System.out.println("beginFound");
        String line = "\\begin{document}";
        boolean result1 = ParserUtilities.beginFound(line);
        assertEquals(result1, true);
        
        String badLine = "begin{document}";
        boolean result2 = ParserUtilities.beginFound(badLine);
        assertEquals(result2, false);
    }

   
    @Test
    public void testIsEndingElement() {
        System.out.println("isEndingElement");
        String line = "\\end{Document}";
        boolean result1 = ParserUtilities.isEndingElement(line);
        assertEquals(result1, true);
        
        String badLine = "end{Document}";
        boolean result2 = ParserUtilities.isEndingElement(badLine);
        assertEquals(result2, false);
    }

    /**
     * Test of isStartingElement method, of class ParserUtilities.
     */
    @Test
    public void testIsStartingElement() {
        System.out.println("isStartingElement");
        String line = "\\begin{document}";
        boolean result1 = ParserUtilities.isStartingElement(line);
        assertEquals(result1, true);
        
        String badLine = "begin something else";
        boolean result2 = ParserUtilities.isStartingElement(badLine);
        assertEquals(result2, false);
    }

  
    @Test
    public void testParseName() {
        System.out.println("parseName");
        String line = "begin{document}";
        String result1 = ParserUtilities.parseName(line);
        assertEquals(result1, "document");
        
        String line2 = "begin{chapter}";
        String result2 = ParserUtilities.parseName(line2);
        assertEquals(result2, "chapter");
    }

    /**
     * Test of parseType method, of class ParserUtilities.
     */
    @Test
    public void testParseType() {
        System.out.println("parseType");
        String line = "\\chapter{Titlehere}";
        String result = ParserUtilities.parseType(line);
        assertEquals(result, "chapter");
        
        String line2 = "\\begin{chapter}";
        String result2 = ParserUtilities.parseType(line);
        assertEquals(result2, ParserUtilities.parseName(line));
    }

    /**
     * Test of getEnumValue method, of class ParserUtilities.
     */
    @Test
    public void testGetEnumValue() {
        System.out.println("getEnumValue");
        String value = "part";
        ElementBean.ElementType result = ParserUtilities.getEnumValue(value);
        assertEquals(result, ElementBean.ElementType.PART);
        
        String value2 = "butt";
        ElementBean.ElementType result2 = ParserUtilities.getEnumValue(value2);
        exception.expect(IllegalArgumentException.class);
    }
    public final ExpectedException exception = ExpectedException.none();
}

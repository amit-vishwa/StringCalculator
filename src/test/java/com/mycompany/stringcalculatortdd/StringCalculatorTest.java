/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculatortdd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amitv
 */
public class StringCalculatorTest {
    
    @Test // TC1  
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0,StringCalculator.add("")) ;
    }
    
    @Test // TC2
    public void shouldReturnNumberForNumber() {
        assertEquals(1,StringCalculator.add("1")) ;
    }
    
    @Test // TC3
    public void shouldReturnSumForTwoNumbersDelimitedByComma() {
        assertEquals(3,StringCalculator.add("1,2")) ;
    }
    
    @Test // TC4
    public void shouldReturnSumForMultipleNumbers() {
        assertEquals(10,StringCalculator.add("1,2,3,4")) ;
    }
    
    @Test // TC5
    public void shouldAcceptNewLineAndReturnSumForMultipleNumbers() {
        assertEquals(6,StringCalculator.add("1\n2,3")) ;
    }
    
    @Test // TC6
    public void shouldSupportDiffDelimitersAndReturnSumForMultipleNumbers() {
        assertEquals(3,StringCalculator.add("//;\n1;2")) ;
    }
    
    @Test // TC7
    public void shouldRaiseExceptionOnNegatives() {
        try
        {
            StringCalculator.add("-1,2,3");
            fail("Exception expected");
        }catch(RuntimeException ex){}
        //assertEquals(3,StringCalculator.add("//.\n1.2")) ;
    }
    
    @Test // TC8
    public void shouldRaiseExceptionOnNegativesWithMessageAndNegativeNumbers() {
        try
        {
            StringCalculator.add("-1,-2,3");
            fail("Exception expected");
        }catch(RuntimeException ex)
        {
            assertEquals("Negatives not allowed: -1,-2",ex.getMessage()) ;
        }        
    }
    
    @Test // TC9
    public void shouldIgnoreNumbersGreaterThanThousandWhileAddingNumbersInAscending() {
        assertEquals(2,StringCalculator.add("2,1001")) ;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculatortdd;
import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;
/**
 *
 * @author amitv
 */
public class StringCalculator {
    
    /*testCase 1 failure case
    public static int add(String numbers)
    {
        return -1;
    }*/
    
//------------------------------------------------------------------TC1
    
    /* TC1 passed & TC2 failure
    public static int add(String numbers)
    {
        return 0;
    }*/
    
//------------------------------------------------------------------TC2
    
    /* TC2 passed & TC3 failure
    public static int add(String numbers)
    {
        if(numbers.isEmpty()){return 0;}
                else {return Integer.parseInt(numbers);}
    }*/
    
//------------------------------------------------------------------TC3
    
    /* TC3 passed & TC4 failure
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(","))
        {
            String[] a = numbers.split(",");
            return Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
        }
        else 
        {
            return Integer.parseInt(numbers);
        }
    }*/
    
//--------------------------------------------------------------------TC4
    
    /* TC4 passed & TC5 failure
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(","))
        {
            String[] a = numbers.split(",");
            int n=0;
            for(String b : a)
            {n+= Integer.parseInt(b);}
            return n;
        }
        else 
        {
            return toInt(numbers);
        }
    }*/
    
//------------------------------------------------------------------TC5
    
    /* TC5 passed & TC6 failure
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.contains(",")||numbers.contains("\n"))
        {
            String[] a = numbers.split(",|\n");
            int n=0;
            for(String b : a)
            {n+= Integer.parseInt(b);}
            return n;
        }
        else 
        {
            return toInt(numbers);
        }
    }*/

//-----------------------------------------------------------------------TC6

    /* TC6 passed & TC7 failure
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else
        {
            String[] a = tokensize(numbers);
            return getSum(a);            
        }
    }*/
    
    // Check getSum() for further TC changes
    public static int add(String numbers)
    {
        if(numbers.isEmpty()) {  return 0;  }
        else
        {
            String[] a = tokensize(numbers);
            return getSum(a);            
        }
    }
    
//--------------------------------------------------------------------TC7    
    
    /* TC7 passed & TC8 failure
    private static int getSum(String[] numbers)
    {
            int c=0,d=0,n=0,i=0;
            for(String b : numbers)
            {
                if(b.isEmpty()){b="0";}        
                    if(toInt(b)<0){
                    throw new RuntimeException();              
                    }
                n+= toInt(b);                                
            }
            return n;
    }*/
    
//-------------------------------------------------------------------TC8
       
    /* TC8 passed & TC9 failure
    private static int getSum(String[] numbers)
    {
            int n=0;
            List<Integer> c = new ArrayList<>();
            StringJoiner j=new StringJoiner(",");
            for(String b : numbers)
            {
                b = assignZeroForEmptyString(b);
                makeListOfNegativeNumbers(b, c, j);
                n+= toInt(b);                                
            }
            throwExceptionAndDisplayNegativeNumbers(c, j);
            return n;
    }*/
    
    //----------------------------------------------------------------TC9
    
    // TC9 passed
    private static int getSum(String[] numbers)
    {
            int n=0;
            List<Integer> c = new ArrayList<>();
            StringJoiner j=new StringJoiner(",");
            for(String b : numbers)
            {
                b = assignZeroForEmptyString(b);
                makeListOfNegativeNumbers(b, c, j);
                if(ignoresNumberGreaterThanThousand(b))break;
                n+= toInt(b);                                
            }
            throwExceptionAndDisplayNegativeNumbers(c, j);
            return n;
    }

    private static boolean ignoresNumberGreaterThanThousand(String b) throws NumberFormatException {
        if (toInt(b)>1000) {
            return true;
        }
        return false;
    }

    private static void makeListOfNegativeNumbers(String b, List<Integer> c, StringJoiner j) throws NumberFormatException {
        if(toInt(b)<0){
            c.add(toInt(b));
            j.add(b);
        }
    }

    private static String assignZeroForEmptyString(String b) {
        if(b.isEmpty()){b="0";}
        return b;
    }

    private static void throwExceptionAndDisplayNegativeNumbers(List<Integer> c, StringJoiner j) throws RuntimeException {
        if(c.size()>0){throw new RuntimeException("Negatives not allowed: "+j.toString());}
    }
      
    
    private static String[] tokensize(String numbers)
    {
        if(usesCustomDelimiterSyntax(numbers))
        {
            return usingCustomerDelimiter(numbers);
        }
        return splitUsingNewLineAndComma(numbers);
    }

    private static String[] usingCustomerDelimiter(String numbers) {
        String x=numbers.substring(2,numbers.length());
        return x.split(";|,|\n");
    }

    private static boolean usesCustomDelimiterSyntax(String numbers) {
        return numbers.startsWith("//");
    }

    private static String[] splitUsingNewLineAndComma(String numbers) {
        String[] tokens = numbers.split(",|\n");
        return tokens;
    }    
    
    private static int toInt(String numbers) throws NumberFormatException {
        return Integer.parseInt(numbers);
    }       
    
}

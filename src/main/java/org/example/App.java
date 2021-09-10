package org.example;
import java.util.Scanner;
import java.math.*;
import java.text.NumberFormat;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Exercise 14 Solution
 *  Copyright 2021 Patrick Mac
 */

public class App
{
    private static final double percentage = 0.055;
    static void calculate(String state,double order)
    {
        double tax;
        double total;
        if(state.equals("WI"))
        {

            tax = order * percentage;
            total = order + (order * percentage);
            BigDecimal formattedTax = new BigDecimal(tax).setScale(2, RoundingMode.FLOOR);
            NumberFormat defaultTax = NumberFormat.getCurrencyInstance();

            BigDecimal formattedTotal = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
            NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

            System.out.println("The tax is "+defaultTax.format(formattedTax)+".\n"+"The total is "+defaultFormat.format(formattedTotal)+".");
            return;
        }

        BigDecimal formattedTotal = new BigDecimal(order).setScale(2, RoundingMode.HALF_UP);
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        System.out.println("The total is "+defaultFormat.format(formattedTotal)+".");
    }
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        System.out.print( "What is the order amount? ");
        String stringOrder = scan.nextLine();
        System.out.print( "What is the state? ");
        String stringState = scan.nextLine();

        double order = Double.parseDouble(stringOrder);

        calculate(stringState,order);
    }
}
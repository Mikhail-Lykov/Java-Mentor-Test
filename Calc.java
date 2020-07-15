/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.Scanner;

/**
 *
 * @author Mickael
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Expressions object = new Expressions();
        String s = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Напишите математическое выражение:");
        s = scan.nextLine();      
    
        try {
            System.out.println(object.make(s));
        } catch (MyException ex) {
            if (ex.getCode() == MyException.FORMAT) {
                System.out.println("Нельзя использовать римские и арабские числа вместе.");
                scan.close();
            }
            else if (ex.getCode() == MyException.BAD_CISLO) {
                System.out.println("Неверное число.");
                scan.close();
            }
            else if (ex.getCode() == MyException.BAD_OPERATION) {
                System.out.println("Неверная арифметическая операция.");
                scan.close();
            }
        }
    }
}

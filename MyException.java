/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

/**
 *
 * @author Mickael
 */
public class MyException extends Exception{
    
    final static public int FORMAT = 1;
    final static public int BAD_CISLO = 2;
    final static public int BAD_OPERATION = 3;
    private int code;
    
    public MyException(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
}

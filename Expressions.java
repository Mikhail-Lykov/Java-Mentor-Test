/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.LinkedList;


/**
 *
 * @author Mickael
 */
public class Expressions {
    
    public boolean isOperation(char c) 
    {
        return c == '+' || c == '-' || c == '/' ||  c == '*'; 
    } 
    
    public boolean isRoman(char c)
    {
        return c == 'I' || c == 'V' || c == 'X';
    }
    
    public boolean interval(char c) 
    {
        return c == ' ';
    }
    public int opearatorsPriority(char operand) 
    {
        switch (operand) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    
    public int romanToArab(String operand){
        switch (operand) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;    
            default:
                return -1;
        }
    }
    
    public String ArabToRoman(int a){
          String result = "";
          
            while (a >=1000){
                result += "M";
                a -= 1000;
            }
            while (a >=900){
                result += "CM";
                a -= 900;
            }
            while (a >=500){
                result += "D";
                a -= 500;
            }
            while (a >=400){
                result += "CD";
                a -= 400;
            }
            while (a >=100){
                result += "C";
                a -= 100;
            }
            while (a >=90){
                result += "XC";
                a -= 90;
            }
            while (a >=50){
                result += "L";
                a -= 50;
            }
            while (a >=40){
                result += "XL";
                a -= 40;
            }
            while (a >=10){
                result += "X";
                a -= 10;
            }
            while (a >=9){
                result += "IX";
                a -= 9;
            }
            while (a >=5){
                result += "V";
                a -= 5;
            }
            while (a >=4){
                result += "IV";
                a -= 4;
            }
            while (a >=1){
                result += "I";
                a -= 1;
            }
            return result;
    }
    
    public void operator(LinkedList<Integer> cislo, char znak) 
    {
        int r = cislo.removeLast();
        int l = cislo.removeLast();
            switch (znak) {
                case '+':
                    cislo.add(l + r);
                    break;
                case '-':
                    cislo.add(l - r);
                    break;
                case '*':
                    cislo.add(l * r);
                    break;
                case '/':
                    cislo.add(l / r);
                    break;
        }
    }
 
 
    public String make(String s) throws MyException 
    {
        Expressions obj = new Expressions();
        LinkedList<Integer> h = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        boolean fa = true;
        boolean fr = true;        
        
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                    if (obj.interval(c))
                        continue;                    
                    String e="";
                    e += c;
                    if ((c == '.') || (c == ',')) throw new MyException(MyException.BAD_CISLO);
                    if (!obj.isOperation(c) && !obj.isRoman(c) && !Character.isDigit(s.charAt(i))) throw new MyException(MyException.BAD_OPERATION);
                    
                    if (obj.isOperation(c))
                    {  
                        while (!op.isEmpty() && obj.opearatorsPriority(op.getLast()) >= obj.opearatorsPriority(c))                            
                            operator(h, op.removeLast());
                            op.add(c);
                    } 
                    else if(obj.isRoman(c))
                    {
                        if (fr == false) throw new MyException(MyException.FORMAT);
                        fa = false;
                       String operand = "";
                       while (i < s.length() && obj.isRoman(s.charAt(i)) )                               
                                operand += s.charAt(i++);
                --i;
                if (obj.romanToArab(operand) == -1) throw new MyException(MyException.BAD_CISLO);
                h.add(obj.romanToArab(operand));
                                 
                    }
                    else
                    {
                        if (fa == false) throw new MyException(MyException.FORMAT);
                        fr = false;
                        String operand = "";
                            while (i < s.length() && Character.isDigit(s.charAt(i)))                               
                                operand += s.charAt(i++); 
                --i;
                if (Integer.parseInt(operand) < 1 || Integer.parseInt(operand) > 10) throw new MyException(MyException.BAD_CISLO);
                h.add(Integer.parseInt(operand));
                   }
            }
            
        while (!op.isEmpty())
            operator(h, op.removeLast());
        
        String result = "";
       
        if (fr){
            result = ArabToRoman(h.get(0));
        }
        else result += h.get(0);
            
        return result;
        
    }

}

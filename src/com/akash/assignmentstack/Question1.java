package com.akash.assignmentstack;

import java.util.Scanner;
import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Expression : ");
        String inp = scanner.next();
        if (findEquation(inp)){
            System.out.println("Valid Equation");
        }else {
            System.out.println("Invalid Equation");
        }
    }

    private static boolean findEquation(String inp) {
        int start = 0;
        Stack s = new Stack();
        while(start < inp.length()){
            if(inp.charAt(start) == '(' || inp.charAt(start) == '[' || inp.charAt(start) == '{' ){
                s.push(inp.charAt(start));
            }else{
                char c = (char)s.pop();
                if (inp.charAt(start) == ')'){
                    if (c != '(')
                        return false;
                } else if (inp.charAt(start) == ']') {
                    if (c != '[')
                        return false;
                } else if (inp.charAt(start) == '}') {
                    if (c != '{')
                        return false;
                }
            }
            start++;
        }
        if (!s.isEmpty()){
            return false;
        }
        return true;
    }
}

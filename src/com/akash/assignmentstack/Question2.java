package com.akash.assignmentstack;

import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text : ");
        String text = in.nextLine();
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<text.length();i++){
            char s = text.charAt(i);
            if(Character.isLetterOrDigit(s)){
                result = result + s;
            }else {
                stack.push(s);
            }
        }
        while (!stack.isEmpty()){
            result=result+stack.pop();
        }
        System.out.println(result);
    }
}
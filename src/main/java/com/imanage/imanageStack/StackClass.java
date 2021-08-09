package com.imanage.imanageStack;

import com.imanage.imanageStack.configuration.CapacityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;


public class StackClass {
    String[] stackArray;
    int topPointer=-1;

    public StackClass(int capacity) {
        stackArray=new String[capacity];
    }
    
    public String pop(){
        if(topPointer<0)
            return "Stack is Empty";
        else
            return stackArray[topPointer--];
        
        
    }
    
    public boolean  push(String data){
        if(topPointer<stackArray.length)
             stackArray[++topPointer]=data;
        else
            return false;
        return true;
        
        
    }
    
    public String get(int index)
    {
        if(index>=0 && index<=topPointer)
            return stackArray[index];
        return "Invalid Index!";
    }
    
    
    
}

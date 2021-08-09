/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imanage.imanageStack;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 *
 * @author shetty
 */
public class StackClassTest {
    
    @Test
    public void testCreate(){
        StackClass s=new StackClass(2);
        try{
            s.stackArray[2]="test";
        }catch(Exception e){
            Assert.isTrue(e.getClass().getSimpleName().equals("ArrayIndexOutOfBoundsException"),"Fail" );
        }
    }
    
    @Test
    public void testPush(){
        StackClass s=new StackClass(2);
        Assert.isTrue( s.push("test"),"Push unsuccessful");
        
    }
    
    @Test
    public void testPop(){
        StackClass s=new StackClass(2);
        s.push("Hi");
        Assert.hasText(s.pop(),"Hi");
        
    }
    
    @Test
    public void testGet(){
        StackClass s=new StackClass(3);
        s.push("Hi");
        s.push("Imanage");
        s.push("Benagaluru");
        Assert.hasText(s.get(1),"Imanage");
        
    }
    
}

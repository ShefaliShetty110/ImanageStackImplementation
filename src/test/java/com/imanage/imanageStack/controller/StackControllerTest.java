package com.imanage.imanageStack.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StackControllerTest {

    StackController controller=new StackController();

    @Test
    void testAllRestOperations() {
        ResponseEntity<String> response = controller.createNewStack(2);
        response=controller.pushInStack("Welcome");
        Assert.isTrue("Successfully pushed!".equals(response.getBody()),"Push failed");
        response=controller.display();
        response=controller.pushInStack("to");
        response=controller.display();
        response=controller.pushInStack("iManage");
        Assert.isTrue("Push failed".equals(response.getBody()),"Push passed");
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.INSUFFICIENT_STORAGE),"Wrong status");
        response=controller.display();
        response=controller.popFromStack();
        response=controller.display();
        response=controller.popFromStack();
        response=controller.display();
        response=controller.popFromStack();
        Assert.isTrue(response.getBody().equals("Stack is Empty"),"Stack should have been empty");
        response=controller.display();




    }


}
package com.imanage.imanageStack.controller;


import com.imanage.imanageStack.StackClass;
import com.imanage.imanageStack.configuration.CapacityConfig;
import com.imanage.imanageStack.model.InputVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class StackController {

    StackClass newStack;
    
    @GetMapping("/")
	public String index() {
		return "stackWebPage";
	}

    @PostMapping(value="/create" ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String> createNewStack( @RequestBody InputVo capacity){
        System.out.println(capacity);
      //   newStack=new StackClass(Integer.parseInt(body.get()));
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping(value="/push/{data}")
    public ResponseEntity<String> pushInStack(@PathVariable String data){
        if(newStack==null)
            newStack=new StackClass(CapacityConfig.getPropertyValue());
          newStack.push(data);
          return   ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    @GetMapping(value="/pop")
    public String popFromStack(){
        return newStack.pop();

    }



}

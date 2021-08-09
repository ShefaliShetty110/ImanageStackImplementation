package com.imanage.imanageStack.controller;


import com.imanage.imanageStack.StackClass;
import com.imanage.imanageStack.configuration.CapacityConfig;
import com.imanage.imanageStack.model.InputVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class StackController {

    StackClass newStack;
    
    @GetMapping("/")
	public String index() {
		return "stackWebPage";
	}

    @RequestMapping(value="/create" ,method = RequestMethod.POST)
    public ResponseEntity<String> createNewStack(@RequestParam int capacity){

         newStack=new StackClass(capacity);
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping(value="/push/{data}")
    public ResponseEntity<String> pushInStack(@PathVariable String data){
        if(newStack==null)
            newStack=new StackClass(CapacityConfig.getPropertyValue());
          if(newStack.push(data))
              return   ResponseEntity.status(HttpStatus.CREATED).body("Successfully pushed!");
          else
              return   ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body("Push failed");

    }

    @GetMapping(value="/pop")
    public ResponseEntity<String> popFromStack(){
        return ResponseEntity.status(HttpStatus.OK).body(newStack.pop());

    }

    @GetMapping(value="/display")
    public ResponseEntity<String> display(){
        String result=newStack.displayAll();
        System.out.println(result);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }



}

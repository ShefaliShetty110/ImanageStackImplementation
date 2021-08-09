/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imanage.imanageStack.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author shetty
 */
@Configuration
@ConfigurationProperties(prefix="stack")
public class CapacityConfig {
    
    String propertyName;
    private static int propertyValue;
    
    public String getPropertyName(){
        return propertyName;
        
    }
    
    public static int getPropertyValue(){
        return propertyValue;
    }
    public void setPropertyName(String name){
        this.propertyName=name;
    }
    public void setPropertyValue(int value){
        this.propertyValue=value;
    }
}

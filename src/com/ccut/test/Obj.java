package com.ccut.test;

import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Obj {
	
    public void setStr(String str)
    {
        this.str = str;
    }
 
    private String str = "default value5555";
 
    public String toString()
    {
        return str;
    }
    
    public static void main(String[] args) {
    	System.out.println(UUID.randomUUID().toString());
    	System.out.println(UUID.randomUUID().toString());
    	System.out.println(UUID.randomUUID().toString().substring(0, 2));
    	
	}
}

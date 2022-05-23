package com.sp.communicationlibrary;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@EnableFeignClients("com.sp.communicationlibrary")
@ComponentScan(basePackages = {"com.sp.communicationlibrary"})
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.services.BookService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        //call the method
        bookService.getBookRepository1();
    }
}

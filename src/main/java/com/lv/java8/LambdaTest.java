package com.lv.java8;

import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args) {
        //Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
        //Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
        /*
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.println( e );
            System.out.println( e );
        } );
        */
        final String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );
    }
}

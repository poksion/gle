package net.poksion.gle.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SectionBuilder {

    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){

            String line = null;  
            while( (line = input.readLine()) != null ) {    
                System.out.println(line); 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.sazails.Spring_Boot;

public class SomeTest {
    public int add(int[] numbers){
        int total = 0;
        for(int i : numbers){
            total += i;
        }
        return total;
    }

    public String getWeirdString(){
        String temp = "yo";
        temp = temp.toUpperCase();
        temp.replace('O', 'a');
        temp = temp.concat("choo");
        return temp;
    }
}

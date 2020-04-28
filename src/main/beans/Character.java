package main.beans;

public class Character implements Entity {

    public int id = 0;
    public String name = "Unnamed";


    @Override
    public void sayHello(){
        System.out.println(name + " says hello!");
    }
}

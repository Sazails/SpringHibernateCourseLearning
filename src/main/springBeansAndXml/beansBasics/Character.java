package main.springBeansAndXml.beansBasics;

public class Character implements IEntity {

    public int id = 0;
    public String name = "Unnamed";


    @Override
    public void sayHello(){
        System.out.println(name + " says hello!");
    }
}

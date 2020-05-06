package main.springConfigWithJavaCode.springBeanJavaCodeNoXml;

public class Person implements IPerson {

    private String name = "Pencil";

    private IHobby hobby;

    public Person(IHobby theHobby) {
        this.hobby = theHobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println(name + ": Hello!");
    }

    public void sayHobby(){
        System.out.println(hobby.getHobby());
    }
}

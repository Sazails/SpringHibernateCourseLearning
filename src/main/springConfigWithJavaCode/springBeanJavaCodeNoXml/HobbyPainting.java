package main.springConfigWithJavaCode.springBeanJavaCodeNoXml;

public class HobbyPainting implements IHobby {

    @Override
    public void runHobby() {
        System.out.println("I am now painting!");
    }

    @Override
    public String getHobby() {
        return "Painting";
    }
}

package main.springBeansAndXml.injectFromPropertiesFile;

public class DataPacket {
    public String id;
    public String name;
    public String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void sendDataPacket(String locationID){
        System.out.println("Sending packet: " + this.toString() + " to location with ID: " + locationID);
    }

    @Override
    public String toString() {
        return "DataPacket[" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                ']';
    }
}

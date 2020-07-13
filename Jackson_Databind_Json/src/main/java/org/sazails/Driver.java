package org.sazails;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            // Read and print Json data
            ObjectMapper objectMapper = new ObjectMapper();

            /*User user = objectMapper.readValue(new File("data/sample_data.json"), User.class);
            System.out.println(user.toString());*/

            User user = objectMapper.readValue(new File("data/sample_data_full.json"), User.class);
            System.out.println(user.toString());
            System.out.println(user.getUserExtraInfo().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

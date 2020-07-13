package org.sazails;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class DriverTest {

    @Test
    void main() {
        User user = null;

        try{
            // Read and print Json data
            ObjectMapper objectMapper = new ObjectMapper();

            /*User user = objectMapper.readValue(new File("data/sample_data.json"), User.class);
            System.out.println(user.toString());*/

            user = objectMapper.readValue(new File("data/sample_data_full.json"), User.class);
            System.out.println(user.toString());
            System.out.println(user.getUserExtraInfo().toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        Assertions.assertEquals("Hugan", user.getUsername());
    }
}
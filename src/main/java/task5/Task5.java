//The general task for all:
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.

package task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Task5 {
    public static void main(String[] args) {
        //JSON
        ObjectMapper objectMapper = new ObjectMapper();
        Data data = null;
        try {
            data = objectMapper.readValue(Files.readString(new File("/Users/user/Desktop/ITStep/IT STEP 4 course/AQA/Tasks/src/main/resources/input.json").toPath()), Data.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JSON before: " + data.toString());

        data.setAge(29);
        System.out.println("JSON after: " + data.toString());

        try {
            objectMapper.writeValue(new File("/Users/user/Desktop/ITStep/IT STEP 4 course/AQA/Tasks/src/main/resources/output.json"), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //XML
        XmlMapper xmlMapper = new XmlMapper();

        try {
            data = xmlMapper.readValue(Files.readString(new File("/Users/user/Desktop/ITStep/IT STEP 4 course/AQA/Tasks/src/main/resources/input.xml").toPath()), Data.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("XML before: " + data.toString());
        data.setAge(29);
        System.out.println("XML after: " + data.toString());

        try {
            xmlMapper.writeValue(new File("/Users/user/Desktop/ITStep/IT STEP 4 course/AQA/Tasks/src/main/resources/output.xml"), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


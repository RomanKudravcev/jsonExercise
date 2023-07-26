package jsonfun;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JSONConverter {
    private final ObjectMapper mapper;

    public JSONConverter(){
        this.mapper = new ObjectMapper();
    }

    public void convertObjectToJSON(Object o, Path path){

        try {
            // Java object to JSON file
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            String json = writer.writeValueAsString(o);
            Files.write(path, json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert object to JSON and write to file: " + path, e);
        }
    }

    public <T> T convertJSONToObject(Class<T> targetClass, File file){
        try {
            return mapper.readValue(file, targetClass);
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert JSON file to object of type " + targetClass.getName(), e);
        }
    }

}

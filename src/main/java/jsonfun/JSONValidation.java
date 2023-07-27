package jsonfun;

import com.networknt.schema.*;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class JSONValidation {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

        try {
            // Load the JSON schema
            InputStream schemaInputStream = JSONValidation.class.getResourceAsStream("/schema.json");
            if (schemaInputStream == null) {
                throw new IllegalStateException("Schema file not found in resources.");
            }
            JsonSchema jsonSchema = factory.getSchema(schemaInputStream);

            // Load the JSON data to validate
            InputStream jsonInputStream = JSONValidation.class.getResourceAsStream("/film.json");
            if (jsonInputStream == null) {
                throw new IllegalStateException("JSON data file not found in resources.");
            }
            JsonNode jsonNode = mapper.readTree(jsonInputStream);

            // Validate the JSON data against the schema
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            // If there are validation errors, throw an exception
            if (!errors.isEmpty()) {
                StringBuilder errorMessages = new StringBuilder();
                for (ValidationMessage error : errors) {
                    errorMessages.append(error.getMessage()).append("\n");
                }
                throw new IllegalArgumentException("JSON data is invalid:\n" + errorMessages);
            }

                // JSON data is valid, continue with your logic here
                System.out.println("The validation was successful!");

        } catch (IOException e) {
            // Handle any I/O errors
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // Handle the exception for invalid JSON data
            System.err.println(e.getMessage());
        }
    }
}

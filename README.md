# JSON Exercise
This is a possible exercise that covers the topic of JSON. The exercise includes the following aspects:

- Transformation of objects into a JSON file
- Transformation of a JSON file into objects
- Validation of JSON files based on a schema
- Creation of a schema using a tool

## Conversion of objects and JSON files
Mkyong provides an example with a suitable library in their [Jackson 2 – Convert Java Object to / from JSON](https://mkyong.com/java/jackson-2-convert-java-object-to-from-json/). This example contains the conversion of objects into a JSON file and the other way around. These examples have been revised into a more complex application (see `Main`). This class uses the `JSONConverter` class to apply the conversion. A nested object was used for this application, which reflects a realistic scenario, since this can be further expanded as desired. However, [annotations](https://www.baeldung.com/jackson-annotations) must be added to these objects for serialization and deserialization (see `model.Film`and `Genre`).

## Schema Validation
Baeldung provides an example with a suitable library in their [Introduction to JSON Schema](https://www.baeldung.com/introduction-to-json-schema-in-java). This example has been revised for proper integration into applications, and you can find it in the `JSONValidation` class.

## Schema generation
[Victools](https://github.com/victools/jsonschema-generator) provides a library for generating JSON schemas from Java classes that use Jackson annotations. This library retrieves these annotations and uses them to construct the schema. This library is used to create a task named `generateSchema` in the `build.gradle` file to create a schema for the model `Film'. This schema can be used to validate JSON files and check that the structure is correct.
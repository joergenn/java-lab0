package lab2;

import com.fasterxml.jackson.databind.JavaType;
import  com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class JsonSerializer<T> implements Serializable<T> {
    @Override
    public void writeObject(T entity, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/" + fileName), entity);
    }

    @Override
    public T readObject(String fileName, Class<T> name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new String(Files.readAllBytes(Paths.get("target/" + fileName))), name);
    }

    @Override
    public void writeList(List<T> instanceList, String fileName) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/" + fileName), instanceList);
    }

    @Override
    public List<T> readList(String fileName, Class<T> name) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String json = new String(Files.readAllBytes(Paths.get("target/" + fileName)));
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, name);
        return objectMapper.readValue(json, type);
    }
}

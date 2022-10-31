package lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XmlSerializer<T> implements Serializable<T> {
    @Override
    public void writeObject(T entity, String fileName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("target/" + fileName), entity);
    }

    @Override
    public T readObject(String fileName, Class<T> name) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = new String(Files.readAllBytes(Paths.get("target/" + fileName)));
        return xmlMapper.readValue(xml, name);
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
        return objectMapper.readValue(json, new TypeReference<List<T>>(){});
    }
}

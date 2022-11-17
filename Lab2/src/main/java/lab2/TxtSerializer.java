package lab2;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtSerializer {
    public void writeObject(Employee instance, String fileName) throws IllegalAccessException, FileNotFoundException {
        Class<?> classFields = instance.getClass();
        File myFile = new File("target/" + fileName);
        PrintWriter writer = new PrintWriter(myFile);
        String json = "";
        for(Field field : classFields.getDeclaredFields()) {
            field.setAccessible(true);
            json += field.getName() + ": " + field.get(instance) + "\n";
        }
        json = json.substring(0, json.length()-1);
        writer.println(json);
        writer.close();
    }

    public Employee readObject(String fileName) throws IOException {
        String json = "{";
        String tempString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> allLines = Files.readAllLines(Paths.get("target/" + fileName));
        for (String line : allLines) {
            String[] arrOfStr = line.split(":", 0);

            for (String a : arrOfStr) {
                a = a.replaceFirst("\\s","");
                tempString += "\"" + a + "\"" + ":";
            }
            tempString = tempString.substring(0, tempString.length() - 1);
            tempString += ",";
            json += tempString;
            tempString = "";
        }
        json = json.substring(0, json.length() - 1) + "}";
        return objectMapper.readValue(json, Employee.class);
    }

    public void writeList(List<Employee> instanceList, String fileName) throws FileNotFoundException, IllegalAccessException {
        if(instanceList.size() == 0){
            return;
        }
        Class<?> classFields = instanceList.get(0).getClass();
        File myFile = new File("target/" + fileName);
        PrintWriter writer = new PrintWriter(myFile);
        String json = "";
        for (int i = 0; i < instanceList.size(); i++) {
            for(Field field : classFields.getDeclaredFields()) {
                field.setAccessible(true);
                json += field.getName() + ": " + field.get(instanceList.get(i)) + "\n";
            }
            json += "\n";
        }
        writer.println(json.substring(0, json.length()-1));
        writer.close();
    }

    public List<Employee> readList(String fileName) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class);
        String json = "[";
        String tempString = "{";
        List<String> allLines = Files.readAllLines(Paths.get("target/" + fileName));
        for (String line : allLines) {
            if(line.length() > 0) {
                String[] arrOfStr = line.split(":", 0);
                for (String a : arrOfStr) {
                    a = a.replaceFirst("\\s", "");
                    tempString += "\"" + a + "\"" + ":";
                }
                tempString = tempString.substring(0, tempString.length() - 1);
                tempString += ",";
            }
            else{
                tempString = tempString.substring(0, tempString.length() -1) +  "},";
                json += tempString;
                tempString = "{";
            }
        }
        json = json.substring(0, json.length() - 1) + "]";
        return objectMapper.readValue(json, type);
    }
}

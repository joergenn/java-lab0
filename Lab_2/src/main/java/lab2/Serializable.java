package lab2;

import java.io.IOException;
import java.util.List;

public interface Serializable<T> {
    /**
     * @param instance object of a class
     * @param fileName string that point to file location, provide only name of file and extension without full path
     * @throws IOException
     */
    void writeObject(T instance, String fileName) throws IOException;

    /**
     * @param instanceList list of class objects
     * @param fileName string that point to file location, provide only name of file and extension without full path
     * @throws IOException
     */
    void writeList(List<T> instanceList, String fileName) throws IOException;

    T readObject(String fileName, Class<T> name) throws IOException;

    List<T> readList(String fileName, Class<T> name) throws IOException;
}

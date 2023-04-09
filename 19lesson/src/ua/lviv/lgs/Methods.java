package ua.lviv.lgs;

import java.io.*;

public class Methods {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("serializedEmployee.txt");
        Employee employee = new Employee("Pavlo", 45,1500);
        System.out.println(employee);
        serializeObject(employee, file);

        System.out.println(deserializeObject(file));

    }

    public static void serializeObject(Serializable object, File file) throws IOException {
        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        outputStream.close();
    }

    public static Serializable deserializeObject(File file) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Serializable object = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        return object;


    }


}

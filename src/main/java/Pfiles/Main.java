package Pfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException {
        
    //     System.out.println(new File("example.txt").getAbsolutePath());

    //    FileReader filereader = new FileReader("example.txt");
    //    BufferedReader bufferedReader = new BufferedReader(filereader); // decorater

    //    //String line;
    //    while ((line = bufferedReader.readLine()) != null){
    //     System.out.println(line);
    //    }
    //    bufferedReader.close();

       // write 
    //    FileWriter fw = new FileWriter("output.txt");
    //    BufferedWriter bw = new BufferedWriter(fw);

    //    bw.write("hello from the buffered writer!");
    //    bw.newLine();
    //    bw.write("another line");

    //    bw.close();

       // NIO -- auto close files for us. 

    //    Path filePath = Paths.get("example.txt");

    //    for (String line : Files.readAllLines(filePath)){
    //     System.out.println(line);
    //    }

    // //    Files.write(Paths.get("example.txt"), "write to file pls".getBytes());

    // //    Path p = Path.of("example.txt");
    // //    Files.writeString(p, "will this work");
       

    // Person person = new Person(30, "c");

    // // should only have 1 json object - reuse it rather than recreate.
    // //Gson gson = new Gson();

    // //serialisation so json can write it:
    // String json = gson.toJson(person);
    // System.out.println(json); // looks like json data...

    // //write to a .json file
    // Path out = Path.of("person.json");
    // Files.writeString(out, json);

    // // read and make back into a Person object:
    // String read = Files.readString(out);
    // Person person1 = gson.fromJson(read, Person.class);
    // System.out.println(person1.getAge() + person1.getName());









    }
}
class Person {
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}


/*
 * legacy ways to deal with files locally. (fileReader + bufferedReader)
 * 
 * modern way NIO
 * 
 * Gson/json
 * 
 * 
 * 
 * 
 */
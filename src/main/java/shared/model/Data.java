package shared.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data {

  public void saveData(University university) throws IOException {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setPrettyPrinting();
    Gson gson = gsonBuilder.create();

    String universityJson = gson.toJson(university);
    FileWriter writer = new FileWriter("./src/main/resources/data/university.txt");
    writer.write(universityJson);
    writer.close();
  }

  public void loadData() throws FileNotFoundException {
      File file = new File("./src/main/resources/data/university.txt");
      Scanner scanner = new Scanner(file);
      String jsonString = "";
      while (scanner.hasNext()) {
        jsonString += scanner.nextLine();
      }
      GsonBuilder gsonBuilder = new GsonBuilder();
      gsonBuilder.setPrettyPrinting();
      Gson gson = gsonBuilder.create();

      University university = gson.fromJson(jsonString, University.class);
      University.setInstance(university);
  }
}

package doman;

import au.com.bytecode.opencsv.CSVReader;
import java.io.*;
import java.util.Arrays;
import java.util.List;


  public class CSVFile{
   String name;

    public CSVFile(String name) {this.name=name;}

    public List<String[]> getList() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(name);
        //чтение CSV файла
        CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(in)),
                ',','"',0);

        List<String[]> list = reader.readAll();
      return list;

    }
}

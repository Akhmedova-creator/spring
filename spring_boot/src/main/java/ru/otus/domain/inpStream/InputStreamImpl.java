package ru.otus.domain.inpStream;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.config.SpringBootConf;
import ru.otus.domain.ListNullException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InputStreamImpl implements InptStream {

    final private String pathName;
    final private int SIZELIST = 5;

    public int getSIZELIST() {
        return SIZELIST;
    }

    @Autowired
    public InputStreamImpl(SpringBootConf conf) {
        this.pathName = conf.getPathName();
    }

    public List<String[]> getList() {
        List<String[]> list = new ArrayList<>();
        CSVReader reader = null;
        //чтение CSV файла
        try {
            reader = new CSVReader(new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(pathName)))),
                    ',', '"', 0);
            list = reader.readAll();
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        } finally {
            {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии файла" + e.getMessage());
                }
            }
        }
        return Objects.requireNonNullElseGet(list, () -> (List<String[]>) new ListNullException("Пустой  список"));
    }

}


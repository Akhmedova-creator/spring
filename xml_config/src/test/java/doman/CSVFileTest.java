package doman;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVFileTest {
    final int COUNT=5;
    @Test
    void getList() throws IOException {

        String []res1={"What is your name?"};
        String []res2={"What is your last name ?"};
        String []res3={"How is your middle name?"};
        String []res4= {"How old are you?"};
        String []res5={"what is your hobby?"};

        List<String[]> exp=new ArrayList<>();
        exp.add(res1);
        exp.add(res2);
        exp.add(res3);
        exp.add(res4);
        exp.add(res5);

        CSVFile csvFile=new CSVFile("questions.csv");
        List<String[]> act=csvFile.getList();
        for (int i=0;i<COUNT;i++) {
            assertEquals(Arrays.toString(exp.get(i)),Arrays.toString(act.get(i)));
        }
    }
}
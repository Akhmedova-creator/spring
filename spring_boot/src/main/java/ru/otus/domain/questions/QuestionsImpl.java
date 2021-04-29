package ru.otus.domain.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.inpStream.InptStream;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionsImpl implements Questions {

    final private InptStream inptStream;

    @Autowired
    public QuestionsImpl(InptStream inptStream) {
        this.inptStream = inptStream;
    }

    public List<String> getQuestions(){

        List<String[]> list=inptStream.getList();
        List<String> que = new ArrayList<>();

        for (int i = 0; i < inptStream.getSIZELIST(); i++) {
            String temp = Arrays.toString(list.get(i));
            que.add(i,temp.substring(1, temp.length() - 1));
        }

         return que;
    }
}

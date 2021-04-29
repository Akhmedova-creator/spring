package ru.otus.domain.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.inpStream.InptStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnswersImpl implements Answers {

    final private InptStream inputStream;

    @Autowired
    public AnswersImpl(InptStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<Integer> getAnswers() {
        List<String[]> list=inputStream.getList();
        int len=0;
        List<Integer> ans = new ArrayList<>();
        for (int i = inputStream.getSIZELIST()+1; i <inputStream.getSIZELIST()*2+1; i++) {
            String temp = Arrays.toString(list.get(i));
            ans.add(len,Integer.valueOf(temp.substring(1, temp.length() - 1)));
            len++;
        }
        return ans;
    }

}

package ru.otus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.domain.testResult.TestResult;

import java.io.IOException;

@Component
public class TestsImpl implements Tests {

@Autowired
private TestResult testResult;

    @Override
    public TestResult getResult() {
      return  testResult;
    }
}


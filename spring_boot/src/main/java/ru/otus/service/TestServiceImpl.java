package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;
import ru.otus.dao.Tests;
import ru.otus.domain.testResult.TestResult;

@Service
public class TestServiceImpl implements TestService {

    private Tests tests;

    @Autowired
    public TestServiceImpl(Tests tests) {
        this.tests = tests;
    }

    @Override
    public TestResult getTest () {  return tests.getResult();}

}

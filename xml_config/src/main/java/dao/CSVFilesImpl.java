package dao;

import doman.CSVFile;

public class CSVFilesImpl implements CSVFiles {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public CSVFile getCSVFile() {
        return new CSVFile(name);
    }

}

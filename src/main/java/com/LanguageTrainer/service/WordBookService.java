package com.LanguageTrainer.service;

/**
 * Created by mycomputericons on 7/1/2017.
 */
public interface WordBookService {
    public void add(String first, String second);

    public String getByKey(String which);

    public String getSecondByIndex(int index);

    public String getFirstByIndex(int index);

    public int size();
}

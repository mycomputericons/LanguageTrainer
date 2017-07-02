package com.LanguageTrainer.repository;

/**
 * Created by mycomputericons on 6/30/2017.
 */
public interface WordBookRepository {
    public void add(String first, String second);

    public String getByKey(String which);

    public String getSecondByIndex(int index);

    public String getFirstByIndex(int index);

    public int size();
}

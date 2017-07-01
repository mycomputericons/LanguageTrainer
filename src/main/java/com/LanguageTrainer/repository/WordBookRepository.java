package com.LanguageTrainer.repository;

/**
 * Created by mycomputericons on 6/30/2017.
 */
public interface WordBookRepository {
    public void add(String first, String second);

    public String get(String which);
}

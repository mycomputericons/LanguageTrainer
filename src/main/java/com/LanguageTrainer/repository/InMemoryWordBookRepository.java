package com.LanguageTrainer.repository;

import javafx.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by mycomputericons on 7/1/2017.
 */
@Repository
public class InMemoryWordBookRepository implements WordBookRepository {

    private ArrayList<Pair<String, String>> words = new ArrayList<Pair<String, String>>();

    @Override
    public void add(String first, String second) {
        words.add(new Pair<String, String>(first, second));
    }

    @Override
    public String get(String which) {
        return words.get(words.indexOf(which)).getValue();
    }
}

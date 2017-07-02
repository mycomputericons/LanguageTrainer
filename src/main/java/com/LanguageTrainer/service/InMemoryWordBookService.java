package com.LanguageTrainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LanguageTrainer.repository.InMemoryWordBookRepository;

/**
 * Created by mycomputericons on 7/1/2017.
 */
@Service
public class InMemoryWordBookService implements WordBookService {

    @Autowired
    private InMemoryWordBookRepository inMemoryWordBookRepository;

    @Override
    public void add(String first, String second) {
        inMemoryWordBookRepository.add(first, second);
    }

    @Override
    public String getByKey(String which) {
        return inMemoryWordBookRepository.getByKey(which);
    }

    @Override
    public String getSecondByIndex(int index) {
        return inMemoryWordBookRepository.getSecondByIndex(index);
    }

    @Override
    public String getFirstByIndex(int index) {
        return inMemoryWordBookRepository.getFirstByIndex(index);
    }

    @Override
    public int size() {
        return inMemoryWordBookRepository.size();
    }


}

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

    public InMemoryWordBookService()
    {
        inMemoryWordBookRepository = new InMemoryWordBookRepository();
    }

    @Override
    public void add(String first, String second) {
        inMemoryWordBookRepository.add(first, second);
    }

    @Override
    public String get(String which) {
        return inMemoryWordBookRepository.get(which);
    }
}

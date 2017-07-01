package com.LanguageTrainer.LanguageTrainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.LanguageTrainer.utils.Util;

/**
 * Created by mycomputericons on 7/1/2017.
 */
@Component
public class LanguageTrainerRunner implements CommandLineRunner {

    @Autowired
    Util util;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello world");

        util.loadWords("words001.txt");

        
    }
}

package com.LanguageTrainer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.LanguageTrainer.repository.WordBookRepository;
import com.LanguageTrainer.service.InMemoryWordBookService;
import com.LanguageTrainer.service.WordBookService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Created by mycomputericons on 7/1/2017.
 */
@Component
public class Util {

    @Autowired
    private WordBookService wordBookService;

    public void loadWords(String filename)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            int lineNumber = 1;

            while((line = bufferedReader.readLine()) != null)
            {
                String[] words = line.split("  ");
                if (words.length != 2)
                {
                    throw new InputMismatchException("There are not two words separated by two spaces in line " + lineNumber);
                }

                wordBookService.add(words[0], words[1]);

                lineNumber++;
            }

        }
        catch (FileNotFoundException exception)
        {
            System.out.println("The file cannot be found: " + filename + ". Error message: " + exception.getMessage());
        }
        catch (IOException exception)
        {
            System.out.println("Line cannot be read from file. Error: " + exception.getMessage());
        }
        catch (InputMismatchException exception)
        {
            System.out.println(exception.getMessage());
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}

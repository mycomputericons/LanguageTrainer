package com.LanguageTrainer.LanguageTrainer;

import com.LanguageTrainer.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by mycomputericons on 7/1/2017.
 */
// TODO: write logic which permutates the wrongly answered results
// TODO: organize code, it looks like crap now
@Component
public class LanguageTrainerRunner implements CommandLineRunner {

    @Autowired
    private WordBookService wordBookService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Which input file should we use?");
        String filename = System.console().readLine();
        loadWords(filename);

        int wordsCount = wordBookService.size();

        Stack<Integer> words = new Stack<>();
        Stack<Integer> wrongWords = new Stack<>();

        fillCollection(words, wordsCount);


        int correctAnswers = 0;
        int badAnswers = 0;

        List<String> inCorrectAnswers = new ArrayList<>();

        for (Integer which : words)
        {
            ClearScreen();
            System.out.println(wordBookService.getSecondByIndex(which));

            String input = System.console().readLine();
            if (input.equals(wordBookService.getFirstByIndex(which)))
            {
                correctAnswers++;
                continue;
            }
            else
            {
                System.out.println("Nope! Correct solution: " + wordBookService.getFirstByIndex(which));
                wrongWords.add(which);
                System.console().readLine();
            }
        }

        for (Integer which : wrongWords)
        {
            ClearScreen();
            System.out.println(wordBookService.getSecondByIndex(which));

            String input = System.console().readLine();
            if (input.equals(wordBookService.getFirstByIndex(which)))
            {
                correctAnswers++;
                continue;
            }
            else
            {
                badAnswers++;
                System.out.println("Nope! Correct solution: " + wordBookService.getFirstByIndex(which));
                inCorrectAnswers.add(wordBookService.getSecondByIndex(which));
                inCorrectAnswers.add(wordBookService.getFirstByIndex(which));
                System.console().readLine();
            }
        }

        ClearScreen();
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + badAnswers);
        if (badAnswers != 0) {
            System.out.println("These ones: " + inCorrectAnswers.toString());
        }

        System.console().reader();
        System.console().readLine();
    }

    private void fillCollection(Collection<Integer> collection, int number)
    {
        ArrayList<Integer> randomArray = new ArrayList<>(number);

        for (int i = 0; i < number; i++)
        {
            randomArray.add(i);
        }

        Collections.shuffle(randomArray);

        collection.addAll(randomArray);
    }

    private void loadWords(String filename)
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
        catch (IOException exception)
        {
            System.out.println("Line cannot be read from file. Error: " + exception.getMessage());
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    private void ClearScreen()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

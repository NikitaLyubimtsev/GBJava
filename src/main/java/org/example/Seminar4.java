package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Seminar4 {

    public static void main(String[] args) throws IOException {

        // Запись и чтение файла
        File file = new File("text.in");
        Scanner scan = new Scanner("Lyubimtsev Nikita Alexandrovich 34 M\nLyubimtseva Anna Viktorovna 36 F\nIvanov Ivan Mikhailovich 14 M\nPetrov Fedor Mikhailovich 67 M\nFedorova Irina Ivanovna 17 F".formatted());

        try (FileWriter writer = new FileWriter(file)) {
            while (scan.hasNext()) {
                String newStr = scan.nextLine();
                writer.write(newStr);
                writer.append('\n');

                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e);
        }

        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e);
        }

        // Формирование массивов данных

        ArrayList<String> firstNameList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> middleNameList = new ArrayList<>();
        ArrayList<Integer> ageList = new ArrayList<>();
        ArrayList<String> genderList = new ArrayList<>();
        ArrayList<Integer> idList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        ArrayList<String> resList = new ArrayList<>();
        int id = 0;
        while (true) {
            try {

                String str = sc.nextLine();
                resList.add(str);

                String [] temp = str.split(" ");

                firstNameList.add(temp[0]);
                nameList.add(temp[1]);
                middleNameList.add(temp[2]);
                ageList.add(Integer.parseInt(temp[3]));
                genderList.add(temp[4]);
                idList.add(id);

                id++;
            } catch (NoSuchElementException e) {
                break;
            }
        }

        // Сортировака по возрасту
        for (int idx: idList) {
            System.out.println(resList.get(idx));
        }

        int ageTemp;
        int idTemp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < ageList.size() - 1; i++) {
                if (ageList.get(i) > ageList.get(i + 1)) {
                    // age
                    ageTemp = ageList.get(i);
                    ageList.set(i, ageList.get(i + 1));
                    ageList.set(i + 1, ageTemp);
                    // id
                    idTemp = idList.get(i);
                    idList.set(i, idList.get(i + 1));
                    idList.set(i + 1, idTemp);
                    //trigger
                    sorted = false;
                }
            }
        }

        for (int idx: idList) {
            System.out.println(resList.get(idx));
        }
    }

}

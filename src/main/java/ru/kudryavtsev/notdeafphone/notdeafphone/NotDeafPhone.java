package ru.kudryavtsev.notdeafphone.notdeafphone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

    public class NotDeafPhone {

            public static void file () {

               try( FileInputStream inputStream = new FileInputStream("C:\\\\Users\\\\Kudryavtsev Gennady\\\\Desktop\\\\input.txt");
                FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\Kudryavtsev Gennady\\\\Desktop\\\\output.txt");) {
                   while (inputStream.available() > 0) //пока есть еще непрочитанные байты
                   {
                       int data = inputStream.read(); // прочитать очередной байт в переменную data
                       outputStream.write(data); // и записать его во второй поток
                   }

                   String out = " И засунул в output.txt";
                   outputStream.write(out.getBytes(StandardCharsets.UTF_8));

                   inputStream.close(); //закрываем оба потока. Они больше не нужны.
                   outputStream.close();

                   FileReader fileReader = new FileReader("C:\\\\Users\\\\Kudryavtsev Gennady\\\\Desktop\\\\output.txt");
                   int i;
                   while ((i = fileReader.read()) != -1) {
                       System.out.print((char) i);
                   }
               } catch (Exception e) {
                   System.out.println("Ошибка! Проверьте файл.");
               }
            }

    }

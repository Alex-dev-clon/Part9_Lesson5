package task1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
//во вновь созданную папку ./backup
public class Main {
    public static void main(String[] args) {

        Path target = Path.of("./backup");
        Path source = Path.of(".");

        createCopy(source, target);
    }

    /*
    Метод для копирования файлов
     */
    static void createCopy(Path source, Path target) {
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(source)) {
            //Проверяем есть ли уже такая папка
            if (!Files.isDirectory(target)) Files.createDirectory(target);
            for (Path file : dir) {
                //Проверяем что по полученному пути файл
                if (Files.isRegularFile(file)) {
                    String str = target + "\\" + file.getFileName();
                    //Проверяем существует ли уже файл по заданному пути
                    if (Files.notExists(Path.of(str))) {
                        Files.copy(file, Path.of(target + file.toString()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
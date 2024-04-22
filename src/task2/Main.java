package task2;

import java.io.FileOutputStream;
import java.io.IOException;

//Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
//и представляют собой, например, состояния ячеек поля для игры в крестики нолики,
//где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
//Такое предположение позволит хранить в одном числе типа int всё поле 3х3. Записать в файл 9 значений так,
//чтобы они заняли три байта.
public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 0, 1, 2, 3, 0};
        String fileName = "values.txt";
        writeArray(array, fileName);

    }

    //Запись в файл
    static void writeArray(int [] array, String fileName){
        try (FileOutputStream stream = new FileOutputStream(fileName)) {
            //запись в 3 байта
            for (int i = 0; i < 3; i++) {
                byte value = 0;
                //запись трёх значений в один байт
                for (int j = 0; j < 3; j++) {
                    value += (byte) (array[3 * i + j] << (j * 2));
                }
                stream.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static int[] createRandomArray(int arrayLength){
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i<arrayLength; i++){
            array[i] = random.nextInt(101);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred when writing to the file: " + e.getMessage());
        }
    }
    public static int[] readFileToArray(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String lines; 
            int[] array = new int[100];
            int index = 0;
            while ((lines = reader.readLine()) != null){
                array[index++] = Integer.parseInt(lines);
            }
            int[] result = new int[index];
            System.arraycopy(array, 0, result, 0, index);
            return result;

        } catch (IOException e) {
            System.err.println("An error occurred when reading the file: " + e.getMessage());
            return new int[0];
        }
    }
    public static void bubbleSort(int[] array) {
        boolean swap = true;
        while(swap){

            swap = false;
            for(int i = 0; i <array.length-1; i++){
                if(array[i] > array[i+1]) {
                    swap = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 100 to be randomly generated: ");
        int runs = scanner.nextInt();
        int[] randomArray = createRandomArray(runs);

        String filename = "randomIntegers.txt";
        writeArrayToFile(randomArray, filename);

        int[] arrayFromFile = readFileToArray(filename);
        
        bubbleSort(arrayFromFile);
        for (int num : arrayFromFile) {
            System.out.println(num + " ");
        }
        System.out.println();

        String sortedFileName = "sortedArray.txt";
        writeArrayToFile(arrayFromFile, sortedFileName);
    }


}

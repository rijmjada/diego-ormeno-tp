import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        final int col = 15;
        final int hasta = 1000000;
        
        try {
            FileWriter fileWriter = new FileWriter("numeros.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 1; i <= hasta; i++) {
                printWriter.print(i + "\t"); 
                if (i % col == 0) {
                    printWriter.println(); 
                }
            }

            printWriter.close();
            System.out.println("Los números se han guardado en el archivo 'numeros.txt'.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

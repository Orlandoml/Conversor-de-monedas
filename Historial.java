import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Historial {
    public void saveHistory(String message) {
        try {
            
            DateTimeFormatter formato = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            String fecha = LocalDateTime.now().format(formato);
            FileWriter escritor = new FileWriter("Historial.txt", true);

            escritor.write(message + " (" + fecha + ") \n");
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

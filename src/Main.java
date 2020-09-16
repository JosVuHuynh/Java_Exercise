import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathFolder = "C:\\Users\\hvv\\Desktop\\Code\\Design_Patten\\import"; //directory of folder import
        HandleRequire handleRequire = new HandleRequire(pathFolder);
        handleRequire.readFolder();
        try {
            handleRequire.watchService();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

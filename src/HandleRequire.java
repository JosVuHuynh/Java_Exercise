import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class HandleRequire {
    private final String pathFolder;

    public HandleRequire(String pathFolder) {
        this.pathFolder = pathFolder;
    }

    public void readFolder() {
        Path path = Paths.get(this.pathFolder);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.{csv}")) {
            for (Path file : stream) {
                FileFactory fileFactory = new FileFactory();
                FileOperation fileOperation = fileFactory.getFile("CSV");
                List<Company> companies = fileOperation.readFile(file);// read file , return list of Object
                // total capital
                System.out.println("-----------------------Read file " + file.getFileName() + "-------------------------------");
                System.out.println("2. Total capital of headquarters is " + fileOperation.totalCapital(companies));
                // name of companies
                System.out.println("3. the name of companies that the country is in “CH” is");
                for (String name : fileOperation.nameOfCompanies(companies)) {
                    System.out.println(name + " ");
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            x.printStackTrace();
        }
    }

    public  void watchService() throws IOException, InterruptedException {
        Path path = Paths.get(this.pathFolder);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind" + event.kind() + ". File affected" + event.context() + ".");
            }
            System.out.println("--------------After Change--------------------------------------");
            readFolder();
            key.reset();
        }
        watchService.close();
    }
}

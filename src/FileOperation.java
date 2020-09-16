import java.nio.file.Path;
import java.util.List;

public interface FileOperation {
    List<Company> readFile(Path path);
    int totalCapital(List<Company> companies);
    List<String> nameOfCompanies(List<Company> companies);
}

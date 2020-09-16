public class FileFactory {
    public FileOperation getFile(String fileType) {
        if (fileType.equalsIgnoreCase("CSV")) {
            return new CSVReader();
        }
    return null;
    }
}

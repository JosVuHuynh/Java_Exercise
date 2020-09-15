public class App {
    public static void main(String[] args) {
        String path= "C:\\Users\\hvv\\Desktop\\Code\\Design_Patten\\Exercises\\companies.csv";
        FileFactory fileFactory = new FileFactory();
        FileOperation file = fileFactory.getFile("CSV");
        file.readFile(path);
        System.out.println(file.readFile(path));
    }
}

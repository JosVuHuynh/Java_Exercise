import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements FileOperation {
    @Override
    public List<Company> readFile(String fileName) {
        List<Company> companies = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line!=null){
                String[] attribute = line.split(",",-1);
                Company company = new Company(Integer.parseInt(attribute[0])
                                                ,attribute[1]
                                                ,attribute[2]
                                                ,Integer.parseInt(attribute[3])
                                                ,attribute[4]
                                                ,Boolean.parseBoolean(attribute[5]));
                companies.add(company);
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        int sum = companies.stream()
                .filter(x->x.getCountry() == "CH")
                .map(x->x.getCapital())
                .reduce(0,(a,b)->a+b);
        System.out.println(sum);
        return companies;
    }
    public void filterCapital(List<Company> companies){
        int sum = companies.stream()
                 .filter(x->x.getCountry() == "CH")
                 .map(x->x.getCapital())
                 .reduce(0,(a,b)->a+b);

        System.out.println(sum);
    }

}

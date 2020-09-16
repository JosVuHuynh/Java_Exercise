import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader implements FileOperation {
    @Override
    public List<Company> readFile(Path fileName) {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(fileName, StandardCharsets.US_ASCII)){
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line!=null){
                String[] attribute = line.split(",");
                if (attribute.length == 6){
                    Company company = new Company.CompanyBuilder(Integer.parseInt(attribute[0]),attribute[1])
                                                 .withFoundationDate(attribute[2])
                                                 .withCapital(Integer.parseInt(attribute[3]))
                                                 .withCountry(attribute[4])
                                                 .withIsHeadQuater(Integer.parseInt(attribute[5]) == 1)
                                                 .build();
                    companies.add(company);
                }
                else{
                    Company company = new Company.CompanyBuilder(Integer.parseInt(attribute[0]),attribute[1])
                            .withFoundationDate(attribute[2])
                            .withCapital(Integer.parseInt(attribute[3]))
                            .withCountry(attribute[4])
                            .withIsHeadQuater(null)
                            .build();
                    companies.add(company);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return companies;
    }
    @Override
    public int totalCapital(List<Company> companies){
       return companies.stream()
                       .filter(x->x.isHeadQuater()!=null && x.isHeadQuater() && x.getCountry().equals("CH"))
                       .map(Company::getCapital)
                       .reduce(0, Integer::sum);
    }

    @Override
    public List<String> nameOfCompanies(List<Company> companies) {
        return companies.stream()
                        .filter(x-> x.getCountry().equals("CH"))
                        .map(Company::getName)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
    }

}

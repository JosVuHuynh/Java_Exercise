public class Company {
    private int id ;
    private String name ;
    private String foundationDate;
    private int capital;
    private String country;
    private Boolean isHeadQuater;

    public Company(int id, String name, String foundationDate, int capital, String country, Boolean isHeadQuater) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.capital = capital;
        this.country = country;
        this.isHeadQuater = isHeadQuater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean isHeadQuater() {
        return isHeadQuater;
    }

    public void setHeadQuater(Boolean headQuater) {
        isHeadQuater = headQuater;
    }

    public static class CompanyBuilder{
        private int id ;
        private String name ;
        private String foundationDate;
        private int capital;
        private String country;
        private Boolean isHeadQuater;

        public CompanyBuilder(int id, String name){
            this.id = id;
            this.name = name;
        }
        public CompanyBuilder withFoundationDate(String foundationDate){
            this.foundationDate = foundationDate;
            return this;
        }
        public CompanyBuilder withCapital(int capital){
            this.capital = capital;
            return this;
        }
        public CompanyBuilder withCountry(String country){
            this.country = country;
            return this;
        }
        public CompanyBuilder withIsHeadQuater(Boolean isHeadQuater){
            this.isHeadQuater = isHeadQuater;
            return this;
        }
        public Company build(){
            Company company = new Company(this.id,this.name,this.foundationDate,this.capital,this.country,this.isHeadQuater);
            return company;
        }
    }
}

public class Company {
    private int id ;
    private String name ;
    private String foundationDate;
    private int capital;
    private String country;
    private boolean isHeadQuater;

    public Company(int id, String name, String foundationDate, int capital, String country, boolean isHeadQuater) {
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

    public boolean isHeadQuater() {
        return isHeadQuater;
    }

    public void setHeadQuater(boolean headQuater) {
        isHeadQuater = headQuater;
    }
}

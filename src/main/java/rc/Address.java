package rc;

public class Address {
    private String city;
    private String country;

    protected Address() {}

    public Address(String city, String county) {
        this.city = city;
        this.country = county;
    }

    public String getCity() { return city; }

    public String getCountry() { return country; }
}

package dto;


//lombok : https://galid1.tistory.com/531

public class Product {

    int id;
    String name;
    float price;
    String countryCode;


    public Product(int id, String name, float price, String countryCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.countryCode = countryCode;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}

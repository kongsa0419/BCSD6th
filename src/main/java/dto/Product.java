package dto;


//lombok : https://galid1.tistory.com/531

public class Product {

    int id;
    String name;
    float price;
    String countryCode;

/*
생성자를 이렇게쓰니까 new Product()할때 일일히 넣어줘야돼서 피곤해지더라...
롬복쓰면 좋을듯
    public Product(int id, String name, float price, String countryCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.countryCode = countryCode;
    }
*/
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

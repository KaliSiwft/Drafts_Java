package Phone;

public class Phone {
    private String brand;
    private double price;
    private String colour;

    public Phone() {
    }

    public Phone(String brand, double price, String colour) {
        this.brand = brand;
        this.price = price;
        this.colour = colour;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * 设置
     * @param colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString() {
        return "Phone{brand = " + brand + ", price = " + price + ", colour = " + colour + "}";
    }
}

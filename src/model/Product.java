package src.model;

// 产品模型类
public class Product {
    private String name;
    private String description;
    private int availNum;
    private double price;
    private Address manufactureAddress; // 生产地址
    private Address shippingAddress;    // 发货地址

    // 构造方法
    public Product(String name, String description, int availNum, double price,
                   Address manufactureAddress, Address shippingAddress) {
        this.name = name;
        this.description = description;
        this.availNum = availNum;
        this.price = price;
        this.manufactureAddress = manufactureAddress;
        this.shippingAddress = shippingAddress;
    }

    // Getter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailNum() {
        return availNum;
    }

    public void setAvailNum(int availNum) {
        this.availNum = availNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Address getManufactureAddress() {
        return manufactureAddress;
    }

    public void setManufactureAddress(Address manufactureAddress) {
        this.manufactureAddress = manufactureAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // 写toString，方便展示产品详情
    @Override
    public String toString() {
        return "=== Product Details ===\n" +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Available Quantity: " + availNum + "\n" +
                "Price: $" + String.format("%.2f", price) + "\n\n" +
                "--- Manufacture Address ---\n" + manufactureAddress + "\n\n" +
                "--- Shipping Address ---\n" + shippingAddress;
    }

}

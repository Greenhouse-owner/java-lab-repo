package src.model;

// 地址模型类
public class Address {
    private String streetName;
    private String unitNum;
    private String city;
    private String zipCode;

    // 构造方法
    public Address(String streetName, String unitNum, String city, String zipCode) {
        this.streetName = streetName;
        this.unitNum = unitNum;
        this.city = city;
        this.zipCode = zipCode;
    }

    // Getter方法
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // 重写toString，方便展示
    @Override
    public String toString() {
        return "Street: " + streetName + "\n" +
                "Unit: " + unitNum + "\n" +
                "City: " + city + "\n" +
                "ZIP Code: " + zipCode;
    }
}
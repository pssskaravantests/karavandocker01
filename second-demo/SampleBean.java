public class SampleBean {

    private String name;
    private String houseNumber;
    private String city;
    private String province;
    private String postalCode;

    public SampleBean(String name, String houseNumber, String city, String province, String postalCode) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public SampleBean() {
        this.name = "N/A";
        this.houseNumber = "N/A";
        this.city = "N/A";
        this.province = "N/A";
        this.postalCode = "N/A";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "SampleBean{" +
                "\n\tname='" + name + '\'' +
                ",\n\thouseNumber='" + houseNumber + '\'' +
                ",\n\tcity='" + city + '\'' +
                ",\n\tprovince='" + province + '\'' +
                ",\n\tpostalCode='" + postalCode + '\'' +
                "\n\t}";
    }
}
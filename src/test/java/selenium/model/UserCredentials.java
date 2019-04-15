package selenium.model;

import com.opencsv.bean.CsvBindByName;

public class UserCredentials {
    @CsvBindByName(column = "firstname")
    private String firstName;

    @CsvBindByName(column = "lastname")
    private String lastName;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "phone")
    private String phone;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "city")
    private String city;

    @CsvBindByName(column = "state")
    private String state;

    @CsvBindByName(column = "zip")
    private String zip;

    @CsvBindByName(column = "domain")
    private String domain;

    @CsvBindByName(column = "hosting")
    private String hosting;

    @CsvBindByName(column = "project_description")
    private String projectDescription;

    public UserCredentials(String[] csvInputLine) {
        this.firstName = csvInputLine[0];
        this.lastName = csvInputLine[1];
        this.email = csvInputLine[2];
        this.phone = csvInputLine[3];
        this.address = csvInputLine[4];
        this.city = csvInputLine[5];
        this.state = csvInputLine[6];
        this.zip = csvInputLine[7];
        this.domain = csvInputLine[8];
        this.hosting = csvInputLine[9];
        this.projectDescription = csvInputLine[10];

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setHosting(String hosting) {
        this.hosting = hosting;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getDomain() {
        return domain;
    }

    public String getHosting() {
        return hosting;
    }

    public String getProjectDescription() {
        return projectDescription;
    }
}

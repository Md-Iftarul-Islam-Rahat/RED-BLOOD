package models;

public class DonorInfo {
    private int id;
    private String full_Name;
    private String nick_Name;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private String blood_group;
    private String phone;
    private String address;
    private String country;

    public DonorInfo() {
    }

    public DonorInfo(String full_Name, String nick_Name, String email, String password, String dob, String gender, String blood_group, String phone, String address, String country) {
        this.full_Name = full_Name;
        this.nick_Name = nick_Name;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.blood_group = blood_group;
        this.phone = phone;
        this.address = address;
        this.country = country;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public String getNick_Name() {
        return nick_Name;
    }

    public void setNick_Name(String nick_Name) {
        this.nick_Name = nick_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

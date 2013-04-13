package li.koly.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String sex;


    public ArrayList<String> getHouse() {
        return house;
    }

    public void setHouse(ArrayList<String> house) {
        this.house = house;
    }

    private ArrayList<String> house;

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    private ArrayList<String> skills;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    private List sexOptions;
    private boolean isRich;

    public List getSexOptions() {
        return sexOptions;
    }

    public void setSexOptions(List sexOptions) {
        this.sexOptions = sexOptions;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean getIsRich() {
        return isRich;
    }

    public void setIsRich(boolean rich) {
        isRich = rich;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package main.springMVC.Model;

import java.util.LinkedHashMap;

public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String team;
    private String magic;
    private String programmingLanguage;

    private LinkedHashMap<String, String> teamOptions;
    private LinkedHashMap<String, String> programmingLanguageOptions;

    private String[] emotionOptions;

    public User(){
        // populate team list
        teamOptions = new LinkedHashMap<>();
        teamOptions.put("0", "Good");
        teamOptions.put("1", "Evil");
        teamOptions.put("2", "Unknown");

        // populate programming list
        programmingLanguageOptions = new LinkedHashMap<>();
        programmingLanguageOptions.put("0", "C");
        programmingLanguageOptions.put("1", "C#");
        programmingLanguageOptions.put("2", "C++");
        programmingLanguageOptions.put("3", "Java");
        programmingLanguageOptions.put("4", "Python");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LinkedHashMap<String, String> getTeamOptions() {
        return teamOptions;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public LinkedHashMap<String, String> getProgrammingLanguageOptions() {
        return programmingLanguageOptions;
    }

    public String[] getEmotionOptions() {
        return emotionOptions;
    }

    public void setEmotionOptions(String[] emotionOptions) {
        this.emotionOptions = emotionOptions;
    }
}

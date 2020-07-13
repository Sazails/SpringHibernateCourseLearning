package org.sazails;

import java.util.Arrays;

public class UserExtraInfo {
    private String hobby;
    private String birthday;
    private String[] languages;

    public UserExtraInfo() {}

    public UserExtraInfo(String hobby, String birthday, String[] languages) {
        this.hobby = hobby;
        this.birthday = birthday;
        this.languages = languages;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "org.sazails.UserExtraInfo{" +
                "hobby='" + hobby + '\'' +
                ", birthday='" + birthday + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}

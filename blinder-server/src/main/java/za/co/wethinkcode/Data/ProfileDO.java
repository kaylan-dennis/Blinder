package za.co.wethinkcode.Data;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileDO {
    public int id;
    public String name;
    public String surname;
    public String email;
    public int age;
    public String gender;
    public String hash;
    public String preference;
    public String bio;
    public String interests;
    public String likes;

    public ProfileDO() {}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPreference() {
        return this.preference;
    }

    public JSONArray getBio() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(this.bio);
    }

    public JSONArray getInterests() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(this.interests);
    }

    public JSONArray getLikes() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(this.likes);
    }

}
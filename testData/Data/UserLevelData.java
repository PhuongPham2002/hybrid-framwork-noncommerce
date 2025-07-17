package Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserLevelData {
    public static UserLevelData getUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH+"User.json"), UserLevelData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty ("Register")
    Register register;
    static class Register{
        @JsonProperty("fullname")
        private String fullName;
    }

    @JsonProperty ("Login")
    Login login;
    static class Login {
        @JsonProperty("username")
        private String userName;
        @JsonProperty("password")
        private String password;
    }

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty ("lastName")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Login getLogin() {
        return login;
    }

    public Register getRegister() {
        return register;
    }
    public String getFullname() {
        return register.fullName;
    }
    public String getUsername (){
        return login.userName;
    }
    public String getPassword (){
        return login.password;
    }
}

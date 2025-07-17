package Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import getterSetter.User;

import java.io.File;

public class UserData {
    public static UserData getUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH+"User.json"), UserData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @JsonProperty ("firstName")
    private String firstName;
    @JsonProperty ("lastName")
    private String lastName;
    @JsonProperty ("editFirstname")
    private String editFirstname;
    @JsonProperty ("editLastname")
    private String editLastName;
    @JsonProperty ("driverLicense")
    private String driverLicense;
    @JsonProperty ("expiryDate")
    private String expiryDate;
    @JsonProperty ("nation")
    private String nation;
    @JsonProperty ("maritalStatus")
    private String maritalStatus;
    @JsonProperty ("dateOfBirth")
    private String dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEditFirstname() {
        return editFirstname;
    }

    public String getEditLastName() {
        return editLastName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getNation() {
        return nation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}


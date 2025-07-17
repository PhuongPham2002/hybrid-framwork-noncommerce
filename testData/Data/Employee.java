package Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.util.List;

public class Employee {
    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("skilltree")
    private List<String> skillTree;

    @JsonProperty("address")
    private Address address;

    public static Employee getEmployee(){
        try{
            ObjectMapper  mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH+"Employee.json"),Employee.class);
        }
        catch (Exception exp){
            exp.printStackTrace();
            return null;
        }
    }

    public static class Address {
        @JsonProperty("street")
        private String street;
        @JsonProperty("streetNo")
        private String streetNumber;

        public String getStreet() {
            return street;
        }

        public String getStreetNumber() {
            return streetNumber;
        }
    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public List<String> getSkillTree() {
        return skillTree;
    }

    public Address getAddress() {
        return address;
    }
}

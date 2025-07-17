package Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.util.List;

public class EmployeeList {
    @JsonProperty("employees")
    private List<Employee> employeeList;
    public List<Employee> getEmployee() {
        return employeeList;
    }



    public static EmployeeList getEmployeeList(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH+"EmployeeList.json"), EmployeeList.class);
        }
        catch (Exception exp){
            exp.printStackTrace();
            return null;
        }
    }


    public static class Employee {
        String name;
        @JsonProperty("email")
        String emailAddress;
        String age;

        public String getName() {
            return name;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public String getAge() {
            return age;
        }
    }

}

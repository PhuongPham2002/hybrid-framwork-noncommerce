package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInfo {
    private String firstName,lastName,editFirstname, editLastName,driverLicense,expiryDate,nation,maritalStatus,dateOfBirth;

    public static UserInfo getUserData(){
        return new UserInfo();
    }

}

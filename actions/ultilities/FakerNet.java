package ultilities;


import net.datafaker.Faker;

public class FakerNet {
    private Faker faker = new Faker();
    public static FakerNet getFaker() {
        return new FakerNet();
    }
    public String getEmailAddress () {
        return faker.internet().emailAddress();
    }
    public String getFirstName () {
        return faker.name().firstName();
    }

    public String getLastName () {
        return faker.name().lastName();
    }
    public String getFullName(){
        return faker.name().fullName();
    }
    public  String getCity(){
        return faker.address().city();
    }
    public String getFullAddress(){
        return faker.address().fullAddress();
    }
    public String getZipcode(){
        return faker.address().zipCode();
    }

    public String getCompanyName(){
        return faker.company().name();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getPassword(){
        return faker.internet().password(10,20); }//10-20 kí tự
}

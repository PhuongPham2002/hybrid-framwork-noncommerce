package getterSetter;

public class Test {
    public static void main(String[] args) {
//        UserGetter user = new UserGetter();
//        System.out.println(user.getEmailAddress());
//        System.out.println(user.getFirstName());
//        System.out.println(user.getLastName());
//
//        UserSetter userSetter = new UserSetter();
//        userSetter.setEmailAddress("mocnguyen2002@gmail.com");
//        userSetter.setFirstName("Moc");
//        userSetter.setLastName("Nguyen");
//
//        User use = new User();
//        use.setEmailAddress("mocnguyen2002@gmail.com");
//        use.setFirstName("Ho");
//        use.setLastName("Stephen");
//
//        System.out.println(use.getEmailAddress());
//        System.out.println(use.getFirstName());
//        System.out.println(use.getLastName());

        UserLombok userLombok = new UserLombok();
        userLombok.setEmailAddress("a@gmail.com");
        userLombok.setFirstName("Phuong");
        userLombok.setLastName("Minh");

        System.out.println(userLombok.getEmailAddress());
        System.out.println(userLombok.getFirstName());
        System.out.println(userLombok.getLastName());


    }
}

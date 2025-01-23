package keywords;

public class Animals {
    int age ;
    String name ;
    public Animals(int animalAge, String animalName){
        name = animalName;
        age = animalAge;
    }
    public void eat(){
        System.out.println(name + " is eating");
    }
    public void sleep () {
        System.out.println(name + " is sleeping");
    }
}

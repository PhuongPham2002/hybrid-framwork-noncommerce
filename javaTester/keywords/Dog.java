package keywords;

public class Dog extends Animals{
    public Dog(int animalAge, String animalName) {
        super(animalAge, animalName);
    }
    public void bark(){
        System.out.println(name + " is barking");
    }

    public static void main(String[] args) {
        Dog dog = new Dog(2,"Lucy");
        dog.eat();
        dog.sleep();
        dog.bark();
    }
}


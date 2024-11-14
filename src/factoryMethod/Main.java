package factoryMethod;

// Product interface
interface Animal {
    void speak();
}

// Concrete Product 1
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Concrete Product 2
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Creator abstract class
abstract class AnimalFactory { // 공장 
    // Factory Method
    public abstract Animal createAnimal(); // API만 정함

    public void makeAnimalSpeak() {
        Animal animal = createAnimal();
        animal.speak();
    }
}

// Concrete Creator 1
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

// Concrete Creator 2
class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeAnimalSpeak(); // Output: Woof!

        AnimalFactory catFactory = new CatFactory();
        catFactory.makeAnimalSpeak(); // Output: Meow!
    }
}
package abstractFactory;

// 제품군
// Abstract product A
interface Chair {
    void sitOn();
}

// Concrete product A1
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

// Concrete product A2
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern chair.");
    }
}

// Abstract product B
interface Sofa {
    void lieOn();   // 눕는 기능
}

// Concrete product B1
class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Victorian sofa.");
    }
}

// Concrete product B2
class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Modern sofa.");
    }
}

// 팩토리(공장)
// Abstract factory
interface FurnitureFactory {    // 공장을 위한 인터페이스(의자, 소파 만들어요)
    Chair createChair();
    Sofa createSofa();
}

// Concrete factory 1
class VictorianFurnitureFactory implements FurnitureFactory {   // Victorian 관련 의자, 소파
    @Override
    public Chair createChair() {
        // 이런 부가적인 로직을 공장이 따로 진행하므로 클라이언트는 제품 생성 과정으로부터 독립적
        System.out.println("Creating a Victorian chair")
        
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

// Concrete factory 2
class ModernFurnitureFactory implements FurnitureFactory {  // Modern 관련 의자, 소파
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // if 패턴이 없다면 제품을 직접 선택했을 것임
        Chair chair = new VictorianChair();
        chair.sitOn();
        Sofa sofa = new VictorianSofa();
        sofa.lieOn();

        // 공장을 이용해서 제품을 생성하도록 하는게 AbstractFactory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();

        victorianChair.sitOn();
        victorianSofa.lieOn();

        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();

        modernChair.sitOn();
        modernSofa.lieOn();
    }
}
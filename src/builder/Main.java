package builder;

// Product class
class House {
    private String foundation;
    private String structure;
    private String roof;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + "]";
    }
}

// Builder interface
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    House getHouse();
}

// Concrete Builder 1
class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Wooden foundation");
        System.out.println("WoodenHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wooden structure");
        System.out.println("WoodenHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wooden roof");
        System.out.println("WoodenHouseBuilder: Roof complete...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Concrete Builder 2
class BrickHouseBuilder implements HouseBuilder {
    private House house;

    public BrickHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Brick foundation");
        System.out.println("BrickHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Brick structure");
        System.out.println("BrickHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Brick roof");
        System.out.println("BrickHouseBuilder: Roof complete...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Director
class ConstructionEngineer {
    private HouseBuilder houseBuilder;  // 부모 타입 : 나무집빌더와 벽돌집빌더 둘 다 받을 수 있음

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();    //기초작업
        this.houseBuilder.buildStructure();     //구조물작업
        this.houseBuilder.buildRoof();          //지붕작업
        return this.houseBuilder.getHouse();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // 엔지니어한테 부탁해서 빌더를 통해 집을 만들어 달라고 요청
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        ConstructionEngineer engineer1 = new ConstructionEngineer(woodenHouseBuilder);
        House woodenHouse = engineer1.constructHouse();
        System.out.println("House is: " + woodenHouse);

        HouseBuilder brickHouseBuilder = new BrickHouseBuilder();
        ConstructionEngineer engineer2 = new ConstructionEngineer(brickHouseBuilder);
        House brickHouse = engineer2.constructHouse();
        System.out.println("House is: " + brickHouse);
    }
}
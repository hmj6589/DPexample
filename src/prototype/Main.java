package prototype;

class Employee implements Cloneable { // 복제가 가능함을 나타내기 위해 Clonable 인터페이스 구현
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public Employee clone() { // 복제메소드
        try {
            return (Employee) super.clone(); // Object.clone() 이 호출됨
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name);
    }
}

// 클라이언트
public class Main {
    public static void main(String[] args) {
        Employee originalEmployee = new Employee("John Doe");
        Employee clonedEmployee = originalEmployee.clone(); // 복제품을 얻음

        originalEmployee.introduce(); // Output: Hi, my name is John Doe
        clonedEmployee.introduce();   // Output: Hi, my name is John Doe
    }
}
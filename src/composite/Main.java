package composite;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface FileSystemComponent {
    void showDetails();
}

// Leaf class
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite class
class Directory implements FileSystemComponent { // 복합 객체
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>(); // 개별 객체를 담는 컬렉션

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {     // 재귀적 호출을 이용함
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();    // 자기 자식의 showDetails 호출
        }
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // 개별 객체 생성
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("hmj.txt");

        // 복합(합성) 객체 생성
        Directory dir1 = new Directory("dir1");
        dir1.addComponent(file1); // 개별 객체 추가(트리 구조 구성하는 중)
        dir1.addComponent(file3);

        Directory dir2 = new Directory("dir2");
        dir2.addComponent(file2);
        dir2.addComponent(dir1);

        dir2.showDetails(); // dir2 루트 노드에게 일을 시킴
    }
}
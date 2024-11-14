package adapter;

// Target interface
interface Socket {
    String getOutput(); // 클라이언트가 원하는 이름
}

// Adaptee class
class EuropeanSocket {
    public String getEuropeanOutput() { // 클라이언트가 원하는 메소드 이름이 아님
        return "220V";
    }
}

// Adapter class
class SocketAdapter implements Socket { // 어댑터 클래스
    private EuropeanSocket europeanSocket; // 어댑터 클래스가 어뎁티 클래스 포함

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public String getOutput() {
        return europeanSocket.getEuropeanOutput(); // 실제 일은 어댑터 클래스에 위임
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        EuropeanSocket europeanSocket = new EuropeanSocket();   // 유럽 소켓
        Socket socketAdapter = new SocketAdapter(europeanSocket);   // 유럽 소켓을 한국 소켓으로 변환
        System.out.println("Socket output: " + socketAdapter.getOutput());
    }
}
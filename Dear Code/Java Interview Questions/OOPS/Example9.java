import java.io.IOException;
import java.sql.SQLException;

class A {
    void show() throws SQLException {
        System.out.println("Inside A");
    }
}

class B extends A {
    void show(){
        System.out.println("Inside B");
    }
}

public class Example9 {
    public static void main(String[] args) {
        
    }
}

package Exceptions;

public class Exceptions extends Exception {
    String message;

    public Exceptions(String msg) {
        this.message = msg;
    }

    public void Message() {
        System.out.println("Error : " + message);
    }
}

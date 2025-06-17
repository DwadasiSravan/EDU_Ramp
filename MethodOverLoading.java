public class MethodOverLoading {
    void display(int num) {
        System.out.println("Number: " + num);
    }

    void display(int num1, int num2) {
        System.out.println("Numbers: " + num1 + ", " + num2);
    }

    void display(String str) {
        System.out.println("Message: " + str);
    }

    public static void main(String[] args) {
        MethodOverLoading obj = new MethodOverLoading();
        obj.display(10);
        obj.display(20, 30);
        obj.display("Hello, World!");
    }
}

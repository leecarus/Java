package Chap19;

public class GenericStackQuiz1 {
    public static void main(String[] args) {
        GenericStack<Object> stack1 = new GenericStack<>();
        stack1.push("London");
        stack1.push("Paris");
        stack1.push("Berlin");
        stack1.peek();
        stack1.pop();
        stack1.push(5);
        stack1.push(-5);
        stack1.push("Seoul");
        stack1.pop();
        stack1.peek();
        System.out.println("(1) " + stack1.peek());
        System.out.println("(2) " + stack1.pop());
        System.out.println("(3) " + stack1);
    }
}

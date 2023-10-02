package Chap19;

public class GenericStackQuiz2 {
    public static void main(String[] args) {
        GenericStack<Double> stack1 = new GenericStack<>();
        GenericStack<Object> stack2 = new GenericStack<>();

        stack1.push(Double.valueOf(1));
        stack1.push(2.0);
        stack1.push((double) -2);
        stack1.push(-1.0);
        stack2.push("London");
        stack2.push("Paris");
        stack2.push(3);
        stack2.push(4.0);
        stack1.peek();
        stack2.pop();
        System.out.println("(4) " + stack1.pop());
        System.out.println("(5) " + stack2.peek());
        System.out.println("(6) " + stack1);
        System.out.println("(7) " + stack2);

        add(stack1, stack2);
        System.out.println("(8) " + stack1);
        System.out.println("(9) " + stack2);
    }

    public static <T> void add(GenericStack<T> stack1, GenericStack <? super T> stack2) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
}

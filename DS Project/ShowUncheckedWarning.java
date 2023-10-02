import java.util.ArrayList;

public class ShowUncheckedWarning {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Red");
        list.add("White");
        String s = list.get(0);
        System.out.println(s);
    }
}

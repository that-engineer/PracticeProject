import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        System.out.println("Hi there");
        List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("Chinese");

        list = manipulateList(list);
        printList(list);
        list.add(1,"Test");
        System.out.println();
        System.out.println("After Test ");

        printList(list);

        List<String > list1;
        list1=list;
        List<String > list2 = new ArrayList<String>(list);
        list.remove(1);
        System.out.println("List");
        printList(list);
        System.out.println("List1");
        printList(list1);
        System.out.println("List2 ");
        printList(list2);
    }
    public static List<String> manipulateList(List<String> list){
        list.add("Spanish");
        list.add("French");
        list.add("Japanese");
       return list;
    }

    public static void printList(List<String> list){
        System.out.println();
        for (String s:list
        ) {
            System.out.println(s);
        }
        System.out.println();
    }
}

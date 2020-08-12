import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Test {

    public enum E {

        E1("AAA", 1),
        E2("BBB", 2),
        E3("CCC", 3),
        E4("DDD", 4),
        ;

        E(String field1, int field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public String getField1() {
            return field1;
        }

        public int getField2() {
            return field2;
        }

        private String field1;
        private int field2;
    }

    public static void main(String[] args) {
//        Map<String, Integer> testMap = new HashMap<>();
//        testMap.put("1", 1);
//        System.out.println(testMap);
//
//        Hashtable<String, Integer> ht = new Hashtable<>();

        System.out.println(Arrays.toString(E.values()));
    }
}

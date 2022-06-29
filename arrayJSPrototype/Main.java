package arrayJSPrototype;

public class Main {

    public static void main(String[] args) {
        ArrayJSPrototype<String> obj = new ArrayJSPrototype<>();

        try {
            obj.push("a");
            obj.push("b");
            obj.push("w");
            obj.push("X");
            obj.push("y");
            obj.push("z");

            // obj.delete(3);

            System.out.println("Before The Splice");
            for (int i = 0; i <= obj.size(); i++) {
                System.out.print(obj.get(i) + " ");
            }
            System.out.println();

            obj.splice(2, 900, "c", "d", "e", "f");

            System.out.println("After the splice");
            for (int i = 0; i <= obj.size(); i++) {
                System.out.print(obj.get(i) + " ");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

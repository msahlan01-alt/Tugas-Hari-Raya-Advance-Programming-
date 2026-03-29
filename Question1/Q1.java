package Question1; // package name sesuai dengan nama folder
import java.util.*;
public class Q1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("MORIOH'S HIDDEN DANGER");
        System.out.print("Input Hidden Message: ");
        String input = sc.nextLine();

        HiddenMessage hm = new HiddenMessage();
        String[] result = hm.process(input);

        System.out.print("Output Hidden Message: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}

class HiddenMessage {
    private static int getMonthValue(String month) {
        month = month.toLowerCase();
        return switch (month) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };
    }

    public String[] process(String input) {
        Stack<String> stack = new Stack<>();
        String[] words = input.split(" ");

        for (String w : words) {
            stack.push(w);
        }

        int n = words.length / 2;
        List<String[]> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String month = stack.pop();
            String name = stack.pop();
            pairs.add(new String[]{name, month});
        }

        pairs.sort((a, b) -> getMonthValue(a[1]) - getMonthValue(b[1]));

        Stack<String> resultStack = new Stack<>();
        for (String[] p : pairs) {
            resultStack.push(p[0]);
            resultStack.push(p[1]);
        }

        String[] result = new String[resultStack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = resultStack.pop();
        }

        return result;
    }
}
package Question2; // package name sesuai dengan nama folder
import java.util.*;
public class Q2 {
    @SuppressWarnings({"ManualArrayToCollectionCopy", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String standName = sc.nextLine();
        String input = sc.nextLine();
        Queue<String> q = new LinkedList<>();
        for (String s : input.split(" ")) {
            q.add(s);
        }

        Stack<String> arrested = new Stack<>();

        Stand stand;
        if (standName.equals("Josuke")) stand = new Josuke();
        else if (standName.equals("Jotaro")) stand = new Jotaro();
        else if (standName.equals("Okuyasu")) stand = new Okuyasu();
        else if (standName.equals("Koichi")) stand = new Koichi();
        else if (standName.equals("Rohan")) stand = new Rohan();
        else stand = new Stand();
        while (!q.isEmpty()) {
            String name = q.poll();
            if (stand.expose(name)) {
                arrested.push(name.toLowerCase());
            }
        }

        // DISOAL WAJIB KIRA MASUK DIDALAM SUSPECT LIST, JADI KIRA MASUK KE STACK ARRESTED
        // arrested.push("kira");   // (bisa di uncomment untuk testing dan saya ragu kira masuk ke stack arrested karena nama "kira" memenuhi kriteria expose Josuke)

        if (arrested.size() > 0) {
            System.out.println(standName + " exposed someone!");
        } else {
            System.out.println(standName + " exposed no one.");
        }

        System.out.println("Arrested: " + arrested);
        sc.close();
    }
}

class Stand {
    public boolean expose(String name) {
        return false;
    }
}

class Josuke extends Stand {
    @Override
    public boolean expose(String name) {
        return name.toLowerCase().startsWith("k");
    }
}

class Jotaro extends Stand {
    @Override
    public boolean expose(String name) {
        return name.length() <= 3;
    }
}

class Okuyasu extends Stand {
    @Override
    public boolean expose(String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == name.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

class Koichi extends Stand {
    @Override
    public boolean expose(String name) {
        int count = 0;
        String v = "aeiouAEIOU";
        for (char c : name.toCharArray()) {
            if (v.indexOf(c) != -1) count++;
        }
        return count >= 3;
    }
}

class Rohan extends Stand {
    @Override
    public boolean expose(String name) {
        String s = name.toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
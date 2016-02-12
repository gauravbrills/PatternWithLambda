package patterns.decorator;

import java.util.function.Consumer;

/**
 * Created by grawat on 11/16/2015.
 */
public class Sample_Composite {
    public static void main(String[] args) {
        Mailer.send(mailer ->
                // cascade method pattern
                mailer.from("grawat@sapeint.com").to("ts@sapient.com").subject("code sucks").body("here u go .."));
    }

}

class Mailer {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public Mailer from(String addr) {
        print(addr);
        return this;
    }

    public Mailer to(String addr) {
        print("to");
        return this;
    }

    public Mailer subject(String line) {
        print("subject");
        return this;
    }

    public Mailer body(String msg) {
        print("body");
        return this;
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending..");
    }
}
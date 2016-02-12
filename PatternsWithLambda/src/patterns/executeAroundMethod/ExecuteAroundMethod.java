package patterns.executeAroundMethod;

import java.util.function.Consumer;

/**
 * Created by grawat on 11/16/2015.
 */
public class ExecuteAroundMethod {

    public static void main(String[] args) {
// JAVA 7 ARM - auto resource management
    /*    try (Resource resource = new Resource()) {
            resource.op1();
            resource.op2();
        }
    }*/
        Resource.use(resource -> resource.op1().op2());
    }
}

// autoCloseable resource
class Resource {

    private Resource() {
        System.out.println("created...");
    }

    public Resource op1() {
        System.out.println("op1");
        return this;
    }

    public Resource op2() {
        System.out.println("op2");
        return this;
    }

    private void close() {
        System.out.println("Cleanup");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}

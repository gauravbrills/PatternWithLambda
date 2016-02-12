import java.util.function.BiFunction;

/**
 * Created by grawat on 11/15/2015.
 */
public class OOPSFUNCDualism {
    private BiFunction<Cat, Bird, FullCat> story;

    public static void main(String[] args) {
        // emphasis on verbs rather than names in Functional programming
        // Functions compose better than objects
        BiFunction<Cat, Bird, FullCat> story = ((BiFunction<Cat, Bird, CatWithCatch>) Cat::capture).andThen(CatWithCatch::eat);
        FullCat fullCat = story.apply(new Cat(), new Bird());
    }
}

class Bird {
}

class Cat {
    public CatWithCatch capture(Bird bird) {
        return new CatWithCatch(bird);
    }
}

class CatWithCatch {
    // immutable
    private final Bird catcch;

    public CatWithCatch(Bird bird) {
        catcch = bird;
    }

    public FullCat eat() {
        return new FullCat();
    }
}

class FullCat {

}
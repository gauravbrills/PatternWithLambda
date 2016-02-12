package patterns.decorator;
import javafx.scene.Camera;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by grawat on 11/16/2015.
 */
public class Camera_venkat {
    private Function<Color, Color> filter;

    public Camera_venkat() {
        setFilters();
    }

    public Camera_venkat(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    private void setFilters(Function<Color, Color>... filters) {
        // identity function color -> color
        filter = Stream.of(filters).reduce(Function.identity(), (a, b) -> a.andThen(b));
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }

    public static void printSnap(Camera_venkat camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printSnap(new Camera_venkat());
        // decorate
        printSnap(new Camera_venkat(Color::brighter));
        // decorate more
        printSnap(new Camera_venkat(Color::darker));
    }
}

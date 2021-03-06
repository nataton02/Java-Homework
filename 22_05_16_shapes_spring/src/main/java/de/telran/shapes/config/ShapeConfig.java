package de.telran.shapes.config;

import de.telran.shapes.types.Line;
import de.telran.shapes.types.Picture;
import de.telran.shapes.types.Rectangle;
import de.telran.shapes.types.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShapeConfig {

    // lines
    @Bean
    @Qualifier("picture1")
    public Line line1() {
        return new Line('*', 20);
    }

    @Bean
    @Qualifier("picture1")
    public Line line2() {
        return new Line('X', 30);
    }

    @Bean
    @Qualifier("picture2")
    public Line line3() {
        return new Line('#', 30);
    }


    // rectangles
    @Bean
    @Qualifier("picture1")
    public Rectangle rectangle1() {
        return new Rectangle(':', 3, 20);
    }

    @Bean
    @Qualifier("picture2")
    public Rectangle rectangle2() {
        return new Rectangle('O', 3, 20);
    }


    // pictures
    @Bean
    public Picture picture1(@Qualifier("picture1") List<Shape> shapes) {
        return new Picture('=', 40, shapes);
    }

    @Bean
    public Picture picture2(@Qualifier("picture2") List<Shape> shapes) {
        return new Picture('=', 40, shapes);
    }
}

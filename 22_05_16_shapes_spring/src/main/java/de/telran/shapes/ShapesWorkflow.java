package de.telran.shapes;

import de.telran.shapes.types.Shape;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShapesWorkflow implements CommandLineRunner {

         private final Shape picture1;
         private final Shape picture2;

    public ShapesWorkflow(Shape picture1, Shape picture2) {
        this.picture1 = picture1;
        this.picture2 = picture2;
    }


    @Override
    public void run(String... args) throws Exception {

        picture1.draw();

        picture2.draw();

    }
}

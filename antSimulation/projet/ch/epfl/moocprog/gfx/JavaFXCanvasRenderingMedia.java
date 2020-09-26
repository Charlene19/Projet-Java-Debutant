package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.RenderingMedia;
import javafx.scene.canvas.Canvas;

public class JavaFXCanvasRenderingMedia extends Canvas implements RenderingMedia {
    public JavaFXCanvasRenderingMedia(int width, int height) {
        super(width, height);
    }
}

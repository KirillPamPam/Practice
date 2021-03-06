import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;

public class CreateImage {
    private int width, height;
    private BufferedImage bi;
    private Point point;
    private int size = 10;

    public CreateImage(int width, int height, Point point) {
        this.point = point;
        this.width = width;
        this.height = height;
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void drawImage(int radius) throws IOException {
        Graphics2D g2 = bi.createGraphics();
        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, width-1, height-1);
        for (PointPosition position: point.getPositions()) {
            g2.fillOval(position.getX()*10, position.getY()*10, size, size);
        }
        g2.setColor(Color.BLUE);
        g2.fillOval(point.getCenterX()*10, point.getCenterY()*10, size, size);

        ImageIO.write(bi, "PNG", new File("c:\\Practice.PNG"));
    }
}

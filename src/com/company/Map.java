package com.company;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.lang.Math;


public class Map {
    int numberOfHouses;
    int numberOfTrees;
    String filename;
    int houseSize = 100;
    int treeSize = 50;
    int imageSize = 1000;

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    int strokeSize = 5;

    public int getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    public int getTreeSize() {
        return treeSize;
    }

    public void setTreeSize(int treeSize) {
        this.treeSize = treeSize;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }

    public void setNumberOfTrees(int numberOfTrees) {
        this.numberOfTrees = numberOfTrees;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    /**
     * Generates the map using the defined parameters.
     * @throws IOException throws an IOException if unable to write to file
     */
    public void generateMap() throws IOException {
        //TODO: Find a way of ensuring that houses and trees aren't built on top of each other
        final BufferedImage image = new BufferedImage(this.imageSize, this.imageSize, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();

        graphics2D.setStroke(new BasicStroke(this.strokeSize));
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, this.imageSize, this.imageSize);

        for (int i=0; i<this.numberOfHouses; i++) {
            int randomHouseSize = (int) (Math.random() * this.houseSize);
            int randomX = (int) (Math.random() * this.imageSize - this.houseSize);
            int randomY = (int) (Math.random() * this.imageSize - this.houseSize);
            graphics2D.setPaint(Color.DARK_GRAY);
            graphics2D.fillRect(randomX, randomY, randomHouseSize, randomHouseSize);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawRect(randomX, randomY, randomHouseSize, randomHouseSize);
        }
        for (int j=0; j<this.numberOfTrees; j++) {
            int randomTreeSize = (int) (Math.random() * this.treeSize);
            int randomX = (int) (Math.random() * this.imageSize - this.treeSize);
            int randomY = (int) (Math.random() * this.imageSize - this.treeSize);
            graphics2D.setPaint(Color.GREEN);
            graphics2D.fillOval(randomX, randomY, randomTreeSize, randomTreeSize);
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawOval(randomX, randomY, randomTreeSize, randomTreeSize);
        }

        graphics2D.dispose();

        ImageIO.write(image, "png", new File(this.filename));
    }
}

package cn.hff.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import net.sourceforge.tess4j.TesseractException;

/**
 * 卧槽
 * <p>
 * Created by Holmofy on 2018/5/10.
 */
public class ImageUtilsTest {

    @Test
    public void testReduceInterference() throws IOException, TesseractException, InterruptedException {
        String text = ImageUtils.recognition(ImageIO.read(new File("C:\\Users\\19383\\Desktop\\output.jpg")));
        System.out.println(text);
    }

    @Test
    public void testImageProcess() throws IOException {
        BufferedImage originImage = ImageIO.read(new File("C:\\Users\\19383\\Desktop\\CheckCode.jpg"));
        BufferedImage processedImage = ImageUtils.binaryImage(ImageUtils.grayImage(ImageUtils.clipImage(originImage)));
        ImageIO.write(processedImage, "JPEG", new File("C:\\Users\\19383\\Desktop\\output.jpg"));
    }
}

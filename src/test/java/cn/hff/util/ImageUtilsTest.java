package cn.hff.util;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * 卧槽
 * <p>
 * Created by Holmofy on 2018/5/10.
 */
public class ImageUtilsTest {

    @Test
    public void testReduceInterference() throws IOException, TesseractException, InterruptedException {
        String text = ImageUtils.recognition(ImageIO.read(new File("C:\\Users\\19383\\Desktop\\CheckCode.jpg")));
        System.out.println(text);
    }
}

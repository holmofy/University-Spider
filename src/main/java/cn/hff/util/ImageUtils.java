package cn.hff.util;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * 识别验证码
 * <p>
 * Created by Holmofy on 2018/5/10.
 */
public class ImageUtils {


    private static ITesseract TESSERACT = new Tesseract();

    static {
        // 配置自己的训练数据
        TESSERACT.setDatapath("D:\\Java\\JavaProject\\UniversityTrack\\training\\tessdata");
        TESSERACT.setLanguage("myeng");
    }

    /**
     * 裁剪图片：去掉黑边
     */
    private static BufferedImage clipImage(BufferedImage srcImage) {
        return srcImage.getSubimage(1, 1, srcImage.getWidth() - 2, srcImage.getHeight() - 2);
    }

    /**
     * 灰度化
     */
    private static BufferedImage grayImage(BufferedImage srcImage) {
        return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY));
    }

    /**
     * 二值化
     */
    private static BufferedImage binaryImage(BufferedImage srcImage) {
        return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY));
    }

    private static BufferedImage copyImage(BufferedImage srcImage, BufferedImage destImage) {
        for (int y = 0; y < srcImage.getHeight(); y++) {
            for (int x = 0; x < srcImage.getWidth(); x++) {
                destImage.setRGB(x, y, srcImage.getRGB(x, y));
            }
        }
        return destImage;
    }

    /**
     * 识别验证码
     *
     * @param is 输入流，包含图片数据
     * @return 图片中的验证码
     */
    public static String recognition(InputStream is) throws IOException, TesseractException {
        return recognition(ImageIO.read(is));
    }

    /**
     * 识别验证码
     *
     * @param srcImage 图片
     * @return 图片中的验证码
     */
    public static String recognition(BufferedImage srcImage) throws TesseractException, IOException {
        BufferedImage reducedImage = binaryImage(grayImage(clipImage(srcImage)));
        return TESSERACT.doOCR(reducedImage).trim();
    }
}

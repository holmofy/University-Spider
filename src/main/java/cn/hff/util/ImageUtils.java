package cn.hff.util;

import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

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
    public static BufferedImage clipImage(BufferedImage srcImage) {
        return srcImage.getSubimage(1, 1, srcImage.getWidth() - 2, srcImage.getHeight() - 2);
    }

    /**
     * 灰度化
     */
    public static BufferedImage grayImage(BufferedImage srcImage) {
        return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY));
    }

    /**
     * 二值化
     */
    public static BufferedImage binaryImage(BufferedImage srcImage) {
        return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY));
    }

    public static BufferedImage copyImage(BufferedImage srcImage, BufferedImage destImage) {
        for (int y = 0; y < srcImage.getHeight(); y++) {
            for (int x = 0; x < srcImage.getWidth(); x++) {
                destImage.setRGB(x, y, srcImage.getRGB(x, y));
            }
        }
        return destImage;
    }

    /**
     * Convert to Grayscale color space
     */
    public static BufferedImage grayScale(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        ColorConvertOp grayScaleOp = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return operate(grayScaleOp, srcImage, destImage);
    }

    /**
     * Image negative. Multiply each color value by -1.0 and add 255
     */
    public static BufferedImage negative(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        RescaleOp negativeOp = new RescaleOp(-1.0f, 255f, null);
        return operate(negativeOp, srcImage, destImage);
    }

    /**
     * Brighten using a linear formula that increases all color values
     */
    public static BufferedImage brightenByRescale(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        RescaleOp brightenOp = new RescaleOp(1.25f, 0, null);
        return operate(brightenOp, srcImage, destImage);
    }

    // These arrays of bytes are used by the LookupImageOp image filters below
    private static byte[] brightenTable = new byte[256];
    private static byte[] thresholdTable = new byte[256];

    static { // Initialize the arrays
        for (int i = 0; i < 256; i++) {
            brightenTable[i] = (byte) (Math.sqrt(i / 255.0) * 255);
            thresholdTable[i] = (byte) ((i < 225) ? 0 : i);
        }
    }

    /**
     * Brighten using the lookup table defined above
     */
    public static BufferedImage brightenByLookup(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        LookupOp brightenOp = new LookupOp(new ByteLookupTable(0, brightenTable), null);
        return operate(brightenOp, srcImage, destImage);
    }

    /**
     * Threshold using the lookup table defined above
     */
    public static BufferedImage thresholdByLookup(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        LookupOp thresholdOp = new LookupOp(new ByteLookupTable(0, thresholdTable), null);
        return operate(thresholdOp, srcImage, destImage);
    }

    /**
     * Blur by "convolving" the image with a matrix
     */
    public static BufferedImage blur(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        ConvolveOp blurOp = new ConvolveOp(new Kernel(3, 3, new float[]{.1111f, .1111f,
                .1111f, .1111f, .1111f, .1111f, .1111f, .1111f, .1111f,}));
        return operate(blurOp, srcImage, destImage);
    }

    /**
     * Sharpen by using a different matrix
     */
    public static BufferedImage sharpen(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        ConvolveOp convolveOp = new ConvolveOp(new Kernel(3, 3, new float[]{0.0f, -0.75f, 0.0f,
                -0.75f, 4.0f, -0.75f, 0.0f, -0.75f, 0.0f}));
        return operate(convolveOp, srcImage, destImage);
    }

    /**
     * Edge detect using yet another matrix
     */
    public static BufferedImage edgeDetect(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        ConvolveOp convolveOp = new ConvolveOp(new Kernel(3, 3, new float[]{0.0f, -0.75f, 0.0f,
                -0.75f, 3.0f, -0.75f, 0.0f, -0.75f, 0.0f}));
        return operate(convolveOp, srcImage, destImage);
    }

    private static AffineTransform mirrorTransform;

    static { // Create and initialize the AffineTransform
        mirrorTransform = AffineTransform.getTranslateInstance(127, 0);
        mirrorTransform.scale(-1.0, 1.0); // flip horizontally
    }

    /**
     * Compute a mirror image using the transform defined above
     */
    public static BufferedImage mirror(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        AffineTransformOp convolveOp = new AffineTransformOp(mirrorTransform,
                AffineTransformOp.TYPE_BILINEAR);
        return operate(convolveOp, srcImage, destImage);
    }

    /**
     * Rotate the image 180 degrees about its center point
     */
    public static BufferedImage rotate(BufferedImage srcImage, @Nullable BufferedImage destImage) {
        AffineTransformOp convolveOp = new AffineTransformOp(AffineTransform.getRotateInstance(Math.PI,
                srcImage.getWidth() >> 1, srcImage.getHeight() >> 1), AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return operate(convolveOp, srcImage, destImage);
    }

    private static BufferedImage operate(BufferedImageOp op, BufferedImage srcImage, @Nullable BufferedImage destImage) {
        return op.filter(srcImage, destImage);
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
        ImageIO.write(reducedImage, "jpg", new File("./tmp/CheckCode.jpg"));
        return TESSERACT.doOCR(reducedImage).trim();
    }
}

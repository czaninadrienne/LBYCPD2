import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQR {
    // Function to create the QR code
    private static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
            throws WriterException, IOException
    {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }

    private static void chkDir() {
        File dir = new File("QR Codes");
        if (!dir.exists()){
            dir.mkdirs();
        }
    }

    // Driver code
    public static void run(String fName, String lName, int idNum) throws WriterException, IOException, NotFoundException {

        // The data that the QR code will contain
        String data = fName + "," + lName + "," + idNum;

        chkDir();

        // The path where the image will get saved
        String path = "QR Codes/me.png";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        createQR(data, path, charset, hashMap, 800, 800);
        System.out.println("QR Code Generated!!! ");
    }

    public static void run() throws WriterException, IOException, NotFoundException {
        run("Johnson", "Dela Cruz", 11800001);
    }
}

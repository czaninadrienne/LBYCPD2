import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.IOException;

public class MainQR {
    private static void myQR() throws IOException, WriterException, NotFoundException {
        //CreateQR.run(); //default value
        CreateQR.run("Myles Earvin", "Uy", 11806303); //Reference values to SQL database
        ReadQR.run();
    }
    public static void main(String[] args){
        try {
            myQR();
        } catch (IOException | NotFoundException | WriterException e) {
            e.printStackTrace();
        }
    }
}

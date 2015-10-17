package helpers;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xzbla on 17/10/2015.
 */
public class JsonHelper {

    public static String loadJsonFromAsset(Context context, String fileName) {
        String json;
        try {

            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-16LE");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}

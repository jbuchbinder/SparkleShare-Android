/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sparkleshare.android.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;

/**
 *
 * @author vauvenal5
 */
public class BitmapGenerator {
    public static Bitmap getBitmorPath(String path){
        File file = new File(path);
        Bitmap fileBitmap = null;
        
        if (file.exists() && file.length() < 1000000) {
                
                try {
                         BitmapFactory.Options options = new BitmapFactory.Options();
                         options.inSampleSize = 4;

                        fileBitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                } catch (Exception e) {
                        //todo: log when logining possible
                }
        }
        
        return fileBitmap;
    }
    
}

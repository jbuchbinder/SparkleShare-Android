/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sparkleshare.android.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.File;

/**
 *
 * @author vauvenal5
 */
public class BitmapGenerator {
    
    public enum ScalingMode{
        preview(8), detail(2);
        
        private int size;
        
        private ScalingMode(int size){
            this.size = size;
        }
        
        public int getSize(){
            return this.size;
        }
    }
    
    public static Bitmap getBitmorPath(String path, ScalingMode mode){
        File file = new File(path);
        Bitmap fileBitmap = null;
        
        if (file.exists() && file.length() < 1000000) {
                
                try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = mode.getSize();

                       fileBitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                } catch (Exception e) {
                        //todo: log when logining possible
                }
        }
        
        return fileBitmap;
    }
    
}

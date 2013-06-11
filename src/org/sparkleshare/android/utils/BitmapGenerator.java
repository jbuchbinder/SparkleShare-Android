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
        preview(8,64), detail(2,256);
        
        private int size;
        private int scale;
        
        private ScalingMode(int scale, int size){
            this.size = size;
        }
        
        public int getSize(){
            return this.size;
        }
        
        public int getScale(){
            return this.scale;
        }
    }
    
    public static Bitmap getBitmorPath(String path, ScalingMode mode){
        File file = new File(path);
        Bitmap fileBitmap = null;
        
        if (file.exists()) {
                
                try {
                        //BitmapFactory.Options options = new BitmapFactory.Options();
                        //options.inSampleSize = mode.getScale();

                       //fileBitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                       
                       
                       Bitmap origBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                       double factor = 0;
                       
                       if(origBitmap.getHeight() > origBitmap.getWidth()){
                           factor = ((double) mode.getSize())/((double)origBitmap.getHeight());
                           return Bitmap.createScaledBitmap(origBitmap, ((int)(factor*(double)origBitmap.getWidth())), mode.getSize(), true);
                       }
                       else{
                           factor = ((double) mode.getSize())/((double)origBitmap.getWidth());
                           return Bitmap.createScaledBitmap(origBitmap, mode.getSize(), ((int)(factor*(double)origBitmap.getHeight())), true);
                       }
                       
                } catch (Exception e) {
                        //todo: log when logining possible
                }
        }
        
        return fileBitmap;
    }
    
}

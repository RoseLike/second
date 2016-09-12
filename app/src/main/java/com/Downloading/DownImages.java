package com.Downloading;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DownImages{

    public static ExecutorService executor=Executors.
            newFixedThreadPool(10);

    public static void downLoadImage(final String url,final Handler mHandler,final ImageView imageView) {

        executor.execute(new Runnable() {

            @Override
            public void run() {

                byte[] imageByte= DownLoadUtils.getImageByte(url);
                if (imageByte==null) {
                    return;
                }
                final Bitmap bitmap=BitmapFactory.
                        decodeByteArray(imageByte, 0, imageByte.length);

                mHandler.post(new Runnable() {

                    @Override
                    public void run() {

                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

}
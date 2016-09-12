package com.Downloading;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/9/7.
 */
public class HandloadJson {

    public static void downLoadingJson(final String path, final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String string = DownLoadUtils.getJsonString(path);
                Message message = Message.obtain();
                message.what = 1;
                message.obj = string;
                handler.sendMessage(message);
            }
        }).start();
    }

}


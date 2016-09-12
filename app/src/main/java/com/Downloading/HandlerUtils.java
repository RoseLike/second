package com.Downloading;

import android.os.Handler;
import android.os.Message;

public class HandlerUtils {
    Handler handler;
    public HandlerUtils(Handler handler) {
        super();
        this.handler = handler;
    }

    public void downLoadingJson(final String path) {
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


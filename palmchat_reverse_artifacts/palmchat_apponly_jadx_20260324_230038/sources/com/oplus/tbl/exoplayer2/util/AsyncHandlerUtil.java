package com.oplus.tbl.exoplayer2.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AsyncHandlerUtil {
    public static void sendAsyncMessage(Handler handler, Runnable runnable) {
        handler.getClass();
        Message messageObtain = Message.obtain(handler, runnable);
        if (Build.VERSION.SDK_INT >= 22) {
            messageObtain.setAsynchronous(true);
        } else {
            try {
                Method declaredMethod = Class.forName(messageObtain.getClass().getName()).getDeclaredMethod("setAsynchronous", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(messageObtain, Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        handler.sendMessage(messageObtain);
    }
}

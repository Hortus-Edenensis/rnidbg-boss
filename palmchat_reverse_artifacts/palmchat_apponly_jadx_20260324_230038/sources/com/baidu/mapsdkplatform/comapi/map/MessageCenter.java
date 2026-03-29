package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.platform.comjni.engine.MessageProxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MessageCenter {
    public static void registMessage(int i, Handler handler) {
        MessageProxy.registerMessageHandler(i, handler);
    }

    public static void unregistMessage(int i, Handler handler) {
        MessageProxy.unRegisterMessageHandler(i, handler);
    }
}

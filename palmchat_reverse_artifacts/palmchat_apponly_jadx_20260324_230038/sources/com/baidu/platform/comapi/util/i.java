package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends Handler {
    public i(Looper looper) {
        super(looper);
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.copyFrom(message);
        a(messageObtain);
        messageObtain.recycle();
    }
}

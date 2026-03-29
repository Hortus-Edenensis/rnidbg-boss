package com.bef.effectsdk.message;

import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface MessageInterceptor {
    void destroy();

    boolean intercept(Message message);
}

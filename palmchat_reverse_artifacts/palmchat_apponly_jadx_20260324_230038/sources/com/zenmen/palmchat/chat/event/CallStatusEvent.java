package com.zenmen.palmchat.chat.event;

import androidx.annotation.Keep;
import defpackage.ds0;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CallStatusEvent implements ds0.a {
    public static final String KEY_REASON = "KEY_REASON";
    public static final String KEY_SESSION = "KEY_SESSION";
    public static final int STATUS_CONNECTED = 1;
    public static final int STATUS_DISCONNECTED = 2;
    public HashMap<String, Object> args = new HashMap<>();
    public int status;

    public CallStatusEvent(int i) {
        this.status = i;
    }

    public CallStatusEvent addArgs(String str, Object obj) {
        this.args.put(str, obj);
        return this;
    }
}

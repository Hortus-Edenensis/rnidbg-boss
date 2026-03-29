package com.bytedance.sdk.openadsdk.iz.nr;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Handler.Callback {
    private Handler u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public static final fx u = new fx();
    }

    public static fx u() {
        return u.u;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    private fx() {
        this.u = new Handler(jk.u().getLooper(), this);
    }

    public void u(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.u.sendMessage(messageObtain);
    }

    public void u(Runnable runnable, long j) {
        this.u.postDelayed(runnable, j);
    }
}

package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lx2 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19095a;

    public lx2(Context context, Looper looper) {
        super(looper);
        this.f19095a = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            sx2.d().e(this.f19095a, message.what, message.obj);
        } catch (Throwable unused) {
        }
    }
}

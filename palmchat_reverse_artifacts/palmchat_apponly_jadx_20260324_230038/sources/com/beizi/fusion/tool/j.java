package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class j extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f4734a;

    public j(Context context) {
        super(Looper.getMainLooper());
        this.f4734a = new WeakReference<>(context.getApplicationContext());
    }

    public Context a() {
        WeakReference<Context> weakReference = this.f4734a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f4734a.get();
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        WeakReference<Context> weakReference = this.f4734a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        a(message);
    }
}

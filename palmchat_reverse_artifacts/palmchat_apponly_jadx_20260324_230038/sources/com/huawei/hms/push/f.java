package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<a> f6826a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.f6826a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f6826a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}

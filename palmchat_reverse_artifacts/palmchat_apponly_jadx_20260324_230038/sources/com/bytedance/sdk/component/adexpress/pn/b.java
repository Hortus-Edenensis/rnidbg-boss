package com.bytedance.sdk.component.adexpress.pn;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.u.kj;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private WeakReference<kj> u;

    public b(kj kjVar) {
        this.u = new WeakReference<>(kjVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<kj> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().invokeMethod(str);
    }

    public void u(kj kjVar) {
        this.u = new WeakReference<>(kjVar);
    }
}

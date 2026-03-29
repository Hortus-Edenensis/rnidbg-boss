package cn.shuzilm.core;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2480a;
    final /* synthetic */ Listener b;

    public j(Context context, Listener listener) {
        this.f2480a = context;
        this.b = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!DUHelper.d.D) {
                System.loadLibrary(com.umeng.analytics.pro.f.ac);
            }
        } catch (Throwable unused) {
        }
        dl.ia(this.f2480a);
        if (this.b != null) {
            String strC = DUHelper.c(this.f2480a, 301, (String) null);
            if (strC == null) {
                this.b.handler("");
            } else {
                try {
                    strC = strC.replace('+', '-').replace('/', '_').replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
                } catch (Exception unused2) {
                }
                this.b.handler(strC);
            }
        }
    }
}

package com.zx.a.I8b7;

import android.media.MediaDrm;
import android.os.Build;
import android.util.Base64;
import com.zx.module.base.Callback;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f16872a;

    public v0(Callback callback) {
        this.f16872a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaDrm mediaDrm;
        Throwable th;
        try {
            try {
                mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
                try {
                    String str = new String(Base64.encode(mediaDrm.getPropertyByteArray("deviceUniqueId"), 2), StandardCharsets.UTF_8);
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.release();
                    } else {
                        mediaDrm.release();
                    }
                    this.f16872a.callback(str);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        r2.a(th);
                        if (Build.VERSION.SDK_INT >= 28) {
                            if (mediaDrm != null) {
                                mediaDrm.release();
                            }
                        } else if (mediaDrm != null) {
                            mediaDrm.release();
                        }
                        this.f16872a.callback("");
                    } catch (Throwable th3) {
                        try {
                            if (Build.VERSION.SDK_INT >= 28) {
                                if (mediaDrm != null) {
                                    mediaDrm.release();
                                }
                            } else if (mediaDrm != null) {
                                mediaDrm.release();
                            }
                            this.f16872a.callback("");
                        } catch (Throwable unused) {
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th4) {
            mediaDrm = null;
            th = th4;
        }
    }
}

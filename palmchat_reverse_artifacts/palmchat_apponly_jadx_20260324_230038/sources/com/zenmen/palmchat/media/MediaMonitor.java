package com.zenmen.palmchat.media;

import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MediaMonitor {
    public static volatile MediaMonitor b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14647a;

    /* JADX INFO: compiled from: SearchBox */
    public enum MediaType {
        IMG
    }

    public static MediaMonitor a() {
        if (b == null) {
            synchronized (MediaMonitor.class) {
                if (b == null) {
                    b = new MediaMonitor();
                }
            }
        }
        return b;
    }

    public final boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri uri = Uri.parse(str);
            if (uri.getPath() != null && uri.getPath().contains("/mdc/res/")) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str) {
        boolean z = ir5.b() < this.f14647a && b(str);
        LogUtil.i("MediaMonitor", "useLocalRes" + z);
        return z;
    }
}

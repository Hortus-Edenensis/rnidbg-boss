package com.bytedance.sdk.openadsdk.core.k.u.u;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends ContentObserver {
    private InterfaceC0267u nr;
    private Context u;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.k.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0267u {
        void u(int i);
    }

    public u(Context context, Handler handler, InterfaceC0267u interfaceC0267u) {
        super(handler);
        this.u = context;
        this.nr = interfaceC0267u;
    }

    public void nr() {
        this.u.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        if (uri.equals(Settings.System.getUriFor("screen_brightness"))) {
            int i = Settings.System.getInt(this.u.getContentResolver(), "screen_brightness", 0);
            InterfaceC0267u interfaceC0267u = this.nr;
            if (interfaceC0267u != null) {
                interfaceC0267u.u(i);
            }
        }
    }

    public void u() {
        this.u.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this);
    }
}

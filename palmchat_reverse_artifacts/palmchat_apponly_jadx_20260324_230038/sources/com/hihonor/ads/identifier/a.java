package com.hihonor.ads.identifier;

import android.content.Context;
import android.os.Bundle;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdvertisingIdClient.Info f6429a;
    public Context b;
    public final BinderC0404a c = new BinderC0404a();
    public final b d = new b();
    public final CountDownLatch e = new CountDownLatch(2);

    /* JADX INFO: renamed from: com.hihonor.ads.identifier.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class BinderC0404a extends com.hihonor.cloudservice.oaid.a$a {
        public BinderC0404a() {
        }

        public native void a(int i, long j, boolean z, float f, double d, String str);

        public native void a(int i, Bundle bundle);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends com.hihonor.cloudservice.oaid.a$a {
        public b() {
        }

        public native void a(int i, long j, boolean z, float f, double d, String str);

        public native void a(int i, Bundle bundle);
    }

    public static native void a(a aVar);

    public final native void a();

    public native boolean a(Context context);
}

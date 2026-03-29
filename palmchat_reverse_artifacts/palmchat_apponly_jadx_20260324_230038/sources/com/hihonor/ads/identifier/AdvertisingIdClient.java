package com.hihonor.ads.identifier;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class AdvertisingIdClient {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Info {
        public String id;
        public boolean isLimit;
    }

    public static native Info getAdvertisingIdInfo(Context context);

    public static native boolean isAdvertisingIdAvailable(Context context);
}

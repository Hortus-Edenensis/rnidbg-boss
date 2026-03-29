package com.ss.android.socialbase.appdownloader;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static int b(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int fx(String str) {
        try {
            return u(str, com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int iz(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int nr(String str) {
        return u(com.ss.android.socialbase.downloader.downloader.fx.oa(), str);
    }

    public static int pn(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int u(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int nr(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int u(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int u(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.fx.oa().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception unused) {
            return 0;
        }
    }
}

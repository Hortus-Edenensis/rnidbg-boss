package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static String i = null;
    public static int j = 0;
    public static int k = -2;
    public static long l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3513a;
    public String b;
    public String c;
    public String d;
    private boolean m;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f3514a = new b();
    }

    private b() {
        this.f3513a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.m = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        return a.f3514a;
    }

    private boolean d() {
        return false;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.c != null) {
            stringBuffer.append("&cu=");
            str = this.c;
        } else {
            stringBuffer.append("&im=");
            str = this.f3513a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(e);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.653f);
        return stringBuffer.toString();
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.653f);
        if (z) {
            if (h.e.equals("all")) {
                stringBuffer.append("&addr=allj2");
            }
            if (h.h) {
                stringBuffer.append("&adtp=n2");
            }
            if (h.g || h.j || h.k || h.i || d()) {
                stringBuffer.append("&sema=");
                if (h.g) {
                    stringBuffer.append("aptag|");
                }
                if (h.i || d()) {
                    stringBuffer.append("aptagd2|");
                }
                if (h.j) {
                    stringBuffer.append("poiregion|");
                }
                if (h.k) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                str = "&coor=gcj02";
            } else {
                stringBuffer.append("&coor=");
            }
            stringBuffer.append(str);
            String strL = com.baidu.location.c.d.l();
            if (strL != null) {
                stringBuffer.append(strL);
            }
        }
        if (this.c != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.c);
            String str3 = this.f3513a;
            str2 = (str3 == null || str3.equals("NULL") || this.c.contains(new StringBuffer(this.f3513a).reverse().toString())) ? "&im=" : "&Aim=";
            if (this.b != null) {
                stringBuffer.append("&snd=");
                stringBuffer.append(this.b);
            }
            if (this.d != null) {
                stringBuffer.append("&Aid=");
                stringBuffer.append(this.d);
            }
            stringBuffer.append("&fw=");
            stringBuffer.append(com.baidu.location.f.getFrameVersion());
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append(BaseWrapper.ENTER_ID_MARKET);
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            if (z) {
                stringBuffer.append("&sv=");
                String strSubstring = Build.VERSION.RELEASE;
                if (strSubstring != null && strSubstring.length() > 6) {
                    strSubstring = strSubstring.substring(0, 6);
                }
                stringBuffer.append(strSubstring);
            }
            return stringBuffer.toString();
        }
        stringBuffer.append(str2);
        stringBuffer.append(this.f3513a);
        if (this.b != null) {
        }
        if (this.d != null) {
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(BaseWrapper.ENTER_ID_MARKET);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK_INT);
        if (z) {
        }
        return stringBuffer.toString();
    }

    public void a(Context context) {
        if (context == null || this.m) {
            return;
        }
        try {
            e = context.getPackageName();
        } catch (Exception unused) {
            e = null;
        }
        try {
            i = h.f(context);
        } catch (Exception unused2) {
            i = null;
        }
        h.n = "" + this.c;
        this.m = true;
    }

    public void a(String str) {
        this.c = str;
        h.n = "" + this.c;
    }

    public void a(String str, String str2) {
        f = str;
        e = str2;
    }
}

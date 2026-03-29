package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class k implements BaseNotifyDataAdapter {
    private static int e;
    private static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f11303a;
    private String b;
    private String c;
    private String d;

    private static boolean a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int iA;
        if (a(e)) {
            return e;
        }
        String str = this.d;
        if (a(str)) {
            iA = a(str, "_notifyicon");
        } else {
            t.d("DefaultNotifyDataAdapter", "getNotifyIconByArdVersion isSystemCodeUsable is false ");
            iA = -1;
        }
        e = iA;
        if (a(iA)) {
            return e;
        }
        String strSubstring = this.c;
        while (true) {
            t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion codeReg = ".concat(String.valueOf(strSubstring)));
            if (TextUtils.isEmpty(strSubstring)) {
                return this.f11303a.getIdentifier("vivo_push_notifyicon", "drawable", this.b);
            }
            int identifier = this.f11303a.getIdentifier("vivo_push_rom" + strSubstring + "_notifyicon", "drawable", this.b);
            if (identifier > 0) {
                t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion find notifyicon = vivo_push_rom" + strSubstring + "_notifyicon");
                return identifier;
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int iA;
        if (a(f)) {
            return f;
        }
        String str = this.d;
        if (a(str)) {
            iA = a(str, "_icon");
        } else {
            t.d("DefaultNotifyDataAdapter", "getSmallIconByArdVersion isSystemCodeUsable is false ");
            iA = -1;
        }
        f = iA;
        if (a(iA)) {
            return f;
        }
        String strSubstring = this.c;
        while (true) {
            t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion codeReg = ".concat(String.valueOf(strSubstring)));
            if (TextUtils.isEmpty(strSubstring)) {
                return this.f11303a.getIdentifier("vivo_push_icon", "drawable", this.b);
            }
            int identifier = this.f11303a.getIdentifier("vivo_push_rom" + strSubstring + "_icon", "drawable", this.b);
            if (identifier > 0) {
                t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion find smallIcon = vivo_push_rom" + strSubstring + "_icon");
                return identifier;
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.f11303a = context.getResources();
        this.c = m.a();
        this.d = Build.VERSION.RELEASE;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        t.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    private int a(String str, String str2) {
        t.d("DefaultNotifyDataAdapter", "getIcon systemVersion = " + str + " suffix= " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit != null && strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
            try {
                for (int i = Integer.parseInt(str); i > 0; i--) {
                    String str3 = "vivo_push_ard" + i + str2;
                    t.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f11303a.getIdentifier(str3, "drawable", this.b);
                    if (identifier > 0) {
                        t.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                t.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}

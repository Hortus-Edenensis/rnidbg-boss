package com.zm.fda.Z0225;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.O52OZ.O52OZ;
import com.zm.fda.O52OZ.OOZ20;
import com.zm.fda.O52OZ.Z2500;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.busi.IPubParams;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z200O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IPubParams f16655a;
    public Context b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public Z200O(Context context, IPubParams iPubParams) {
        if (context != null) {
            this.e = context.getPackageName();
            this.b = context;
        }
        this.f16655a = iPubParams;
        this.f = com.zm.fda.O52OZ.O022Z.a();
    }

    private boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 10 || str.matches("(.)\\1+")) ? false : true;
    }

    public String b() {
        return String.valueOf(Z2500.b());
    }

    public String c() {
        return String.valueOf(Z2500.c());
    }

    public String d() {
        String str = this.f;
        return str == null ? "" : str;
    }

    public String e() {
        return O2O5Z.a(Build.MODEL);
    }

    public String f() {
        try {
            int iD = O52OZ.d(this.b);
            if (iD == 1) {
                this.g = RXScreenCaptureService.KEY_WIDTH;
                return RXScreenCaptureService.KEY_WIDTH;
            }
            if (iD == 0) {
                this.g = "g";
                return "g";
            }
            this.g = "";
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            this.g = "";
            return "";
        }
    }

    public String g() {
        return O2O5Z.a(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    public String h() {
        return O2O5Z.a(Build.VERSION.RELEASE);
    }

    public IPubParams i() {
        return this.f16655a;
    }

    public String j() {
        String str = this.e;
        return str == null ? "" : str;
    }

    public String k() {
        return String.valueOf(com.zm.fda.OO22Z.d);
    }

    public String l() {
        return O2O5Z.a(com.zm.fda.OO22Z.e);
    }

    public String m() {
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        String strA = ZZ050.a(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.l, "");
        this.h = strA;
        if (a(strA)) {
            return this.h;
        }
        IPubParams iPubParams = this.f16655a;
        if (iPubParams != null) {
            String strA2 = com.zm.fda.Z25O0.a(iPubParams);
            if (com.zm.fda.oaid.ZZ00Z.a(strA2)) {
                this.h = strA2;
            }
            if (!a(this.h)) {
                this.h = this.f16655a.getAndroidId();
            }
        }
        if (!a(this.h)) {
            this.h = OOZ20.a(UUID.randomUUID().toString() + System.currentTimeMillis());
        }
        if (!a(this.h)) {
            this.h = UUID.randomUUID().toString();
        }
        ZZ050.b(com.zm.fda.ZZ00Z.b(), com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.l, this.h);
        return this.h;
    }

    public long n() {
        return System.currentTimeMillis();
    }

    public int o() {
        return com.zm.fda.O52OZ.ZZ00Z.c(this.b);
    }

    public String p() {
        return O2O5Z.a(com.zm.fda.O52OZ.ZZ00Z.d(this.b));
    }

    public String a() {
        return O2O5Z.a(Build.BRAND);
    }
}

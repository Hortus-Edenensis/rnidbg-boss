package com.opos.cmn.f;

import android.content.Context;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.STManager;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements b {
    private static volatile STManager b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7915a = new byte[0];
    private static final String c = com.opos.cmn.an.b.b.a("Y29tLm9wcG8udW5pb24=");

    private static STManager b() {
        STManager sTManager = b;
        if (sTManager == null) {
            synchronized (f7915a) {
                sTManager = b;
                if (sTManager == null) {
                    sTManager = STManager.getInstance();
                    b = sTManager;
                }
            }
        }
        return sTManager;
    }

    private void c() {
        try {
            b().enableDebugLog();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STool", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.f.b
    public int a() {
        return b().getSdkVerCode();
    }

    @Override // com.opos.cmn.f.b
    public void a(Context context, String str, String str2, String str3, boolean z) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.b.a(str2) || (!STManager.BRAND_OF_O.equalsIgnoreCase(str2) && !STManager.BRAND_OF_P.equalsIgnoreCase(str2) && !STManager.BRAND_OF_R.equalsIgnoreCase(str2))) {
                    str2 = STManager.BRAND_OF_O;
                }
                b().init(context, str2, str3, new InitParams.Builder().setPkgName(c).setIsLoganInit(false).build());
                if (z) {
                    c();
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("STool", "", th);
            }
        }
    }

    @Override // com.opos.cmn.f.b
    public void a(Context context, String str, Map<String, String> map) {
        if (context == null || map == null || map.size() <= 0) {
            return;
        }
        try {
            b().onEvent(context, str, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("STool", "", th);
        }
    }
}

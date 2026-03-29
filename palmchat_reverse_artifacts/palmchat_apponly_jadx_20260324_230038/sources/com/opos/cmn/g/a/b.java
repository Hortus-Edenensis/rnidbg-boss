package com.opos.cmn.g.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static String a(Context context) {
        String strC;
        if (context != null) {
            try {
                strC = h.c(context.getApplicationContext());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strC = "";
            }
        } else {
            strC = "";
        }
        return strC != null ? strC : "";
    }

    public static String b(Context context) {
        String strD;
        if (context != null) {
            try {
                strD = h.d(context.getApplicationContext());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strD = "";
            }
        } else {
            strD = "";
        }
        return strD != null ? strD : "";
    }

    public static String c(Context context) {
        String strE;
        if (context != null) {
            try {
                strE = h.e(context.getApplicationContext());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strE = "";
            }
        } else {
            strE = "";
        }
        return strE != null ? strE : "";
    }

    public static void d(Context context) {
        try {
            h.a(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdTool", "", e);
        }
    }

    public static boolean e(Context context) {
        if (context != null) {
            try {
                return g.c(context.getApplicationContext());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
            }
        }
        return false;
    }

    public static String f(Context context) {
        String strA;
        if (context != null) {
            try {
                strA = e.a(context.getApplicationContext());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("IdTool", "", e);
                strA = "";
            }
        } else {
            strA = "";
        }
        return strA != null ? strA : "";
    }

    public static boolean g(Context context) {
        boolean zF = false;
        if (context == null) {
            return false;
        }
        try {
            zF = h.f(context.getApplicationContext());
            h.b(context.getApplicationContext());
            return zF;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IdTool", "", e);
            return zF;
        }
    }
}

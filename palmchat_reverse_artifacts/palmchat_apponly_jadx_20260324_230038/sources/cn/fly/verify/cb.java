package cn.fly.verify;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.fly.verify.fq;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ce f2139a;

    /* JADX INFO: renamed from: cn.fly.verify.cb$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2140a;

        static {
            int[] iArr = new int[a.values().length];
            f2140a = iArr;
            try {
                iArr[a.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2140a[a.REDMI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2140a[a.MEITU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2140a[a.BLACKSHARK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2140a[a.VIVO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2140a[a.HUA_WEI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2140a[a.HORNOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2140a[a.OPPO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2140a[a.ONEPLUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2140a[a.REALME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2140a[a.MOTO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2140a[a.ZUK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2140a[a.LENOVO.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2140a[a.ASUS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2140a[a.SAMSUNG.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2140a[a.MEIZU.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2140a[a.MBLU.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f2140a[a.ALPS.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f2140a[a.NUBIA.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f2140a[a.ZTE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f2140a[a.FERRMEOS.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f2140a[a.SSUI.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        UNSUPPORT(-1, ec.b("009FcfUd9egcf%ii!dcci_h")),
        HUA_WEI(0, ec.b("006Keidfdkfdfgdh")),
        XIAOMI(1, ec.b("006)fech?cFdccech")),
        VIVO(2, ec.b("004Occchccdc")),
        OPPO(3, ec.b("004CdcKii]dc")),
        MOTO(4, ec.b("0089cedc'hKdccidc@fc")),
        LENOVO(5, ec.b("006fed.dcccdc")),
        ASUS(6, ec.b("004cVegcfeg")),
        SAMSUNG(7, ec.b("0075egMcSceegcf)dSdd")),
        MEIZU(8, ec.b("005^ce^eWchfbcf")),
        ALPS(9, ec.b("004cfiSeg")),
        NUBIA(10, ec.b("005d.cfedch3c")),
        ONEPLUS(11, ec.b("007-dcKdeif?cfeg")),
        BLACKSHARK(12, ec.b("0100ed4fcb)ckeg!gcQcick")),
        ZTE(13, ec.b("003Hfb7he")),
        FERRMEOS(14, ec.b("0087deci6ee^ce@eNdceg")),
        SSUI(15, ec.b("004Begegcfch")),
        HORNOR(16, "HONOR"),
        REALME(17, "REALME"),
        REDMI(18, "REDMI"),
        MEITU(19, "MEITU"),
        ZUK(20, "ZUK"),
        MBLU(21, "MBLU");

        private int x;
        private String y;

        a(int i, String str) {
            this.x = i;
            this.y = str;
        }
    }

    public static a a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : a.values()) {
                if (aVar.y.equalsIgnoreCase(str) || aVar.y.equalsIgnoreCase(str2)) {
                    return aVar;
                }
            }
        }
        return (a() || b()) ? a.ZTE : a.UNSUPPORT;
    }

    private static boolean b() {
        String strC = fq.d.c(ec.b("015 cidcecegegcfchec;i*cidccbcfWbh"));
        return (TextUtils.isEmpty(strC) || strC.equalsIgnoreCase(ec.b("0074cf^dFckUdPdceeVd"))) ? false : true;
    }

    public static String c(Context context) {
        a(context);
        ce ceVar = f2139a;
        if (ceVar == null) {
            return null;
        }
        if (ceVar instanceof cc) {
            String strD = ceVar.d();
            if (!TextUtils.isEmpty(strD) && !Pattern.compile("^[0fF\\-]+").matcher(strD).matches()) {
                return strD;
            }
            f2139a = new cd(context);
        }
        return f2139a.d();
    }

    public static synchronized void a(Context context) {
        ce clVar;
        if (f2139a != null) {
            return;
        }
        a aVarA = a(Build.MANUFACTURER, Build.BRAND);
        if (aVarA == a.UNSUPPORT) {
            return;
        }
        switch (AnonymousClass1.f2140a[aVarA.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                clVar = new cl(context);
                f2139a = clVar;
                return;
            case 5:
                clVar = new ck(context);
                f2139a = clVar;
                return;
            case 6:
                clVar = new cd(context);
                f2139a = clVar;
                return;
            case 7:
                clVar = new cc(context);
                f2139a = clVar;
                return;
            case 8:
            case 9:
            case 10:
                clVar = new ci(context);
                f2139a = clVar;
                return;
            case 11:
            case 12:
            case 13:
                clVar = new cg(context);
                f2139a = clVar;
                return;
            case 14:
                clVar = new bz(context);
                f2139a = clVar;
                return;
            case 15:
                clVar = new cj(context);
                f2139a = clVar;
                return;
            case 16:
            case 17:
            case 18:
                clVar = new cf(context);
                f2139a = clVar;
                return;
            case 19:
                clVar = new ch(context);
                f2139a = clVar;
                return;
            case 20:
            case 21:
            case 22:
                clVar = new cm(context);
                f2139a = clVar;
                return;
            default:
                return;
        }
    }

    public static boolean b(Context context) {
        a(context);
        ce ceVar = f2139a;
        if (ceVar != null) {
            return ceVar.e();
        }
        return false;
    }

    private static boolean a() {
        String strC = fq.d.c(ec.b("021YcidcecedcfchJfOcbecdeci,eeIce7e'ec=fc.edFef"));
        return !TextUtils.isEmpty(strC) && strC.equalsIgnoreCase(ec.b("008Xekfhfgfggbfgffdi"));
    }
}

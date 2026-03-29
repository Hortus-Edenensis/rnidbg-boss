package com.qq.gdt.action.e;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.multioprocess.b.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: com.qq.gdt.action.e.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10480a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[a.values().length];
            b = iArr;
            try {
                iArr[a.ANDROIDID_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.IMEI_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[a.IMEI0_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[a.IMEI1_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[a.DEVICEID_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[a.DEVICEID0_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[a.DEVICEID1_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[a.MEID_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[a.MEID0_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[a.MEID1_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[a.BUILD_MODEL_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[a.BSSID_TYPE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[a.IMSI_TYPE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr2 = new int[EnumC0837b.values().length];
            f10480a = iArr2;
            try {
                iArr2[EnumC0837b.IMEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10480a[EnumC0837b.MEID.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10480a[EnumC0837b.ANDROID_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10480a[EnumC0837b.DEVICEID.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10480a[EnumC0837b.BSSID.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f10480a[EnumC0837b.IMSI.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        ANDROIDID_TYPE,
        IMEI_TYPE,
        IMEI0_TYPE,
        IMEI1_TYPE,
        DEVICEID_TYPE,
        DEVICEID0_TYPE,
        DEVICEID1_TYPE,
        MEID_TYPE,
        MEID0_TYPE,
        MEID1_TYPE,
        BUILD_MODEL_TYPE,
        BSSID_TYPE,
        IMSI_TYPE
    }

    /* JADX INFO: renamed from: com.qq.gdt.action.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0837b {
        MEID,
        IMEI,
        ANDROID_ID,
        DEVICEID,
        BSSID,
        IMSI
    }

    public static synchronized com.qq.gdt.action.multioprocess.b.b a(com.qq.gdt.action.multioprocess.b.a aVar, a aVar2) {
        b.j jVar;
        switch (AnonymousClass1.b[aVar2.ordinal()]) {
            case 1:
                b.a aVarA = aVar.a();
                jVar = aVarA;
                if (aVarA == null) {
                    b.a aVar3 = new b.a();
                    aVar.a(aVar3);
                    jVar = aVar3;
                }
                break;
            case 2:
                b.i iVarB = aVar.b();
                jVar = iVarB;
                if (iVarB == null) {
                    b.i iVar = new b.i();
                    aVar.a(iVar);
                    jVar = iVar;
                }
                break;
            case 3:
                b.g gVarC = aVar.c();
                jVar = gVarC;
                if (gVarC == null) {
                    b.g gVar = new b.g();
                    aVar.a(gVar);
                    jVar = gVar;
                }
                break;
            case 4:
                b.h hVarD = aVar.d();
                jVar = hVarD;
                if (hVarD == null) {
                    b.h hVar = new b.h();
                    aVar.a(hVar);
                    jVar = hVar;
                }
                break;
            case 5:
                b.f fVarE = aVar.e();
                jVar = fVarE;
                if (fVarE == null) {
                    b.f fVar = new b.f();
                    aVar.a(fVar);
                    jVar = fVar;
                }
                break;
            case 6:
                b.d dVarF = aVar.f();
                jVar = dVarF;
                if (dVarF == null) {
                    b.d dVar = new b.d();
                    aVar.a(dVar);
                    jVar = dVar;
                }
                break;
            case 7:
                b.e eVarG = aVar.g();
                jVar = eVarG;
                if (eVarG == null) {
                    b.e eVar = new b.e();
                    aVar.a(eVar);
                    jVar = eVar;
                }
                break;
            case 8:
                b.m mVarH = aVar.h();
                jVar = mVarH;
                if (mVarH == null) {
                    b.m mVar = new b.m();
                    aVar.a(mVar);
                    jVar = mVar;
                }
                break;
            case 9:
                b.k kVarI = aVar.i();
                jVar = kVarI;
                if (kVarI == null) {
                    b.k kVar = new b.k();
                    aVar.a(kVar);
                    jVar = kVar;
                }
                break;
            case 10:
                b.l lVarJ = aVar.j();
                jVar = lVarJ;
                if (lVarJ == null) {
                    b.l lVar = new b.l();
                    aVar.a(lVar);
                    jVar = lVar;
                }
                break;
            case 11:
                b.c cVarK = aVar.k();
                jVar = cVarK;
                if (cVarK == null) {
                    b.c cVar = new b.c();
                    aVar.a(cVar);
                    jVar = cVar;
                }
                break;
            case 12:
                b.C0838b c0838bL = aVar.l();
                jVar = c0838bL;
                if (c0838bL == null) {
                    b.C0838b c0838b = new b.C0838b();
                    aVar.a(c0838b);
                    jVar = c0838b;
                }
                break;
            case 13:
                b.j jVarM = aVar.m();
                jVar = jVarM;
                if (jVarM == null) {
                    b.j jVar2 = new b.j();
                    aVar.a(jVar2);
                    jVar = jVar2;
                }
                break;
            default:
                jVar = null;
                break;
        }
        return jVar;
    }

    public static synchronized com.qq.gdt.action.multioprocess.b.a b() {
        com.qq.gdt.action.multioprocess.b.a aVarE;
        aVarE = com.qq.gdt.action.multioprocess.d.a().e();
        if (aVarE == null) {
            aVarE = new com.qq.gdt.action.multioprocess.b.a();
        }
        return aVarE;
    }

    public static synchronized String c(Context context, int i, boolean z) {
        return "";
    }

    public static synchronized String a() {
        com.qq.gdt.action.multioprocess.b.a aVarB = b();
        com.qq.gdt.action.multioprocess.b.b bVarA = a(aVarB, a.BUILD_MODEL_TYPE);
        String strA = bVarA.a();
        if (TextUtils.isEmpty(strA) && !a(bVarA.b(), bVarA.c())) {
            bVarA.d();
            try {
                strA = Build.MODEL;
            } catch (Throwable th) {
                o.a("getBuildModule Throwable " + th, new Object[0]);
            }
            a(strA, bVarA, aVarB);
            return strA;
        }
        return strA;
    }

    public static synchronized String b(Context context, int i, boolean z) {
        return "";
    }

    public static synchronized String c(Context context, boolean z) {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static synchronized String a(Context context) {
        if (!a(context, EnumC0837b.ANDROID_ID)) {
            return "";
        }
        com.qq.gdt.action.multioprocess.b.a aVarB = b();
        com.qq.gdt.action.multioprocess.b.b bVarA = a(aVarB, a.ANDROIDID_TYPE);
        String strA = bVarA.a();
        int iIsEmpty = 0;
        iIsEmpty = 0;
        iIsEmpty = 0;
        try {
        } catch (Throwable th) {
            o.a("getAndroidId Throwable = " + th, new Object[iIsEmpty]);
        }
        if (TextUtils.isEmpty(strA) && !a(bVarA.b(), bVarA.c())) {
            bVarA.d();
            try {
                String string = Settings.System.getString(context.getApplicationContext().getContentResolver(), "android_id");
                iIsEmpty = TextUtils.isEmpty(string);
                iIsEmpty = iIsEmpty;
                if (iIsEmpty == 0) {
                    strA = string;
                    iIsEmpty = iIsEmpty;
                }
            } catch (Throwable th2) {
                o.a("getAndroidId throwable " + th2, new Object[0]);
            }
            a(strA, bVarA, aVarB);
            return strA;
        }
        return strA;
    }

    public static synchronized String b(Context context, boolean z) {
        return "";
    }

    public static synchronized String a(Context context, int i, boolean z) {
        return "";
    }

    public static synchronized String a(Context context, boolean z) {
        return "";
    }

    public static void a(String str, com.qq.gdt.action.multioprocess.b.b bVar, com.qq.gdt.action.multioprocess.b.a aVar) {
        bVar.a(str);
        com.qq.gdt.action.multioprocess.d.a().a(aVar);
    }

    public static boolean a(int i, int i2) {
        return i >= i2;
    }

    public static boolean a(Context context, EnumC0837b enumC0837b) {
        int i;
        try {
            switch (AnonymousClass1.f10480a[enumC0837b.ordinal()]) {
                case 1:
                    i = com.qq.gdt.action.b.a(context).i();
                    break;
                case 2:
                    i = com.qq.gdt.action.b.a(context).j();
                    break;
                case 3:
                    i = com.qq.gdt.action.b.a(context).k();
                    break;
                case 4:
                    i = com.qq.gdt.action.b.a(context).l();
                    break;
                case 5:
                    i = com.qq.gdt.action.b.a(context).g();
                    break;
                case 6:
                    i = com.qq.gdt.action.b.a(context).h();
                    break;
                default:
                    return false;
            }
            return i == 0;
        } catch (Throwable th) {
            o.a("!checkSwitchOpen error" + th, new Object[0]);
            return false;
        }
    }
}

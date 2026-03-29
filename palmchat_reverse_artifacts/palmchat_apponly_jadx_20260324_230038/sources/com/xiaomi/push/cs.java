package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cs {

    /* JADX INFO: renamed from: com.xiaomi.push.cs$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11483a;

        static {
            int[] iArr = new int[gf.values().length];
            f11483a = iArr;
            try {
                iArr[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11483a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11483a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11483a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11483a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11483a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11483a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11483a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11483a[gf.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11483a[gf.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11483a[gf.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11483a[gf.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(hq hqVar, gf gfVar) {
        int iA;
        switch (AnonymousClass1.f11483a[gfVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return ds.a(gfVar.a());
            case 11:
                iA = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof gw) {
                            String str = ((gw) hqVar).f620d;
                            if (!TextUtils.isEmpty(str) && ds.a(ds.m380a(str)) != -1) {
                                iA = ds.a(ds.m380a(str));
                            }
                        } else if (hqVar instanceof he) {
                            String str2 = ((he) hqVar).f679d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (ds.a(ds.m380a(str2)) != -1) {
                                    iA = ds.a(ds.m380a(str2));
                                }
                                if (gp.UploadTinyData.equals(ds.m380a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return iA;
                    }
                }
                break;
            case 12:
                iA = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof ha) {
                            String strB = ((ha) hqVar).b();
                            if (!TextUtils.isEmpty(strB) && ed.a(strB) != -1) {
                                iA = ed.a(strB);
                            }
                        } else if (hqVar instanceof gz) {
                            String strA = ((gz) hqVar).a();
                            if (!TextUtils.isEmpty(strA) && ed.a(strA) != -1) {
                                return ed.a(strA);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                    }
                }
                break;
            default:
                return -1;
        }
        return iA;
    }

    public static int a(Context context, int i) {
        int iA = fz.a(context);
        if (-1 == iA) {
            return -1;
        }
        return (i * (iA == 0 ? 13 : 11)) / 10;
    }

    public static int a(gf gfVar) {
        return ds.a(gfVar.a());
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            a(str, context, hbVar, bArr.length);
        } catch (hu unused) {
            com.xiaomi.channel.commonutils.logger.b.m74a("fail to convert bytes to container");
        }
    }

    public static void a(String str, Context context, hb hbVar, int i) {
        gf gfVarA;
        if (context == null || hbVar == null || (gfVarA = hbVar.a()) == null) {
            return;
        }
        int iA = a(gfVarA);
        if (i <= 0) {
            byte[] bArrA = hp.a(hbVar);
            i = bArrA != null ? bArrA.length : 0;
        }
        a(str, context, iA, i);
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int iA = a(context, i2);
        if (i != ds.a(gp.UploadTinyData)) {
            dt.a(context.getApplicationContext()).a(str, i, 1L, iA);
        }
    }

    public static void a(String str, Context context, hq hqVar, gf gfVar, int i) {
        a(str, context, a(hqVar, gfVar), i);
    }
}

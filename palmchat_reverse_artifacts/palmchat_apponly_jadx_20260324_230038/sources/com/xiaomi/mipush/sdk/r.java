package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ay;
import com.xiaomi.push.gf;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class r {

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.r$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11384a;

        static {
            int[] iArr = new int[gf.values().length];
            f11384a = iArr;
            try {
                iArr[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11384a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11384a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11384a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11384a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11384a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11384a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11384a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11384a[gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11384a[gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static <T extends hq<T, ?>> hb a(Context context, T t, gf gfVar) {
        return a(context, t, gfVar, !gfVar.equals(gf.Registration), context.getPackageName(), b.m99a(context).m100a());
    }

    public static <T extends hq<T, ?>> hb b(Context context, T t, gf gfVar, boolean z, String str, String str2) {
        return a(context, t, gfVar, z, str, str2, false);
    }

    public static <T extends hq<T, ?>> hb a(Context context, T t, gf gfVar, boolean z, String str, String str2) {
        return a(context, t, gfVar, z, str, str2, true);
    }

    public static <T extends hq<T, ?>> hb a(Context context, T t, gf gfVar, boolean z, String str, String str2, boolean z2) {
        byte[] bArrA = hp.a(t);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        hb hbVar = new hb();
        if (z) {
            String strD = b.m99a(context).d();
            if (TextUtils.isEmpty(strD)) {
                com.xiaomi.channel.commonutils.logger.b.m74a("regSecret is empty, return null");
                return null;
            }
            try {
                bArrA = com.xiaomi.push.h.b(ay.m185a(strD), bArrA);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
            }
        }
        gu guVar = new gu();
        guVar.f583a = 5L;
        guVar.f584a = "fakeid";
        hbVar.a(guVar);
        hbVar.a(ByteBuffer.wrap(bArrA));
        hbVar.a(gfVar);
        hbVar.b(z2);
        hbVar.b(str);
        hbVar.a(z);
        hbVar.a(str2);
        return hbVar;
    }

    public static hq a(Context context, hb hbVar) {
        byte[] bArrM559a;
        if (hbVar.m561b()) {
            byte[] bArrA = f.a(context, hbVar, d.ASSEMBLE_PUSH_FCM);
            if (bArrA == null) {
                bArrA = ay.m185a(b.m99a(context).d());
            }
            try {
                bArrM559a = com.xiaomi.push.h.a(bArrA, hbVar.m559a());
            } catch (Exception e) {
                throw new l("the aes decrypt failed.", e);
            }
        } else {
            bArrM559a = hbVar.m559a();
        }
        hq hqVarA = a(hbVar.a(), hbVar.f663b);
        if (hqVarA != null) {
            hp.a(hqVarA, bArrM559a);
        }
        return hqVarA;
    }

    private static hq a(gf gfVar, boolean z) {
        switch (AnonymousClass1.f11384a[gfVar.ordinal()]) {
            case 1:
                return new hg();
            case 2:
                return new hm();
            case 3:
                return new hk();
            case 4:
                return new ho();
            case 5:
                return new hi();
            case 6:
                return new gv();
            case 7:
                return new ha();
            case 8:
                return new hh();
            case 9:
                if (z) {
                    return new he();
                }
                gw gwVar = new gw();
                gwVar.a(true);
                return gwVar;
            case 10:
                return new ha();
            default:
                return null;
        }
    }
}

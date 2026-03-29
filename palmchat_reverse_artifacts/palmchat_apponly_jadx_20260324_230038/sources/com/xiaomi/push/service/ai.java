package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.go;
import com.xiaomi.push.gq;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ai {

    /* JADX INFO: renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11714a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[gm.values().length];
            b = iArr;
            try {
                iArr[gm.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[gm.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[gm.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[gm.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gl.values().length];
            f11714a = iArr2;
            try {
                iArr2[gl.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11714a[gl.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(ah ahVar, hd hdVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", hdVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (go goVar : hdVar.a()) {
            arrayList.add(new Pair<>(goVar.m500a(), Integer.valueOf(goVar.a())));
            List<Pair<Integer, Object>> listA = a(goVar.f533a, false);
            if (!com.xiaomi.push.z.a(listA)) {
                arrayList2.addAll(listA);
            }
        }
        ahVar.a(arrayList, arrayList2);
        ahVar.b();
    }

    public static void a(ah ahVar, hc hcVar) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hcVar);
        ahVar.a(a(hcVar.a(), true));
        ahVar.b();
    }

    public static int a(ah ahVar, gl glVar) {
        return ahVar.a(glVar, AnonymousClass1.f11714a[glVar.ordinal()] != 1 ? 0 : 1);
    }

    private static List<Pair<Integer, Object>> a(List<gq> list, boolean z) {
        Pair pair;
        if (com.xiaomi.push.z.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gq gqVar : list) {
            int iA = gqVar.a();
            gm gmVarA = gm.a(gqVar.b());
            if (gmVarA != null) {
                if (z && gqVar.f541a) {
                    arrayList.add(new Pair(Integer.valueOf(iA), null));
                } else {
                    int i = AnonymousClass1.b[gmVarA.ordinal()];
                    if (i == 1) {
                        pair = new Pair(Integer.valueOf(iA), Integer.valueOf(gqVar.c()));
                    } else if (i == 2) {
                        pair = new Pair(Integer.valueOf(iA), Long.valueOf(gqVar.m504a()));
                    } else if (i != 3) {
                        pair = i != 4 ? null : new Pair(Integer.valueOf(iA), Boolean.valueOf(gqVar.g()));
                    } else {
                        pair = new Pair(Integer.valueOf(iA), gqVar.m505a());
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }
}

package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gk;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<d, a> f11372a = new HashMap<>();

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11373a;

        static {
            int[] iArr = new int[d.values().length];
            f11373a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11373a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11373a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11373a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11374a;
        public String b;

        public a(String str, String str2) {
            this.f11374a = str;
            this.b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f11372a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return f11372a.get(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static gk m126a(d dVar) {
        return gk.AggregatePushSwitch;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static v m125a(d dVar) {
        int i = AnonymousClass1.f11373a[dVar.ordinal()];
        if (i == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}

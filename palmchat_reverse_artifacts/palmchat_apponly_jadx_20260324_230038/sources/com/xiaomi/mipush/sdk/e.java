package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gk;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class e implements AbstractPushManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f11367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f54a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PushConfiguration f55a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f57a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f56a = new HashMap();

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11369a;

        static {
            int[] iArr = new int[d.values().length];
            f11369a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11369a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11369a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11369a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private e(Context context) {
        this.f54a = context.getApplicationContext();
    }

    public boolean b(d dVar) {
        int i = AnonymousClass2.f11369a[dVar.ordinal()];
        boolean openCOSPush = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f55a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f55a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i == 3) {
            PushConfiguration pushConfiguration3 = this.f55a;
            if (pushConfiguration3 != null) {
                openCOSPush = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i != 4) {
            return false;
        }
        PushConfiguration pushConfiguration4 = this.f55a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : openCOSPush;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : assemble push register");
        if (this.f56a.size() <= 0) {
            a();
        }
        if (this.f56a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f56a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            f.m119a(this.f54a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m74a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f56a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f56a.clear();
    }

    public static e a(Context context) {
        if (f11367a == null) {
            synchronized (e.class) {
                if (f11367a == null) {
                    f11367a = new e(context);
                }
            }
        }
        return f11367a;
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f55a = pushConfiguration;
        this.f57a = ah.a(this.f54a).a(gk.AggregatePushSwitch.a(), true);
        if (this.f55a.getOpenHmsPush() || this.f55a.getOpenFCMPush() || this.f55a.getOpenCOSPush() || this.f55a.getOpenFTOSPush()) {
            ah.a(this.f54a).a(new ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.ah.a
                public void onCallback() {
                    boolean zA = ah.a(e.this.f54a).a(gk.AggregatePushSwitch.a(), true);
                    if (e.this.f57a != zA) {
                        e.this.f57a = zA;
                        f.b(e.this.f54a);
                    }
                }
            });
        }
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f56a.containsKey(dVar)) {
                this.f56a.remove(dVar);
            }
            this.f56a.put(dVar, abstractPushManager);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m116a(d dVar) {
        this.f56a.remove(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m117a(d dVar) {
        return this.f56a.containsKey(dVar);
    }

    public AbstractPushManager a(d dVar) {
        return this.f56a.get(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        AbstractPushManager abstractPushManagerA;
        AbstractPushManager abstractPushManagerA2;
        AbstractPushManager abstractPushManagerA3;
        AbstractPushManager abstractPushManagerA4;
        PushConfiguration pushConfiguration = this.f55a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f55a.getOpenHmsPush() + " HW online switch : " + f.m123a(this.f54a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + h.m127a(this.f54a));
                com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
            }
            if (this.f55a.getOpenHmsPush()) {
                Context context = this.f54a;
                d dVar = d.ASSEMBLE_PUSH_HUAWEI;
                if (f.m123a(context, dVar) && h.m127a(this.f54a)) {
                    if (!m117a(dVar)) {
                        a(dVar, s.a(this.f54a, dVar));
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
                } else {
                    d dVar2 = d.ASSEMBLE_PUSH_HUAWEI;
                    if (m117a(dVar2) && (abstractPushManagerA = a(dVar2)) != null) {
                        m116a(dVar2);
                        abstractPushManagerA.unregister();
                    }
                }
            }
            if (this.f55a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f55a.getOpenFCMPush() + " FCM online switch : " + f.m123a(this.f54a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + h.b(this.f54a));
                com.xiaomi.channel.commonutils.logger.b.m74a(sb2.toString());
            }
            if (this.f55a.getOpenFCMPush()) {
                Context context2 = this.f54a;
                d dVar3 = d.ASSEMBLE_PUSH_FCM;
                if (f.m123a(context2, dVar3) && h.b(this.f54a)) {
                    if (!m117a(dVar3)) {
                        a(dVar3, s.a(this.f54a, dVar3));
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
                } else {
                    d dVar4 = d.ASSEMBLE_PUSH_FCM;
                    if (m117a(dVar4) && (abstractPushManagerA2 = a(dVar4)) != null) {
                        m116a(dVar4);
                        abstractPushManagerA2.unregister();
                    }
                }
            }
            if (this.f55a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f55a.getOpenCOSPush() + " COS online switch : " + f.m123a(this.f54a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + h.c(this.f54a));
                com.xiaomi.channel.commonutils.logger.b.m74a(sb3.toString());
            }
            if (this.f55a.getOpenCOSPush()) {
                Context context3 = this.f54a;
                d dVar5 = d.ASSEMBLE_PUSH_COS;
                if (f.m123a(context3, dVar5) && h.c(this.f54a)) {
                    a(dVar5, s.a(this.f54a, dVar5));
                } else {
                    d dVar6 = d.ASSEMBLE_PUSH_COS;
                    if (m117a(dVar6) && (abstractPushManagerA3 = a(dVar6)) != null) {
                        m116a(dVar6);
                        abstractPushManagerA3.unregister();
                    }
                }
            }
            if (this.f55a.getOpenFTOSPush()) {
                Context context4 = this.f54a;
                d dVar7 = d.ASSEMBLE_PUSH_FTOS;
                if (f.m123a(context4, dVar7) && h.d(this.f54a)) {
                    a(dVar7, s.a(this.f54a, dVar7));
                    return;
                }
            }
            d dVar8 = d.ASSEMBLE_PUSH_FTOS;
            if (!m117a(dVar8) || (abstractPushManagerA4 = a(dVar8)) == null) {
                return;
            }
            m116a(dVar8);
            abstractPushManagerA4.unregister();
        }
    }
}

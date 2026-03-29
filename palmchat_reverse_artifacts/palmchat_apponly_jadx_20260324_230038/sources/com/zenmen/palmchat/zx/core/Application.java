package com.zenmen.palmchat.zx.core;

import android.content.Context;
import androidx.multidex.MultiDexApplication;
import com.kuaishou.weapon.p0.t;
import defpackage.ConfigInfo;
import defpackage.hh;
import defpackage.ol0;
import defpackage.p5;
import defpackage.r63;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/zenmen/palmchat/zx/core/Application;", "Landroidx/multidex/MultiDexApplication;", "Landroid/content/Context;", "base", "", "attachBaseContext", "Lsl0;", "a", "onCreate", "<init>", "()V", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class Application extends MultiDexApplication {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.zenmen.palmchat.zx.core.Application$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/zenmen/palmchat/zx/core/Application$a;", "", "Landroid/app/Application;", "shared", "Lsl0;", "info", "", "a", t.l, "<init>", "()V", "zx-core_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final void a(android.app.Application shared, ConfigInfo info) {
            hh.b(shared);
            ol0 ol0Var = ol0.e;
            ol0Var.f(info.getDEBUGGABLE());
            ol0Var.e(info.getBUILD_TYPE());
            if (info.getBUILD_ID() != null) {
                String build_id = info.getBUILD_ID();
                if (build_id == null) {
                    Intrinsics.throwNpe();
                }
                ol0Var.d(build_id);
            }
            r63.a();
        }

        public final android.app.Application b() {
            return hh.a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Application() {
        hh.b(this);
    }

    public abstract ConfigInfo a();

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE.a(hh.a(), a());
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new p5());
    }
}

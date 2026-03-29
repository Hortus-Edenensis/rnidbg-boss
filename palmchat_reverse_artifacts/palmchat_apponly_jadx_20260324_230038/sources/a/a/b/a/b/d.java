package a.a.b.a.b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1075a;
    public static final d b = new d();

    public final synchronized void a() {
        if (f1075a) {
            return;
        }
        f1075a = true;
        Intrinsics.checkNotNullParameter("launch_app", "label");
        Intrinsics.checkNotNullParameter("2", "eventVersion");
        b bVar = new b("launch_app");
        bVar.g = "2";
        bVar.h = null;
        bVar.a("Convert:EventReporterV2");
    }
}

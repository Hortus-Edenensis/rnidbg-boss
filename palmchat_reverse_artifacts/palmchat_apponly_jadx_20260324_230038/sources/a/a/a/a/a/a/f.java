package a.a.a.a.a.a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1055a;
    public e b;
    public e c;
    public e d;

    public f(boolean z, e chinaMobileConfig, e chinaTelecomConfig, e chinaUnicomConfig) {
        Intrinsics.checkNotNullParameter(chinaMobileConfig, "chinaMobileConfig");
        Intrinsics.checkNotNullParameter(chinaTelecomConfig, "chinaTelecomConfig");
        Intrinsics.checkNotNullParameter(chinaUnicomConfig, "chinaUnicomConfig");
        this.f1055a = z;
        this.b = chinaMobileConfig;
        this.c = chinaTelecomConfig;
        this.d = chinaUnicomConfig;
    }

    public /* synthetic */ f(boolean z, e eVar, e eVar2, e eVar3, int i) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new e(false, 3300000L) : null, (i & 4) != 0 ? new e(false, 3300000L) : null, (i & 8) != 0 ? new e(false, 40000L) : null);
    }
}

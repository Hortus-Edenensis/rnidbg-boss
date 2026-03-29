package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\u0013\u001a\u00060\rj\u0002`\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lol0;", "", "", "a", "Z", t.l, "()Z", "f", "(Z)V", "DEBUGGABLE", "c", "setIS_UNITTEST", "IS_UNITTEST", "", "Lcom/zenmen/palmchat/zx/jvm/BuildType;", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "BUILD_TYPE", "d", "getBUILD_ID", "BUILD_ID", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class ol0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static boolean DEBUGGABLE;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static boolean IS_UNITTEST;
    public static final ol0 e = new ol0();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static String BUILD_TYPE = "cross";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static String BUILD_ID = "com.zenmen.palmchat.zx.jvm";

    public final String a() {
        return BUILD_TYPE;
    }

    public final boolean b() {
        return DEBUGGABLE;
    }

    public final boolean c() {
        return IS_UNITTEST;
    }

    public final void d(String str) {
        BUILD_ID = str;
    }

    public final void e(String str) {
        BUILD_TYPE = str;
    }

    public final void f(boolean z) {
        DEBUGGABLE = z;
    }
}

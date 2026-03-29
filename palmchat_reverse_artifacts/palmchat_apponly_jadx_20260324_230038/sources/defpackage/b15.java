package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000e"}, d2 = {"Lb15;", "", "", "isEnabled", "c", "Lsm2;", "a", t.l, "Lsm2;", "mLogger", "Z", "isLogEnabled", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class b15 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static boolean isLogEnabled;
    public static final b15 c = new b15();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static sm2 mLogger = new e61();

    public final sm2 a() {
        return mLogger;
    }

    public final boolean b() {
        return isLogEnabled;
    }

    public final b15 c(boolean isEnabled) {
        isLogEnabled = isEnabled;
        return this;
    }
}

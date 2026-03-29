package defpackage;

import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.zx.jvm.DATETIME_FORMAT;
import com.zenmen.palmchat.zx.jvm.LOG_LEVEL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0004\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001f"}, d2 = {"Lzb4;", "", "", "toString", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "tag", "Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", t.l, "Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", "()Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", "f", "(Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;)V", "level", "c", "message", "", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "exception", "Lt43;", "e", "Lt43;", "()Lt43;", "time", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lt43;)V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class zb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String tag;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public LOG_LEVEL level;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Throwable exception;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final t43 time;

    public zb4(String str, Throwable th, t43 t43Var) {
        this.message = str;
        this.exception = th;
        this.time = t43Var;
        this.tag = t63.b();
        this.level = LOG_LEVEL.DEBUG;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final LOG_LEVEL getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final t43 getTime() {
        return this.time;
    }

    public final void f(LOG_LEVEL log_level) {
        this.level = log_level;
    }

    public final void g(String str) {
        this.tag = str;
    }

    public String toString() {
        return '[' + this.tag + ' ' + this.time.a(DATETIME_FORMAT.LOG) + ' ' + this.level.name() + "]: " + this.message;
    }

    public /* synthetic */ zb4(String str, Throwable th, t43 t43Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, (i & 4) != 0 ? t43.INSTANCE.a() : t43Var);
    }
}

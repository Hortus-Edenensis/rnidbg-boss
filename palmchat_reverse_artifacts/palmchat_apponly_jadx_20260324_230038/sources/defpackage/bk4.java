package defpackage;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bk4 {
    public static final bk4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f1738a;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static final class a {
        public static final a b = new a(LogSessionId.LOG_SESSION_ID_NONE);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogSessionId f1739a;

        public a(LogSessionId logSessionId) {
            this.f1739a = logSessionId;
        }
    }

    static {
        b = g86.f17680a < 31 ? new bk4() : new bk4(a.b);
    }

    public bk4() {
        this((a) null);
        vh.g(g86.f17680a < 31);
    }

    @RequiresApi(31)
    public LogSessionId a() {
        return ((a) vh.e(this.f1738a)).f1739a;
    }

    @RequiresApi(31)
    public bk4(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    public bk4(@Nullable a aVar) {
        this.f1738a = aVar;
    }
}

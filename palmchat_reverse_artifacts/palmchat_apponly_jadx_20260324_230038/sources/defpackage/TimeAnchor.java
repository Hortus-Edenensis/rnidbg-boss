package defpackage;

import android.os.SystemClock;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: renamed from: ux5, reason: from toString */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0016"}, d2 = {"Lux5;", "", "", "a", "", "toString", "Lux5$a;", "Lux5$a;", "getAbsoluteTime", "()Lux5$a;", "setAbsoluteTime", "(Lux5$a;)V", "absoluteTime", t.l, "getNanoTime", "nanoTime", "c", "getThreadTime", "setThreadTime", "threadTime", "<init>", "()V", "basics_release"}, k = 1, mv = {1, 4, 0})
public final class TimeAnchor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public TimeAnchorBean absoluteTime = new TimeAnchorBean();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final TimeAnchorBean nanoTime = new TimeAnchorBean();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public TimeAnchorBean threadTime = new TimeAnchorBean();

    /* JADX INFO: renamed from: ux5$a, reason: from toString */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lux5$a;", "", "", "a", "", "toString", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "getStartTime", "()J", t.l, "(J)V", "startTime", "getEndTime", "setEndTime", bq.f.h, "<init>", "()V", "basics_release"}, k = 1, mv = {1, 4, 0})
    public static final class TimeAnchorBean {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public long startTime;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        public long endTime;

        public final long a() {
            long j = this.endTime - this.startTime;
            if (j < 0) {
                return 0L;
            }
            return j;
        }

        public final void b(long j) {
            this.startTime = j;
        }

        public String toString() {
            return "TimeAnchorBean(startTime=" + this.startTime + ", endTime=" + this.endTime + ",costTime=" + a() + ')';
        }
    }

    public TimeAnchor() {
        a();
    }

    public final void a() {
        this.absoluteTime.b(System.currentTimeMillis());
        this.nanoTime.b(System.nanoTime());
        this.threadTime.b(SystemClock.currentThreadTimeMillis());
    }

    public String toString() {
        return "TimeAnchor(absoluteTime=" + this.absoluteTime + ", threadTime=" + this.threadTime + ", nanoTime=" + this.nanoTime + ')';
    }
}

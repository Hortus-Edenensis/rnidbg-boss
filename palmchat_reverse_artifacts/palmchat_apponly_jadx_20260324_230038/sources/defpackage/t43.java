package defpackage;

import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.zx.jvm.DATETIME_FORMAT;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lt43;", "", "", "toString", "Lcom/zenmen/palmchat/zx/jvm/DATETIME_FORMAT;", "fmt", "a", "Ljava/util/Date;", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "<init>", "(Ljava/util/Date;)V", t.l, "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class t43 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Date date;

    /* JADX INFO: renamed from: t43$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lt43$a;", "", "Lt43;", "a", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final t43 a() {
            Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Shanghai"));
            Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance(Tim…imeZone(\"Asia/Shanghai\"))");
            Date time = calendar.getTime();
            Intrinsics.checkExpressionValueIsNotNull(time, "Calendar.getInstance(Tim…ne(\"Asia/Shanghai\")).time");
            return new t43(time);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t43(Date date) {
        this.date = date;
    }

    public final String a(DATETIME_FORMAT fmt) {
        return fmt.format(this.date);
    }

    public String toString() {
        return DATETIME_FORMAT.SIMPLE.format(this.date);
    }
}

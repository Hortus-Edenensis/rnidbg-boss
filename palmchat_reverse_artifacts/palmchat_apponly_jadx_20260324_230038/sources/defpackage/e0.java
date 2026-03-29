package defpackage;

import com.kuaishou.weapon.p0.t;
import defpackage.iz5;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Le0;", "", "h", "a", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public abstract class e0 {

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17184a = "Barrier";
    public static final String b = "权限未开";
    public static final String c = "直接请求";
    public static final String d = "系统请求";
    public static final String e = "后台系统请求";
    public static final String f = "缓存获得";
    public static final String g = "后台获得";

    /* JADX INFO: renamed from: e0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Le0$a;", "", "", "msg", "api", "", "a", "TAG", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "MSG_SYSTEM_CALL", t.l, "MSG_VALUE_CACHE", "c", "CATEGORY", "<init>", "()V", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final void a(String msg, String api) {
            n63.g.c(d(), msg + ' ' + api + " <= " + iz5.Companion.b(iz5.INSTANCE, null, 1, null));
        }

        public final String b() {
            return e0.d;
        }

        public final String c() {
            return e0.f;
        }

        public final String d() {
            return e0.f17184a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

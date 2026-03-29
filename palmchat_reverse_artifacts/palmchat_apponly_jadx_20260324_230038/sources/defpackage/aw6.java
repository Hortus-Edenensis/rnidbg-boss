package defpackage;

import com.oplus.instant.router.Instant;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class aw6 {
    public static aw6 c = new aw6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Instant.IStatisticsProvider f1594a = null;
    public Instant.IStatisticsProvider b = new a(this);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Instant.IStatisticsProvider {
        public a(aw6 aw6Var) {
        }

        @Override // com.oplus.instant.router.Instant.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[");
                sb.append(str);
                sb.append(":");
                sb.append(map.get(str));
                sb.append("]");
            }
            h87.f("router_stat", "fail to stat:" + sb.toString());
        }
    }

    public static aw6 a() {
        return c;
    }

    public void b(Instant.IStatisticsProvider iStatisticsProvider) {
        this.f1594a = iStatisticsProvider;
    }

    public Instant.IStatisticsProvider c() {
        Instant.IStatisticsProvider iStatisticsProvider = this.f1594a;
        return iStatisticsProvider != null ? iStatisticsProvider : this.b;
    }
}

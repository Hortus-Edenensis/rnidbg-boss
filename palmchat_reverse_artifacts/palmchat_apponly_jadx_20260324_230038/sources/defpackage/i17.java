package defpackage;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class i17 extends Instant.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f18085a = new HashMap();
    public Map<String, String> b = new HashMap();
    public Map<String, String> c = null;
    public Map<String, String> d = null;
    public Callback e;
    public String f;

    public i17(String str, String str2) {
        b(str);
        a(str2);
    }

    public final Instant.Builder a(String str) {
        this.b.put("secret", str);
        return this;
    }

    public final Instant.Builder b(String str) {
        this.b.put("origin", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Req build() {
        return (TextUtils.isEmpty(this.f) || this.f.startsWith("oaps://instant/app")) ? new g87(this) : new ha7(this);
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putExtra(String str, String str2) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putParams(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putStat(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setCallback(Callback callback) {
        this.e = callback;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setExtra(String str) {
        this.f18085a.put("ext", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setFrom(String str) {
        this.f18085a.put("f", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPackage(String str) {
        this.f18085a.put("pkg", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPage(String str) {
        this.f18085a.put("page", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPath(String str) {
        this.f18085a.put(OapsWrapper.KEY_PATH, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setRequestUrl(String str) {
        this.f = str;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder signAsPlatform() {
        this.b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}

package defpackage;

import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19952a;
    public String b;

    public p70(String str, String str2) {
        this.f19952a = str;
        this.b = str2;
    }

    public void a(int i, int i2, long j, wi0<BaseResponse<CircleCouponInfoResult>> wi0Var) {
        c70.R().I(this.f19952a, this.b, i, i2, Long.valueOf(j), wi0Var);
    }
}

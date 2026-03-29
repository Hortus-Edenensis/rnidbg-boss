package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoActivity;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoItem;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q70 {
    public static final String g = "q70";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CircleCouponInfoActivity f20192a;
    public boolean b;
    public p70 d;
    public long f;
    public int c = 1;
    public boolean e = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<CircleCouponInfoResult>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleCouponInfoResult> baseResponse) {
            q70.this.b = false;
            if (q70.this.f20192a != null) {
                q70.this.f20192a.M1(false, false);
                q70.this.g();
                if (baseResponse == null || baseResponse.getResultCode() != 0) {
                    q70.this.f20192a.H1(baseResponse != null ? baseResponse.getErrorMsg() : "");
                } else {
                    q70.this.l(baseResponse.getData());
                }
            }
        }
    }

    public q70(String str, String str2) {
        this.d = new p70(str, str2);
    }

    public void e(CircleCouponInfoActivity circleCouponInfoActivity) {
        this.f20192a = circleCouponInfoActivity;
    }

    public void f() {
        CircleCouponInfoActivity circleCouponInfoActivity = this.f20192a;
        if (circleCouponInfoActivity != null) {
            circleCouponInfoActivity.hideBaseProgressBar();
        }
        this.f20192a = null;
    }

    public final void g() {
        CircleCouponInfoActivity circleCouponInfoActivity = this.f20192a;
        if (circleCouponInfoActivity != null) {
            circleCouponInfoActivity.hideBaseProgressBar();
            this.f20192a.M1(true, false);
        }
    }

    public void h() {
        this.b = true;
        this.d.a(this.c, 10, this.f, new a());
    }

    public void i() {
        if (this.e || this.b) {
            return;
        }
        CircleCouponInfoActivity circleCouponInfoActivity = this.f20192a;
        if (circleCouponInfoActivity != null) {
            circleCouponInfoActivity.M1(true, true);
        }
        h();
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Double.parseDouble(str) > 0.0d;
        } catch (NumberFormatException e) {
            LogUtil.e(g, e);
            return false;
        }
    }

    public final boolean k(int i) {
        return i == 1;
    }

    public final void l(CircleCouponInfoResult circleCouponInfoResult) {
        if (circleCouponInfoResult != null) {
            String str = circleCouponInfoResult.headIconUrl;
            String str2 = circleCouponInfoResult.receiveAmount;
            String str3 = circleCouponInfoResult.couponTypeTips;
            String str4 = circleCouponInfoResult.receiveContent;
            String str5 = circleCouponInfoResult.listContent;
            int i = circleCouponInfoResult.viewDisplay;
            this.e = circleCouponInfoResult.lastPage;
            CircleCouponInfoActivity circleCouponInfoActivity = this.f20192a;
            if (circleCouponInfoActivity != null) {
                circleCouponInfoActivity.L1(circleCouponInfoResult.records);
                this.f20192a.M1(false, false);
                if (this.c == 1) {
                    m(circleCouponInfoResult.records);
                    if (j(str2)) {
                        this.f20192a.K1(str2);
                        this.f20192a.P1("");
                    } else {
                        this.f20192a.K1("");
                        this.f20192a.P1(str4);
                    }
                    this.f20192a.R1(k(i));
                    this.f20192a.N1(true);
                    this.f20192a.Q1(str);
                    this.f20192a.S1(str3);
                    this.f20192a.O1(str5);
                }
                this.c++;
            }
        }
    }

    public final void m(List<CircleCouponInfoItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f = list.get(0).detailId;
    }
}

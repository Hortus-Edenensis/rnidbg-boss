package defpackage;

import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17645a = 0;
    public String b = "";
    public String c = "";
    public EnterFromMerge d = EnterFromMerge.NO_VALUE;
    public EnterMethod e = EnterMethod.NO_VALUE;
    public ActionType f = ActionType.CLICK;
    public long g = 0;

    public g43 a(ActionType actionType) {
        this.f = actionType;
        return this;
    }

    public g43 b(String str) {
        this.b = str;
        return this;
    }

    public bc4 c() {
        return new bc4(this.f17645a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public g43 d(long j) {
        this.g = j;
        return this;
    }

    public g43 e(EnterFromMerge enterFromMerge) {
        this.d = enterFromMerge;
        return this;
    }

    public g43 f(EnterMethod enterMethod) {
        this.e = enterMethod;
        return this;
    }

    public g43 g(String str) {
        this.c = str;
        return this;
    }

    public g43 h(long j) {
        this.f17645a = j;
        return this;
    }
}

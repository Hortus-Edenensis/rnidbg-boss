package defpackage;

import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bc4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1685a;
    public String b;
    public String c;
    public EnterFromMerge d;
    public EnterMethod e;
    public ActionType f;
    public long g;

    public bc4(long j, String str, String str2, EnterFromMerge enterFromMerge, EnterMethod enterMethod, ActionType actionType, long j2) {
        this.f1685a = j;
        this.b = str;
        this.c = str2;
        this.d = enterFromMerge;
        this.e = enterMethod;
        this.f = actionType;
        this.g = j2;
    }

    public ActionType a() {
        return this.f;
    }

    public String b() {
        return this.b;
    }

    public long c() {
        return this.g;
    }

    public EnterFromMerge d() {
        return this.d;
    }

    public EnterMethod e() {
        return this.e;
    }

    public String f() {
        return this.c;
    }

    public long g() {
        return this.f1685a;
    }
}

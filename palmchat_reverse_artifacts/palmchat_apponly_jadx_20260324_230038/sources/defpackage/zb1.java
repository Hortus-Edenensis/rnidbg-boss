package defpackage;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zb1 implements ReportCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f22388a;
    public String b;
    public String c;

    public zb1(Context context, String str, String str2) {
        this.f22388a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i) {
        p63.a("DeviceReport", "report finish code:" + i);
        if (i != 0) {
            return;
        }
        kv2.F(this.f22388a, this.c);
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        kv2.D(this.f22388a, this.b);
    }
}

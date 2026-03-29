package defpackage;

import android.content.Context;
import com.zenmen.palmchat.sync.MyTabOfVipCenterConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19365a;
    public MyTabOfVipCenterConfig b;

    public mt3(Context context) {
        this.f19365a = context;
        JSONObject jSONObjectG = ts0.o().G();
        if (jSONObjectG == null) {
            this.b = new MyTabOfVipCenterConfig();
            return;
        }
        MyTabOfVipCenterConfig myTabOfVipCenterConfig = (MyTabOfVipCenterConfig) az2.a(jSONObjectG.toString(), MyTabOfVipCenterConfig.class);
        this.b = myTabOfVipCenterConfig;
        if (myTabOfVipCenterConfig == null) {
            this.b = new MyTabOfVipCenterConfig();
        }
    }

    public boolean a(String str) {
        return go.c(str, true);
    }

    public MyTabOfVipCenterConfig b() {
        return this.b;
    }

    public boolean c(String str) {
        return go.k(str, false);
    }
}

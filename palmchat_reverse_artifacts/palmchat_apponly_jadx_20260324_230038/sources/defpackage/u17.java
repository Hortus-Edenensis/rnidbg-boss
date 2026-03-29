package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.b;
import com.opos.acs.st.STManager;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.Objects;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class u17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21116a;
    public final ArrayMap<String, Object> b;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";

    public u17(@NonNull Context context) {
        Objects.requireNonNull(context, "TrackEvent: context is null");
        this.f21116a = context;
        this.b = new ArrayMap<>();
        c(context);
    }

    public static /* synthetic */ String b() {
        return "appId is empty";
    }

    public final void c(Context context) {
        this.b.put(STManager.KEY_DATA_TYPE, Integer.valueOf(g()));
        this.b.put(STManager.KEY_SSO_ID, sw6.a(context));
        this.b.put("statSId", ec7.a().b(context));
        String strI = x17.i(context);
        if (TextUtils.isEmpty(strI)) {
            n87.c("TrackEvent", new la7() { // from class: yy6
                @Override // defpackage.la7
                public final Object get() {
                    return u17.b();
                }
            });
        } else {
            f(strI);
        }
        nw6 nw6VarE = nw6.e(strI);
        if (nw6VarE == null) {
            this.b.put("appVersion", x17.h(context));
            this.b.put(b.e, x17.d(context));
            this.b.put(WfConstant.EVENT_KEY_APP_NAME, x17.g(context));
        } else {
            this.b.put("headerFlag", Integer.valueOf(nw6VarE.b().c()));
            this.b.put("appVersion", nw6VarE.b().g());
            this.b.put(b.e, nw6VarE.b().e());
            this.b.put(WfConstant.EVENT_KEY_APP_NAME, nw6VarE.b().h());
        }
    }

    public void d(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
    }

    public void e(String str, String str2) {
        this.b.put(str, str2);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
        e("appIdStr", str);
        if (TextUtils.isDigitsOnly(this.c)) {
            d("appId", Integer.parseInt(this.c));
        }
    }

    public abstract int g();

    @NonNull
    public Map<String, Object> h() {
        return new ArrayMap(this.b);
    }

    public String i() {
        return this.c;
    }

    @NonNull
    public Context j() {
        return this.f21116a;
    }
}

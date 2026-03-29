package defpackage;

import android.text.Html;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.handinhand.bean.HandInHandUpdateEvent;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dg2 {
    public static final String f = "dg2";
    public static dg2 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sp4 f17043a;
    public int b = -1;
    public boolean c;
    public long d;
    public boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject != null) {
                LogUtil.i(dg2.f, "queryAmountDao onResponse " + jSONObject.toString());
                int iOptInt = jSONObject.optInt("resultCode", -1);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (iOptInt == 0 && jSONObjectOptJSONObject != null) {
                    dg2.this.b = jSONObjectOptJSONObject.optInt("amount");
                    dg2.this.c = jSONObjectOptJSONObject.optBoolean(bq.b.V);
                    ds0.a().b(new HandInHandUpdateEvent());
                }
            }
            dg2.this.e = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            dg2.this.e = false;
        }
    }

    public static dg2 f() {
        if (g == null) {
            synchronized (dg2.class) {
                if (g == null) {
                    g = new dg2();
                }
            }
        }
        return g;
    }

    public boolean e() {
        return this.c;
    }

    public CharSequence g() {
        return (this.b <= 0 || !tg4.b(AppContext.getContext(), BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList)) ? "" : Html.fromHtml(AppContext.getContext().getString(R.string.settings_item_handinhandv3_subtitle, fg2.b(), Integer.valueOf(this.b / 100)));
    }

    public void h() {
        if (this.e) {
            return;
        }
        sp4 sp4Var = new sp4(new a(), new b());
        this.f17043a = sp4Var;
        sp4Var.n();
        LogUtil.i(f, "queryAmountDao.post....");
        this.e = true;
    }

    public void i() {
        if (fg2.c()) {
            if (this.b < 0 || Math.abs(System.currentTimeMillis() - this.d) > fg2.a()) {
                h();
                this.d = System.currentTimeMillis();
            }
        }
    }
}

package defpackage;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.databinding.LovematchPopNewMatchBinding;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o93 extends m93 {
    public static final String i = "o93";
    public LovematchPopNewMatchBinding e;
    public je1 f;
    public Activity g;
    public ObjectAnimator h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o93.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19718a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o93.this.h.start();
            }
        }

        public b(String str, String str2, int i) {
            this.f19718a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            n93.b(this.f19718a, this.b, this.c);
            if (o93.this.h != null) {
                o93.this.h.cancel();
            }
            Path path = new Path();
            path.moveTo(0.3f, 0.3f);
            path.lineTo(1.2f, 1.2f);
            path.lineTo(1.0f, 1.0f);
            o93 o93Var = o93.this;
            o93Var.h = ObjectAnimator.ofFloat(o93Var.e.b, "scaleX", "scaleY", path);
            o93.this.h.setDuration(400L);
            if (!o93.this.c()) {
                o93.this.h.start();
                return;
            }
            o93.this.e.b.setScaleX(0.3f);
            o93.this.e.b.setScaleY(0.3f);
            o93.this.d.postDelayed(new a(), 300L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19720a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kd5 f19721a;

            public a(kd5 kd5Var) {
                this.f19721a = kd5Var;
            }

            @Override // o93.e
            public void onFailure(Exception exc) {
                if (!this.f19721a.isShowing() || o93.this.g.isFinishing()) {
                    return;
                }
                this.f19721a.dismiss();
                LogUtil.e(o93.i, "request remain num failed.", exc);
                sy5.f(o93.this.g, "获取剩余次数失败，请稍后再试", 0).g();
            }

            @Override // o93.e
            public void onSuccess(int i) {
                if (!this.f19721a.isShowing() || o93.this.g.isFinishing()) {
                    return;
                }
                this.f19721a.dismiss();
                if (i > 0) {
                    if (!TextUtils.isEmpty(c.this.b)) {
                        p93.p(o93.this.g, c.this.b);
                    }
                    o93.this.dismiss();
                } else if (!fg6.d(o93.this.g)) {
                    ap3.y(com.zenmen.palmchat.c.b(), "51", "1");
                } else {
                    sy5.f(o93.this.g, "今天次数已用完，明天再来吧～", 0).g();
                    o93.this.dismiss();
                }
            }
        }

        public c(String str, String str2, int i) {
            this.f19720a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n93.a(this.f19720a, this.b, this.c);
            o93.this.l(new a(kd5.b(o93.this.g)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19722a;

        public d(e eVar) {
            this.f19722a = eVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            e eVar = this.f19722a;
            if (eVar != null) {
                eVar.onFailure(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(o93.i, "======get remaining num info:" + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt2 = jSONObjectOptJSONObject.optInt("remainingNum", -1);
            if (iOptInt2 == -1) {
                onFail(new Exception("num is null"));
                return;
            }
            e eVar = this.f19722a;
            if (eVar != null) {
                eVar.onSuccess(iOptInt2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void onFailure(Exception exc);

        void onSuccess(int i);
    }

    public o93(@NonNull Activity activity) {
        super(activity);
        this.f = null;
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setFlags(32, 32);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 48;
        attributes.y = a46.b(activity, 34.0f);
        window.setAttributes(attributes);
        this.g = activity;
        LovematchPopNewMatchBinding lovematchPopNewMatchBindingB = LovematchPopNewMatchBinding.b(LayoutInflater.from(getContext()));
        this.e = lovematchPopNewMatchBindingB;
        setContentView(lovematchPopNewMatchBindingB.getRoot());
        this.e.c.setOnClickListener(new a());
    }

    public static String j(long j) {
        if (j < 1000) {
            return j + "m";
        }
        return (j / 1000) + "km";
    }

    public Activity k() {
        return this.g;
    }

    public final void l(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            zw4.f(vm0.e1, 1, jSONObject, new d(eVar));
        } catch (JSONException e2) {
            if (eVar != null) {
                eVar.onFailure(e2);
            }
        }
    }

    public void m(JSONObject jSONObject, int i2, String str) {
        int iOptInt;
        String strOptString = jSONObject.optString("avatar", "");
        if (this.f == null) {
            this.f = a46.i(R.drawable.default_portrait);
        }
        gr2.j().h(strOptString, this.e.f13911a, this.f);
        String strOptString2 = jSONObject.optString(DeviceInfoUtil.UID_TAG, null);
        b(new b(str, strOptString2, i2));
        int iOptInt2 = jSONObject.optInt("sex", -1);
        if (iOptInt2 == 0) {
            this.e.h.setVisibility(0);
            this.e.h.setImageResource(R.mipmap.lovematch_pop_generic_sex_man);
        } else if (iOptInt2 == 1) {
            this.e.h.setVisibility(0);
            this.e.h.setImageResource(R.mipmap.lovematch_pop_generic_sex_women);
        } else {
            this.e.h.setVisibility(8);
        }
        int iOptInt3 = jSONObject.optInt("age", -1);
        long jOptLong = jSONObject.optLong("distance", -1L);
        String strOptString3 = jSONObject.optString("activeStateDesc", null);
        StringBuffer stringBuffer = new StringBuffer();
        if (iOptInt3 != -1) {
            stringBuffer.append(iOptInt3 + "岁");
        }
        if (jOptLong != -1) {
            stringBuffer.append("·距离" + j(jOptLong));
        }
        if (!TextUtils.isEmpty(strOptString3)) {
            stringBuffer.append("·" + strOptString3);
        }
        String string = stringBuffer.toString();
        if (string.startsWith("·")) {
            string = string.substring(1);
        }
        this.e.e.setText(string);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("friendType");
        this.e.f.setVisibility(8);
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && (iOptInt = jSONArrayOptJSONArray.optInt(0, -1)) != -1) {
            String strF = hs1.e().f(iOptInt);
            if (!TextUtils.isEmpty(strF)) {
                this.e.f.setVisibility(0);
                this.e.f.setText(strF);
            }
        }
        this.e.g.setVisibility(8);
        int iOptInt4 = jSONObject.optInt("jobType", -1);
        if (iOptInt4 != -1) {
            String strH = hs1.e().h(iOptInt4);
            if (!TextUtils.isEmpty(strH)) {
                this.e.g.setVisibility(0);
                this.e.g.setText(strH);
            }
        }
        this.e.d.setText(p93.m().d);
        this.e.d.setOnClickListener(new c(str, strOptString2, i2));
    }
}

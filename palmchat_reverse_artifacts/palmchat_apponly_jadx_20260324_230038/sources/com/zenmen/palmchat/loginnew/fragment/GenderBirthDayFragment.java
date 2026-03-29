package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker;
import defpackage.ac1;
import defpackage.e73;
import defpackage.eb4;
import defpackage.f56;
import defpackage.fm1;
import defpackage.iv0;
import defpackage.l50;
import defpackage.mz;
import defpackage.nz;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.x63;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GenderBirthDayFragment extends BaseCompleteProfileFragment {
    public static final String F = "GenderBirthDayFragment";
    public int A;
    public int B = -1;
    public String C;
    public f56 E;
    public Activity p;
    public View q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public DateWheelPicker v;
    public TextView w;
    public com.zenmen.palmchat.loginnew.a x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            genderBirthDayFragment.W(genderBirthDayFragment.p, null, GenderBirthDayFragment.this.getString(R.string.profile_fail));
            GenderBirthDayFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Response.Listener f14491a;
        public final /* synthetic */ Response.ErrorListener b;
        public final /* synthetic */ String c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements CaptchaManager.a {
            public a() {
            }

            @Override // com.zenmen.palmchat.utils.captcha.CaptchaManager.a
            public void a(int i, CaptchaResult captchaResult) {
                if (captchaResult != null) {
                    b bVar = b.this;
                    GenderBirthDayFragment.this.G0(captchaResult, bVar.f14491a, bVar.b, bVar.c);
                }
            }
        }

        public b(Response.Listener listener, Response.ErrorListener errorListener, String str) {
            this.f14491a = listener;
            this.b = errorListener;
            this.c = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null || !nz.c(jSONObject.optInt("resultCode", -1)) || GenderBirthDayFragment.this.getActivity() == null) {
                this.f14491a.onResponse(jSONObject);
            } else {
                CaptchaManager.c(GenderBirthDayFragment.this.getActivity(), new mz(jSONObject.optJSONObject("data"), GenderBirthDayFragment.this.i, null, false), new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            zn6.f("reggenderage_clickmale", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            GenderBirthDayFragment.this.C0(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            zn6.f("reggenderage_clickfamale", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            GenderBirthDayFragment.this.C0(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DateWheelPicker.d {
        public e() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker.d
        public void a() {
            if (!GenderBirthDayFragment.this.z) {
                GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
                zn6.f("reggenderage_clickage", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            }
            GenderBirthDayFragment.this.z = true;
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker.d
        public void b() {
            if (!GenderBirthDayFragment.this.z) {
                GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
                zn6.f("reggenderage_clickage", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            }
            GenderBirthDayFragment.this.z = true;
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker.d
        public void c() {
            if (!GenderBirthDayFragment.this.z) {
                GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
                zn6.f("reggenderage_clickage", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            }
            GenderBirthDayFragment.this.z = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            zn6.f("reggenderage_clicknext", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
            GenderBirthDayFragment.this.u0("/user.update.info.v2");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GenderBirthDayFragment.this.A0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.d("reggenderage_show_clickskip", null, new JSONObject().toString());
            GenderBirthDayFragment.this.u0("/user.sex.default.set");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {
        public i() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            GenderBirthDayFragment.this.c0();
            com.zenmen.palmchat.loginnew.a aVar = GenderBirthDayFragment.this.x;
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            aVar.M0(false, genderBirthDayFragment.i, null, genderBirthDayFragment.A, 0, 1);
            GenderBirthDayFragment.this.B = -1;
            GenderBirthDayFragment genderBirthDayFragment2 = GenderBirthDayFragment.this;
            genderBirthDayFragment2.C = null;
            zn6.f("reggenderage_detaintop_exit", "click", x63.b(genderBirthDayFragment2.i, genderBirthDayFragment2.A));
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            zn6.f("reggenderage_detaintop_continue", "click", x63.b(genderBirthDayFragment.i, genderBirthDayFragment.A));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements BaseCompleteProfileFragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14500a;

        public j(String str) {
            this.f14500a = str;
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void a() {
            GenderBirthDayFragment.this.I0(this.f14500a);
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void b() {
            GenderBirthDayFragment.this.G();
            sy5.e(AppContext.getContext(), R.string.mend_update_session_error, 0).g();
            com.zenmen.palmchat.loginnew.a aVar = GenderBirthDayFragment.this.x;
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            aVar.M0(false, genderBirthDayFragment.i, null, genderBirthDayFragment.A, 0, 2);
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void c() {
            GenderBirthDayFragment.this.G();
            GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
            genderBirthDayFragment.W(genderBirthDayFragment.p, null, GenderBirthDayFragment.this.getString(R.string.profile_fail));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.Listener<JSONObject> {
        public k() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt == 0) {
                com.zenmen.palmchat.loginnew.a aVar = GenderBirthDayFragment.this.x;
                GenderBirthDayFragment genderBirthDayFragment = GenderBirthDayFragment.this;
                aVar.N0(genderBirthDayFragment.f, genderBirthDayFragment.A, GenderBirthDayFragment.this.h);
            } else {
                GenderBirthDayFragment genderBirthDayFragment2 = GenderBirthDayFragment.this;
                genderBirthDayFragment2.W(genderBirthDayFragment2.p, null, GenderBirthDayFragment.this.getString(R.string.profile_fail));
                HashMap map = new HashMap();
                map.put("from", "gender");
                map.put(DeviceInfoUtil.UID_TAG, GenderBirthDayFragment.this.i);
                map.put("errorCode", String.valueOf(iOptInt));
                zn6.i("risk_control_tips", map);
            }
            GenderBirthDayFragment.this.G();
        }
    }

    public final void A0() {
        zn6.f("reggenderage_clickback", "click", x63.b(this.i, this.A));
        new sd3(getContext()).T(R.string.complete_gender_back_title).j(R.string.complete_gender_back_text).h(true).O(R.string.complete_gender_back_positive).K(R.string.complete_gender_back_negative).f(new i()).e().show();
        zn6.f("reggenderage_detaintop", "view", x63.b(this.i, this.A));
    }

    public void B0(int i2, JSONObject jSONObject) {
        this.A = i2;
        h0(jSONObject);
        this.B = this.o;
        K0();
        zn6.f("reggenderage_show", "view", x63.b(this.i, i2));
    }

    public void C0(int i2) {
        this.B = i2;
        this.w.setEnabled(i2 >= 0);
        this.t.setSelected(i2 == 0);
        this.u.setSelected(i2 == 1);
    }

    public final void E0(String str) {
        L();
        Z(new j(str));
    }

    public final void G0(CaptchaResult captchaResult, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, String str) {
        this.E = new f56(listener, errorListener);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, this.i);
            jSONObject.put("birthday", this.C);
            jSONObject.put("sex", this.B);
            jSONObject.put("sdid", ac1.v());
            jSONObject.put("appId", eb4.b());
            jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("dfp", fm1.k().toString());
            nz.b(jSONObject, captchaResult);
            this.E.n(this.i, this.j, jSONObject, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            W(this.p, null, getString(R.string.profile_fail));
            G();
        }
    }

    public void I0(String str) {
        k kVar = new k();
        a aVar = new a();
        G0(null, new b(kVar, aVar, str), aVar, str);
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (!isVisible()) {
            return false;
        }
        A0();
        return true;
    }

    public final void K0() {
        if (this.q != null) {
            this.w.setEnabled(this.B >= 0);
            this.t.setSelected(this.B == 0);
            this.u.setSelected(this.B == 1);
            if (TextUtils.isEmpty(this.l)) {
                this.v.reset();
            } else {
                this.v.setBirthday(iv0.b(this.l));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment, com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("authResponseData", null);
            if (!TextUtils.isEmpty(string) && this.y) {
                e0(string);
                this.B = this.o;
                zn6.f("reggenderage_show", "view", x63.b(this.i, this.A));
            }
        }
        FragmentActivity activity = getActivity();
        this.p = activity;
        this.x = (com.zenmen.palmchat.loginnew.a) activity;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_gender_birthday, (ViewGroup) null, false);
        this.q = viewInflate;
        viewInflate.setVisibility(this.y ? 0 : 4);
        x0();
        y0();
        return this.q;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f56 f56Var = this.E;
        if (f56Var != null) {
            f56Var.onCancel();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i(F, "onResume");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.y = z;
        if (z) {
            View view = this.q;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.q;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    public final void u0(String str) {
        String birthday = this.v.getBirthday();
        this.C = birthday;
        if (this.B == this.o && birthday.equals(this.l)) {
            this.x.N0(this.f, this.A, this.h);
        } else {
            E0(str);
        }
    }

    public void w0(int i2) {
        this.A = i2;
    }

    public final void x0() {
        Toolbar toolbar = (Toolbar) this.q.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((TextView) toolbar.findViewById(R.id.title)).setText(R.string.complete_profile_title);
            toolbar.setNavigationIcon(R.drawable.login_back);
            toolbar.setNavigationOnClickListener(new g());
            ((TextView) toolbar.findViewById(R.id.btn_jump)).setOnClickListener(new h());
        }
    }

    public final void y0() {
        TextView textView = (TextView) this.q.findViewById(R.id.tv_text_title);
        this.r = textView;
        textView.setText(e73.e());
        TextView textView2 = (TextView) this.q.findViewById(R.id.tv_text_subtitle);
        this.s = textView2;
        textView2.setText(e73.d());
        TextView textView3 = (TextView) this.q.findViewById(R.id.btn_male);
        this.t = textView3;
        textView3.setOnClickListener(new c());
        TextView textView4 = (TextView) this.q.findViewById(R.id.btn_female);
        this.u = textView4;
        textView4.setOnClickListener(new d());
        DateWheelPicker dateWheelPicker = (DateWheelPicker) this.q.findViewById(R.id.birthday_view);
        this.v = dateWheelPicker;
        dateWheelPicker.setListener(new e());
        TextView textView5 = (TextView) this.q.findViewById(R.id.btn_next);
        this.w = textView5;
        textView5.setOnClickListener(new f());
        K0();
    }
}

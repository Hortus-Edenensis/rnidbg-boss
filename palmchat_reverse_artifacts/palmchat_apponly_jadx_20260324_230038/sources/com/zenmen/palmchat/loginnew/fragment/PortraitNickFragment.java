package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bg5;
import defpackage.bq6;
import defpackage.cq3;
import defpackage.dq3;
import defpackage.dt2;
import defpackage.e73;
import defpackage.gr2;
import defpackage.k86;
import defpackage.l50;
import defpackage.o52;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.vm0;
import defpackage.x63;
import defpackage.yy2;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PortraitNickFragment extends BaseCompleteProfileFragment {
    public static final String S = "PortraitNickFragment";
    public com.zenmen.palmchat.loginnew.a A;
    public boolean B;
    public boolean C;
    public int E;
    public String F;
    public String G;
    public ProgressBar K;
    public dq3 M;
    public o52 N;
    public cq3 O;
    public Timer P;
    public TimerTask Q;
    public Activity p;
    public View q;
    public ScrollView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public EffectiveShapeView v;
    public ImageView w;
    public EditText x;
    public ImageView y;
    public TextView z;
    public int H = 0;
    public boolean I = false;
    public MaterialDialog J = null;
    public int L = 0;
    public boolean R = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            PortraitNickFragment.this.G();
            LogUtil.i(PortraitNickFragment.S, "genUserPortrait response=" + jSONObject);
            try {
                if (jSONObject.optInt("resultCode", -1) != 0) {
                    PortraitNickFragment.this.p1();
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("headIconUrl") : null;
                com.zenmen.palmchat.loginnew.a aVar = PortraitNickFragment.this.A;
                PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
                aVar.M0(true, portraitNickFragment.i, strOptString, portraitNickFragment.L, 2, 0);
            } catch (Exception e) {
                PortraitNickFragment.this.p1();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PortraitNickFragment.this.G();
            PortraitNickFragment.this.p1();
            LogUtil.i(PortraitNickFragment.S, "genUserPortrait error=" + String.valueOf(volleyError));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(PortraitNickFragment.S, "uploadNickname response=" + String.valueOf(jSONObject));
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (!PortraitNickFragment.this.p.isFinishing()) {
                if (iOptInt != 0) {
                    if (PortraitNickFragment.this.H < 100) {
                        PortraitNickFragment.this.H = 0;
                        PortraitNickFragment.this.m1();
                    }
                    PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
                    portraitNickFragment.W(portraitNickFragment.p, null, PortraitNickFragment.this.getString(R.string.profile_fail));
                    HashMap map = new HashMap();
                    map.put("from", "nickname");
                    map.put(DeviceInfoUtil.UID_TAG, PortraitNickFragment.this.i);
                    map.put("errorCode", String.valueOf(iOptInt));
                    zn6.i("risk_control_tips", map);
                } else if (PortraitNickFragment.this.G.equals(PortraitNickFragment.this.n)) {
                    PortraitNickFragment.this.f1();
                    com.zenmen.palmchat.loginnew.a aVar = PortraitNickFragment.this.A;
                    PortraitNickFragment portraitNickFragment2 = PortraitNickFragment.this;
                    aVar.M0(true, portraitNickFragment2.i, portraitNickFragment2.G, PortraitNickFragment.this.L, 1, 0);
                } else {
                    PortraitNickFragment.this.u1();
                }
            }
            PortraitNickFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(PortraitNickFragment.S, "uploadNickname error=" + String.valueOf(volleyError));
            PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
            portraitNickFragment.W(portraitNickFragment.p, null, PortraitNickFragment.this.getString(R.string.profile_fail));
            PortraitNickFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<String> {
        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            LogUtil.i(PortraitNickFragment.S, "uploadPortrait response=" + String.valueOf(str));
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("resultCode", -1);
                if (iOptInt == 0) {
                    if (PortraitNickFragment.this.R) {
                        return;
                    }
                    PortraitNickFragment.this.f1();
                    com.zenmen.palmchat.loginnew.a aVar = PortraitNickFragment.this.A;
                    PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
                    aVar.M0(true, portraitNickFragment.i, portraitNickFragment.G, PortraitNickFragment.this.L, 3, 0);
                    return;
                }
                if (iOptInt != 1131) {
                    PortraitNickFragment.this.p1();
                    return;
                }
                if (PortraitNickFragment.this.H < 100) {
                    PortraitNickFragment.this.H = 0;
                    PortraitNickFragment.this.m1();
                }
                PortraitNickFragment.this.f1();
                PortraitNickFragment portraitNickFragment2 = PortraitNickFragment.this;
                portraitNickFragment2.W(portraitNickFragment2.p, yy2.a(jSONObject), PortraitNickFragment.this.getString(R.string.send_failed));
            } catch (JSONException e) {
                e.printStackTrace();
                PortraitNickFragment.this.p1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(PortraitNickFragment.S, "uploadPortrait error=" + String.valueOf(volleyError));
            PortraitNickFragment.this.p1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends TimerTask {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PortraitNickFragment.this.R) {
                    return;
                }
                if (PortraitNickFragment.this.H < 61) {
                    PortraitNickFragment.this.H += 5;
                    PortraitNickFragment.this.K.setProgress(PortraitNickFragment.this.H);
                } else if (PortraitNickFragment.this.H > 60 && PortraitNickFragment.this.H < 81) {
                    PortraitNickFragment.this.H += 2;
                    PortraitNickFragment.this.K.setProgress(PortraitNickFragment.this.H);
                } else {
                    if (PortraitNickFragment.this.H <= 80 || PortraitNickFragment.this.H >= 99) {
                        PortraitNickFragment.this.K.setProgress(PortraitNickFragment.this.H);
                        return;
                    }
                    PortraitNickFragment.this.H++;
                    PortraitNickFragment.this.K.setProgress(PortraitNickFragment.this.H);
                }
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            PortraitNickFragment.this.p.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements DialogInterface.OnCancelListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                PortraitNickFragment.this.I = false;
                if (PortraitNickFragment.this.M != null) {
                    PortraitNickFragment.this.M.onCancel();
                }
                if (PortraitNickFragment.this.H < 100) {
                    PortraitNickFragment.this.H = 0;
                    PortraitNickFragment.this.m1();
                }
                sy5.e(PortraitNickFragment.this.p, R.string.mend_update_cancle_toast, 0).g();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                PortraitNickFragment.this.k1();
            }
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (PortraitNickFragment.this.I) {
                new sd3(PortraitNickFragment.this.p).j(R.string.mend_exit_update).h(false).O(R.string.mend_update_wait).K(R.string.mend_update_cancle).f(new a()).e().show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitNickFragment.this.n1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitNickFragment.this.n1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitNickFragment.this.x.setText("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
            portraitNickFragment.F = portraitNickFragment.x.getText().toString().trim();
            if (!TextUtils.isEmpty(PortraitNickFragment.this.F) && !TextUtils.isEmpty(PortraitNickFragment.this.G)) {
                if (PortraitNickFragment.this.F.equals(PortraitNickFragment.this.m) && PortraitNickFragment.this.G.equals(PortraitNickFragment.this.n)) {
                    com.zenmen.palmchat.loginnew.a aVar = PortraitNickFragment.this.A;
                    PortraitNickFragment portraitNickFragment2 = PortraitNickFragment.this;
                    aVar.M0(true, portraitNickFragment2.i, portraitNickFragment2.G, PortraitNickFragment.this.L, 1, 0);
                } else {
                    PortraitNickFragment.this.v1(false);
                }
            }
            PortraitNickFragment portraitNickFragment3 = PortraitNickFragment.this;
            zn6.f("regphotonick_clicknext", "click", x63.b(portraitNickFragment3.i, portraitNickFragment3.L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements bg5.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitNickFragment.this.r.fullScroll(130);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitNickFragment.this.r.fullScroll(33);
            }
        }

        public n() {
        }

        @Override // bg5.a
        public void a() {
            if (PortraitNickFragment.this.B) {
                PortraitNickFragment.this.q.postDelayed(new b(), 50L);
            }
        }

        @Override // bg5.a
        public void b(int i, int i2) {
            if (PortraitNickFragment.this.B) {
                PortraitNickFragment.this.q.postDelayed(new a(), 50L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PortraitNickFragment.this.v1(true);
            PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
            zn6.f("regphotonick_clickskip", "click", x63.b(portraitNickFragment.i, portraitNickFragment.L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitNickFragment.this.i1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements BaseCompleteProfileFragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14533a;

        public q(boolean z) {
            this.f14533a = z;
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void a() {
            if (this.f14533a) {
                PortraitNickFragment.this.e1();
            } else if (PortraitNickFragment.this.F.equals(PortraitNickFragment.this.m)) {
                PortraitNickFragment.this.u1();
            } else {
                PortraitNickFragment.this.t1();
            }
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void b() {
            PortraitNickFragment.this.r1(true);
            com.zenmen.palmchat.loginnew.a aVar = PortraitNickFragment.this.A;
            PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
            aVar.M0(false, portraitNickFragment.i, null, portraitNickFragment.L, 0, 2);
        }

        @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment.b
        public void c() {
            PortraitNickFragment.this.p1();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (!isVisible()) {
            return false;
        }
        i1();
        return true;
    }

    public final void e1() {
        this.N = new o52(new a(), new b());
        if (TextUtils.isEmpty(this.i) || TextUtils.isEmpty(this.j)) {
            return;
        }
        try {
            this.N.n(this.i, this.j);
        } catch (Exception e2) {
            p1();
            e2.printStackTrace();
        }
    }

    public final void f1() {
        MaterialDialog materialDialog = this.J;
        if (materialDialog != null) {
            try {
                materialDialog.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void g1() {
        Toolbar toolbar = (Toolbar) this.q.findViewById(R.id.toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.btn_jump);
        this.s = textView;
        textView.setOnClickListener(new o());
        ((TextView) toolbar.findViewById(R.id.title)).setText(R.string.complete_profile_title);
        toolbar.setNavigationIcon(R.drawable.login_back);
        toolbar.setNavigationOnClickListener(new p());
    }

    public final void h1() {
        this.r = (ScrollView) this.q.findViewById(R.id.scroll_layout);
        TextView textView = (TextView) this.q.findViewById(R.id.tv_text_title);
        this.t = textView;
        textView.setText(e73.m());
        TextView textView2 = (TextView) this.q.findViewById(R.id.tv_text_subtitle);
        this.u = textView2;
        textView2.setText(e73.l());
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) this.q.findViewById(R.id.take_photo);
        this.v = effectiveShapeView;
        effectiveShapeView.changeShapeType(1);
        this.v.setOnClickListener(new i());
        ImageView imageView = (ImageView) this.q.findViewById(R.id.take_photo_logo);
        this.w = imageView;
        imageView.setOnClickListener(new j());
        EditText editText = (EditText) this.q.findViewById(R.id.nick_edit);
        this.x = editText;
        e73.r(editText, R.drawable.login_phonenumber_cursor);
        this.x.addTextChangedListener(new k());
        this.E = this.x.getEditableText().toString().length();
        ImageView imageView2 = (ImageView) this.q.findViewById(R.id.nick_clear);
        this.y = imageView2;
        imageView2.setVisibility(this.E > 0 ? 0 : 8);
        this.y.setOnClickListener(new l());
        TextView textView3 = (TextView) this.q.findViewById(R.id.btn_next);
        this.z = textView3;
        textView3.setEnabled(false);
        this.z.setOnClickListener(new m());
        new bg5(this.q, false).a(new n());
    }

    public final void i1() {
        this.v.setImageResource(R.color.transparent);
        c0();
        this.H = 0;
        this.C = false;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.x.setText("");
        this.z.setEnabled(false);
        this.A.n(this.g);
        zn6.f("regphotonick_clickback", "click", x63.b(this.i, this.L));
    }

    public void j1(int i2, JSONObject jSONObject) {
        this.L = i2;
        h0(jSONObject);
        if (!TextUtils.isEmpty(this.n)) {
            this.G = this.n;
            gr2.j().h(k86.p(this.G), this.v, bq6.s());
        }
        String str = this.m;
        this.F = str;
        if (!TextUtils.isEmpty(str)) {
            this.x.setText(this.F);
            EditText editText = this.x;
            editText.setSelection(editText.getText().length());
            this.E = this.F.length();
        }
        s1();
        zn6.f("regphotonick_show", "view", x63.b(this.i, i2));
    }

    public final void k1() {
        View viewInflate = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.layout_mend_dialog, (ViewGroup) null);
        this.K = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        l1();
        MaterialDialog materialDialogE = new sd3(this.p).b(false).p(viewInflate, true).L(null).g(new h()).P(null).e();
        this.J = materialDialogE;
        materialDialogE.setCanceledOnTouchOutside(false);
        this.J.show();
    }

    public final void l1() {
        if (this.P != null) {
            return;
        }
        this.R = false;
        this.P = new Timer();
        g gVar = new g();
        this.Q = gVar;
        if (this.H <= 60) {
            this.P.schedule(gVar, 0L, 250L);
        }
    }

    public final void m1() {
        this.R = true;
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
            this.P = null;
        }
        TimerTask timerTask = this.Q;
        if (timerTask != null) {
            timerTask.cancel();
            this.Q = null;
        }
    }

    public final void n1() {
        Intent intent = new Intent(this.p, (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 1);
        startActivityForResult(intent, 1);
        zn6.f("regphotonick_clickphoto", "click", x63.b(this.i, this.L));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                this.G = stringExtra;
                gr2.j().h(k86.p(this.G), this.v, bq6.t());
                s1();
            }
            zn6.f("regphotonick_clickphotodone", null, x63.b(this.i, this.L));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.loginnew.fragment.BaseCompleteProfileFragment, com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.p = activity;
        this.A = (com.zenmen.palmchat.loginnew.a) activity;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_portrait_nick, (ViewGroup) null, false);
        this.q = viewInflate;
        viewInflate.setVisibility(this.B ? 0 : 4);
        g1();
        h1();
        return this.q;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dq3 dq3Var = this.M;
        if (dq3Var != null) {
            dq3Var.onCancel();
        }
        o52 o52Var = this.N;
        if (o52Var != null) {
            o52Var.onCancel();
        }
        cq3 cq3Var = this.O;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i(S, "onResume");
    }

    public final void p1() {
        r1(false);
    }

    public final void r1(boolean z) {
        if (this.H < 100) {
            this.H = 0;
            m1();
        }
        f1();
        if (z) {
            sy5.e(AppContext.getContext(), R.string.mend_update_session_error, 0).g();
            return;
        }
        Activity activity = this.p;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        W(this.p, null, getString(R.string.profile_fail));
    }

    public final void s1() {
        if (this.E <= 0 || TextUtils.isEmpty(this.G)) {
            this.z.setEnabled(false);
        } else {
            this.z.setEnabled(true);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.B = z;
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

    public final void t1() {
        c cVar = new c();
        d dVar = new d();
        HashMap map = new HashMap();
        map.put("nickname", this.F);
        cq3 cq3Var = new cq3(cVar, dVar);
        this.O = cq3Var;
        try {
            cq3Var.o(map, Y(vm0.f));
        } catch (Exception e2) {
            e2.printStackTrace();
            G();
        }
    }

    public final void u1() {
        dq3 dq3Var = new dq3(new e(), new f(), this.G, true);
        this.M = dq3Var;
        try {
            dq3Var.o(this.i, this.j);
        } catch (DaoException e2) {
            e2.printStackTrace();
            p1();
        }
    }

    public final void v1(boolean z) {
        this.I = true;
        if (z || this.G.equals(this.n)) {
            L();
        } else {
            k1();
        }
        Z(new q(z));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements TextWatcher {
        public k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PortraitNickFragment portraitNickFragment = PortraitNickFragment.this;
            portraitNickFragment.E = portraitNickFragment.x.getEditableText().toString().trim().length();
            PortraitNickFragment.this.s1();
            PortraitNickFragment.this.y.setVisibility(PortraitNickFragment.this.E > 0 ? 0 : 8);
            if (PortraitNickFragment.this.E <= 0 || PortraitNickFragment.this.C) {
                return;
            }
            PortraitNickFragment.this.C = true;
            PortraitNickFragment portraitNickFragment2 = PortraitNickFragment.this;
            zn6.f("regphotonick_namewrite", "click", x63.b(portraitNickFragment2.i, portraitNickFragment2.L));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            dt2.d(PortraitNickFragment.this.x, charSequence, 18);
            if (charSequence.length() == 0) {
                PortraitNickFragment.this.x.setTypeface(Typeface.defaultFromStyle(0));
            } else {
                PortraitNickFragment.this.x.setTypeface(Typeface.defaultFromStyle(1));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}

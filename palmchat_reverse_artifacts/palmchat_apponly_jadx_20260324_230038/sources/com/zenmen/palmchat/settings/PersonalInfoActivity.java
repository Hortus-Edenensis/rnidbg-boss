package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.openalliance.ad.constant.az;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.a;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.settings.portrait.PortraitAlbumActivity;
import com.zenmen.palmchat.task1v1.TaskTipBean;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CommonInfoCellView;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.b05;
import defpackage.bo0;
import defpackage.cq3;
import defpackage.dq3;
import defpackage.ds0;
import defpackage.fn0;
import defpackage.fq3;
import defpackage.ft5;
import defpackage.gq3;
import defpackage.hx3;
import defpackage.i00;
import defpackage.il5;
import defpackage.iq5;
import defpackage.je1;
import defpackage.k86;
import defpackage.m66;
import defpackage.q42;
import defpackage.qm5;
import defpackage.r92;
import defpackage.rk4;
import defpackage.rw0;
import defpackage.sy5;
import defpackage.y63;
import defpackage.yy2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalInfoActivity extends BaseActionBarActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public TextView F;
    public TextView G;
    public LXPortraitView H;
    public TextView I;
    public ImageView J;
    public View K;
    public View L;
    public View M;
    public View N;
    public View O;
    public View P;
    public View Q;
    public je1 R;
    public Response.Listener<String> S;
    public Response.ErrorListener T;
    public boolean U = false;
    public cq3 V;
    public dq3 W;
    public gq3 X;
    public CommonInfoCellView Y;
    public CommonInfoCellView Z;
    public CommonInfoCellView e0;
    public CommonInfoCellView f0;
    public CommonInfoCellView g0;
    public View h0;
    public View i0;
    public CommonInfoCellView j0;
    public CommonInfoCellView k0;
    public CommonInfoCellView l0;
    public CommonInfoCellView m0;
    public CommonInfoCellView n0;
    public LinearLayout o0;
    public int q;
    public r92 r;
    public ContactInfoItem s;
    public String t;
    public String u;
    public int v;
    public TextView w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalInfoActivity.this.s != null && TextUtils.isEmpty(PersonalInfoActivity.this.s.getAccount())) {
                Intent intent = new Intent(PersonalInfoActivity.this, (Class<?>) ModifyPersonalInfoActivity.class);
                intent.putExtra("mode", 2);
                intent.putExtra(az.at, PersonalInfoActivity.this.u);
                intent.putExtra("info", PersonalInfoActivity.this.s.getNickName());
                intent.putExtra("info_2", PersonalInfoActivity.this.s.getIconURL());
                PersonalInfoActivity.this.startActivityForResult(intent, 40);
            }
            if (AppContext.getContext().getTrayPreferences().a("key_show_account_notification", false)) {
                AppContext.getContext().getTrayPreferences().i("key_show_account_notification", false);
                PersonalInfoActivity.this.z.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) QRCodeActivity.class);
            intent.putExtra("code", str);
            PersonalInfoActivity.this.startActivity(intent);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.QRCodeScan.a.c(new a.e() { // from class: mh4
                @Override // com.zenmen.palmchat.QRCodeScan.a.e
                public final void a(String str) {
                    this.f19218a.b(str);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoActivity.this.startActivityForResult(new Intent(PersonalInfoActivity.this, (Class<?>) AddressInfoActivity.class), 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put(az.at, PersonalInfoActivity.this.u);
            put("type", 4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15221a;

        public e(String str) {
            this.f15221a = str;
            put("action", "mend_portrait");
            put("status", "failed");
            put("detail", "portraitUrl is invalide" + str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put(az.at, PersonalInfoActivity.this.u);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<String> {
        public g() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            PersonalInfoActivity.this.hideBaseProgressBar();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("resultCode") == 0) {
                    Log.i(BaseActionBarActivity.TAG, jSONObject.toString());
                    iq5.j(false, new String[0]);
                    if (PersonalInfoActivity.this.U) {
                        ds0.a().b(new i00());
                        sy5.e(AppContext.getContext(), R.string.settings_able_upload, 0).g();
                    } else {
                        sy5.e(AppContext.getContext(), R.string.send_success, 0).g();
                    }
                } else if (PersonalInfoActivity.this.U) {
                    PersonalInfoActivity.this.showRequestFailDialog(yy2.a(jSONObject), PersonalInfoActivity.this.getString(R.string.settings_unable_upload));
                } else {
                    PersonalInfoActivity.this.showRequestFailDialog(yy2.a(jSONObject), PersonalInfoActivity.this.getString(R.string.send_failed));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (PersonalInfoActivity.this.U) {
                    sy5.e(AppContext.getContext(), R.string.settings_unable_upload, 0).g();
                } else {
                    sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PersonalInfoActivity.this.hideBaseProgressBar();
            if (!hx3.m(PersonalInfoActivity.this)) {
                sy5.e(PersonalInfoActivity.this, R.string.net_status_unavailable, 1).g();
            } else if (PersonalInfoActivity.this.U) {
                sy5.e(AppContext.getContext(), R.string.settings_unable_upload, 0).g();
            } else {
                sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("from", Integer.valueOf(PersonalInfoActivity.this.q));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends HashMap<String, Object> {
        public j() {
            put("from", IMediaFormat.KEY_PROFILE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalInfoActivity.this.s = bo0.r().l(PersonalInfoActivity.this.t);
            if (PersonalInfoActivity.this.s != null) {
                y63.u(PersonalInfoActivity.this.s.getBigIconURL(), PersonalInfoActivity.this.s.getIconURL());
                PersonalInfoActivity.this.u2();
                PersonalInfoActivity.this.Y1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            rk4.d(PersonalInfoActivity.this, 2, null, 1, -1, -1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m66.f();
            Bundle bundle = new Bundle();
            bundle.putInt("from", 1);
            PortraitAlbumActivity.f2(PersonalInfoActivity.this, bundle);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalInfoActivity.this.s == null || TextUtils.isEmpty(PersonalInfoActivity.this.s.getBigIconURL()) || TextUtils.isEmpty(PersonalInfoActivity.this.s.getIconURL())) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(PersonalInfoActivity.this, PhotoViewActivity.class);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            MediaItem mediaItem = new MediaItem();
            mediaItem.thumbnailPath = PersonalInfoActivity.this.s.getIconURL();
            mediaItem.fileFullPath = PersonalInfoActivity.this.s.getBigIconURL();
            arrayList.add(mediaItem);
            intent.putParcelableArrayListExtra("mediaList", arrayList);
            intent.putExtra("selectIndex", 0);
            intent.putExtra("from_portrait", true);
            intent.putExtra("from_personal_info", true);
            intent.putExtra("from_user_portrait", true);
            intent.putExtra("show_mode", 0);
            PersonalInfoActivity.this.startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoActivity.this.r2(13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        r2(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        r2(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        r2(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(View view) {
        r2(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        r2(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        r2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        r2(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        r2(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        r2(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(View view) {
        r2(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(View view) {
        r2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(View view) {
        r2(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(View view) {
        r2(9);
    }

    public final void Y1() {
        ft5.b(1, new k());
    }

    public String Z1(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? "" : strArr[0];
    }

    public final void a2() {
        this.S = new g();
        this.T = new h();
    }

    public final void b2() {
        this.M = findViewById(R.id.portrait_area);
        this.w = (TextView) findViewById(R.id.nickname_textview);
        this.x = (TextView) findViewById(R.id.account_textview);
        this.y = (TextView) findViewById(R.id.phone_textview);
        this.z = (ImageView) findViewById(R.id.account_notification_image);
        this.A = (TextView) findViewById(R.id.gender_textview);
        this.B = (TextView) findViewById(R.id.district_textview);
        this.C = (TextView) findViewById(R.id.signature_textview);
        this.H = (LXPortraitView) findViewById(R.id.portrait);
        this.I = (TextView) findViewById(R.id.portrait_tips);
        this.J = (ImageView) findViewById(R.id.account_arrow);
        this.K = findViewById(R.id.nickname_area);
        this.L = findViewById(R.id.account_area);
        this.h0 = findViewById(R.id.signature_area);
        this.N = findViewById(R.id.qrcode_area);
        this.O = findViewById(R.id.gender_area);
        this.P = findViewById(R.id.address_area);
        this.i0 = findViewById(R.id.interests_area);
        this.E = (TextView) findViewById(R.id.hobby_textview);
        this.G = (TextView) findViewById(R.id.mall_label);
        if (rw0.b()) {
            this.G.setText("个性商城");
        } else {
            this.G.setText("挂件商城");
        }
        this.o0 = (LinearLayout) findViewById(R.id.people_match_photos_layout);
        this.F = (TextView) findViewById(R.id.empty_photo_tips);
        this.Q = findViewById(R.id.amuletStoreLayout);
        if (rk4.e()) {
            this.Q.setVisibility(0);
        } else {
            this.Q.setVisibility(8);
        }
        this.Q.setOnClickListener(new m());
        if (AppContext.getContext().getTrayPreferences().a("key_show_account_notification", false)) {
            this.z.setVisibility(0);
        }
        m66.f();
        this.I.setVisibility(0);
        this.I.setText(m66.a());
        this.M.setOnClickListener(new n());
        this.H.setOnClickListener(new o());
        this.K.setOnClickListener(new p());
        this.L.setOnClickListener(new a());
        this.h0.setOnClickListener(new View.OnClickListener() { // from class: zg4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22408a.d2(view);
            }
        });
        CommonInfoCellView commonInfoCellView = (CommonInfoCellView) findViewById(R.id.birthCellView);
        this.Y = commonInfoCellView;
        commonInfoCellView.setClickListener(new View.OnClickListener() { // from class: gh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17725a.e2(view);
            }
        });
        this.N.setOnClickListener(new b());
        this.P.setOnClickListener(new c());
        this.O.setOnClickListener(new View.OnClickListener() { // from class: hh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17957a.i2(view);
            }
        });
        this.i0.setOnClickListener(new View.OnClickListener() { // from class: ih4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18167a.j2(view);
            }
        });
        CommonInfoCellView commonInfoCellView2 = (CommonInfoCellView) findViewById(R.id.occupation);
        this.Z = commonInfoCellView2;
        commonInfoCellView2.setClickListener(new View.OnClickListener() { // from class: jh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18404a.k2(view);
            }
        });
        CommonInfoCellView commonInfoCellView3 = (CommonInfoCellView) findViewById(R.id.income);
        this.e0 = commonInfoCellView3;
        commonInfoCellView3.setClickListener(new View.OnClickListener() { // from class: kh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18689a.l2(view);
            }
        });
        CommonInfoCellView commonInfoCellView4 = (CommonInfoCellView) findViewById(R.id.friendPrefer);
        this.g0 = commonInfoCellView4;
        commonInfoCellView4.setClickListener(new View.OnClickListener() { // from class: lh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18981a.m2(view);
            }
        });
        CommonInfoCellView commonInfoCellView5 = (CommonInfoCellView) findViewById(R.id.homeCellView);
        this.f0 = commonInfoCellView5;
        commonInfoCellView5.setClickListener(new View.OnClickListener() { // from class: ah4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1229a.n2(view);
            }
        });
        CommonInfoCellView commonInfoCellView6 = (CommonInfoCellView) findViewById(R.id.personalityCharacteristics);
        this.j0 = commonInfoCellView6;
        commonInfoCellView6.setClickListener(new View.OnClickListener() { // from class: bh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1718a.o2(view);
            }
        });
        CommonInfoCellView commonInfoCellView7 = (CommonInfoCellView) findViewById(R.id.likePersonalityCharacteristics);
        this.k0 = commonInfoCellView7;
        commonInfoCellView7.setClickListener(new View.OnClickListener() { // from class: ch4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1990a.p2(view);
            }
        });
        CommonInfoCellView commonInfoCellView8 = (CommonInfoCellView) findViewById(R.id.myPreferences);
        this.l0 = commonInfoCellView8;
        commonInfoCellView8.setClickListener(new View.OnClickListener() { // from class: dh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17051a.f2(view);
            }
        });
        CommonInfoCellView commonInfoCellView9 = (CommonInfoCellView) findViewById(R.id.house);
        this.m0 = commonInfoCellView9;
        commonInfoCellView9.setClickListener(new View.OnClickListener() { // from class: eh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17301a.g2(view);
            }
        });
        CommonInfoCellView commonInfoCellView10 = (CommonInfoCellView) findViewById(R.id.car);
        this.n0 = commonInfoCellView10;
        commonInfoCellView10.setClickListener(new View.OnClickListener() { // from class: fh4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17530a.h2(view);
            }
        });
    }

    public final void c2(int i2) {
        int i3;
        ContactInfoItem contactInfoItem;
        Intent intent = new Intent(this, (Class<?>) ModifyPersonalInfoActivity.class);
        if (i2 == 0) {
            intent.putExtra("mode", 0);
            i3 = 20;
        } else if (i2 == 1) {
            intent.putExtra("mode", 1);
            i3 = 30;
        } else if (i2 == 2 && (contactInfoItem = this.s) != null && TextUtils.isEmpty(contactInfoItem.getAccount())) {
            intent.putExtra("info", this.s.getNickName());
            intent.putExtra("info_2", this.s.getIconURL());
            intent.putExtra("mode", 2);
            i3 = 40;
        } else {
            if (i2 != 3) {
                return;
            }
            intent.putExtra("mode", 3);
            i3 = 50;
        }
        intent.putExtra(az.at, this.u);
        startActivityForResult(intent, i3);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 108;
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_personal_info_title);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            this.U = true;
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (!k86.I(stringExtra)) {
                LogUtil.i(BaseActionBarActivity.TAG, 3, new e(stringExtra), (Throwable) intent.getSerializableExtra("media_pick_photo_key_error"));
                return;
            }
            dq3 dq3Var = this.W;
            if (dq3Var != null) {
                dq3Var.onCancel();
            }
            this.W = new dq3(this.S, this.T, stringExtra, false);
            showBaseProgressBar(getString(R.string.settings_uploading), false);
            try {
                this.W.n();
            } catch (DaoException e2) {
                e2.printStackTrace();
                hideBaseProgressBar();
                sy5.e(AppContext.getContext(), R.string.settings_unable_upload, 0).g();
            } catch (JSONException e3) {
                e3.printStackTrace();
                hideBaseProgressBar();
                sy5.e(AppContext.getContext(), R.string.settings_unable_upload, 0).g();
            }
            LogUtil.uploadInfoImmediate("97003", new d());
            return;
        }
        if (i2 == 2 && i3 == -1) {
            return;
        }
        if (i2 == 20 && i3 == -1) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("info");
                if (TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                this.w.setText(stringExtra2);
                return;
            }
            return;
        }
        if (i2 == 30 && i3 == -1) {
            if (intent != null) {
                String stringExtra3 = intent.getStringExtra("info");
                if (TextUtils.isEmpty(stringExtra3)) {
                    this.C.setText("");
                    return;
                } else {
                    this.C.setText(stringExtra3);
                    return;
                }
            }
            return;
        }
        if (i2 == 40 && i3 == -1) {
            if (intent != null) {
                String stringExtra4 = intent.getStringExtra("info");
                if (TextUtils.isEmpty(stringExtra4)) {
                    this.x.setText("");
                    return;
                }
                this.s.setAccount(stringExtra4);
                this.x.setText(stringExtra4);
                this.J.setVisibility(8);
                return;
            }
            return;
        }
        if (i2 == 50 && i3 == -1 && intent != null) {
            String stringExtra5 = intent.getStringExtra("info");
            if (TextUtils.isEmpty(stringExtra5)) {
                this.E.setText("");
            } else {
                this.E.setText(stringExtra5);
            }
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new l());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.q = intent.getIntExtra("extra_from", 10);
            this.u = intent.getStringExtra("extra_source");
            this.v = intent.getIntExtra("extra_type", -1);
            if (TextUtils.isEmpty(this.u)) {
                this.u = MapController.DEFAULT_LAYER_TAG;
            }
        }
        setContentView(R.layout.layout_activity_personal_info);
        this.t = AccountUtils.p(AppContext.getContext());
        this.R = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        initActionBar();
        b2();
        a2();
        Y1();
        bo0.r().i().j(this);
        s2();
        LogUtil.uploadInfoImmediate("97001", new f());
        zn6.j("profileInfor_pageshow", "view", new i());
        zn6.j("newpageprofi_edit", "view", new j());
        int i2 = this.v;
        if (i2 >= 0) {
            c2(i2);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cq3 cq3Var = this.V;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
        dq3 dq3Var = this.W;
        if (dq3Var != null) {
            dq3Var.onCancel();
        }
        gq3 gq3Var = this.X;
        if (gq3Var != null) {
            gq3Var.onCancel();
        }
        bo0.r().i().l(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void q2(String str, String str2, String str3) {
        this.B.setText(il5.j(this, str, str2, str3, false));
    }

    public final void r2(int i2) {
        b05.d("跳转到webview" + i2);
        fq3.a(this, i2, 6);
    }

    public final void s2() {
        this.s = bo0.r().l(this.t);
        u2();
        r92 r92Var = new r92();
        this.r = r92Var;
        r92Var.n();
    }

    public final void t2(TaskTipBean taskTipBean) {
        View viewFindViewById = findViewById(R.id.baseProfileGuideLayout);
        TextView textView = (TextView) findViewById(R.id.baseProfileGuideTv);
        View viewFindViewById2 = findViewById(R.id.more_info_task);
        TextView textView2 = (TextView) findViewById(R.id.more_info_task_text);
        if (!q42.a() || taskTipBean == null) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            return;
        }
        if (il5.l(taskTipBean.basicDataTip)) {
            viewFindViewById.setVisibility(8);
        } else {
            if (8 == viewFindViewById.getVisibility()) {
                zn6.b("ProfileBubble_show");
            }
            viewFindViewById.setVisibility(0);
            textView.setText(taskTipBean.basicDataTip);
        }
        if (il5.l(taskTipBean.interestTip)) {
            viewFindViewById2.setVisibility(8);
            return;
        }
        if (8 == viewFindViewById2.getVisibility()) {
            zn6.b("InterestBubble_show");
        }
        viewFindViewById2.setVisibility(0);
        textView2.setText(taskTipBean.interestTip);
    }

    public final void u2() {
        ContactInfoItem contactInfoItem = this.s;
        if (contactInfoItem == null) {
            return;
        }
        if (!TextUtils.isEmpty(contactInfoItem.getNickName())) {
            this.w.setText(this.s.getNickName());
        }
        this.y.setText(k86.O(AccountUtils.k(AppContext.getContext())));
        if (TextUtils.isEmpty(this.s.getAccount())) {
            this.x.setText("");
        } else {
            this.x.setText(this.s.getAccount());
            this.J.setVisibility(8);
        }
        if (this.s.getGender() == 1) {
            this.A.setText(getText(R.string.string_female));
        } else if (this.s.getGender() == 0) {
            this.A.setText(getText(R.string.string_male));
        } else {
            this.A.setText("");
        }
        String str = null;
        if (TextUtils.isEmpty(this.s.getBirthday())) {
            this.Y.update(null, com.zenmen.palmchat.settings.b.c().d(32));
        } else {
            this.Y.update(this.s.getBirthday().replaceAll("-", "/"), false);
        }
        if (TextUtils.isEmpty(this.s.getSignature())) {
            this.C.setText("");
        } else {
            this.C.setText(this.s.getSignature());
        }
        if (TextUtils.isEmpty(this.s.getHobby())) {
            this.E.setText("");
        } else {
            this.E.setText(this.s.getHobby());
        }
        q2(this.s.getCountry(), this.s.getProvince(), this.s.getCity());
        if (!TextUtils.isEmpty(this.s.getIconURL())) {
            this.H.setAvatarView(this.s.getIconURL(), this.s.getAmulet());
        }
        this.Z.update(this.s.getOccupationForShow(), com.zenmen.palmchat.settings.b.c().d(4));
        this.e0.update(this.s.getIncomeForShow(), com.zenmen.palmchat.settings.b.c().d(8));
        String[] intentionForShow = this.s.getIntentionForShow();
        CommonInfoCellView commonInfoCellView = this.g0;
        if (intentionForShow != null && intentionForShow.length > 0) {
            str = intentionForShow[0];
        }
        commonInfoCellView.update(str, com.zenmen.palmchat.settings.b.c().d(16));
        this.f0.update(TextUtils.isEmpty(this.s.getHomeTownForShow()) ? "" : this.s.getHomeTownForShow(), false);
        this.j0.update(Z1(this.s.getPersonalityForShow()), false);
        this.k0.update(Z1(this.s.getLikePersonalityForShow()), false);
        this.l0.update(Z1(this.s.getFondForShow()), false);
        this.m0.update(this.s.getRealestateForShow() != null ? TextUtils.isEmpty(this.s.getRealestateForShow()) ? "未购买" : this.s.getRealestateForShow() : "", false);
        this.n0.update(this.s.getStringHasCar(), false);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements ft5.b {
        public k() {
        }

        @Override // ft5.b
        public void a(TaskTipBean taskTipBean) {
            PersonalInfoActivity.this.t2(taskTipBean);
        }

        @Override // ft5.b
        public void onFail(Exception exc) {
        }
    }
}

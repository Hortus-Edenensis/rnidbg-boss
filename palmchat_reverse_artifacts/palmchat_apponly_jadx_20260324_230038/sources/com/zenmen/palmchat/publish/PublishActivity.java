package com.zenmen.palmchat.publish;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.az;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.publish.a;
import com.zenmen.palmchat.ui.widget.draggridview.DragGridView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.an1;
import defpackage.ds0;
import defpackage.ei4;
import defpackage.fi0;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.h13;
import defpackage.hr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.l50;
import defpackage.lf5;
import defpackage.me1;
import defpackage.n5;
import defpackage.rp2;
import defpackage.sd3;
import defpackage.sq3;
import defpackage.st1;
import defpackage.sy5;
import defpackage.tk3;
import defpackage.tq3;
import defpackage.v4;
import defpackage.vj6;
import defpackage.wt1;
import defpackage.xt;
import defpackage.zo4;
import defpackage.zq3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PublishActivity extends FrameworkBaseActivity implements DragGridView.f, zq3.f {
    public static final String t0 = "PublishActivity";
    public ImageView A;
    public TextView B;
    public ImageView C;
    public ImageView E;
    public View F;
    public int G;
    public Media N;
    public je1 R;
    public ArrayList<MediaItem> S;
    public View T;
    public ImageView U;
    public ImageView V;
    public int W;
    public DragGridView X;
    public com.zenmen.palmchat.publish.a Y;
    public PublishEmojiView Z;
    public String e0;
    public String f0;
    public String g0;
    public String h0;
    public String i0;
    public String j0;
    public String k0;
    public String l0;
    public String m0;
    public String n0;
    public String o0;
    public String p0;
    public TextView q;
    public String q0;
    public TextView r;
    public a.b r0;
    public EditText s;
    public String s0;
    public LinearLayout t;
    public ImageView u;
    public View v;
    public TextView z;
    public boolean w = false;
    public String x = null;
    public boolean y = false;
    public boolean H = false;
    public String I = null;
    public String J = "";
    public String K = "";
    public String L = "";
    public byte[] M = null;
    public View O = null;
    public ImageView P = null;
    public TextView Q = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublishActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MediaItem mediaItem;
            if (adapterView == null || adapterView.getAdapter() == null || (mediaItem = (MediaItem) adapterView.getAdapter().getItem(i)) == null) {
                return;
            }
            ArrayList<FeedBean> arrayListA = ei4.a(PublishActivity.this.S);
            if (mediaItem.mimeType == 10) {
                PublishActivity.this.R1(arrayListA);
                return;
            }
            PublishActivity publishActivity = PublishActivity.this;
            if (4 == publishActivity.G) {
                ei4.f(publishActivity, arrayListA, i);
            } else {
                ei4.g(publishActivity, arrayListA, i, 2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ei4.k(PublishActivity.this, ei4.a(PublishActivity.this.S), 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements a.b {
        public d() {
        }

        @Override // com.zenmen.palmchat.publish.a.b
        public void a(int i) {
            ArrayList<MediaItem> arrayList;
            if (PublishActivity.this.W == 2 || PublishActivity.this.W == 1) {
                PublishActivity publishActivity = PublishActivity.this;
                if (publishActivity.Z1(publishActivity.s.getText().toString()) || !((arrayList = PublishActivity.this.S) == null || arrayList.isEmpty())) {
                    PublishActivity.this.q.setEnabled(true);
                } else {
                    PublishActivity.this.q.setEnabled(false);
                }
                PublishActivity.this.h2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_feed");
            put("status", "send_start");
            put("type", Integer.valueOf(PublishActivity.this.W));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", "send_feed");
            put("status", "send_start");
            put("type", Integer.valueOf(PublishActivity.this.W));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("action", "send_feed");
            put("status", "send_start");
            put("type", Integer.valueOf(PublishActivity.this.W));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15042a;

        public h(String str) {
            this.f15042a = str;
            put("action", "publishImage");
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("action", "send_feed");
            put("status", "send_start");
            put("type", Integer.valueOf(PublishActivity.this.W));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PublishActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PublishActivity.this.hideBaseProgressBar();
            sy5.f(PublishActivity.this, "发布失败，请稍后再试", 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f15046a;

        public l(JSONObject jSONObject) {
            this.f15046a = jSONObject;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            LogUtil.uploadInfoImmediate("M253", "1", null, this.f15046a.toString());
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            PublishActivity.super.onBackPressed();
            if (6 == PublishActivity.this.G) {
                Intent intent = new Intent("com.zenmen.palmchat.openapi.Intent.ACTION_PUBLISH_MOMENT_STATUS");
                intent.putExtra("_lxapi_errorcode", 2);
                PublishActivity.this.sendBroadcast(intent);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fromwblx", 2);
                    jSONObject.put("appid", PublishActivity.this.I);
                    LogUtil.uploadInfoImmediate("wblx_F", null, null, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
            LogUtil.uploadInfoImmediate("M252", "1", null, this.f15046a.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublishActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, PublishActivity.this.G);
            } catch (JSONException unused) {
            }
            LogUtil.uploadInfoImmediate("M254", "1", null, jSONObject.toString());
            if (PublishActivity.this.s.getText().toString().length() > 2000) {
                new sd3(PublishActivity.this).j(R$string.string_publish_text_overflow_dialog_content).O(R$string.string_publish_text_overflow_dialog_positive).f(new a()).e().show();
                LogUtil.uploadInfoImmediate("M255", null, null, jSONObject.toString());
                return;
            }
            PublishActivity.this.showBaseProgressBar();
            int i = 2;
            if (PublishActivity.this.W == 2) {
                ArrayList<MediaItem> arrayList = PublishActivity.this.S;
                if (arrayList == null || arrayList.isEmpty()) {
                    PublishActivity.this.W = 1;
                    PublishActivity publishActivity = PublishActivity.this;
                    publishActivity.d2(publishActivity.s.getText().toString(), PublishActivity.this.G);
                } else {
                    PublishActivity.this.W = 2;
                    PublishActivity publishActivity2 = PublishActivity.this;
                    publishActivity2.b2(publishActivity2.G);
                }
            } else if (PublishActivity.this.W == 1) {
                PublishActivity publishActivity3 = PublishActivity.this;
                publishActivity3.d2(publishActivity3.s.getText().toString(), PublishActivity.this.G);
            } else if (PublishActivity.this.W == 4) {
                PublishActivity publishActivity4 = PublishActivity.this;
                publishActivity4.f2(publishActivity4.s.getText().toString(), PublishActivity.this.G);
            } else if (PublishActivity.this.W == 3) {
                PublishActivity publishActivity5 = PublishActivity.this;
                publishActivity5.e2(publishActivity5.G);
            } else if (PublishActivity.this.W == 6) {
                PublishActivity publishActivity6 = PublishActivity.this;
                publishActivity6.c2(publishActivity6.s.getText().toString(), PublishActivity.this.G);
            } else if (PublishActivity.this.W == 7) {
                PublishActivity publishActivity7 = PublishActivity.this;
                publishActivity7.g2(publishActivity7.s.getText().toString(), PublishActivity.this.G);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                int i2 = PublishActivity.this.G;
                if (i2 == 12 || i2 == 11 || i2 == 13 || i2 == 14) {
                    i2 = 1;
                }
                if (i2 != 22 && i2 != 21) {
                    i = i2;
                }
                jSONObject2.put(az.at, i);
                LogUtil.uploadInfoImmediate("M23", "1", null, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (6 == PublishActivity.this.G) {
                Intent intent = new Intent("com.zenmen.palmchat.openapi.Intent.ACTION_PUBLISH_MOMENT_STATUS");
                intent.putExtra("_lxapi_errorcode", 0);
                PublishActivity.this.sendBroadcast(intent);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("fromwblx", 1);
                    jSONObject3.put("appid", PublishActivity.this.I);
                    LogUtil.uploadInfoImmediate("wblx_S", null, null, jSONObject3.toString());
                } catch (JSONException unused2) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublishActivity.this.v.setVisibility(8);
            PublishActivity.this.i2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PublishActivity.this.N == null) {
                rp2.a aVar = new rp2.a();
                aVar.l(PublishActivity.this.K);
                aVar.g(-1);
                aVar.k(true);
                aVar.i(h13.n);
                PublishActivity.this.startActivity(vj6.a(PublishActivity.this, aVar));
                return;
            }
            int i = PublishActivity.this.N.subType;
            if (i == 1) {
                PublishActivity publishActivity = PublishActivity.this;
                lf5.e(publishActivity, null, i, publishActivity.N.wid, null);
                return;
            }
            if (i == 3) {
                lf5.e(PublishActivity.this, null, i, null, null);
                return;
            }
            if (i == 2) {
                PublishActivity publishActivity2 = PublishActivity.this;
                lf5.e(publishActivity2, null, i, publishActivity2.N.wineTopicId, null);
            } else if (i == 4) {
                PublishActivity publishActivity3 = PublishActivity.this;
                lf5.f(publishActivity3, null, i, publishActivity3.N.poiId, PublishActivity.this.N.adCode, PublishActivity.this.N.cityCode, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublishActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public s() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PublishActivity.this.y = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15055a;

        public t(TextView textView) {
            this.f15055a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15055a.setVisibility(8);
        }
    }

    public PublishActivity() {
        je1.a aVarW = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY);
        int i2 = R$drawable.ic_default_link;
        this.R = aVarW.B(i2).z(i2).A(i2).r();
        this.S = new ArrayList<>();
        this.W = 1;
        this.e0 = "";
        this.f0 = "";
        this.g0 = "";
        this.h0 = "";
        this.i0 = "";
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = "";
        this.n0 = "";
        this.r0 = new d();
        this.s0 = null;
    }

    public static int[] U1(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public void R1(ArrayList<FeedBean> arrayList) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MOMENT_PUBLISH_STORAGE);
    }

    public final void S1() {
        zo4.b(this);
        int i2 = this.G;
        if (4 == i2) {
            ds0.a().b(new fi0(1));
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "momentsTitle");
            aVar.b(bundle);
            startActivity(n5.b(this, aVar));
            finish();
        } else if (6 == i2) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fromType", 4);
            bundle2.putBoolean("key_back_to_discover", true);
            bundle2.putInt("moment_from", -1);
            n5.f(this, bundle2);
            super.finish();
        } else if (5 == i2) {
            String stringExtra = getIntent().getStringExtra("key_extra_info");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", stringExtra);
                jSONObject.put("from", 2);
                LogUtil.uploadInfoImmediate("621", null, null, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            W1();
            new Handler().postDelayed(new j(), 100L);
        } else {
            W1();
            finish();
        }
        MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
        momentsDetailEvent.eventType = 0;
        an1.c().l(momentsDetailEvent);
    }

    public final boolean T1() {
        return com.zenmen.palmchat.c.e().a(k86.a("sp_mements_drag_show"), true);
    }

    public final boolean V1() {
        int i2;
        ArrayList<MediaItem> arrayList;
        return Y1(this.s.getText()) || !(this.W != 2 || (arrayList = this.S) == null || arrayList.isEmpty()) || (i2 = this.W) == 3 || i2 == 4;
    }

    public void W1() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.s.getWindowToken(), 2);
    }

    public final void X1() {
        this.s = (EditText) findViewById(R$id.edt_publish_text);
        PublishEmojiView publishEmojiView = (PublishEmojiView) findViewById(R$id.emojiView);
        this.Z = publishEmojiView;
        publishEmojiView.setInputBox(this.s);
        if (this.W == 1) {
            this.s.setText(zo4.a(this));
            if (Z1(zo4.a(this))) {
                this.q.setEnabled(true);
            } else {
                this.q.setEnabled(false);
            }
        }
        EditText editText = this.s;
        editText.setSelection(editText.getText().length());
        this.s.addTextChangedListener(new n());
        this.q.setOnClickListener(new o());
        this.v = findViewById(R$id.img_drag_hints);
        ImageView imageView = (ImageView) findViewById(R$id.cancel_img_hint_icon);
        this.u = imageView;
        imageView.setOnClickListener(new p());
        this.O = findViewById(R$id.publish_link_container);
        this.P = (ImageView) findViewById(R$id.publish_link_icon);
        this.Q = (TextView) findViewById(R$id.publish_link_title);
        this.O.setOnClickListener(new q());
        if (this.W == 4) {
            this.O.setVisibility(0);
            this.Q.setText(this.J);
            if (TextUtils.isEmpty(this.L)) {
                byte[] bArr = this.M;
                if (bArr != null) {
                    this.P.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
            } else {
                gr2.j().h(k86.p(this.L), this.P, this.R);
            }
        } else {
            this.O.setVisibility(8);
        }
        View viewFindViewById = findViewById(R$id.smallvideo_container);
        View viewFindViewById2 = findViewById(R$id.webapp_container);
        int i2 = this.W;
        if (i2 == 6) {
            viewFindViewById.setVisibility(0);
            View viewFindViewById3 = findViewById(R$id.small_video_layout);
            View viewFindViewById4 = findViewById(R$id.small_video_layot_new);
            viewFindViewById3.setVisibility(0);
            viewFindViewById4.setVisibility(8);
            this.E = (ImageView) findViewById(R$id.smallvideo_cover);
            this.B = (TextView) findViewById(R$id.wine_title);
            this.A = (ImageView) findViewById(R$id.wine_head);
            this.z = (TextView) findViewById(R$id.wine_name);
            this.C = (ImageView) findViewById(R$id.source_icon);
            this.F = findViewById(R$id.item_smallvideo_field);
            gr2.j().h(this.j0, this.E, hr2.j());
            this.B.setText(this.J);
            this.z.setText(this.h0);
            gr2.j().h(this.i0, this.A, hr2.i());
            gr2.j().h(lf5.c(), this.C, hr2.i());
            this.F.setOnClickListener(new r());
            ((CheckBox) findViewById(R$id.update_comment_checkbox)).setOnCheckedChangeListener(new s());
            TextView textView = (TextView) findViewById(R$id.update_comment_tips);
            boolean zA = com.zenmen.palmchat.c.e().a(k86.a("sp_moment_update_comments_to_smallvideo"), false);
            LogUtil.d(t0, "hasShowTips = " + zA);
            if (zA) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.postDelayed(new t(textView), 3000L);
                com.zenmen.palmchat.c.e().i(k86.a("sp_moment_update_comments_to_smallvideo"), true);
            }
        } else if (i2 == 7) {
            viewFindViewById2.setVisibility(0);
            View viewFindViewById5 = findViewById(R$id.web_app_layout);
            View viewFindViewById6 = findViewById(R$id.web_app_layout_new);
            viewFindViewById5.setVisibility(0);
            viewFindViewById6.setVisibility(8);
            this.E = (ImageView) viewFindViewById5.findViewById(R$id.smallvideo_cover);
            this.B = (TextView) viewFindViewById5.findViewById(R$id.wine_title);
            this.A = (ImageView) viewFindViewById5.findViewById(R$id.wine_head);
            this.z = (TextView) viewFindViewById5.findViewById(R$id.wine_name);
            this.F = viewFindViewById5.findViewById(R$id.item_smallvideo_field);
            gr2.j().h(this.L, this.E, hr2.m());
            this.B.setText(this.J);
            this.z.setText(this.h0);
            gr2.j().h(this.i0, this.A, hr2.i());
            this.F.setOnClickListener(new a());
        } else {
            viewFindViewById.setVisibility(8);
        }
        this.t = (LinearLayout) findViewById(R$id.lyt_pic);
        DragGridView dragGridView = (DragGridView) findViewById(R$id.gridview);
        this.X = dragGridView;
        dragGridView.setOnItemClickListener(new b());
        if (this.W == 2) {
            this.t.setVisibility(0);
            com.zenmen.palmchat.publish.a aVar = new com.zenmen.palmchat.publish.a(this, this.S);
            this.Y = aVar;
            aVar.h(this.r0);
            if (this.G == 4) {
                this.X.setDrag(false);
                this.Y.g();
                this.v.setVisibility(8);
            } else {
                h2();
            }
            this.X.setAdapter((ListAdapter) this.Y);
            this.X.setImgMoveListener(this);
        } else {
            this.t.setVisibility(8);
        }
        this.T = findViewById(R$id.publish_video_container);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R$id.publish_video_cover);
        effectiveShapeView.changeShapeType(3);
        effectiveShapeView.setDegreeForRoundRectangle(me1.a(com.zenmen.palmchat.c.b(), 7.0f), me1.a(com.zenmen.palmchat.c.b(), 7.0f));
        this.U = effectiveShapeView;
        this.V = (ImageView) findViewById(R$id.publish_video_play);
        this.U.setOnClickListener(new c());
        if (this.W == 3) {
            this.T.setVisibility(0);
            ArrayList<MediaItem> arrayList = this.S;
            if (arrayList != null && !arrayList.isEmpty()) {
                gr2.j().h(k86.p(this.S.get(0).localThumbPath), this.U, hr2.i());
            }
        } else {
            this.T.setVisibility(8);
        }
        if (this.W == 1) {
            this.s.setText(this.e0);
        }
        if (this.G == 6 && this.w) {
            sy5.f(this, getResources().getString(R$string.publish_change_scence_toast), 0).g();
        }
    }

    public final boolean Y1(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = charSequence.charAt(i3);
                if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n') {
                    i2++;
                }
            }
            if (i2 < length) {
                return true;
            }
        }
        return false;
    }

    public final boolean Z1(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n') {
                    i2++;
                }
            }
            if (i2 < length) {
                return true;
            }
        }
        return false;
    }

    public final void a2() {
        Intent intent = getIntent();
        if (intent != null) {
            this.G = intent.getIntExtra("key_from", 0);
            this.I = intent.getStringExtra("sdk_share_appid");
            int i2 = this.G;
            if (i2 == 3 || i2 == 4) {
                LogUtil.onImmediateClickEvent("M224", "1", null);
            }
            this.W = intent.getIntExtra("key_publish_type", 2);
            this.w = intent.getBooleanExtra("key_change_scence", false);
            this.x = intent.getStringExtra("key_source");
            this.o0 = intent.getStringExtra("key_publish_author_name");
            this.p0 = intent.getStringExtra("key_publish_app_name");
            int i3 = this.W;
            if (i3 == 2) {
                ArrayList<MediaItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_publish_pictures");
                this.S = parcelableArrayListExtra;
                if (parcelableArrayListExtra != null) {
                    for (MediaItem mediaItem : parcelableArrayListExtra) {
                        String str = mediaItem.editedImagePath;
                        if (str != null) {
                            mediaItem.fileFullPath = str;
                        }
                    }
                }
                ArrayList<MediaItem> arrayList = this.S;
                if (arrayList == null || arrayList.isEmpty()) {
                    this.H = true;
                    if (Z1(zo4.a(this))) {
                        this.q.setEnabled(true);
                        return;
                    } else {
                        this.q.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i3 == 3) {
                ArrayList<MediaItem> parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("key_publish_videos");
                this.S = parcelableArrayListExtra2;
                if (parcelableArrayListExtra2 == null || parcelableArrayListExtra2.isEmpty()) {
                    this.W = 1;
                    if (Z1(zo4.a(this))) {
                        this.q.setEnabled(true);
                        return;
                    } else {
                        this.q.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i3 == 4) {
                this.J = intent.getStringExtra("key_publish_subject");
                this.K = intent.getStringExtra("key_publish_url");
                this.L = intent.getStringExtra("key_publish_shortcut_icon");
                this.M = intent.getByteArrayExtra("key_publish_shortcut_icon_data");
                Media media = (Media) intent.getParcelableExtra("key_publish_share_media");
                this.N = media;
                if (media != null) {
                    this.J = media.title;
                    this.K = media.url;
                    this.L = media.thumbUrl;
                }
                String str2 = t0;
                Log.i(str2, "mWebLinkSubject:" + this.J);
                Log.i(str2, "mWebLinkUrl :" + this.K);
                Log.i(str2, "mWebLinkIconUrl :" + this.L);
                Log.i(str2, "mMomentType :" + this.W);
                return;
            }
            if (i3 != 6) {
                if (i3 != 7) {
                    this.e0 = intent.getStringExtra("key_publish_text");
                    return;
                }
                this.J = intent.getStringExtra("key_publish_subject");
                this.K = intent.getStringExtra("key_publish_url");
                this.L = intent.getStringExtra("key_publish_shortcut_icon");
                this.q0 = intent.getStringExtra("key_publish_open_link");
                this.i0 = intent.getStringExtra("key_publish_wineHead");
                this.h0 = intent.getStringExtra("key_publish_wineName");
                return;
            }
            this.J = intent.getStringExtra("key_publish_subject");
            this.K = intent.getStringExtra("key_publish_url");
            this.L = intent.getStringExtra("key_publish_shortcut_icon");
            this.f0 = intent.getStringExtra("key_publish_wid");
            this.g0 = intent.getStringExtra("key_publish_wineFeedId");
            this.i0 = intent.getStringExtra("key_publish_wineHead");
            this.h0 = intent.getStringExtra("key_publish_wineName");
            this.j0 = intent.getStringExtra("key_publish_wineImageUrl");
            this.k0 = intent.getStringExtra("key_publish_videoUrl");
            this.l0 = intent.getStringExtra("key_publish_wineid");
            this.m0 = intent.getStringExtra("key_publish_mediaid");
            this.n0 = intent.getStringExtra("key_publish_sv_channelid");
            String str3 = t0;
            Log.i(str3, "mWebLinkSubject:" + this.J);
            Log.i(str3, "mWebLinkUrl :" + this.K);
            Log.i(str3, "mWebLinkIconUrl :" + this.L);
            Log.i(str3, "mMomentType :" + this.W);
            Log.i(str3, "wineImgUrl : " + this.j0);
            Log.i(str3, "wineVideoUrl : " + this.k0);
            Log.i(str3, "mWid :" + this.f0);
            Log.i(str3, "wineFeedId :" + this.g0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final void b2(int i2) {
        LogUtil.i(t0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new g(), (Throwable) null);
        ArrayList<String> arrayList = new ArrayList();
        boolean z = false;
        for (int i3 = 0; i3 < this.S.size(); i3++) {
            arrayList.add(this.S.get(i3).fileFullPath);
        }
        String string = this.s.getText().toString();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i4 = tq3.g;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            Media media = new Media();
            media.localPath = str;
            media.type = 0;
            int[] iArrU1 = U1(str);
            if (xt.r(str)) {
                media.width = Integer.toString(iArrU1[1]);
                media.height = Integer.toString(iArrU1[0]);
            } else {
                media.width = Integer.toString(iArrU1[0]);
                media.height = Integer.toString(iArrU1[1]);
            }
            arrayList2.add(media);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Media media2 = (Media) it.next();
            JSONObject jSONObject = new JSONObject();
            Iterator it2 = it;
            try {
                jSONObject.put("localPath", media2.localPath);
                jSONObject.put("width", media2.width);
                jSONObject.put("height", media2.height);
                if (TextUtils.isEmpty(media2.width) || TextUtils.isEmpty(media2.height)) {
                    z = true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
            it = it2;
        }
        if (z) {
            LogUtil.i(t0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new h(jSONArray.toString()), (Throwable) null);
        }
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), string, this.W, 0, i4, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, arrayList2);
        feed.setSource(source);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("clientId", feed.getClientId());
            jSONObject2.put("feedType", feed.getFeedType());
            jSONObject2.put(az.at, i2);
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject2.toString());
        zq3.l().p(feed, getApplicationContext(), this);
    }

    public void c2(String str, int i2) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i3 = tq3.g;
        ArrayList arrayList = new ArrayList();
        Media media = new Media();
        media.url = this.K;
        media.thumbUrl = this.L;
        media.title = this.J;
        media.wid = this.f0;
        media.wineFeedId = this.g0;
        media.midUrl = this.j0;
        media.videoUrl = this.k0;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", this.h0);
            jSONObject2.put("icon", this.i0);
            jSONObject.put(az.at, jSONObject2);
            media.extension = jSONObject.toString();
            LogUtil.d(t0, "publishSmallVideo extension = " + media.extension);
        } catch (JSONException unused) {
        }
        arrayList.add(media);
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.W, 0, i3, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, arrayList);
        feed.setSource(source);
        tq3.e().m(feed, true, true);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("clientId", feed.getClientId());
            jSONObject3.put("feedType", feed.getFeedType());
            jSONObject3.put(az.at, i2);
            jSONObject3.put("title", media.title);
            jSONObject3.put("wid", media.wid);
            jSONObject3.put("wineFeedId", media.wineFeedId);
        } catch (Exception unused2) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject3.toString());
        zq3.l().o(feed, getApplicationContext(), this);
    }

    public final void d2(String str, int i2) {
        LogUtil.i(t0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(), (Throwable) null);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i3 = tq3.g;
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.W, 0, i3, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, null);
        feed.setSource(source);
        tq3.e().m(feed, true, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientId", feed.getClientId());
            jSONObject.put("feedType", feed.getFeedType());
            jSONObject.put(az.at, i2);
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject.toString());
        zq3.l().o(feed, getApplicationContext(), this);
    }

    @Override // com.zenmen.palmchat.ui.widget.draggridview.DragGridView.f
    public void e0() {
        View view = this.v;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.v.setVisibility(8);
        i2();
    }

    public final void e2(int i2) {
        LogUtil.i(t0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new i(), (Throwable) null);
        String string = this.s.getText().toString();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i3 = tq3.g;
        ArrayList arrayList = new ArrayList();
        for (MediaItem mediaItem : this.S) {
            Media media = new Media();
            media.localPath = mediaItem.localPath;
            String str = mediaItem.localThumbPath;
            media.localThumbPath = str;
            media.type = 1;
            media.videoDuration = mediaItem.playLength;
            media.width = Integer.toString(U1(str)[0]);
            media.height = Integer.toString(U1(mediaItem.localThumbPath)[1]);
            arrayList.add(media);
            LogUtil.i(t0, "publishVideo localPath = " + media.localPath + ", thumbUrl = " + media.localThumbPath + ", type = " + media.type);
            i3 = i3;
        }
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), string, this.W, 0, i3, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, arrayList);
        feed.setSource(source);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientId", feed.getClientId());
            jSONObject.put("feedType", feed.getFeedType());
            jSONObject.put(az.at, i2);
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject.toString());
        zq3.l().q(feed, getApplicationContext(), this);
    }

    public final void f2(String str, int i2) {
        String str2;
        LogUtil.i(t0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new f(), (Throwable) null);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i3 = tq3.g;
        ArrayList arrayList = new ArrayList();
        Media media = this.N;
        if (media == null) {
            media = new Media();
            media.url = this.K;
            media.thumbUrl = this.L;
            media.title = this.J;
        }
        Media media2 = media;
        arrayList.add(media2);
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.W, 0, i3, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, arrayList);
        feed.setSource(source);
        tq3.e().m(feed, true, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientId", feed.getClientId());
            jSONObject.put("feedType", feed.getFeedType());
            jSONObject.put(az.at, i2);
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject.toString());
        if (this.G != 6 || (str2 = media2.thumbUrl) == null || str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            zq3.l().o(feed, getApplicationContext(), this);
        } else {
            zq3.l().r(feed, getApplicationContext(), this);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.G == 6) {
            startActivity(n5.b(this, null));
        }
        super.finish();
    }

    public void g2(String str, int i2) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        int i3 = tq3.g;
        ArrayList arrayList = new ArrayList();
        Media media = new Media();
        media.url = this.K;
        String str2 = this.L;
        media.thumbUrl = str2;
        media.title = this.J;
        media.midUrl = str2;
        media.openLink = this.q0;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", this.h0);
            jSONObject2.put("icon", this.i0);
            jSONObject.put(az.at, jSONObject2);
            media.extension = jSONObject.toString();
            LogUtil.d(t0, "publishSmallVideo extension = " + media.extension);
        } catch (JSONException unused) {
        }
        arrayList.add(media);
        long jP = sq3.o().p(strE) + 1;
        Feed.Source source = new Feed.Source();
        source.setAppName(this.p0);
        source.setName(this.o0);
        Feed feed = new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.W, 0, i3, null, Long.valueOf(jP), Integer.valueOf(wt1.f21791a), null, arrayList);
        feed.setSource(source);
        tq3.e().m(feed, true, true);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("clientId", feed.getClientId());
            jSONObject3.put("feedType", feed.getFeedType());
            jSONObject3.put(az.at, i2);
        } catch (Exception unused2) {
        }
        LogUtil.uploadInfoImmediate("M256", null, null, jSONObject3.toString());
        zq3.l().o(feed, getApplicationContext(), this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN;
    }

    public final void h2() {
        if (T1()) {
            com.zenmen.palmchat.publish.a aVar = this.Y;
            if (aVar == null) {
                View view = this.v;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.v != null) {
                if (aVar.getCount() > 2) {
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                }
            }
        }
    }

    public final void i2() {
        com.zenmen.palmchat.c.e().i(k86.a("sp_mements_drag_show"), false);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, "", true);
        TextView textView = (TextView) getToolbar().findViewById(R$id.action_button);
        this.q = textView;
        textView.setText(R$string.publish_activity_send);
        TextView textView2 = (TextView) getToolbar().findViewById(R$id.title);
        this.r = textView2;
        if (this.G == 4) {
            textView2.setText(R$string.publish_activity_title);
        } else {
            textView2.setText(R$string.publish_activity_title);
        }
        toolbarInitToolbar.setNavigationOnClickListener(new m());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        MediaItem mediaItem;
        ArrayList<MediaItem> arrayList;
        super.onActivityResult(i2, i3, intent);
        if ((i2 != 1 && i2 != 3) || i3 != -1 || intent == null) {
            if (i2 == 2 && i3 == -1 && intent != null) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_key_feeds");
                this.S.clear();
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    this.S.add(((FeedBean) it.next()).getMediaItem());
                }
                if (this.W == 2 && ((arrayList = this.S) == null || arrayList.isEmpty())) {
                    this.q.setEnabled(false);
                }
                com.zenmen.palmchat.publish.a aVar = new com.zenmen.palmchat.publish.a(this, this.S);
                this.Y = aVar;
                aVar.h(this.r0);
                this.X.setAdapter((ListAdapter) this.Y);
                h2();
                return;
            }
            return;
        }
        ArrayList<MediaItem> arrayList2 = new ArrayList();
        if (i2 == 1) {
            arrayList2 = intent.getParcelableArrayListExtra("select_picture");
            for (MediaItem mediaItem2 : arrayList2) {
                String str = mediaItem2.editedImagePath;
                if (str != null) {
                    mediaItem2.fileFullPath = str;
                }
            }
        } else if (i2 == 3 && (mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_RECORD_ITEM")) != null) {
            arrayList2.add(mediaItem);
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        this.S.addAll(arrayList2);
        if (((MediaItem) arrayList2.get(0)).mimeType == 1) {
            this.W = 3;
            this.T.setVisibility(0);
            this.V.setVisibility(0);
            ArrayList<MediaItem> arrayList3 = this.S;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                gr2.j().h(k86.p(this.S.get(0).localThumbPath), this.U, hr2.i());
            }
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
            com.zenmen.palmchat.publish.a aVar2 = new com.zenmen.palmchat.publish.a(this, this.S);
            this.Y = aVar2;
            aVar2.h(this.r0);
            this.X.setAdapter((ListAdapter) this.Y);
            h2();
            this.W = 2;
            this.T.setVisibility(8);
        }
        this.q.setEnabled(true);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, this.G);
        } catch (JSONException unused) {
        }
        LogUtil.uploadInfoImmediate("M251", "1", null, jSONObject.toString());
        if (V1()) {
            new sd3(this).j(R$string.string_publish_image_back_dialog_content).O(R$string.string_publish_back_dialog_positive).M(getResources().getColor(R$color.color_e6433e)).K(R$string.string_publish_back_dialog_negative).I(getResources().getColor(R$color.color_7e7e7e)).f(new l(jSONObject)).e().show();
            return;
        }
        super.onBackPressed();
        if (6 == this.G) {
            Intent intent = new Intent("com.zenmen.palmchat.openapi.Intent.ACTION_PUBLISH_MOMENT_STATUS");
            intent.putExtra("_lxapi_errorcode", 2);
            sendBroadcast(intent);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fromwblx", 2);
                jSONObject2.put("appid", this.I);
                LogUtil.uploadInfoImmediate("wblx_F", null, null, jSONObject2.toString());
            } catch (JSONException unused2) {
            }
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_publish_b);
        initActionBar();
        a2();
        X1();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, this.G);
            LogUtil.uploadInfoImmediate("M20", null, null, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_RECORD) {
            tk3.f(this, 1, 3, 3);
        } else if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            tk3.h(this, 9 - this.S.size(), !this.S.isEmpty() ? 1 : 0, 1, 3);
        }
    }

    @Override // zq3.f
    public void p() {
        runOnUiThread(new k());
    }

    @Override // zq3.f
    public void w0(Feed feed) {
        hideBaseProgressBar();
        st1.f().b();
        zo4.c(this, "");
        S1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements TextWatcher {
        public n() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ArrayList<MediaItem> arrayList;
            if (PublishActivity.this.W == 2) {
                if (PublishActivity.this.Z1(charSequence.toString()) || !((arrayList = PublishActivity.this.S) == null || arrayList.isEmpty())) {
                    PublishActivity.this.q.setEnabled(true);
                    return;
                } else {
                    PublishActivity.this.q.setEnabled(false);
                    return;
                }
            }
            if (PublishActivity.this.W == 1) {
                zo4.c(PublishActivity.this, charSequence.toString());
                if (PublishActivity.this.Z1(charSequence.toString())) {
                    PublishActivity.this.q.setEnabled(true);
                } else {
                    PublishActivity.this.q.setEnabled(false);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}

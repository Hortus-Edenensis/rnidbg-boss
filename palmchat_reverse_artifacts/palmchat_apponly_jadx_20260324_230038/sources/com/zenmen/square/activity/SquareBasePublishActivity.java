package com.zenmen.square.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.afollestad.materialdialogs.MaterialDialog;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.activity.a;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.widget.SquareTagSelectDialog;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.ui.widget.BottomShareView;
import com.zenmen.square.ui.widget.LocationSelectDialog;
import com.zenmen.square.ui.widget.TopicSelectDialog;
import defpackage.ai5;
import defpackage.ds0;
import defpackage.fk2;
import defpackage.gi5;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.i53;
import defpackage.je1;
import defpackage.jr2;
import defpackage.k36;
import defpackage.k86;
import defpackage.kj5;
import defpackage.l50;
import defpackage.lj5;
import defpackage.mj5;
import defpackage.n5;
import defpackage.n53;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.v4;
import defpackage.vi5;
import defpackage.vs0;
import defpackage.wt1;
import defpackage.xj5;
import defpackage.xt;
import defpackage.zk5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareBasePublishActivity extends FrameworkBaseActivity {
    public static final String k0 = "SquareBasePublishActivity";
    public String A;
    public LocationSelectDialog B;
    public SquareTagBean C;
    public TopicListBean.Topic E;
    public LocationEx J;
    public EditText L;
    public ViewGroup M;
    public BottomShareView N;
    public TextView O;
    public View P;
    public TextView Q;
    public ViewGroup R;
    public TextView S;
    public int X;
    public int e0;
    public int q;
    public boolean r;
    public int t;
    public SquareTagBean u;
    public TopicListBean.Topic v;
    public TopicListBean.Ae w;
    public LocationEx y;
    public int s = 1;
    public ArrayList<MediaItem> x = new ArrayList<>();
    public int z = 2;
    public boolean F = true;
    public boolean G = false;
    public boolean H = true;
    public boolean I = true;
    public boolean K = false;
    public boolean T = true;
    public int U = 0;
    public boolean V = false;
    public com.zenmen.square.activity.a W = new com.zenmen.square.activity.a(this);
    public Rect Y = new Rect();
    public boolean Z = false;
    public float f0 = 0.0f;
    public boolean g0 = true;
    public boolean h0 = false;
    public boolean i0 = false;
    public boolean j0 = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.d {
        public a() {
        }

        @Override // com.zenmen.square.activity.a.d
        public void a() {
            SquareBasePublishActivity.this.l2(false);
        }

        @Override // com.zenmen.square.activity.a.d
        public void b() {
            SquareBasePublishActivity.this.j2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) SquareBasePublishActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                SquareBasePublishActivity.this.L.requestFocus();
                inputMethodManager.showSoftInput(SquareBasePublishActivity.this.L, 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements SquareTagSelectDialog.c {
        public d() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectDialog.c
        public void a(SquareTagBean squareTagBean) {
            SquareBasePublishActivity squareBasePublishActivity = SquareBasePublishActivity.this;
            squareBasePublishActivity.C = squareTagBean;
            squareBasePublishActivity.F2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TopicSelectDialog.f {
        public e() {
        }

        @Override // com.zenmen.square.ui.widget.TopicSelectDialog.f
        public void a(TopicListBean.Topic topic) {
            SquareBasePublishActivity squareBasePublishActivity = SquareBasePublishActivity.this;
            squareBasePublishActivity.E = topic;
            squareBasePublishActivity.G2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16102a;

        public f(MaterialDialog materialDialog) {
            this.f16102a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16102a.dismiss();
            if (SquareBasePublishActivity.this.V) {
                zn6.c("pagemultipleedit_callback_accpet", "click");
            } else {
                zn6.c("pagephotoedit_callback_accpet", "click");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16103a;

        public g(MaterialDialog materialDialog) {
            this.f16103a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16103a.dismiss();
            SquareBasePublishActivity.super.onBackPressed();
            if (SquareBasePublishActivity.this.V) {
                zn6.c("pagemultipleedit_callback_cancel", "click");
            } else {
                zn6.c("pagephotoedit_callback_cancel", "click");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements LocationSelectDialog.h {
        public h() {
        }

        @Override // com.zenmen.square.ui.widget.LocationSelectDialog.h
        public void a(LocationSelectDialog.k kVar) {
            SquareBasePublishActivity squareBasePublishActivity = SquareBasePublishActivity.this;
            squareBasePublishActivity.y = kVar.f16538a;
            int i = kVar.b;
            squareBasePublishActivity.z = i;
            squareBasePublishActivity.E2(i);
            SquareBasePublishActivity.this.D2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements TextView.OnEditorActionListener {
        public i() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent != null && SquareBasePublishActivity.this.s2() && keyEvent.getKeyCode() == 66;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        public l() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SquareBasePublishActivity.this.X == 0) {
                SquareBasePublishActivity squareBasePublishActivity = SquareBasePublishActivity.this;
                squareBasePublishActivity.X = squareBasePublishActivity.b2();
            }
            Log.d(SquareBasePublishActivity.k0, "keyboard change isKeyboardShow():" + SquareBasePublishActivity.this.f2() + "isKeyboardShow:" + SquareBasePublishActivity.this.Z);
            if (SquareBasePublishActivity.this.f2() && !SquareBasePublishActivity.this.Z) {
                SquareBasePublishActivity.this.Z = true;
                SquareBasePublishActivity squareBasePublishActivity2 = SquareBasePublishActivity.this;
                squareBasePublishActivity2.i2(true, squareBasePublishActivity2.W1());
            }
            if (SquareBasePublishActivity.this.f2() || !SquareBasePublishActivity.this.Z) {
                return;
            }
            SquareBasePublishActivity.this.Z = false;
            SquareBasePublishActivity.this.i2(false, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareBasePublishActivity.this.l2(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareBasePublishActivity.this.j2();
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
            SquareBasePublishActivity.this.A2();
            if (SquareBasePublishActivity.this.V) {
                zn6.c("pagemultipleedit_editarea_tag", "click");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (SquareBasePublishActivity.this.V) {
                zn6.c("pagemultipleedit_editarea_talk", "click");
            } else {
                zn6.c("pagephotoedit_upleft_talktab", "click");
            }
            SquareBasePublishActivity.this.z2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                SquareBasePublishActivity.this.startActivity(intent);
                SquareBasePublishActivity.this.K = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends HashMap<String, Object> {
        public r() {
            put("photonum", Integer.valueOf(SquareBasePublishActivity.this.x.size()));
        }
    }

    public static int[] X1(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String Z1(Context context) {
        JSONObject config = vs0.a().getConfig("loginPage");
        String strOptString = config != null ? config.optString("pagePublishTagTitle") : null;
        return TextUtils.isEmpty(strOptString) ? context.getString(R$string.square_publish_tag_title) : strOptString;
    }

    public final void A2() {
        SquareTagSelectDialog squareTagSelectDialog = new SquareTagSelectDialog(this, !this.V);
        squareTagSelectDialog.q(new d());
        squareTagSelectDialog.r(this.C);
        squareTagSelectDialog.show();
    }

    public final void B2() {
        if (this.T) {
            this.i0 = true;
            com.zenmen.palmchat.location.d.g().k(LocationScene.PUBLISH_SQUARE, new j());
            E2(this.z);
        }
    }

    public final void C2(float f2) {
        Log.d(k0, "keyboard change translation animation:" + f2);
        this.N.animate().translationY(f2).setDuration(200L).start();
    }

    public void D2() {
        ArrayList<MediaItem> arrayList;
        boolean z = false;
        boolean z2 = this.C != null;
        if (!TextUtils.isEmpty(this.L.getText()) || ((arrayList = this.x) != null && arrayList.size() != 0)) {
            z = z2;
        }
        if (z) {
            this.M.setBackgroundResource(R$drawable.square_publish_share_bg);
            this.M.setAlpha(1.0f);
        } else {
            this.M.setBackgroundResource(R$drawable.square_publish_share_bg_disable);
            this.M.setAlpha(0.6f);
        }
    }

    public final void E2(int i2) {
        if (!this.T) {
            this.R.setVisibility(8);
            return;
        }
        LocationEx locationEx = this.y;
        if (locationEx == null) {
            q2("");
        } else if (i2 == 1) {
            q2(LocationSelectDialog.F(locationEx));
        } else {
            q2(locationEx.getName());
        }
    }

    public final void F2() {
        String name;
        List<SquareTagBean> tags;
        SquareTagBean squareTagBean = this.C;
        if (squareTagBean == null) {
            if (ai5.k().j() != null && (tags = ai5.k().j().getTags()) != null && !tags.isEmpty()) {
                SquareTagBean squareTagBean2 = tags.get(0);
                this.C = squareTagBean2;
                name = squareTagBean2.getName();
                Iterator<SquareTagBean> it = tags.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SquareTagBean next = it.next();
                    if (next.isDefaultTag()) {
                        name = next.getName();
                        this.C = next;
                        break;
                    }
                }
            } else {
                name = "选择生活方式";
            }
            this.O.setText(name);
        } else {
            this.O.setText(squareTagBean.getName());
        }
        ImageView imageView = (ImageView) findViewById(R$id.icon_tag);
        je1 je1VarR = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        if (this.C != null) {
            gr2.j().k(this.C.getPicUrl(), je1VarR, new c(imageView));
        }
    }

    public final void G2() {
        if (!this.H) {
            a2().setVisibility(8);
            return;
        }
        a2().setVisibility(0);
        if (this.E == null) {
            TextView textView = this.Q;
            StringBuilder sb = new StringBuilder();
            sb.append(g2() ? "# " : "");
            sb.append("选择话题");
            textView.setText(sb.toString());
        } else {
            TextView textView2 = this.Q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(g2() ? "# " : "");
            sb2.append(this.E.getTopicName());
            textView2.setText(sb2.toString());
        }
        if (this.v != null) {
            this.Q.setEnabled(false);
        }
    }

    public final void R1(MediaItem mediaItem, Media media) {
        if (media == null || mediaItem == null) {
            return;
        }
        MediaItem.LocationInfo locationInfo = mediaItem.locationInfo;
        if (locationInfo != null) {
            media.location = locationInfo.getShowName();
        }
        if (mediaItem.extractInfo != null) {
            if (k86.K(r0.lat, r0.lng)) {
                MediaItem.ExtractInfo extractInfo = mediaItem.extractInfo;
                media.latitude = extractInfo.lat;
                media.longitude = extractInfo.lng;
            }
            MediaItem.ExtractInfo extractInfo2 = mediaItem.extractInfo;
            long j2 = extractInfo2.time;
            media.shootingTime = j2;
            if (j2 <= 0) {
                media.shootingTime = extractInfo2.fileTime;
            }
        }
    }

    public abstract float S1(int i2);

    public final boolean T1() {
        if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            return false;
        }
        this.W.a(this, new a());
        return true;
    }

    public void U1() {
        if (!this.T || tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            init();
        } else {
            v2();
        }
    }

    public final void V1() {
        if (this.T && this.J == null && !com.zenmen.palmchat.location.b.f(this)) {
            this.P.setVisibility(0);
        } else {
            this.P.setVisibility(8);
        }
    }

    public final int W1() {
        if (f2()) {
            return Y1();
        }
        return 0;
    }

    public final int Y1() {
        return this.X - b2();
    }

    public View a2() {
        return this.Q;
    }

    public final int b2() {
        if (getWindow() == null) {
            return 0;
        }
        getWindow().getDecorView().getWindowVisibleDisplayFrame(this.Y);
        return this.Y.bottom;
    }

    public final void c2(Feed feed) {
        SquareShareFeedBean squareShareFeedBean = new SquareShareFeedBean();
        squareShareFeedBean.feedType = feed.getFeedType();
        squareShareFeedBean.mediaList = feed.getMediaList();
        squareShareFeedBean.content = feed.getContent();
        squareShareFeedBean.ae = this.w;
        if (this.z == 1) {
            LocationEx locationEx = this.y;
            locationEx.setName(LocationSelectDialog.F(locationEx));
        }
        squareShareFeedBean.location = this.y;
        squareShareFeedBean.topic = this.E;
        squareShareFeedBean.tagId = this.C.getId();
        squareShareFeedBean.clearMedia = this.G;
        if (this.q == 76) {
            squareShareFeedBean.feedCategory = 3;
        } else if (lj5.c().f19012a == 102) {
            squareShareFeedBean.feedCategory = 7;
        } else if (lj5.c().f19012a == 103) {
            squareShareFeedBean.feedCategory = 6;
        }
        squareShareFeedBean.picSource = this.s == 2 ? 0 : 1;
        squareShareFeedBean.visibleType = this.N.getShareTarget();
        mj5.r().B(squareShareFeedBean);
        k2();
    }

    public void d2() {
        String str = k0;
        Log.d(str, "hide soft keyboard begin");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        Log.d(str, "hide soft keyboard really hide");
        inputMethodManager.hideSoftInputFromWindow(this.L.getWindowToken(), 2);
    }

    public void e2() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("key_init_text") : null;
        this.M = (ViewGroup) findViewById(R$id.share_fl);
        this.N = (BottomShareView) findViewById(R$id.bottom_share);
        int iA = ai5.k().m().a();
        EditText editText = (EditText) findViewById(R$id.edit);
        this.L = editText;
        editText.setOnEditorActionListener(new i());
        this.L.addTextChangedListener(new k(iA));
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new l());
        this.M.setOnClickListener(new m());
        this.R = (ViewGroup) findViewById(R$id.location_rl);
        this.S = (TextView) findViewById(R$id.location);
        this.O = (TextView) findViewById(R$id.tag);
        this.Q = (TextView) findViewById(R$id.topic);
        this.R.setOnClickListener(new n());
        int i2 = R$id.tag_rl;
        findViewById(i2).setOnClickListener(new o());
        findViewById(i2).setVisibility(8);
        a2().setOnClickListener(new p());
        this.P = findViewById(R$id.location_layout);
        findViewById(R$id.location_setting).setOnClickListener(new q());
        E2(2);
        F2();
        G2();
        D2();
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.L.setText(stringExtra);
        EditText editText2 = this.L;
        editText2.setSelection(editText2.getText().length());
    }

    public final boolean f2() {
        return this.X > b2();
    }

    public boolean g2() {
        return true;
    }

    public final void h2() {
        MediaItem mediaItem;
        Intent intent = getIntent();
        if (intent != null) {
            boolean z = false;
            this.q = intent.getIntExtra("key_from", 0);
            this.r = intent.getBooleanExtra("key_need_pop_media", false);
            this.u = (SquareTagBean) intent.getParcelableExtra("key_tag");
            this.v = (TopicListBean.Topic) intent.getParcelableExtra("key_topic");
            this.w = (TopicListBean.Ae) intent.getParcelableExtra("key_ae");
            this.C = this.u;
            this.E = this.v;
            int intExtra = intent.getIntExtra("key_media_type", 2);
            this.t = intExtra;
            if (intExtra == 2) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_publish_pictures");
                if (parcelableArrayListExtra != null) {
                    this.x.addAll(parcelableArrayListExtra);
                }
            } else if (intExtra == 3 && (mediaItem = (MediaItem) intent.getParcelableExtra("key_publish_video")) != null) {
                this.x.add(mediaItem);
            }
            this.A = intent.getStringExtra("key_publish_time");
            this.U = intent.getIntExtra("key_camera_facing", 0);
            this.F = intent.getBooleanExtra("key_goto_square", true);
            this.G = intent.getBooleanExtra("clear_media", false);
            this.H = intent.getBooleanExtra("key_topic_enable", true);
            this.s = intent.getIntExtra("key_media_source", 1);
            List<TopicListBean.Topic> listI = xj5.h().i();
            if (this.H && listI != null && listI.size() > 0) {
                z = true;
            }
            this.H = z;
        }
    }

    public void i2(boolean z, int i2) {
        String str = k0;
        Log.d(str, "keyboard change height:" + i2);
        if (i2 > 0) {
            this.Z = true;
            C2(S1(i2));
            return;
        }
        this.Z = false;
        Log.d(str, "keyboard change currentTranslationY:" + this.f0);
        C2(this.f0);
    }

    public final void init() {
        if (this.T && this.g0) {
            this.g0 = false;
            B2();
        }
        v2();
    }

    public final void j2() {
        if (this.V) {
            zn6.c("pagemultipleedit_editarea_location", "click");
        } else {
            zn6.c("pagephotoedit_editarea_location", "click");
        }
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_square_location_tips", Boolean.FALSE);
        if (k86.L(this.y)) {
            w2();
        } else if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            B2();
        } else {
            p2();
        }
    }

    public final void k2() {
        if (this.N.getShareTarget() == 0) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "recommendTitle");
            aVar.b(bundle);
            startActivity(n5.b(this, aVar));
        } else if (this.N.getShareTarget() == 2 && gi5.t("friendFeedTitle")) {
            fk2.a aVar2 = new fk2.a();
            Bundle bundle2 = new Bundle();
            bundle2.putString("main_tab", "tab_square");
            bundle2.putString("square_tab", "friendFeedTitle");
            aVar2.b(bundle2);
            startActivity(n5.b(this, aVar2));
        }
        ds0.a().b(new kj5());
        vi5.b().j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if (defpackage.zk5.g(r2, r2.getText(), r0, null, false) < defpackage.ai5.k().m().b()) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l2(boolean z) {
        d2();
        C2(0.0f);
        if (l50.a()) {
            return;
        }
        if (!hx3.m(this)) {
            sy5.e(this, R$string.square_network_error, 0).g();
            return;
        }
        if (!this.V) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.q);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.f("pagephotoedit_upright_publish", "click", jSONObject);
        } else if (this.x != null) {
            zn6.j("pagemultipleedit_downright_publish", "click", new r());
        }
        int iA = ai5.k().m().a();
        if (this.C == null) {
            sy5.f(this, "请选择生活方式哦", 0).g();
            return;
        }
        ArrayList<MediaItem> arrayList = this.x;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                if (this.L.getText() != null) {
                    EditText editText = this.L;
                }
            }
            if (z && T1()) {
                return;
            }
            ArrayList<MediaItem> arrayList2 = this.x;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                this.t = 1;
                n2(this.L.getText().toString());
                return;
            } else if (this.x.size() == 1 && this.x.get(0).mimeType == 1) {
                this.t = 3;
                o2(this.q, this.L.getText().toString());
                return;
            } else {
                this.t = 2;
                m2(this.q, this.L.getText().toString());
                return;
            }
        }
        u2();
    }

    public void m2(int i2, String str) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (MediaItem mediaItem : this.x) {
            String str2 = mediaItem.fileFullPath;
            Media media = new Media();
            media.localPath = str2;
            media.type = 2;
            media.picSource = mediaItem.picSource;
            int[] iArrX1 = X1(str2);
            if (xt.r(str2)) {
                media.width = Integer.toString(iArrX1[1]);
                media.height = Integer.toString(iArrX1[0]);
            } else {
                media.width = Integer.toString(iArrX1[0]);
                media.height = Integer.toString(iArrX1[1]);
            }
            R1(mediaItem, media);
            arrayList.add(media);
        }
        c2(new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.t, 0, 0, null, 0L, Integer.valueOf(wt1.f21791a), null, arrayList));
    }

    public void n2(String str) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        c2(new Feed(Long.valueOf(timeInMillis), Long.valueOf(Calendar.getInstance().getTimeInMillis()), strE, Long.valueOf(timeInMillis2), str, this.t, 0, 0, null, 0L, Integer.valueOf(wt1.f21791a), null, new ArrayList()));
    }

    public void o2(int i2, String str) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        if (this.x.size() > 0) {
            MediaItem mediaItem = this.x.get(0);
            Media media = new Media();
            media.localPath = mediaItem.localPath;
            String str2 = mediaItem.localThumbPath;
            media.localThumbPath = str2;
            media.type = 3;
            media.videoDuration = mediaItem.playLength;
            media.width = Integer.toString(X1(str2)[0]);
            media.height = Integer.toString(X1(mediaItem.localThumbPath)[1]);
            media.picSource = mediaItem.picSource;
            R1(mediaItem, media);
            arrayList.add(media);
            LogUtil.i(k0, "publishVideo localPath = " + media.localPath + ", thumbUrl = " + media.localThumbPath + ", type = " + media.type);
            c2(new Feed(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis3), strE, Long.valueOf(timeInMillis2), str, this.t, 0, 0, null, 0L, Integer.valueOf(wt1.f21791a), null, arrayList));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 100 || i3 != -1 || intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("tags")) == null || parcelableArrayListExtra.size() <= 0) {
            return;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ArrayList<MediaItem> arrayList;
        if (TextUtils.isEmpty(this.L.getText()) && ((arrayList = this.x) == null || arrayList.isEmpty())) {
            super.onBackPressed();
        } else {
            t2();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        h2();
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            ds0.a().d(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        this.i0 = false;
        this.j0 = locationEx != null;
        if (locationEx != null) {
            this.J = locationEx;
            locationEx.setCity(locationEx.getRealCityName());
            this.y = locationEx;
            this.z = 1;
            x2(LocationSelectDialog.F(locationEx));
        } else {
            x2("");
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    jSONObject.put(MyLocationStyle.ERROR_INFO, str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("errorCode", i2);
            if (this.V) {
                zn6.f("pagemultipleedit_positionfail", "view", jSONObject);
            } else {
                zn6.f("pagephotoedit_positionfail", "view", jSONObject);
            }
        }
        D2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.LOCATION) {
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_square_permission_location_reject", Boolean.TRUE);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.LOCATION) {
            init();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h0) {
            this.h0 = false;
            if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
                init();
            }
        }
        if (this.K) {
            this.K = false;
            B2();
        }
        V1();
    }

    @qm5
    public void onSquarePublishEvent(kj5 kj5Var) {
        finish();
    }

    public final void p2() {
        if (!SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, "key_square_permission_location_reject", false)) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_LOCATION);
        } else {
            jump2Setting();
            this.h0 = true;
        }
    }

    public void q2(String str) {
        this.W.c(str, this.i0, this.j0);
        if (!TextUtils.isEmpty(str)) {
            this.S.setCompoundDrawables(null, null, null, null);
            this.S.setText(str);
            return;
        }
        Drawable drawable = getResources().getDrawable(R$drawable.square_publish_right_arrow);
        drawable.setColorFilter(Color.parseColor(this.V ? "#222222" : "#ffffff"), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.S.setCompoundDrawablePadding(k36.b(4.0f));
        if (this.i0) {
            this.S.setCompoundDrawables(null, null, null, null);
            this.S.setText("定位中...");
        } else if (!tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            this.S.setCompoundDrawables(null, null, drawable, null);
            this.S.setText("请授权位置信息");
        } else if (this.j0) {
            this.S.setCompoundDrawables(null, null, null, null);
            this.S.setText("   ");
        } else {
            this.S.setCompoundDrawables(null, null, drawable, null);
            this.S.setText("定位失败，点击重试");
        }
    }

    public void r2(boolean z) {
        this.V = z;
    }

    public boolean s2() {
        return true;
    }

    public final void t2() {
        View viewInflate = View.inflate(this, R$layout.square_dialog_publish_back, null);
        MaterialDialog materialDialogE = new sd3(this).p(viewInflate, false).h(false).e();
        materialDialogE.show();
        View viewFindViewById = viewInflate.findViewById(R$id.confirm);
        View viewFindViewById2 = viewInflate.findViewById(R$id.cancel);
        viewFindViewById.setOnClickListener(new f(materialDialogE));
        viewFindViewById2.setOnClickListener(new g(materialDialogE));
        if (this.V) {
            zn6.c("pagemultipleedit_callback", "view");
        } else {
            zn6.c("pagephotoedit_callback", "view");
        }
    }

    public void u2() {
        new sd3(this).k(this.L.getText() == null || this.L.getText().toString().trim().length() == 0 ? "请添加文字或图片内容后再分享" : String.format("纯文字内容要求不少于%d个字", Integer.valueOf(ai5.k().m().b()))).P("知道了").h(true).e().show();
    }

    public final void v2() {
        if (!this.r) {
            this.L.postDelayed(new b(), 200L);
        } else {
            this.r = false;
            y2();
        }
    }

    public final void w2() {
        if (com.zenmen.palmchat.location.c.b().pageMultipleEditLocation) {
            LocationSelectDialog locationSelectDialog = this.B;
            if (locationSelectDialog == null || !locationSelectDialog.isShowing()) {
                LocationSelectDialog locationSelectDialog2 = new LocationSelectDialog(this, !this.V, this.J, new h(), LocationScene.PUBLISH_SQUARE);
                this.B = locationSelectDialog2;
                locationSelectDialog2.show();
            }
        }
    }

    public final void x2(String str) {
        this.R.setVisibility(0);
        q2(str);
        V1();
    }

    public final void z2() {
        new TopicSelectDialog(this, !this.V, new e()).show();
    }

    public void y2() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements i53 {
        public j() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            SquareBasePublishActivity.this.onLocationReceived(locationEx, i, str);
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16107a;

        public k(int i) {
            this.f16107a = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iG = zk5.g(SquareBasePublishActivity.this.L, charSequence, this.f16107a, null, false);
            SquareBasePublishActivity squareBasePublishActivity = SquareBasePublishActivity.this;
            if (squareBasePublishActivity.I && iG > this.f16107a) {
                squareBasePublishActivity.I = false;
                if (!squareBasePublishActivity.V) {
                    zn6.c("pagephotoedit_word_fiftyrecord", "click");
                }
            }
            SquareBasePublishActivity.this.D2();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f16099a;

        public c(ImageView imageView) {
            this.f16099a = imageView;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setColorFilter(Color.parseColor(SquareBasePublishActivity.this.V ? "#222222" : "#ffffff"), PorterDuff.Mode.SRC_ATOP);
            bitmapDrawable.setBounds(0, 0, k36.b(18.0f), k36.b(18.0f));
            this.f16099a.setImageDrawable(bitmapDrawable);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}

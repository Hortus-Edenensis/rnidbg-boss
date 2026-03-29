package com.zenmen.media.album;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.GravityEnum;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.photoview.BasePreviewActivity;
import com.zenmen.palmchat.activity.photoview.PhotoViewFragmentAdapter;
import com.zenmen.palmchat.activity.photoview.a;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.ch;
import defpackage.cj5;
import defpackage.ds0;
import defpackage.g13;
import defpackage.gi4;
import defpackage.gl2;
import defpackage.h22;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.pu1;
import defpackage.px5;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sg3;
import defpackage.sn2;
import defpackage.tk3;
import defpackage.u92;
import defpackage.wv;
import defpackage.yk3;
import defpackage.zn6;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaPreviewActivity extends BasePreviewActivity implements Animation.AnimationListener, gl2, a.b {
    public static final String g0 = "SquareMediaPreviewActivity";
    public static ArrayList<MediaItem> h0;
    public View A;
    public TextView B;
    public TextView C;
    public ImageView E;
    public TextView F;
    public TextView G;
    public View H;
    public View I;
    public RelativeLayout J;
    public gi4 K;
    public TextView L;
    public View M;
    public PhotoViewFragmentAdapter P;
    public Animation Q;
    public Animation R;
    public HorizontalScrollView S;
    public LinearLayout T;
    public com.zenmen.palmchat.activity.photoview.a U;
    public String Z;
    public ViewPager q;
    public View z;
    public ArrayList<MediaItem> r = new ArrayList<>();
    public ArrayList<a.c> s = new ArrayList<>();
    public int t = 9;
    public int u = 0;
    public int v = 0;
    public int w = -1;
    public int x = 0;
    public MediaItem y = null;
    public ArrayList<MediaItem> N = new ArrayList<>();
    public boolean O = false;
    public boolean V = true;
    public HashMap<String, Integer> W = new HashMap<>();
    public boolean X = false;
    public n Y = new n(this);
    public long e0 = ((wv.a() + 1) * 1000) - 1;
    public long f0 = 1000;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPreviewActivity.this.finish();
            zn6.c("pagephotopreview_top_back", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPreviewActivity.this.finish();
            zn6.c("pagephotopreview_top_back", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPreviewActivity.this.j2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SquareMediaPreviewActivity.this.k2();
            zn6.c("pagephotopreview_top_edit", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f11930a;

        public f(MediaItem mediaItem) {
            this.f11930a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i != 0) {
                com.zenmen.palmchat.chat.h.h(SquareMediaPreviewActivity.this, i);
            } else {
                tk3.k(SquareMediaPreviewActivity.this, this.f11930a, ErrorCode.DETAIL_HTTP_TIMEOUT);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f11931a;

        public g(MediaItem mediaItem) {
            this.f11931a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i != 0) {
                com.zenmen.palmchat.chat.h.h(SquareMediaPreviewActivity.this, i);
            } else if (u92.a(this.f11931a) != 0) {
                u92.c(SquareMediaPreviewActivity.this, i);
            } else {
                SquareMediaPreviewActivity.this.N.add(this.f11931a);
                if (SquareMediaPreviewActivity.this.s.size() == 0) {
                    SquareMediaPreviewActivity.this.S.setVisibility(0);
                }
                SquareMediaPreviewActivity.this.s.add(new a.c(this.f11931a));
                SquareMediaPreviewActivity.this.U.e((a.c) SquareMediaPreviewActivity.this.s.get(SquareMediaPreviewActivity.this.s.size() - 1));
                SquareMediaPreviewActivity.this.U.h(SquareMediaPreviewActivity.this.s.size() - 1);
                SquareMediaPreviewActivity.this.A.setSelected(true);
                SquareMediaPreviewActivity.this.B.setText("已选");
                ds0.a().b(new yk3(this.f11931a, true));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("clicktype", 1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.f("pagephotopreview_upright_select", "click", jSONObject);
            }
            SquareMediaPreviewActivity.this.n2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareMediaPreviewActivity.this.r2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f11933a;

        public i(MediaItem mediaItem) {
            this.f11933a = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareMediaPreviewActivity.this.W.put(this.f11933a.fileFullPath, 1);
            SquareMediaPreviewActivity.this.r2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11934a;

        public j(int i) {
            this.f11934a = i;
            put("type", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaItem f11936a;

            public a(MediaItem mediaItem) {
                this.f11936a = mediaItem;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    com.zenmen.palmchat.chat.h.h(SquareMediaPreviewActivity.this, i);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("result_media", this.f11936a);
                SquareMediaPreviewActivity.this.setResult(-1, intent);
                SquareMediaPreviewActivity.this.finish();
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.c("pagephotopreview_top_next", "click");
            SquareMediaPreviewActivity.this.s.clear();
            MediaItem mediaItemD2 = SquareMediaPreviewActivity.this.d2();
            if (mediaItemD2 == null) {
                return;
            }
            if (!SquareMediaPreviewActivity.this.O) {
                com.zenmen.palmchat.chat.h.c(SquareMediaPreviewActivity.this, mediaItemD2, new a(mediaItemD2));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("result_media", mediaItemD2);
            SquareMediaPreviewActivity.this.setResult(-1, intent);
            SquareMediaPreviewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends g13 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<m> f11937a;

        public l(ArrayList<m> arrayList) {
            this.f11937a = arrayList;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                for (m mVar : this.f11937a) {
                    Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(mVar.f11938a.fileFullPath, 1);
                    if (bitmapCreateVideoThumbnail != null) {
                        File file = new File(pu1.f);
                        if (!file.exists()) {
                            file.mkdirs();
                            LogUtil.i(SquareMediaPreviewActivity.g0, "create dir");
                        }
                        File fileC = pu1.c((pu1.f + File.separator) + mVar.f11938a.fileID + ".thumbnail");
                        FileOutputStream fileOutputStream = new FileOutputStream(fileC);
                        bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        mVar.f11938a.thumbnailPath = fileC.getAbsolutePath();
                        mVar.f11938a.localThumbPath = fileC.getAbsolutePath();
                        LogUtil.i(SquareMediaPreviewActivity.g0, "CreateThumbThread, index = " + mVar.b + "， path = " + fileC.getAbsolutePath());
                        Message message = new Message();
                        message.what = 2;
                        message.obj = mVar;
                        SquareMediaPreviewActivity.this.Y.sendMessage(message);
                    }
                }
            } catch (Exception e) {
                LogUtil.i(SquareMediaPreviewActivity.g0, "CreateThumbThread, error = " + e);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaItem f11938a;
        public int b;

        public m(MediaItem mediaItem, int i) {
            this.b = i;
            this.f11938a = mediaItem;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SquareMediaPreviewActivity> f11939a;

        public n(SquareMediaPreviewActivity squareMediaPreviewActivity) {
            this.f11939a = new WeakReference<>(squareMediaPreviewActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2 || this.f11939a.get() == null || this.f11939a.get().r == null) {
                return;
            }
            SquareMediaPreviewActivity squareMediaPreviewActivity = this.f11939a.get();
            m mVar = (m) message.obj;
            if (squareMediaPreviewActivity.r.size() > mVar.b) {
                squareMediaPreviewActivity.r.set(mVar.b, mVar.f11938a);
            } else {
                squareMediaPreviewActivity.r.add(mVar.f11938a);
            }
            if (squareMediaPreviewActivity.P == null) {
                squareMediaPreviewActivity.P = new PhotoViewFragmentAdapter(squareMediaPreviewActivity.getSupportFragmentManager(), null, squareMediaPreviewActivity.r, false, false, false, false, squareMediaPreviewActivity.Z, squareMediaPreviewActivity.x, squareMediaPreviewActivity.V);
            }
            squareMediaPreviewActivity.P.h(squareMediaPreviewActivity.r);
            if (squareMediaPreviewActivity.i2()) {
                return;
            }
            squareMediaPreviewActivity.P.notifyDataSetChanged();
        }
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public int B1() {
        return this.x;
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void C1() {
        G1();
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void G1() {
        gi4 gi4Var = this.K;
        if (gi4Var != null) {
            gi4Var.j();
        }
    }

    @Override // com.zenmen.palmchat.activity.photoview.a.b
    public void J(a.c cVar, View view, int i2, int i3) {
        ArrayList<MediaItem> arrayList = this.r;
        if (arrayList == null || cVar == null) {
            return;
        }
        Iterator<MediaItem> it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (cVar.f12364a.fileFullPath.equals(it.next().fileFullPath)) {
                this.v = i4;
                ViewPager viewPager = this.q;
                if (viewPager != null) {
                    viewPager.setCurrentItem(i4, false);
                }
            }
            i4++;
        }
        V0(view, i2);
        zn6.c("pagephotopreview_down_choice", "click");
    }

    @Override // com.zenmen.palmchat.activity.photoview.a.b
    public void V0(View view, int i2) {
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int width = view.getWidth();
        if (i3 == 0 || width == 0) {
            return;
        }
        this.S.smoothScrollTo((view.getLeft() - (((i3 / width) * width) / 2)) + (width / 2), 0);
    }

    public final MediaItem d2() {
        MediaItem mediaItem = this.y;
        if (mediaItem == null) {
            mediaItem = null;
        }
        ArrayList<MediaItem> arrayList = this.r;
        return (arrayList == null || arrayList.size() <= this.q.getCurrentItem()) ? mediaItem : this.r.get(this.q.getCurrentItem());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e2() {
        int i2;
        Intent intent = getIntent();
        ArrayList<MediaItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("mediaList");
        this.r = parcelableArrayListExtra;
        if (parcelableArrayListExtra == null) {
            this.r = h0;
        }
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        h0 = null;
        int i3 = 0;
        this.O = intent.getBooleanExtra("multi_select", false);
        ArrayList<MediaItem> parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("selectlist");
        this.N = parcelableArrayListExtra2;
        if (parcelableArrayListExtra2 == null) {
            this.N = new ArrayList<>();
        } else {
            for (MediaItem mediaItem : parcelableArrayListExtra2) {
                mediaItem.editedImagePath = null;
                mediaItem.cropRect = null;
                mediaItem.degree = 0;
            }
        }
        this.y = (MediaItem) intent.getParcelableExtra("first_item");
        int intExtra = intent.getIntExtra("selectIndex", 0);
        this.u = intExtra;
        this.v = intExtra;
        this.x = intent.getIntExtra("show_mode", 0);
        this.V = intent.getBooleanExtra("init_item_auto_play", true);
        this.Z = intent.getStringExtra("from");
        this.t = intent.getIntExtra("extra_key_max_num", 9);
        this.w = intent.getIntExtra("enter_type", -1);
        if (this.x == 2) {
            MediaItem mediaItem2 = this.y;
            if (mediaItem2 == null) {
                try {
                    ArrayList<MediaItem> arrayList = this.N;
                    if (arrayList != null && arrayList.size() > 0 && this.u < this.N.size() && (i2 = this.u) > 0) {
                        if (this.N.get(i2).mimeType != 0) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (mediaItem2.mimeType != 0) {
                i3 = 1;
            }
        }
        updateCurrentPageInfo(this, new j(i3));
    }

    public final int f2(ArrayList<MediaItem> arrayList, MediaItem mediaItem) {
        if (arrayList != null && mediaItem != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = arrayList.get(i2).fileFullPath;
                if (str != null && str.equals(mediaItem.fileFullPath)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public final void g2() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.Q = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.Q.setFillAfter(true);
        this.Q.setAnimationListener(this);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.R = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.R.setFillAfter(true);
        this.R.setAnimationListener(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 106;
    }

    public final void h2() {
        this.C = (TextView) findViewById(R.id.tv_action);
        this.E = (ImageView) findViewById(R.id.info_icon);
        this.F = (TextView) findViewById(R.id.info_location);
        this.G = (TextView) findViewById(R.id.info_time);
        this.I = findViewById(R.id.toolbar_area);
        this.H = findViewById(R.id.bottomContainer);
        this.L = (TextView) findViewById(R.id.edit);
        this.M = findViewById(R.id.edit_tips);
        this.z = findViewById(R.id.select_layout);
        this.A = findViewById(R.id.select_icon);
        this.B = (TextView) findViewById(R.id.select_title);
        this.z.setOnClickListener(new c());
        this.q = (ViewPager) findViewById(R.id.viewpager);
        this.S = (HorizontalScrollView) findViewById(R.id.scrollView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scrollContentView);
        this.T = linearLayout;
        this.U = new com.zenmen.palmchat.activity.photoview.a(this, this, linearLayout);
        this.L.setOnClickListener(new d());
        ArrayList<MediaItem> arrayList = this.r;
        PhotoViewFragmentAdapter photoViewFragmentAdapter = this.P;
        if (photoViewFragmentAdapter == null) {
            this.P = new PhotoViewFragmentAdapter(getSupportFragmentManager(), null, this.r, false, false, false, false, this.Z, this.x, this.V);
        } else {
            photoViewFragmentAdapter.h(arrayList);
        }
        ArrayList<MediaItem> arrayList2 = this.r;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.P.f(this.y);
        }
        this.P.g(this.u);
        this.q.setAdapter(this.P);
        this.q.setBackgroundColor(-16777216);
        this.q.setCurrentItem(this.u, true);
        this.q.addOnPageChangeListener(new e());
    }

    public final boolean i2() {
        return isFinishing() || isDestroyed();
    }

    public final void initActionBar() {
        setStatusBarColor(-16777216);
        a46.A(getWindow(), false);
        this.J = (RelativeLayout) findViewById(R.id.rootView);
        findViewById(R.id.iv_back).setOnClickListener(new a());
        findViewById(R.id.title).setOnClickListener(new b());
        if (this.x == 2) {
            View viewFindViewById = findViewById(R.id.toolbar_layout);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams.setMargins(0, me1.h(this), 0, 0);
            viewFindViewById.setLayoutParams(layoutParams);
            gi4 gi4Var = new gi4(this.J, this.I, this.H);
            this.K = gi4Var;
            gi4Var.h(-me1.b(this.J.getContext(), 130));
        }
    }

    public final void j2() {
        a.c cVarRemove;
        MediaItem mediaItemD2 = d2();
        int iF2 = f2(this.N, mediaItemD2);
        if (iF2 != -1) {
            if (this.N.size() > iF2) {
                this.N.remove(iF2);
            }
            if (this.s.size() > iF2 && (cVarRemove = this.s.remove(iF2)) != null) {
                this.U.g(cVarRemove);
            }
            if (this.s.size() == 0) {
                this.S.setVisibility(4);
            }
            this.A.setSelected(false);
            this.B.setText("未选");
            ds0.a().b(new yk3(mediaItemD2, false));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clicktype", 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.f("pagephotopreview_upright_select", "click", jSONObject);
        } else if (this.N.size() >= this.t) {
            o2();
        } else {
            com.zenmen.palmchat.chat.h.c(this, mediaItemD2, new g(mediaItemD2));
        }
        n2();
    }

    public final void k2() {
        MediaItem mediaItemD2 = d2();
        if (mediaItemD2 == null) {
            return;
        }
        com.zenmen.palmchat.chat.h.c(this, mediaItemD2, new f(mediaItemD2));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l2(int i2) {
        MediaItem mediaItem;
        this.v = i2;
        ArrayList<MediaItem> arrayList = this.r;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = this.v;
            mediaItem = size > i3 ? this.r.get(i3) : null;
        }
        r2();
        this.P.g(i2);
        ds0.a().b(new h22(i2));
        q2();
        s2();
        if (this.s.size() <= 0 || this.r.size() <= 0) {
            return;
        }
        this.U.i(mediaItem);
    }

    public void m2() {
        if ("from_moment".equals(this.Z)) {
            Iterator<a.c> it = this.s.iterator();
            while (it.hasNext()) {
                sn2.a(this, it.next().b);
            }
            return;
        }
        for (a.c cVar : this.s) {
            if (cVar.b != null) {
                File file = new File(cVar.b);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public final void n2() {
        int size = this.N.size();
        String string = "下一步";
        if (this.O && size != 0) {
            string = getResources().getString(R.string.square_media_pick_next, Integer.valueOf(size));
        }
        this.C.setText(string);
    }

    public final void o2() {
        new sd3(this).k(getResources().getString(R.string.square_media_pick_reach_limit, Integer.valueOf(this.t))).n(GravityEnum.CENTER).O(R.string.alert_dialog_i_knoW).e().show();
        zn6.c("pageselectlimit", "view");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        LogUtil.i(g0, "onActivityResult");
        super.onActivityResult(i2, i3, intent);
        if (i2 == 998 && i3 == -1) {
            MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_CROP_ITEM");
            MediaItem mediaItemD2 = d2();
            if (mediaItem != null && mediaItemD2 != null) {
                mediaItem.extractInfo = mediaItemD2.extractInfo;
                mediaItem.locationInfo = mediaItemD2.locationInfo;
                Intent intent2 = new Intent();
                intent2.putExtra("result_media", mediaItem);
                setResult(-1, intent2);
            }
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        zn6.c("pagephotopreview_top_back", "click");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = new ArrayList<>();
        e2();
        setContentView(R.layout.activity_square_media_preview);
        h2();
        g2();
        initActionBar();
        ds0.a().c(this);
        ArrayList<MediaItem> arrayList = this.N;
        if (arrayList == null || arrayList.size() <= 0) {
            this.S.setVisibility(8);
        } else {
            Iterator<MediaItem> it = this.N.iterator();
            while (it.hasNext()) {
                a.c cVar = new a.c(it.next());
                this.s.add(cVar);
                this.U.e(cVar);
            }
            if (this.s.size() > 0) {
                this.U.h(0);
            }
        }
        u2();
        p2();
        v2();
        ch.s().r().j(this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("entermodel", this.w);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("pagephotopreview", "view", jSONObject);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        px5.g();
        ch.s().r().l(this);
        m2();
        ds0.a().d(this);
        super.onDestroy();
    }

    @qm5
    public void onMediaExtractorEvent(sg3 sg3Var) {
        runOnUiThread(new h());
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    public final void p2() {
        n2();
        this.C.setOnClickListener(new k());
    }

    public final void q2() {
        if (this.O) {
            this.H.setBackgroundColor(Color.parseColor("#d9222222"));
        } else {
            this.H.setBackgroundResource(R.drawable.bg_square_media_preview_bottom_info);
        }
        MediaItem mediaItemD2 = d2();
        if (mediaItemD2 == null) {
            return;
        }
        if (mediaItemD2.mimeType == 1) {
            this.L.setVisibility(0);
        } else {
            this.L.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r2() {
        MediaItem mediaItem;
        ArrayList<MediaItem> arrayList = this.r;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = this.v;
            mediaItem = (size <= i2 || i2 < 0) ? null : this.r.get(i2);
        }
        if (mediaItem != null) {
            LogUtil.d("logmedia", "curMedia: " + mediaItem.fileFullPath);
        }
        if (mediaItem == null || mediaItem.extractInfo == null) {
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.X = false;
        } else {
            MediaItem.LocationInfo locationInfoD = cj5.c().d(mediaItem);
            if (locationInfoD == null || TextUtils.isEmpty(locationInfoD.getShowName())) {
                MediaItem.ExtractInfo extractInfo = mediaItem.extractInfo;
                Integer num = !k86.K((double) extractInfo.lat, (double) extractInfo.lng) ? 1 : this.W.get(mediaItem.fileFullPath);
                if (num == null) {
                    this.E.setVisibility(0);
                    this.F.setVisibility(8);
                    this.G.setVisibility(0);
                    this.E.setImageResource(R.drawable.square_preview_info_loading);
                    this.G.setText("加载中");
                    this.W.put(mediaItem.fileFullPath, 0);
                    cj5.c().b(mediaItem, true);
                    this.E.postDelayed(new i(mediaItem), 3000L);
                    this.X = true;
                } else if (num.intValue() == 0) {
                    this.E.setVisibility(0);
                    this.F.setVisibility(8);
                    this.G.setVisibility(0);
                    this.E.setImageResource(R.drawable.square_preview_info_loading);
                    this.G.setText("加载中");
                    this.X = true;
                } else if (num.intValue() == 1) {
                    this.F.setVisibility(8);
                    this.G.setVisibility(0);
                    if (TextUtils.isEmpty(mediaItem.extractInfo.getTimeStr())) {
                        this.E.setVisibility(8);
                        this.G.setVisibility(8);
                    } else {
                        this.E.setVisibility(0);
                        this.G.setVisibility(0);
                        this.E.setImageResource(R.drawable.square_preview_info_tips);
                        this.G.setText(mediaItem.extractInfo.getTimeStr());
                    }
                    this.X = false;
                }
            } else {
                this.E.setVisibility(0);
                this.F.setVisibility(0);
                this.E.setImageResource(R.drawable.square_preview_info_tips);
                this.F.setText(locationInfoD.getShowName());
                if (TextUtils.isEmpty(mediaItem.extractInfo.getTimeStr())) {
                    this.G.setVisibility(8);
                } else {
                    this.G.setVisibility(0);
                    this.G.setText(mediaItem.extractInfo.getTimeStr());
                }
                mediaItem.locationInfo = locationInfoD;
                this.X = false;
            }
        }
        t2();
    }

    public final void s2() {
        if (!this.O) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        MediaItem mediaItemD2 = d2();
        if (mediaItemD2 == null) {
            return;
        }
        this.A.setSelected(f2(this.N, mediaItemD2) >= 0);
        this.B.setText(this.A.isSelected() ? "已选" : "未选");
    }

    public final void t2() {
        MediaItem mediaItemD2 = d2();
        if (mediaItemD2 == null || mediaItemD2.mimeType != 1 || mediaItemD2.playLength <= this.e0) {
            this.C.setEnabled(true ^ this.X);
            this.M.setVisibility(8);
        } else {
            this.C.setEnabled(false);
            this.M.setVisibility(0);
        }
    }

    public final void u2() {
        String str;
        if (this.r == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            MediaItem mediaItem = this.r.get(i2);
            if (mediaItem.mimeType == 1 && (((str = mediaItem.thumbnailPath) == null || !pu1.b(str)) && mediaItem.fileFullPath.toLowerCase().endsWith("mp4"))) {
                arrayList.add(new m(mediaItem, i2));
            }
        }
        if (arrayList.size() != 0) {
            LogUtil.i(g0, "updateThumbForVideo ， size = " + arrayList.size());
            new l(arrayList).start();
        }
    }

    public final void v2() {
        String str = g0;
        LogUtil.i(str, "updataUI");
        if (this.x != 2) {
            this.H.setVisibility(8);
        } else {
            this.H.setVisibility(0);
        }
        ArrayList<MediaItem> arrayList = this.r;
        PhotoViewFragmentAdapter photoViewFragmentAdapter = this.P;
        if (photoViewFragmentAdapter == null) {
            this.P = new PhotoViewFragmentAdapter(getSupportFragmentManager(), null, this.r, false, false, false, false, this.Z, this.x, this.V);
        } else {
            photoViewFragmentAdapter.h(arrayList);
        }
        ArrayList<MediaItem> arrayList2 = this.r;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.P.f(this.y);
        } else {
            LogUtil.i(str, "updateUI,size = " + this.r.size());
        }
        this.P.g(this.u);
        this.q.setAdapter(this.P);
        this.q.setCurrentItem(this.u, false);
        q2();
        r2();
        s2();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ViewPager.OnPageChangeListener {
        public e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SquareMediaPreviewActivity.this.l2(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // defpackage.gl2
    public void T(int i2, String str) {
    }

    @Override // defpackage.gl2
    public void G0(int i2, int i3, String str) {
    }

    @Override // defpackage.gl2
    public void h0(int i2, String str, int i3) {
    }

    @Override // defpackage.gl2
    public void E(int i2, int i3, String str, int i4) {
    }

    @Override // defpackage.gl2
    public void L(File file, int i2, String str, int i3) {
    }
}

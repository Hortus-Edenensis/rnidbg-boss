package com.zenmen.palmchat.activity.find;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.VisibleRegion;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.opensource.svgaplayer.SVGAImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.AvatarPayBean;
import com.zenmen.find.bean.CheckDriftBean;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.find.bean.FindFriendCondition;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.find.bean.conf.FindMapActiveConf;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.find.b;
import com.zenmen.palmchat.activity.find.separation.MapSeparationModel;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.find.dialog.AgreementDialog;
import com.zenmen.palmchat.find.dialog.SwitchAvatarDialog;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.AliMapConfig;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.ui.widget.LocationSearchView;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.a46;
import defpackage.ad3;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bw1;
import defpackage.c15;
import defpackage.d74;
import defpackage.dd1;
import defpackage.ds0;
import defpackage.dw1;
import defpackage.dw4;
import defpackage.ed3;
import defpackage.ew1;
import defpackage.fd3;
import defpackage.gi5;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.i53;
import defpackage.iq5;
import defpackage.k86;
import defpackage.ky;
import defpackage.l50;
import defpackage.m15;
import defpackage.ma3;
import defpackage.mc3;
import defpackage.me1;
import defpackage.n53;
import defpackage.of2;
import defpackage.pc3;
import defpackage.q05;
import defpackage.qm5;
import defpackage.qw1;
import defpackage.ry5;
import defpackage.sc3;
import defpackage.sd3;
import defpackage.tc3;
import defpackage.u93;
import defpackage.uj5;
import defpackage.um2;
import defpackage.v05;
import defpackage.v4;
import defpackage.vc3;
import defpackage.ve;
import defpackage.wc3;
import defpackage.xc3;
import defpackage.yg4;
import defpackage.yi0;
import defpackage.yo;
import defpackage.z66;
import defpackage.zn6;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FindNearByMapActivity extends FrameworkBaseActivity implements tc3, d74, View.OnClickListener, i53, bw1.f, LocationSearchView.f, yi0, ConditionHelper.a {
    public TextView A;
    public TextView B;
    public View C0;
    public ImageView D0;
    public View E0;
    public ImageView F;
    public View F0;
    public ImageView G;
    public View G0;
    public ImageView H;
    public View H0;
    public ImageView I;
    public TextView I0;
    public ImageView J;
    public SVGAImageView J0;
    public ImageView K;
    public SVGAImageView K0;
    public bw1 L;
    public FrameLayout L0;
    public com.zenmen.palmchat.activity.find.b M;
    public FrameLayout M0;
    public int Q;
    public LoadCountBean.MarkerBean S;
    public float d1;
    public BaseNetBean<AvatarPayBean> p1;
    public com.zenmen.palmchat.location.b q;
    public ad3 r;
    public View s;
    public View t;
    public LocationSearchView u;
    public View v;
    public View w;
    public View x;
    public TextView y;
    public TextView z;
    public View C = null;
    public int E = 0;
    public boolean N = false;
    public boolean O = true;
    public int P = 0;
    public int R = gi5.i();
    public int T = 0;
    public int U = 0;
    public boolean V = false;
    public View W = null;
    public View X = null;
    public TextView Y = null;
    public View Z = null;
    public View e0 = null;
    public View f0 = null;
    public View g0 = null;
    public TextView h0 = null;
    public EffectiveShapeView i0 = null;
    public ed3 j0 = null;
    public View k0 = null;
    public ImageView l0 = null;
    public ImageView m0 = null;
    public ImageView n0 = null;
    public View o0 = null;
    public View p0 = null;
    public View q0 = null;
    public View r0 = null;
    public TextView s0 = null;
    public TextView t0 = null;
    public TextView u0 = null;
    public View v0 = null;
    public TextView w0 = null;
    public boolean x0 = false;
    public View y0 = null;
    public View z0 = null;
    public String A0 = null;
    public String B0 = null;
    public boolean N0 = false;
    public LocationEx O0 = null;
    public boolean P0 = false;
    public boolean Q0 = false;
    public Handler R0 = new Handler(Looper.getMainLooper());
    public wc3 S0 = new v();
    public boolean T0 = false;
    public boolean U0 = false;
    public boolean V0 = false;
    public LocationEx W0 = null;
    public LocationEx X0 = null;
    public LocationEx Y0 = null;
    public boolean Z0 = false;
    public float a1 = 0.0f;
    public boolean b1 = false;
    public Runnable c1 = new w();
    public boolean e1 = false;
    public boolean f1 = false;
    public boolean g1 = false;
    public boolean h1 = false;
    public boolean i1 = false;
    public boolean j1 = false;
    public boolean k1 = false;
    public boolean l1 = true;
    public boolean m1 = true;
    public boolean n1 = false;
    public boolean o1 = false;
    public Bitmap q1 = null;
    public Bitmap r1 = null;
    public ed3 s1 = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12195a;
        public final /* synthetic */ LocationEx b;

        public a0(boolean z, LocationEx locationEx) {
            this.f12195a = z;
            this.b = locationEx;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            ma3.a("onResourceReady", new Object[0]);
            FindNearByMapActivity.this.q1 = ((BitmapDrawable) drawable).getBitmap();
            if (this.f12195a) {
                FindNearByMapActivity.this.b4(this.b);
            } else {
                FindNearByMapActivity.this.F2();
            }
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            FindNearByMapActivity.this.G0.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q05.o(FindNearByMapActivity.this.sInstance)) {
                return;
            }
            com.zenmen.palmchat.location.d.g().k(LocationScene.FIND_MAP, FindNearByMapActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements b.a {
        public c0() {
        }

        @Override // com.zenmen.palmchat.activity.find.b.a
        public void a(Object obj) {
            FindNearByMapActivity.this.T0 = false;
            FindNearByMapActivity.this.J3();
            if ((obj instanceof sc3) && ((sc3) obj).b == 1001) {
                xc3.Q(FindNearByMapActivity.this);
                return;
            }
            if (obj instanceof LoadCountBean.MarkerBean) {
                LoadCountBean.MarkerBean markerBean = (LoadCountBean.MarkerBean) obj;
                int i = 2;
                if (markerBean.beanType == 2) {
                    ew1.i0("click", markerBean.uid + "", markerBean.scheduleOrderId);
                    ew1.Q(FindNearByMapActivity.this, markerBean, 0);
                    return;
                }
                FindNearByMapActivity.this.S = markerBean;
                if (markerBean.beanType != 1) {
                    return;
                }
                if (markerBean.isBlur) {
                    FindNearByMapActivity.this.P2(true, 2);
                } else {
                    FindNearByMapActivity.this.W2(markerBean);
                }
                boolean z = markerBean.isBlur;
                if (!z) {
                    i = 1;
                } else if (markerBean.userKind == 1) {
                    i = 4;
                }
                if (!z && markerBean.userKind == 1) {
                    i = 3;
                }
                HashMap map = new HashMap();
                map.put("type", Integer.valueOf(i));
                if (FindNearByMapActivity.this.W0 != null && markerBean.getLatLng() != null) {
                    map.put("distance", Float.valueOf(AMapUtils.calculateLineDistance(new LatLng(FindNearByMapActivity.this.W0.getLatitude(), FindNearByMapActivity.this.W0.getLongitude()), markerBean.getLatLng())));
                }
                zn6.j("page_mapfinder_clickheadportrait", null, map);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements View.OnTouchListener {
        public d0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogUtil.d("", "mapFindX allTouchLayout onTouch motionEvent " + motionEvent.getAction());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            FindNearByMapActivity.this.T0 = true;
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements View.OnClickListener {
        public f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ew1.j0();
            if (FindNearByMapActivity.this.z0.getVisibility() == 0) {
                ew1.X();
                FindNearByMapActivity.this.z0.setVisibility(8);
            }
            FindNearByMapActivity findNearByMapActivity = FindNearByMapActivity.this;
            ew1.c0(findNearByMapActivity, findNearByMapActivity.B0, FindNearByMapActivity.this.A0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements RequestListener<GifDrawable> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends Animatable2Compat.AnimationCallback {
            public a() {
            }

            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                FindNearByMapActivity.this.C0.setVisibility(8);
                FindNearByMapActivity.this.N0 = true;
            }
        }

        public g() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
            gifDrawable.setLoopCount(1);
            gifDrawable.registerAnimationCallback(new a());
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
            FindNearByMapActivity.this.C0.setVisibility(8);
            FindNearByMapActivity.this.N0 = true;
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pc3 f12209a;

        public h(pc3 pc3Var) {
            this.f12209a = pc3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l50.a() && FindNearByMapActivity.this.C0.getVisibility() == 8) {
                FindNearByMapActivity.this.c3(this.f12209a.f19991a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements View.OnTouchListener {
        public h0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogUtil.d("", "allGuideRowCLayout onTouch ");
            FindNearByMapActivity.this.J3();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.b("page_mapfinder_postitinerary");
            ew1.Y();
            ew1.R(FindNearByMapActivity.this);
            FindNearByMapActivity.this.v0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ew1.Y();
            ew1.R(FindNearByMapActivity.this);
            FindNearByMapActivity.this.v0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ um2 f12214a;
        public final /* synthetic */ String b;

        public k(um2 um2Var, String str) {
            this.f12214a = um2Var;
            this.b = str;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            LogUtil.d("MapPendantManager", "getSelfPendantBitmap onResourceReady pendantUrl " + this.b);
            try {
                FindNearByMapActivity.this.r1 = ((BitmapDrawable) drawable).getBitmap();
                um2 um2Var = this.f12214a;
                if (um2Var == null) {
                    return false;
                }
                um2Var.a(FindNearByMapActivity.this.r1);
                return false;
            } catch (Exception unused) {
                um2 um2Var2 = this.f12214a;
                if (um2Var2 == null) {
                    return false;
                }
                um2Var2.b();
                return false;
            }
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            um2 um2Var = this.f12214a;
            if (um2Var == null) {
                return false;
            }
            um2Var.b();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindNearByMapActivity.this.k0.setVisibility(8);
            LogUtil.d("MapPendantManager", "initPendantView pendantClose click");
            SPUtil.f14322a.v(SPUtil.SCENE.SQUARE, "key_map_pendant_close", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FindMapActiveConf f12216a;

        public m(FindMapActiveConf findMapActiveConf) {
            this.f12216a = findMapActiveConf;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || TextUtils.isEmpty(this.f12216a.url)) {
                return;
            }
            LogUtil.d("MapPendantManager", "initPendantView pendantAllLayout click");
            zn6.c("page_mapfinder_lowerright_Adbutton", "click");
            ve.o(FindNearByMapActivity.this, this.f12216a.url, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements ky<Boolean> {
        public p() {
        }

        @Override // defpackage.ky
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            FindNearByMapActivity.this.H2(bool.booleanValue());
            FindNearByMapActivity.this.N2();
            dw4.a("page_mapfinder_showheadset_setup", bool.booleanValue() ? 1 : 0);
        }

        @Override // defpackage.ky
        public void onCancel() {
            FindNearByMapActivity.this.P3();
            dw4.a("page_mapfinder_showheadset_setup", 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements mc3 {
        public q() {
        }

        @Override // defpackage.mc3
        public void a(boolean z) {
            if (z) {
                return;
            }
            FindNearByMapActivity.this.N2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements ky<Boolean> {
        public r() {
        }

        @Override // defpackage.ky
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            FindNearByMapActivity.this.H2(true);
            FindNearByMapActivity.this.N2();
        }

        @Override // defpackage.ky
        public void onCancel() {
            FindNearByMapActivity.this.c4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends MaterialDialog.e {
        public s() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12223a;

        public t(int i) {
            this.f12223a = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            zn6.b("page_mapfinder_closeproximitypopup_cancel");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            FindNearByMapActivity.this.P2(false, this.f12223a);
            zn6.b("page_mapfinder_closeproximitypopup_confirm");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends HashMap<String, Object> {
        public u() {
            put("from", Integer.valueOf(FindNearByMapActivity.this.P));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements wc3 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TextView textView = (TextView) FindNearByMapActivity.this.findViewById(R.id.map_finder_separation_intro);
                TextView textView2 = (TextView) FindNearByMapActivity.this.findViewById(R.id.map_finder_confirm_intro);
                LogUtil.d("", "setChargeData onSeparationModel unlockBtnTitle:" + vc3.f21404a + " clonedBtnTitle " + vc3.b + " isUnlockFree " + dw1.i);
                if (textView != null) {
                    textView.setText(vc3.b);
                }
                if (textView2 == null || dw1.i) {
                    return;
                }
                textView2.setText(vc3.f21404a);
            }
        }

        public v() {
        }

        @Override // defpackage.wc3
        public void a(MapSeparationModel mapSeparationModel) {
            FindNearByMapActivity.this.I2();
        }

        @Override // defpackage.wc3
        public void b(MapSeparationModel mapSeparationModel) {
            LogUtil.d("MapSeparationManager", "MapSeparationCallBack onSeparationModel model:" + mapSeparationModel);
            if (mapSeparationModel != null) {
                if (vc3.b()) {
                    FindNearByMapActivity.this.R0.post(new a());
                }
                FindNearByMapActivity.this.P0 = true;
                int i = mapSeparationModel.status;
                boolean z = i == 1;
                int i2 = mapSeparationModel.bean;
                if (i2 > 0) {
                    xc3.c = i2;
                }
                LogUtil.d("MapSeparationManager", "MapSeparationCallBack onSeparationModel status:" + mapSeparationModel.status + " hour:" + mapSeparationModel.durationSeconds + " cost:" + mapSeparationModel.bean + " isSeparation " + z + " ll " + mapSeparationModel.latitude + " lt " + mapSeparationModel.longitude + " mSeparationLoseTextBean " + xc3.c + " isFromOldNearby " + FindNearByMapActivity.this.Z0 + " from " + FindNearByMapActivity.this.P + " lastDriftLocation " + FindNearByMapActivity.this.Y0);
                if (mapSeparationModel.latitude != 0.0d && mapSeparationModel.longitude != 0.0d) {
                    LocationEx locationEx = new LocationEx();
                    locationEx.setLatitude(mapSeparationModel.latitude);
                    locationEx.setLongitude(mapSeparationModel.longitude);
                    FindNearByMapActivity.this.O0 = locationEx;
                    FindNearByMapActivity.this.b4(locationEx);
                }
                FindNearByMapActivity.this.M2(z);
                FindNearByMapActivity.this.l1 = z;
                FindNearByMapActivity.this.Y.setText(FindNearByMapActivity.this.getString(R.string.map_separation_lose_text2, Integer.valueOf(xc3.c)));
                FindNearByMapActivity.this.k3();
                if (FindNearByMapActivity.this.Z0 && i == -100) {
                    xc3.R(FindNearByMapActivity.this, 0);
                }
                FindNearByMapActivity.this.Q2("onSeparationModel");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements Runnable {
        public w() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FindNearByMapActivity.this.X0 == null) {
                return;
            }
            FindNearByMapActivity.this.L.p(FindNearByMapActivity.this.X0, FindNearByMapActivity.this.a1, FindNearByMapActivity.this.r);
            FindNearByMapActivity findNearByMapActivity = FindNearByMapActivity.this;
            if (!findNearByMapActivity.O || findNearByMapActivity.N) {
                if (dw1.l()) {
                    FindNearByMapActivity.this.G0.setVisibility(8);
                } else {
                    FindNearByMapActivity.this.A.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x extends TimerTask {
        public x() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FindNearByMapActivity.this.k1 = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements a.InterfaceC1055a {
        public y() {
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            LogUtil.d("", "FindMapPayManager startCharge result success " + z);
            if (dw1.m() && z) {
                dw1.H(FindNearByMapActivity.this, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseNetBean f12230a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ MaterialDialog d;
        public final /* synthetic */ View e;
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ View g;
        public final /* synthetic */ View h;

        public z(BaseNetBean baseNetBean, TextView textView, boolean z, MaterialDialog materialDialog, View view, ImageView imageView, View view2, View view3) {
            this.f12230a = baseNetBean;
            this.b = textView;
            this.c = z;
            this.d = materialDialog;
            this.e = view;
            this.f = imageView;
            this.g = view2;
            this.h = view3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            T t;
            BaseNetBean baseNetBean = this.f12230a;
            if (baseNetBean == null || (t = baseNetBean.data) == 0) {
                return;
            }
            if (view == this.b) {
                dw4.a(baseNetBean.resultCode == 1 ? "page_mapfinder_freetimepopup_cancel" : "page_mapfinder_paytimepopup_cancel", this.c ? 2 : 1);
                this.d.dismiss();
                return;
            }
            if (view == this.e) {
                if (baseNetBean.resultCode != 1 && !((CheckDriftBean) t).enoughBean) {
                    FindNearByMapActivity.this.e4(((CheckDriftBean) t).priceBean);
                } else if (this.c) {
                    FindNearByMapActivity.this.L.r(FindNearByMapActivity.this.S);
                } else {
                    FindNearByMapActivity.this.N3(false);
                }
                if (this.f.isSelected()) {
                    FindNearByMapActivity.this.j4();
                }
                dw4.a(this.f12230a.resultCode == 1 ? "page_mapfinder_freetimepopup_lookfor" : "page_mapfinder_paytimepopup_lookfor", this.c ? 2 : 1);
                this.d.dismiss();
                return;
            }
            if (view == this.g) {
                this.f.setSelected(!r7.isSelected());
            } else if (view == this.h) {
                HashMap map = new HashMap();
                if (((CheckDriftBean) this.f12230a.data).vipLevel == 0) {
                    map.put("type", 2);
                    ap3.a().w(FindNearByMapActivity.this, "64", "1");
                } else {
                    ap3.a().w(FindNearByMapActivity.this, "64", "0");
                    map.put("type", 1);
                }
                zn6.j("page_mapfinder_paytimepopup_memberguide_click", "click", map);
                this.d.dismiss();
            }
        }
    }

    public static void I3(Context context, LocationEx locationEx, boolean z2, boolean z3, int i2, int i3, int i4) {
        Intent intent = new Intent(context, (Class<?>) FindNearByMapActivity.class);
        intent.putExtra("key_last_drift_location", locationEx);
        intent.putExtra("KEY_IS_FROM_OLD_NEARBY", z2);
        intent.putExtra("KEY_IS_SHOW_SEPARATION_DIALOG", z3);
        intent.putExtra("KEY_CLICK_TYPE", i2);
        intent.putExtra("KEY_CLICK_POPTYPE", i3);
        intent.putExtra("KEY_FROM", i4);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n3() {
        return Boolean.valueOf(this.o1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o3() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p3() {
        return this.X0;
    }

    public static /* synthetic */ Object q3() {
        return 1;
    }

    public static /* synthetic */ Object r3() {
        return 2;
    }

    public static /* synthetic */ Object s3() {
        return 3;
    }

    public static /* synthetic */ Object t3() {
        return 4;
    }

    public static /* synthetic */ Object u3() {
        return 5;
    }

    public static /* synthetic */ Object v3() {
        return 1;
    }

    public void A3(LocationEx locationEx) {
        ad3 ad3Var;
        if (!xc3.I() || locationEx == null || (ad3Var = this.r) == null) {
            return;
        }
        ad3Var.b(locationEx, 1L);
    }

    @Override // defpackage.tc3
    public void B(boolean z2, BaseNetBean<CheckDriftBean> baseNetBean, boolean z3) {
        CheckDriftBean checkDriftBean;
        if (baseNetBean == null || (checkDriftBean = baseNetBean.data) == null) {
            return;
        }
        if (baseNetBean.resultCode != 1 && !checkDriftBean.enoughBean) {
            if (z3) {
                e4(checkDriftBean.priceBean);
            }
        } else if (z2) {
            this.L.r(this.S);
        } else {
            N3(false);
        }
    }

    public final void B3() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.Y0 = (LocationEx) intent.getParcelableExtra("key_last_drift_location");
        this.Z0 = intent.getBooleanExtra("KEY_IS_FROM_OLD_NEARBY", false);
        this.V = intent.getBooleanExtra("KEY_IS_SHOW_SEPARATION_DIALOG", false);
        this.T = intent.getIntExtra("KEY_CLICK_TYPE", 0);
        this.U = intent.getIntExtra("KEY_CLICK_POPTYPE", 0);
        int intExtra = intent.getIntExtra("KEY_FROM", 0);
        this.P = intExtra;
        ew1.h = intExtra;
        this.N = this.Y0 != null;
        b05.d("mFrom====》" + this.P);
        zn6.j("page_mapfinder", "view", new u());
    }

    public final void C3(int i2) {
        if (this.X0 == null) {
            return;
        }
        if (this.W0 != null && AMapUtils.calculateLineDistance(new LatLng(this.X0.getLatitude(), this.X0.getLongitude()), new LatLng(this.W0.getLatitude(), this.W0.getLongitude())) < 1.0f) {
            a4();
            return;
        }
        zn6.b("page_mapfinder_lookforpeoplenearby");
        if (this.Y0 == null || AMapUtils.calculateLineDistance(new LatLng(this.X0.getLatitude(), this.X0.getLongitude()), new LatLng(this.Y0.getLatitude(), this.Y0.getLongitude())) >= 1000.0f) {
            P2(false, i2);
        } else {
            Q3(i2);
        }
    }

    public void D3() {
        G3();
    }

    public final void E3() {
        double latitude;
        double longitude;
        LocationEx locationEx;
        if (this.X0 != null) {
            ed3 ed3Var = this.j0;
            if (ed3Var == null || (locationEx = ed3Var.b) == null) {
                latitude = -1.0d;
                longitude = -1.0d;
            } else {
                latitude = locationEx.getLatitude();
                longitude = locationEx.getLongitude();
            }
            if (longitude == this.X0.getLongitude() && latitude == this.X0.getLatitude()) {
                ry5.a("该定位已设置分身头像，请勿重复操作");
                return;
            }
            b4(this.X0);
            String str = xc3.k;
            if (TextUtils.isEmpty(str)) {
                LogUtil.d("MapGDConfig", "onSeparationEffectClick curAddess null getRealAddress start");
                dw1.F("MapActivity onSeparationEffectClick", com.zenmen.palmchat.c.b(), new o(), this.X0);
            } else {
                xc3.J(this.X0, str);
            }
            ry5.a("分身头像设置成功");
        }
    }

    public final void F2() {
        G2(true);
    }

    public void F3(int i2) {
        LogUtil.d("MapSeparationManager", "FindNearByMapActivity onSeparationLoseClick");
        if (dw1.m()) {
            dw1.o(this, i2);
        } else {
            H3();
        }
    }

    public final void G2(boolean z2) {
        Bitmap bitmap;
        if (this.W0 == null || (bitmap = this.q1) == null) {
            return;
        }
        if (bitmap.isRecycled()) {
            w3(false, null);
            return;
        }
        ma3.a("addMarkToSelfLocation", new Object[0]);
        Bitmap bitmapR2 = R2(this.q1);
        ed3 ed3Var = this.s1;
        if (ed3Var != null) {
            this.r.o(ed3Var);
        }
        if (yg4.a(this.Q, 32768)) {
            this.s1 = this.r.q(bitmapR2, this.W0, 0.5f, 0.4f, 4.0f);
        }
    }

    public final void G3() {
        LogUtil.d("MapSeparationManager", "mapFindX FindNearByMapActivity onSeparationLoseLayoutClose");
        View view = this.X;
        if (view != null && view.getVisibility() == 0) {
            this.X.setVisibility(8);
        }
        if (dw1.l()) {
            if (this.E <= 0) {
                this.F0.setVisibility(0);
                this.E0.setVisibility(8);
                return;
            } else {
                this.F0.setVisibility(8);
                this.E0.setVisibility(0);
                dw1.O("view");
                return;
            }
        }
        if (this.E > 0) {
            TextView textView = this.z;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view2 = this.C;
            if (view2 != null) {
                view2.setVisibility(0);
                dw1.O("view");
                return;
            }
            return;
        }
        TextView textView2 = this.z;
        if (textView2 != null && textView2.getVisibility() == 8) {
            this.z.setVisibility(0);
        }
        View view3 = this.C;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final void H2(boolean z2) {
        LogUtil.d("FindMap", "avatarSwitch " + z2);
        if (z2 == yg4.a(this.Q, 32768)) {
            return;
        }
        this.L.x(z2);
        SquareSingleton.getInstance().getUsedTagHelper().b(2L);
    }

    public final void H3() {
        if (this.X.getVisibility() == 8) {
            this.X.setVisibility(0);
            zn6.b("page_mapfinder_setanotherme_setpopup");
        }
        if (dw1.l()) {
            this.F0.setVisibility(8);
            this.E0.setVisibility(8);
            return;
        }
        if (this.z.getVisibility() == 0) {
            this.z.setVisibility(8);
        }
        if (this.C.getVisibility() == 0) {
            this.C.setVisibility(8);
        }
    }

    public final void I2() {
        LogUtil.d("MapSeparationManager", "FindNearByMapActivity buySeparationSuccess");
        xc3.S(this);
        b4(this.X0);
        M2(true);
    }

    public final float J2() {
        if (this.d1 <= 0.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.d1 = displayMetrics.heightPixels / displayMetrics.ydpi;
        }
        try {
            return this.r instanceof yo ? L2() : K2();
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.a1;
        }
    }

    public final void J3() {
        FrameLayout frameLayout;
        if (this.N0 && (frameLayout = this.M0) != null && frameLayout.getVisibility() == 0) {
            this.M0.setVisibility(8);
        }
    }

    public final float K2() {
        VisibleRegion visibleRegion = ((MapView) this.r.p()).getMap().getProjection().getVisibleRegion();
        return AMapUtils.calculateLineDistance(visibleRegion.farLeft, visibleRegion.nearLeft) / (this.d1 * 2.54f);
    }

    public final void K3() {
        ed3 ed3Var = this.j0;
        if (ed3Var != null) {
            this.r.o(ed3Var);
            this.j0 = null;
        }
    }

    public final float L2() {
        com.baidu.mapapi.map.MapView mapView = (com.baidu.mapapi.map.MapView) this.r.p();
        BaiduMap map = mapView.getMap();
        mapView.getWidth();
        int height = mapView.getHeight();
        return (float) (DistanceUtil.getDistance(map.getProjection().fromScreenLocation(new Point(0, 0)), map.getProjection().fromScreenLocation(new Point(0, height))) / ((double) (this.d1 * 2.54f)));
    }

    public final void L3(LocationEx locationEx, boolean z2) {
        b05.a("resolveSelectedLocation方法调用");
        if (locationEx == null) {
            return;
        }
        float fJ2 = J2();
        if (this.X0 != null && this.a1 != 0.0f) {
            b05.c(new b05.a() { // from class: gw1
                @Override // b05.a
                public final Object getValue() {
                    return FindNearByMapActivity.v3();
                }
            });
            float fCalculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(this.X0.getLatitude(), this.X0.getLongitude()), new LatLng(locationEx.getLatitude(), locationEx.getLongitude()));
            float f2 = fJ2 - this.a1;
            boolean z3 = Math.abs(f2) / this.a1 > 0.3f;
            ma3.a("perCMDistance:" + fJ2 + " lastScaleZoom:" + this.a1 + " scaleChange:" + f2 + " isZoom:" + z3, new Object[0]);
            if (!z2 && !z3 && fCalculateLineDistance < 10.0f) {
                this.a1 = fJ2;
                return;
            }
        }
        this.a1 = fJ2;
        this.X0 = locationEx;
        if (this.b1 && com.zenmen.palmchat.location.c.b().nearbyLocationShow) {
            LogUtil.d(AliMapConfig.TAG, "nearbyLocationShow is true 允许获取逆地理编码服务");
            if (TextUtils.isEmpty(locationEx.getAddress())) {
                this.q.h(locationEx);
            } else {
                onRegeocodeSearched(locationEx.getAddress());
            }
        } else {
            LogUtil.d(AliMapConfig.TAG, "nearbyLocationShow is false 不允许获取逆地理编码服务");
            onRegeocodeSearched(locationEx.getAddress());
        }
        this.b1 = true;
        x3();
    }

    @Override // defpackage.d74
    public void M(LocationEx locationEx) {
        com.zenmen.palmchat.activity.find.b bVar = this.M;
        if (bVar != null) {
            bVar.M(locationEx);
        }
        L3(locationEx, this.O);
        View view = this.H0;
        if (view != null && view.getVisibility() == 0) {
            this.H0.setVisibility(8);
        }
        if (this.T0) {
            y3();
        }
        this.T0 = false;
    }

    public void M2(boolean z2) {
        if (this.f0 == null || this.g0 == null) {
            return;
        }
        LogUtil.d("MapSeparationManager", "FindNearByMapActivity changeSeparationBtn isSeparation:" + z2);
        if (z2) {
            this.f0.setVisibility(8);
            this.g0.setVisibility(0);
        } else {
            this.f0.setVisibility(0);
            this.g0.setVisibility(8);
            K3();
        }
    }

    public final void M3(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("page_mapfinder_setanotherme", null, jSONObject.toString());
    }

    public final void N2() {
        if (this.x0) {
            X3();
        }
    }

    public final void N3(boolean z2) {
        if (!z2) {
            ap3.a().a0(this, (dw1.l() && UserrecommendTabs230414Config.getUserrecommendTabs230414Config().mapfinder.show_Switch) ? "zenxin://activity?page=a0406&openMap=false&subTabName=mapfinder" : "zenxin://activity?page=a0406&openMap=false");
        }
        ConditionHelper.getInstance().setDriftInfo(this.X0, true, !z2, 0);
        if (z2) {
            return;
        }
        finish();
    }

    public final void O2() {
        SPUtil.f14322a.v(SPUtil.SCENE.SQUARE, "key_active_close", Long.valueOf(System.currentTimeMillis()));
        g4(null, true);
    }

    public void O3(LocationEx locationEx) {
        if (locationEx != null) {
            this.r.b(locationEx, 100L);
        }
    }

    @Override // defpackage.tc3
    public void P() {
        xc3.x(this.S0, this, this.X0);
    }

    public final void P2(boolean z2, int i2) {
        showSimpleProgressBar();
        this.L.m(T2(z2), z2, i2);
    }

    public final void P3() {
        AgreementDialog agreementDialog = new AgreementDialog(this, new r());
        agreementDialog.w(false);
        agreementDialog.show();
    }

    @Override // bw1.f
    public void Q0(BaseNetBean<CheckDriftBean> baseNetBean, boolean z2, int i2) {
        LocationEx locationEx;
        if (isFinishing() || isDestroyed() || baseNetBean == null) {
            return;
        }
        hideSimpleProgressBar();
        if (!dw1.m()) {
            if (!baseNetBean.isSuccess()) {
                int i3 = baseNetBean.resultCode;
                if (i3 == 1 || i3 == 2) {
                    Y3(baseNetBean, z2);
                    return;
                } else {
                    ry5.a(baseNetBean.getErrMsg());
                    return;
                }
            }
            CheckDriftBean checkDriftBean = baseNetBean.data;
            if (checkDriftBean != null) {
                if (!checkDriftBean.enoughBean) {
                    e4(checkDriftBean.priceBean);
                    return;
                } else if (z2) {
                    this.L.r(this.S);
                    return;
                } else {
                    N3(false);
                    return;
                }
            }
            return;
        }
        CheckDriftBean checkDriftBean2 = baseNetBean.data;
        if (checkDriftBean2 != null) {
            if (checkDriftBean2.tipStatus) {
                if (!checkDriftBean2.enoughBean) {
                    e4(checkDriftBean2.priceBean);
                    return;
                } else if (z2) {
                    this.L.r(this.S);
                    return;
                } else {
                    N3(false);
                    return;
                }
            }
            String strA = a46.a(this.X0, this.W0);
            String str = xc3.k;
            if (!com.zenmen.palmchat.location.c.b().unlockLocation) {
                LogUtil.d(AliMapConfig.TAG, "unlockLocation is false 解锁附近的人不去获取逆地理编码服务");
                dw1.j0(baseNetBean, this, strA, "", z2, this, i2, this.E);
                return;
            }
            if (!z2) {
                if (TextUtils.isEmpty(str)) {
                    dw1.A(this, this.X0, strA, baseNetBean, z2, this, i2, this.E);
                    return;
                } else {
                    dw1.j0(baseNetBean, this, strA, str, z2, this, i2, this.E);
                    return;
                }
            }
            LoadCountBean.MarkerBean markerBean = this.S;
            if (markerBean != null) {
                String strA2 = a46.a(markerBean.getLocationEx(), this.W0);
                locationEx = this.S.getLocationEx();
                strA = strA2;
            } else {
                locationEx = null;
            }
            dw1.A(this, locationEx, strA, baseNetBean, z2, this, i2, this.E);
        }
    }

    public final void Q2(String str) {
        int i2 = this.P;
        if (i2 == 8 || i2 == 9) {
            LogUtil.d("MapSeparationManager", "MapSeparationCallBack onSeparationModel feedUserFromCheck mapSeparationDone " + this.P0 + " onLocationReceivedDone " + this.Q0 + " typeName " + str);
            if (this.P0 && this.Q0) {
                if (!this.l1) {
                    LocationEx locationEx = this.Y0;
                    if (locationEx != null) {
                        this.r.b(locationEx, 50L);
                    }
                    j1(this.P == 9 ? 6 : 5);
                    return;
                }
                LocationEx locationEx2 = this.Y0;
                if (locationEx2 != null) {
                    this.r.b(locationEx2, 50L);
                    return;
                }
                LocationEx locationEx3 = this.O0;
                if (locationEx3 != null) {
                    this.r.b(locationEx3, 50L);
                }
            }
        }
    }

    public final void Q3(int i2) {
        new sd3(this).U("温馨提示").k("本次解锁和当前已解锁位置距离较近，请确认是否继续？").O(R.string.dialog_confirm).L("再看看").f(new t(i2)).u().e().show();
        zn6.b("page_mapfinder_closeproximitypopup");
    }

    public final Bitmap R2(Bitmap bitmap) {
        int iB = a46.b(this, 68.0f);
        int iB2 = a46.b(this, 72.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, Bitmap.Config.ARGB_8888);
        Bitmap bitmapS2 = S2();
        int iB3 = iB2 - a46.b(this, 8.0f);
        int iMin = Math.min(bitmap.getHeight(), bitmap.getWidth());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * iB3) / iMin, (iB3 * bitmap.getHeight()) / iMin, false);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmapS2, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateScaledBitmap, tileMode, tileMode));
        canvas.drawCircle(a46.b(this, 34.0f), a46.b(this, 32.0f), a46.b(this, 26.0f), paint);
        if (vc3.c()) {
            LogUtil.d("MapPendantManager", "genAvatarMark pendantBitmap " + this.r1);
            Bitmap bitmap2 = this.r1;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(this.r1, iB, iB2, false);
                canvas.drawBitmap(bitmapCreateScaledBitmap2, 0.0f, 0.0f, (Paint) null);
                bitmapCreateScaledBitmap2.recycle();
            }
        }
        bitmapCreateScaledBitmap.recycle();
        bitmapS2.recycle();
        return bitmapCreateBitmap;
    }

    public final void R3() {
        if (this.U0) {
            return;
        }
        this.U0 = true;
        if (dw1.l() && dw1.n()) {
            try {
                T3();
                U3();
                dw1.c0();
                dw1.u("view");
            } catch (Exception e2) {
                LogUtil.d("", "moveguide showGuideLayout Exception " + e2.toString());
            }
        }
    }

    public final Bitmap S2() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.bg_self_map_location);
    }

    public final void S3(Bitmap bitmap, pc3 pc3Var) {
        if (bitmap == null || pc3Var == null || pc3Var.b == null || pc3Var.f19991a == null) {
            return;
        }
        View view = new View(this);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        view.setBackground(new BitmapDrawable(bitmap));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        Point point = pc3Var.b;
        layoutParams.topMargin = point.y - (width / 2);
        layoutParams.leftMargin = point.x - (height / 2);
        this.M0.addView(view, layoutParams);
        view.setOnClickListener(new h(pc3Var));
    }

    public final LocationEx T2(boolean z2) {
        LoadCountBean.MarkerBean markerBean;
        LocationEx locationEx = this.X0;
        return (!z2 || (markerBean = this.S) == null) ? locationEx : markerBean.getLocationEx();
    }

    public final void T3() {
        this.C0.setVisibility(0);
        Glide.with((FragmentActivity) this).asGif().load2(Integer.valueOf(R.drawable.map_find_guide_gif_bg)).addListener(new g()).into(this.D0);
    }

    public final void U2(um2 um2Var) {
        if (vc3.c()) {
            try {
                String strV2 = V2();
                LogUtil.d("MapPendantManager", "getSelfPendantBitmap start pendantUrl " + strV2);
                if (TextUtils.isEmpty(strV2)) {
                    return;
                }
                hc2.b(this).load(strV2).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new k(um2Var, strV2)).preload();
            } catch (Exception unused) {
            }
        }
    }

    public final void U3() {
        List<pc3> listZ;
        pc3[] pc3VarArrL = bw1.l(this.r, 7, 5);
        if (pc3VarArrL == null || pc3VarArrL.length <= 0 || (listZ = dw1.z(pc3VarArrL)) == null || listZ.size() != 3) {
            return;
        }
        this.M0.setVisibility(0);
        Bitmap bitmapR = dw1.r(dw1.r, "guideType13");
        if (bitmapR != null) {
            S3(bitmapR, listZ.get(0));
        }
        Bitmap bitmapR2 = dw1.r(dw1.s, "guideType35");
        if (bitmapR2 != null) {
            S3(bitmapR2, listZ.get(1));
        }
        Bitmap bitmapR3 = dw1.r(dw1.t, "guideType42");
        if (bitmapR3 != null) {
            S3(bitmapR3, listZ.get(2));
        }
    }

    public final String V2() {
        Amulet amulet;
        if (v4.f() == null || (amulet = v4.f().getAmulet()) == null) {
            return "";
        }
        String str = amulet.url;
        if (TextUtils.isEmpty(str) || !str.endsWith("svga")) {
            return str;
        }
        String strReplace = str.replace(".svga", ".png");
        LogUtil.d("MapPendantManager", "getSelfPendantPngUrl pendantUrl " + strReplace);
        return strReplace;
    }

    public final void V3() {
        this.F.setVisibility(8);
        this.J0.setVisibility(0);
        try {
            new c15(this).n("map_find_guide_center_s1.svga", new e(), new f());
        } catch (Exception unused) {
        }
    }

    public final void W2(LoadCountBean.MarkerBean markerBean) {
        int i2;
        int i3;
        if (markerBean.userKind == 1) {
            i2 = 5023;
            i3 = 85;
        } else {
            i2 = ErrorCode.AD_TYPE_DEPRECATED;
            i3 = 80;
        }
        z66.f(markerBean.uid + "", null, markerBean.gender, 60, i2, i3, this);
    }

    public final void W3() {
        this.F.setVisibility(8);
        this.K0.setVisibility(0);
        try {
            new c15(this).n("map_find_guide_center_s2.svga", new c(), new d());
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // bw1.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X0(BaseNetBean<LoadCountBean> baseNetBean, boolean z2) {
        int i2;
        View view;
        b3();
        if (isFinishing() || isDestroyed() || this.M == null) {
            return;
        }
        R3();
        if (baseNetBean.isSuccess()) {
            LoadCountBean loadCountBean = baseNetBean.data;
            if (loadCountBean != null) {
                i2 = loadCountBean.nearbyCount;
                if (loadCountBean.nearbyList != null && loadCountBean.nearbyList.size() > 0) {
                    baseNetBean.data.nearbyList.get(0);
                }
                if (baseNetBean.data.nearbyAvatar != null) {
                    for (int i3 = 0; i3 < baseNetBean.data.nearbyAvatar.size(); i3++) {
                        baseNetBean.data.nearbyAvatar.get(i3);
                    }
                }
                this.M.v(baseNetBean.data.nearbyAvatar);
                this.M.K0(baseNetBean.data.nearbyList);
                ew1.O(baseNetBean.data.nearbySchedule, this.X0, this.a1, this.r.p(), this.M);
            }
            this.e1 = true;
            this.O = false;
            this.E = i2;
            this.L.v(i2);
            this.z.setText(i2 <= 0 ? getString(R.string.find_map_load_count, Integer.valueOf(i2)) : "附近暂无活跃用户");
            if (dw1.l()) {
                this.z.setVisibility(8);
                if (i2 <= 0) {
                    this.F0.setVisibility(0);
                }
            }
            if (this.T == 1 && this.X != null) {
                F3(2);
                this.T = 0;
            }
            if (this.U == 1) {
                P2(false, 4);
                this.U = 0;
            }
            if (dw1.l()) {
                if (this.X0 == null || this.A.getVisibility() == 0) {
                    return;
                }
            } else if (this.X0 == null || this.G0.getVisibility() == 0) {
                return;
            }
            view = this.X;
            if (view != null || view.getVisibility() == 8) {
                if (!dw1.l()) {
                    if (this.E > 0) {
                        this.F0.setVisibility(8);
                        this.E0.setVisibility(0);
                        dw1.O("view");
                        this.I0.setText(i2 + "");
                    } else {
                        this.F0.setVisibility(0);
                        this.E0.setVisibility(8);
                    }
                    this.H0.setVisibility(8);
                } else if (this.E > 0) {
                    this.z.setVisibility(8);
                    this.C.setVisibility(0);
                    dw1.O("view");
                    this.B.setText(i2 + "");
                } else {
                    this.z.setVisibility(0);
                    this.C.setVisibility(8);
                }
            }
            this.N = false;
            if (this.x0) {
                X3();
                return;
            }
            return;
        }
        ry5.a(baseNetBean.getErrMsg());
        i2 = 0;
        this.e1 = true;
        this.O = false;
        this.E = i2;
        this.L.v(i2);
        this.z.setText(i2 <= 0 ? getString(R.string.find_map_load_count, Integer.valueOf(i2)) : "附近暂无活跃用户");
        if (dw1.l()) {
        }
        if (this.T == 1) {
            F3(2);
            this.T = 0;
        }
        if (this.U == 1) {
        }
        if (dw1.l()) {
        }
        view = this.X;
        if (view != null) {
            if (!dw1.l()) {
            }
        }
        this.N = false;
        if (this.x0) {
        }
    }

    public final void X2() {
        LogUtil.d("", "mapFindX111 anim start ");
        this.H0.setVisibility(0);
        this.F0.setVisibility(8);
        this.E0.setVisibility(8);
        this.G0.setVisibility(8);
        V3();
        this.f1 = true;
    }

    public final void X3() {
        if (this.n1) {
            return;
        }
        this.n1 = true;
        this.x0 = false;
        ew1.l(this, getIntent().getStringExtra("key_trip_info"));
    }

    public final void Y2() {
        LogUtil.d("", "mapFindX222 guideAnim2 guideAnimDone1 " + this.f1);
        if (this.f1) {
            this.f1 = false;
            this.F.setImageResource(R.drawable.map_find_guide_center_up_bg);
            this.F.setVisibility(0);
            this.J0.stopAnimation();
            this.J0.clear();
            this.J0.setVisibility(8);
            this.g1 = true;
        }
    }

    public final void Y3(BaseNetBean<CheckDriftBean> baseNetBean, boolean z2) {
        String str;
        CheckDriftBean checkDriftBean;
        View viewInflate = View.inflate(this, R.layout.layout_check_drift_dialog, null);
        MaterialDialog materialDialogE = new sd3(this).p(viewInflate, false).h(true).e();
        materialDialogE.show();
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_msg);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_cancel_btn);
        View viewFindViewById = viewInflate.findViewById(R.id.positive_btn);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.positive_btn_text2);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_dialog_title);
        View viewFindViewById2 = viewInflate.findViewById(R.id.check_layout);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_checkbox);
        View viewFindViewById3 = viewInflate.findViewById(R.id.ll_vip_guide);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_vip_level);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_guide_info);
        z zVar = new z(baseNetBean, textView2, z2, materialDialogE, viewFindViewById, imageView, viewFindViewById2, viewFindViewById3);
        textView2.setOnClickListener(zVar);
        viewFindViewById2.setOnClickListener(zVar);
        viewFindViewById.setOnClickListener(zVar);
        viewFindViewById3.setOnClickListener(zVar);
        textView4.setText(z2 ? "解锁指定头像及其附近用户" : "温馨提示");
        if (baseNetBean.resultCode != 1 || (checkDriftBean = baseNetBean.data) == null) {
            String string = getString(R.string.find_map_dialog_msg_2, Integer.valueOf(baseNetBean.data.priceBean), Integer.valueOf(baseNetBean.data.getValidHour()));
            textView3.setText(getString(R.string.find_map_dialog_price_prompt, Integer.valueOf(baseNetBean.data.priceBean)));
            viewFindViewById2.setVisibility(0);
            if (baseNetBean.data != null) {
                str = baseNetBean.data.priceBean + "连信豆";
            } else {
                str = "";
            }
            textView.setText(a46.d(string, str, Color.parseColor("#14CD64")));
        } else {
            String string2 = getString(R.string.find_map_dialog_msg_1, Integer.valueOf(checkDriftBean.freeCount), Integer.valueOf(baseNetBean.data.priceBean));
            textView3.setText("（本次免费）");
            viewFindViewById2.setVisibility(8);
            if (bw1.o()) {
                String str2 = baseNetBean.data.freeContentTip;
                if (!TextUtils.isEmpty(str2)) {
                    textView.setText(Html.fromHtml(str2));
                }
            } else {
                textView.setText(a46.d(string2, baseNetBean.data.priceBean + "连信豆", Color.parseColor("#14CD64")));
            }
        }
        CheckDriftBean checkDriftBean2 = baseNetBean.data;
        if (checkDriftBean2 == null) {
            return;
        }
        String str3 = baseNetBean.resultCode == 1 ? "page_mapfinder_freetimepopup" : "page_mapfinder_paytimepopup";
        viewFindViewById3.setVisibility((TextUtils.isEmpty(checkDriftBean2.vipText) || baseNetBean.data.vipLevel == 1) ? 8 : 0);
        textView5.setText(baseNetBean.data.vipText);
        if (baseNetBean.data.vipLevel == 0) {
            imageView2.setImageResource(R.drawable.svip_icon_normal);
        } else {
            imageView2.setImageResource(R.drawable.vip_icon_normal);
        }
        dw4.a(str3, z2 ? 2 : 1);
    }

    @Override // bw1.f
    public void Z0(BaseNetBean baseNetBean, boolean z2) {
        if (!baseNetBean.isSuccess()) {
            ry5.a(baseNetBean.getErrMsg());
            return;
        }
        this.Q = yg4.b(this.Q, z2, 32768);
        iq5.j(false, new String[0]);
        G2(false);
        this.L.y(z2);
        h4();
    }

    public final void Z2() {
        LogUtil.d("", "mapFindX333 guideAnimDone2 " + this.g1);
        if (this.g1) {
            this.g1 = false;
            W3();
            this.h1 = true;
        }
    }

    public final void Z3() {
        this.u.setVisibility(0);
        this.u.showKeyboard();
    }

    public final void a3() {
        LogUtil.d("", "mapFindX444 guideAnimDone3 " + this.h1);
        if (this.h1) {
            this.h1 = false;
            this.K0.setVisibility(8);
            this.F.setImageResource(R.drawable.map_find_guide_center_bg);
            this.F.setVisibility(0);
            this.K0.stopAnimation();
            this.K0.clear();
            this.i1 = true;
        }
    }

    public final void a4() {
        new sd3(this).U("温馨提示").k("当前位置附近的人已处于可见状态，建议拖动地图后解锁其他位置附近的人").P("好的").f(new s()).u().e().show();
    }

    public final void b3() {
        if (this.i1) {
            this.i1 = false;
        }
        this.F.setVisibility(0);
        this.F.setImageResource(R.drawable.map_find_guide_center_bg);
        this.K0.setVisibility(8);
        this.f1 = false;
        this.g1 = false;
        this.h1 = false;
        this.i1 = false;
        this.j1 = false;
    }

    public final void b4(LocationEx locationEx) {
        LocationEx locationEx2;
        LogUtil.d("MapSeparationManager", "FindNearByMapActivity showSeparationMark avatarBitmap " + this.q1 + " currentSelectedLocation " + locationEx);
        if (locationEx == null) {
            return;
        }
        Bitmap bitmap = this.q1;
        if (bitmap == null || bitmap.isRecycled()) {
            w3(true, locationEx);
            return;
        }
        Bitmap bitmapA = xc3.A(this.q1, this, this.r1);
        ed3 ed3Var = this.j0;
        if (ed3Var != null) {
            this.r.o(ed3Var);
        }
        ed3 ed3VarE = this.r.e(bitmapA, locationEx, 0.5f, 0.4f, 1.0f, sc3.a(1001));
        this.j0 = ed3VarE;
        if (ed3VarE != null && (locationEx2 = ed3VarE.b) != null) {
            xc3.N(locationEx2);
        }
        this.n0.setVisibility(0);
        LogUtil.d("MapSeparationManager", "FindNearByMapActivity showSeparationMark end separationMarkerEx " + this.j0);
    }

    public final void c3(LocationEx locationEx) {
        LogUtil.d("", "mapFindX moveguide guideItemClick clickValueObj " + locationEx);
        if (locationEx != null) {
            this.r.b(locationEx, 300L);
            J3();
            dw1.u("click");
        }
    }

    public final void c4() {
        SwitchAvatarDialog switchAvatarDialog = new SwitchAvatarDialog(this, new p(), new q());
        switchAvatarDialog.setCanceledOnTouchOutside(true);
        switchAvatarDialog.w(false);
        switchAvatarDialog.show();
        SquareSingleton.getInstance().getUsedTagHelper().b(1L);
        zn6.b("page_mapfinder_showheadset");
    }

    public final void d3() {
        if (com.zenmen.palmchat.location.c.b().surroundingSearch || this.u.getVisibility() != 8) {
            this.u.setVisibility(8);
            this.u.hideKeyboard();
            this.u.resetSearchList();
        }
    }

    public final void d4() {
        AvatarPayBean avatarPayBean;
        BaseNetBean<AvatarPayBean> baseNetBean = this.p1;
        if (baseNetBean == null || (avatarPayBean = baseNetBean.data) == null || avatarPayBean.unlockBy != 2) {
            dd1.a(this, "已为您解锁指定头像及其附近用户", -1);
        } else {
            dd1.a(this, "已使用会员权益为您解锁指定头像及其附近用户", avatarPayBean.remainFreeCount);
        }
        this.p1 = null;
        HashMap map = new HashMap();
        map.put("type", 2);
        zn6.j("mapfinder_findcompletepopup", null, map);
    }

    public void e3() {
        ImageView imageView = this.n0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void e4(long j2) {
        if (!hx3.m(this)) {
            ry5.a("网络好像有点问题，稍后再试");
        } else {
            com.zenmen.palmchat.giftkit.a.a().b(this, of2.f(ew1.h + 8000, 1001, "", 0, "", 0), j2, new y());
        }
    }

    public final void f3() {
        if (gi5.g() != null) {
            if (gi5.g().mapFinder_button != null) {
                MapFinderConfig.FinderButton finderButton = gi5.g().mapFinder_button;
                if (!TextUtils.isEmpty(finderButton.title)) {
                    ((TextView) findViewById(R.id.map_finder_confirm_title)).setText(finderButton.title);
                }
                TextView textView = (TextView) findViewById(R.id.map_finder_confirm_intro);
                if (dw1.m()) {
                    if (vc3.b()) {
                        textView.setText(vc3.f21404a);
                    } else if (!TextUtils.isEmpty(finderButton.newintro)) {
                        textView.setText(finderButton.newintro);
                    }
                } else if (!TextUtils.isEmpty(finderButton.intro)) {
                    textView.setText(finderButton.intro);
                }
            }
            if (gi5.g().setanotherme_button != null) {
                MapFinderConfig.FinderButton finderButton2 = gi5.g().setanotherme_button;
                if (!TextUtils.isEmpty(finderButton2.title)) {
                    ((TextView) findViewById(R.id.map_finder_separation_title)).setText(finderButton2.title);
                }
                TextView textView2 = (TextView) findViewById(R.id.map_finder_separation_intro);
                if (!dw1.m()) {
                    if (TextUtils.isEmpty(finderButton2.intro)) {
                        return;
                    }
                    textView2.setText(finderButton2.intro);
                } else if (vc3.b()) {
                    textView2.setText(vc3.b);
                } else {
                    if (TextUtils.isEmpty(finderButton2.newintro)) {
                        return;
                    }
                    textView2.setText(finderButton2.newintro);
                }
            }
        }
    }

    public final void f4() {
        if (dw1.l()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 30.0f, 0.0f, -30.0f, 0.0f);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.setRepeatCount(1);
            valueAnimatorOfFloat.addUpdateListener(new b());
            valueAnimatorOfFloat.start();
        }
    }

    public final void g3() {
        View viewFindViewById = findViewById(R.id.map_guide_all_layout);
        this.C0 = viewFindViewById;
        viewFindViewById.setOnClickListener(new g0());
        this.D0 = (ImageView) findViewById(R.id.map_guide_gif_jj);
        this.G0 = findViewById(R.id.location_guide_center_bottom_view);
        this.H0 = findViewById(R.id.location_guide_center_ing_view);
        this.E0 = findViewById(R.id.location_guide_count_num_layout);
        this.I0 = (TextView) findViewById(R.id.map_find_guide_near_people_num_text);
        this.F0 = findViewById(R.id.location_guide_near_no_people);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.map_find_guide_rowcolumn_layout);
        this.M0 = frameLayout;
        frameLayout.setOnTouchListener(new h0());
        this.E0.setOnClickListener(this);
        f4();
        SVGAImageView sVGAImageView = (SVGAImageView) findViewById(R.id.iv_center_location_s1);
        this.J0 = sVGAImageView;
        sVGAImageView.setLoops(1);
        this.J0.setCallback(new i0());
        SVGAImageView sVGAImageView2 = (SVGAImageView) findViewById(R.id.iv_center_location_s2);
        this.K0 = sVGAImageView2;
        sVGAImageView2.setLoops(1);
        this.K0.setCallback(new a());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K0.getLayoutParams();
        layoutParams.bottomMargin = (a46.m(this).y / 2) - a46.b(this, 6.0f);
        this.K0.setLayoutParams(layoutParams);
    }

    public final void g4(FindMapActiveConf findMapActiveConf, boolean z2) {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        int i2 = z2 ? 4 : 0;
        this.J.setVisibility(i2);
        this.K.setVisibility(i2);
        if (!z2 && !TextUtils.isEmpty(findMapActiveConf.pic)) {
            try {
                hc2.b(this).load(findMapActiveConf.pic).into(this.J);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (z2) {
            return;
        }
        zn6.c("page_mapfinder_lowerright_Adbutton", "view");
    }

    public final void h3(Bundle bundle) {
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(this, null, LocationScene.FIND_MAP);
        this.q = bVarA;
        bVarA.i(this);
        ad3 ad3VarD = this.q.d();
        this.r = ad3VarD;
        View viewF = ad3VarD.f(this);
        this.r.n(false);
        this.r.k(this);
        ((RelativeLayout) findViewById(R.id.mapview_container)).addView(viewF, new FrameLayout.LayoutParams(-1, -1));
        this.r.onCreate(bundle);
        this.r.g(false);
        this.r.j(this);
        w3(false, null);
        this.u.init(this.q);
        LocationEx locationEx = this.Y0;
        if (locationEx != null) {
            this.r.b(locationEx, 100L);
        }
    }

    public final void h4() {
        this.H.setSelected(yg4.a(this.Q, 32768));
    }

    public final void i3() {
        if (vc3.c()) {
            FindMapActiveConf findMapActiveConfC = gi5.c();
            this.k0 = findViewById(R.id.map_pendant_layout);
            this.l0 = (ImageView) findViewById(R.id.map_pendant_img);
            ImageView imageView = (ImageView) findViewById(R.id.map_pendant_close);
            this.m0 = imageView;
            imageView.setOnClickListener(new l());
            this.k0.setOnClickListener(new m(findMapActiveConfC));
            if (findMapActiveConfC == null || TextUtils.isEmpty(findMapActiveConfC.pic) || TextUtils.isEmpty(findMapActiveConfC.url)) {
                return;
            }
            if (System.currentTimeMillis() - SPUtil.f14322a.k(SPUtil.SCENE.SQUARE, "key_map_pendant_close", 0L) <= findMapActiveConfC.closetime * 60.0f * 60.0f * 1000.0f) {
                LogUtil.d("MapPendantManager", "initPendantView time not allow show pendantAllLayout");
                return;
            }
            LogUtil.d("MapPendantManager", "initPendantView allow show pendantAllLayout");
            this.k0.setVisibility(0);
            zn6.c("page_mapfinder_lowerright_Adbutton", "view");
            try {
                if (findMapActiveConfC.pic.endsWith(".gif")) {
                    Glide.with(getApplicationContext()).asGif().load2(findMapActiveConfC.pic).into(this.l0);
                } else {
                    Glide.with(getApplicationContext()).load2(findMapActiveConfC.pic).into(this.l0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void i4() {
        this.I.setSelected(!ConditionHelper.getInstance().getNearByCond().isDefaultCond());
        if (!uj5.c()) {
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            layoutParams.width = a46.b(this, 10.0f);
            this.I.setLayoutParams(layoutParams);
            this.I.setAlpha(0.0f);
        }
        this.I.setEnabled(uj5.c());
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void j(FindFriendCondition findFriendCondition) {
        x3();
        i4();
    }

    @Override // defpackage.tc3
    public void j1(int i2) {
        dw1.b0(i2);
        H3();
    }

    public final void j3() {
        if (gi5.g() == null || gi5.g().setanotherme_setpopup == null) {
            return;
        }
        MapFinderConfig.SetPopUp setPopUp = gi5.g().setanotherme_setpopup;
        String str = setPopUp.title;
        LogUtil.d("MapPendantManager", "initSeparationBuyView title " + str);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.map_separation_bug_title)).setText(str);
        }
        String str2 = setPopUp.pic1;
        LogUtil.d("MapPendantManager", "initSeparationBuyView img1 " + str2);
        if (!TextUtils.isEmpty(str2)) {
            hc2.a(getApplicationContext()).load(str2).error(R.drawable.map_separation_bug_img1).into((ImageView) findViewById(R.id.map_separation_bug_img1));
        }
        String str3 = setPopUp.pic2;
        LogUtil.d("MapPendantManager", "initSeparationBuyView img2 " + str3);
        if (!TextUtils.isEmpty(str3)) {
            hc2.a(getApplicationContext()).load(str3).error(R.drawable.map_separation_bug_img2).into((ImageView) findViewById(R.id.map_separation_bug_img2));
        }
        String str4 = setPopUp.pic3;
        LogUtil.d("MapPendantManager", "initSeparationBuyView img3 " + str4);
        if (!TextUtils.isEmpty(str4)) {
            hc2.a(getApplicationContext()).load(str4).error(R.drawable.map_separation_bug_img3).into((ImageView) findViewById(R.id.map_separation_bug_img3));
        }
        String str5 = setPopUp.vice_intro;
        LogUtil.d("MapPendantManager", "initSeparationBuyView vice_intro " + str5);
        if (!TextUtils.isEmpty(str5)) {
            ((TextView) findViewById(R.id.map_separation_optimize_buy_desc_title)).setText(str5);
        }
        String str6 = setPopUp.set_button;
        LogUtil.d("MapPendantManager", "initSeparationBuyView set_button " + str6);
        if (TextUtils.isEmpty(str6)) {
            return;
        }
        ((TextView) findViewById(R.id.separation_optimize_button_text)).setText(str6);
    }

    public final void j4() {
        this.L.z();
    }

    public final void k3() {
        if (this.X0 == null || this.l1 || this.U != 2) {
            return;
        }
        this.U = 0;
        this.l1 = true;
        F3(3);
        if (dw1.l()) {
            this.G0.setVisibility(8);
        } else {
            this.A.setVisibility(8);
        }
    }

    public final void l3() {
        if (ew1.K()) {
            TextView textView = (TextView) findViewById(R.id.trip_button_layout);
            this.u0 = textView;
            textView.setOnClickListener(new i());
            this.u0.setText(ew1.f17370a);
            this.u0.setVisibility(0);
            this.v0 = findViewById(R.id.trip_bubble_layout);
            this.w0 = (TextView) findViewById(R.id.map_trip_bubble_btn_title);
            this.v0.setOnClickListener(new j());
            if (!ew1.i()) {
                this.v0.setVisibility(8);
            } else {
                this.v0.setVisibility(0);
                this.w0.setText(ew1.b);
            }
        }
    }

    public final void m3() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.map_find_all_touch_layout);
        this.L0 = frameLayout;
        frameLayout.setOnTouchListener(new d0());
        int iH = me1.h(this) + a46.b(this, 20.0f);
        View viewFindViewById = findViewById(R.id.rl_top_tool_bar);
        this.s = viewFindViewById;
        viewFindViewById.setPadding(0, iH, 0, 0);
        this.w = findViewById(R.id.tv_search_btn);
        ImageView imageView = (ImageView) findViewById(R.id.iv_move_start);
        this.G = imageView;
        imageView.setOnClickListener(this);
        this.w.setOnClickListener(this);
        LocationSearchView locationSearchView = (LocationSearchView) findViewById(R.id.rl_search_layout);
        this.u = locationSearchView;
        locationSearchView.setSurroundingSearch(com.zenmen.palmchat.location.c.b().surroundingSearch);
        this.u.setProxy(this);
        this.x = findViewById(R.id.tv_top_prompt);
        ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = iH;
        TextView textView = (TextView) findViewById(R.id.tv_selected_location_info);
        this.y = textView;
        dw1.f0(textView);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_find_bar_left);
        drawable.setColorFilter(Color.parseColor("#0072FF"), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.y.setCompoundDrawables(drawable, null, null, null);
        this.F = (ImageView) findViewById(R.id.iv_center_location);
        this.z = (TextView) findViewById(R.id.tv_location_count);
        View viewFindViewById2 = findViewById(R.id.tv_location_count_num_layout);
        this.C = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.B = (TextView) findViewById(R.id.tv_location_count_num);
        this.W = findViewById(R.id.btn_confirm_separation_layout);
        View viewFindViewById3 = findViewById(R.id.tv_location_separation_layout);
        this.X = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new e0());
        this.f0 = findViewById(R.id.btn_left_separation);
        this.g0 = findViewById(R.id.btn_left_separation_success);
        this.Z = findViewById(R.id.separation_buy_click);
        this.h0 = (TextView) findViewById(R.id.btn_left_separation_success_text);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_separation_move);
        this.n0 = imageView2;
        imageView2.setOnClickListener(this);
        this.e0 = findViewById(R.id.tv_location_separation_layout_close);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.map_separation_dialog_icon);
        this.i0 = effectiveShapeView;
        effectiveShapeView.setBorderColor(Color.parseColor("#FFFFFF"));
        this.Y = (TextView) findViewById(R.id.separation_lose_text2);
        this.Z.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.t = findViewById(R.id.btn_confirm);
        this.J = (ImageView) findViewById(R.id.iv_active_enter);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_active_close);
        this.K = imageView3;
        imageView3.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.A = (TextView) findViewById(R.id.tv_first_prompt);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.super_expose_tab_enter_shake);
        animationLoadAnimation.setInterpolator(new CycleInterpolator(5.0f));
        animationLoadAnimation.setRepeatCount(1);
        animationLoadAnimation.setDuration(com.igexin.push.config.c.j);
        this.A.startAnimation(animationLoadAnimation);
        View viewFindViewById4 = findViewById(R.id.iv_back);
        this.v = viewFindViewById4;
        viewFindViewById4.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.H = (ImageView) findViewById(R.id.avatar_switch_enter);
        this.I = (ImageView) findViewById(R.id.filter_enter);
        h4();
        i4();
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        g3();
        i4();
        View viewFindViewById5 = findViewById(R.id.iv_center_location_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById5.getLayoutParams();
        layoutParams.bottomMargin = a46.m(this).y / 2;
        viewFindViewById5.setLayoutParams(layoutParams);
        if (dw1.l()) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.F.getLayoutParams();
            layoutParams2.width = a46.b(this, 70.0f);
            layoutParams2.height = a46.b(this, 44.0f);
            this.F.setLayoutParams(layoutParams2);
            this.F.setImageResource(R.drawable.map_find_guide_center_bg);
            this.A.setVisibility(8);
            this.z.setVisibility(8);
            this.C.setVisibility(8);
            this.G0.setVisibility(0);
        }
        this.y0 = findViewById(R.id.trip_nearby_button_layout);
        if (ew1.h0()) {
            LogUtil.d("TripNearByTag", "FindNearByMapActivity initview show nearByLayout ");
            this.y0.setVisibility(0);
            this.z0 = findViewById(R.id.trip_nearby_red_button);
            if (ew1.g()) {
                LogUtil.d("TripNearByTag", "FindNearByMapActivity initview show allowShowNearByRed ");
                this.z0.setVisibility(0);
            } else {
                this.z0.setVisibility(8);
            }
            this.y0.setOnClickListener(new f0());
        }
        this.t = findViewById(R.id.btn_confirm_separation);
        if (xc3.I()) {
            LogUtil.d("MapSeparationManager", "FindNearByMapActivity onCreate taiji allow");
            this.t.setOnClickListener(this);
            xc3.e = this.h0;
            if (!TextUtils.isEmpty(v4.f().getIconURL())) {
                gr2.j().h(v4.f().getIconURL(), this.i0, xc3.D());
            }
            M2(false);
            xc3.M(this.S0, this, 2);
            this.Y.setText(getString(R.string.map_separation_lose_text2, Integer.valueOf(xc3.c)));
        }
        i3();
        j3();
        f3();
        dw1.p(this);
        LogUtil.d("", "initView clickType" + this.T + " popType " + this.U);
        l3();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        View view;
        if (dw1.m() && (view = this.X) != null && view.getVisibility() == 0) {
            G3();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        this.T0 = false;
        if (view == this.v) {
            zn6.b("page_mapfinder_back");
            finish();
            return;
        }
        int i2 = 1;
        if (view == this.t || view == this.C || view == this.E0) {
            if (view == this.C || view == this.E0) {
                dw1.O("click");
                i2 = 3;
            }
            C3(i2);
            return;
        }
        if (view == this.e0) {
            G3();
            zn6.b("page_mapfinder_setanotherme_setpopup_cancel");
            return;
        }
        if (view == this.g0) {
            E3();
            M3(2);
            return;
        }
        if (view == this.f0) {
            F3(1);
            M3(1);
            return;
        }
        if (view == this.Z) {
            G3();
            zn6.b("page_mapfinder_setanotherme_setpopup_set");
            xc3.x(this.S0, this, this.X0);
            return;
        }
        if (view == this.w) {
            Z3();
            zn6.b("page_mapfinder_searchclic");
            return;
        }
        if (view == this.G) {
            LocationEx locationEx = this.W0;
            if (locationEx != null) {
                this.r.c(this.R, locationEx);
                this.r.b(this.W0, 100L);
                this.X0 = null;
                zn6.b("page_mapfinder_comebackbutton");
                dw1.f0(this.y);
                this.y.setVisibility(8);
                if (dw1.l()) {
                    this.G0.setVisibility(0);
                    this.E0.setVisibility(8);
                    this.F0.setVisibility(8);
                } else {
                    this.A.setVisibility(0);
                    this.z.setVisibility(8);
                }
            } else {
                com.zenmen.palmchat.location.d.g().k(LocationScene.FIND_MAP, this);
            }
            this.O = true;
            return;
        }
        if (view == this.n0) {
            if (xc3.C() != null) {
                this.r.c(this.R, xc3.C());
                this.r.b(xc3.C(), 100L);
                zn6.b("page_mapfinder_comebackbutton_another");
                return;
            }
            return;
        }
        if (view == this.H) {
            c4();
            return;
        }
        if (view == this.I) {
            zn6.c("page_mapfinder_screenentry", "click");
            ConditionHelper.openFilterDialog(80, this);
        } else {
            if (view == this.K) {
                O2();
                return;
            }
            if (view == this.J) {
                FindMapActiveConf findMapActiveConfC = gi5.c();
                zn6.c("page_mapfinder_lowerright_Adbutton", "click");
                if (TextUtils.isEmpty(findMapActiveConfC.url)) {
                    return;
                }
                ve.o(this, findMapActiveConfC.url, false);
            }
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        LocationEx locationEx;
        super.onCreate(bundle);
        U2(null);
        setContentView(R.layout.layout_find_nearby_map);
        ds0.a().c(this);
        this.Q = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
        B3();
        bw1 bw1Var = new bw1(yg4.a(this.Q, 32768));
        this.L = bw1Var;
        bw1Var.u(this);
        DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
        if (driftInfo != null && (locationEx = driftInfo.location) != null) {
            this.L.t(locationEx);
        }
        m3();
        h3(bundle);
        if (!SquareSingleton.getInstance().getUsedTagHelper().a(1L) && !yg4.a(this.Q, 32768)) {
            this.x0 = true;
            c4();
        }
        ConditionHelper.getInstance().addConditionChangeListener(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ad3 ad3Var = this.r;
        if (ad3Var != null) {
            ad3Var.onDestroy();
        }
        com.zenmen.palmchat.location.b bVar = this.q;
        if (bVar != null) {
            bVar.r(this);
        }
        this.q1 = null;
        this.r1 = null;
        this.s.removeCallbacks(this.c1);
        ConditionHelper.getInstance().removeConditionChangeListener(this);
        xc3.K();
        com.zenmen.palmchat.activity.find.b bVar2 = this.M;
        if (bVar2 != null) {
            bVar2.onDestroy();
        }
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.fa3
    public void onEvent(int i2, Object obj) {
        if (i2 != 1) {
            return;
        }
        d3();
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        b05.a("onLocationReceived()");
        this.Q0 = true;
        ma3.a("onLocationReceived", new Object[0]);
        if (this.r == null) {
            Q2("onLocationReceived");
            return;
        }
        if (locationEx == null) {
            ry5.a("定位失败");
            Q2("onLocationReceived");
            return;
        }
        if (this.V && xc3.I() && xc3.C() != null) {
            locationEx.setLatitude(xc3.C().getLatitude());
            locationEx.setLongitude(xc3.C().getLongitude());
        }
        this.W0 = locationEx;
        if (this.Y0 == null) {
            this.r.b(locationEx, 1L);
            x3();
        }
        this.L.w(locationEx);
        this.u.updateSelfLocation(locationEx);
        this.u.resetSearchList();
        this.r.g(true);
        this.X0 = locationEx;
        F2();
        Q2("onLocationReceived");
    }

    @Override // com.zenmen.square.ui.widget.LocationSearchView.f
    public void onLocationSelected(LocationEx locationEx) {
        b05.a("onLocationSelected方法调用");
        d3();
        this.r.b(locationEx, 150L);
        L3(locationEx, false);
    }

    @Override // defpackage.yi0
    public void onMapLoaded() {
        if (this.r instanceof yo) {
            u93.b(1000, new b0());
        } else {
            com.zenmen.palmchat.location.d.g().k(LocationScene.FIND_MAP, this);
        }
        int i2 = this.R;
        LogUtil.d("", "onMapLoaded initMapScaling " + this.R + " mapScale " + i2);
        this.r.c((float) i2, this.X0);
        com.zenmen.palmchat.activity.find.b bVarA = fd3.a(this, this.r);
        this.M = bVarA;
        bVarA.O(new c0());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ad3 ad3Var = this.r;
        if (ad3Var != null) {
            ad3Var.onPause();
        }
        this.V0 = true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        b05.d("onPermissionGrant=====>权限申请失败！");
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
        b05.a("onRegeocodeSearched()");
        b05.c(new b05.a() { // from class: hw1
            @Override // b05.a
            public final Object getValue() {
                return this.f18062a.n3();
            }
        });
        b05.c(new b05.a() { // from class: iw1
            @Override // b05.a
            public final Object getValue() {
                return this.f18272a.o3();
            }
        });
        b05.c(new b05.a() { // from class: jw1
            @Override // b05.a
            public final Object getValue() {
                return this.f18525a.p3();
            }
        });
        if (!TextUtils.isEmpty(str)) {
            xc3.k = str;
        }
        if (this.o1 && this.S != null) {
            b05.c(new b05.a() { // from class: kw1
                @Override // b05.a
                public final Object getValue() {
                    return FindNearByMapActivity.q3();
                }
            });
            this.X0 = this.S.getLocationEx();
        }
        if (this.X0 == null) {
            b05.c(new b05.a() { // from class: lw1
                @Override // b05.a
                public final Object getValue() {
                    return FindNearByMapActivity.r3();
                }
            });
            this.y.setVisibility(8);
            this.o1 = false;
            return;
        }
        b05.c(new b05.a() { // from class: mw1
            @Override // b05.a
            public final Object getValue() {
                return FindNearByMapActivity.s3();
            }
        });
        LocationEx locationEx = this.X0;
        xc3.l = locationEx;
        locationEx.setAddress(str);
        if (this.o1) {
            b05.c(new b05.a() { // from class: nw1
                @Override // b05.a
                public final Object getValue() {
                    return FindNearByMapActivity.t3();
                }
            });
            N3(true);
            this.x.setVisibility(0);
            d4();
        }
        b05.c(new b05.a() { // from class: ow1
            @Override // b05.a
            public final Object getValue() {
                return FindNearByMapActivity.u3();
            }
        });
        this.o1 = false;
        ma3.a("setSelectedInfo onRegeocodeSearched address " + str + " hasSelectedInfo " + dw1.E, new Object[0]);
        if (!dw1.E) {
            if (com.zenmen.palmchat.location.c.b().nearbyLocationShow) {
                this.B0 = str;
                this.y.setText(getString(R.string.find_map_selected_info, a46.a(this.X0, this.W0), "", str));
            } else {
                this.A0 = a46.a(this.X0, this.W0);
                this.y.setText("距离你当前位置 " + this.A0);
            }
        }
        dw1.E = false;
        this.y.setVisibility(0);
        if (this.m1 && this.V) {
            this.m1 = false;
            F3(4);
        }
        k3();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        xc3.h = this;
        ad3 ad3Var = this.r;
        if (ad3Var != null) {
            ad3Var.onResume();
        }
        if (this.V0) {
            U2(new n());
        }
        this.V0 = false;
    }

    @Override // bw1.f
    public void q(BaseNetBean<AvatarPayBean> baseNetBean, LoadCountBean.MarkerBean markerBean) {
        if (!baseNetBean.isSuccess()) {
            ry5.a(baseNetBean.getErrMsg());
            this.p1 = null;
            return;
        }
        this.r.b(markerBean.getLocationEx(), 100L);
        this.r.c(this.R, markerBean.getLocationEx());
        this.o1 = true;
        this.p1 = baseNetBean;
        this.L.t(markerBean.getLocationEx());
        this.Y0 = markerBean.getLocationEx();
        LogUtil.d("FindMap", "onPayResult end isUnlockFree " + dw1.i);
        if (dw1.i) {
            dw1.H(this, false);
        }
    }

    @qm5
    public void tripEvent(qw1 qw1Var) {
        if (qw1Var != null) {
            try {
                int i2 = qw1Var.f20336a;
                if (i2 == 2) {
                    double d2 = qw1Var.c;
                    double d3 = qw1Var.d;
                    if (d2 > 0.0d && d3 > 0.0d) {
                        LocationEx locationEx = new LocationEx();
                        locationEx.setLongitude(d3);
                        locationEx.setLatitude(d2);
                        ad3 ad3Var = this.r;
                        if (ad3Var != null) {
                            ad3Var.b(locationEx, 100L);
                            x3();
                        }
                    }
                } else if (i2 == 1) {
                    if (this.M != null && !TextUtils.isEmpty(qw1Var.b)) {
                        this.M.u0(qw1Var.b);
                    }
                } else if (i2 == 3) {
                    if (this.M != null && !TextUtils.isEmpty(qw1Var.b)) {
                        this.M.i(qw1Var.b);
                        x3();
                    }
                } else if (i2 == 4) {
                    x3();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void w3(boolean z2, LocationEx locationEx) {
        LogUtil.d("MapPendantManager", "loadAvatarBitmap start isSeparation " + z2 + " currentSelectedLocation " + this.X0);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        try {
            hc2.b(this).load(v4.f().getIconURL()).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new a0(z2, locationEx)).preload();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x3() {
        this.s.removeCallbacks(this.c1);
        this.s.postDelayed(this.c1, 800L);
    }

    @Override // defpackage.d74
    public void y(LocationEx locationEx) {
        com.zenmen.palmchat.activity.find.b bVar = this.M;
        if (bVar != null) {
            bVar.y(locationEx);
        }
        ma3.a("onMapChange mapOnTouchDown " + this.T0, new Object[0]);
        z3();
        d3();
        if (dw1.l() && this.T0) {
            J3();
            if (this.j1) {
                return;
            }
            this.j1 = true;
            X2();
        }
    }

    public final void y3() {
        if (dw1.l()) {
            Z2();
        }
    }

    public final void z3() {
        if (!this.e1 || this.k1) {
            return;
        }
        this.k1 = true;
        zn6.b("page_mapfinder_movemap");
        new Timer().schedule(new x(), 1000L);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements c15.e {
        public d() {
        }

        @Override // c15.e
        public void onPlay(@NonNull List<? extends File> list) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements View.OnClickListener {
        public e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements c15.e {
        public f() {
        }

        @Override // c15.e
        public void onPlay(@NonNull List<? extends File> list) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements View.OnClickListener {
        public g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void d1(FindFriendCondition findFriendCondition) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements v05 {
        public a() {
        }

        @Override // defpackage.v05
        public void a() {
            FindNearByMapActivity.this.a3();
        }

        @Override // defpackage.v05
        public void c() {
        }

        @Override // defpackage.v05
        public void onPause() {
        }

        @Override // defpackage.v05
        public void b(int i, double d) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c15.d {
        public c() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            FindNearByMapActivity.this.K0.setVideoItem(m15Var);
            FindNearByMapActivity.this.K0.startAnimation();
        }

        @Override // c15.d
        public void onError() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements c15.d {
        public e() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            FindNearByMapActivity.this.J0.setVideoItem(m15Var);
            FindNearByMapActivity.this.J0.startAnimation();
        }

        @Override // c15.d
        public void onError() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements v05 {
        public i0() {
        }

        @Override // defpackage.v05
        public void a() {
            FindNearByMapActivity.this.Y2();
        }

        @Override // defpackage.v05
        public void c() {
        }

        @Override // defpackage.v05
        public void onPause() {
        }

        @Override // defpackage.v05
        public void b(int i, double d) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements um2 {
        public n() {
        }

        @Override // defpackage.um2
        public void a(Bitmap bitmap) {
            FindNearByMapActivity.this.F2();
            if (xc3.B() == null || xc3.B().status != 1 || xc3.C() == null) {
                return;
            }
            FindNearByMapActivity.this.b4(xc3.C());
        }

        @Override // defpackage.um2
        public void b() {
        }
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void H0() {
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void z0() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements i53 {
        public o() {
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            xc3.J(FindNearByMapActivity.this.X0, str);
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i2, List<LocationEx> list, n53 n53Var) {
    }
}

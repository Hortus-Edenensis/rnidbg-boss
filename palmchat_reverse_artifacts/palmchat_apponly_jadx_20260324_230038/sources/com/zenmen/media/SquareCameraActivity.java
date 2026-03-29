package com.zenmen.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.media.SquarePhotoButton;
import com.zenmen.media.SquareRecordButton;
import com.zenmen.media.album.SquareMediaPickActivity;
import com.zenmen.media.camera.OnCameraListener;
import com.zenmen.media.camera.OnLogListener;
import com.zenmen.media.camera.RecorderView;
import com.zenmen.media.camera.ui.HorizontalPicker;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.activity.SquarePublishActivity;
import defpackage.ds0;
import defpackage.fd6;
import defpackage.iv0;
import defpackage.kj5;
import defpackage.l50;
import defpackage.l84;
import defpackage.me1;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.wg4;
import defpackage.zn6;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareCameraActivity extends FrameworkBaseActivity {
    public v E;
    public Bitmap J;
    public LocationEx N;
    public View Y;
    public HorizontalPicker Z;
    public SquarePhotoButton e0;
    public View f0;
    public View g0;
    public View h0;
    public GestureDetector j0;
    public RelativeLayout q;
    public ValueAnimator q0;
    public SquareRecordButton s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public boolean x;
    public RecorderView r = null;
    public int w = 0;
    public boolean y = false;
    public int z = 720;
    public int A = 1416;
    public String B = null;
    public long C = 0;
    public int F = 0;
    public int G = 0;
    public boolean H = false;
    public int I = -1;
    public boolean K = false;
    public boolean L = false;
    public boolean M = true;
    public long O = 0;
    public long P = 0;
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;
    public boolean T = false;
    public boolean U = false;
    public boolean V = false;
    public boolean W = false;
    public boolean X = false;
    public boolean i0 = false;
    public long k0 = 0;
    public GestureDetector.SimpleOnGestureListener l0 = new k();
    public Runnable m0 = new e();
    public Runnable n0 = new g();
    public OnCameraListener o0 = new i();
    public OnLogListener p0 = new j();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wg4.a(SquareCameraActivity.this).f(true, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wg4.a(SquareCameraActivity.this).c(true, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            SquareCameraActivity.this.jump2Setting();
            SquareCameraActivity.this.K = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            SquareCameraActivity.this.s.setVisibility(8);
            SquareCameraActivity.this.e0.setVisibility(0);
            if (SquareCameraActivity.this.Z.getSelectedItem() != 0) {
                SquareCameraActivity.this.Z.setSelectedItem(0);
            }
            SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA;
            if (tg4.b(squareCameraActivity, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            SquareCameraActivity.this.jump2Setting();
            SquareCameraActivity.this.L = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SquareCameraActivity.this.W && SquareCameraActivity.this.X) {
                if (SquareCameraActivity.this.r == null) {
                    SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
                    SquareCameraActivity squareCameraActivity2 = SquareCameraActivity.this;
                    squareCameraActivity.r = new RecorderView(squareCameraActivity2, squareCameraActivity2.z, SquareCameraActivity.this.A);
                    SquareCameraActivity.this.q.addView(SquareCameraActivity.this.r, 0);
                    SquareCameraActivity.this.r.setOnCameraChangeListener(SquareCameraActivity.this.o0);
                    SquareCameraActivity.this.r.setOnLogChangeListener(SquareCameraActivity.this.p0);
                    SquareCameraActivity.this.r.setSaveCover(true);
                }
                if (SquareCameraActivity.this.r.openCamera() == 0) {
                    SquareCameraActivity.this.V = true;
                    SquareCameraActivity.this.s.setEnabled(true);
                    LogUtil.d("logsquare", "SquareCameraActivity: openCamera");
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareCameraActivity.this.I = -1;
            SquareCameraActivity.this.init();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareCameraActivity.this.E2();
            if (SquareCameraActivity.this.I == 3) {
                SquareCameraActivity.this.s.postDelayed(SquareCameraActivity.this.n0, 1000L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements RecorderView.PictureCallback {
        public h() {
        }

        @Override // com.zenmen.media.camera.RecorderView.PictureCallback
        public void onPictureTaken(int i, int i2) throws Throwable {
            Bitmap bitmapGetPicture = SquareCameraActivity.this.r.GetPicture();
            Matrix matrix = new Matrix();
            matrix.postRotate(SquareCameraActivity.this.G);
            SquareCameraActivity.this.x2(Bitmap.createBitmap(bitmapGetPicture, 0, 0, bitmapGetPicture.getWidth(), bitmapGetPicture.getHeight(), matrix, true));
            SquareCameraActivity.this.H = false;
            LogUtil.i("GCCameraActivity", "takePickture onPictureTaken" + SquareCameraActivity.this.H);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements OnCameraListener {
        public i() {
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFileOpenFail() {
            LogUtil.i("GCCameraActivity", "onRecordFileOpenFail ");
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFileOpenSucess() {
            LogUtil.i("GCCameraActivity", "onRecordFileOpenSucess ");
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFinish() throws Throwable {
            LogUtil.i("GCCameraActivity", "onRecordFinish ");
            SquareCameraActivity.this.y2();
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordStart() {
            LogUtil.i("GCCameraActivity", "onRecordStart ");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements OnLogListener {
        public j() {
        }

        @Override // com.zenmen.media.camera.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
            Log.d("GCCameraActivity", "TestLog " + String.valueOf(obj) + "  " + String.valueOf(obj2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends GestureDetector.SimpleOnGestureListener {
        public k() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Log.e("<--滑动测试-->", "开始滑动");
            float x = motionEvent.getX() - motionEvent2.getX();
            float x2 = motionEvent2.getX() - motionEvent.getX();
            if (x > 50.0f && Math.abs(f) > 0.0f) {
                BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_VIDEO_RECORD, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
                return false;
            }
            if (x2 <= 50.0f || Math.abs(f) <= 0.0f) {
                return false;
            }
            BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sy5.e(SquareCameraActivity.this, R.string.record_short, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnTouchListener {
        public n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (SquareCameraActivity.this.y) {
                return false;
            }
            return SquareCameraActivity.this.Z.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements SquarePhotoButton.d {
        public o() {
        }

        @Override // com.zenmen.media.SquarePhotoButton.d
        public void a() {
            BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            SquareCameraActivity.this.D2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements HorizontalPicker.OnItemSelected {
        public p() {
        }

        @Override // com.zenmen.media.camera.ui.HorizontalPicker.OnItemSelected
        public void onItemSelected(int i) {
            if (i == 0) {
                BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            } else if (i == 1) {
                BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_VIDEO_RECORD, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements SquareRecordButton.e {
        public q() {
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void a() {
            LogUtil.i("GCCameraActivity", "onClickEvent" + SquareCameraActivity.this.H);
            if (l50.a()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagephoto_foot_shoot", "click", jSONObject);
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void b(long j) {
            LogUtil.i("GCCameraActivity", "onCountDownFinished");
            if (SquareCameraActivity.this.r == null) {
                return;
            }
            SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
            squareCameraActivity.P = squareCameraActivity.O + j;
            SquareCameraActivity.this.C = j;
            SquareCameraActivity.this.r.stopRecord();
            SquareCameraActivity.this.E2();
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void c() {
            if (SquareCameraActivity.this.r == null) {
                return;
            }
            SquareCameraActivity.this.C2(false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagephoto_foot_shoot", "click", jSONObject);
            SquareCameraActivity.this.I = 3;
            SquareCameraActivity.this.O = System.currentTimeMillis();
            SquareCameraActivity.this.P = 0L;
            SquareCameraActivity.this.Q = false;
            SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
            squareCameraActivity.G = squareCameraActivity.F;
            LogUtil.i("GCCameraActivity", "onLongPressStart");
            SquareCameraActivity.this.r.setVideoBitrate(SquareCameraActivity.this.z * SquareCameraActivity.this.A * 2);
            File fileL = pu1.l(SquareCameraActivity.this);
            if (!fileL.exists()) {
                fileL.mkdirs();
            }
            String absolutePath = new File(fileL, UUID.randomUUID().toString().replace("-", "") + ".mp4").getAbsolutePath();
            SquareCameraActivity squareCameraActivity2 = SquareCameraActivity.this;
            squareCameraActivity2.B = squareCameraActivity2.r.startRecord(absolutePath, SquareCameraActivity.this.F);
            SquareCameraActivity.this.C = 0L;
            SquareCameraActivity.this.s.post(SquareCameraActivity.this.n0);
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void d(long j) {
            if (SquareCameraActivity.this.r == null) {
                return;
            }
            SquareCameraActivity.this.C2(true);
            SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
            squareCameraActivity.P = squareCameraActivity.O + j;
            SquareCameraActivity.this.s.post(SquareCameraActivity.this.n0);
            if (SquareCameraActivity.this.r.isRecording()) {
                LogUtil.i("GCCameraActivity", "onLongPressEnd");
                SquareCameraActivity.this.C = j;
                SquareCameraActivity.this.r.stopRecord();
            }
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void e() {
            if (SquareCameraActivity.this.r == null) {
                return;
            }
            SquareCameraActivity.this.C2(true);
            LogUtil.i("GCCameraActivity", "onLongPressCancel");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagephoto_foot_shoot", "click", jSONObject);
            if (SquareCameraActivity.this.r.isRecording()) {
                SquareCameraActivity.this.I = 0;
                SquareCameraActivity.this.P = System.currentTimeMillis();
                SquareCameraActivity.this.s.post(SquareCameraActivity.this.n0);
                SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
                squareCameraActivity.C = squareCameraActivity.P - SquareCameraActivity.this.O;
                SquareCameraActivity.this.r.stopRecord();
            }
        }

        @Override // com.zenmen.media.SquareRecordButton.e
        public void f(boolean z) {
            SquareCameraActivity.this.Q = z;
            SquareCameraActivity.this.s.post(SquareCameraActivity.this.n0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.c("pagephoto_foot_turncamera", "click");
            BaseActivityPermissionDispatcher.b(SquareCameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            if (SquareCameraActivity.this.r != null && SquareCameraActivity.this.I == 0) {
                SquareCameraActivity.this.r.switchCamera();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SquareCameraActivity.this.h0.setVisibility(8);
            zn6.c("pagephoto_foot_album", "click");
            SquareCameraActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements ViewTreeObserver.OnDrawListener {
        public t() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            LogUtil.d("logsquare", "SquareCameraActivity: onDraw");
            SquareCameraActivity.this.w2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.d("logsquare", "SquareCameraActivity: fakeDraw");
            SquareCameraActivity.this.w2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends OrientationEventListener {
        public v(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            if (i == -1 || (i2 = (((i + 45) / 90) * 90) % 360) == SquareCameraActivity.this.F) {
                return;
            }
            SquareCameraActivity squareCameraActivity = SquareCameraActivity.this;
            squareCameraActivity.r2(squareCameraActivity.F, i2);
            SquareCameraActivity.this.F = i2;
            Log.e("GCCameraActivity", "mOrientation" + SquareCameraActivity.this.F);
        }
    }

    public final void A2() {
        new sd3(this).k("请开启相机权限开始拍摄").L("取消").h(false).P("去设置").f(new c()).h(false).e().show();
    }

    public final void B2() {
        new sd3(this).k(tg4.b(this, "android.permission.CAMERA") ? "请开启麦克风权限开始视频拍摄" : tg4.b(this, "android.permission.RECORD_AUDIO") ? "请开启相机权限开始视频拍摄" : "请开启相机权限和麦克风权限开始视频拍摄").L("取消").h(false).P("去设置").f(new d()).h(false).e().show();
    }

    public final void C2(boolean z) {
        this.u.setVisibility(z ? 0 : 8);
        this.t.setVisibility(z ? 0 : 8);
        this.g0.setVisibility(z ? 0 : 8);
        if (z) {
            this.h0.setVisibility(8);
        } else {
            this.h0.setVisibility(8);
        }
    }

    public final void D2() {
        LogUtil.i("GCCameraActivity", "takePickture start" + this.H);
        RecorderView recorderView = this.r;
        if (recorderView == null || this.H) {
            return;
        }
        this.H = true;
        this.G = this.F;
        recorderView.takePicture(true, new h());
    }

    public final void E2() {
        long j2;
        int i2 = this.I;
        if (i2 != 3 && i2 != 2) {
            this.v.setVisibility(4);
            this.Y.setVisibility(this.y ? 8 : 0);
            this.Z.setVisibility(this.y ? 8 : 0);
            return;
        }
        this.v.setVisibility(0);
        this.Z.setVisibility(8);
        this.Y.setVisibility(8);
        long jCurrentTimeMillis = this.P;
        if (jCurrentTimeMillis > 0) {
            j2 = this.O;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            j2 = this.O;
        }
        long j3 = jCurrentTimeMillis - j2;
        if (j3 < 3000) {
            this.v.setBackgroundResource(R.drawable.shape_ff6262_12);
            this.s.setCircleColor(Color.parseColor("#FF6262"));
        } else {
            this.v.setBackgroundResource(R.drawable.shape_14cd64_12);
            this.s.setCircleColor(Color.parseColor("#FF6262"));
        }
        long j4 = j3 / 1000;
        if (j4 < 10) {
            this.v.setText(String.format("00:0%d", Long.valueOf(j4)));
        } else {
            this.v.setText(String.format("00:%d", Long.valueOf(j4)));
        }
    }

    public void back(View view) {
        onBackPressed();
    }

    public final void init() {
        if (this.I == 0) {
            return;
        }
        this.I = 0;
        this.B = null;
        this.C = 0L;
        this.O = 0L;
        this.P = 0L;
        this.J = null;
        E2();
        this.q.removeCallbacks(this.m0);
        this.q.post(this.m0);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RecorderView recorderView = this.r;
        if (recorderView == null || !recorderView.isRecording()) {
            super.onBackPressed();
        } else {
            this.s.cancelRecordAnim();
            this.r.stopRecord();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.d("logsquare", "SquareCameraActivity: onCreate begin");
        getWindow().addFlags(128);
        this.E = new v(this, 3);
        if (getIntent() != null) {
            this.w = getIntent().getIntExtra("key_from", 0);
            this.x = getIntent().getBooleanExtra("extra_need_feedback", false);
            this.y = getIntent().getBooleanExtra("extra_only_photo", false);
        }
        this.i0 = SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, "key_square_text_feed_guide_dot", false);
        ds0.a().c(this);
        setContentView(R.layout.activity_square_camera);
        View viewFindViewById = findViewById(R.id.cover);
        this.f0 = viewFindViewById;
        viewFindViewById.setOnTouchListener(new n());
        this.f0.setLongClickable(true);
        SquarePhotoButton squarePhotoButton = (SquarePhotoButton) findViewById(R.id.camera_photo_button);
        this.e0 = squarePhotoButton;
        squarePhotoButton.setTouchEventListener(new o());
        this.Y = findViewById(R.id.pick_cover);
        HorizontalPicker horizontalPicker = (HorizontalPicker) findViewById(R.id.tab_view);
        this.Z = horizontalPicker;
        if (this.y) {
            horizontalPicker.setVisibility(8);
        }
        this.Z.setValues(new CharSequence[]{"照片", "视频"});
        this.Z.setOnItemSelectedListener(new p());
        this.Z.setSelectedItem(0);
        this.q = (RelativeLayout) findViewById(R.id.addContainer);
        this.j0 = new GestureDetector(this, this.l0);
        this.t = (ImageView) findViewById(R.id.swap);
        this.u = (TextView) findViewById(R.id.swap_tv);
        this.g0 = findViewById(R.id.album);
        this.h0 = findViewById(R.id.album_tips);
        this.v = (TextView) findViewById(R.id.duration);
        SquareRecordButton squareRecordButton = (SquareRecordButton) findViewById(R.id.camera_record_button);
        this.s = squareRecordButton;
        squareRecordButton.setOnlyTakePickture(false);
        this.s.setOuterColorBegin(Color.parseColor("#FFFFFF"));
        this.s.setOuterColorEnd(Color.parseColor("#FFFFFF"));
        this.s.setInnerColorBegin(Color.parseColor("#FF6262"));
        this.s.setInnerColorEnd(Color.parseColor("#FF6262"));
        this.s.setEnabled(false);
        this.s.setTouchEventListener(new q());
        this.t.setOnClickListener(new r());
        this.g0.setOnClickListener(new s());
        this.h0.setVisibility(8);
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA;
        if (!tg4.b(this, permissionType.permissionList)) {
            zn6.c("pagephoto_camera", "view");
        }
        BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
        E2();
        t2(this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, this.w);
            jSONObject.put("from", this.w);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("pagephoto", "view", jSONObject);
        if (this.q.getViewTreeObserver() == null || !this.q.getViewTreeObserver().isAlive()) {
            w2();
        } else {
            this.q.getViewTreeObserver().addOnDrawListener(new t());
            this.q.postDelayed(new u(), 100L);
        }
        LogUtil.d("logsquare", "SquareCameraActivity: onCreate end");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LogUtil.d("loggc", "onDestroy");
        super.onDestroy();
        RecorderView recorderView = this.r;
        if (recorderView != null) {
            recorderView.destroy();
        }
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogUtil.d("loggc", "onPause");
        this.W = false;
        this.E.disable();
        this.q.removeCallbacks(this.m0);
        RecorderView recorderView = this.r;
        if (recorderView != null && recorderView.isRecording()) {
            this.s.cancelRecordAnim();
        }
        RecorderView recorderView2 = this.r;
        if (recorderView2 == null || !this.V) {
            return;
        }
        this.V = false;
        recorderView2.stopCamera();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA) {
            zn6.c("pagephoto_camera_cancel", "click");
            A2();
            return;
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.SQUARE_VIDEO_RECORD) {
            zn6.c("pagephoto_camera_cancel", "click");
            B2();
            return;
        }
        BaseActivityPermissionDispatcher.PermissionType permissionType2 = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        if (permissionType == permissionType2) {
            LogUtil.d("logmedia", "onPermissionDenied: time = " + System.currentTimeMillis() + ", requestTime = " + this.k0);
            if (System.currentTimeMillis() - this.k0 >= 1000 || tg4.d(this, permissionType2.permissionList)) {
                return;
            }
            Intent intent = getIntent();
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(this, SquareMediaPickActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA) {
            this.s.setVisibility(8);
            this.e0.setVisibility(0);
            if (this.Z.getSelectedItem() != 0) {
                this.Z.setSelectedItem(0);
            }
            if (z) {
                zn6.c("pagephoto_camera_accpet", "click");
            }
            init();
        } else if (permissionType == BaseActivityPermissionDispatcher.PermissionType.SQUARE_VIDEO_RECORD) {
            this.s.setVisibility(0);
            this.e0.setVisibility(8);
            if (this.Z.getSelectedItem() != 1) {
                this.Z.setSelectedItem(1);
            }
            init();
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            Intent intent = getIntent();
            Intent intent2 = intent == null ? new Intent() : new Intent(intent);
            intent2.putExtra("key_from", 44);
            intent2.setClass(this, SquareMediaPickActivity.class);
            startActivityForResult(intent2, 1);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtil.d("logsquare", "SquareCameraActivity: onResume begin");
        this.W = true;
        if (this.E.canDetectOrientation()) {
            this.E.enable();
        } else {
            Log.d("chengcj1", "Can't Detect Orientation");
        }
        if (this.I == 0) {
            this.q.removeCallbacks(this.m0);
            this.q.post(this.m0);
        }
        if (this.K) {
            this.K = false;
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA;
            if (tg4.b(this, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            }
        }
        if (this.L) {
            this.L = false;
            BaseActivityPermissionDispatcher.PermissionType permissionType2 = BaseActivityPermissionDispatcher.PermissionType.SQUARE_VIDEO_RECORD;
            if (tg4.b(this, permissionType2.permissionList)) {
                BaseActivityPermissionDispatcher.b(this, permissionType2, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
            } else {
                this.s.setVisibility(8);
                this.e0.setVisibility(0);
                if (this.Z.getSelectedItem() != 0) {
                    this.Z.setSelectedItem(0);
                }
                BaseActivityPermissionDispatcher.PermissionType permissionType3 = BaseActivityPermissionDispatcher.PermissionType.SQUARE_CAMERA;
                if (tg4.b(this, permissionType3.permissionList)) {
                    BaseActivityPermissionDispatcher.b(this, permissionType3, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_CAMERA);
                }
            }
        }
        LogUtil.d("logsquare", "SquareCameraActivity: onResume end");
    }

    @qm5
    public void onSquarePublishEvent(kj5 kj5Var) {
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtil.d("loggc", "onStop");
    }

    public final void r2(int i2, int i3) {
        ValueAnimator valueAnimator = this.q0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.q0.cancel();
        }
        ValueAnimator valueAnimator2 = this.q0;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.q0 = valueAnimator3;
            valueAnimator3.setInterpolator(new LinearInterpolator());
            int[] iArrZ2 = z2(i2, i3);
            this.q0.setFloatValues(iArrZ2[0], iArrZ2[1]);
            this.q0.setDuration(150L);
            this.q0.addUpdateListener(new m());
            this.q0.start();
        }
    }

    public final void s2() {
        RecorderView recorderView = this.r;
        if (recorderView == null) {
            return;
        }
        int i2 = this.I;
        if (i2 == 0 || i2 == 3) {
            recorderView.stopCamera();
            v2();
        } else if (i2 == 1 || i2 == 2) {
            return;
        }
        runOnUiThread(new f());
    }

    public void saveAsImage(Bitmap bitmap, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            Log.d("GCCameraActivity", "Saved frame as '" + str);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        Log.d("GCCameraActivity", "Saved frame as '" + str);
    }

    @qm5
    public void showOpenCameraFailedDialog(l84 l84Var) {
        runOnUiThread(new a());
    }

    @qm5
    public void showVideoRecordFailedDialog(fd6 fd6Var) {
        runOnUiThread(new b());
    }

    public final void t2(Context context) {
        int iH = me1.h(context);
        int iB = me1.b(context, 48);
        int iD = me1.d(context);
        int iG = (me1.g() * 4) / 3;
        if ((((me1.f() - iH) - iB) - iG) - iD >= me1.b(context, 160)) {
            this.T = false;
            return;
        }
        this.T = true;
        if ((me1.f() - iG) - iD < me1.b(context, 130)) {
            this.U = true;
        } else {
            this.U = false;
        }
    }

    public final void u2() throws Throwable {
        this.s.post(this.n0);
        int i2 = this.I;
        if (i2 == 1) {
            Bitmap bitmap = this.J;
            if (bitmap != null) {
                File fileL = pu1.l(this);
                if (!fileL.exists()) {
                    fileL.mkdirs();
                }
                String absolutePath = new File(fileL, UUID.randomUUID().toString().replace("-", "") + ".jpg").getAbsolutePath();
                saveAsImage(bitmap, absolutePath);
                Intent intent = getIntent();
                if (intent == null) {
                    intent = new Intent();
                }
                intent.setClass(this, SquarePublishActivity.class);
                intent.putExtra("key_from", this.w);
                MediaItem mediaItem = new MediaItem();
                mediaItem.mimeType = 0;
                mediaItem.localPath = absolutePath;
                mediaItem.fileFullPath = absolutePath;
                mediaItem.picSource = 1;
                if (this.x) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("result_media", mediaItem);
                    setResult(-1, intent2);
                    finish();
                    return;
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(mediaItem);
                intent.putParcelableArrayListExtra("key_publish_pictures", arrayList);
                intent.putExtra("key_publish_location", this.N);
                intent.putExtra("key_publish_time", iv0.a(System.currentTimeMillis(), "yyyy·MM·dd HH:mm"));
                intent.putExtra("key_media_type", 2);
                intent.putExtra("clear_media", true);
                intent.putExtra("key_camera_facing", this.r.getCameraType());
                startActivity(intent);
                init();
                return;
            }
            return;
        }
        if (i2 == 2) {
            Intent intent3 = getIntent();
            if (intent3 == null) {
                intent3 = new Intent();
            }
            intent3.setClass(this, SquarePublishActivity.class);
            intent3.putExtra("key_from", this.w);
            MediaItem mediaItem2 = new MediaItem();
            mediaItem2.mimeType = 1;
            mediaItem2.localPath = this.B;
            if (pu1.b(this.B + ".cover")) {
                mediaItem2.thumbnailPath = this.B + ".cover";
                pu1.e(this.B + ".thumbnail");
            } else {
                mediaItem2.thumbnailPath = this.B + ".thumbnail";
            }
            mediaItem2.localThumbPath = mediaItem2.thumbnailPath;
            mediaItem2.playLength = this.C;
            mediaItem2.fileFullPath = this.B;
            int i3 = this.F;
            mediaItem2.width = (i3 == 0 || i3 == 360) ? this.z : this.A;
            mediaItem2.height = (i3 == 0 || i3 == 360) ? this.A : this.z;
            mediaItem2.picSource = 1;
            if (this.x) {
                Intent intent4 = new Intent();
                intent4.putExtra("result_media", mediaItem2);
                setResult(-1, intent4);
                finish();
                return;
            }
            intent3.putExtra("key_publish_video", mediaItem2);
            intent3.putExtra("key_publish_location", this.N);
            intent3.putExtra("key_publish_time", iv0.a(System.currentTimeMillis(), "yyyy·MM·dd HH:mm"));
            intent3.putExtra("key_media_type", 3);
            intent3.putExtra("clear_media", true);
            intent3.putExtra("key_camera_facing", this.r.getCameraType());
            startActivity(intent3);
            init();
            LogUtil.d("logsquare", "[Camera] gotoPublish, videoPath = " + this.B);
        }
    }

    public final void v2() {
        if (TextUtils.isEmpty(this.B)) {
            return;
        }
        File file = new File(this.B);
        File file2 = new File(this.B + ".cover");
        File file3 = new File(this.B + ".thumbnail");
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
        if (file3.exists()) {
            file3.delete();
        }
    }

    public final void w2() {
        if (this.X) {
            return;
        }
        this.X = true;
        if (this.I == 0) {
            this.q.removeCallbacks(this.m0);
            this.q.post(this.m0);
        }
    }

    public final void x2(Bitmap bitmap) throws Throwable {
        this.J = bitmap;
        this.I = 1;
        this.r.stopCamera();
        u2();
    }

    public final void y2() throws Throwable {
        if (this.I != 3) {
            s2();
            return;
        }
        if (!(this.C >= 3000)) {
            runOnUiThread(new l());
            s2();
        } else {
            this.r.stopCamera();
            this.I = 2;
            u2();
        }
    }

    public final int[] z2(int i2, int i3) {
        int[] iArr = new int[2];
        if (i2 == 90) {
            i2 = 270;
        } else if (i2 == 270) {
            i2 = 90;
        }
        if (i3 == 90) {
            i3 = 270;
        } else if (i3 == 270) {
            i3 = 90;
        }
        if (i2 == 270 && i3 == 0) {
            i3 = 360;
        }
        if (i2 == 0 && i3 == 270) {
            i2 = 360;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        return iArr;
    }
}

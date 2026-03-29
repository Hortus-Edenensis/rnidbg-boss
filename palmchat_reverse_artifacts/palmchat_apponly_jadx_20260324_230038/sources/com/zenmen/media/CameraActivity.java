package com.zenmen.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.media.MButton;
import com.zenmen.media.camera.OnCameraListener;
import com.zenmen.media.camera.OnLogListener;
import com.zenmen.media.camera.RecorderView;
import com.zenmen.media.player.IMagicMediaPlayer;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ed6;
import defpackage.fd6;
import defpackage.l50;
import defpackage.l84;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.tg4;
import defpackage.wg4;
import defpackage.xm3;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CameraActivity extends FrameworkBaseActivity implements View.OnClickListener {
    public View A;
    public View B;
    public View C;
    public View E;
    public View F;
    public View G;
    public ImageView H;
    public IMagicMediaPlayer I;
    public LinearLayout J;
    public TextView K;
    public k N;
    public ValueAnimator X;
    public MButton v;
    public ImageView w;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = -1;
    public RecorderView u = null;
    public boolean x = true;
    public int y = 540;
    public int z = 960;
    public String L = null;
    public long M = 0;
    public int O = 0;
    public int P = 0;
    public boolean Q = false;
    public boolean R = false;
    public OnCameraListener S = new h();
    public OnLogListener T = new i();
    public int U = 0;
    public AudioManager.OnAudioFocusChangeListener V = new j();
    public boolean W = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CameraActivity.this.w.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wg4.a(CameraActivity.this).f(true, CameraActivity.this.t);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements MButton.d {
        public c() {
        }

        @Override // com.zenmen.media.MButton.d
        public void a() {
            LogUtil.i("LXCameraActivity", "onClickEvent" + CameraActivity.this.Q);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, CameraActivity.this.q + "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M2213", null, jSONObject.toString());
            if (l50.a()) {
                return;
            }
            CameraActivity.this.d2();
        }

        @Override // com.zenmen.media.MButton.d
        public void b(long j) {
            LogUtil.i("LXCameraActivity", "onCountDownFinished");
            CameraActivity.this.M = j;
            CameraActivity.this.u.stopRecord();
        }

        @Override // com.zenmen.media.MButton.d
        public void c() {
            CameraActivity cameraActivity = CameraActivity.this;
            cameraActivity.P = cameraActivity.O;
            LogUtil.i("LXCameraActivity", "onLongPressStart");
            CameraActivity cameraActivity2 = CameraActivity.this;
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO;
            if (!tg4.b(cameraActivity2, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(CameraActivity.this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_RECORD_AUDIO);
                return;
            }
            CameraActivity cameraActivity3 = CameraActivity.this;
            cameraActivity3.u.setVideoBitrate(cameraActivity3.y * cameraActivity3.z * 2);
            CameraActivity cameraActivity4 = CameraActivity.this;
            cameraActivity4.L = cameraActivity4.u.startRecord(CameraActivity.this.O);
        }

        @Override // com.zenmen.media.MButton.d
        public void d(long j) {
            if (CameraActivity.this.u.isRecording()) {
                LogUtil.i("LXCameraActivity", "onLongPressEnd");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, CameraActivity.this.q + "2");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("M2213", null, jSONObject.toString());
                CameraActivity.this.M = j;
                CameraActivity.this.u.stopRecord();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.u.switchCamera();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityPermissionDispatcher.b(CameraActivity.this, BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_RECORD_AUDIO);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActivityPermissionDispatcher.PermissionType f11861a;
        public final /* synthetic */ BaseActivityPermissionDispatcher.PermissionUsage b;

        public f(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
            this.f11861a = permissionType;
            this.b = permissionUsage;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            CameraActivity.this.onPermissionDialogCancel(this.f11861a, this.b);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            CameraActivity.this.jump2Setting();
            CameraActivity.this.onPermissionDialogConfirm(this.f11861a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements RecorderView.PictureCallback {
        public g() {
        }

        @Override // com.zenmen.media.camera.RecorderView.PictureCallback
        public void onPictureTaken(int i, int i2) {
            Bitmap bitmapGetPicture = CameraActivity.this.u.GetPicture();
            Matrix matrix = new Matrix();
            matrix.postRotate(CameraActivity.this.P);
            CameraActivity.this.Z1(Bitmap.createBitmap(bitmapGetPicture, 0, 0, bitmapGetPicture.getWidth(), bitmapGetPicture.getHeight(), matrix, true));
            CameraActivity.this.Q = false;
            LogUtil.i("LXCameraActivity", "takePickture onPictureTaken" + CameraActivity.this.Q);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements OnCameraListener {
        public h() {
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFileOpenFail() {
            LogUtil.i("LXCameraActivity", "onRecordFileOpenFail ");
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFileOpenSucess() {
            LogUtil.i("LXCameraActivity", "onRecordFileOpenSucess ");
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordFinish() {
            LogUtil.i("LXCameraActivity", "onRecordFinish ");
            CameraActivity.this.a2();
        }

        @Override // com.zenmen.media.camera.OnCameraListener
        public void onRecordStart() {
            LogUtil.i("LXCameraActivity", "onRecordStart ");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements OnLogListener {
        public i() {
        }

        @Override // com.zenmen.media.camera.OnLogListener
        public void onLogEvent(int i, Object obj, Object obj2) {
            Log.d("LXCameraActivity", "TestLog " + String.valueOf(obj) + "  " + String.valueOf(obj2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements AudioManager.OnAudioFocusChangeListener {
        public j() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Log.d("LXCameraActivity", "onAudioFocusChange :" + i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends OrientationEventListener {
        public k(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            if (i == -1 || (i2 = (((i + 45) / 90) * 90) % 360) == CameraActivity.this.O) {
                return;
            }
            CameraActivity cameraActivity = CameraActivity.this;
            cameraActivity.U1(cameraActivity.O, i2);
            CameraActivity.this.O = i2;
            Log.e("LXCameraActivity", "mOrientation" + CameraActivity.this.O);
        }
    }

    public final void Q1() {
        try {
            if (this.W) {
                ((AudioManager) getSystemService("audio")).abandonAudioFocus(this.V);
                this.W = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void U1(int i2, int i3) {
        ValueAnimator valueAnimator = this.X;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.X.cancel();
        }
        ValueAnimator valueAnimator2 = this.X;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.X = valueAnimator3;
            valueAnimator3.setInterpolator(new LinearInterpolator());
            int[] iArrB2 = b2(i2, i3);
            this.X.setFloatValues(iArrB2[0], iArrB2[1]);
            this.X.setDuration(150L);
            this.X.addUpdateListener(new a());
            this.X.start();
        }
    }

    public final void V1() {
        if (this.R) {
            return;
        }
        this.R = true;
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO;
        if (tg4.b(this, permissionType.permissionList)) {
            return;
        }
        BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_RECORD_AUDIO);
    }

    public final void W1() {
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        File file = new File(this.L);
        File file2 = new File(this.L + ".thumbnail");
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
    }

    public final View X1() {
        return new MagicTextureMediaPlayer(this);
    }

    public final void Z1(Bitmap bitmap) {
        this.G.setVisibility(8);
        this.A.setVisibility(0);
        this.J.setVisibility(8);
        this.H.setVisibility(0);
        this.H.setImageBitmap(bitmap);
        this.U = 1;
        this.u.stopCamera();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a2() {
        if (!(this.M >= 2000)) {
            W1();
            LogUtil.i("LXCameraActivity", "onClickEvent");
            d2();
            return;
        }
        this.u.stopCamera();
        this.G.setVisibility(8);
        this.A.setVisibility(0);
        this.H.setVisibility(8);
        this.J.setVisibility(0);
        IMagicMediaPlayer iMagicMediaPlayer = this.I;
        if (iMagicMediaPlayer != null) {
            iMagicMediaPlayer.stop();
            this.I.release();
            this.J.removeAllViews();
            this.I = null;
        }
        View viewX1 = X1();
        this.I = (IMagicMediaPlayer) viewX1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.J.addView(viewX1, layoutParams);
        c2();
        this.I.setVideo(this.L);
        this.I.mute(false);
        this.I.start();
        this.U = 2;
    }

    public final int[] b2(int i2, int i3) {
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

    public final void c2() {
        try {
            ((AudioManager) getSystemService("audio")).requestAudioFocus(this.V, 3, 2);
            this.W = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d2() {
        LogUtil.i("LXCameraActivity", "takePickture start" + this.Q);
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.P = this.O;
        this.u.takePicture(true, new g());
    }

    public final void e2() {
        boolean zB = tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.RECORD_AUDIO.permissionList);
        this.v.setCanUpdateAngle(true);
        if (zB) {
            if (this.r == 0) {
                this.K.setText(R.string.camera_record);
            } else {
                this.K.setText(R.string.camera_take_picture);
            }
        } else if (this.r == 0) {
            this.K.setText("未开启麦克风，无法拍摄视频>");
            this.v.setCanUpdateAngle(false);
        } else {
            this.K.setText(R.string.camera_take_picture);
        }
        this.K.setOnClickListener(new e());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_translate_out_alpha);
        Q1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RecorderView recorderView = this.u;
        if (recorderView == null || !recorderView.isRecording()) {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        Bitmap bitmap;
        if (view == this.B) {
            return;
        }
        if (view == this.C) {
            int i2 = this.U;
            if (i2 != 1 && i2 == 2) {
                W1();
                Q1();
            }
            this.U = 0;
            this.G.setVisibility(0);
            this.A.setVisibility(8);
            this.J.setVisibility(8);
            this.H.setVisibility(8);
            IMagicMediaPlayer iMagicMediaPlayer = this.I;
            if (iMagicMediaPlayer != null) {
                iMagicMediaPlayer.stop();
                this.I.release();
                this.J.removeAllViews();
                this.I = null;
            }
            this.u.openCamera();
            return;
        }
        if (view != this.E) {
            if (view == this.F) {
                onBackPressed();
                return;
            }
            return;
        }
        int i3 = this.U;
        if (i3 != 1) {
            if (i3 == 2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, this.q + "2");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("M2210", null, jSONObject.toString());
                xm3.a(this.L);
                Intent intent = new Intent();
                MediaItem mediaItem = new MediaItem();
                mediaItem.mimeType = 1;
                mediaItem.localPath = this.L;
                String str = this.L + ".thumbnail";
                mediaItem.thumbnailPath = str;
                mediaItem.localThumbPath = str;
                mediaItem.playLength = this.M;
                intent.putExtra("EXTRA_RECORD_ITEM", mediaItem);
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(az.at, this.q + "1");
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("M2210", null, jSONObject2.toString());
        if (this.H.getDrawable() == null || (bitmap = ((BitmapDrawable) this.H.getDrawable()).getBitmap()) == null) {
            return;
        }
        pu1.t();
        File file = new File(pu1.j);
        if (!file.exists()) {
            file.mkdir();
        }
        String str2 = pu1.j + File.separator + UUID.randomUUID().toString().replace("-", "") + ".jpg";
        saveAsImage(bitmap, str2);
        xm3.a(str2);
        Intent intent2 = new Intent();
        MediaItem mediaItem2 = new MediaItem();
        mediaItem2.mimeType = 0;
        mediaItem2.localPath = str2;
        mediaItem2.fileFullPath = str2;
        intent2.putExtra("EXTRA_RECORD_ITEM", mediaItem2);
        setResult(-1, intent2);
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().setNavigationBarColor(Color.parseColor("#66333333"));
        AudioController.b0().Z().j(this);
        processIntent();
        setContentView(R.layout.activity_lx_camera);
        this.N = new k(this, 3);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.adcontainer);
        linearLayout.setOrientation(0);
        this.H = (ImageView) findViewById(R.id.camera_imageview);
        this.J = (LinearLayout) findViewById(R.id.videoViewLayout);
        this.A = findViewById(R.id.result_btn_layout);
        this.G = findViewById(R.id.camera_control_layout);
        View viewFindViewById = findViewById(R.id.edit);
        this.B = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(R.id.revert);
        this.C = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        View viewFindViewById3 = findViewById(R.id.ok);
        this.E = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        View viewFindViewById4 = findViewById(R.id.close);
        this.F = viewFindViewById4;
        viewFindViewById4.setOnClickListener(this);
        this.K = (TextView) findViewById(R.id.desTv);
        Log.d("LXCameraActivity", "CameraSDK Version '" + RecorderView.GetSDKVersion());
        MButton mButton = (MButton) findViewById(R.id.camera_record_button);
        this.v = mButton;
        mButton.setOnlyTakePickture(this.r != 0);
        e2();
        this.w = (ImageView) findViewById(R.id.swap);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        Log.d("LXCameraActivity", "the screen size is " + point.toString());
        getWindowManager().getDefaultDisplay().getRealSize(point);
        int i2 = point.x;
        int i3 = point.y;
        ed6.b bVar = new ed6.b();
        ed6.b(i2, i3, bVar);
        RecorderView recorderView = new RecorderView(this, bVar.f17284a, bVar.b);
        this.u = recorderView;
        linearLayout.addView(recorderView);
        this.u.setOnCameraChangeListener(this.S);
        this.u.setOnLogChangeListener(this.T);
        this.v.setTouchEventListener(new c());
        this.w.setOnClickListener(new d());
        Y1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.d("LXCameraActivity", "onDestroy");
        super.onDestroy();
        AudioController.b0().Z().l(this);
        this.u.destroy();
        IMagicMediaPlayer iMagicMediaPlayer = this.I;
        if (iMagicMediaPlayer != null) {
            iMagicMediaPlayer.release();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d("LXCameraActivity", "onPause");
        this.N.disable();
        IMagicMediaPlayer iMagicMediaPlayer = this.I;
        if (iMagicMediaPlayer != null) {
            iMagicMediaPlayer.pause();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("LXCameraActivity", "onResume");
        V1();
        e2();
        if (this.N.canDetectOrientation()) {
            this.N.enable();
        } else {
            Log.d("chengcj1", "Can't Detect Orientation");
        }
        if (this.U == 0) {
            this.u.openCamera();
        }
        IMagicMediaPlayer iMagicMediaPlayer = this.I;
        if (iMagicMediaPlayer != null) {
            iMagicMediaPlayer.pause();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Log.d("LXCameraActivity", "onStop");
        this.u.stopCamera();
    }

    public final void processIntent() {
        Intent intent = getIntent();
        this.r = intent.getIntExtra("EXTRA_RECORD_MODE", 0);
        this.s = intent.getIntExtra("EXTRA_REQUEST_CODE", 0);
        this.q = intent.getIntExtra(az.at, 0);
        this.t = this.s == 106 ? 2 : 3;
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
            Log.d("LXCameraActivity", "Saved frame as '" + str);
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
        Log.d("LXCameraActivity", "Saved frame as '" + str);
    }

    @qm5
    public void showOpenCameraFailedDialog(l84 l84Var) {
        runOnUiThread(new b());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showPermissionDenyDialog(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.string_permission_audio).L("继续拍照").P("前往设置").f(new f(permissionType, permissionUsage)).h(false).e().show();
    }

    public final void Y1() {
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onNewVersionChecked() {
    }

    @qm5
    public void showVideoRecordFailedDialog(fd6 fd6Var) {
    }
}

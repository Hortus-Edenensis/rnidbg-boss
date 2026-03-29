package com.zenmen.square.activity;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import defpackage.bd5;
import defpackage.ei4;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.je1;
import defpackage.k36;
import defpackage.k86;
import defpackage.l50;
import defpackage.mj5;
import defpackage.sy5;
import defpackage.tn;
import defpackage.v4;
import defpackage.xt;
import defpackage.zn6;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquarePublishActivity extends SquareBasePublishActivity {
    public static final String C0 = "SquarePublishActivity";
    public static int D0;
    public TextView l0;
    public TextView m0;
    public View n0;
    public TextView o0;
    public View p0;
    public View q0;
    public TextView r0;
    public ImageView s0;
    public AspectRatioFrameLayout t0;
    public MagicTextureMediaPlayer u0;
    public ImageView v0;
    public ViewGroup w0;
    public ConstraintLayout x0;
    public boolean y0 = false;
    public boolean z0 = false;
    public boolean A0 = false;
    public AudioManager.OnAudioFocusChangeListener B0 = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = SquarePublishActivity.this.w0.getHeight();
            if (height <= tn.g()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) SquarePublishActivity.this.M.getLayoutParams();
                SquarePublishActivity squarePublishActivity = SquarePublishActivity.this;
                squarePublishActivity.y0 = false;
                squarePublishActivity.e0 = (tn.g() - height) + marginLayoutParams.bottomMargin;
                return;
            }
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(SquarePublishActivity.this.x0);
            constraintSet.connect(SquarePublishActivity.this.M.getId(), 4, 0, 4);
            constraintSet.applyTo(SquarePublishActivity.this.x0);
            SquarePublishActivity.this.e0 = k36.b(20.0f);
            SquarePublishActivity.this.y0 = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            FeedBean feedBean = new FeedBean();
            feedBean.setMediaItem(SquarePublishActivity.this.x.get(0));
            int[] iArrX1 = SquareBasePublishActivity.X1(SquarePublishActivity.this.x.get(0).fileFullPath);
            if (xt.r(SquarePublishActivity.this.x.get(0).fileFullPath)) {
                feedBean.setWidth(Integer.toString(iArrX1[1]));
                feedBean.setHeight(Integer.toString(iArrX1[0]));
            } else {
                feedBean.setWidth(Integer.toString(iArrX1[0]));
                feedBean.setHeight(Integer.toString(iArrX1[1]));
            }
            arrayList.add(feedBean);
            ei4.h(SquarePublishActivity.this, arrayList, 0, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            FeedBean feedBean = new FeedBean();
            feedBean.setMediaItem(SquarePublishActivity.this.x.get(0));
            feedBean.setWidth(Integer.toString(SquareBasePublishActivity.X1(SquarePublishActivity.this.x.get(0).localThumbPath)[0]));
            feedBean.setHeight(Integer.toString(SquareBasePublishActivity.X1(SquarePublishActivity.this.x.get(0).localThumbPath)[1]));
            feedBean.setUid(v4.e(SquarePublishActivity.this));
            arrayList.add(feedBean);
            ei4.k(SquarePublishActivity.this, arrayList, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AudioManager.OnAudioFocusChangeListener {
        public d() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Log.d(SquarePublishActivity.C0, "onAudioFocusChange :" + i);
        }
    }

    public final void H2() {
        try {
            if (this.z0) {
                ((AudioManager) getSystemService("audio")).abandonAudioFocus(this.B0);
                this.z0 = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void L2() {
        try {
            ((AudioManager) getSystemService("audio")).requestAudioFocus(this.B0, 3, 2);
            this.z0 = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public float S1(int i) {
        float f = i;
        Log.d(C0, "keyboard change y:" + f);
        return -f;
    }

    public void cameraBack(View view) {
        onBackPressed();
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public void e2() {
        super.e2();
        this.l0 = (TextView) findViewById(R$id.action_button);
        this.x0 = (ConstraintLayout) findViewById(R$id.root);
        this.m0 = (TextView) findViewById(R$id.time);
        this.N.setBgColorType(1);
        this.N.setPageFrom(1);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.addContainer);
        this.w0 = viewGroup;
        viewGroup.post(new a());
        this.s0 = (ImageView) findViewById(R$id.image);
        this.t0 = (AspectRatioFrameLayout) findViewById(R$id.video_content);
        this.u0 = (MagicTextureMediaPlayer) findViewById(R$id.video);
        this.v0 = (ImageView) findViewById(R$id.video_thumbnail);
        this.s0.setOnClickListener(new b());
        if (this.t != 2 || this.x == null) {
            this.s0.setVisibility(8);
        } else {
            this.s0.setVisibility(0);
            gr2.j().h(k86.p(this.x.get(0).fileFullPath), this.s0, new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY).v(new bd5()).r());
        }
        this.t0.setOnClickListener(new c());
        if (this.t != 3 || this.x == null) {
            this.t0.setVisibility(8);
        } else {
            this.t0.setVisibility(0);
            if (TextUtils.isEmpty(this.x.get(0).thumbnailPath)) {
                this.v0.setVisibility(4);
            } else {
                gr2.j().h(k86.p(this.x.get(0).thumbnailPath), this.v0, hr2.h());
            }
            L2();
            this.u0.setVideo(this.x.get(0).localPath);
            this.u0.setLoop(true);
            this.u0.setResumable(false);
            this.u0.mute(false);
            this.u0.start();
        }
        SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, "key_square_location_tips", true);
        this.m0.setText(this.A);
        this.n0 = findViewById(R$id.info_location_layout);
        this.o0 = (TextView) findViewById(R$id.info_location);
        this.p0 = findViewById(R$id.info_time_layout);
        this.r0 = (TextView) findViewById(R$id.info_time);
        this.q0 = findViewById(R$id.info_time_icon);
        if (this.x.size() < 1 || this.x.get(0).extractInfo == null || TextUtils.isEmpty(this.x.get(0).extractInfo.getTimeStr())) {
            this.p0.setVisibility(8);
        } else {
            this.p0.setVisibility(0);
            this.r0.setText(this.x.get(0).extractInfo.getTimeStr());
        }
        if (this.x.size() < 1 || this.x.get(0).locationInfo == null || TextUtils.isEmpty(this.x.get(0).locationInfo.getShowName())) {
            this.n0.setVisibility(8);
        } else {
            this.n0.setVisibility(0);
            this.o0.setText(this.x.get(0).locationInfo.getShowName());
        }
        if (this.n0.getVisibility() == 0) {
            this.q0.setVisibility(8);
        } else {
            this.q0.setVisibility(0);
        }
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.square_layout_activity_publish);
        ArrayList<MediaItem> arrayList = this.x;
        if (arrayList == null || arrayList.isEmpty()) {
            finish();
            return;
        }
        e2();
        int i = 1;
        if (mj5.r().t()) {
            sy5.e(this, R$string.square_publish_uploading_now, 1).g();
            finish();
            return;
        }
        mj5.r().z();
        U1();
        JSONObject jSONObject = new JSONObject();
        try {
            LocationEx locationEx = this.y;
            if (locationEx != null) {
                jSONObject.put("address", locationEx.getName());
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put("time", this.A);
            }
            if (this.s != 2) {
                if (this.x.get(0).mimeType != 0) {
                    i = this.U == 0 ? 3 : 2;
                } else if (this.U != 0) {
                    i = 0;
                }
                jSONObject.put("contentsource", i);
            }
            jSONObject.put("from", this.q);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f("pagephotoedit", "view", jSONObject);
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.u0;
        if (magicTextureMediaPlayer != null) {
            magicTextureMediaPlayer.release();
        }
        H2();
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.u0;
        if (magicTextureMediaPlayer == null || !magicTextureMediaPlayer.isPlaying()) {
            return;
        }
        this.u0.pause();
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.u0;
        if (magicTextureMediaPlayer == null || magicTextureMediaPlayer.isPlaying()) {
            return;
        }
        this.u0.pause();
    }
}

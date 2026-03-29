package com.zenmen.palmchat.circle.app.keep.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import defpackage.c70;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.hz2;
import defpackage.k86;
import defpackage.mz2;
import defpackage.uz2;
import defpackage.wi0;
import defpackage.z53;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionItemView extends LinearLayout {
    private static final String TAG = "com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView";
    private AspectRatioFrameLayout content;
    private ImageView cover;
    private mz2 keepMotionData;
    private uz2 onStateChange;
    private KeepMotionParam param;
    private c playCallBack;
    private hz2 playerWrapper;
    private int position;
    private ViewGroup root;
    private long submitTime;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends uz2 {
        public a() {
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            super.onCompleted();
            z53.a(KeepMotionItemView.TAG, "on onCompleted:" + KeepMotionItemView.this.position);
            hz2 hz2Var = KeepMotionItemView.this.playerWrapper;
            hz2Var.f18074a = hz2Var.f18074a + 1;
            if (KeepMotionItemView.this.playCallBack != null) {
                KeepMotionItemView.this.playCallBack.a(KeepMotionItemView.this.keepMotionData, KeepMotionItemView.this.position);
            }
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
            z53.a(KeepMotionItemView.TAG, "on onPaused:" + KeepMotionItemView.this.position);
            KeepMotionItemView.this.parentUIOnPause();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            z53.a(KeepMotionItemView.TAG, "on prepared:" + KeepMotionItemView.this.position);
            super.onPrepared(i, i2);
            if (KeepMotionItemView.this.playCallBack != null) {
                KeepMotionItemView.this.playCallBack.c(KeepMotionItemView.this.keepMotionData, KeepMotionItemView.this.playerWrapper);
            }
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            z53.a(KeepMotionItemView.TAG, "on started:" + KeepMotionItemView.this.position);
            KeepMotionItemView.this.parentUIOnStart();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
            super.onVideoFirstFrame();
            KeepMotionItemView.this.root.removeView(KeepMotionItemView.this.cover);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(mz2 mz2Var, int i);

        void b(mz2 mz2Var, hz2 hz2Var, int i);

        void c(mz2 mz2Var, hz2 hz2Var);

        void d(mz2 mz2Var);

        void e(mz2 mz2Var, hz2 hz2Var);

        void f(mz2 mz2Var);

        void g(mz2 mz2Var, int i);
    }

    public KeepMotionItemView(@NonNull Context context) {
        super(context);
        this.onStateChange = new a();
        init(context);
    }

    private void init(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_keep_motion, (ViewGroup) this, false);
        this.root = (ViewGroup) viewInflate.findViewById(R.id.root);
        this.content = (AspectRatioFrameLayout) viewInflate.findViewById(R.id.video_content);
        ImageView imageView = new ImageView(context);
        this.cover = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(viewInflate);
    }

    private void motionComplete() {
        mz2 mz2Var = this.keepMotionData;
        if (mz2Var.b) {
            return;
        }
        mz2Var.b = true;
        if (this.playCallBack != null && System.currentTimeMillis() - this.submitTime > 2000) {
            this.playCallBack.g(this.keepMotionData, this.position);
            this.submitTime = System.currentTimeMillis();
        }
        KeepMotionParam keepMotionParam = this.param;
        String str = keepMotionParam.actionId;
        String str2 = keepMotionParam.lessonId;
        String str3 = keepMotionParam.planId;
        int i = keepMotionParam.week;
        int i2 = keepMotionParam.day;
        c70.R().A("1", str, str2, str3, "" + i, "" + i2, new b());
    }

    private void parentUIOnInit() {
        parentUIOnRelease();
        c cVar = this.playCallBack;
        if (cVar != null) {
            cVar.b(this.keepMotionData, this.playerWrapper, this.position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parentUIOnPause() {
        c cVar = this.playCallBack;
        if (cVar != null) {
            cVar.f(this.keepMotionData);
        }
    }

    private void parentUIOnRelease() {
        c cVar = this.playCallBack;
        if (cVar != null) {
            cVar.d(this.keepMotionData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parentUIOnStart() {
        c cVar = this.playCallBack;
        if (cVar != null) {
            cVar.e(this.keepMotionData, this.playerWrapper);
        }
    }

    private void restComplete() {
        if (this.playCallBack == null || System.currentTimeMillis() - this.submitTime <= 2000) {
            return;
        }
        this.playCallBack.g(this.keepMotionData, this.position);
        this.submitTime = System.currentTimeMillis();
    }

    public void bindData(mz2 mz2Var) {
        KeepMotionParam keepMotionParam = mz2Var.f19395a;
        this.param = keepMotionParam;
        if (TextUtils.isEmpty(keepMotionParam.url)) {
            KeepMotionParam keepMotionParam2 = this.param;
            keepMotionParam2.unit = 1;
            keepMotionParam2.nums = 1;
        }
        this.keepMotionData = mz2Var;
    }

    public KeepMotionParam getParam() {
        return this.param;
    }

    public boolean isPlaying() {
        return this.playerWrapper.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.playerWrapper = new hz2(new MagicTextureMediaPlayer(getContext()));
        if (TextUtils.isEmpty(this.param.url)) {
            this.playerWrapper.j(0);
        } else {
            this.playerWrapper.j(5000);
        }
        this.playerWrapper.b = this.param.unit;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.content.addView(this.playerWrapper.e, layoutParams);
        String str = this.param.cover;
        gr2.j().i(k86.p(str), this.cover, hr2.l(), null);
        this.root.addView(this.cover, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        z53.a(TAG, "on onDetachedFromWindow:" + this.position);
        super.onDetachedFromWindow();
        this.playerWrapper.f(true);
        this.playerWrapper.n();
        this.playerWrapper.h();
        this.root.removeView(this.cover);
        this.content.removeView(this.playerWrapper.e);
    }

    public void onPageSelected() {
        z53.a(TAG, "on Selected:" + this.position);
        parentUIOnInit();
        this.playerWrapper.f(false);
        if (TextUtils.isEmpty(this.param.url)) {
            this.playerWrapper.l(this.param.restVideoUrl);
        } else {
            this.playerWrapper.l(this.param.url);
        }
        this.playerWrapper.k(this.onStateChange);
    }

    public void onPageUnSelected() {
        z53.a(TAG, "on UN Selected:" + this.position);
        this.playerWrapper.k(null);
        parentUIOnRelease();
    }

    public void pauseVideo() {
        this.playerWrapper.g();
    }

    public void playOrPause() {
        if (this.playerWrapper.e()) {
            this.playerWrapper.g();
        } else {
            this.playerWrapper.m();
        }
    }

    public void playVideo() {
        this.playerWrapper.m();
    }

    public void releaseStateChangeListener() {
        this.playerWrapper.k(null);
    }

    public void setPlayCallBack(c cVar) {
        this.playCallBack = cVar;
    }

    public void setPos(int i) {
        this.position = i;
    }

    public void submit() {
        if (TextUtils.isEmpty(this.keepMotionData.f19395a.url)) {
            restComplete();
        } else {
            motionComplete();
        }
    }

    public KeepMotionItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onStateChange = new a();
        init(context);
    }

    public KeepMotionItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onStateChange = new a();
        init(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
        }
    }
}

package com.zenmen.palmchat.conversations.threadbubble.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.r75;
import defpackage.ux3;
import defpackage.zf2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadsBubbleWidget extends FrameLayout implements View.OnClickListener {
    public static final long MAX_TIMER = 8640000000L;
    private ThreadsBubbleBean bean;
    private Runnable countDownRunnable;
    private boolean isDestroyed;
    private ImageView mBubbleCloseView;
    private TextView mBubbleCountDown;
    private ImageView mBubbleImageView;
    protected Context mContext;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RequestListener<GifDrawable> {
        public a() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
            try {
                new JSONObject().put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ThreadsBubbleWidget.this.setVisibility(0);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends SimpleTarget<Bitmap> {
        public b() {
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            try {
                new JSONObject().put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ThreadsBubbleWidget.this.mBubbleImageView.setImageBitmap(bitmap);
            ThreadsBubbleWidget.this.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadsBubbleWidget.this.isDestroyed) {
                return;
            }
            if (ThreadsBubbleWidget.this.bean == null || ir5.c(true) >= ThreadsBubbleWidget.this.bean.getExpiredTime()) {
                ThreadsBubbleWidget.this.update();
            } else {
                ThreadsBubbleWidget.this.updateCountDownView();
                ThreadsBubbleWidget.this.scheduleCountDown();
            }
        }
    }

    public ThreadsBubbleWidget(@NonNull Context context) {
        super(context, null);
        this.countDownRunnable = new c();
    }

    private void cancelCountDown() {
        removeCallbacks(this.countDownRunnable);
    }

    private ThreadsBubbleBean getBubbleBean() {
        if (ux3.h().i()) {
            return ux3.h().g();
        }
        if (ux3.h().j() || !zf2.e().g()) {
            return null;
        }
        return zf2.e().d();
    }

    private String getRemainTimeStr() {
        long jC = ir5.c(true);
        ThreadsBubbleBean threadsBubbleBean = this.bean;
        if (threadsBubbleBean == null || !threadsBubbleBean.isShowCountdown() || this.bean.getExpiredTime() <= 0 || jC > this.bean.getExpiredTime()) {
            return null;
        }
        long expiredTime = ((this.bean.getExpiredTime() - jC) % MAX_TIMER) / 1000;
        return AppContext.getContext().getString(R.string.bubble_countdown, Long.valueOf(expiredTime / 3600), Long.valueOf((expiredTime / 60) % 60));
    }

    private void init(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_threads_bubble_widget, this);
        this.mBubbleCloseView = (ImageView) viewInflate.findViewById(R.id.bubble_close);
        this.mBubbleImageView = (ImageView) viewInflate.findViewById(R.id.bubble_image);
        this.mBubbleCountDown = (TextView) viewInflate.findViewById(R.id.bubble_countdown);
        this.mBubbleCloseView.setOnClickListener(this);
        this.mBubbleImageView.setOnClickListener(this);
    }

    private void jumpLink(String str) {
        if (getContext() == null || TextUtils.isEmpty(str) || !AccountUtils.r(getContext())) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(getContext(), CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putBoolean("extra_key_disable_text_zoom", true);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleCountDown() {
        cancelCountDown();
        postDelayed(this.countDownRunnable, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDownView() {
        String remainTimeStr = getRemainTimeStr();
        if (TextUtils.isEmpty(remainTimeStr)) {
            this.mBubbleCountDown.setVisibility(8);
        } else {
            this.mBubbleCountDown.setVisibility(0);
            this.mBubbleCountDown.setText(remainTimeStr);
        }
    }

    public void destroy() {
        this.isDestroyed = true;
        cancelCountDown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadsBubbleBean threadsBubbleBean;
        if (view.getId() == R.id.bubble_close) {
            r75.o(com.zenmen.palmchat.c.b(), "sp_bubble_cancel_flag", true);
            zf2.e().c();
            setVisibility(8);
            return;
        }
        if (view.getId() != R.id.bubble_image || (threadsBubbleBean = this.bean) == null) {
            return;
        }
        jumpLink(threadsBubbleBean.getUrl());
        if (ux3.h().i()) {
            HashMap map = new HashMap();
            map.put("status", Integer.valueOf(this.bean.getTreasureBoxStatus()));
            LogUtil.uploadInfoImmediate("newtask_click", map);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("landingurl", this.bean.getUrl());
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "qp_click", "1", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        ThreadsBubbleBean bubbleBean = getBubbleBean();
        this.bean = bubbleBean;
        if (bubbleBean == null || TextUtils.isEmpty(bubbleBean.getIconUrl())) {
            this.mBubbleImageView.setImageResource(0);
            setVisibility(8);
            this.bean = null;
            return;
        }
        this.mBubbleCloseView.setVisibility(8);
        if (this.bean.getIconUrl().endsWith(".gif")) {
            hc2.a(this.mContext).asGif().load(this.bean.getIconUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.DATA).listener(new a()).into(this.mBubbleImageView);
        } else {
            hc2.a(this.mContext).asBitmap().load(this.bean.getIconUrl()).centerCrop().into(new b());
        }
        updateCountDownView();
        if (this.bean.isShowCountdown()) {
            scheduleCountDown();
        }
        if (ux3.h().i()) {
            HashMap map = new HashMap();
            map.put("status", Integer.valueOf(this.bean.getTreasureBoxStatus()));
            LogUtil.uploadInfoImmediate("newtask_show", map);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("iconurl", this.bean.getIconUrl());
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "qp_show", "1", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public ThreadsBubbleWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDownRunnable = new c();
        this.mContext = context;
        init(context, attributeSet);
    }

    public ThreadsBubbleWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDownRunnable = new c();
        this.mContext = context;
        init(context, attributeSet);
    }
}

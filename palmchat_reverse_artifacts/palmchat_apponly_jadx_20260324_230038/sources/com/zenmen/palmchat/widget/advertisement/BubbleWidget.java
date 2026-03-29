package com.zenmen.palmchat.widget.advertisement;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.r75;
import defpackage.rl0;
import defpackage.t56;
import defpackage.xu;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class BubbleWidget extends FrameLayout implements View.OnClickListener {
    private ImageView mBubbleCloseView;
    private ImageView mBubbleImageView;
    protected Context mContext;
    private String mIconUrl;
    private String mPage;
    private String mRedirectAddr;
    private boolean mShowCloseButton;
    private int mVanishType;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RequestListener<GifDrawable> {
        public a() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H181", null, null, jSONObject.toString());
            BubbleWidget.this.setVisibility(0);
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
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H181", null, null, jSONObject.toString());
            BubbleWidget.this.mBubbleImageView.setImageBitmap(bitmap);
            BubbleWidget.this.setVisibility(0);
        }
    }

    public BubbleWidget(@NonNull Context context) {
        super(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleWidget);
                this.mPage = typedArrayObtainStyledAttributes.getString(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        View viewInflate = View.inflate(context, R.layout.layout_bubble_widget, this);
        this.mBubbleCloseView = (ImageView) viewInflate.findViewById(R.id.bubble_close);
        this.mBubbleImageView = (ImageView) viewInflate.findViewById(R.id.bubble_image);
        this.mBubbleCloseView.setOnClickListener(this);
        this.mBubbleImageView.setOnClickListener(this);
    }

    private void jumpLink(String str) {
        if (getContext() == null || TextUtils.isEmpty(str) || !AccountUtils.r(getContext())) {
            return;
        }
        try {
            t56.a(getContext(), Uri.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bubble_close) {
            r75.o(c.b(), "sp_bubble_cancel_flag", true);
            setVisibility(8);
            ch.s().G();
        } else if (view.getId() == R.id.bubble_image) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H182", null, null, jSONObject.toString());
            r75.o(c.b(), "sp_bubble_click_flag", true);
            if (this.mVanishType == -1) {
                setVisibility(8);
                ch.s().G();
            }
            jumpLink(this.mRedirectAddr);
        }
    }

    public void update() {
        if (!xu.a(this.mPage)) {
            setVisibility(8);
            return;
        }
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.REDACTBUBBLE);
        String strOptString = "";
        if (!TextUtils.isEmpty(dynamicConfig.getExtra())) {
            try {
                JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
                strOptString = jSONObject.optString(LxAdDLManager.ITEM_ICONURL);
                this.mRedirectAddr = jSONObject.optString("redirectAddr");
                this.mShowCloseButton = jSONObject.optBoolean("showCloseButton");
                this.mVanishType = jSONObject.optInt("vanishType", 0);
            } catch (Exception unused) {
            }
        }
        this.mBubbleCloseView.setVisibility(this.mShowCloseButton ? 0 : 8);
        if (getVisibility() == 8 || TextUtils.isEmpty(this.mIconUrl) || !this.mIconUrl.equals(strOptString)) {
            this.mIconUrl = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("H180", null, null, jSONObject2.toString());
                if (this.mIconUrl.endsWith(".gif")) {
                    hc2.a(this.mContext).asGif().load(this.mIconUrl).fitCenter().diskCacheStrategy(DiskCacheStrategy.DATA).listener(new a()).into(this.mBubbleImageView);
                } else {
                    hc2.a(this.mContext).asBitmap().load(this.mIconUrl).centerCrop().into(new b());
                }
            }
        }
        if (r75.h(c.b(), "sp_bubble_first_show_time") == 0) {
            r75.q(c.b(), "sp_bubble_first_show_time", ir5.b());
        }
    }

    public BubbleWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(context, attributeSet);
    }

    public BubbleWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context, attributeSet);
    }
}

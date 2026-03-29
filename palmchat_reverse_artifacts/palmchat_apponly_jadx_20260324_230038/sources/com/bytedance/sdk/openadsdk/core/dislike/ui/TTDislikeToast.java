package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTDislikeToast extends FrameLayout {
    private TextView nr;
    private Handler u;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public void fx() {
        setVisibility(8);
        this.u.removeCallbacksAndMessages(null);
    }

    public void nr() {
        try {
            u(q.u(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable unused) {
        }
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void u(Context context) {
        TextView textView = new TextView(context);
        this.nr = textView;
        textView.setClickable(false);
        this.nr.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iU = com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(getContext(), 20.0f);
        int iU2 = com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(getContext(), 12.0f);
        this.nr.setPadding(iU, iU2, iU, iU2);
        this.nr.setLayoutParams(layoutParams);
        this.nr.setTextColor(-1);
        this.nr.setTextSize(16.0f);
        this.nr.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(getContext(), 6.0f));
        this.nr.setBackgroundDrawable(gradientDrawable);
        addView(this.nr);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        u(context);
    }

    public void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u.removeCallbacksAndMessages(null);
        this.u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.nr != null) {
                    TTDislikeToast.this.nr.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.u.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void u() {
        u(q.u(getContext(), "tt_dislike_feedback_success"));
    }
}

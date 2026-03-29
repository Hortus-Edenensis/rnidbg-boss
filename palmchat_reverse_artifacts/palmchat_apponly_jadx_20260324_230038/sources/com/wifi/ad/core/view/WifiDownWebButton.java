package com.wifi.ad.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"AppCompatCustomView"})
public class WifiDownWebButton extends TextView {
    private float mLastX;
    private float mLastY;
    private int mMoveX;
    private int mMoveY;
    private OnButtonClickListener onButtonClickListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnButtonClickListener {
        void onPerformClick(View view);
    }

    public WifiDownWebButton(Context context) {
        super(context);
    }

    public static String getDownLoadMemoryProgress(long j, long j2) {
        int i = (int) (j / 1024);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String str = decimalFormat.format((j2 / 1024.0f) / 1024.0f);
        String str2 = i + "KB";
        if (i >= 1024) {
            str2 = decimalFormat.format(i / 1024.0f) + "MB";
        }
        return "(" + str2 + "/" + str + "MB)";
    }

    private void resetTouchPoint() {
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mMoveX = 0;
        this.mMoveY = 0;
    }

    public static SpannableStringBuilder setProgressStyleString(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.indexOf("("), str.length(), 17);
        return spannableStringBuilder;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public WifiDownWebButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WifiDownWebButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

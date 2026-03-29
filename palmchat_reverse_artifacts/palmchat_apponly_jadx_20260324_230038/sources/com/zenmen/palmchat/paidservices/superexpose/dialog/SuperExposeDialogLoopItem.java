package com.zenmen.palmchat.paidservices.superexpose.dialog;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeDialogLoopItem extends FrameLayout {
    private Context mContext;
    private TextView textView;

    public SuperExposeDialogLoopItem(@NonNull Context context) {
        super(context);
        this.textView = null;
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        TextView textView = new TextView(this.mContext);
        this.textView = textView;
        textView.setBackgroundResource(R.drawable.super_expose_dialog_loop_item_bg);
        this.textView.setTextSize(12.0f);
        this.textView.setMaxLines(1);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setPadding(a46.b(this.mContext, 8.0f), 0, a46.b(this.mContext, 8.0f), 0);
        this.textView.setTextColor(Color.parseColor("#222222"));
        this.textView.setGravity(17);
        this.textView.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, a46.b(this.mContext, 30.0f));
        layoutParams.gravity = 19;
        addView(this.textView, layoutParams);
        this.textView.setText("TTTTTTTT");
    }

    public void setTextBackgroundResource(Integer num) {
        TextView textView;
        if (num == null || (textView = this.textView) == null) {
            return;
        }
        textView.setBackgroundResource(num.intValue());
    }

    public void setTextColor(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.textView) == null) {
            return;
        }
        textView.setTextColor(Color.parseColor(str));
    }

    public void setTextData(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.textView) == null) {
            return;
        }
        textView.setText(Html.fromHtml(str));
    }
}

package com.ss.android.downloadlib.addownload.u;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.x.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10591a;
    private boolean b;
    private boolean fx;
    private String iz;
    private String n;
    private fx nr;
    private Activity pn;
    private b u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private String fx;
        private boolean iz;
        private fx n;
        private String nr;
        private String pn;
        private Activity u;
        private b x;

        public u(Activity activity) {
            this.u = activity;
        }

        public u b(String str) {
            this.pn = str;
            return this;
        }

        public u fx(String str) {
            this.b = str;
            return this;
        }

        public u nr(String str) {
            this.fx = str;
            return this;
        }

        public u u(String str) {
            this.nr = str;
            return this;
        }

        public u u(boolean z) {
            this.iz = z;
            return this;
        }

        public u u(b bVar) {
            this.x = bVar;
            return this;
        }

        public u u(fx fxVar) {
            this.n = fxVar;
            return this;
        }

        public pn u() {
            return new pn(this.u, this.nr, this.fx, this.b, this.pn, this.iz, this.x, this.n);
        }
    }

    public pn(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull b bVar, fx fxVar) {
        super(activity);
        this.pn = activity;
        this.u = bVar;
        this.iz = str;
        this.x = str2;
        this.n = str3;
        this.f10591a = str4;
        this.nr = fxVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        u(this.pn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.b = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.pn.isFinishing()) {
            this.pn.finish();
        }
        if (this.fx) {
            this.u.u();
        } else if (this.b) {
            this.nr.delete();
        } else {
            this.u.nr();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        dismiss();
    }

    private void u(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(u(context, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(u(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iU = u(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iU, iU, iU, iU);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.iz)) {
            textView.setText(this.iz);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = u(context, 26);
        layoutParams4.bottomMargin = iU;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(u(context, 70), u(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.f10591a)) {
            textView2.setText(this.f10591a);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.u.pn.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pn.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = u(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(u(context, 70), u(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.n)) {
            textView3.setText(this.n);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.u.pn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.this.nr();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(u(context, 70), u(context, 33));
        layoutParams6.leftMargin = u(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.x)) {
            textView4.setText(this.x);
        }
        textView4.setBackground(u(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.u.pn.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.this.u();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable u(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(u(context, i));
        return gradientDrawable;
    }

    private static int u(Context context, int i) {
        return mv.u(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.fx = true;
        dismiss();
    }
}

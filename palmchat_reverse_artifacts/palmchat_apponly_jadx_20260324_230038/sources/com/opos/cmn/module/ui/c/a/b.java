package com.opos.cmn.module.ui.c.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.module.ui.c.d.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends a {
    private ImageView f;
    private TextView g;
    private com.opos.cmn.module.ui.a.a h;

    public b(Context context, c cVar) {
        super(context, cVar);
    }

    private void c() {
        ImageView imageView = new ImageView(this.f8070a);
        this.f = imageView;
        imageView.setId(1);
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8070a, 43.0f), com.opos.cmn.an.h.f.a.a(this.f8070a, 43.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f8070a, 12.0f);
        this.c.addView(this.f, layoutParams);
    }

    private String d(String str) {
        String strF = com.opos.cmn.an.h.d.a.f(this.f8070a, str);
        try {
            if (!com.opos.cmn.an.d.b.a(strF) && strF.length() > 0) {
                int iIndexOf = strF.indexOf("(");
                int iIndexOf2 = strF.indexOf(")");
                com.opos.cmn.an.f.a.b("ReminderToast", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                if (-1 == iIndexOf || -1 == iIndexOf2) {
                    iIndexOf = strF.indexOf("（");
                    iIndexOf2 = strF.indexOf("）");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                }
                if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                    strF = strF.substring(0, iIndexOf) + strF.substring(iIndexOf2 + 1, strF.length());
                }
                int iIndexOf3 = strF.indexOf("-");
                com.opos.cmn.an.f.a.b("ReminderToast", "english - =" + iIndexOf3);
                if (-1 == iIndexOf3) {
                    iIndexOf3 = strF.indexOf("—");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese — =" + iIndexOf3);
                }
                if (-1 != iIndexOf3) {
                    strF = strF.substring(0, iIndexOf3);
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("ReminderToast", "getAppDefaultTitle=" + strF);
        return strF;
    }

    private void e() {
        com.opos.cmn.module.ui.a.a aVar = new com.opos.cmn.module.ui.a.a(this.f8070a, "opos_module_biz_ui_cmn_reminder_toast_click_bn_normal_img.png", "opos_module_biz_ui_cmn_reminder_toast_click_bn_pressed_img.png");
        this.h = aVar;
        aVar.setText("立即打开");
        this.h.setId(2);
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 10.0f);
        this.h.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8070a, 66.0f), com.opos.cmn.an.h.f.a.a(this.f8070a, 22.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f8070a, 12.0f);
        this.c.addView(this.h, layoutParams);
    }

    @Override // com.opos.cmn.module.ui.c.a.a
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.module.ui.a.a aVar;
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setCustomViewData pkgName=");
            sb.append(str);
            sb.append(",gbClick=");
            sb.append(z);
            sb.append(",objects=");
            sb.append(objArr != null ? objArr : com.igexin.push.core.b.m);
            com.opos.cmn.an.f.a.b("ReminderToast", sb.toString());
            b(str);
            c(str);
            a(str);
            if (z) {
                a(this.c, str);
                aVar = this.h;
            } else {
                a(this.c);
                aVar = this.h;
            }
            a(aVar, str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.c.a.a
    public void b() {
        c();
        e();
        d();
    }

    private void b(String str) throws PackageManager.NameNotFoundException {
        Drawable drawableE = com.opos.cmn.an.h.d.a.e(this.f8070a, str);
        if (drawableE != null) {
            this.f.setImageDrawable(drawableE);
        }
    }

    private void c(String str) {
        this.g.setText("您下载的【" + d(str) + "】已经安装完成，是否立即打开？");
    }

    private void d() {
        TextView textView = new TextView(this.f8070a);
        this.g = textView;
        textView.setTextColor(Color.parseColor("#2f2f2f"));
        this.g.setTextSize(1, 12.0f);
        this.g.setMaxLines(2);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 1);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f8070a, 19.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f8070a, 19.0f);
        this.c.addView(this.g, layoutParams);
    }
}

package com.opos.mobad.m;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class n implements com.opos.mobad.ad.g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8994a;
    private ViewGroup b;
    private String c;
    private String d;
    private boolean e = false;

    public n(Context context, String str, String str2) {
        this.f8994a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5 A[PHI: r6
      0x00d5: PHI (r6v5 java.lang.String) = (r6v3 java.lang.String), (r6v3 java.lang.String), (r6v6 java.lang.String) binds: [B:8:0x0014, B:10:0x001a, B:23:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        String strF;
        String strSubstring = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    strF = com.opos.cmn.an.h.d.a.f(context, str);
                    try {
                        if (com.opos.cmn.an.d.b.a(strF) || strF.length() <= 0) {
                            strSubstring = strF;
                        } else {
                            int iIndexOf = strF.indexOf("(");
                            int iIndexOf2 = strF.indexOf(")");
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                            if (-1 == iIndexOf || -1 == iIndexOf2) {
                                iIndexOf = strF.indexOf("（");
                                iIndexOf2 = strF.indexOf("）");
                                com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                            }
                            if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                                strF = strF.substring(0, iIndexOf) + strF.substring(iIndexOf2 + 1, strF.length());
                            }
                            int iIndexOf3 = strF.indexOf("-");
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "english - =" + iIndexOf3);
                            if (-1 == iIndexOf3) {
                                iIndexOf3 = strF.indexOf("—");
                                com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese — =" + iIndexOf3);
                            }
                            if (-1 != iIndexOf3) {
                                strSubstring = strF.substring(0, iIndexOf3);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.opos.cmn.an.f.a.a("SplashBottomArea", "", (Throwable) e);
                    }
                }
                strF = strSubstring;
            } catch (Exception e2) {
                e = e2;
                strF = "";
            }
        } else {
            strF = strSubstring;
        }
        com.opos.cmn.an.f.a.b("SplashBottomArea", "getAppDefaultTitle=" + strF);
        return strF;
    }

    @Override // com.opos.mobad.ad.g.d
    public View getAppLogoView() {
        return this.b;
    }

    private void a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8994a);
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f8994a);
        a(relativeLayout2);
        a(relativeLayout2, this.c, this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f8994a, 55.0f));
        layoutParams.addRule(13);
        this.b.addView(relativeLayout2, layoutParams);
        this.b.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.m.n.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                n.this.e = false;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                n.this.e = true;
            }
        });
    }

    private void b(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f8994a);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#aaaaaa"));
        textView.setTextSize(1, 13.0f);
        textView.setMaxEms(11);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout) {
        final ImageView imageView = new ImageView(this.f8994a);
        imageView.setId(2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.m.n.2
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableE;
                if (n.this.e || (drawableE = com.opos.cmn.an.h.d.a.e(n.this.f8994a, n.this.f8994a.getPackageName())) == null) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.m.n.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.e) {
                            return;
                        }
                        imageView.setImageDrawable(drawableE);
                    }
                });
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8994a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f8994a, 40.0f));
        layoutParams.addRule(15);
        relativeLayout.addView(imageView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f8994a);
        textView.setText(str);
        textView.setId(3);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#010036"));
        textView.setTextSize(1, 22.0f);
        textView.setMaxEms(7);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str, String str2) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f8994a);
        a(relativeLayout2, str);
        b(relativeLayout2, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f8994a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams);
    }
}

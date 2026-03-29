package com.opos.mobad.template.i.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PowerManager f10100a;

    public static final View a(com.opos.mobad.template.d.b bVar, ViewGroup viewGroup) {
        if (viewGroup == null || bVar == null) {
            return null;
        }
        View viewA = bVar.t.a();
        if (viewA == null) {
            viewA = new com.opos.mobad.template.i.a(viewGroup.getContext());
        }
        viewGroup.addView(viewA, a(viewGroup.getContext(), bVar, viewA));
        viewA.setVisibility(4);
        return viewA;
    }

    public static final BaseTextView b(Context context) {
        BaseTextView baseTextView = new BaseTextView(context);
        baseTextView.setTextSize(0, com.opos.cmn.an.h.f.a.a(context, 18.0f));
        baseTextView.setTextColor(-1);
        baseTextView.setGravity(17);
        baseTextView.setEllipsize(TextUtils.TruncateAt.END);
        baseTextView.setSingleLine();
        baseTextView.setPadding(com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f), com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f));
        Drawable drawable = context.getResources().getDrawable(R.drawable.opos_mobad_splash_right_side_arrow);
        drawable.setBounds(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f), com.opos.cmn.an.h.f.a.a(context, 15.0f), com.opos.cmn.an.h.f.a.a(context, 18.0f));
        baseTextView.setCompoundDrawables(null, null, drawable, null);
        return baseTextView;
    }

    public static final ViewGroup.LayoutParams c(Context context) {
        if (context == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d(context));
        layoutParams.addRule(12);
        return layoutParams;
    }

    public static int d(Context context) {
        if (context != null) {
            return (int) ((com.opos.cmn.an.h.f.a.b(context) * 0.3778f) + 0.5f);
        }
        return 504;
    }

    public static final PowerManager e(Context context) {
        if (f10100a == null) {
            f10100a = (PowerManager) context.getSystemService("power");
        }
        return f10100a;
    }

    public static final boolean f(Context context) {
        boolean zIsInteractive = true;
        if (context != null) {
            try {
                PowerManager powerManagerE = e(context);
                if (powerManagerE != null) {
                    zIsInteractive = powerManagerE.isInteractive();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SplashUtils", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("SplashUtils", "is screenOn = " + zIsInteractive);
        return zIsInteractive;
    }

    public static RelativeLayout.LayoutParams a(Context context, com.opos.mobad.template.d.b bVar, View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view instanceof com.opos.mobad.template.i.a) {
            layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f));
            view.setMinimumWidth(com.opos.cmn.an.h.f.a.a(context, 64.0f));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int i = bVar.m;
        layoutParams.topMargin = i != 1 ? i != 2 ? com.opos.cmn.an.h.f.a.a(context, 32.0f) : (com.opos.cmn.an.h.f.a.c(context) - d(context)) + com.opos.cmn.an.h.f.a.a(context, 12.0f) : (com.opos.cmn.an.h.f.a.c(context) - d(context)) - com.opos.cmn.an.h.f.a.a(context, 75.0f);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, 24.0f);
        return layoutParams;
    }

    public static final BaseTextView a(Context context) {
        BaseTextView baseTextView = new BaseTextView(context);
        baseTextView.setTextSize(0, com.opos.cmn.an.h.f.a.a(context, 18.0f));
        baseTextView.setTextColor(-1);
        baseTextView.setGravity(17);
        baseTextView.setEllipsize(TextUtils.TruncateAt.END);
        baseTextView.setSingleLine();
        baseTextView.setPadding(com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f), com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f));
        baseTextView.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_drawable_splash_click));
        Drawable drawable = context.getResources().getDrawable(R.drawable.opos_mobad_splash_right_side_arrow);
        drawable.setBounds(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f), com.opos.cmn.an.h.f.a.a(context, 17.0f));
        baseTextView.setCompoundDrawables(null, null, drawable, null);
        return baseTextView;
    }
}

package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n {
    public static int a(Context context) {
        if (context != null) {
            return (int) ((com.opos.cmn.an.h.f.a.b(context) * 0.3778f) + 0.5f);
        }
        return 504;
    }

    public static boolean a(ViewGroup viewGroup, View view) {
        boolean z = false;
        if (viewGroup != null && view != null) {
            try {
                if (view.getParent() == null) {
                    viewGroup.addView(view);
                    z = true;
                } else {
                    com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e);
            }
        }
        return z;
    }

    public static boolean a(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        boolean z = false;
        if (viewGroup != null && view != null) {
            try {
                if (view.getParent() == null) {
                    viewGroup.addView(view, layoutParams);
                    z = true;
                } else {
                    com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e);
            }
        }
        return z;
    }
}

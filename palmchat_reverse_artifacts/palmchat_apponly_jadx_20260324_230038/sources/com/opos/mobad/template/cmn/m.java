package com.opos.mobad.template.cmn;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m {
    public static void a(Context context, RelativeLayout relativeLayout, boolean z) {
        View relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setClickable(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 16.0f));
        layoutParams.addRule(12);
        relativeLayout.addView(relativeLayout2, layoutParams);
        if (z) {
            return;
        }
        View relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setClickable(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 16.0f), -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(relativeLayout3, layoutParams2);
    }
}

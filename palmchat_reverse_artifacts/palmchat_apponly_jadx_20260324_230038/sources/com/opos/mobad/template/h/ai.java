package com.opos.mobad.template.h;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9976a;
    private ViewGroup b;
    private BaseTextView c;
    private View d;
    private TextView e;
    private BaseImageView f;
    private a g;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public void a(int i, boolean z, String str) {
        BaseTextView baseTextView;
        String str2;
        View view;
        int i2 = 8;
        if ((i != 0 || z) && !(i == 0 && TextUtils.isEmpty(str))) {
            this.b.setVisibility(0);
            this.e.setVisibility(z ? 0 : 8);
            this.e.setText(str);
            boolean z2 = true;
            if (i == 1) {
                baseTextView = this.c;
                str2 = "跳过广告";
            } else if (i == 2) {
                baseTextView = this.c;
                str2 = "VIP免广告";
            } else {
                this.c.setVisibility(8);
                z2 = false;
                view = this.d;
                if (z && z2) {
                    i2 = 0;
                }
            }
            baseTextView.setText(str2);
            this.c.setVisibility(0);
            view = this.d;
            if (z) {
                i2 = 0;
            }
        } else {
            view = this.b;
        }
        view.setVisibility(i2);
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(boolean z) {
        BaseImageView baseImageView;
        Resources resources;
        int i;
        if (z) {
            baseImageView = this.f;
            resources = this.f9976a.getResources();
            i = R.drawable.opos_mobad_drawable_sound_on;
        } else {
            baseImageView = this.f;
            resources = this.f9976a.getResources();
            i = R.drawable.opos_mobad_drawable_sound_off;
        }
        baseImageView.setImageDrawable(resources.getDrawable(i));
    }
}

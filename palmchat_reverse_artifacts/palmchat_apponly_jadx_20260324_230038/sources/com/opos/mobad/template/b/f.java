package com.opos.mobad.template.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.f;
import com.opos.mobad.template.cmn.w;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f extends g {
    private ImageView l;
    private ImageView m;
    private boolean n;
    private w o;

    public f(Context context, int i, com.opos.mobad.d.a aVar, boolean z) {
        super(context, i, aVar, z);
    }

    @Override // com.opos.mobad.template.b.g
    public g a(List<Bitmap> list, int i) {
        if (this.d != null && list != null && !list.isEmpty()) {
            Bitmap bitmap = list.get(0);
            if (this.l != null) {
                com.opos.mobad.template.cmn.f.a(this.d, bitmap, 100, 1.0f, 60.0f, new f.a() { // from class: com.opos.mobad.template.b.f.1
                    @Override // com.opos.mobad.template.cmn.f.a
                    public void a() {
                    }

                    @Override // com.opos.mobad.template.cmn.f.a
                    public void a(Bitmap bitmap2) {
                        if (f.this.n) {
                            return;
                        }
                        f.this.a(bitmap2);
                    }
                });
            }
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                ViewGroup viewGroup = this.e;
                if (viewGroup != null) {
                    viewGroup.setBackgroundColor(0);
                }
            }
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.n = true;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.n || f.this.l == null) {
                    return;
                }
                f.this.l.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.opos.mobad.template.b.g
    public void b() {
        super.b();
        this.g = a.a((View) this.o);
    }

    @Override // com.opos.mobad.template.b.g
    public void a(ViewGroup viewGroup) {
        Context context = this.d;
        if (context == null) {
            return;
        }
        w wVar = new w(context);
        this.o = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.d, 8.0f));
        ImageView imageView = new ImageView(this.d);
        this.l = imageView;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.addView(this.l);
        ImageView imageView2 = new ImageView(this.d);
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(R.drawable.opos_mobad_bg_banner_icon_new_img);
        this.o.addView(imageView2);
        w wVar2 = new w(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        wVar2.setLayoutParams(layoutParams);
        ImageView imageView3 = new ImageView(this.d);
        this.m = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int iA = com.opos.cmn.an.h.f.a.a(this.d, 48.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(13);
        this.m.setLayoutParams(layoutParams2);
        wVar2.addView(this.m);
        this.o.addView(wVar2);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.d, 8.0f));
        viewGroup.addView(this.o);
    }
}

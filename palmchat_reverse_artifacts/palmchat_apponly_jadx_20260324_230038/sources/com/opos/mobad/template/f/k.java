package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseImageView f9534a;
    private h b;
    private a.InterfaceC0778a c;
    private Context d;

    public k(Context context) {
        super(context);
        if (context == null) {
            return;
        }
        this.d = context.getApplicationContext();
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        BaseImageView baseImageViewA = a(context);
        this.f9534a = baseImageViewA;
        addView(baseImageViewA);
        h hVar = new h(context, 1);
        this.b = hVar;
        addView(hVar);
    }

    @Override // com.opos.mobad.template.f.d
    public RelativeLayout a() {
        return this;
    }

    private BaseImageView a(Context context) {
        BaseImageView baseImageView = new BaseImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        baseImageView.setLayoutParams(layoutParams);
        return baseImageView;
    }

    @Override // com.opos.mobad.template.f.d
    public void a(Bitmap bitmap) {
        BaseImageView baseImageView;
        if (this.d == null || (baseImageView = this.f9534a) == null) {
            return;
        }
        baseImageView.setImageBitmap(bitmap);
    }

    @Override // com.opos.mobad.template.f.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(interfaceC0778a);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        BaseImageView baseImageView = this.f9534a;
        if (baseImageView != null) {
            baseImageView.a(fVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.p pVar) {
        BaseImageView baseImageView = this.f9534a;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.f9534a.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(bVar, bitmap);
        }
    }
}

package com.opos.mobad.template.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.opos.mobad.template.cmn.CarouselViewPager;
import com.opos.mobad.template.cmn.p;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends g {
    private CarouselViewPager l;
    private final int m;

    public h(Context context, int i, com.opos.mobad.d.a aVar, boolean z) {
        super(context, i, aVar, z);
        this.m = 3;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(p pVar) {
        super.a(pVar);
        CarouselViewPager carouselViewPager = this.l;
        if (carouselViewPager != null) {
            carouselViewPager.a(pVar);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a_(com.opos.mobad.template.cmn.baseview.f fVar) {
        super.a_(fVar);
        CarouselViewPager carouselViewPager = this.l;
        if (carouselViewPager != null) {
            carouselViewPager.a(fVar);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(List<Bitmap> list, int i) {
        if (this.d != null && list != null && !list.isEmpty()) {
            this.l.a(list);
            this.l.a(i);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public void a(ViewGroup viewGroup) {
        if (this.d == null) {
            return;
        }
        CarouselViewPager carouselViewPager = new CarouselViewPager(this.d, 3, false, ImageView.ScaleType.CENTER_CROP);
        this.l = carouselViewPager;
        if (viewGroup != null) {
            viewGroup.addView(carouselViewPager);
        }
    }
}

package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.imp.BigText.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k36;
import defpackage.k86;
import defpackage.me1;
import defpackage.mo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<mo> f12884a;
    public Context b;
    public LayoutInflater c;
    public b.InterfaceC0998b d;
    public int e;
    public GridView f;
    public int g = 0;

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.imp.BigText.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0997a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EffectiveShapeView f12885a;
        public ImageView b;

        public C0997a() {
        }
    }

    public a(Context context, List<mo> list, b.InterfaceC0998b interfaceC0998b, int i, GridView gridView) {
        this.b = context;
        this.f12884a = list;
        this.c = LayoutInflater.from(context);
        this.d = interfaceC0998b;
        this.e = i;
        this.f = gridView;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public mo getItem(int i) {
        List<mo> list = this.f12884a;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public void b(int i) {
        LogUtil.i("FontGridAdapter", "setSelectedBackground = " + i + ", pageIndex =  " + this.e + ", count = " + getCount());
        this.g = i;
        for (int i2 = 0; i2 < getCount(); i2++) {
            LogUtil.i("FontGridAdapter", "SelectedId = " + getItem(i2).f19278a + ", i =  " + i2);
            if (this.g == getItem(i2).f19278a) {
                View childAt = this.f.getChildAt(i2);
                if (childAt != null) {
                    ((C0997a) childAt.getTag()).b.setVisibility(0);
                }
            } else {
                View childAt2 = this.f.getChildAt(i2);
                if (childAt2 != null) {
                    ((C0997a) childAt2.getTag()).b.setVisibility(8);
                }
            }
        }
    }

    public void c(int i) {
        this.g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<mo> list = this.f12884a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        C0997a c0997a;
        if (view == null) {
            c0997a = new C0997a();
            viewInflate = this.c.inflate(R.layout.layout_background_item, (ViewGroup) null);
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.background);
            c0997a.f12885a = effectiveShapeView;
            effectiveShapeView.changeShapeType(3);
            c0997a.f12885a.setDegreeForRoundRectangle(22, 22);
            c0997a.b = (ImageView) viewInflate.findViewById(R.id.background_selected);
            viewInflate.setTag(c0997a);
        } else {
            viewInflate = view;
            c0997a = (C0997a) view.getTag();
        }
        mo item = getItem(i);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(k36.b(50.0f), k36.b(50.0f), Bitmap.Config.RGB_565);
            bitmapCreateBitmap.eraseColor(Color.parseColor(item.b));
            c0997a.f12885a.setImageBitmap(bitmapCreateBitmap);
        } catch (IllegalArgumentException e) {
            LogUtil.i("FontGridAdapter", "IllegalArgumentException e = " + e);
        }
        if (this.g == item.f19278a) {
            c0997a.b.setVisibility(0);
        } else {
            c0997a.b.setVisibility(8);
        }
        LogUtil.i("FontGridAdapter", "currentPageIndex  = " + this.e + ", position = " + i);
        if (this.e == 0 && i == 0) {
            c0997a.f12885a.setBorderColor(Color.parseColor("#cccccc"));
            c0997a.f12885a.setBorderWidth(me1.a(this.b, 0.5f));
        }
        gr2.j().h(k86.p(item.d), c0997a.f12885a, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.color.white).r());
        return viewInflate;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f.requestLayout();
    }
}

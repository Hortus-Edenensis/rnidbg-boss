package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.imp.BigText.e;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.v02;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<v02> f12890a;
    public Context b;
    public LayoutInflater c;
    public e.b d;
    public int e;
    public int f = 0;
    public GridView g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f12891a;
        public TextView b;
        public ImageView c;
        public ProgressBar d;
        public ImageView e;
        public v02 f;
    }

    public d(Context context, List<v02> list, e.b bVar, int i, GridView gridView) {
        this.b = context;
        this.f12890a = list;
        this.c = LayoutInflater.from(context);
        this.d = bVar;
        this.e = i;
        this.g = gridView;
    }

    public a a(int i) {
        for (int i2 = 0; i2 < getCount(); i2++) {
            if (i == getItem(i2).f21335a) {
                return (a) this.g.getChildAt(i2).getTag();
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v02 getItem(int i) {
        List<v02> list = this.f12890a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public void c(int i) {
        LogUtil.i("FontGridAdapter", "setSelectedFont = " + i + ", pageIndex =  " + this.e + ", count = " + getCount());
        this.f = i;
        for (int i2 = 0; i2 < getCount(); i2++) {
            LogUtil.i("FontGridAdapter", "SelectedId = " + getItem(i2).f21335a + ", i =  " + i2);
            if (this.f == getItem(i2).f21335a) {
                a aVar = (a) this.g.getChildAt(i2).getTag();
                aVar.c.setVisibility(0);
                aVar.e.setVisibility(8);
                aVar.d.setVisibility(8);
            } else {
                ((a) this.g.getChildAt(i2).getTag()).c.setVisibility(8);
            }
        }
    }

    public void e(int i) {
        this.f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<v02> list = this.f12890a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        v02 item = getItem(i);
        if (view == null) {
            aVar = new a();
            viewInflate = this.c.inflate(R.layout.layout_font_item, (ViewGroup) null);
            aVar.f12891a = (ImageView) viewInflate.findViewById(R.id.fontImage);
            aVar.b = (TextView) viewInflate.findViewById(R.id.fontText);
            aVar.c = (ImageView) viewInflate.findViewById(R.id.font_selected);
            aVar.d = (ProgressBar) viewInflate.findViewById(R.id.font_progress);
            aVar.e = (ImageView) viewInflate.findViewById(R.id.font_mask);
            aVar.f = item;
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.b.setText(item.b);
        if (this.f == item.f21335a) {
            aVar.c.setVisibility(0);
        } else {
            aVar.c.setVisibility(8);
        }
        if (c.b(item) != null || (i == 0 && this.e == 0)) {
            aVar.e.setVisibility(8);
        } else {
            aVar.e.setVisibility(0);
        }
        if (i == 0 && this.e == 0) {
            aVar.f12891a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.font_default));
        } else {
            gr2.j().h(k86.p(item.c), aVar.f12891a, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        }
        return viewInflate;
    }
}

package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.imp.BigText.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g03;
import defpackage.me1;
import defpackage.mo;
import defpackage.vs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BackgroundPageAdapter extends PagerAdapter {
    public static String g = "BackgroundPageAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12869a;
    public BigTextViewPager b;
    public com.zenmen.palmchat.chat.imp.BigText.a c;
    public b.InterfaceC0998b e;
    public int f = 0;
    public List<mo> d = vs.a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridView f12870a;

        public a(GridView gridView) {
            this.f12870a = gridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            mo moVar = (mo) this.f12870a.getAdapter().getItem(i);
            BackgroundPageAdapter.this.f = moVar.f19278a;
            BackgroundPageAdapter.this.e.a(moVar);
            ((com.zenmen.palmchat.chat.imp.BigText.a) this.f12870a.getAdapter()).b(BackgroundPageAdapter.this.f);
        }
    }

    public BackgroundPageAdapter(Context context, BigTextViewPager bigTextViewPager, b.InterfaceC0998b interfaceC0998b) {
        this.f12869a = context;
        this.b = bigTextViewPager;
        this.e = interfaceC0998b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        Runtime.getRuntime().gc();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.d != null) {
            return (int) Math.ceil(r0.size() / 15.0f);
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public final int i(int i, int i2) {
        int iD = g03.d() - ((int) (this.f12869a.getResources().getDimension(R.dimen.expression_pager_indicator) + me1.b(com.zenmen.palmchat.c.b(), 1)));
        if (iD != 0) {
            return (iD - (i2 * i)) / (i + 1);
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2;
        GridView gridView = new GridView(this.f12869a);
        gridView.setCacheColorHint(this.f12869a.getResources().getColor(android.R.color.transparent));
        gridView.setSelector(android.R.color.transparent);
        gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int i3 = i(3, me1.b(this.f12869a, 50));
        gridView.setPadding(me1.b(this.f12869a, 19), i3, me1.b(this.f12869a, 19), i3);
        gridView.setVerticalSpacing(i3);
        gridView.setNumColumns(5);
        ArrayList arrayList = new ArrayList();
        List<mo> list = this.d;
        if (list != null && list.size() > 0) {
            LogUtil.i(g, "backgroundConfigs size = " + this.d.size() + ", pageCount = " + getCount());
            int i4 = i * 15;
            int i5 = (i + 1) * 15;
            if (i == 0) {
                arrayList.add(new mo(0, "#FFFFFF", "#000000", null, null));
                i2 = 1;
            } else {
                i2 = 0;
            }
            for (int i6 = 0; i6 < this.d.size(); i6++) {
                if (i == 0) {
                    if (i2 >= i4 && i2 < i5) {
                        arrayList.add(this.d.get(i6));
                        LogUtil.i(g, "currentPageConfigs index = " + i2 + "; i = " + i6 + ", position = " + i);
                    }
                } else if (i == getCount() - 1) {
                    if (i2 >= i4 - 1 && i2 < i5) {
                        arrayList.add(this.d.get(i6));
                        LogUtil.i(g, "currentPageConfigs index = " + i2 + "; i = " + i6 + ", position = " + i);
                    }
                } else if (i2 >= i4 - 1 && i2 < i5 - 1) {
                    arrayList.add(this.d.get(i6));
                    LogUtil.i(g, "currentPageConfigs index = " + i2 + "; i = " + i6 + ", position = " + i);
                }
                i2++;
            }
            LogUtil.i(g, "currentPageConfigs size = " + arrayList.size() + ", position = " + i);
        }
        com.zenmen.palmchat.chat.imp.BigText.a aVar = new com.zenmen.palmchat.chat.imp.BigText.a(this.f12869a, arrayList, this.e, i, gridView);
        this.c = aVar;
        gridView.setAdapter((ListAdapter) aVar);
        this.c.c(this.f);
        gridView.setOnItemClickListener(new a(gridView));
        viewGroup.addView(gridView);
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(int i) {
        LogUtil.i(g, "onPageSelected, selected = " + this.f + ", pageIndex = " + i);
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            ((com.zenmen.palmchat.chat.imp.BigText.a) ((GridView) this.b.getChildAt(i2)).getAdapter()).b(this.f);
        }
    }

    public void k(int i) {
        this.f = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        for (int i = 0; i < this.b.getChildCount(); i++) {
            this.b.getChildAt(i).requestLayout();
        }
    }
}

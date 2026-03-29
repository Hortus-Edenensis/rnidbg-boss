package com.zenmen.palmchat.ui.widget.expression;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.R$dimen;
import com.zenmen.palmchat.ui.widget.expression.a;
import defpackage.g03;
import defpackage.me1;
import defpackage.ul1;
import defpackage.vl1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ExpressionPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15615a;
    public ExpressionViewPager b;
    public a.c c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f15616a;

        public a(ExpressionGridView expressionGridView) {
            this.f15616a = expressionGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((String) adapterView.getItemAtPosition(i)).equals(vl1.n)) {
                if (ExpressionPagerAdapter.this.c != null) {
                    ExpressionPagerAdapter.this.c.a();
                }
            } else if (ExpressionPagerAdapter.this.c != null) {
                ExpressionPagerAdapter.this.c.b((String) this.f15616a.getAdapter().getItem(i), false);
            }
        }
    }

    public ExpressionPagerAdapter(Context context, a.c cVar, ExpressionViewPager expressionViewPager) {
        this.f15615a = context;
        this.c = cVar;
        this.b = expressionViewPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        Runtime.getRuntime().gc();
    }

    public int g() {
        return (int) Math.ceil((vl1.f().size() - 1) / 20.0f);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return g();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public final int h(int i, int i2) {
        int iD = g03.d() - ((int) ((this.f15615a.getResources().getDimension(R$dimen.expression_setting_height) + this.f15615a.getResources().getDimension(R$dimen.expression_pager_indicator)) + me1.b(c.b(), 1)));
        if (iD != 0) {
            return (iD - (i2 * i)) / (i + 1);
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ExpressionGridView expressionGridView = new ExpressionGridView(this.f15615a);
        expressionGridView.setCacheColorHint(this.f15615a.getResources().getColor(R.color.transparent));
        expressionGridView.setSelector(R.color.transparent);
        expressionGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int iH = h(3, (int) this.f15615a.getResources().getDimension(R$dimen.emoji_item_size));
        expressionGridView.setPadding(me1.b(this.f15615a, 6), iH, me1.b(this.f15615a, 6), iH);
        expressionGridView.setVerticalSpacing(iH);
        expressionGridView.setNumColumns(7);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = vl1.f().entrySet().iterator();
        int i2 = i * 20;
        int i3 = (i + 1) * 20;
        int i4 = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (i4 >= i2 && i4 < i3) {
                arrayList.add(key);
            }
            i4++;
        }
        if (!((String) arrayList.get(arrayList.size() - 1)).equals(vl1.n)) {
            arrayList.add(vl1.n);
        }
        expressionGridView.setAdapter((ListAdapter) new ul1(this.f15615a, arrayList));
        expressionGridView.setOnItemClickListener(new a(expressionGridView));
        viewGroup.addView(expressionGridView);
        return expressionGridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        for (int i = 0; i < this.b.getChildCount(); i++) {
            this.b.getChildAt(i).requestLayout();
        }
    }
}

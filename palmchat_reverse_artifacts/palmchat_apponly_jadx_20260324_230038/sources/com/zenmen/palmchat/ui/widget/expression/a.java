package com.zenmen.palmchat.ui.widget.expression;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f15617a;
    public ExpressionViewPager b;
    public LinearLayout c;
    public Context d;
    public ExpressionPagerAdapter e;
    public View f;
    public boolean g;

    /* JADX INFO: renamed from: com.zenmen.palmchat.ui.widget.expression.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1114a implements View.OnClickListener {
        public ViewOnClickListenerC1114a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b.setCurrentItem(0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void b(String str, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    public a(Context context, ViewGroup viewGroup, d dVar, c cVar) {
        this.f15617a = viewGroup;
        this.d = context;
        this.b = (ExpressionViewPager) viewGroup.findViewById(R$id.faceViewPager);
        this.c = (LinearLayout) viewGroup.findViewById(R$id.facePagerIndicator);
        View viewFindViewById = viewGroup.findViewById(R$id.input_expression_emoji);
        this.f = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC1114a());
        ExpressionPagerAdapter expressionPagerAdapter = new ExpressionPagerAdapter(context, cVar, this.b);
        this.e = expressionPagerAdapter;
        this.b.setAdapter(expressionPagerAdapter);
        this.b.addOnPageChangeListener(new b());
        e(false);
    }

    public final void d(int i) {
        this.c.removeAllViews();
        if (i > 1) {
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = new ImageView(this.d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, me1.b(this.d, 10), 0);
                imageView.setImageResource(R$drawable.state_ball_selector);
                imageView.setLayoutParams(layoutParams);
                if (i2 == 0) {
                    imageView.setSelected(true);
                } else {
                    imageView.setSelected(false);
                }
                this.c.addView(imageView);
            }
        }
    }

    public final void e(boolean z) {
        int currentItem = this.b.getCurrentItem();
        boolean z2 = currentItem < this.e.g();
        if (z2) {
            this.f.setSelected(true);
        } else {
            this.f.setSelected(false);
        }
        d(this.e.g());
        if (!z2) {
            currentItem -= this.e.g();
        }
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            if (i == currentItem) {
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
        }
    }

    public void f() {
        this.b.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            a.this.g = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.e(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}

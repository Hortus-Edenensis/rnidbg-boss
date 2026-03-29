package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.R;
import defpackage.me1;
import defpackage.v02;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f12892a;
    public BigTextViewPager b;
    public LinearLayout c;
    public Context d;
    public FontPageAdapter e;
    public int f = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(v02 v02Var, String str);
    }

    public e(Context context, ViewGroup viewGroup, b bVar) {
        this.f12892a = viewGroup;
        this.d = context;
        this.b = (BigTextViewPager) viewGroup.findViewById(R.id.fontViewPager);
        this.c = (LinearLayout) viewGroup.findViewById(R.id.fontIndicator);
        FontPageAdapter fontPageAdapter = new FontPageAdapter(context, this.b, bVar);
        this.e = fontPageAdapter;
        this.b.setAdapter(fontPageAdapter);
        this.b.addOnPageChangeListener(new a());
        e(false);
    }

    public final void c(int i) {
        this.c.removeAllViews();
        if (i > 1) {
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = new ImageView(this.d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, me1.b(this.d, 10), 0);
                imageView.setImageResource(R.drawable.state_ball_selector);
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

    public void d(int i) {
        this.f = i;
    }

    public final void e(boolean z) {
        int currentItem = this.b.getCurrentItem();
        c(this.e.getCount());
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
        this.e.u(this.f);
        this.b.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            e.this.e(false);
            e.this.e.t(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}

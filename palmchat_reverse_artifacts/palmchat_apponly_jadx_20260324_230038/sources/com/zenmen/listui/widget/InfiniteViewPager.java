package com.zenmen.listui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class InfiniteViewPager extends ViewPager {
    public InfiniteViewPager(@NonNull Context context) {
        super(context);
    }

    private void setFirstLayout() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mFirstLayout");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        if (Math.abs(i - getCurrentItem()) > 3) {
            setFirstLayout();
        }
        super.setCurrentItem(i);
    }

    public InfiniteViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        if (Math.abs(i - getCurrentItem()) > 3) {
            setFirstLayout();
        }
        super.setCurrentItem(i, z);
    }
}

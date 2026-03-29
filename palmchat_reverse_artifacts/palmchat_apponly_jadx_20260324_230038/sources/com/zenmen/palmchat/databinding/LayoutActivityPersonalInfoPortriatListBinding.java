package com.zenmen.palmchat.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.peoplematch.view.LoopingViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutActivityPersonalInfoPortriatListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f13901a;

    @NonNull
    public final LoopingViewPager b;

    @NonNull
    public final View c;

    public LayoutActivityPersonalInfoPortriatListBinding(Object obj, View view, int i, FrameLayout frameLayout, LoopingViewPager loopingViewPager, View view2) {
        super(obj, view, i);
        this.f13901a = frameLayout;
        this.b = loopingViewPager;
        this.c = view2;
    }
}

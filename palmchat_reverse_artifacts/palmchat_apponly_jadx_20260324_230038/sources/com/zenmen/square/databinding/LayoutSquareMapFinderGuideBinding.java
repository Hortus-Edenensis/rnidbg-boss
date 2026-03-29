package com.zenmen.square.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.VenusPortraitView;
import com.zenmen.square.util.conf.MapFinderConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareMapFinderGuideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LeftDrawableText f16231a;

    @NonNull
    public final VenusPortraitView b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TextView d;

    @Bindable
    public MapFinderConfig.RecommendEntry e;

    public LayoutSquareMapFinderGuideBinding(Object obj, View view, int i, LeftDrawableText leftDrawableText, VenusPortraitView venusPortraitView, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.f16231a = leftDrawableText;
        this.b = venusPortraitView;
        this.c = relativeLayout;
        this.d = textView;
    }

    public abstract void b(@Nullable MapFinderConfig.RecommendEntry recommendEntry);
}

package com.zenmen.square.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.find.holder.NearbyMapFinderGuideViewHolder;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.VenusPortraitView;
import com.zenmen.square.R$id;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareMapFinderGuideBindingImpl extends LayoutSquareMapFinderGuideBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts j = null;

    @Nullable
    public static final SparseIntArray k;

    @NonNull
    public final FrameLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;
    public long i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R$id.root_content, 6);
    }

    public LayoutSquareMapFinderGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, j, k));
    }

    @Override // com.zenmen.square.databinding.LayoutSquareMapFinderGuideBinding
    public void b(@Nullable MapFinderConfig.RecommendEntry recommendEntry) {
        this.e = recommendEntry;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(ko.g);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j2 = this.i;
            this.i = 0L;
        }
        MapFinderConfig.RecommendEntry recommendEntry = this.e;
        long j3 = j2 & 3;
        if (j3 == 0 || recommendEntry == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        } else {
            str = recommendEntry.text1;
            str2 = recommendEntry.text2;
            str3 = recommendEntry.button_text;
            str4 = recommendEntry.text3;
            str5 = recommendEntry.pic;
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f16231a, str3);
            this.mBindingComponent.getNearbyMapFinderGuideViewHolder().r(this.b, str5);
            TextViewBindingAdapter.setText(this.g, str2);
            TextViewBindingAdapter.setText(this.h, str4);
            TextViewBindingAdapter.setText(this.d, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.g != i) {
            return false;
        }
        b((MapFinderConfig.RecommendEntry) obj);
        return true;
    }

    public LayoutSquareMapFinderGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LeftDrawableText) objArr[5], (VenusPortraitView) objArr[1], (RelativeLayout) objArr[6], (TextView) objArr[2]);
        this.i = -1L;
        ensureBindingComponentIsNotNull(NearbyMapFinderGuideViewHolder.class);
        this.f16231a.setTag(null);
        this.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.h = textView2;
        textView2.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

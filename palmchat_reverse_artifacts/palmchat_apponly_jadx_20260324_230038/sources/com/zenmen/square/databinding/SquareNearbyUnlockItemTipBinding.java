package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareNearbyUnlockItemTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16242a;

    public SquareNearbyUnlockItemTipBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f16242a = textView;
    }

    @NonNull
    public static SquareNearbyUnlockItemTipBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareNearbyUnlockItemTipBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareNearbyUnlockItemTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_nearby_unlock_item_tip, null, false, obj);
    }
}

package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareGenericListItemAdGroupItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EffectiveShapeView f16238a;

    public SquareGenericListItemAdGroupItemBinding(Object obj, View view, int i, EffectiveShapeView effectiveShapeView) {
        super(obj, view, i);
        this.f16238a = effectiveShapeView;
    }

    @NonNull
    public static SquareGenericListItemAdGroupItemBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareGenericListItemAdGroupItemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareGenericListItemAdGroupItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_generic_list_item_ad_group_item, null, false, obj);
    }
}

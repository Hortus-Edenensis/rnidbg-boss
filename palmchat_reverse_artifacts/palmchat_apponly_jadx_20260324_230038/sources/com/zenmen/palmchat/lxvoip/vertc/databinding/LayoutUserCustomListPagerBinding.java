package com.zenmen.palmchat.lxvoip.vertc.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.view.CustomUserRenderView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class LayoutUserCustomListPagerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f14592a;

    @NonNull
    public final CustomUserRenderView b;

    @NonNull
    public final RecyclerView c;

    public LayoutUserCustomListPagerBinding(@NonNull FrameLayout frameLayout, @NonNull CustomUserRenderView customUserRenderView, @NonNull RecyclerView recyclerView) {
        this.f14592a = frameLayout;
        this.b = customUserRenderView;
        this.c = recyclerView;
    }

    @NonNull
    public static LayoutUserCustomListPagerBinding a(@NonNull View view) {
        int i = R$id.main_user_view;
        CustomUserRenderView customUserRenderView = (CustomUserRenderView) ViewBindings.findChildViewById(view, i);
        if (customUserRenderView != null) {
            i = R$id.user_list_rv;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                return new LayoutUserCustomListPagerBinding((FrameLayout) view, customUserRenderView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f14592a;
    }
}

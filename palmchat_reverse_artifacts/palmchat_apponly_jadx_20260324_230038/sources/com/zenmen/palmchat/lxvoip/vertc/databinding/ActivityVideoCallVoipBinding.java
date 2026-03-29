package com.zenmen.palmchat.lxvoip.vertc.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class ActivityVideoCallVoipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14579a;

    @NonNull
    public final ViewStub b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final ViewStub e;

    @NonNull
    public final ViewStub f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextureView i;

    @NonNull
    public final ViewStub j;

    @NonNull
    public final ViewStub k;

    public ActivityVideoCallVoipBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextureView textureView, @NonNull ViewStub viewStub4, @NonNull ViewStub viewStub5) {
        this.f14579a = constraintLayout;
        this.b = viewStub;
        this.c = frameLayout;
        this.d = constraintLayout2;
        this.e = viewStub2;
        this.f = viewStub3;
        this.g = textView;
        this.h = imageView;
        this.i = textureView;
        this.j = viewStub4;
        this.k = viewStub5;
    }

    @NonNull
    public static ActivityVideoCallVoipBinding a(@NonNull View view) {
        int i = R$id.group_call_panel_vs;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
        if (viewStub != null) {
            i = R$id.root_view_in_pip;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R$id.root_view_non_pip;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R$id.video_call_panel_vs;
                    ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
                    if (viewStub2 != null) {
                        i = R$id.video_match_panel_vs;
                        ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i);
                        if (viewStub3 != null) {
                            i = R$id.video_pip_call_status;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.video_pip_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R$id.video_pip_render_view;
                                    TextureView textureView = (TextureView) ViewBindings.findChildViewById(view, i);
                                    if (textureView != null) {
                                        i = R$id.voice_call_panel_vs;
                                        ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i);
                                        if (viewStub4 != null) {
                                            i = R$id.voice_match_panel_vs;
                                            ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, i);
                                            if (viewStub5 != null) {
                                                return new ActivityVideoCallVoipBinding((ConstraintLayout) view, viewStub, frameLayout, constraintLayout, viewStub2, viewStub3, textView, imageView, textureView, viewStub4, viewStub5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityVideoCallVoipBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityVideoCallVoipBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_video_call_voip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14579a;
    }
}

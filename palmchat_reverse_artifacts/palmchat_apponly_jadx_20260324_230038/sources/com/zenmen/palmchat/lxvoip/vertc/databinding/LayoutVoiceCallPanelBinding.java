package com.zenmen.palmchat.lxvoip.vertc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class LayoutVoiceCallPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14596a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final EffectiveShapeView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final LinearLayout n;

    @NonNull
    public final TextView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    @NonNull
    public final ImageView s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final TextView u;

    @NonNull
    public final ConstraintLayout v;

    public LayoutVoiceCallPanelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull EffectiveShapeView effectiveShapeView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout4, @NonNull TextView textView5, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout5, @NonNull TextView textView6, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout6, @NonNull TextView textView7, @NonNull ConstraintLayout constraintLayout2) {
        this.f14596a = constraintLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = textView;
        this.e = linearLayout2;
        this.f = textView2;
        this.g = effectiveShapeView;
        this.h = imageView2;
        this.i = linearLayout3;
        this.j = textView3;
        this.k = textView4;
        this.l = imageView3;
        this.m = imageView4;
        this.n = linearLayout4;
        this.o = textView5;
        this.p = imageView5;
        this.q = linearLayout5;
        this.r = textView6;
        this.s = imageView6;
        this.t = linearLayout6;
        this.u = textView7;
        this.v = constraintLayout2;
    }

    @NonNull
    public static LayoutVoiceCallPanelBinding a(@NonNull View view) {
        int i = R$id.accept_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.accept_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R$id.accept_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.audio_headimage_area;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R$id.audio_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R$id.audio_portrait;
                            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) ViewBindings.findChildViewById(view, i);
                            if (effectiveShapeView != null) {
                                i = R$id.background;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R$id.button_layout;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout3 != null) {
                                        i = R$id.call_duration;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R$id.calling_hint_tv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R$id.float_iv;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView3 != null) {
                                                    i = R$id.hangup_iv;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView4 != null) {
                                                        i = R$id.hangup_layout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R$id.hangup_tv;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R$id.silence_iv;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView5 != null) {
                                                                    i = R$id.silence_layout;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout5 != null) {
                                                                        i = R$id.silence_tv;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R$id.speaker_iv;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView6 != null) {
                                                                                i = R$id.speaker_layout;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout6 != null) {
                                                                                    i = R$id.speaker_tv;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                        return new LayoutVoiceCallPanelBinding(constraintLayout, imageView, linearLayout, textView, linearLayout2, textView2, effectiveShapeView, imageView2, linearLayout3, textView3, textView4, imageView3, imageView4, linearLayout4, textView5, imageView5, linearLayout5, textView6, imageView6, linearLayout6, textView7, constraintLayout);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14596a;
    }
}

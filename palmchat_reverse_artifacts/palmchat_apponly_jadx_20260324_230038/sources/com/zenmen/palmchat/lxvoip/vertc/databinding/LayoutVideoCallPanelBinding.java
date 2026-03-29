package com.zenmen.palmchat.lxvoip.vertc.databinding;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
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
public final class LayoutVideoCallPanelBinding implements ViewBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final TextView B;

    @NonNull
    public final ImageView C;

    @NonNull
    public final LinearLayout E;

    @NonNull
    public final TextView F;

    @NonNull
    public final ImageView G;

    @NonNull
    public final ConstraintLayout H;

    @NonNull
    public final TextureView I;

    @NonNull
    public final FrameLayout J;

    @NonNull
    public final TextureView K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14594a;

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
    public final ImageView i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final LinearLayout n;

    @NonNull
    public final TextView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final LinearLayout r;

    @NonNull
    public final TextView s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final ImageView u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final LinearLayout w;

    @NonNull
    public final ImageView x;

    @NonNull
    public final LinearLayout y;

    @NonNull
    public final ImageView z;

    public LayoutVideoCallPanelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull EffectiveShapeView effectiveShapeView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout4, @NonNull TextView textView5, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout5, @NonNull TextView textView6, @NonNull LinearLayout linearLayout6, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout7, @NonNull LinearLayout linearLayout8, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout9, @NonNull ImageView imageView9, @NonNull LinearLayout linearLayout10, @NonNull TextView textView7, @NonNull ImageView imageView10, @NonNull LinearLayout linearLayout11, @NonNull TextView textView8, @NonNull ImageView imageView11, @NonNull ConstraintLayout constraintLayout2, @NonNull TextureView textureView, @NonNull FrameLayout frameLayout, @NonNull TextureView textureView2) {
        this.f14594a = constraintLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = textView;
        this.e = linearLayout2;
        this.f = textView2;
        this.g = effectiveShapeView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = linearLayout3;
        this.k = textView3;
        this.l = textView4;
        this.m = imageView4;
        this.n = linearLayout4;
        this.o = textView5;
        this.p = imageView5;
        this.q = imageView6;
        this.r = linearLayout5;
        this.s = textView6;
        this.t = linearLayout6;
        this.u = imageView7;
        this.v = linearLayout7;
        this.w = linearLayout8;
        this.x = imageView8;
        this.y = linearLayout9;
        this.z = imageView9;
        this.A = linearLayout10;
        this.B = textView7;
        this.C = imageView10;
        this.E = linearLayout11;
        this.F = textView8;
        this.G = imageView11;
        this.H = constraintLayout2;
        this.I = textureView;
        this.J = frameLayout;
        this.K = textureView2;
    }

    @NonNull
    public static LayoutVideoCallPanelBinding a(@NonNull View view) {
        int i = R$id.accept_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.accept_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R$id.accept_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.act_button_layout;
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
                                    i = R$id.background_fl;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R$id.button_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R$id.call_duration;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R$id.calling_hint_tv;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R$id.camera_iv;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView4 != null) {
                                                        i = R$id.camera_layout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R$id.camera_tv;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R$id.float_iv;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView5 != null) {
                                                                    i = R$id.hangup_iv;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView6 != null) {
                                                                        i = R$id.hangup_layout;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout5 != null) {
                                                                            i = R$id.hangup_tv;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R$id.headimage_area;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout6 != null) {
                                                                                    i = R$id.pre_accept_iv;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView7 != null) {
                                                                                        i = R$id.pre_accept_layout;
                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout7 != null) {
                                                                                            i = R$id.pre_button_layout;
                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout8 != null) {
                                                                                                i = R$id.pre_hangup_iv;
                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView8 != null) {
                                                                                                    i = R$id.pre_hangup_layout;
                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout9 != null) {
                                                                                                        i = R$id.silence_iv;
                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView9 != null) {
                                                                                                            i = R$id.silence_layout;
                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout10 != null) {
                                                                                                                i = R$id.silence_tv;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R$id.speaker_iv;
                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (imageView10 != null) {
                                                                                                                        i = R$id.speaker_layout;
                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout11 != null) {
                                                                                                                            i = R$id.speaker_tv;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R$id.swap_iv;
                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (imageView11 != null) {
                                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                                                                    i = R$id.video_screen_render_sv;
                                                                                                                                    TextureView textureView = (TextureView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textureView != null) {
                                                                                                                                        i = R$id.video_window_render_fl;
                                                                                                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (frameLayout != null) {
                                                                                                                                            i = R$id.video_window_render_sv;
                                                                                                                                            TextureView textureView2 = (TextureView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textureView2 != null) {
                                                                                                                                                return new LayoutVideoCallPanelBinding(constraintLayout, imageView, linearLayout, textView, linearLayout2, textView2, effectiveShapeView, imageView2, imageView3, linearLayout3, textView3, textView4, imageView4, linearLayout4, textView5, imageView5, imageView6, linearLayout5, textView6, linearLayout6, imageView7, linearLayout7, linearLayout8, imageView8, linearLayout9, imageView9, linearLayout10, textView7, imageView10, linearLayout11, textView8, imageView11, constraintLayout, textureView, frameLayout, textureView2);
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
        return this.f14594a;
    }
}

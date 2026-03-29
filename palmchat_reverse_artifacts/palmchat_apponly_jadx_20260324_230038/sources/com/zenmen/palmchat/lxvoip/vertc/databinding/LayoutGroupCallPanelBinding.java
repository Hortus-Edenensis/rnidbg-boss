package com.zenmen.palmchat.lxvoip.vertc.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.view.CustomUserListPagerLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class LayoutGroupCallPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14590a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final TextView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final RecyclerView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final ImageView r;

    @NonNull
    public final LinearLayout s;

    @NonNull
    public final TextView t;

    @NonNull
    public final ImageView u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final TextView w;

    @NonNull
    public final ImageView x;

    @NonNull
    public final CustomUserListPagerLayout y;

    @NonNull
    public final ConstraintLayout z;

    public LayoutGroupCallPanelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout3, @NonNull TextView textView3, @NonNull ImageView imageView5, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout5, @NonNull RecyclerView recyclerView, @NonNull TextView textView4, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout6, @NonNull TextView textView5, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout7, @NonNull TextView textView6, @NonNull ImageView imageView9, @NonNull CustomUserListPagerLayout customUserListPagerLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.f14590a = constraintLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = imageView2;
        this.e = imageView3;
        this.f = linearLayout2;
        this.g = textView;
        this.h = textView2;
        this.i = imageView4;
        this.j = linearLayout3;
        this.k = textView3;
        this.l = imageView5;
        this.m = linearLayout4;
        this.n = imageView6;
        this.o = linearLayout5;
        this.p = recyclerView;
        this.q = textView4;
        this.r = imageView7;
        this.s = linearLayout6;
        this.t = textView5;
        this.u = imageView8;
        this.v = linearLayout7;
        this.w = textView6;
        this.x = imageView9;
        this.y = customUserListPagerLayout;
        this.z = constraintLayout2;
    }

    @NonNull
    public static LayoutGroupCallPanelBinding a(@NonNull View view) {
        int i = R$id.accept_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.accept_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R$id.btn_float;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R$id.btn_invite;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R$id.button_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R$id.call_duration;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.calling_hint_tv;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.camera_iv;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R$id.camera_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R$id.camera_tv;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R$id.hangup_iv;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R$id.hangup_layout;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout4 != null) {
                                                        i = R$id.invite_icon;
                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView6 != null) {
                                                            i = R$id.invite_layout;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout5 != null) {
                                                                i = R$id.invite_list;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                if (recyclerView != null) {
                                                                    i = R$id.invite_name;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R$id.silence_iv;
                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView7 != null) {
                                                                            i = R$id.silence_layout;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout6 != null) {
                                                                                i = R$id.silence_tv;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R$id.speaker_iv;
                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView8 != null) {
                                                                                        i = R$id.speaker_layout;
                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout7 != null) {
                                                                                            i = R$id.speaker_tv;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView6 != null) {
                                                                                                i = R$id.swap_iv;
                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView9 != null) {
                                                                                                    i = R$id.user_list_pager_layout;
                                                                                                    CustomUserListPagerLayout customUserListPagerLayout = (CustomUserListPagerLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (customUserListPagerLayout != null) {
                                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                                        return new LayoutGroupCallPanelBinding(constraintLayout, imageView, linearLayout, imageView2, imageView3, linearLayout2, textView, textView2, imageView4, linearLayout3, textView3, imageView5, linearLayout4, imageView6, linearLayout5, recyclerView, textView4, imageView7, linearLayout6, textView5, imageView8, linearLayout7, textView6, imageView9, customUserListPagerLayout, constraintLayout);
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
        return this.f14590a;
    }
}

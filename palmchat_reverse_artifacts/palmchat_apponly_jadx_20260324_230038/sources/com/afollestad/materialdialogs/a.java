package com.afollestad.materialdialogs;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import defpackage.ed1;
import defpackage.sb3;
import defpackage.wd3;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static ColorStateList a(Context context, int i) {
        int iG = ed1.g(context, R.attr.textColorPrimary);
        if (i == 0) {
            i = iG;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{ed1.a(i, 0.4f), i});
    }

    public static int b(MaterialDialog.d dVar) {
        if (dVar.o != null) {
            return R$layout.md_dialog_custom;
        }
        CharSequence[] charSequenceArr = dVar.k;
        return ((charSequenceArr == null || charSequenceArr.length <= 0) && dVar.L == null) ? dVar.X > -2 ? R$layout.md_dialog_progress : dVar.V ? R$layout.md_dialog_progress_indeterminate : dVar.b0 != null ? R$layout.md_dialog_input : R$layout.md_dialog_basic : R$layout.md_dialog_list;
    }

    public static int c(MaterialDialog.d dVar) {
        Context context = dVar.f2502a;
        int i = R$attr.md_dark_theme;
        Theme theme = dVar.A;
        Theme theme2 = Theme.DARK;
        boolean zF = ed1.f(context, i, theme == theme2);
        if (!zF) {
            theme2 = Theme.LIGHT;
        }
        dVar.A = theme2;
        return zF ? R$style.MD_Dark : R$style.MD_Light;
    }

    public static void d(MaterialDialog materialDialog) {
        CharSequence[] charSequenceArr;
        CharSequence charSequence;
        MaterialDialog.d dVar = materialDialog.d;
        materialDialog.setCancelable(dVar.B);
        if (dVar.T == 0) {
            dVar.T = ed1.g(dVar.f2502a, R$attr.md_background_color);
        }
        if (dVar.T != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(dVar.f2502a.getResources().getDimension(R$dimen.md_bg_corner_radius));
            gradientDrawable.setColor(dVar.T);
            ed1.o(materialDialog.c, gradientDrawable);
        }
        dVar.q = ed1.h(dVar.f2502a, R$attr.md_positive_color, dVar.q);
        dVar.s = ed1.h(dVar.f2502a, R$attr.md_neutral_color, dVar.s);
        dVar.r = ed1.h(dVar.f2502a, R$attr.md_negative_color, dVar.r);
        dVar.p = ed1.h(dVar.f2502a, R$attr.md_widget_color, dVar.p);
        if (!dVar.i0) {
            int iG = ed1.g(dVar.f2502a, R.attr.textColorPrimary);
            int iH = ed1.h(dVar.f2502a, R$attr.md_title_color, iG);
            dVar.h = iH;
            if (iH == iG) {
                if (ed1.d(iH)) {
                    if (dVar.A == Theme.DARK) {
                        dVar.h = ed1.g(dVar.f2502a, R.attr.textColorPrimaryInverse);
                    }
                } else if (dVar.A == Theme.LIGHT) {
                    dVar.h = ed1.g(dVar.f2502a, R.attr.textColorPrimaryInverse);
                }
            }
        }
        if (!dVar.j0) {
            int iG2 = ed1.g(dVar.f2502a, R.attr.textColorSecondary);
            int iH2 = ed1.h(dVar.f2502a, R$attr.md_content_color, iG2);
            dVar.i = iH2;
            if (iH2 == iG2) {
                if (ed1.d(iH2)) {
                    if (dVar.A == Theme.DARK) {
                        dVar.i = ed1.g(dVar.f2502a, R.attr.textColorSecondaryInverse);
                    }
                } else if (dVar.A == Theme.LIGHT) {
                    dVar.i = ed1.g(dVar.f2502a, R.attr.textColorSecondaryInverse);
                }
            }
        }
        if (!dVar.k0) {
            dVar.U = ed1.h(dVar.f2502a, R$attr.md_item_color, dVar.i);
        }
        MDRootLayout mDRootLayout = materialDialog.c;
        int i = R$id.title;
        materialDialog.g = (TextView) mDRootLayout.findViewById(i);
        materialDialog.f = (ImageView) materialDialog.c.findViewById(R$id.icon);
        materialDialog.h = materialDialog.c.findViewById(R$id.titleFrame);
        materialDialog.m = (TextView) materialDialog.c.findViewById(R$id.content);
        materialDialog.e = (ListView) materialDialog.c.findViewById(R$id.contentListView);
        materialDialog.p = (MDButton) materialDialog.c.findViewById(R$id.buttonDefaultPositive);
        materialDialog.q = (MDButton) materialDialog.c.findViewById(R$id.buttonDefaultNeutral);
        materialDialog.r = (MDButton) materialDialog.c.findViewById(R$id.buttonDefaultNegative);
        if (dVar.b0 != null && dVar.l == null) {
            dVar.l = dVar.f2502a.getText(R.string.ok);
        }
        materialDialog.p.setVisibility(dVar.l != null ? 0 : 8);
        materialDialog.q.setVisibility(dVar.m != null ? 0 : 8);
        materialDialog.r.setVisibility(dVar.n != null ? 0 : 8);
        if (dVar.I != null) {
            materialDialog.f.setVisibility(0);
            materialDialog.f.setImageDrawable(dVar.I);
        } else {
            Drawable drawableK = ed1.k(dVar.f2502a, R$attr.md_icon);
            if (drawableK != null) {
                materialDialog.f.setVisibility(0);
                materialDialog.f.setImageDrawable(drawableK);
            } else {
                materialDialog.f.setVisibility(8);
            }
        }
        int dimensionPixelSize = dVar.K;
        if (dimensionPixelSize == -1) {
            dimensionPixelSize = ed1.i(dVar.f2502a, R$attr.md_icon_max_size);
        }
        if (dVar.J || ed1.e(dVar.f2502a, R$attr.md_icon_limit_icon_to_default_size)) {
            dimensionPixelSize = dVar.f2502a.getResources().getDimensionPixelSize(R$dimen.md_icon_max_size);
        }
        if (dimensionPixelSize > -1) {
            materialDialog.f.setAdjustViewBounds(true);
            materialDialog.f.setMaxHeight(dimensionPixelSize);
            materialDialog.f.setMaxWidth(dimensionPixelSize);
            materialDialog.f.requestLayout();
        }
        ed1.g(materialDialog.getContext(), R$attr.md_divider);
        materialDialog.c.setDividerColor(dVar.S);
        CharSequence charSequence2 = dVar.b;
        if (charSequence2 == null) {
            materialDialog.h.setVisibility(8);
        } else {
            materialDialog.g.setText(charSequence2);
            materialDialog.v(materialDialog.g, dVar.G);
            materialDialog.g.setTextColor(dVar.h);
            materialDialog.g.setGravity(dVar.c.getGravityInt());
            materialDialog.g.setTextAlignment(dVar.c.getTextAlignment());
        }
        TextView textView = materialDialog.m;
        if (textView != null && (charSequence = dVar.j) != null) {
            textView.setText(charSequence);
            materialDialog.m.setMovementMethod(new LinkMovementMethod());
            materialDialog.v(materialDialog.m, dVar.G);
            materialDialog.m.setLineSpacing(0.0f, dVar.C);
            int i2 = dVar.q;
            if (i2 == 0) {
                materialDialog.m.setLinkTextColor(ed1.g(materialDialog.getContext(), R.attr.textColorPrimary));
            } else {
                materialDialog.m.setLinkTextColor(i2);
            }
            materialDialog.m.setTextColor(dVar.i);
            materialDialog.m.setGravity(dVar.d.getGravityInt());
            materialDialog.m.setTextAlignment(dVar.d.getTextAlignment());
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        materialDialog.c.setButtonGravity(dVar.g);
        materialDialog.c.setButtonStackedGravity(dVar.e);
        materialDialog.c.setForceStack(dVar.Q);
        boolean zF = ed1.f(dVar.f2502a, R.attr.textAllCaps, true);
        if (zF) {
            zF = ed1.f(dVar.f2502a, R$attr.textAllCaps, true);
        }
        MDButton mDButton = materialDialog.p;
        materialDialog.v(mDButton, dVar.G);
        mDButton.setAllCapsCompat(zF);
        mDButton.setText(dVar.l);
        mDButton.setTextColor(a(dVar.f2502a, dVar.q));
        MDButton mDButton2 = materialDialog.p;
        DialogAction dialogAction = DialogAction.POSITIVE;
        mDButton2.setStackedSelector(materialDialog.h(dialogAction, true));
        materialDialog.p.setDefaultSelector(materialDialog.h(dialogAction, false));
        materialDialog.p.setTag(dialogAction);
        materialDialog.p.setOnClickListener(materialDialog);
        materialDialog.p.setVisibility(0);
        MDButton mDButton3 = materialDialog.r;
        materialDialog.v(mDButton3, dVar.G);
        mDButton3.setAllCapsCompat(zF);
        mDButton3.setText(dVar.n);
        mDButton3.setTextColor(a(dVar.f2502a, dVar.r));
        MDButton mDButton4 = materialDialog.r;
        DialogAction dialogAction2 = DialogAction.NEGATIVE;
        mDButton4.setStackedSelector(materialDialog.h(dialogAction2, true));
        materialDialog.r.setDefaultSelector(materialDialog.h(dialogAction2, false));
        materialDialog.r.setTag(dialogAction2);
        materialDialog.r.setOnClickListener(materialDialog);
        materialDialog.r.setVisibility(0);
        MDButton mDButton5 = materialDialog.q;
        materialDialog.v(mDButton5, dVar.G);
        mDButton5.setAllCapsCompat(zF);
        mDButton5.setText(dVar.m);
        mDButton5.setTextColor(a(dVar.f2502a, dVar.s));
        MDButton mDButton6 = materialDialog.q;
        DialogAction dialogAction3 = DialogAction.NEUTRAL;
        mDButton6.setStackedSelector(materialDialog.h(dialogAction3, true));
        materialDialog.q.setDefaultSelector(materialDialog.h(dialogAction3, false));
        materialDialog.q.setTag(dialogAction3);
        materialDialog.q.setOnClickListener(materialDialog);
        materialDialog.q.setVisibility(0);
        if (dVar.w != null) {
            materialDialog.t = new ArrayList();
        }
        ListView listView = materialDialog.e;
        if (listView != null && (((charSequenceArr = dVar.k) != null && charSequenceArr.length > 0) || dVar.L != null)) {
            listView.setSelector(materialDialog.l());
            ListAdapter listAdapter = dVar.L;
            if (listAdapter == null) {
                if (dVar.v != null) {
                    materialDialog.s = MaterialDialog.ListType.SINGLE;
                } else if (dVar.w != null) {
                    materialDialog.s = MaterialDialog.ListType.MULTI;
                    if (dVar.E != null) {
                        materialDialog.t = new ArrayList(Arrays.asList(dVar.E));
                    }
                } else {
                    materialDialog.s = MaterialDialog.ListType.REGULAR;
                }
                dVar.L = new b(materialDialog, MaterialDialog.ListType.getLayoutForType(materialDialog.s), i, dVar.k);
            } else if (listAdapter instanceof wd3) {
                ((wd3) listAdapter).b(materialDialog, false);
            }
        }
        g(materialDialog);
        f(materialDialog);
        if (dVar.o != null) {
            FrameLayout frameLayout = (FrameLayout) materialDialog.c.findViewById(R$id.customViewFrame);
            materialDialog.i = frameLayout;
            View view = dVar.o;
            View view2 = view;
            if (dVar.R) {
                Resources resources = materialDialog.getContext().getResources();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(materialDialog.getContext());
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.md_content_padding_top);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize4);
                    view.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view2 = scrollView;
            }
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -2));
        }
        materialDialog.b();
        materialDialog.o();
        materialDialog.d(materialDialog.c);
        materialDialog.e();
    }

    public static void e(MaterialDialog materialDialog) {
        MaterialDialog.d dVarG = materialDialog.g();
        DialogInterface.OnShowListener onShowListener = dVarG.P;
        if (onShowListener != null) {
            materialDialog.setOnShowListener(onShowListener);
        }
        DialogInterface.OnCancelListener onCancelListener = dVarG.N;
        if (onCancelListener != null) {
            materialDialog.setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = dVarG.M;
        if (onDismissListener != null) {
            materialDialog.setOnDismissListener(onDismissListener);
        }
        DialogInterface.OnKeyListener onKeyListener = dVarG.O;
        if (onKeyListener != null) {
            materialDialog.setOnKeyListener(onKeyListener);
        }
    }

    public static void f(MaterialDialog materialDialog) {
        MaterialDialog.d dVar = materialDialog.d;
        EditText editText = (EditText) materialDialog.c.findViewById(R.id.input);
        materialDialog.n = editText;
        if (editText == null) {
            return;
        }
        materialDialog.v(editText, dVar.G);
        CharSequence charSequence = dVar.Z;
        if (charSequence != null) {
            materialDialog.n.setText(charSequence);
        }
        materialDialog.t();
        materialDialog.n.setHint(dVar.a0);
        materialDialog.n.setSingleLine();
        materialDialog.n.setTextColor(dVar.i);
        materialDialog.n.setHintTextColor(ed1.a(dVar.i, 0.3f));
        sb3.c(materialDialog.n, materialDialog.d.p);
        int i = dVar.d0;
        if (i != -1) {
            materialDialog.n.setInputType(i);
            if ((dVar.d0 & 128) == 128) {
                materialDialog.n.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
        TextView textView = (TextView) materialDialog.c.findViewById(R$id.minMax);
        materialDialog.o = textView;
        if (dVar.f0 > -1) {
            materialDialog.n(materialDialog.n.getText().toString().length());
        } else {
            textView.setVisibility(8);
            materialDialog.o = null;
        }
    }

    public static void g(MaterialDialog materialDialog) {
        MaterialDialog.d dVar = materialDialog.d;
        if (dVar.V || dVar.X > -2) {
            ProgressBar progressBar = (ProgressBar) materialDialog.c.findViewById(R.id.progress);
            materialDialog.j = progressBar;
            if (progressBar == null) {
                return;
            }
            sb3.d(progressBar, dVar.p);
            if (dVar.V) {
                return;
            }
            materialDialog.j.setProgress(0);
            materialDialog.j.setMax(dVar.Y);
            TextView textView = (TextView) materialDialog.c.findViewById(R$id.label);
            materialDialog.k = textView;
            textView.setTextColor(dVar.i);
            materialDialog.v(materialDialog.k, dVar.H);
            TextView textView2 = (TextView) materialDialog.c.findViewById(R$id.minMax);
            materialDialog.l = textView2;
            textView2.setTextColor(dVar.i);
            materialDialog.v(materialDialog.l, dVar.G);
            if (dVar.W) {
                materialDialog.l.setVisibility(0);
                materialDialog.l.setText("0/" + dVar.Y);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) materialDialog.j.getLayoutParams();
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
            } else {
                materialDialog.l.setVisibility(8);
            }
            materialDialog.k.setText("0%");
        }
    }
}

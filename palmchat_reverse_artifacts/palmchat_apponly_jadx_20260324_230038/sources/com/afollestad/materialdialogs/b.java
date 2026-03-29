package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import defpackage.sb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b extends ArrayAdapter<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialDialog f2503a;
    public final GravityEnum b;
    public RadioButton c;
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2504a;

        static {
            int[] iArr = new int[MaterialDialog.ListType.values().length];
            f2504a = iArr;
            try {
                iArr[MaterialDialog.ListType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2504a[MaterialDialog.ListType.MULTI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(MaterialDialog materialDialog, int i, int i2, CharSequence[] charSequenceArr) {
        super(materialDialog.d.f2502a, i, i2, charSequenceArr);
        this.f2503a = materialDialog;
        this.b = materialDialog.d.f;
    }

    @TargetApi(17)
    public final boolean a() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @TargetApi(17)
    public final void b(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.b.getGravityInt() | 16);
        if (viewGroup.getChildCount() == 2) {
            if (this.b == GravityEnum.END && !a() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
                View view = (CompoundButton) viewGroup.getChildAt(0);
                viewGroup.removeView(view);
                TextView textView = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView(textView);
                viewGroup.addView(view);
                return;
            }
            if (this.b == GravityEnum.START && a() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
                View view2 = (CompoundButton) viewGroup.getChildAt(1);
                viewGroup.removeView(view2);
                TextView textView2 = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView2);
                textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
                viewGroup.addView(view2);
                viewGroup.addView(textView2);
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @SuppressLint({"WrongViewCast"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(R$id.title);
        int i2 = a.f2504a[this.f2503a.s.ordinal()];
        if (i2 == 1) {
            RadioButton radioButton = (RadioButton) view2.findViewById(R$id.control);
            MaterialDialog.d dVar = this.f2503a.d;
            boolean z = dVar.D == i;
            sb3.e(radioButton, dVar.p);
            radioButton.setChecked(z);
            if (z && this.d) {
                this.c = radioButton;
            }
        } else if (i2 == 2) {
            CheckBox checkBox = (CheckBox) view2.findViewById(R$id.control);
            boolean zContains = this.f2503a.t.contains(Integer.valueOf(i));
            sb3.b(checkBox, this.f2503a.d.p);
            checkBox.setChecked(zContains);
        }
        textView.setText(this.f2503a.d.k[i]);
        textView.setTextColor(this.f2503a.d.U);
        MaterialDialog materialDialog = this.f2503a;
        materialDialog.v(textView, materialDialog.d.G);
        view2.setTag(i + ":" + ((Object) this.f2503a.d.k[i]));
        ViewGroup viewGroup2 = (ViewGroup) view2;
        b(viewGroup2);
        if (viewGroup2.getChildCount() == 2) {
            if (viewGroup2.getChildAt(0) instanceof CompoundButton) {
                viewGroup2.getChildAt(0).setBackground(null);
            } else if (viewGroup2.getChildAt(1) instanceof CompoundButton) {
                viewGroup2.getChildAt(1).setBackground(null);
            }
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}

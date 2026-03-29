package com.afollestad.materialdialogs.prefs;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R$attr;
import com.afollestad.materialdialogs.R$layout;
import defpackage.ed1;
import defpackage.sb3;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MaterialEditTextPreference extends EditTextPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2507a;
    public MaterialDialog b;
    public EditText c;
    public final MaterialDialog.e d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnShowListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (MaterialEditTextPreference.this.c.getText().length() > 0) {
                MaterialEditTextPreference.this.c.setSelection(MaterialEditTextPreference.this.c.length());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String string = MaterialEditTextPreference.this.c.getText().toString();
            if (MaterialEditTextPreference.this.callChangeListener(string) && MaterialEditTextPreference.this.isPersistent()) {
                MaterialEditTextPreference.this.setText(string);
            }
        }
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2507a = 0;
        this.d = new b();
        this.f2507a = ed1.h(context, R$attr.colorAccent, ed1.g(context, R.attr.colorAccent));
        AppCompatEditText appCompatEditText = new AppCompatEditText(context, attributeSet);
        this.c = appCompatEditText;
        appCompatEditText.setEnabled(true);
    }

    public final void c(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.b;
    }

    @Override // android.preference.EditTextPreference
    public EditText getEditText() {
        return this.c;
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.b;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.b.dismiss();
    }

    @Override // android.preference.EditTextPreference
    public void onAddEditTextToDialogView(@NonNull View view, @NonNull EditText editText) {
        if (editText.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(editText);
        }
        ((ViewGroup) view).addView(editText, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    public void onBindDialogView(@NonNull View view) {
        super.onBindDialogView(view);
        this.c.setText("");
        if (getText() != null) {
            this.c.setText(getText());
        }
        ViewParent parent = this.c.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.c);
            }
            onAddEditTextToDialogView(view, this.c);
        }
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    public void onDialogClosed(boolean z) {
        if (z) {
            String string = this.c.getText().toString();
            if (callChangeListener(string)) {
                setText(string);
            }
        }
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    public void showDialog(Bundle bundle) {
        MaterialDialog.d dVarR = new MaterialDialog.d(getContext()).U(getDialogTitle()).A(getDialogIcon()).P(getPositiveButtonText()).L(getNegativeButtonText()).f(this.d).r(this).R(new a());
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.md_stub_inputpref, (ViewGroup) null);
        onBindDialogView(viewInflate);
        sb3.c(this.c, this.f2507a);
        TextView textView = (TextView) viewInflate.findViewById(R.id.message);
        if (getDialogMessage() == null || getDialogMessage().toString().length() <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(getDialogMessage());
        }
        dVarR.p(viewInflate, false);
        PreferenceManager preferenceManager = getPreferenceManager();
        try {
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod("registerOnActivityDestroyListener", PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MaterialDialog materialDialogE = dVarR.e();
        this.b = materialDialogE;
        if (bundle != null) {
            materialDialogE.onRestoreInstanceState(bundle);
        }
        c(this.b);
        this.b.show();
    }
}

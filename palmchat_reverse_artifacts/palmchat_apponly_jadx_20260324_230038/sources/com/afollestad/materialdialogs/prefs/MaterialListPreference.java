package com.afollestad.materialdialogs.prefs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MaterialListPreference extends ListPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2510a;
    public MaterialDialog b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MaterialDialog.i {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.i
        public boolean a(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
            MaterialListPreference.this.onClick(null, -1);
            if (i < 0 || MaterialListPreference.this.getEntryValues() == null) {
                return true;
            }
            String string = MaterialListPreference.this.getEntryValues()[i].toString();
            if (!MaterialListPreference.this.callChangeListener(string) || !MaterialListPreference.this.isPersistent()) {
                return true;
            }
            MaterialListPreference.this.setValue(string);
            return true;
        }
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b(Context context) {
        this.f2510a = context;
    }

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.b;
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

    @Override // android.preference.ListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        MaterialDialog materialDialog = this.b;
        if (materialDialog != null) {
            materialDialog.u(charSequenceArr);
        }
    }

    @Override // android.preference.ListPreference
    public void setValue(String str) {
        super.setValue(str);
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle bundle) {
        if (getEntries() == null || getEntryValues() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        MaterialDialog.d dVarH = new MaterialDialog.d(this.f2510a).U(getDialogTitle()).k(getDialogMessage()).A(getDialogIcon()).L(getNegativeButtonText()).F(getEntries()).b(true).H(findIndexOfValue(getValue()), new a());
        View viewOnCreateDialogView = onCreateDialogView();
        if (viewOnCreateDialogView != null) {
            onBindDialogView(viewOnCreateDialogView);
            dVarH.p(viewOnCreateDialogView, false);
        } else {
            dVarH.k(getDialogMessage());
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        try {
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod("registerOnActivityDestroyListener", PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MaterialDialog materialDialogE = dVarH.e();
        this.b = materialDialogE;
        if (bundle != null) {
            materialDialogE.onRestoreInstanceState(bundle);
        }
        this.b.show();
    }
}

package com.afollestad.materialdialogs.prefs;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class MaterialMultiSelectListPreference extends MultiSelectListPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2512a;
    public MaterialDialog b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MaterialDialog.h {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.h
        public boolean a(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr) {
            MaterialMultiSelectListPreference.this.onClick(null, -1);
            materialDialog.dismiss();
            HashSet hashSet = new HashSet();
            for (Integer num : numArr) {
                hashSet.add(MaterialMultiSelectListPreference.this.getEntryValues()[num.intValue()].toString());
            }
            if (!MaterialMultiSelectListPreference.this.callChangeListener(hashSet)) {
                return true;
            }
            MaterialMultiSelectListPreference.this.setValues(hashSet);
            return true;
        }
    }

    public MaterialMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b(Context context) {
        this.f2512a = context;
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

    @Override // android.preference.MultiSelectListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        MaterialDialog materialDialog = this.b;
        if (materialDialog != null) {
            materialDialog.u(charSequenceArr);
        }
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (String str : getValues()) {
            if (findIndexOfValue(str) >= 0) {
                arrayList.add(Integer.valueOf(findIndexOfValue(str)));
            }
        }
        MaterialDialog.d dVarR = new MaterialDialog.d(this.f2512a).U(getDialogTitle()).k(getDialogMessage()).A(getDialogIcon()).L(getNegativeButtonText()).P(getPositiveButtonText()).F(getEntries()).G((Integer[]) arrayList.toArray(new Integer[arrayList.size()]), new a()).r(this);
        View viewOnCreateDialogView = onCreateDialogView();
        if (viewOnCreateDialogView != null) {
            onBindDialogView(viewOnCreateDialogView);
            dVarR.p(viewOnCreateDialogView, false);
        } else {
            dVarR.k(getDialogMessage());
        }
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
        this.b.show();
    }
}

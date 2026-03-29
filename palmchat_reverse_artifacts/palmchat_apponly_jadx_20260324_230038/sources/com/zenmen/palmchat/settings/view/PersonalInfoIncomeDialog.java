package com.zenmen.palmchat.settings.view;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.IncomeWheelPicker;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.l50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalInfoIncomeDialog extends LXBottomSheetDialog {
    public IncomeWheelPicker h;
    public View i;
    public int j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoIncomeDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements WheelPicker.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            PersonalInfoIncomeDialog.this.i.setEnabled(pickerData != null && pickerData.id > 0);
            if (pickerData != null) {
                PersonalInfoIncomeDialog.this.j = pickerData.getId();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PersonalInfoIncomeDialog.z(PersonalInfoIncomeDialog.this);
            PersonalInfoIncomeDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    public static /* bridge */ /* synthetic */ f z(PersonalInfoIncomeDialog personalInfoIncomeDialog) {
        personalInfoIncomeDialog.getClass();
        return null;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_income_select, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        IncomeWheelPicker incomeWheelPicker = (IncomeWheelPicker) viewInflate.findViewById(R.id.income_wheel_picker);
        this.h = incomeWheelPicker;
        incomeWheelPicker.setPickerId(this.j);
        this.h.setOnItemSelectedListener(new b());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new c());
        this.i.setEnabled(this.j > 0);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new d());
        setOnShowListener(new e());
        return viewInflate;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DialogInterface.OnShowListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }
}

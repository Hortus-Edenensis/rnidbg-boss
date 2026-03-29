package com.zenmen.palmchat.settings.view;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.Occupation2WheelPicker;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.l50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalInfoOccupation2Dialog extends LXBottomSheetDialog {
    public Occupation2WheelPicker h;
    public View i;
    public int j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoOccupation2Dialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PersonalInfoOccupation2Dialog.z(PersonalInfoOccupation2Dialog.this);
            PersonalInfoOccupation2Dialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements WheelPicker.a {
        public c() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            PersonalInfoOccupation2Dialog.this.i.setEnabled(pickerData != null && pickerData.id > 0);
            if (pickerData != null) {
                PersonalInfoOccupation2Dialog.this.j = pickerData.getId();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    public static /* bridge */ /* synthetic */ f z(PersonalInfoOccupation2Dialog personalInfoOccupation2Dialog) {
        personalInfoOccupation2Dialog.getClass();
        return null;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_occupation2_select, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        this.i.setEnabled(this.j > 0);
        Occupation2WheelPicker occupation2WheelPicker = (Occupation2WheelPicker) viewInflate.findViewById(R.id.income_wheel_picker);
        this.h = occupation2WheelPicker;
        occupation2WheelPicker.setOnItemSelectedListener(new c());
        this.h.setPickerId(this.j);
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

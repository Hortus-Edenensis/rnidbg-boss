package com.zenmen.palmchat.settings.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker;
import defpackage.l50;
import defpackage.rn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalinfobirthdayDia extends LXBottomSheetDialog implements View.OnClickListener {
    public View h;
    public DateWheelPicker i;
    public TextView j;
    public rn k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            String birthday = PersonalinfobirthdayDia.this.i.getBirthday();
            if (PersonalinfobirthdayDia.this.k != null) {
                PersonalinfobirthdayDia.this.k.run(1, birthday, null);
            }
            PersonalinfobirthdayDia.this.dismiss();
        }
    }

    public final void B() {
        this.i = (DateWheelPicker) this.h.findViewById(R.id.birthday_view);
        this.j = (TextView) this.h.findViewById(R.id.btn_next);
        this.h.findViewById(R.id.close).setOnClickListener(this);
        this.j.setOnClickListener(new a());
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        this.h = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_personalinfi_birthday, (ViewGroup) null);
        B();
        return this.h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.close) {
            return;
        }
        dismiss();
    }
}

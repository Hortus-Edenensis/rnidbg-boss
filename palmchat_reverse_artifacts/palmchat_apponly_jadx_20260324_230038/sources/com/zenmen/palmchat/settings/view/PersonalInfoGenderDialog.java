package com.zenmen.palmchat.settings.view;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.l50;
import defpackage.vs0;
import defpackage.zn6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalInfoGenderDialog extends LXBottomSheetDialog {
    public View h;
    public View i;
    public View j;
    public int k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoGenderDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoGenderDialog.this.k = 0;
            PersonalInfoGenderDialog.this.C();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoGenderDialog.this.k = 1;
            PersonalInfoGenderDialog.this.C();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PersonalInfoGenderDialog.z(PersonalInfoGenderDialog.this);
            PersonalInfoGenderDialog.this.dismiss();
            zn6.c("pagegenderchange_complete", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            zn6.c("pagegenderchange_cancel", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DialogInterface.OnShowListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            zn6.c("pagegenderchange", "view");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
    }

    public static /* bridge */ /* synthetic */ g z(PersonalInfoGenderDialog personalInfoGenderDialog) {
        personalInfoGenderDialog.getClass();
        return null;
    }

    public final void C() {
        View view = this.h;
        if (view == null) {
            return;
        }
        view.setSelected(this.k == 0);
        this.i.setSelected(this.k == 1);
        this.j.setEnabled(this.k != -1);
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_gender_select, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        String strB = vs0.a().b("genderchangetip");
        if (TextUtils.isEmpty(strB)) {
            strB = getContext().getString(R.string.settings_gender_subtitle);
        }
        ((TextView) viewInflate.findViewById(R.id.subTitle)).setText(strB);
        View viewFindViewById = viewInflate.findViewById(R.id.male);
        this.h = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        View viewFindViewById2 = viewInflate.findViewById(R.id.female);
        this.i = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new c());
        View viewFindViewById3 = viewInflate.findViewById(R.id.confirm);
        this.j = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new d());
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new e());
        setOnShowListener(new f());
        C();
        return viewInflate;
    }
}

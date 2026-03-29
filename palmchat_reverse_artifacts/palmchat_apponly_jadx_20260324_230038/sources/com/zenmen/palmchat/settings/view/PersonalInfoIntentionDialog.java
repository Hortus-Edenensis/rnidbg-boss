package com.zenmen.palmchat.settings.view;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.picker.multi.IntentionPicker;
import defpackage.l50;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PersonalInfoIntentionDialog extends LXBottomSheetDialog {
    public IntentionPicker h;
    public View i;
    public List<Integer> j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalInfoIntentionDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements IntentionPicker.b {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.picker.multi.IntentionPicker.b
        public void a(ArrayList<Integer> arrayList) {
            PersonalInfoIntentionDialog.this.i.setEnabled(arrayList != null && arrayList.size() > 0);
            PersonalInfoIntentionDialog.this.j = arrayList;
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
            PersonalInfoIntentionDialog.z(PersonalInfoIntentionDialog.this);
            PersonalInfoIntentionDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    public static /* bridge */ /* synthetic */ f z(PersonalInfoIntentionDialog personalInfoIntentionDialog) {
        personalInfoIntentionDialog.getClass();
        return null;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_intention_select, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        IntentionPicker intentionPicker = (IntentionPicker) viewInflate.findViewById(R.id.intention_picker);
        this.h = intentionPicker;
        intentionPicker.bind(new b(), this.j);
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new c());
        View view = this.i;
        List<Integer> list = this.j;
        view.setEnabled(list != null && list.size() > 0);
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

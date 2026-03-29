package com.zenmen.palmchat.square;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.l50;
import defpackage.le1;
import defpackage.q05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SuperExposeAgreementDialog extends LXBottomSheetDialog {
    public TextView h;
    public View i;
    public Activity j;
    public e k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SuperExposeAgreementDialog.this.k != null) {
                SuperExposeAgreementDialog.this.k.onCancel();
            }
            SuperExposeAgreementDialog.this.dismiss();
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
            if (SuperExposeAgreementDialog.this.k != null) {
                SuperExposeAgreementDialog.this.k.onConfirm();
            }
            SuperExposeAgreementDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SAppUtil.H(SuperExposeAgreementDialog.this.getContext(), "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-41bf2881ea1f459fa99594a6594b34cb-strs8y", false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (SuperExposeAgreementDialog.this.k != null) {
                SuperExposeAgreementDialog.this.k.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void onCancel();

        void onConfirm();
    }

    public SuperExposeAgreementDialog(@NonNull Activity activity, e eVar) {
        super(activity);
        this.j = activity;
        this.k = eVar;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_login_agreement, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        TextView textView = (TextView) viewInflate.findViewById(R.id.agreement);
        this.h = textView;
        q05.B(textView, new SpannableString("《超级曝光付费说明》"), Color.parseColor("#00C85A"), "《超级曝光付费说明》", new c());
        t(le1.a(AppContext.getContext(), 250.0f));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new d());
        return viewInflate;
    }
}

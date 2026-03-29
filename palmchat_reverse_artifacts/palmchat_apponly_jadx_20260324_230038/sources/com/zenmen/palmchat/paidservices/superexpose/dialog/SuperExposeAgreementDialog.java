package com.zenmen.palmchat.paidservices.superexpose.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.ap3;
import defpackage.ky;
import defpackage.l50;
import defpackage.le1;
import defpackage.nl0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeAgreementDialog extends LXBottomSheetDialog {
    public TextView h;
    public View i;
    public Activity j;
    public ky k;

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
                SuperExposeAgreementDialog.this.k.a(null);
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
            ap3.a().B(SuperExposeAgreementDialog.this.j, nl0.q + "/popup/#/boost/illustrate");
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

    public SuperExposeAgreementDialog(@NonNull Activity activity, ky kyVar) {
        super(activity);
        this.j = activity;
        this.k = kyVar;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.super_expose_dialog_agreement, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        TextView textView = (TextView) viewInflate.findViewById(R.id.agreement);
        this.h = textView;
        textView.setOnClickListener(new c());
        t(le1.a(AppContext.getContext(), 250.0f));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new d());
        return viewInflate;
    }
}

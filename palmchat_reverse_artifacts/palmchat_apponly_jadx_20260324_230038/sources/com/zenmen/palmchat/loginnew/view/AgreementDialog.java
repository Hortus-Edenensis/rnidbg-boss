package com.zenmen.palmchat.loginnew.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.l50;
import defpackage.le1;
import defpackage.zm4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AgreementDialog extends LXBottomSheetDialog {
    public TextView h;
    public View i;
    public Activity j;
    public int k;
    public d l;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AgreementDialog.this.l != null) {
                AgreementDialog.this.l.onCancel();
            }
            AgreementDialog.this.dismiss();
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
            if (AgreementDialog.this.l != null) {
                AgreementDialog.this.l.onConfirm();
            }
            AgreementDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (AgreementDialog.this.l != null) {
                AgreementDialog.this.l.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onCancel();

        void onConfirm();
    }

    public AgreementDialog(@NonNull Activity activity, int i, d dVar) {
        super(activity);
        this.k = i;
        this.j = activity;
        this.l = dVar;
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
        textView.setText(zm4.e(this.j, this.k));
        this.h.setMovementMethod(LinkMovementMethod.getInstance());
        this.h.setHighlightColor(AppContext.getContext().getResources().getColor(android.R.color.transparent));
        t(le1.a(AppContext.getContext(), 250.0f));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new c());
        return viewInflate;
    }
}

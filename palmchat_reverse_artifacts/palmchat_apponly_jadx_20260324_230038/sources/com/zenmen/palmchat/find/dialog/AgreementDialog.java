package com.zenmen.palmchat.find.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.ky;
import defpackage.l50;
import defpackage.le1;
import defpackage.ym4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AgreementDialog extends LXBottomSheetDialog {
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
            if (AgreementDialog.this.k != null) {
                AgreementDialog.this.k.onCancel();
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
            if (AgreementDialog.this.k != null) {
                AgreementDialog.this.k.a(null);
            }
            AgreementDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AgreementDialog.A(AgreementDialog.this.getContext(), ym4.e());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (AgreementDialog.this.k != null) {
                AgreementDialog.this.k.onCancel();
            }
        }
    }

    public AgreementDialog(@NonNull Activity activity, ky kyVar) {
        super(activity);
        this.j = activity;
        this.k = kyVar;
    }

    public static void A(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_find_map_agreement, (ViewGroup) null);
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

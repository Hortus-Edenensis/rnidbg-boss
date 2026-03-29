package com.zenmen.palmchat.aichat;

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

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiChatBuyAgreementDialog extends LXBottomSheetDialog {
    public TextView h;
    public View i;
    public ky j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AiChatBuyAgreementDialog.this.j != null) {
                AiChatBuyAgreementDialog.this.j.onCancel();
            }
            AiChatBuyAgreementDialog.this.dismiss();
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
            if (AiChatBuyAgreementDialog.this.j != null) {
                AiChatBuyAgreementDialog.this.j.a(null);
            }
            AiChatBuyAgreementDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiChatBuyAgreementDialog.A(AiChatBuyAgreementDialog.this.getContext(), "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-a27b8ee997b04e3eaff63b905de96b76-sxf0gy");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (AiChatBuyAgreementDialog.this.j != null) {
                AiChatBuyAgreementDialog.this.j.onCancel();
            }
        }
    }

    public AiChatBuyAgreementDialog(@NonNull Context context, ky kyVar) {
        super(context);
        setCanceledOnTouchOutside(true);
        this.j = kyVar;
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
        View viewInflate = getLayoutInflater().inflate(R.layout.aichat_dialog_buy_agreement, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        TextView textView = (TextView) viewInflate.findViewById(R.id.agreement);
        this.h = textView;
        textView.setOnClickListener(new c());
        t(le1.a(AppContext.getContext(), 250.0f));
        setOnCancelListener(new d());
        return viewInflate;
    }
}

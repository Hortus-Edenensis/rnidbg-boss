package com.zenmen.palmchat.chat.pay;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.pay.a;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.l50;
import defpackage.le1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatPayInfoDialog extends LXBottomSheetDialog {
    public a.c h;
    public PayChatInfo i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (ChatPayInfoDialog.this.h != null) {
                ChatPayInfoDialog.this.h.a(true);
            }
            ChatPayInfoDialog.this.dismiss();
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
            if (ChatPayInfoDialog.this.h != null) {
                ChatPayInfoDialog.this.h.a(false);
            }
            ChatPayInfoDialog.this.dismiss();
        }
    }

    public ChatPayInfoDialog(@NonNull Context context, PayChatInfo payChatInfo, a.c cVar) {
        super(context);
        this.h = cVar;
        this.i = payChatInfo;
        x(1);
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_chat_pay_info, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.des1)).setText(Html.fromHtml(this.i.popupContent));
        viewInflate.findViewById(R.id.btn_send).setOnClickListener(new a());
        viewInflate.findViewById(R.id.btn_cancel).setOnClickListener(new b());
        t(le1.a(AppContext.getContext(), 240.0f));
        setCanceledOnTouchOutside(true);
        return viewInflate;
    }
}

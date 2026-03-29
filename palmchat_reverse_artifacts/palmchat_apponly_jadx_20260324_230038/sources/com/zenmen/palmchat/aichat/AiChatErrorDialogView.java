package com.zenmen.palmchat.aichat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.l50;
import defpackage.v8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiChatErrorDialogView extends LXBottomSheetDialog {
    public ViewGroup h;
    public Activity i;
    public Context j;
    public TextView k;
    public View l;
    public int m;
    public long n;
    public long o;
    public int p;
    public int q;
    public boolean r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AiChatErrorDialogView.this.dismiss();
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
            AiChatErrorDialogView.this.dismiss();
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
            AiChatErrorDialogView.this.dismiss();
            v8.N(AiChatErrorDialogView.this.j, AiChatErrorDialogView.this.m, AiChatErrorDialogView.this.n, AiChatErrorDialogView.this.o, AiChatErrorDialogView.this.p, AiChatErrorDialogView.this.q);
        }
    }

    public AiChatErrorDialogView(@NonNull Context context, int i) {
        super(context, i);
        this.i = null;
        setCanceledOnTouchOutside(true);
        if (context instanceof Activity) {
            this.i = (Activity) context;
        }
        this.j = context;
        this.h = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_aichat_error_dialog, (ViewGroup) null);
        F();
    }

    public final void F() {
        this.h.findViewById(R.id.ai_chat_buy_all_layout).setOnClickListener(new a());
        this.h.findViewById(R.id.ai_chat_show_layout).setOnClickListener(new b());
        View viewFindViewById = this.h.findViewById(R.id.close_img);
        this.l = viewFindViewById;
        viewFindViewById.setOnClickListener(new c());
        TextView textView = (TextView) this.h.findViewById(R.id.ai_chat_error_again);
        this.k = textView;
        textView.setOnClickListener(new d());
    }

    public void G(int i) {
        this.q = i;
    }

    public void H(int i) {
        this.m = i;
    }

    public void I(long j) {
        this.n = j;
    }

    public void J(int i) {
        this.p = i;
    }

    public void K(long j) {
        this.o = j;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.r) {
            try {
                super.dismiss();
                Activity activity = this.i;
                if (activity instanceof AiCHatBuyDialogBaseActivity) {
                    activity.finish();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        return this.h;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.r = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}

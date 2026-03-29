package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bl4 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f1745a;
    public View b;
    public View c;
    public Activity d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            bl4.this.b();
            bl4.this.dismiss();
            w4.p("Accountset_PRCauthentication_cancel_cancelaccount");
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
            bl4.this.dismiss();
            w4.p("Accountset_PRCauthentication_cancel_back");
        }
    }

    public bl4(@NonNull Context context) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.b = null;
        this.c = null;
        this.d = null;
        setCanceledOnTouchOutside(false);
        this.f1745a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_account_prauthen_delete, (ViewGroup) null);
        if (context instanceof Activity) {
            this.d = (Activity) context;
        }
    }

    public final void b() {
        LogUtil.d("AccountPrAuthenManager", "PrDialogDelete deleteUid mAct " + this.d);
        Activity activity = this.d;
        if (activity != null) {
            ve.o(activity, "zenxin://activity?page=a0052&pkgId=deregister", false);
        }
    }

    public final void c() {
        View viewFindViewById = findViewById(R.id.pr_authen_dialog_delete);
        this.b = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = findViewById(R.id.pr_authen_dialog_cancel);
        this.c = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.d = null;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f1745a);
        c();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}

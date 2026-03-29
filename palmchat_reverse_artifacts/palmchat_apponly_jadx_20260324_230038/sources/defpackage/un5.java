package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.dialog.SuperBuyDialogBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class un5 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f21248a;
    public Activity b;
    public Context c;
    public View d;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            un5.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (un5.this.b != null) {
                ve.o(un5.this.b, "zenxin://activity?page=a0510&tab=tab_find_friend", false);
            }
            un5.this.dismiss();
        }
    }

    public un5(Context context) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.b = null;
        this.d = null;
        setCanceledOnTouchOutside(false);
        super.setOnDismissListener(new a());
        this.f21248a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.super_expose_buy_success_dialog_layout, (ViewGroup) null);
        this.c = context.getApplicationContext();
        if (context instanceof Activity) {
            this.b = (Activity) context;
        }
    }

    public final void b() {
        View viewFindViewById = findViewById(R.id.dialog_close);
        this.d = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        findViewById(R.id.dialog_done_find).setOnClickListener(new c());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.b instanceof SuperBuyDialogBaseActivity) {
            LogUtil.d("", "SuperDialog SuperExposeBuySuccessDialog dismiss done");
            this.b.finish();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f21248a);
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        LogUtil.d("", "SuperDialog SuperExposeBuySuccessDialog show");
        super.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}

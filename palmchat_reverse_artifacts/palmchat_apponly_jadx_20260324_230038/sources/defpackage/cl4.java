package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cl4 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f2006a;
    public View b;
    public View c;
    public View d;
    public Activity e;
    public TextView f;
    public GroupModifyResultVo g;
    public String h;
    public al4 i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (cl4.this.i != null) {
                cl4.this.i.a(cl4.this.g);
            }
            cl4.this.dismiss();
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
            cl4.this.dismiss();
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
            cl4.this.d();
        }
    }

    public cl4(@NonNull Context context, GroupModifyResultVo groupModifyResultVo, al4 al4Var) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = "";
        this.i = null;
        setCanceledOnTouchOutside(false);
        this.g = groupModifyResultVo;
        this.i = al4Var;
        if (groupModifyResultVo != null) {
            if (groupModifyResultVo.resultCode == 4028) {
                this.h = TextUtils.isEmpty(groupModifyResultVo.errorMsg) ? "你的建群数量已达到上限，完成实名认证后可继续建群" : groupModifyResultVo.errorMsg;
            } else {
                this.h = groupModifyResultVo.errorMsg;
            }
            LogUtil.d("AccountPrAuthenManager", "PrRoomDialog start code " + this.g.resultCode + " msg " + this.h);
        }
        ds0.a().c(this);
        this.f2006a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_account_prauthen_room_failed, (ViewGroup) null);
        if (context instanceof Activity) {
            this.e = (Activity) context;
        }
    }

    public final void d() {
        LogUtil.d("AccountPrAuthenManager", "PrRoomDialog authenApp mAct " + this.e);
        Activity activity = this.e;
        if (activity != null) {
            w4.B(activity, 1, this, false);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        LogUtil.d("AccountPrAuthenManager", "PrRoomDialog dismiss ");
        ds0.a().d(this);
        this.e = null;
        this.g = null;
    }

    public final void e() {
        View viewFindViewById = findViewById(R.id.pr_account_room_realname);
        this.b = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = findViewById(R.id.pr_account_room_cancel);
        this.c = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        View viewFindViewById3 = findViewById(R.id.pr_account_room_authen);
        this.d = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new c());
        this.f = (TextView) findViewById(R.id.account_room_realname_title);
        if (TextUtils.isEmpty(this.h)) {
            return;
        }
        this.f.setText(this.h);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f2006a);
        e();
    }

    @qm5
    public void prDialogEvent(x4 x4Var) {
        LogUtil.d("AccountPrAuthenManager", "PrRoomDialog prDialogEvent prEvent " + x4Var);
        if (x4Var != null) {
            LogUtil.d("AccountPrAuthenManager", "PrRoomDialog prDialogEvent type " + x4Var.f21873a + " msg " + x4Var.b);
            int i = x4Var.f21873a;
            if (i == x4.j) {
                Toast.makeText(this.e, "认证成功", 0).show();
                dismiss();
            } else if (i == x4.k) {
                Toast.makeText(this.e, !TextUtils.isEmpty(x4Var.b) ? x4Var.b : "认证失败，请重新认证", 0).show();
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}

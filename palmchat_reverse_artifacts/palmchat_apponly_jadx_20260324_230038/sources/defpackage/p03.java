package defpackage;

import android.accounts.AccountManagerCallback;
import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.EncryptUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p03 implements dk2 {
    @Override // defpackage.dk2
    public ContactInfoItem a(Context context) {
        String strE = e(context);
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        return dn0.a(strE);
    }

    @Override // defpackage.dk2
    public String b(Context context) {
        return AccountUtils.j(context);
    }

    @Override // defpackage.dk2
    public String c() {
        return EncryptUtils.generateMessageToken();
    }

    @Override // defpackage.dk2
    public void d(s4 s4Var) {
        AccountUtils.e(AppContext.getContext(), s4Var.g(), s4Var.b(), s4Var.a(), s4Var.d(), s4Var.f(), s4Var.e(), s4Var.c());
    }

    @Override // defpackage.dk2
    public String e(Context context) {
        return AccountUtils.q(context, false);
    }

    @Override // defpackage.dk2
    public s4 f(Context context) {
        s4 s4Var = new s4();
        s4Var.m(AccountUtils.p(context));
        s4Var.i(AccountUtils.j(context));
        s4Var.h(AccountUtils.i(context));
        s4Var.j(AccountUtils.k(context));
        s4Var.l(AccountUtils.o(context));
        s4Var.k(AccountUtils.m(context));
        return s4Var;
    }

    @Override // defpackage.dk2
    public void g(Context context, AccountManagerCallback accountManagerCallback) {
        AccountUtils.u(context, accountManagerCallback);
    }

    @Override // defpackage.dk2
    public String h(Context context) {
        return AccountUtils.o(context);
    }

    @Override // defpackage.dk2
    public void init(Context context) {
        t4.b().d(null);
    }
}

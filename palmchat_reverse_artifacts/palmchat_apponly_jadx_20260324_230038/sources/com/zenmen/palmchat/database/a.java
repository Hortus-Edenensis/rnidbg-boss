package com.zenmen.palmchat.database;

import android.content.ContentValues;
import android.content.Context;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ho3;
import defpackage.ir5;
import defpackage.r75;
import defpackage.vh5;
import defpackage.wf5;
import defpackage.xf5;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13885a;
    public String b;
    public AtomicInteger c = new AtomicInteger(-1);

    public a(Context context, String str) {
        this.f13885a = context;
        this.b = str;
        LogUtil.i("DBTransferHelper", "DBTransferHelper " + this);
    }

    public static String a(boolean z) {
        return z ? "" : "%";
    }

    public static String b(boolean z) {
        return z ? "=? " : " like ? ";
    }

    public static boolean c() {
        wf5 wf5VarA = xf5.a(AccountUtils.p(AppContext.getContext()));
        boolean zG = wf5VarA != null ? wf5VarA.g() : false;
        LogUtil.i("DBTransferHelper", "isMsgContactRelateTransferComplete " + zG);
        return zG;
    }

    public static void e(vh5 vh5Var) {
        long jB = ir5.b();
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate start");
        vh5Var.e(ho3.a("tb_messages"));
        vh5Var.e("UPDATE tb_messages SET contact_relate = replace(contact_relate,'@muc.youni','@muc.youni/123')  where contact_relate LIKE '%@%';");
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate end" + ir5.e(jB));
    }

    public static void g() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("params_msg_data_transfer", Boolean.TRUE);
        AppContext.getContext().getContentResolver().update(DBUriManager.d(ho3.class, DBUriManager.MsgSaveType.COMMON), contentValues, null, null);
    }

    public static int h(vh5 vh5Var) {
        long jB = ir5.b();
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate start");
        vh5Var.e("UPDATE tb_messages SET contact_relate = substr(contact_relate,1,(instr(contact_relate,'/')-1))  where contact_relate LIKE '%/%';");
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate update common msg");
        vh5Var.e("UPDATE tb_hotchat_messages SET contact_relate = substr(contact_relate,1,(instr(contact_relate,'/')-1))  where contact_relate LIKE '%/%';");
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate update hoc msg");
        vh5Var.e("UPDATE tb_bottle_messages SET contact_relate = substr(contact_relate,1,(instr(contact_relate,'/')-1))  where contact_relate LIKE '%/%';");
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate update pot msg");
        vh5Var.e(ho3.c("tb_messages"));
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate create index common msg");
        LogUtil.i("DBTransferHelper", "updateMsgContactRelate end" + ir5.e(jB) + " count =0");
        return 0;
    }

    public boolean d() {
        if (this.c.get() == -1) {
            AtomicInteger atomicInteger = this.c;
            Context context = this.f13885a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("groupDataTransferedState");
            atomicInteger.set(r75.d(context, sb.toString(), false) ? 1 : 0);
        }
        boolean z = this.c.get() == 1;
        LogUtil.i("DBTransferHelper", "isMsgContactRelateTransferCompleteImp " + z + this);
        return z;
    }

    public void f() {
        r75.o(this.f13885a, this.b + "groupDataTransferedState", true);
        this.c.set(1);
        LogUtil.i("DBTransferHelper", "setMsgContactRelateTransferCompleteImp " + this);
    }
}

package com.zenmen.palmchat.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.w;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a5;
import defpackage.ac1;
import defpackage.jo6;
import defpackage.mh2;
import defpackage.qq5;
import defpackage.r75;
import defpackage.t4;
import defpackage.yh4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AccountUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f12176a = "AccountUtils";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12177a;

        public a(boolean z) {
            this.f12177a = z;
            put("action", "accountSync addAccount result: " + z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AccountManagerCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12178a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ AccountManager f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Context h;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f12179a;

            public a(boolean z) {
                this.f12179a = z;
                put("action", "accountSync removeAndAddAccount result: " + z);
            }
        }

        public b(String str, String str2, String str3, String str4, String str5, AccountManager accountManager, String str6, Context context) {
            this.f12178a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = accountManager;
            this.g = str6;
            this.h = context;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            Account account = new Account(TextUtils.isEmpty(this.f12178a) ? AccountUtils.g(this.b) : this.f12178a, "com.zenmen.palmchat.AccountType");
            Bundle bundle = new Bundle();
            bundle.putString("mobile", this.c);
            bundle.putString(w.v, this.d);
            bundle.putString(DeviceInfoUtil.UID_TAG, this.b);
            bundle.putString("refresh_key", this.e);
            bundle.putString("nick_name", this.f12178a);
            bundle.putString("sys_account_ignore", String.valueOf(jo6.j()));
            try {
                boolean zAddAccountExplicitly = this.f.addAccountExplicitly(account, this.g, bundle);
                LogUtil.i(AccountUtils.f12176a, 3, new a(zAddAccountExplicitly), (Throwable) null);
                AccountUtils.y(account, zAddAccountExplicitly, this.h);
                qq5.c().d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12180a;

        public c(String str) {
            this.f12180a = str;
            put("action", "AccountSessionIdCheck");
            put("detail", "uid= " + str);
        }
    }

    public static void A(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            B(context, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Account accountH = h(context);
        if (accountH == null) {
            return;
        }
        AccountManager.get(context).setUserData(accountH, str, str2);
        qq5.c().d();
    }

    public static void B(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            if (str.equals("mobile")) {
                str2 = yh4.b(str2);
            }
            contentValues.put(str, str2);
            context.getContentResolver().update(a5.f1152a, contentValues, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void C(String str) {
        t4.b().g(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r75.r(AppContext.getContext(), "sp_exid_additional", EncryptUtils.encryptString(str));
    }

    public static void d(Context context) {
        Account accountH = h(context);
        if (accountH != null) {
            y(accountH, true, context);
        } else {
            e(context, p(context), j(context), i(context), k(context), o(context), m(context), l(context));
        }
    }

    public static void e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            t4.b().h(str);
            t4.b().g(str2);
            f(context, str3, str4, str5, str6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Account accountH = h(context);
            AccountManager accountManager = AccountManager.get(context);
            if (accountH == null) {
                Account account = new Account(TextUtils.isEmpty(str7) ? g(str) : str7, "com.zenmen.palmchat.AccountType");
                Bundle bundle = new Bundle();
                bundle.putString("mobile", str4);
                bundle.putString(w.v, str3);
                bundle.putString(DeviceInfoUtil.UID_TAG, str);
                bundle.putString("refresh_key", str6);
                bundle.putString("nick_name", str7);
                bundle.putString("sys_account_ignore", String.valueOf(jo6.j()));
                boolean zAddAccountExplicitly = accountManager.addAccountExplicitly(account, str5, bundle);
                LogUtil.i(f12176a, 3, new a(zAddAccountExplicitly), (Throwable) null);
                y(account, zAddAccountExplicitly, context);
                qq5.c().d();
            } else {
                accountManager.removeAccount(accountH, new b(str7, str, str4, str3, str6, accountManager, str5, context), null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        x(str, str2, str5, str6);
    }

    public static void f(Context context, String str, String str2, String str3, String str4) {
        try {
            ContentValues contentValues = new ContentValues();
            if (!TextUtils.isEmpty(str)) {
                contentValues.put(w.v, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("mobile", yh4.b(str2));
            }
            if (!TextUtils.isEmpty(str3)) {
                contentValues.put("session_id", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                contentValues.put("refresh_key", str4);
            }
            context.getContentResolver().insert(a5.f1152a, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String g(String str) {
        try {
            return mh2.e(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static native byte[] getAccountPublicKey(boolean z);

    @Deprecated
    public static Account h(Context context) {
        if (r75.d(context, "is_first_launch", false) || !ac1.a()) {
            return null;
        }
        return qq5.c().a(context);
    }

    public static String i(Context context) {
        return t4.b().c(w.v);
    }

    public static String j(Context context) {
        String strC = t4.b().c(bd.h);
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strDecryptString = EncryptUtils.decryptString(r75.i(context, "sp_exid_additional"));
        return !TextUtils.isEmpty(strDecryptString) ? strDecryptString : strC;
    }

    public static String k(Context context) {
        Account accountH;
        String strC = t4.b().c("mobile");
        if ((!TextUtils.isEmpty(strC) && s(strC)) || (accountH = h(context)) == null) {
            return strC;
        }
        String userData = AccountManager.get(context).getUserData(accountH, "mobile");
        LogUtil.d(f12176a, "获取系统账户信息 MOBILE:" + userData);
        return userData;
    }

    public static String l(Context context) {
        return t4.b().c("nick_name");
    }

    public static String m(Context context) {
        String strC = t4.b().c("refresh_key");
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strDecryptString = EncryptUtils.decryptString(r75.i(context, "sp_rk_additional"));
        return !TextUtils.isEmpty(strDecryptString) ? strDecryptString : strC;
    }

    @Nullable
    public static String n(Context context) {
        boolean z;
        Account accountH = h(context);
        if (accountH != null && ac1.a()) {
            AccountManager accountManager = AccountManager.get(context);
            try {
                String userData = accountManager.getUserData(accountH, "sys_account_ignore");
                LogUtil.d(f12176a, "获取系统账户信息 SYSACCOUNT_IGNORE:" + userData);
                z = Boolean.parseBoolean(userData);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            if (!z) {
                String userData2 = accountManager.getUserData(accountH, DeviceInfoUtil.UID_TAG);
                LogUtil.d(f12176a, "获取系统账户信息 UID:" + userData2);
                return userData2;
            }
        }
        return null;
    }

    public static String o(Context context) {
        String strC = t4.b().c("session_id");
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strDecryptString = EncryptUtils.decryptString(r75.i(context, "sp_sid_additional"));
        return !TextUtils.isEmpty(strDecryptString) ? strDecryptString : strC;
    }

    public static String p(Context context) {
        return q(context, true);
    }

    public static String q(Context context, boolean z) {
        String strC = t4.b().c(DeviceInfoUtil.UID_TAG);
        if (strC == null && z) {
            strC = n(context);
        }
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strDecryptString = EncryptUtils.decryptString(r75.i(context, "sp_uid_additional"));
        return !TextUtils.isEmpty(strDecryptString) ? strDecryptString : strC;
    }

    public static boolean r(Context context) {
        return (t4.b().c(DeviceInfoUtil.UID_TAG) == null && n(context) == null) ? false : true;
    }

    public static boolean s(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean t(Context context) {
        return !TextUtils.isEmpty(q(context, false));
    }

    public static void u(Context context, AccountManagerCallback<Boolean> accountManagerCallback) {
        AppContext.getContext().getTrayPreferences().h("current_uid", "");
        AppContext.getContext().getTrayPreferences().h("current_exid", "");
        r75.r(AppContext.getContext(), "sp_uid_additional", "");
        r75.r(AppContext.getContext(), "sp_exid_additional", "");
        r75.r(AppContext.getContext(), "sp_sid_additional", "");
        try {
            v(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Account accountH = h(context);
        if (accountH == null) {
            accountManagerCallback.run(null);
            return;
        }
        try {
            AccountManager.get(context).removeAccount(accountH, accountManagerCallback, null);
            qq5.c().d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void v(Context context) {
        try {
            context.getContentResolver().delete(a5.f1152a, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void x(String str, String str2, String str3, String str4) {
        LogUtil.i(f12176a, LogUtil.LogType.LOG_TYPE_BACKGROUP_FAIL, 3, new c(str), (Throwable) null);
        if (!TextUtils.isEmpty(str)) {
            r75.r(AppContext.getContext(), "sp_uid_additional", EncryptUtils.encryptString(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            r75.r(AppContext.getContext(), "sp_exid_additional", EncryptUtils.encryptString(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            r75.r(AppContext.getContext(), "sp_sid_additional", EncryptUtils.encryptString(str3));
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        r75.r(AppContext.getContext(), "sp_rk_additional", EncryptUtils.encryptString(str4));
    }

    public static void z(Context context, ContentValues contentValues) {
        A(context, "nick_name", contentValues.getAsString("contact_operation"));
    }

    public static void w(Context context, Account account) {
    }

    public static void y(Account account, boolean z, Context context) {
    }
}

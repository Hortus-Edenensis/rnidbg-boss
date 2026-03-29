package com.unicom.xiaowo.account.shield;

import android.content.Context;
import com.unicom.xiaowo.account.shield.b.c;
import com.unicom.xiaowo.account.shield.b.e;
import com.unicom.xiaowo.account.shield.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UniAccountHelper {
    private static volatile UniAccountHelper s_instance;
    private Context mContext;

    private UniAccountHelper() {
    }

    public static UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (UniAccountHelper.class) {
                if (s_instance == null) {
                    s_instance = new UniAccountHelper();
                }
            }
        }
        return s_instance;
    }

    public String getSdkVersion() {
        return e.b();
    }

    public boolean init(Context context, String str, String str2) {
        this.mContext = context.getApplicationContext();
        return e.a().a(context, str, str2);
    }

    public void login(int i, ResultListener resultListener) {
        try {
            e.a().a(this.mContext, i, 1, resultListener);
        } catch (Exception e) {
            b.b(e.getMessage());
            c.b().a("sdk异常");
        }
    }

    public void mobileAuth(int i, ResultListener resultListener) {
        try {
            e.a().a(this.mContext, i, 2, resultListener);
        } catch (Exception e) {
            b.b(e.getMessage());
            c.b().a("sdk异常");
        }
    }

    public void setLogEnable(boolean z) {
        e.a().a(z);
    }
}

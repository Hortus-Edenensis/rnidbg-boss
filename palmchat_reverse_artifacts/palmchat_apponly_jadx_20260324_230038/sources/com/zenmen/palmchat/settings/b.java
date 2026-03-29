package com.zenmen.palmchat.settings;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.bo0;
import defpackage.k86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f15274a = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static boolean a(int i, int i2) {
            return (i & i2) != 0;
        }

        public static int b(int i, boolean z, int i2) {
            return z ? i | i2 : i & (~i2);
        }
    }

    public static b c() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public void a(int i) {
        int iB = a.b(b(), true, i);
        this.f15274a = Integer.valueOf(iB);
        SPUtil.f14322a.t(SPUtil.SCENE.EXTRA_REDDOT, k86.a("key_extinfo_reddot_guide"), Integer.valueOf(iB));
    }

    public final int b() {
        if (this.f15274a == null) {
            this.f15274a = Integer.valueOf(SPUtil.f14322a.f(SPUtil.SCENE.EXTRA_REDDOT, k86.a("key_extinfo_reddot_guide"), 0));
        }
        return this.f15274a.intValue();
    }

    public boolean d(int i) {
        int iB = b();
        if (i == 4) {
            ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            return (a.a(iB, 4) || contactInfoItemL == null || contactInfoItemL.getOccupation() != 0) ? false : true;
        }
        if (i == 8) {
            ContactInfoItem contactInfoItemL2 = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            return (a.a(iB, 8) || contactInfoItemL2 == null || contactInfoItemL2.getIncome() != 0) ? false : true;
        }
        if (i == 16) {
            ContactInfoItem contactInfoItemL3 = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            return (a.a(iB, 16) || contactInfoItemL3 == null || contactInfoItemL3.getIntention() != null) ? false : true;
        }
        if (i == 2) {
            if (a.a(iB, 2)) {
                return false;
            }
            return d(4) || d(8) || d(16);
        }
        if (i == 1) {
            return !a.a(iB, 1) && d(2);
        }
        if (i == 32) {
            return !a.a(iB, 32);
        }
        if (i == 64) {
            return !a.a(iB, 64);
        }
        return false;
    }
}

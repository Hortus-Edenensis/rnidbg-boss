package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.notification.group.GroupItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w24 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21591a;
    public String b;
    public String c;
    public int d;

    public w24(String str, String str2, String str3, int i) {
        this.f21591a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public boolean a(GroupItem groupItem) {
        String str;
        String strA;
        String str2;
        String str3;
        if (groupItem == null) {
            return false;
        }
        String str4 = this.c;
        if (str4 != null) {
            str = DomainHelper.n(str4).domain;
            strA = m40.a(this.c);
        } else {
            str = null;
            strA = null;
        }
        return (TextUtils.isEmpty(groupItem.domain) || str == null || groupItem.domain.contains(str)) && (TextUtils.isEmpty(groupItem.type) || (str3 = this.b) == null || str3.equals(groupItem.type)) && ((TextUtils.isEmpty(groupItem.mid) || (str2 = this.f21591a) == null || str2.startsWith(groupItem.mid)) && (TextUtils.isEmpty(groupItem.from) || strA == null || strA.equals(groupItem.from)));
    }
}

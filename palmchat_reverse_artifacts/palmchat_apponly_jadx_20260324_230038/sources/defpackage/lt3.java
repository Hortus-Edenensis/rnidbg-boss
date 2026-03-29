package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19073a;
    public MyTabOfFriendTabConfig b;

    public lt3(Context context) {
        this.f19073a = context;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEWMYTAB);
        if (!dynamicConfig.isEnable()) {
            this.b = new MyTabOfFriendTabConfig();
            return;
        }
        MyTabOfFriendTabConfig myTabOfFriendTabConfig = (MyTabOfFriendTabConfig) dynamicConfig.parseExtra(MyTabOfFriendTabConfig.class);
        this.b = myTabOfFriendTabConfig;
        if (myTabOfFriendTabConfig == null) {
            this.b = new MyTabOfFriendTabConfig();
        }
    }

    public String a() {
        return this.b.app_center;
    }

    public int b() {
        return this.b.appused;
    }

    public String c() {
        return this.b.appused_url;
    }

    public MyTabOfFriendTabConfig d() {
        return this.b;
    }

    public String e() {
        String strH = tn0.i().h();
        if (TextUtils.isEmpty(strH)) {
            return "";
        }
        if (strH.length() <= 5) {
            return strH;
        }
        return strH.substring(0, 5) + "...";
    }

    public boolean f(String str) {
        return go.c(str, true);
    }

    public String[] g() {
        String[] strArr = new String[2];
        if (this.b == null) {
            this.b = new MyTabOfFriendTabConfig();
        }
        if (n() == 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig = this.b;
            strArr[0] = myTabOfFriendTabConfig.friendnodot_listempty_hl;
            strArr[1] = myTabOfFriendTabConfig.friendnodot_listempty_shl;
            return strArr;
        }
        if (i() > 0 && j() > 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig2 = this.b;
            strArr[0] = myTabOfFriendTabConfig2.frienddot_listboth_hl;
            strArr[1] = myTabOfFriendTabConfig2.frienddot_listboth_shl;
            return strArr;
        }
        if (i() > 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig3 = this.b;
            strArr[0] = myTabOfFriendTabConfig3.frienddot_listmay_hl;
            strArr[1] = myTabOfFriendTabConfig3.frienddot_listmay_shl;
            return strArr;
        }
        if (j() > 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig4 = this.b;
            strArr[0] = myTabOfFriendTabConfig4.frienddot_listnew_hl;
            strArr[1] = myTabOfFriendTabConfig4.frienddot_listnew_shl;
        }
        return strArr;
    }

    public String[] h() {
        String[] strArr = new String[2];
        if (this.b == null) {
            this.b = new MyTabOfFriendTabConfig();
        }
        int iM = tn0.i().m();
        if (iM == 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig = this.b;
            strArr[0] = myTabOfFriendTabConfig.nearbynull_hl;
            strArr[1] = myTabOfFriendTabConfig.nearbynull_shl;
            return strArr;
        }
        if (iM > 0) {
            MyTabOfFriendTabConfig myTabOfFriendTabConfig2 = this.b;
            strArr[0] = myTabOfFriendTabConfig2.nearby_hl;
            strArr[1] = myTabOfFriendTabConfig2.nearby_shl;
        }
        return strArr;
    }

    public int i() {
        int iR = tn0.i().r();
        return iR <= 0 ? SPUtil.f14322a.f(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_contact_new_tag"), 0) : iR;
    }

    public int j() {
        return 0;
    }

    public String k() {
        String strM = m();
        return TextUtils.isEmpty(strM) ? e() : strM;
    }

    public String l() {
        String strL = tn0.i().l();
        if (TextUtils.isEmpty(strL)) {
            return "";
        }
        if (strL.length() <= 5) {
            return strL;
        }
        return strL.substring(0, 5) + "...";
    }

    public String m() {
        String strP = tn0.i().p();
        if (TextUtils.isEmpty(strP)) {
            return "";
        }
        if (strP.length() <= 5) {
            return strP;
        }
        return strP.substring(0, 5) + "...";
    }

    public int n() {
        return j() + i();
    }

    public int o() {
        return tn0.i().m();
    }

    public String p() {
        String[] strArr = this.b.chatroom_msg;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[new Random().nextInt(this.b.chatroom_msg.length)];
    }

    public boolean q(String str) {
        return go.k(str, false);
    }
}

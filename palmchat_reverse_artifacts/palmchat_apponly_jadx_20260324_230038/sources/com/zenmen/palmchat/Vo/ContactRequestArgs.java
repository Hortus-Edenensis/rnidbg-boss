package com.zenmen.palmchat.Vo;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.io0;
import defpackage.xh4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactRequestArgs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12148a;
    public String b;
    public String c;
    public String d;
    public String e = "";
    public String f = "";
    public String g;
    public boolean h;
    public ContactRequestsVO i;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12149a;
        public String b;
        public String c;
        public String d;
        public String e = "";
        public String f = "";
        public String g;
        public boolean h;
        public ContactRequestsVO i;
        public Pair<String, String> j;

        public ContactRequestArgs a() {
            ContactRequestArgs contactRequestArgs = new ContactRequestArgs();
            Pair<String, String> pair = this.j;
            if (pair != null) {
                contactRequestArgs.m((String) pair.first);
                contactRequestArgs.l((String) this.j.second);
            } else {
                contactRequestArgs.m(this.c);
                contactRequestArgs.l(this.d);
            }
            contactRequestArgs.q(this.f12149a);
            contactRequestArgs.n(this.e);
            contactRequestArgs.r(this.b);
            contactRequestArgs.o(this.f);
            contactRequestArgs.k(this.g);
            contactRequestArgs.p(this.h);
            contactRequestArgs.j(this.i);
            return contactRequestArgs;
        }

        public Builder b(ContactRequestsVO contactRequestsVO) {
            this.i = contactRequestsVO;
            return this;
        }

        public Builder c(String str) {
            this.g = str;
            return this;
        }

        public Builder d(String str) {
            this.c = str;
            return this;
        }

        public Builder e(Pair<String, String> pair) {
            this.j = pair;
            return this;
        }

        public Builder f(String str) {
            this.e = str;
            return this;
        }

        public Builder g(String str) {
            this.f = str;
            return this;
        }

        public Builder h(boolean z) {
            this.h = z;
            return this;
        }

        public Builder i(String str) {
            this.f12149a = str;
            return this;
        }

        public Builder j(String str) {
            this.b = str;
            return this;
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("groupId", str);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<String, String> b(ContactRequestsVO contactRequestsVO) {
        String str;
        String exidFromUserInfo;
        if (contactRequestsVO != null) {
            str = contactRequestsVO.fromUid;
            exidFromUserInfo = contactRequestsVO.getExidFromUserInfo();
        } else {
            str = null;
            exidFromUserInfo = null;
        }
        return new Pair<>(str, exidFromUserInfo);
    }

    public static Pair<String, String> c(ChatItem chatItem) {
        String exid;
        String chatId = null;
        if (chatItem == null) {
            exid = null;
        } else if (chatItem instanceof ContactInfoItem) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) chatItem;
            chatId = contactInfoItem.getUid();
            exid = contactInfoItem.getExid();
        } else {
            chatId = chatItem.getChatId();
            exid = null;
        }
        return new Pair<>(chatId, exid);
    }

    public static Pair<String, String> d(xh4 xh4Var) {
        String strD;
        if (xh4Var != null) {
            strD = xh4Var.d();
            if (xh4Var.b() != null) {
                return b(xh4Var.b());
            }
        } else {
            strD = null;
        }
        return new Pair<>(strD, null);
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.f12148a;
    }

    public boolean i() {
        return this.h;
    }

    public void j(ContactRequestsVO contactRequestsVO) {
        this.i = contactRequestsVO;
    }

    public void k(String str) {
        this.g = str;
    }

    public void l(String str) {
        this.d = str;
    }

    public void m(String str) {
        this.c = str;
    }

    public void n(String str) {
        this.e = str;
    }

    public void o(String str) {
        this.f = str;
    }

    public void p(boolean z) {
        this.h = z;
    }

    public void q(String str) {
        this.f12148a = str;
    }

    public void r(String str) {
        this.b = str;
    }

    public JSONObject s() {
        ContactRequestsVO contactRequestsVO;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sourceType", this.f12148a);
            jSONObject.put(SharePluginInfo.ISSUE_SUB_TYPE, this.b);
            jSONObject.put("fuid", this.c);
            jSONObject.put("fexid", this.d);
            jSONObject.put("info", this.e);
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put("remarkName", io0.v(this.f));
            }
            jSONObject.put("extend", this.g);
            if (this.h && (contactRequestsVO = this.i) != null) {
                jSONObject.put("sign", contactRequestsVO.getSignFromUserInfo());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i("logaddfriend", "add friend request " + jSONObject);
        return jSONObject;
    }
}

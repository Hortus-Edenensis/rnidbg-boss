package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.bean.ProfileInviteBean;
import com.zenmen.square.tag.bean.CommonResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gs2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set<String> f17799a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends tw4<CommonResponse<ProfileInviteBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17800a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ int c;
        public final /* synthetic */ b d;

        public a(Context context, ContactInfoItem contactInfoItem, int i, b bVar) {
            this.f17800a = context;
            this.b = contactInfoItem;
            this.c = i;
            this.d = bVar;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<ProfileInviteBean> commonResponse) {
            if (commonResponse == null || commonResponse.getData() == null) {
                return;
            }
            if (!commonResponse.getData().allowSend) {
                if (TextUtils.isEmpty(commonResponse.getData().alertMsg)) {
                    return;
                }
                sy5.f(this.f17800a, commonResponse.getData().alertMsg, 1).g();
                return;
            }
            sy5.f(this.f17800a, "你的邀请已发送！", 1).g();
            gs2.c(this.b.getUid() + this.c);
            this.d.a();
            String str = commonResponse.getData().content;
            if (str == null) {
                int i = this.c;
                str = i == 1 ? "想知道你是不是想象中那般迷人，快设置一个头像吧~" : i == 2 ? "你好，我对你很感兴趣，想知道你最近在做些什么？发个动态和我分享一下吧！" : "你好，我带着诚意来邀请你完善个人资料，希望与你很快相识！";
            }
            gs2.f(str, this.b, commonResponse.getData().isFriend);
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            String string = this.f17800a.getString(R.string.square_http_error);
            if (TextUtils.isEmpty(str)) {
                str = string;
            }
            sy5.f(this.f17800a, str, 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();
    }

    public static void c(String str) {
        if (f17799a == null) {
            f17799a = i();
        }
        if (!f17799a.contains(str)) {
            f17799a.add(str);
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_already_invite_complete_ids"), TextUtils.join(",", f17799a));
        }
    }

    public static void d() {
        f17799a = null;
    }

    public static boolean e(String str) {
        if (f17799a == null) {
            f17799a = i();
        }
        return f17799a.contains(str);
    }

    public static void f(final String str, final ContactInfoItem contactInfoItem, final boolean z) {
        new g13(new Runnable() { // from class: fs2
            @Override // java.lang.Runnable
            public final void run() {
                gs2.h(contactInfoItem, z, str);
            }
        }).start();
    }

    public static void g(int i, Context context, ContactInfoItem contactInfoItem, b bVar) {
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getUid())) {
            return;
        }
        bj5.b().c().j(i, contactInfoItem.getUid(), contactInfoItem.getExid(), new a(context, contactInfoItem, i, bVar));
    }

    public static /* synthetic */ void h(ContactInfoItem contactInfoItem, boolean z, String str) {
        int i;
        try {
            ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItem.getUid());
            if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItem));
            }
            ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
            if (z) {
                i = 0;
            } else {
                contactInfoItemM792clone.setSourceType(47);
                i = 69;
            }
            contactInfoItemM792clone.setBizType(i);
            MessageVo messageVoG = u0.g(contactInfoItemM792clone);
            messageVoG.mid = xn3.a();
            messageVoG.text = str;
            messageVoG.mimeType = 1;
            messageVoG.status = 2;
            messageVoG.bizType = i;
            com.zenmen.palmchat.database.b.t(messageVoG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<String> i() {
        HashSet hashSet = new HashSet();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, k86.a("key_already_invite_complete_ids"), "");
        if (!TextUtils.isEmpty(strN)) {
            String[] strArrSplit = strN.split(",");
            if (strArrSplit.length > 0) {
                hashSet.addAll(Arrays.asList(strArrSplit));
            }
        }
        return hashSet;
    }
}

package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingBuyResult;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfoRequestBody;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingProfileResult;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a9 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<AiGreetingInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f1172a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;
        public final /* synthetic */ io2 d;

        public a(ChatItem chatItem, int i, List list, io2 io2Var) {
            this.f1172a = chatItem;
            this.b = i;
            this.c = list;
            this.d = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            sw4 sw4VarC = sw4.c(1, nl0.z + "/aigreet.query.text.list.v2", a9.b(this.f1172a, this.b, this.c));
            int i = this.b;
            if (i == 2 || i == 3) {
                sw4VarC.f(true);
                sw4VarC.e("网络好像有点问题，点击重试！");
            }
            return sw4VarC;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingInfo> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean != null && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                b9 b9VarD = b9.d();
                AiGreetingInfo aiGreetingInfo = lXBaseNetBean.data;
                b9VarD.m(aiGreetingInfo.remainDay, aiGreetingInfo.remainNum, null);
                if (!TextUtils.isEmpty(lXBaseNetBean.data.toast)) {
                    ry5.a(lXBaseNetBean.data.toast);
                }
            }
            this.d.onResult(z, lXBaseNetBean, exc);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SkuConfig>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io2 f1173a;

        public b(io2 io2Var) {
            this.f1173a = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/aigreet.query.package.deal.list.v1", new HashMap()).f(true).e("网络好像有点问题，点击重试！");
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SkuConfig> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean != null && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                b9 b9VarD = b9.d();
                SkuConfig skuConfig = lXBaseNetBean.data;
                b9VarD.m(skuConfig.remainDay, skuConfig.remainNum, skuConfig);
            }
            io2 io2Var = this.f1173a;
            if (io2Var != null) {
                io2Var.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<AiGreetingBuyResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f1174a;
        public final /* synthetic */ io2 b;

        public c(long j, io2 io2Var) {
            this.f1174a = j;
            this.b = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("cfgId", Long.valueOf(this.f1174a));
            return sw4.b(1, nl0.z + "/aigreet.buy.package.deal.v1", map).f(true).e("网络好像有点问题，点击重试！");
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingBuyResult> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean != null && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                b9 b9VarD = b9.d();
                AiGreetingBuyResult aiGreetingBuyResult = lXBaseNetBean.data;
                b9VarD.m(aiGreetingBuyResult.remainDay, aiGreetingBuyResult.remainNum, null);
            }
            this.b.onResult(z, lXBaseNetBean, exc);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<AiGreetingProfileResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1175a;
        public final /* synthetic */ io2 b;

        public d(String str, io2 io2Var) {
            this.f1175a = str;
            this.b = io2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("chatUid", Long.valueOf(Long.parseLong(this.f1175a)));
            return sw4.b(1, nl0.z + "/aigreet.query.user.info.complete.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingProfileResult> lXBaseNetBean, Exception exc) {
            this.b.onResult(z, lXBaseNetBean, exc);
        }
    }

    public static JSONObject b(ChatItem chatItem, int i, List<MessageVo> list) {
        try {
            return new JSONObject(az2.c(AiGreetingInfoRequestBody.build(chatItem, i, list)));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void c(long j, io2<LXBaseNetBean<AiGreetingBuyResult>> io2Var) {
        zw4.e(new c(j, io2Var));
    }

    public static void d(String str, io2<LXBaseNetBean<AiGreetingProfileResult>> io2Var) {
        zw4.e(new d(str, io2Var));
    }

    public static void e(ChatItem chatItem, int i, List<MessageVo> list, io2<LXBaseNetBean<AiGreetingInfo>> io2Var) {
        zw4.e(new a(chatItem, i, list, io2Var));
    }

    public static void f(io2<LXBaseNetBean<SkuConfig>> io2Var) {
        zw4.e(new b(io2Var));
    }
}

package defpackage;

import android.util.Pair;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingChatCardInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfoRequestBody;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x8 implements w8 {
    public ChatterAdapter d;
    public AiGreetingChatCardInfo e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21897a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements io2<LXBaseNetBean<AiGreetingInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21898a;
        public final /* synthetic */ Pair b;
        public final /* synthetic */ long c;

        public a(boolean z, Pair pair, long j) {
            this.f21898a = z;
            this.b = pair;
            this.c = j;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
        @Override // defpackage.io2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean z, LXBaseNetBean<AiGreetingInfo> lXBaseNetBean, Exception exc) {
            boolean zN;
            AiGreetingInfo aiGreetingInfo;
            LogUtil.i("AiGreetingCardMsgHelper", "requestImp end");
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (aiGreetingInfo = lXBaseNetBean.data) == null || aiGreetingInfo.textList == null) {
                zN = false;
            } else {
                AiGreetingChatCardInfo aiGreetingChatCardInfo = new AiGreetingChatCardInfo();
                aiGreetingChatCardInfo.isGenFromMsg = this.f21898a;
                aiGreetingChatCardInfo.textList = lXBaseNetBean.data.textList;
                aiGreetingChatCardInfo.lastMsgTime = ((Long) this.b.second).longValue();
                LogUtil.i("AiGreetingCardMsgHelper", "requestGreetings success ");
                ArrayList<MessageVo> arrayListI = x8.this.d.I();
                if (this.c == (arrayListI.size() > 0 ? arrayListI.get(arrayListI.size() - 1).time : 0L)) {
                    zN = x8.this.n(aiGreetingChatCardInfo);
                }
            }
            if (zN) {
                return;
            }
            LogUtil.i("AiGreetingCardMsgHelper", "post AiGreetingQuickRequestFailEvent");
            ds0.a().b(new d9());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements io2<LXBaseNetBean<AiGreetingInfo>> {
        public b() {
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingInfo> lXBaseNetBean, Exception exc) {
            AiGreetingInfo aiGreetingInfo;
            LogUtil.i("AiGreetingCardMsgHelper", "requestImp refresh end" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (aiGreetingInfo = lXBaseNetBean.data) == null || aiGreetingInfo.textList == null) {
                x8.this.e.state = AiGreetingChatCardInfo.State.ERROR;
            } else {
                x8.this.e.textList = lXBaseNetBean.data.textList;
                x8.this.e.state = AiGreetingChatCardInfo.State.SUCCESS;
            }
            x8.this.d.notifyDataSetChanged();
        }
    }

    public x8(ChatterAdapter chatterAdapter) {
        this.d = chatterAdapter;
    }

    @Override // defpackage.w8
    public void a(String str) {
        this.d.s0();
        this.e = null;
    }

    public final MessageVo e() {
        MessageVo messageVo = new MessageVo();
        messageVo.time = ir5.b();
        messageVo.mimeType = 200010;
        messageVo.text = "ai-greeting";
        return messageVo;
    }

    public boolean f() {
        ChatItem chatItemF = this.d.F();
        b9.d().f();
        return b9.j() && b9.d().g() && (chatItemF instanceof ContactInfoItem) && !a65.e(chatItemF) && !a65.c(chatItemF) && ((ContactInfoItem) chatItemF).getIsStranger() && !mi5.p(this.d.J().e(), chatItemF.getChatId(), false) && b9.d().h();
    }

    public void g(boolean z) {
        if ((this.b && this.c) || z) {
            if (!this.f21897a || z) {
                this.f21897a = true;
                o();
            }
        }
    }

    public AiGreetingChatCardInfo h() {
        return this.e;
    }

    public final void i(ArrayList<MessageVo> arrayList) {
        ChatItem chatItemF = this.d.F();
        if (b9.j() && mi5.p(this.d.J().e(), chatItemF.getChatId(), false)) {
            arrayList.add(mi5.n(chatItemF, this.d.J().e()));
        }
    }

    public void j(boolean z) {
        LogUtil.i("AiGreetingCardMsgHelper", "onChatAvailableFinished " + z);
        this.c = z;
        g(false);
    }

    public void k(ArrayList<MessageVo> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("onDataLoad lastMsgTime ");
        AiGreetingChatCardInfo aiGreetingChatCardInfo = this.e;
        sb.append(aiGreetingChatCardInfo == null ? 0L : aiGreetingChatCardInfo.lastMsgTime);
        LogUtil.i("AiGreetingCardMsgHelper", sb.toString());
        this.b = true;
        g(false);
        AiGreetingChatCardInfo aiGreetingChatCardInfo2 = this.e;
        if (aiGreetingChatCardInfo2 != null && aiGreetingChatCardInfo2.lastMsgTime == AiGreetingInfoRequestBody.getLastRightMsgTime(arrayList)) {
            arrayList.add(e());
        }
        i(arrayList);
    }

    @Override // defpackage.w8
    public void l() {
        AiGreetingChatCardInfo aiGreetingChatCardInfo = this.e;
        if (aiGreetingChatCardInfo == null) {
            return;
        }
        AiGreetingChatCardInfo.State state = aiGreetingChatCardInfo.state;
        AiGreetingChatCardInfo.State state2 = AiGreetingChatCardInfo.State.LOADING;
        if (state == state2) {
            return;
        }
        aiGreetingChatCardInfo.state = state2;
        this.d.notifyDataSetChanged();
        LogUtil.i("AiGreetingCardMsgHelper", "requestImp refresh start");
        b9.d().k(this.d.F(), 3, this.d.I(), new b());
    }

    public final boolean n(AiGreetingChatCardInfo aiGreetingChatCardInfo) {
        LogUtil.i("AiGreetingCardMsgHelper", "refreshOnDataLoad start ");
        if (this.e != null || aiGreetingChatCardInfo == null || this.f) {
            return false;
        }
        this.e = aiGreetingChatCardInfo;
        LogUtil.i("AiGreetingCardMsgHelper", "refreshOnDataLoad enter ");
        this.d.B(e());
        return true;
    }

    public final void o() {
        LogUtil.i("AiGreetingCardMsgHelper", "requestImp start");
        if (f()) {
            LogUtil.i("AiGreetingCardMsgHelper", "requestImp enter");
            ArrayList<MessageVo> arrayListI = this.d.I();
            long j = arrayListI.size() > 0 ? arrayListI.get(arrayListI.size() - 1).time : 0L;
            Pair<List<AiGreetingInfoRequestBody.Records>, Long> pairBuildRecords = AiGreetingInfoRequestBody.buildRecords(arrayListI);
            b9.d().k(this.d.F(), 1, this.d.I(), new a(((List) pairBuildRecords.first).size() > 0, pairBuildRecords, j));
        }
    }

    @Override // defpackage.w8
    public void w() {
        this.d.s0();
        this.e = null;
        this.f = true;
    }
}

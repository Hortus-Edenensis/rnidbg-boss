package defpackage;

import android.content.Context;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.zp4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aq4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements zp4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f1553a;
        public final /* synthetic */ QuickSendVo b;
        public final /* synthetic */ boolean c;

        public a(b bVar, QuickSendVo quickSendVo, boolean z) {
            this.f1553a = bVar;
            this.b = quickSendVo;
            this.c = z;
        }

        @Override // zp4.b
        public void a(boolean z) {
            if (z) {
                SPUtil.f14322a.t(SPUtil.SCENE.GIFT_QUICKSEND, "key_quick_send_gift_confirm", Boolean.TRUE);
            }
            this.f1553a.a(this.b);
            bq4.c(false, z ? 1 : 2);
        }

        @Override // zp4.b
        public void onCancel() {
            bq4.c(false, 3);
            ds0.a().b(new n30(n30.b));
            if (this.c) {
                ds0.a().b(new ShowChatGiftPanelEvent(null, null));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(QuickSendVo quickSendVo);
    }

    public static void a(Context context, QuickSendVo quickSendVo, b bVar) {
        b(context, quickSendVo, bVar, false);
    }

    public static void b(Context context, QuickSendVo quickSendVo, b bVar, boolean z) {
        if (SPUtil.f14322a.a(SPUtil.SCENE.GIFT_QUICKSEND, "key_quick_send_gift_confirm", false) || quickSendVo.isPack()) {
            bVar.a(quickSendVo);
            return;
        }
        zp4 zp4Var = new zp4(context);
        zp4Var.g(quickSendVo);
        zp4Var.h(new a(bVar, quickSendVo, z));
        bq4.c(true, -1);
    }
}

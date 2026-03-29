package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.GiftCardConfig;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x92 extends SimpleChatViewAdapter {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.d("chatlw_card_click", null, null);
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 28;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (31 != messageVo.mimeType) {
            return null;
        }
        return messageVo.isSend ? this.e.inflate(R.layout.list_item_chat_gift_card_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_chat_gift_card_left, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new y92(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        w(messageVo, (y92) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 31) {
            return z ? 29 : 28;
        }
        return -1;
    }

    public void w(MessageVo messageVo, y92 y92Var) {
        GiftCardConfig.GiftCardBean giftCardBean;
        String str = messageVo.extention;
        GiftCardConfig giftCardConfig = !TextUtils.isEmpty(str) ? (GiftCardConfig) az2.a(str, GiftCardConfig.class) : null;
        if (giftCardConfig == null || (giftCardBean = giftCardConfig.giftMsg) == null) {
            return;
        }
        y92Var.v.setVisibility(TextUtils.equals("0", giftCardBean.showType) ? 8 : 0);
        gr2.j().h(giftCardBean.icon + "@2x.png", y92Var.s, bq6.s());
        TextView textView = y92Var.t;
        StringBuilder sb = new StringBuilder();
        sb.append(messageVo.isSend ? "送出" : "送你");
        sb.append(giftCardBean.count);
        sb.append("个");
        sb.append(giftCardBean.giftName);
        textView.setText(sb.toString());
        y92Var.u.setText(giftCardBean.formatTotalPrice());
        y92Var.r.setOnClickListener(new a());
    }
}

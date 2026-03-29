package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ChatOneVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t30 extends SimpleChatViewAdapter {
    public HashMap<Long, Boolean> i = new HashMap<>();
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends u10 {
        public TextView r;
        public View s;

        public a(View view) {
            super(view);
            this.r = (TextView) view.findViewById(R.id.text);
            this.s = view.findViewById(R.id.contentLayout);
        }

        @Override // defpackage.u10
        public boolean f() {
            return false;
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (71 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_one_guide, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new a(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (t instanceof a) {
            w(messageVo, (a) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 71 ? 45 : -1;
    }

    public void w(MessageVo messageVo, a aVar) {
        RichMsgVo richMsgVo;
        ChatOneVo chatOneVo;
        aVar.r.setText(messageVo.text);
        if (!TextUtils.isEmpty(messageVo.extention) && (richMsgVo = (RichMsgVo) az2.a(messageVo.extention, RichMsgVo.class)) != null && (chatOneVo = richMsgVo.chatOne) != null) {
            aVar.r.setText(messageVo.isSend ? chatOneVo.selfContent : chatOneVo.realContent);
        }
        x(messageVo);
    }

    public final void x(MessageVo messageVo) {
        if (this.j) {
            return;
        }
        this.j = true;
    }
}

package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.venus.bean.VenusRoomShareCard;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n96 extends SimpleChatViewAdapter {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f19465a;

        public a(MessageVo messageVo) {
            this.f19465a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVarO = n96.this.r().o();
            if (hVarO == null) {
                return true;
            }
            hVarO.m(this.f19465a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ez2.a("服务已关闭");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ez2.a("服务已关闭");
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 44;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (37 == messageVo.mimeType && messageVo.getExTypeForSend() == 1) {
            return messageVo.isSend ? this.e.inflate(R.layout.list_item_chat_venus_room_share_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_chat_venus_room_share_left, (ViewGroup) null);
        }
        return null;
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new o96(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        w(messageVo, (o96) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 37) {
            return z ? 45 : 44;
        }
        return -1;
    }

    public void w(MessageVo messageVo, o96 o96Var) {
        o96Var.r.setOnLongClickListener(new a(messageVo));
        VenusRoomShareCard venusRoomShareCardI = p96.i(messageVo.extention);
        if (venusRoomShareCardI == null) {
            return;
        }
        boolean z = ir5.c(true) - messageVo.time > 21600000;
        o96Var.r.setSelected(venusRoomShareCardI.gender == 1);
        o96Var.s.setSelected(venusRoomShareCardI.gender == 1);
        o96Var.u.setSelected(venusRoomShareCardI.gender == 1);
        o96Var.t.setSelected(venusRoomShareCardI.gender == 1);
        o96Var.w.setSelected(venusRoomShareCardI.gender == 1);
        o96Var.x.setUrl(venusRoomShareCardI.avatar, "");
        o96Var.x.setGender(venusRoomShareCardI.gender);
        if (z) {
            o96Var.x.stop();
            o96Var.s.setText("");
            o96Var.t.setText(messageVo.isSend ? "邀请已过期" : "太遗憾了，邀请已过期");
            o96Var.u.setText("");
            o96Var.v.setText(messageVo.isSend ? "快去重新发送邀请吧~" : "下次要趁早哦～");
            o96Var.w.setText("查看更多房间");
        } else {
            o96Var.x.start();
            if (TextUtils.isEmpty(venusRoomShareCardI.channelCateText)) {
                o96Var.x.setBottomText("派对");
            } else {
                o96Var.x.setBottomText(venusRoomShareCardI.channelCateText);
            }
            o96Var.s.setText(venusRoomShareCardI.channelTitle);
            o96Var.t.setText("我正在“");
            o96Var.u.setText("”聊天");
            o96Var.v.setText("邀请你进来一起玩");
            o96Var.w.setText("去聊天");
        }
        o96Var.y.setText(fu5.m(5001));
        o96Var.r.setOnClickListener(new b());
        if (z) {
            o96Var.w.setOnClickListener(new c());
        } else {
            o96Var.w.setClickable(false);
        }
    }
}

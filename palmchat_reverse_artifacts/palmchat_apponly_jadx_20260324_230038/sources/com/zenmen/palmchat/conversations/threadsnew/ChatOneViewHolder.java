package com.zenmen.palmchat.conversations.threadsnew;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneItemVo;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.ch;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.l50;
import defpackage.s30;
import defpackage.w30;
import defpackage.zn6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatOneViewHolder extends BaseRecyclerViewHolder<ConversationAdapter.b> implements ViewSwitcher.ViewFactory {
    public ViewSwitcher f;
    public View g;
    public TextView h;
    public long i;
    public Set<String> j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ChatOneViewHolder.this.y();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ChatOneViewHolder.this.h.setText(ChatOneViewHolder.this.v());
            ch.s().r().i(new s30());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            ChatOneViewHolder.this.h.setText(ChatOneViewHolder.this.v());
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
            w30.f().k(ChatOneViewHolder.this.m());
        }
    }

    public ChatOneViewHolder(Context context) {
        super(context, R.layout.list_item_threads_list_chatone);
        this.i = 0L;
        this.j = new HashSet();
        this.f = (ViewSwitcher) this.itemView.findViewById(R.id.vs);
        this.g = this.itemView.findViewById(R.id.btn);
        this.h = (TextView) this.itemView.findViewById(R.id.time);
        this.g.setOnClickListener(new a());
        this.f.setFactory(this);
        this.f.setInAnimation(m(), R.anim.vip_text_des_enter);
        this.f.setOutAnimation(m(), R.anim.vip_text_des_exit);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        return View.inflate(m(), R.layout.viewswitcher_item_chatone, null);
    }

    public final void u() {
        if (this.i == 0) {
            this.i = ir5.b();
            new b(3000L, 1000L).start();
        }
    }

    public final String v() {
        long j = this.i;
        int iE = j > 0 ? 3 - ((int) (ir5.e(j) / 1000)) : 3;
        if (iE < 0) {
            iE = 0;
        }
        return iE + "秒";
    }

    public final void w(ChatOneItemVo chatOneItemVo) {
        if (this.j.contains(chatOneItemVo.uid)) {
            return;
        }
        this.j.add(chatOneItemVo.uid);
        HashMap map = new HashMap();
        map.put("fuid", chatOneItemVo.uid);
        zn6.h("msg_chatlots_msg", "view", map);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void o(ConversationAdapter.b bVar, int i) {
        ChatOneItemVo chatOneItemVoE = w30.f().e();
        z(this.f.getCurrentView(), chatOneItemVoE);
        if (chatOneItemVoE != null) {
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            this.i = 0L;
        } else {
            u();
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(v());
        }
        this.itemView.setOnClickListener(new c());
    }

    public final void y() {
        if (w30.f().m()) {
            z(this.f.getNextView(), w30.f().e());
            this.f.showNext();
        }
    }

    public final void z(View view, ChatOneItemVo chatOneItemVo) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        TextView textView2 = (TextView) view.findViewById(R.id.message);
        TextView textView3 = (TextView) view.findViewById(R.id.additionMessage);
        if (chatOneItemVo == null) {
            textView.setText("明天可遇见新缘分😍");
            textView2.setText("今日聊一个已推荐完毕");
            hc2.a(m()).load(Integer.valueOf(R.drawable.ic_chat_one_default)).placeholder(R.drawable.ic_chat_one_default).error(R.drawable.ic_chat_one_default).into(imageView);
            textView3.setVisibility(8);
            return;
        }
        w(chatOneItemVo);
        textView.setText(chatOneItemVo.nickname);
        textView2.setText(chatOneItemVo.cardMsg);
        hc2.a(m()).load(chatOneItemVo.avatar).placeholder(R.drawable.default_portrait_new).error(R.drawable.default_portrait_new).into(imageView);
        textView3.setVisibility(chatOneItemVo.hasClicked ? 8 : 0);
    }
}

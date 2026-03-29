package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.GuideInfoForChatCard;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u20 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21117a;

        public a(String str) {
            this.f21117a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (il5.l(this.f21117a) || l50.a()) {
                return;
            }
            if (!hx3.m(u20.this.f)) {
                sy5.e(u20.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            ChatterAdapter.h hVarW = u20.this.w();
            if (hVarW != null) {
                hVarW.q1(this.f21117a);
            }
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (20001 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_guide, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new v20(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        x(messageVo, (v20) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 20001 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public ChatterAdapter.h w() {
        return r().o();
    }

    public void x(MessageVo messageVo, v20 v20Var) {
        String str;
        RichMsgVo richMsgVo;
        View view = v20Var.r;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = v20Var.g;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = v20Var.h;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        LXPortraitView lXPortraitView = v20Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view4 = v20Var.j;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        ImageView imageView = v20Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = v20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = v20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        String str2 = messageVo.extention;
        GuideInfoForChatCard guideInfoForChatCard = (TextUtils.isEmpty(str2) || (richMsgVo = (RichMsgVo) az2.a(str2, RichMsgVo.class)) == null) ? null : richMsgVo.guideInfo;
        if (guideInfoForChatCard == null) {
            return;
        }
        int i = guideInfoForChatCard.styleType;
        if (1 == i) {
            v20Var.s.setVisibility(0);
            v20Var.u.setVisibility(8);
            v20Var.A.setVisibility(8);
            v20Var.t.setText(guideInfoForChatCard.content);
            str = "1";
        } else {
            if (3 == i || 2 == i || 4 == i) {
                String str3 = guideInfoForChatCard.title;
                if (il5.l(str3)) {
                    ArrayList<String> arrayList = guideInfoForChatCard.icon;
                    if (arrayList == null || arrayList.isEmpty()) {
                        v20Var.r.setVisibility(8);
                    } else if (arrayList.size() > 1) {
                        v20Var.s.setVisibility(8);
                        v20Var.u.setVisibility(8);
                        v20Var.A.setVisibility(0);
                        v20Var.B.setText(guideInfoForChatCard.content);
                        v20Var.D.setVisibility(0);
                        v20Var.E.setVisibility(8);
                        v20Var.F.setVisibility(8);
                        v20Var.D.changeShapeType(3);
                        v20Var.D.setDegreeForRoundRectangle(me1.b(this.f, 6), me1.b(this.f, 6));
                        gr2.j().h(guideInfoForChatCard.icon.get(0), v20Var.D, bq6.c());
                        if (arrayList.size() == 2) {
                            v20Var.E.setVisibility(0);
                            v20Var.F.setVisibility(8);
                            v20Var.E.changeShapeType(3);
                            v20Var.E.setDegreeForRoundRectangle(me1.b(this.f, 6), me1.b(this.f, 6));
                            gr2.j().h(guideInfoForChatCard.icon.get(1), v20Var.E, bq6.c());
                        } else if (arrayList.size() >= 3) {
                            v20Var.E.setVisibility(0);
                            v20Var.F.setVisibility(0);
                            v20Var.E.changeShapeType(3);
                            v20Var.E.setDegreeForRoundRectangle(me1.b(this.f, 6), me1.b(this.f, 6));
                            gr2.j().h(guideInfoForChatCard.icon.get(1), v20Var.E, bq6.c());
                            v20Var.F.changeShapeType(3);
                            v20Var.F.setDegreeForRoundRectangle(me1.b(this.f, 6), me1.b(this.f, 6));
                            gr2.j().h(guideInfoForChatCard.icon.get(2), v20Var.F, bq6.c());
                        }
                        str = "5";
                    } else {
                        v20Var.s.setVisibility(8);
                        v20Var.u.setVisibility(0);
                        v20Var.A.setVisibility(8);
                        v20Var.w.setVisibility(0);
                        v20Var.z.setVisibility(8);
                        v20Var.v.setText(guideInfoForChatCard.content);
                        v20Var.x.changeShapeType(3);
                        v20Var.x.setDegreeForRoundRectangle(me1.b(this.f, 6), me1.b(this.f, 6));
                        gr2.j().h(guideInfoForChatCard.icon.get(0), v20Var.x, bq6.c());
                        if (4 == i) {
                            v20Var.y.setVisibility(0);
                            str = "4";
                        } else {
                            v20Var.y.setVisibility(8);
                            str = "3";
                        }
                    }
                } else {
                    v20Var.s.setVisibility(8);
                    v20Var.u.setVisibility(0);
                    v20Var.A.setVisibility(8);
                    v20Var.w.setVisibility(8);
                    v20Var.z.setVisibility(0);
                    v20Var.v.setText(guideInfoForChatCard.content);
                    v20Var.z.setText(str3);
                    str = "2";
                }
            } else {
                v20Var.r.setVisibility(8);
            }
            str = "";
        }
        v20Var.r.setOnClickListener(new a(guideInfoForChatCard.turnUrl));
        y(str);
    }

    public final void y(String str) {
        if (this.i) {
            return;
        }
        HashMap map = new HashMap();
        map.put("type", str);
        ChatItem chatItemO = o();
        if (chatItemO != null) {
            map.put("targetUid", chatItemO.getChatId());
        }
        zn6.i("pagechat_topic", map);
        this.i = true;
    }
}

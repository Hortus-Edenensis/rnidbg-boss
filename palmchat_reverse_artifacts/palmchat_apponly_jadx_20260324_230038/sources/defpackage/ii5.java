package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.MediaForChatCard;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ii5 extends SimpleChatViewAdapter {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeedForChatCard f18174a;
        public final /* synthetic */ MessageVo b;

        public a(SquareFeedForChatCard squareFeedForChatCard, MessageVo messageVo) {
            this.f18174a = squareFeedForChatCard;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (!hx3.m(ii5.this.f)) {
                sy5.e(ii5.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            SquareFeed squareFeed = new SquareFeed();
            SquareFeedForChatCard squareFeedForChatCard = this.f18174a;
            squareFeed.feedType = squareFeedForChatCard.feedType;
            squareFeed.id = squareFeedForChatCard.id;
            squareFeed.exid = squareFeedForChatCard.exid;
            if (!this.b.isSend) {
                squareFeed.exid = AccountUtils.j(ii5.this.f);
            }
            MediaViewActivity.B1(8, ii5.this.f, squareFeed, false);
            mi5.o(this.f18174a, "pageprichat_postcard_click");
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 40;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (33 != messageVo.mimeType) {
            return null;
        }
        return messageVo.isSend ? this.e.inflate(R.layout.list_item_chat_square_feed_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_chat_square_feed_left, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new ji5(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        w(messageVo, (ji5) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 33) {
            return z ? 41 : 40;
        }
        return -1;
    }

    public void w(MessageVo messageVo, ji5 ji5Var) {
        String str;
        RichMsgVo richMsgVo;
        View view = ji5Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = ji5Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = ji5Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = ji5Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = ji5Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = ji5Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = ji5Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        String str2 = messageVo.extention;
        SquareFeedForChatCard squareFeedForChatCard = (TextUtils.isEmpty(str2) || (richMsgVo = (RichMsgVo) az2.a(str2, RichMsgVo.class)) == null) ? null : richMsgVo.squareFeed;
        if (squareFeedForChatCard == null) {
            return;
        }
        str = "和Ta聊聊这个动态的故事吧~";
        String str3 = "Ta对你的这条动态很感兴趣~";
        try {
            JSONObject jSONObjectB = ts0.o().B();
            if (jSONObjectB != null) {
                String string = jSONObjectB.getString("postcardsender");
                String string2 = jSONObjectB.getString("postcardacceptor");
                str = TextUtils.isEmpty(string) ? "和Ta聊聊这个动态的故事吧~" : string;
                if (!TextUtils.isEmpty(string2)) {
                    str3 = string2;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (messageVo.isSend) {
            ji5Var.s.setText(str);
        } else {
            ji5Var.s.setText(str3);
        }
        ji5Var.t.changeShapeType(3);
        ji5Var.t.setDegreeForRoundRectangle(me1.b(this.f, 4), me1.b(this.f, 4));
        List<MediaForChatCard> list = squareFeedForChatCard.mediaList;
        if (list != null && list.size() > 0) {
            gr2.j().h(squareFeedForChatCard.mediaList.get(0).thumbUrl, ji5Var.t, bq6.u());
        }
        if (squareFeedForChatCard.feedType == 3) {
            ji5Var.u.setVisibility(0);
        } else {
            ji5Var.u.setVisibility(8);
        }
        ji5Var.r.setOnClickListener(new a(squareFeedForChatCard, messageVo));
    }
}

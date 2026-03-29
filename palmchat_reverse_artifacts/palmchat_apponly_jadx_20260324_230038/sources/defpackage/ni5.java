package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.MediaForChatCard;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedShareCard;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ni5 extends SimpleChatViewAdapter {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f19519a;

        public a(MessageVo messageVo) {
            this.f19519a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVarO = ni5.this.r().o();
            if (hVarO == null) {
                return true;
            }
            hVarO.m(this.f19519a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeedShareCard f19520a;

        public b(SquareFeedShareCard squareFeedShareCard) {
            this.f19520a = squareFeedShareCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (!hx3.m(ni5.this.f)) {
                sy5.e(ni5.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            SquareFeed squareFeed = new SquareFeed();
            SquareFeedShareCard squareFeedShareCard = this.f19520a;
            squareFeed.feedType = squareFeedShareCard.feedType;
            squareFeed.id = squareFeedShareCard.id;
            squareFeed.uid = squareFeedShareCard.uid;
            MediaViewActivity.B1(8, ni5.this.f, squareFeed, false);
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 42;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (34 != messageVo.mimeType) {
            return null;
        }
        return messageVo.isSend ? this.e.inflate(R.layout.list_item_chat_square_feed_share_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_chat_square_feed_share_left, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new oi5(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        w(messageVo, (oi5) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 34) {
            return z ? 43 : 42;
        }
        return -1;
    }

    public void w(MessageVo messageVo, oi5 oi5Var) {
        RichMsgVo richMsgVo;
        SquareFeedShareCard squareFeedShareCard;
        List<MediaForChatCard> list;
        oi5Var.r.setOnLongClickListener(new a(messageVo));
        String str = messageVo.extention;
        MediaForChatCard mediaForChatCard = null;
        if (TextUtils.isEmpty(str)) {
            richMsgVo = null;
            squareFeedShareCard = null;
        } else {
            richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class);
            squareFeedShareCard = richMsgVo != null ? richMsgVo.squareShareFeed : null;
        }
        if (squareFeedShareCard == null) {
            return;
        }
        String str2 = squareFeedShareCard.content;
        if (TextUtils.isEmpty(str2)) {
            str2 = "分享动态";
        }
        oi5Var.s.setText(str2);
        int i = squareFeedShareCard.deleted;
        if (i != 2 && i != 3) {
            Iterator<SquareFeed> it = r().j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SquareFeed next = it.next();
                if (squareFeedShareCard.id == next.id) {
                    squareFeedShareCard.deleted = next.deleted;
                    com.zenmen.palmchat.database.b.O(messageVo, richMsgVo);
                    break;
                }
            }
        }
        int i2 = squareFeedShareCard.deleted;
        if (i2 == 2 || i2 == 3 || (list = squareFeedShareCard.mediaList) == null || list.size() <= 0) {
            oi5Var.u.setImageResource(R.drawable.default_img_square_feed_thumb_in_chat);
        } else {
            gr2.j().h(squareFeedShareCard.mediaList.get(0).thumbUrl, oi5Var.u, a46.l());
        }
        if (squareFeedShareCard.feedType == 3) {
            oi5Var.v.setVisibility(0);
        } else {
            oi5Var.v.setVisibility(8);
        }
        String str3 = squareFeedShareCard.location;
        List<MediaForChatCard> list2 = squareFeedShareCard.mediaList;
        if (list2 != null && !list2.isEmpty()) {
            mediaForChatCard = squareFeedShareCard.mediaList.get(0);
        }
        if (mediaForChatCard != null && !TextUtils.isEmpty(mediaForChatCard.location)) {
            str3 = mediaForChatCard.location;
        }
        if (TextUtils.isEmpty(str3)) {
            oi5Var.t.setVisibility(8);
        } else {
            oi5Var.t.setVisibility(0);
            oi5Var.t.setText(str3);
        }
        oi5Var.r.setOnClickListener(new b(squareFeedShareCard));
    }
}

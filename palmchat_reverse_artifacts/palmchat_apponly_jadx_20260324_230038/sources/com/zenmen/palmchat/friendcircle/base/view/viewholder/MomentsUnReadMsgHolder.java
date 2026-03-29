package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.greendao.model.Feed;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.nq3;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MomentsUnReadMsgHolder extends BaseRecyclerViewHolder<Feed> {
    public TextView f;
    public ImageView g;
    public Feed.UnreadMsg h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14023a;

        public a(Context context) {
            this.f14023a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nq3.a().c(this.f14023a);
            HashMap map = new HashMap();
            map.put("nums", Integer.valueOf(MomentsUnReadMsgHolder.this.h.count));
            zn6.j("pagediscover_top_frindnewscli", "click", map);
        }
    }

    public MomentsUnReadMsgHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.f = (TextView) r(this.f, R$id.unsend_tips);
        this.g = (ImageView) r(this.g, R$id.message_avatar);
        this.itemView.setPadding(0, me1.b(context, 10), 0, me1.b(context, 5));
        this.itemView.setOnClickListener(new a(context));
    }

    public final View r(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void o(Feed feed, int i) {
        Feed.UnreadMsg unreadMsg;
        if (feed == null || (unreadMsg = feed.unreadMsg) == null) {
            return;
        }
        this.h = unreadMsg;
        gr2.j().h(k86.p(feed.unreadMsg.url), this.g, hr2.i());
        this.f.setText(m().getString(R$string.moments_unread_msg_tips, Integer.valueOf(feed.unreadMsg.count)));
    }
}

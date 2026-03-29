package com.zenmen.palmchat.friendcircle.base.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AdViewHolderForCSJ;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AdViewHolderForNestNew;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsNoMoreHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsUnReadMsgHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.MultiImageViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.SmallVideoViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.VenusShareViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.VideoViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.WebAppViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.WebViewHolder;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.lq3;
import defpackage.vq3;
import defpackage.w50;
import defpackage.wt1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MomentsBaseAdapter extends BaseRecyclerViewAdapter<Feed> {
    public final Context j;
    public lq3 k;
    public List<AdViewHolderForCSJ> l;
    public List<AdViewHolderForNestNew> m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;

    public MomentsBaseAdapter(@NonNull Context context, @NonNull List<Feed> list, lq3 lq3Var, int i) {
        super(context, list);
        this.n = false;
        this.o = false;
        this.j = context;
        this.k = lq3Var;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.p = i;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        MomentsBaseViewHolder momentsBaseViewHolder;
        if (i == 101) {
            return new MomentsUnReadMsgHolder(this.e, viewGroup, R$layout.moment_message_tips);
        }
        if (i == 201) {
            return new MomentsNoMoreHolder(this.e, viewGroup, R$layout.moment_footer);
        }
        if (i == 2) {
            momentsBaseViewHolder = new MultiImageViewHolder(this.e, viewGroup, R$layout.moments_multi_image_right);
            momentsBaseViewHolder.t();
        } else if (i == 1) {
            momentsBaseViewHolder = new MomentsBaseViewHolder(this.e, viewGroup, R$layout.moments_only_text_right);
            momentsBaseViewHolder.t();
        } else if (i == 4) {
            momentsBaseViewHolder = new WebViewHolder(this.e, viewGroup, R$layout.moments_web_right);
            momentsBaseViewHolder.t();
        } else if (i == 3) {
            momentsBaseViewHolder = new VideoViewHolder(this.e, viewGroup, R$layout.moments_video_right);
        } else if (i == 5) {
            if (vq3.m()) {
                momentsBaseViewHolder = new AdViewHolderForNestNew(this.e, viewGroup, this.n);
                this.m.add(momentsBaseViewHolder);
            } else {
                momentsBaseViewHolder = new AdViewHolderForCSJ(this.e, viewGroup, w50.G() ? R$layout.moments_ad_csj_style2 : R$layout.moments_ad_csj, this.n);
                this.l.add(momentsBaseViewHolder);
            }
        } else if (i == 7) {
            momentsBaseViewHolder = new WebAppViewHolder(this.e, viewGroup, R$layout.moments_webapp_right);
            momentsBaseViewHolder.t();
        } else if (i == 8) {
            momentsBaseViewHolder = new VenusShareViewHolder(this.e, viewGroup, R$layout.moments_venus_share_room_right);
            momentsBaseViewHolder.t();
        } else if (i == 6) {
            momentsBaseViewHolder = new SmallVideoViewHolder(this.e, viewGroup, R$layout.moments_smallvideo_right);
            momentsBaseViewHolder.t();
        } else {
            momentsBaseViewHolder = new MomentsBaseViewHolder(this.e, viewGroup, R$layout.moments_empty_content);
        }
        momentsBaseViewHolder.C(this.k);
        momentsBaseViewHolder.A(this);
        momentsBaseViewHolder.B(this.p);
        return momentsBaseViewHolder;
    }

    public boolean r() {
        return this.n;
    }

    public String s() {
        return this.q;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull Feed feed) {
        if (feed.getFeedSource() == wt1.b) {
            return 5;
        }
        return feed.getFeedType();
    }

    public void u() {
        List<AdViewHolderForNestNew> list = this.m;
        if (list != null && list.size() > 0) {
            Iterator<AdViewHolderForNestNew> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().K();
            }
        }
        w50.e();
    }

    public void v() {
        List<AdViewHolderForNestNew> list = this.m;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdViewHolderForNestNew> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void w(boolean z) {
        LogUtil.i("MomentsBaseAdapter", "isAdEnabled = " + z);
        this.n = z;
        Iterator<AdViewHolderForCSJ> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().N(z);
        }
        Iterator<AdViewHolderForNestNew> it2 = this.m.iterator();
        while (it2.hasNext()) {
            it2.next().O(z);
        }
        notifyDataSetChanged();
    }

    public void x(String str) {
        this.q = str;
    }
}

package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.SquareLoadFooter;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.a;
import com.zenmen.palmchat.friendcircle.base.view.adapter.MomentsBaseAdapter;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gj5 extends com.zenmen.palmchat.friendcircle.a {
    public SmartRefreshLayout d;
    public RecyclerView e;
    public View f;
    public MomentsBaseAdapter g;
    public int h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements j74 {
        public a() {
        }

        @Override // defpackage.j74
        public void a(@NonNull xu4 xu4Var) {
            gj5.this.b.g(gj5.this.h);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c74 {
        public b() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            gj5.this.b.a();
        }
    }

    public gj5(Activity activity, a.InterfaceC1048a interfaceC1048a) {
        super(activity, interfaceC1048a);
        this.h = 2;
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void a(String str, int i) {
        Feed feed;
        boolean z;
        MomentsBaseAdapter momentsBaseAdapter = this.g;
        if (momentsBaseAdapter != null) {
            List<Feed> listF = momentsBaseAdapter.f();
            if (i <= 0) {
                if (listF.size() <= 0 || listF.get(0).getFeedType() != 101) {
                    return;
                }
                this.g.d(0);
                return;
            }
            if (listF.size() <= 0 || listF.get(0).getFeedType() != 101) {
                Feed feed2 = new Feed();
                feed2.setFeedType(101);
                listF.add(0, feed2);
                feed = feed2;
                z = false;
            } else {
                feed = listF.get(0);
                z = true;
            }
            Feed.UnreadMsg unreadMsg = new Feed.UnreadMsg();
            unreadMsg.url = str;
            unreadMsg.count = i;
            feed.unreadMsg = unreadMsg;
            if (z) {
                this.g.notifyItemChanged(0);
                return;
            }
            this.g.notifyDataSetChanged();
            HashMap map = new HashMap();
            map.put("nums", Integer.valueOf(i));
            zn6.j("pagediscover_top_frindnews", "view", map);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void b(int i) {
        this.h = i;
        this.e.scrollToPosition(0);
        this.d.autoRefresh();
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public RecyclerView c() {
        return this.e;
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public View d(LayoutInflater layoutInflater) {
        this.c = layoutInflater.inflate(R$layout.layout_square_moments_fragment, (ViewGroup) null, false);
        q();
        return this.c;
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void h(boolean z, boolean z2) {
        this.d.finishLoadMore(z);
        this.d.setEnableLoadMore(z2);
        this.d.setNoMoreData(!z2);
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void i(boolean z) {
        this.d.finishRefresh(z);
        if (z) {
            this.d.setEnableLoadMore(true);
            this.d.setNoMoreData(false);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void k(MomentsBaseAdapter momentsBaseAdapter) {
        this.g = momentsBaseAdapter;
        this.e.setAdapter(momentsBaseAdapter);
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void l(boolean z) {
        if (!z) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.d.setEnableLoadMore(false);
        }
    }

    public void q() {
        this.d = (SmartRefreshLayout) this.c.findViewById(R$id.refresh_layout);
        this.e = (RecyclerView) this.c.findViewById(R$id.recycler_view_feeds);
        this.f = this.c.findViewById(R$id.no_moment_layout);
        this.e.setLayoutManager(new LinearLayoutManager(this.f13996a, 1, false));
        this.e.setItemAnimator(null);
        this.d.setEnableLoadMore(true);
        this.d.setOnRefreshListener(new a());
        this.d.setOnLoadMoreListener(new b());
        this.d.setRefreshFooter(new SquareLoadFooter(c.b()));
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void e() {
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void f() {
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void j() {
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void g(boolean z) {
    }

    @Override // com.zenmen.palmchat.friendcircle.a
    public void m(boolean z, String str, String str2, String[] strArr) {
    }
}

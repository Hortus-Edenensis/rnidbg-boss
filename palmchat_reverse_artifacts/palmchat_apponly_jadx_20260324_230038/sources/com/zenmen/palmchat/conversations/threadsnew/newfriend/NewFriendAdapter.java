package com.zenmen.palmchat.conversations.threadsnew.newfriend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewFriendAdapter extends BaseRecyclerViewAdapter<b> {
    public List<String> j;
    public int k;
    public b.k l;
    public HashMap<String, PhoneContactItem> m;
    public NewFriendFragment n;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ContactRequestsVO f13833a;

        public a(ContactRequestsVO contactRequestsVO) {
            this.f13833a = contactRequestsVO;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b implements BaseRecyclerViewAdapter.c {
    }

    public NewFriendAdapter(@NonNull Context context, NewFriendFragment newFriendFragment, @NonNull List<b> list, b.k kVar) {
        super(context, list);
        this.k = 0;
        this.j = new ArrayList();
        this.n = newFriendFragment;
        this.l = kVar;
        this.m = d.j().m();
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        NewFriendViewHolder2 newFriendViewHolder2 = i == 0 ? new NewFriendViewHolder2(this.e, this.n, this.m, viewGroup, R.layout.layout_list_item_friend_request_newfriend2, this.l) : null;
        if (newFriendViewHolder2 != null) {
            p(newFriendViewHolder2);
        }
        return newFriendViewHolder2;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull b bVar) {
        return bVar instanceof a ? 0 : 99;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void k(BaseRecyclerViewHolder<b> baseRecyclerViewHolder, b bVar, int i) {
        super.k(baseRecyclerViewHolder, bVar, i);
    }
}

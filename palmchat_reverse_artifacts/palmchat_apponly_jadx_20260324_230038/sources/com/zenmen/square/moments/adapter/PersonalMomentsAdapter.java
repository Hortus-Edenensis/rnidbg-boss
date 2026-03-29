package com.zenmen.square.moments.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.R$layout;
import com.zenmen.square.moments.PersonalMomentsFragment;
import com.zenmen.square.moments.holder.FooterViewHolder;
import com.zenmen.square.moments.holder.PersonalMomentsViewHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PersonalMomentsAdapter extends BaseRecyclerViewAdapter<Feed> {
    public final Context j;
    public FooterViewHolder k;
    public boolean l;
    public PersonalMomentsFragment.g m;

    public PersonalMomentsAdapter(@NonNull Context context, @NonNull List<Feed> list) {
        super(context, list);
        this.l = false;
        this.j = context;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        BaseRecyclerViewHolder personalMomentsViewHolder;
        if (i == 1) {
            personalMomentsViewHolder = new PersonalMomentsViewHolder(this.e, viewGroup, R$layout.personal_moments_only_text, i);
        } else if (i == 99) {
            FooterViewHolder footerViewHolder = new FooterViewHolder(this.e, viewGroup);
            this.k = footerViewHolder;
            personalMomentsViewHolder = footerViewHolder;
        } else if (i == 3) {
            personalMomentsViewHolder = new PersonalMomentsViewHolder(this.e, viewGroup, R$layout.personal_moments_video, i);
        } else if (i == 4) {
            personalMomentsViewHolder = new PersonalMomentsViewHolder(this.e, viewGroup, R$layout.personal_moments_web, i);
        } else if (i != 6) {
            if (i != 7) {
                personalMomentsViewHolder = new PersonalMomentsViewHolder(this.e, viewGroup, R$layout.personal_moments_multi_image, i);
            }
        }
        if (personalMomentsViewHolder instanceof PersonalMomentsViewHolder) {
            PersonalMomentsViewHolder personalMomentsViewHolder2 = (PersonalMomentsViewHolder) personalMomentsViewHolder;
            personalMomentsViewHolder2.E(this.m);
            personalMomentsViewHolder2.C(this.f);
            personalMomentsViewHolder2.B(this.l);
        }
        return personalMomentsViewHolder;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull Feed feed) {
        return feed.getFeedType();
    }

    public void s(PersonalMomentsFragment.g gVar) {
        this.m = gVar;
    }

    public void t(List<Feed> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        List<T> list2 = this.f;
        if (list2 != 0) {
            list2.clear();
            this.f.addAll(arrayList);
        } else {
            this.f = arrayList;
        }
        if (!z && list != null && list.size() > 0) {
            Feed feed = new Feed();
            feed.setFeedType(99);
            this.f.add(feed);
        }
        notifyDataSetChanged();
    }
}

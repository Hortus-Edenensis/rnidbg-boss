package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.bq6;
import defpackage.gr2;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupChatInitChosenListAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    public final Context e;
    public ArrayList<ContactInfoItem> f;
    public int g;

    /* JADX INFO: compiled from: SearchBox */
    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView d;
        public final View e;

        public SimpleViewHolder(View view) {
            super(view);
            this.d = (ImageView) view.findViewById(R.id.portrait);
            this.e = view.findViewById(R.id.cover);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int i) {
        ContactInfoItem contactInfoItem = this.f.get(i);
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getIconURL())) {
            simpleViewHolder.d.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(contactInfoItem.getIconURL(), simpleViewHolder.d, bq6.s());
        }
        if (i != this.f.size() - 1 || this.g <= 0) {
            simpleViewHolder.e.setVisibility(8);
        } else {
            simpleViewHolder.e.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SimpleViewHolder(LayoutInflater.from(this.e).inflate(R.layout.list_item_group_init_activity_chosen_list, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size();
    }
}

package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.giftkit.bean.VoiceRoomSelectMemberItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChatSelectMemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context e;
    public final List<VoiceRoomSelectMemberItem> f;
    public b g;

    /* JADX INFO: compiled from: SearchBox */
    public static class VoiceRoomSelectMemberHolder extends RecyclerView.ViewHolder {
        public EffectiveShapeView d;

        public VoiceRoomSelectMemberHolder(@NonNull View view) {
            super(view);
            this.d = (EffectiveShapeView) view.findViewById(R$id.iv_icon);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceRoomSelectMemberItem f14089a;

        public a(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem) {
            this.f14089a = voiceRoomSelectMemberItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatSelectMemberAdapter.this.g != null) {
                ChatSelectMemberAdapter.this.g.a(this.f14089a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem);
    }

    public ChatSelectMemberAdapter(Context context, List<VoiceRoomSelectMemberItem> list) {
        this.e = context;
        this.f = list;
    }

    public void b(b bVar) {
        this.g = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VoiceRoomSelectMemberItem> list = this.f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<VoiceRoomSelectMemberItem> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        VoiceRoomSelectMemberItem voiceRoomSelectMemberItem = this.f.get(i);
        if (viewHolder instanceof VoiceRoomSelectMemberHolder) {
            VoiceRoomSelectMemberHolder voiceRoomSelectMemberHolder = (VoiceRoomSelectMemberHolder) viewHolder;
            Glide.with(this.e).load2(voiceRoomSelectMemberItem.userAvatarUrl).error(R$drawable.default_portrait).into(voiceRoomSelectMemberHolder.d);
            voiceRoomSelectMemberHolder.itemView.setOnClickListener(new a(voiceRoomSelectMemberItem));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VoiceRoomSelectMemberHolder(LayoutInflater.from(this.e).inflate(R$layout.item_gift_group_chat_select_member, viewGroup, false));
    }
}

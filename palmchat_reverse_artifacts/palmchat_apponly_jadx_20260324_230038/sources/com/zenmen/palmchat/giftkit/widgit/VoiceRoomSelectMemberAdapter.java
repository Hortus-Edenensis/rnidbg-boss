package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.giftkit.bean.VoiceRoomSelectMemberItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.hc2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VoiceRoomSelectMemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context e;
    public final List<VoiceRoomSelectMemberItem> f;
    public b g;

    /* JADX INFO: compiled from: SearchBox */
    public static class VoiceRoomSelectMemberHolder extends RecyclerView.ViewHolder {
        public EffectiveShapeView d;
        public ImageView e;
        public TextView f;

        public VoiceRoomSelectMemberHolder(@NonNull View view) {
            super(view);
            this.d = (EffectiveShapeView) view.findViewById(R$id.iv_icon);
            this.e = (ImageView) view.findViewById(R$id.iv_select_ring);
            this.f = (TextView) view.findViewById(R$id.tv_name);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceRoomSelectMemberItem f14108a;

        public a(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem) {
            this.f14108a = voiceRoomSelectMemberItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoiceRoomSelectMemberAdapter.this.g != null) {
                VoiceRoomSelectMemberAdapter.this.g.a(this.f14108a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(VoiceRoomSelectMemberItem voiceRoomSelectMemberItem);
    }

    public VoiceRoomSelectMemberAdapter(Context context, List<VoiceRoomSelectMemberItem> list) {
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
            if (voiceRoomSelectMemberItem.isRoomMaster) {
                voiceRoomSelectMemberHolder.f.setText("房主");
            } else {
                voiceRoomSelectMemberHolder.f.setText(String.valueOf(voiceRoomSelectMemberItem.seatIndex));
            }
            if (voiceRoomSelectMemberItem.isSelected) {
                voiceRoomSelectMemberHolder.e.setVisibility(0);
            } else {
                voiceRoomSelectMemberHolder.e.setVisibility(8);
            }
            voiceRoomSelectMemberHolder.f.setSelected(voiceRoomSelectMemberItem.isSelected || voiceRoomSelectMemberItem.isRoomMaster);
            hc2.a(this.e).load(voiceRoomSelectMemberItem.userAvatarUrl).error(R$drawable.default_portrait).into(voiceRoomSelectMemberHolder.d);
            voiceRoomSelectMemberHolder.itemView.setOnClickListener(new a(voiceRoomSelectMemberItem));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VoiceRoomSelectMemberHolder(LayoutInflater.from(this.e).inflate(R$layout.item_voice_room_select_member, viewGroup, false));
    }
}

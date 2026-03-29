package com.zenmen.palmchat.circle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.circle.bean.CircleRedPacketShowInfo;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.ku4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleRedPacketAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List<CircleRedPacketShowInfo> e;
    public c f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public ImageView g;
        public TextView h;
        public TextView i;

        public a(View view) {
            super(view);
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) view.findViewById(R.id.image_head);
            this.d = effectiveShapeView;
            effectiveShapeView.changeShapeType(3);
            this.e = (TextView) view.findViewById(R.id.text_user);
            this.f = (TextView) view.findViewById(R.id.text_time);
            this.g = (ImageView) view.findViewById(R.id.image_red_packet);
            this.h = (TextView) view.findViewById(R.id.text_title);
            this.i = (TextView) view.findViewById(R.id.text_status);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(CircleRedPacketShowInfo circleRedPacketShowInfo, View view) {
            if (CircleRedPacketAdapter.this.f != null) {
                CircleRedPacketAdapter.this.f.R0(circleRedPacketShowInfo);
            }
        }

        public void m(final CircleRedPacketShowInfo circleRedPacketShowInfo) {
            MessageVo messageVo = circleRedPacketShowInfo.message;
            if (messageVo == null) {
                return;
            }
            gr2.j().h(circleRedPacketShowInfo.userAvatar, this.d, bq6.s());
            this.e.setText(circleRedPacketShowInfo.nickName + "发了一个券红包");
            this.f.setText(circleRedPacketShowInfo.timeDetail);
            int iA = ku4.a(messageVo);
            String str = iA == 0 ? "待领取" : iA == 2 ? "已领取" : iA == 3 ? "已过期" : iA == 1 ? "已抢光" : "";
            if (iA == 0) {
                this.g.setImageResource(R.drawable.circle_red_packet_close);
            } else {
                this.g.setImageResource(R.drawable.circle_red_packet_open);
            }
            this.h.setText(messageVo.text);
            this.i.setText(str);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: rb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20432a.n(circleRedPacketShowInfo, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseViewHolder {
        public TextView d;

        public b(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.text_title);
        }

        public void l(CircleRedPacketShowInfo circleRedPacketShowInfo) {
            this.d.setText(circleRedPacketShowInfo.timeTitle);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void R0(CircleRedPacketShowInfo circleRedPacketShowInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (baseViewHolder instanceof b) {
            ((b) baseViewHolder).l(this.e.get(i));
        } else if (baseViewHolder instanceof a) {
            ((a) baseViewHolder).m(this.e.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.circle_red_packet_history_title, viewGroup, false)) : new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.circle_item_red_packet_history, viewGroup, false));
    }

    public void f(c cVar) {
        this.f = cVar;
    }

    public void g(List<CircleRedPacketShowInfo> list) {
        this.e = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<CircleRedPacketShowInfo> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.e.get(i).infoType;
    }
}

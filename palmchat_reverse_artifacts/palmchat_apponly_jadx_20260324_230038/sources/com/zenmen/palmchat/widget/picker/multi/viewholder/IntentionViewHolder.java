package com.zenmen.palmchat.widget.picker.multi.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.widget.picker.multi.IntentionPicker;
import com.zenmen.palmchat.widget.picker.multi.adapter.IntentionAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class IntentionViewHolder extends RecyclerView.ViewHolder {
    public View d;
    public TextView e;
    public ImageView f;
    public IntentionAdapter.b g;
    public IntentionPicker.a h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (IntentionViewHolder.this.h == null || IntentionViewHolder.this.g == null) {
                return;
            }
            IntentionViewHolder.this.g.a(IntentionViewHolder.this.h, IntentionViewHolder.this.itemView);
        }
    }

    public IntentionViewHolder(View view) {
        super(view);
        this.d = n(this.d, R$id.bg);
        this.f = (ImageView) n(this.f, R$id.icon);
        this.e = (TextView) n(this.e, R$id.title);
        this.itemView.setOnClickListener(new a());
    }

    public final View n(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    public void o(IntentionPicker.a aVar) {
        this.h = aVar;
        if (aVar == null) {
            return;
        }
        this.e.setText(aVar.a().getName());
        this.f.setVisibility(aVar.b() ? 0 : 8);
        TextView textView = this.e;
        textView.setTextColor(textView.getContext().getResources().getColor(aVar.b() ? R$color.Aa : R$color.Gb));
        this.d.setBackgroundResource(aVar.b() ? R$drawable.shape_1914cd64_round_corner_12dp : R$drawable.shape_f5f5f5_round_corner_12dp);
    }

    public void p(IntentionAdapter.b bVar) {
        this.g = bVar;
    }
}

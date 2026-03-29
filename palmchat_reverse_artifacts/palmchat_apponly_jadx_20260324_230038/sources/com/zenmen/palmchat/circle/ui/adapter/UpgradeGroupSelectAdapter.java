package com.zenmen.palmchat.circle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UpgradeGroupSelectAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public Context e;
    public LayoutInflater f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public TextView d;
        public EffectiveShapeView e;

        public a(View view) {
            super(view);
            this.e = (EffectiveShapeView) view.findViewById(R.id.circleAvatarImg);
            this.d = (TextView) view.findViewById(R.id.circleNameTv);
            this.e.changeShapeType(3);
        }
    }

    public UpgradeGroupSelectAdapter(Context context) {
        this.e = context;
        this.f = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new a(this.f.inflate(R.layout.adapter_circle_upgrade_group_item, viewGroup, false)) : new BaseViewHolder(this.f.inflate(R.layout.adapter_circle_select_title, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
    }
}

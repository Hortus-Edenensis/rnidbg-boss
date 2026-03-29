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
public class MyCircleListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public Context e;
    public LayoutInflater f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public TextView d;

        public a(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.expandTv);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseViewHolder {
        public TextView d;
        public EffectiveShapeView e;

        public b(View view) {
            super(view);
            this.e = (EffectiveShapeView) view.findViewById(R.id.circleAvatarImg);
            this.d = (TextView) view.findViewById(R.id.circleNameTv);
            this.e.changeShapeType(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BaseViewHolder {
        public TextView d;

        public c(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.titleTv);
        }
    }

    public MyCircleListAdapter(Context context) {
        this.e = context;
        this.f = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new c(this.f.inflate(R.layout.adapter_my_circle_list_title, viewGroup, false));
        }
        if (i == 1) {
            return new b(this.f.inflate(R.layout.adapter_my_circle_list_item, viewGroup, false));
        }
        if (i != 2) {
            return null;
        }
        return new a(this.f.inflate(R.layout.adapter_my_circle_list_expand, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0 || i == 5) {
            return 0;
        }
        return (i == 4 || i == 9) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
    }
}

package com.zenmen.square.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.adapter.SelectWishAdapter;
import com.zenmen.square.topic.bean.TopicListBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TopicSelectWishView extends FrameLayout {
    private b mCallback;
    private RecyclerView tagRecycler;
    private SelectWishAdapter wishAdapter;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SelectWishAdapter.a {
        public a() {
        }

        @Override // com.zenmen.square.topic.adapter.SelectWishAdapter.a
        public void a(TopicListBean.Ae ae, View view) {
            if (ae == null || TopicSelectWishView.this.mCallback == null) {
                return;
            }
            TopicSelectWishView.this.mCallback.a(ae);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(TopicListBean.Ae ae);
    }

    public TopicSelectWishView(Context context) {
        super(context);
        init(null, 0);
    }

    public void bind(List<TopicListBean.Ae> list, b bVar) {
        this.mCallback = bVar;
        LayoutInflater.from(getContext()).inflate(R$layout.square_layout_wish_select, this);
        this.tagRecycler = (RecyclerView) findViewById(R$id.tag_recycler);
        this.tagRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        SelectWishAdapter selectWishAdapter = new SelectWishAdapter(getContext(), list);
        this.wishAdapter = selectWishAdapter;
        this.tagRecycler.setAdapter(selectWishAdapter);
        this.wishAdapter.c(new a());
    }

    public TopicSelectWishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public TopicSelectWishView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
    }
}

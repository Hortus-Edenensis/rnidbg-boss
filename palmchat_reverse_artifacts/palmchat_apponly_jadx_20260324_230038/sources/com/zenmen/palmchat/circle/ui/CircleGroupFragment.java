package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.ui.adapter.BaseViewHolder;
import com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gc0;
import defpackage.gr2;
import defpackage.ty5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleGroupFragment extends CircleLoadFragment {
    public RecyclerView m;
    public int n;
    public List<CircleRecommendItem> o;
    public TextView p;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<List<CircleRecommendItem>>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleRecommendItem>> baseResponse) {
            if (CircleGroupFragment.this.getActivity() == null || CircleGroupFragment.this.getActivity().isFinishing()) {
                CircleGroupFragment.this.Z(false);
                return;
            }
            CircleGroupFragment.this.G();
            if (baseResponse.getResultCode() == 0) {
                CircleGroupFragment.this.o = baseResponse.getData();
                CircleGroupFragment.this.m0();
            } else {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    ty5.d(AppContext.getContext(), R.string.send_failed, 0).show();
                } else {
                    ty5.e(AppContext.getContext(), baseResponse.getErrorMsg(), 0).show();
                }
                CircleGroupFragment.this.Z(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.Adapter<BaseViewHolder> {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            ((c) baseViewHolder).m((CircleRecommendItem) CircleGroupFragment.this.o.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            CircleGroupFragment circleGroupFragment = CircleGroupFragment.this;
            return circleGroupFragment.new c(LayoutInflater.from(circleGroupFragment.getActivity()).inflate(R.layout.item_circle_recommend_common1, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CircleGroupFragment.this.o.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BaseViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public List<TextView> m;

        public c(View view) {
            super(view);
            this.m = new ArrayList();
            this.d = (EffectiveShapeView) view.findViewById(R.id.img_group_head);
            this.e = (TextView) view.findViewById(R.id.text_group_title);
            this.f = (TextView) view.findViewById(R.id.text_group_title_tag);
            this.g = (TextView) view.findViewById(R.id.text_member_count);
            this.h = (TextView) view.findViewById(R.id.text_tags1);
            this.i = (TextView) view.findViewById(R.id.text_tags2);
            this.j = (TextView) view.findViewById(R.id.text_tags3);
            this.k = (TextView) view.findViewById(R.id.text_group_introduce);
            this.l = (TextView) view.findViewById(R.id.text_join);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.m.add(this.h);
            this.m.add(this.i);
            this.m.add(this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(CircleRecommendItem circleRecommendItem, View view) {
            gc0.a(CircleGroupFragment.this.getActivity(), circleRecommendItem, 1);
        }

        public void m(final CircleRecommendItem circleRecommendItem) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: q90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20203a.n(circleRecommendItem, view);
                }
            });
            this.l.setVisibility(8);
            gr2.j().h(circleRecommendItem.headImgUrl, this.d, bq6.s());
            this.e.setText(circleRecommendItem.name);
            this.g.setText(String.valueOf(circleRecommendItem.memberNum));
            if (TextUtils.isEmpty(circleRecommendItem.cateName)) {
                this.f.setVisibility(8);
            } else {
                this.f.setText(circleRecommendItem.cateName);
            }
            if (TextUtils.isEmpty(circleRecommendItem.describe)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(circleRecommendItem.describe);
            }
            List<RoomTag> list = circleRecommendItem.tagList;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (int i = 0; i < list.size() && i < this.m.size(); i++) {
                if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).tagName)) {
                    this.m.get(i).setVisibility(0);
                    this.m.get(i).setText(list.get(i).tagName);
                }
            }
        }
    }

    public static CircleGroupFragment l0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        CircleGroupFragment circleGroupFragment = new CircleGroupFragment();
        circleGroupFragment.setArguments(bundle);
        return circleGroupFragment;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_circle_my_group, viewGroup, false);
        this.m = (RecyclerView) viewInflate.findViewById(R.id.recycler);
        this.p = (TextView) viewInflate.findViewById(R.id.text_empty);
        return viewInflate;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        LogUtil.d("CircleGroupFragment", "my group load data");
        k0();
    }

    public final void k0() {
        if (getActivity() == null || getActivity().isFinishing()) {
            Z(false);
        } else {
            L();
            c70.R().D(this.n, new a());
        }
    }

    public final void m0() {
        List<CircleRecommendItem> list = this.o;
        if (list == null || list.isEmpty()) {
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
        this.m.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.m.setAdapter(new b());
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.n = getArguments().getInt("type", -1);
    }
}

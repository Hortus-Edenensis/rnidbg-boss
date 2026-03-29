package com.zenmen.palmchat.circle.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.hc2;
import defpackage.me1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleToolAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public d e;
    public List<DatingGroupToolBeans.DatingGroupToolBean> f = new ArrayList();
    public List<DatingGroupToolBeans.DatingGroupToolBean> g = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public RelativeLayout d;
        public TextView e;
        public EffectiveShapeView f;
        public TextView g;
        public TextView h;
        public ImageView i;
        public View j;

        public a(View view) {
            super(view);
            this.d = (RelativeLayout) view.findViewById(R.id.layout_action);
            this.e = (TextView) view.findViewById(R.id.layout_action_text);
            this.f = (EffectiveShapeView) view.findViewById(R.id.image_head);
            this.g = (TextView) view.findViewById(R.id.text_tool_name);
            this.h = (TextView) view.findViewById(R.id.text_tool_subtitle);
            this.i = (ImageView) view.findViewById(R.id.image_tool_arrow);
            this.j = view.findViewById(R.id.text_tool_status);
            view.setOnClickListener(new View.OnClickListener() { // from class: jc0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f18378a.p(view2);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: kc0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return this.f18617a.q(view2);
                }
            });
            this.d.setOnClickListener(new View.OnClickListener() { // from class: lc0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f18955a.r(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(View view) {
            if (this.i.getVisibility() != 0 || CircleToolAdapter.this.e == null) {
                return;
            }
            CircleToolAdapter.this.e.s(CircleToolAdapter.this.e(getAdapterPosition()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean q(View view) {
            DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBeanE = CircleToolAdapter.this.e(getAdapterPosition());
            if (datingGroupToolBeanE == null || datingGroupToolBeanE.getIsUsed() != 0 || datingGroupToolBeanE.getIsSystem() != 0) {
                return true;
            }
            if (CircleToolAdapter.this.e == null) {
                return false;
            }
            CircleToolAdapter.this.e.k1(datingGroupToolBeanE);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(View view) {
            if (this.e.getText().equals("+")) {
                if (CircleToolAdapter.this.e != null) {
                    CircleToolAdapter.this.e.A0(CircleToolAdapter.this.e(getAdapterPosition()));
                }
            } else if (CircleToolAdapter.this.e != null) {
                CircleToolAdapter.this.e.a1(CircleToolAdapter.this.e(getAdapterPosition()));
            }
        }

        public void o(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
            if (datingGroupToolBean == null) {
                return;
            }
            if (datingGroupToolBean.getIsUsed() == 1) {
                this.e.setText("-");
                this.i.setVisibility(8);
            } else {
                this.e.setText("+");
                if (datingGroupToolBean.getIsSystem() == 1) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                }
            }
            if (datingGroupToolBean.getState() == 1) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            if (datingGroupToolBean.getIsSystem() == 1) {
                layoutParams.width = me1.b(this.f.getContext(), 42);
                layoutParams.height = me1.b(this.f.getContext(), 42);
            } else {
                layoutParams.width = me1.b(this.f.getContext(), 34);
                layoutParams.height = me1.b(this.f.getContext(), 34);
            }
            hc2.a(this.f.getContext()).load(datingGroupToolBean.getIcon()).error(R.drawable.icon_circle_tools_default).into(this.f);
            this.g.setText(datingGroupToolBean.getToolName());
            if (TextUtils.isEmpty(datingGroupToolBean.getDescription())) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                this.h.setText(datingGroupToolBean.getDescription());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseViewHolder {
        public b(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: mc0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f19192a.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            if (CircleToolAdapter.this.e != null) {
                CircleToolAdapter.this.e.c1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BaseViewHolder {
        public TextView d;
        public TextView e;

        public c(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.text_title);
            this.e = (TextView) view.findViewById(R.id.text_subtitle);
        }

        public void l(String str) {
            this.d.setText(str);
            if (getAdapterPosition() == 0 && (CircleToolAdapter.this.f == null || CircleToolAdapter.this.f.isEmpty())) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void A0(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean);

        void a1(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean);

        void c1();

        void k1(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean);

        void s(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean);
    }

    public CircleToolAdapter(d dVar) {
        this.e = dVar;
    }

    public void c(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        if (datingGroupToolBean == null) {
            return;
        }
        if (!this.g.contains(datingGroupToolBean)) {
            this.g.add(datingGroupToolBean);
            notifyDataSetChanged();
            return;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (this.g.get(i).equals(datingGroupToolBean)) {
                this.g.remove(i);
                this.g.add(i, datingGroupToolBean);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void d(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        boolean z;
        if (datingGroupToolBean == null) {
            return;
        }
        boolean z2 = true;
        if (this.f.contains(datingGroupToolBean)) {
            z = false;
        } else {
            this.f.add(datingGroupToolBean);
            datingGroupToolBean.setIsUsed(1);
            z = true;
        }
        if (this.g.contains(datingGroupToolBean)) {
            this.g.remove(datingGroupToolBean);
            datingGroupToolBean.setIsUsed(1);
        } else {
            z2 = z;
        }
        if (z2) {
            notifyDataSetChanged();
        }
    }

    public DatingGroupToolBeans.DatingGroupToolBean e(int i) {
        if (i == 0) {
            return null;
        }
        int i2 = i - 1;
        if (this.f.size() > i2) {
            return this.f.get(i2);
        }
        if (this.g.size() > (i - this.f.size()) - 2) {
            return this.g.get((i - this.f.size()) - 2);
        }
        return null;
    }

    public List<DatingGroupToolBeans.DatingGroupToolBean> f() {
        return this.f;
    }

    public void g(int i, int i2) {
        int i3 = i - 1;
        int i4 = i2 - 1;
        if (Math.min(i3, i4) < 0) {
            return;
        }
        if (this.f.size() > Math.max(i3, i4)) {
            Collections.swap(this.f, i3, i4);
        }
        notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size() + this.g.size() + 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0 || i == this.f.size() + 1) {
            return 0;
        }
        if (i == getItemCount() - 1) {
            return 3;
        }
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBeanE = e(i);
        return (datingGroupToolBeanE == null || datingGroupToolBeanE.getIsUsed() != 1) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (baseViewHolder instanceof c) {
            if (i == 0) {
                ((c) baseViewHolder).l("管理入口（长按可拖动进行排序)");
                return;
            } else {
                ((c) baseViewHolder).l("未添加工具");
                return;
            }
        }
        if (baseViewHolder instanceof a) {
            ((a) baseViewHolder).o(e(i));
        } else {
            boolean z = baseViewHolder instanceof b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_title, viewGroup, false)) : i == 3 ? new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_foot, viewGroup, false)) : new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tool_content, viewGroup, false));
    }

    public void j(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        this.g.remove(datingGroupToolBean);
        notifyDataSetChanged();
    }

    public void k(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        boolean z;
        if (datingGroupToolBean == null) {
            return;
        }
        boolean z2 = true;
        if (this.f.contains(datingGroupToolBean)) {
            this.f.remove(datingGroupToolBean);
            datingGroupToolBean.setIsUsed(0);
            z = true;
        } else {
            z = false;
        }
        if (this.g.contains(datingGroupToolBean)) {
            z2 = z;
        } else {
            this.g.add(datingGroupToolBean);
            datingGroupToolBean.setIsUsed(0);
        }
        if (z2) {
            notifyDataSetChanged();
        }
    }

    public void l(List<DatingGroupToolBeans.DatingGroupToolBean> list, List<DatingGroupToolBeans.DatingGroupToolBean> list2) {
        this.f.clear();
        if (list != null && !list.isEmpty()) {
            this.f.addAll(list);
        }
        this.g.clear();
        if (list2 != null && !list2.isEmpty()) {
            this.g.addAll(list2);
        }
        notifyDataSetChanged();
    }
}

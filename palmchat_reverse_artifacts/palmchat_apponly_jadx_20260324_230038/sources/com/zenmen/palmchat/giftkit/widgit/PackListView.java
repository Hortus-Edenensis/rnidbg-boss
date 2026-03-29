package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.giftkit.R$string;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.giftkit.bean.PackPanelItem;
import com.zenmen.palmchat.giftkit.event.SetGiftTabEvent;
import com.zenmen.palmchat.giftkit.widgit.BasePanelListView;
import com.zenmen.palmchat.giftkit.widgit.NoRepetViewFlow;
import com.zenmen.palmchat.giftkit.widgit.PackListView;
import com.zenmen.palmchat.utils.SDecoration;
import defpackage.b05;
import defpackage.ds0;
import defpackage.eh;
import defpackage.hc2;
import defpackage.k86;
import defpackage.ub2;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PackListView extends BasePanelListView<PackPanelItem> {
    private static HashMap<String, Boolean> sSlideReportedMap = new HashMap<>();
    private boolean isNewStyle;
    private ub2 mEventDataHelper;
    private d mPackSelectedListener;
    private RecyclerView mRecyclerView;
    private ScrollPackAdapter mScrollAdapter;

    /* JADX INFO: compiled from: SearchBox */
    public class ScrollPackAdapter extends RecyclerView.Adapter<ScrollViewHolder> {

        /* JADX INFO: compiled from: SearchBox */
        public class ScrollViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public RedDeleteLineText d;
            public TextView e;
            public TextView f;
            public ImageView g;
            public RelativeLayout h;
            public CircleProgressView i;
            public ImageView j;
            public TextView k;
            public TextView l;
            public TextView m;
            public PackPanelItem n;

            public ScrollViewHolder(@NonNull View view) {
                super(view);
                this.f = (TextView) view.findViewById(R$id.tv_name);
                this.d = (RedDeleteLineText) view.findViewById(R$id.tv_money);
                this.e = (TextView) view.findViewById(R$id.tv_discount);
                this.g = (ImageView) view.findViewById(R$id.tv_icon);
                this.h = (RelativeLayout) view.findViewById(R$id.rl_continue);
                this.i = (CircleProgressView) view.findViewById(R$id.pg_continue);
                this.j = (ImageView) view.findViewById(R$id.iv_check);
                this.k = (TextView) view.findViewById(R$id.tv_hit_number);
                this.l = (TextView) view.findViewById(R$id.tv_tag);
                this.m = (TextView) view.findViewById(R$id.tv_num);
                view.setOnClickListener(this);
            }

            public void l(PackPanelItem packPanelItem) {
                this.n = packPanelItem;
                PackListView packListView = PackListView.this;
                T t = packListView.mSelectedPanelItem;
                if (t == 0 || ((PackPanelItem) t).itemId != packPanelItem.itemId) {
                    this.j.setVisibility(8);
                } else {
                    packListView.mSelectedView = this.itemView;
                    this.j.setVisibility(0);
                }
                this.m.setVisibility(0);
                this.m.setText("x" + packPanelItem.itemCount);
                this.l.setVisibility(8);
                this.i.setVisibility(8);
                this.e.setVisibility(8);
                this.d.setText(packPanelItem.deadline);
                this.f.setText(packPanelItem.itemName);
                hc2.a(PackListView.this.getContext()).load(k86.p(packPanelItem.iconUrl)).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(this.g);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PackPanelItem packPanelItem = this.n;
                if (packPanelItem != null) {
                    PackListView packListView = PackListView.this;
                    T t = packListView.mSelectedPanelItem;
                    if (t == 0 || packPanelItem.itemId != ((PackPanelItem) t).itemId) {
                        int iIndexOf = packListView.mData.indexOf(t);
                        int adapterPosition = getAdapterPosition();
                        PackListView packListView2 = PackListView.this;
                        packListView2.mSelectedView = this.itemView;
                        packListView2.mSelectedPanelItem = this.n;
                        packListView2.mPackSelectedListener.a((PackPanelItem) PackListView.this.mSelectedPanelItem);
                        if (iIndexOf >= 0 && iIndexOf != adapterPosition) {
                            ScrollPackAdapter.this.notifyItemChanged(iIndexOf);
                        }
                        if (adapterPosition >= 0) {
                            ScrollPackAdapter.this.notifyItemChanged(adapterPosition);
                        }
                        PackListView.this.startSelectedAnim(this.g);
                    }
                }
            }
        }

        public ScrollPackAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull ScrollViewHolder scrollViewHolder, int i) {
            List<T> list = PackListView.this.mData;
            if (list == 0 || i >= list.size()) {
                return;
            }
            scrollViewHolder.l((PackPanelItem) PackListView.this.mData.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScrollViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ScrollViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.layout_gift_item_light_new, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<T> list = PackListView.this.mData;
            if (list == 0) {
                return 0;
            }
            return list.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14106a = false;

        public b() {
        }

        public static /* synthetic */ Object b() {
            return "背包滑动打点";
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f14106a && PackListView.this.mEventDataHelper != null) {
                b05.c(new b05.a() { // from class: cb4
                    @Override // b05.a
                    public final Object getValue() {
                        return PackListView.b.b();
                    }
                });
                PackListView.this.mEventDataHelper.f(1);
                this.f14106a = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 != 0) {
                this.f14106a = true;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements NoRepetViewFlow.e {
        public c() {
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.NoRepetViewFlow.e
        public void a(View view, int i) {
            PackListView packListView = PackListView.this;
            if (packListView.mLastPosition == i) {
                return;
            }
            packListView.mLastPosition = i;
            if (packListView.mPackSelectedListener != null) {
                PackListView.this.mPackSelectedListener.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(PackPanelItem packPanelItem);

        void b(boolean z);

        void onPageSelected(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends BasePanelListView<PackPanelItem>.a {
        public e() {
            super();
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.BasePanelListView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(int i, View view, BasePanelListView<PackPanelItem>.a.C1057a c1057a, PackPanelItem packPanelItem) {
            view.setOnClickListener(this);
            PackListView packListView = PackListView.this;
            if (packListView.mSelectedPanelItem == packPanelItem) {
                packListView.mSelectedView = view;
                c1057a.g.setVisibility(0);
            } else {
                c1057a.g.setVisibility(8);
            }
            c1057a.k.setVisibility(0);
            c1057a.k.setText("x" + packPanelItem.itemCount);
            c1057a.j.setVisibility(8);
            c1057a.f.setVisibility(8);
            c1057a.b.setVisibility(8);
            c1057a.f14088a.setText(packPanelItem.deadline);
            c1057a.c.setText(packPanelItem.itemName);
            c1057a.l = packPanelItem;
            hc2.a(PackListView.this.getContext()).load(k86.p(packPanelItem.iconUrl)).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(c1057a.d);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PackListView packListView = PackListView.this;
            if (packListView.mSelectedView != view) {
                packListView.mSelectedView = view;
                BasePanelListView.a.C1057a c1057a = (BasePanelListView.a.C1057a) view.getTag();
                if (c1057a != null) {
                    PackListView packListView2 = PackListView.this;
                    packListView2.mSelectedPanelItem = c1057a.l;
                    packListView2.mPackSelectedListener.a((PackPanelItem) PackListView.this.mSelectedPanelItem);
                    c1057a.g.setVisibility(0);
                    PackListView.this.startSelectedAnim(c1057a.d);
                    notifyDataSetChanged();
                }
            }
        }
    }

    public PackListView(Context context, int i, int i2, PackPanelItem packPanelItem, d dVar) {
        super(context, i, i2, packPanelItem);
        boolean z = false;
        this.isNewStyle = false;
        this.mPackSelectedListener = dVar;
        if (com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel) {
            z = true;
        }
        this.isNewStyle = z;
        createView(context);
    }

    private void initData() {
        List<PackPanelItem> listK = com.zenmen.palmchat.giftkit.b.j().k(this.panelId);
        this.mData = listK;
        if (listK == null || listK.isEmpty()) {
            this.mSelectedPanelItem = null;
        } else {
            if (this.isNewStyle && this.mData.size() > 0) {
                this.mSelectedPanelItem = (T) this.mData.get(0);
            }
            if (this.mSelectedPanelItem != 0) {
                int i = 0;
                while (true) {
                    if (i >= this.mData.size()) {
                        break;
                    }
                    PackPanelItem packPanelItem = (PackPanelItem) this.mData.get(i);
                    if (((PackPanelItem) this.mSelectedPanelItem).itemId == packPanelItem.itemId) {
                        this.mSelectedPanelItem = packPanelItem;
                        break;
                    } else {
                        if (i == this.mData.size() - 1) {
                            this.mSelectedPanelItem = (T) this.mData.get(0);
                        }
                        i++;
                    }
                }
            } else {
                this.mSelectedPanelItem = (T) this.mData.get(0);
            }
        }
        d dVar = this.mPackSelectedListener;
        if (dVar != null) {
            dVar.a((PackPanelItem) this.mSelectedPanelItem);
            d dVar2 = this.mPackSelectedListener;
            List<T> list = this.mData;
            dVar2.b((list == 0 || list.isEmpty()) ? false : true);
        }
    }

    private void initScrollUI() {
        initData();
        updateEmptyView();
        this.mRecyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.mRecyclerView.addItemDecoration(new SDecoration(getContext(), 8, 8));
        ScrollPackAdapter scrollPackAdapter = new ScrollPackAdapter();
        this.mScrollAdapter = scrollPackAdapter;
        this.mRecyclerView.setAdapter(scrollPackAdapter);
        this.mRecyclerView.addOnItemTouchListener(new a());
        this.mRecyclerView.addOnScrollListener(new b());
    }

    private void initUI() {
        initData();
        NoRepetViewFlow noRepetViewFlow = (NoRepetViewFlow) findViewById(R$id.viewFlow);
        noRepetViewFlow.setNoWindowDestroy();
        noRepetViewFlow.setFlowIndicator((NoRepetCircleFlowIndicator) findViewById(R$id.gift_indic));
        noRepetViewFlow.setOnViewSwitchListener(new c());
        e eVar = new e();
        this.adapter = eVar;
        noRepetViewFlow.setAdapter(eVar);
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateEmptyView$0(View view) {
        ds0.a().b(new SetGiftTabEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEmptyView$1(View view) {
        if (eh.d(view.getId(), 3000L)) {
            return;
        }
        com.zenmen.palmchat.giftkit.b.j().s(this.panelId);
    }

    private void updateEmptyView() {
        updateEmptyView(false);
    }

    @Override // com.zenmen.palmchat.giftkit.widgit.BasePanelListView
    public void createView(Context context) {
        super.createView(context);
        if (this.isNewStyle) {
            View.inflate(context, R$layout.layout_gift_list_scroll, this);
            initScrollUI();
        } else {
            View.inflate(context, R$layout.layout_gift_list, this);
            initUI();
        }
    }

    public void onGiftSend(PackPanelItem packPanelItem, int i) {
        ScrollPackAdapter scrollPackAdapter;
        if (this.mData.contains(packPanelItem)) {
            long j = packPanelItem.itemCount - ((long) i);
            packPanelItem.itemCount = j;
            if (j <= 0) {
                this.mData.remove(packPanelItem);
                initData();
                updateEmptyView(false);
            }
            if (this.isNewStyle && (scrollPackAdapter = this.mScrollAdapter) != null) {
                scrollPackAdapter.notifyDataSetChanged();
                return;
            }
            BasePanelListView<T>.a aVar = this.adapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void setEventDataHelper(ub2 ub2Var) {
        this.mEventDataHelper = ub2Var;
    }

    @Override // com.zenmen.palmchat.giftkit.widgit.BasePanelListView
    public void update(boolean z) {
        ScrollPackAdapter scrollPackAdapter;
        initData();
        if (!this.isNewStyle || (scrollPackAdapter = this.mScrollAdapter) == null) {
            BasePanelListView<T>.a aVar = this.adapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        } else {
            scrollPackAdapter.notifyDataSetChanged();
        }
        updateEmptyView(z);
    }

    private void updateEmptyView(boolean z) {
        List<T> list = this.mData;
        if (list != 0 && !list.isEmpty()) {
            findViewById(R$id.ll_empty).setVisibility(8);
            this.mShowError = false;
            return;
        }
        findViewById(R$id.ll_empty).setVisibility(0);
        ImageView imageView = (ImageView) findViewById(R$id.iv_empty);
        TextView textView = (TextView) findViewById(R$id.tv_empty_tip);
        TextView textView2 = (TextView) findViewById(R$id.tv_empty_action);
        if (z) {
            imageView.setImageResource(R$drawable.ic_gift_panel_net_error);
            textView.setText(R$string.gift_panel_net_error);
            textView2.setText(R$string.gift_panel_net_error_action);
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: bb4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1681a.lambda$updateEmptyView$1(view);
                }
            });
            this.mShowError = true;
            return;
        }
        imageView.setImageResource(R$drawable.ic_gift_panel_empty);
        textView.setText(R$string.gift_panel_pack_empty);
        textView2.setText(R$string.gift_panel_pack_empty_action);
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.ic_gift_pack_empty_arrow, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ab4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PackListView.lambda$updateEmptyView$0(view);
            }
        });
        this.mShowError = false;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RecyclerView.OnItemTouchListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!recyclerView.canScrollVertically(1) && !recyclerView.canScrollVertically(-1)) {
                return false;
            }
            recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }
}

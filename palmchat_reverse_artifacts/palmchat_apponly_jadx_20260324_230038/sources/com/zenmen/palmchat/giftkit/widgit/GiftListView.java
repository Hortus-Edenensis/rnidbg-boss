package com.zenmen.palmchat.giftkit.widgit;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.giftkit.R$anim;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.giftkit.R$string;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.giftkit.bean.GiftPanelItem;
import com.zenmen.palmchat.giftkit.widgit.BasePanelListView;
import com.zenmen.palmchat.giftkit.widgit.CircleProgressView;
import com.zenmen.palmchat.giftkit.widgit.GiftListView;
import com.zenmen.palmchat.giftkit.widgit.NoRepetViewFlow;
import com.zenmen.palmchat.utils.SDecoration;
import defpackage.b05;
import defpackage.eh;
import defpackage.hc2;
import defpackage.k86;
import defpackage.ub2;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftListView extends BasePanelListView<GiftPanelItem> {
    private static HashMap<String, Boolean> sSlideReportedMap = new HashMap<>();
    private boolean isNewStyle;
    private long mActivityId;
    private ub2 mEventDataHelper;
    private e mGiftSelectedListener;
    private Animation mHitAnim;
    private int mHitNumber;
    private int mInitPosition;
    private RecyclerView mRecyclerView;
    private ScrollGiftAdapter mScrollAdapter;

    /* JADX INFO: compiled from: SearchBox */
    public class ScrollGiftAdapter extends RecyclerView.Adapter<ScrollViewHolder> {

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
            public GiftPanelItem n;

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

            public void l(GiftPanelItem giftPanelItem) {
                this.n = giftPanelItem;
                GiftListView giftListView = GiftListView.this;
                T t = giftListView.mSelectedPanelItem;
                if (t == 0 || ((GiftPanelItem) t).itemId != giftPanelItem.itemId) {
                    this.j.setVisibility(8);
                    this.h.setVisibility(8);
                    this.k.setVisibility(8);
                    this.i.cancelAnimProgress();
                } else {
                    giftListView.mSelectedView = this.itemView;
                    this.j.setVisibility(0);
                }
                this.m.setVisibility(8);
                if (TextUtils.isEmpty(giftPanelItem.itemLabelText)) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    this.l.setText(giftPanelItem.itemLabelText);
                    TextView textView = this.l;
                    int i = giftPanelItem.itemLabelStyleCode;
                    textView.setBackgroundResource(i == 1 ? R$drawable.shape_gift_tag_bg_style1_new : i == 2 ? R$drawable.shape_gift_tag_bg_style2_new : R$drawable.shape_gift_tag_bg_style3_new);
                }
                this.e.setVisibility(8);
                if (giftPanelItem.realPrice > 0) {
                    this.d.setText(giftPanelItem.realPrice + "连信豆");
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                this.f.setText(giftPanelItem.itemName);
                Context context = GiftListView.this.getContext();
                if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                    return;
                }
                hc2.a(context).load(k86.p(giftPanelItem.iconUrl)).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(this.g);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftPanelItem giftPanelItem = this.n;
                if (giftPanelItem != null) {
                    if (!TextUtils.isEmpty(giftPanelItem.activityUrl)) {
                        GiftListView.this.mGiftSelectedListener.b(this.n);
                        return;
                    }
                    GiftListView giftListView = GiftListView.this;
                    T t = giftListView.mSelectedPanelItem;
                    if (t == 0 || this.n.itemId != ((GiftPanelItem) t).itemId) {
                        int iIndexOf = giftListView.mData.indexOf(t);
                        int adapterPosition = getAdapterPosition();
                        GiftListView giftListView2 = GiftListView.this;
                        giftListView2.mSelectedView = this.itemView;
                        giftListView2.mSelectedPanelItem = this.n;
                        giftListView2.mGiftSelectedListener.c((GiftPanelItem) GiftListView.this.mSelectedPanelItem);
                        if (iIndexOf >= 0 && iIndexOf != adapterPosition) {
                            ScrollGiftAdapter.this.notifyItemChanged(iIndexOf);
                        }
                        if (adapterPosition >= 0) {
                            ScrollGiftAdapter.this.notifyItemChanged(adapterPosition);
                        }
                        GiftListView.this.startSelectedAnim(this.g);
                    }
                }
            }
        }

        public ScrollGiftAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull ScrollViewHolder scrollViewHolder, int i) {
            List<T> list = GiftListView.this.mData;
            if (list == 0 || i >= list.size()) {
                return;
            }
            scrollViewHolder.l((GiftPanelItem) GiftListView.this.mData.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScrollViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ScrollViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.layout_gift_item_light_new, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<T> list = GiftListView.this.mData;
            if (list == 0) {
                return 0;
            }
            return list.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14096a = false;

        public b() {
        }

        public static /* synthetic */ Object b() {
            return "礼物滑动打点";
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f14096a && GiftListView.this.mEventDataHelper != null) {
                GiftListView.this.mEventDataHelper.f(0);
                b05.c(new b05.a() { // from class: da2
                    @Override // b05.a
                    public final Object getValue() {
                        return GiftListView.b.b();
                    }
                });
                this.f14096a = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 != 0) {
                this.f14096a = true;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements NoRepetViewFlow.e {
        public c() {
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.NoRepetViewFlow.e
        public void a(View view, int i) {
            GiftListView giftListView = GiftListView.this;
            if (giftListView.mLastPosition == i) {
                return;
            }
            giftListView.mLastPosition = i;
            if (giftListView.mGiftSelectedListener != null) {
                GiftListView.this.mGiftSelectedListener.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CircleProgressView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePanelListView.a.C1057a f14098a;

        public d(BasePanelListView.a.C1057a c1057a) {
            this.f14098a = c1057a;
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.CircleProgressView.c
        public void a(int i) {
            if (i == 0) {
                this.f14098a.e.setVisibility(8);
                this.f14098a.h.setVisibility(8);
                GiftListView.this.mHitNumber = 1;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(int i);

        void b(GiftPanelItem giftPanelItem);

        void c(GiftPanelItem giftPanelItem);

        void onPageSelected(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BasePanelListView<GiftPanelItem>.a {
        public f() {
            super();
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.BasePanelListView.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(int i, View view, BasePanelListView<GiftPanelItem>.a.C1057a c1057a, GiftPanelItem giftPanelItem) {
            view.setOnClickListener(this);
            GiftListView giftListView = GiftListView.this;
            if (giftListView.mSelectedPanelItem == giftPanelItem) {
                try {
                    View view2 = giftListView.mSelectedView;
                    if (view2 == null || ((GiftPanelItem) ((BasePanelListView.a.C1057a) view2.getTag()).l).itemId != giftPanelItem.itemId) {
                        GiftListView.this.mSelectedView = view;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c1057a.g.setVisibility(0);
            } else {
                c1057a.g.setVisibility(8);
                c1057a.e.setVisibility(8);
                c1057a.h.setVisibility(8);
                c1057a.f.cancelAnimProgress();
            }
            c1057a.k.setVisibility(8);
            if (TextUtils.isEmpty(giftPanelItem.itemLabelText)) {
                c1057a.j.setVisibility(8);
            } else {
                c1057a.j.setVisibility(0);
                c1057a.j.setText(giftPanelItem.itemLabelText);
                TextView textView = c1057a.j;
                int i2 = giftPanelItem.itemLabelStyleCode;
                textView.setBackgroundResource(i2 == 1 ? R$drawable.shape_gift_tag_bg_style1_new : i2 == 2 ? R$drawable.shape_gift_tag_bg_style2_new : R$drawable.shape_gift_tag_bg_style3_new);
            }
            c1057a.f.setOnClickListener(this);
            c1057a.b.setVisibility(8);
            if (giftPanelItem.realPrice > 0) {
                c1057a.f14088a.setText(giftPanelItem.realPrice + "");
                c1057a.f14088a.setVisibility(0);
            } else {
                c1057a.f14088a.setVisibility(8);
            }
            c1057a.c.setText(giftPanelItem.itemName);
            c1057a.l = giftPanelItem;
            Context context = GiftListView.this.getContext();
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
            hc2.a(context).load(k86.p(giftPanelItem.iconUrl)).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(c1057a.d);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            T t;
            if (view instanceof CircleProgressView) {
                if (eh.d(view.getId(), 100L)) {
                    return;
                }
                GiftListView.this.startHitAnim(view);
                BasePanelListView.a.C1057a c1057a = (BasePanelListView.a.C1057a) GiftListView.this.mSelectedView.getTag();
                c1057a.h.setVisibility(0);
                c1057a.h.setText("x" + GiftListView.access$204(GiftListView.this));
                GiftListView.this.startContinueAnim(c1057a);
                GiftListView.this.mGiftSelectedListener.a(GiftListView.this.mHitNumber);
                return;
            }
            BasePanelListView.a.C1057a c1057a2 = (BasePanelListView.a.C1057a) view.getTag();
            if (c1057a2 == null || (t = c1057a2.l) == 0) {
                return;
            }
            if (!TextUtils.isEmpty(((GiftPanelItem) t).activityUrl)) {
                GiftListView.this.mGiftSelectedListener.b((GiftPanelItem) c1057a2.l);
                return;
            }
            T t2 = c1057a2.l;
            GiftListView giftListView = GiftListView.this;
            if (t2 != giftListView.mSelectedPanelItem) {
                giftListView.mSelectedView = view;
                giftListView.mSelectedPanelItem = t2;
                giftListView.mGiftSelectedListener.c((GiftPanelItem) GiftListView.this.mSelectedPanelItem);
                c1057a2.g.setVisibility(0);
                GiftListView.this.startSelectedAnim(c1057a2.d);
                notifyDataSetChanged();
            }
        }
    }

    public GiftListView(Context context, int i, int i2, GiftPanelItem giftPanelItem, e eVar) {
        super(context, i, i2, giftPanelItem);
        boolean z = false;
        this.isNewStyle = false;
        this.mGiftSelectedListener = eVar;
        if (com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel) {
            z = true;
        }
        this.isNewStyle = z;
        createView(context);
    }

    public static /* synthetic */ int access$204(GiftListView giftListView) {
        int i = giftListView.mHitNumber + 1;
        giftListView.mHitNumber = i;
        return i;
    }

    private void initData() {
        this.mActivityId = 0L;
        List<GiftPanelItem> listI = com.zenmen.palmchat.giftkit.b.j().i(this.panelId);
        this.mData = listI;
        if (listI == null || listI.isEmpty()) {
            this.mSelectedPanelItem = null;
        } else {
            if (this.isNewStyle && this.mData.size() > 0) {
                this.mSelectedPanelItem = (T) this.mData.get(0);
            }
            boolean z = false;
            for (int i = 0; i < this.mData.size(); i++) {
                GiftPanelItem giftPanelItem = (GiftPanelItem) this.mData.get(i);
                if (!TextUtils.isEmpty(giftPanelItem.activityUrl)) {
                    this.mActivityId = giftPanelItem.itemId;
                }
                T t = this.mSelectedPanelItem;
                if (t != 0 && ((GiftPanelItem) t).itemId == giftPanelItem.itemId) {
                    this.mSelectedPanelItem = giftPanelItem;
                    this.mInitPosition = i / 8;
                    z = true;
                }
            }
            if (!z) {
                this.mSelectedPanelItem = (T) this.mData.get(0);
            }
        }
        e eVar = this.mGiftSelectedListener;
        if (eVar != null) {
            eVar.c((GiftPanelItem) this.mSelectedPanelItem);
        }
    }

    private void initScrollUI() {
        initData();
        updateEmptyView();
        this.mRecyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.mRecyclerView.addItemDecoration(new SDecoration(getContext(), 8, 8));
        ScrollGiftAdapter scrollGiftAdapter = new ScrollGiftAdapter();
        this.mScrollAdapter = scrollGiftAdapter;
        this.mRecyclerView.setAdapter(scrollGiftAdapter);
        this.mRecyclerView.addOnItemTouchListener(new a());
        this.mRecyclerView.addOnScrollListener(new b());
    }

    private void initUI() {
        initData();
        updateEmptyView();
        NoRepetViewFlow noRepetViewFlow = (NoRepetViewFlow) findViewById(R$id.viewFlow);
        noRepetViewFlow.setNoWindowDestroy();
        noRepetViewFlow.setFlowIndicator((NoRepetCircleFlowIndicator) findViewById(R$id.gift_indic));
        f fVar = new f();
        this.adapter = fVar;
        noRepetViewFlow.setAdapter(fVar);
        noRepetViewFlow.setSelection(this.mInitPosition);
        noRepetViewFlow.setOnViewSwitchListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEmptyView$0(View view) {
        if (eh.d(view.getId(), 3000L)) {
            return;
        }
        com.zenmen.palmchat.giftkit.b.j().x(this.panelId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startContinueAnim(BasePanelListView<GiftPanelItem>.a.C1057a c1057a) {
        if (c1057a != null) {
            c1057a.f.cancelAnimProgress();
            c1057a.f.startReverseAnimProgress(100, 3000);
            c1057a.f.setOnAnimProgressListener(new d(c1057a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHitAnim(View view) {
        if (view != null) {
            view.clearAnimation();
            if (this.mHitAnim == null) {
                this.mHitAnim = AnimationUtils.loadAnimation(getContext(), R$anim.anim_gift_hit);
            }
            view.startAnimation(this.mHitAnim);
        }
    }

    private void updateEmptyView() {
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
        imageView.setImageResource(R$drawable.ic_gift_panel_net_error);
        textView.setText(R$string.gift_panel_net_error);
        textView2.setText(R$string.gift_panel_net_error_action);
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ca2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1933a.lambda$updateEmptyView$0(view);
            }
        });
        this.mShowError = true;
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

    public long getActivityId() {
        return this.mActivityId;
    }

    public boolean hasActivity() {
        return this.mActivityId > 0;
    }

    public void onGiftSend(GiftPanelItem giftPanelItem, boolean z) {
        BasePanelListView<GiftPanelItem>.a.C1057a c1057a;
        if (z && this.mSelectedPanelItem == giftPanelItem && (c1057a = (BasePanelListView.a.C1057a) this.mSelectedView.getTag()) != null && ((GiftPanelItem) c1057a.l).itemId == giftPanelItem.itemId && c1057a.h.getVisibility() == 8) {
            c1057a.e.setVisibility(0);
            startContinueAnim(c1057a);
        }
    }

    public void resetContinue() {
        BasePanelListView.a.C1057a c1057a;
        this.mHitNumber = 1;
        View view = this.mSelectedView;
        if (view == null || (c1057a = (BasePanelListView.a.C1057a) view.getTag()) == null) {
            return;
        }
        c1057a.e.setVisibility(8);
        c1057a.h.setVisibility(8);
        c1057a.f.cancelAnimProgress();
    }

    public void resetHit() {
        BasePanelListView.a.C1057a c1057a;
        if (this.mHitNumber > 1) {
            this.mHitNumber = 1;
            if (this.mSelectedPanelItem == 0 || (c1057a = (BasePanelListView.a.C1057a) this.mSelectedView.getTag()) == null) {
                return;
            }
            c1057a.h.setVisibility(8);
        }
    }

    public void setEventDataHelper(ub2 ub2Var) {
        this.mEventDataHelper = ub2Var;
    }

    @Override // com.zenmen.palmchat.giftkit.widgit.BasePanelListView
    public void update(boolean z) {
        ScrollGiftAdapter scrollGiftAdapter;
        initData();
        if (!this.isNewStyle || (scrollGiftAdapter = this.mScrollAdapter) == null) {
            BasePanelListView<T>.a aVar = this.adapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        } else {
            scrollGiftAdapter.notifyDataSetChanged();
        }
        updateEmptyView();
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

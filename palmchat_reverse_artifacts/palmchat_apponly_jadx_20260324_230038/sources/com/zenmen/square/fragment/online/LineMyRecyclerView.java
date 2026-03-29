package com.zenmen.square.fragment.online;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dn0;
import defpackage.v4;
import defpackage.z64;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LineMyRecyclerView extends RecyclerView {
    private Activity activity;
    private Runnable autoScrollRunnable;
    private boolean isRightScroll;
    private boolean isScrolling;
    private boolean lineDataDisplay;
    private Timer mTimer;
    private OnLineAdapter onLineAdapter;
    private OnlineRecommend onlineRecommend;
    private long rvDownTime;
    private float rvDownX;
    private float rvDownY;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LineMyRecyclerView.this.isScrolling) {
                LineMyRecyclerView.this.smoothScrollBy(15, 0);
                LineMyRecyclerView.this.postDelayed(this, 120L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LineMyRecyclerView.this.lineDataDisplay = false;
            }
        }

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && LineMyRecyclerView.this.isLastItemDisplaying(recyclerView) && !LineMyRecyclerView.this.lineDataDisplay) {
                LineMyRecyclerView.this.lineDataDisplay = true;
                LineMyRecyclerView.this.onlineRecommend.A1(false);
                if (LineMyRecyclerView.this.mTimer == null) {
                    LineMyRecyclerView.this.mTimer = new Timer();
                }
                LineMyRecyclerView.this.mTimer.schedule(new a(), 500L);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i < 0) {
                LineMyRecyclerView.this.isRightScroll = true;
            } else {
                LineMyRecyclerView.this.isRightScroll = false;
            }
        }
    }

    public LineMyRecyclerView(@NonNull Context context) {
        super(context);
        this.isScrolling = false;
        this.lineDataDisplay = false;
        this.isRightScroll = false;
        this.autoScrollRunnable = new a();
        initView();
    }

    private boolean hasRecyclerData() {
        OnLineAdapter onLineAdapter = this.onLineAdapter;
        return (onLineAdapter == null || onLineAdapter.a() == null || this.onLineAdapter.a().size() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            int[] iArrFindLastCompletelyVisibleItemPositions = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(null);
            int itemCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getItemCount();
            int i = -1000;
            for (int i2 : iArrFindLastCompletelyVisibleItemPositions) {
                if (i2 > i) {
                    i = i2;
                }
            }
            if ((recyclerView.getScrollState() == 0) && i >= itemCount - 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemClickUp(MotionEvent motionEvent) {
        View viewFindChildViewUnder;
        if (motionEvent == null || z64.w() || (viewFindChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY())) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = getChildViewHolder(viewFindChildViewUnder);
        if (childViewHolder instanceof OnLineItemBaseHolder) {
            OnLineItemBaseHolder onLineItemBaseHolder = (OnLineItemBaseHolder) childViewHolder;
            OnLineItemData onLineItemData = onLineItemBaseHolder.d;
            Activity activity = onLineItemBaseHolder.f;
            LogUtil.d("OnLineManagerTag", "onInterceptTouchEvent click itemData " + onLineItemData);
            if (onLineItemData == null || activity == null) {
                return;
            }
            z64.z(onLineItemData, activity);
        }
    }

    public int getAllSize() {
        return this.onLineAdapter.getItemCount();
    }

    public int getMineItemPosition() {
        int[] iArrFindLastCompletelyVisibleItemPositions;
        if (!(getLayoutManager() instanceof StaggeredGridLayoutManager) || (iArrFindLastCompletelyVisibleItemPositions = ((StaggeredGridLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPositions(null)) == null || iArrFindLastCompletelyVisibleItemPositions.length < 3) {
            return 0;
        }
        return iArrFindLastCompletelyVisibleItemPositions[2];
    }

    public void initLineRecyclerView() {
        int iU1 = this.onlineRecommend.u1();
        LogUtil.d("OnLineManagerTag", "initLineRecyclerView initAllOnlineDataLayout onlineNum " + iU1);
        if (this.onLineAdapter != null || iU1 <= 0) {
            return;
        }
        this.onLineAdapter = new OnLineAdapter(getContext(), this.activity);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(iU1, 0);
        staggeredGridLayoutManager.setGapStrategy(0);
        setLayoutManager(staggeredGridLayoutManager);
        setAdapter(this.onLineAdapter);
        addOnScrollListener(new b());
        addOnItemTouchListener(new c());
        startAutoRecyclerScroll();
    }

    public void initRefreshPos() {
        OnLineAdapter onLineAdapter = this.onLineAdapter;
        if (onLineAdapter == null || onLineAdapter.a() == null) {
            return;
        }
        this.onLineAdapter.a().clear();
        this.onLineAdapter.notifyDataSetChanged();
        smoothScrollToPosition(0);
        this.isRightScroll = false;
        startAutoRecyclerScroll();
    }

    public void insertMineItem(OnLineStatusItem onLineStatusItem, String str) {
        if (onLineStatusItem != null) {
            ContactInfoItem contactInfoItemA = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
            OnLineItemData onLineItemData = new OnLineItemData();
            onLineItemData.type = 2;
            onLineItemData.mineType = 1;
            onLineItemData.url = onLineStatusItem.url;
            if (TextUtils.isEmpty(str)) {
                onLineItemData.content = onLineStatusItem.text;
            } else {
                onLineItemData.content = str;
            }
            onLineItemData.id = onLineStatusItem.id;
            try {
                onLineItemData.uid = Long.parseLong(v4.e(com.zenmen.palmchat.c.b()));
            } catch (Exception unused) {
            }
            if (contactInfoItemA != null) {
                onLineItemData.avatar = contactInfoItemA.getIconURL();
            }
            int mineItemPosition = getMineItemPosition();
            OnLineAdapter onLineAdapter = this.onLineAdapter;
            if (onLineAdapter == null || onLineAdapter.a() == null) {
                return;
            }
            if (mineItemPosition > this.onLineAdapter.a().size()) {
                mineItemPosition = this.onLineAdapter.a().size();
            }
            if (mineItemPosition < 0) {
                mineItemPosition = 0;
            }
            LogUtil.d("OnLineManagerTag", "insertMineItem mineData position " + mineItemPosition);
            this.onLineAdapter.a().add(mineItemPosition, onLineItemData);
            this.onLineAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setLineListValue(List<OnLineItemData> list) {
        List<OnLineItemData> listA = this.onLineAdapter.a();
        if (listA == null || listA.size() <= 0) {
            this.onLineAdapter.b(list);
        } else {
            listA.addAll(list);
            this.onLineAdapter.b(listA);
        }
    }

    public void setLineRecommend(OnlineRecommend onlineRecommend) {
        this.onlineRecommend = onlineRecommend;
        this.activity = onlineRecommend.getActivity();
    }

    public void startAutoRecyclerScroll() {
        if (!this.isScrolling && hasRecyclerData() && this.onlineRecommend.n1()) {
            this.isScrolling = true;
            post(this.autoScrollRunnable);
        }
    }

    public void startAutoRecyclerScrollUp() {
        if (!this.isScrolling && hasRecyclerData() && this.onlineRecommend.n1()) {
            this.isScrolling = true;
            postDelayed(this.autoScrollRunnable, 500L);
        }
    }

    public void stopAutoRecyclerScroll() {
        if (this.isScrolling) {
            this.isScrolling = false;
            removeCallbacks(this.autoScrollRunnable);
        }
    }

    public LineMyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.lineDataDisplay = false;
        this.isRightScroll = false;
        this.autoScrollRunnable = new a();
        initView();
    }

    public LineMyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.lineDataDisplay = false;
        this.isRightScroll = false;
        this.autoScrollRunnable = new a();
        initView();
    }

    private void initView() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements RecyclerView.OnItemTouchListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                LineMyRecyclerView.this.rvDownTime = System.currentTimeMillis();
                LineMyRecyclerView.this.rvDownX = motionEvent.getX();
                LineMyRecyclerView.this.rvDownY = motionEvent.getY();
                LineMyRecyclerView.this.stopAutoRecyclerScroll();
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (System.currentTimeMillis() - LineMyRecyclerView.this.rvDownTime < 500 && Math.abs(LineMyRecyclerView.this.rvDownX - x) < 5.0f && Math.abs(LineMyRecyclerView.this.rvDownY - y) < 5.0f) {
                LineMyRecyclerView.this.itemClickUp(motionEvent);
            }
            if (LineMyRecyclerView.this.isRightScroll) {
                return false;
            }
            LineMyRecyclerView.this.startAutoRecyclerScrollUp();
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

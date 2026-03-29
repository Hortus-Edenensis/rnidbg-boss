package com.zenmen.palmchat.conversations.threadsnew.headerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bq6;
import defpackage.en0;
import defpackage.gr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.rl0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CardViewV5 extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private static final int REFRESH_CARD_WHAT = 101;
    private static final long SUGGEST_CONTACT_INFO_CAROUSEL_DUR = 120000;
    private static final long SUGGEST_CONTACT_INFO_CAROUSEL_DUR_LOWEST = 10000;
    private static final String TAG = "CardViewV5";
    private boolean isSuggestCarousel;
    private b mAdapter;
    private CopyOnWriteArrayList<en0> mCards;
    private en0[] mContactCards;
    private LinearLayout mIndicator;
    private ThreadHeaderViewV5.d mListener;

    @SuppressLint({"HandlerLeak"})
    private Handler mSuggestRefreshTask;
    private ViewPager mViewPager;
    private long suggestCarouselDur;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (CardViewV5.this.isSuggestCarousel) {
                LogUtil.e(CardViewV5.TAG, "instantiateItem mSuggestRefreshTask " + System.currentTimeMillis());
                CardViewV5 cardViewV5 = CardViewV5.this;
                cardViewV5.updateCard(cardViewV5.mContactCards[1]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<View> f13823a = new ArrayList();
        public Context b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ en0 f13824a;

            public a(en0 en0Var) {
                this.f13824a = en0Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardViewV5.this.mListener != null) {
                    CardViewV5.this.mListener.b(this.f13824a);
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.headerview.CardViewV5$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ViewOnClickListenerC1041b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ en0 f13825a;

            public ViewOnClickListenerC1041b(en0 en0Var) {
                this.f13825a = en0Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardViewV5.this.mListener != null) {
                    CardViewV5.this.mListener.c(this.f13825a);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements View.OnLongClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ en0 f13826a;

            public c(en0 en0Var) {
                this.f13826a = en0Var;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (CardViewV5.this.mListener == null) {
                    return false;
                }
                CardViewV5.this.mListener.e(this.f13826a);
                return false;
            }
        }

        public b(Context context) {
            this.b = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CardViewV5.this.mCards.size() > 1 ? CardViewV5.this.mCards.size() + 2 : CardViewV5.this.mCards.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.view_thread_contact_swipe_card_v5, (ViewGroup) null);
            SocialPortraitView socialPortraitView = (SocialPortraitView) viewInflate.findViewById(R.id.img_portrait);
            socialPortraitView.changeShapeType(3);
            socialPortraitView.setDegreeForRoundRectangle(13, 13);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_description);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_add);
            en0 en0Var = (en0) CardViewV5.this.mCards.get(i % CardViewV5.this.mCards.size());
            for (en0 en0Var2 : CardViewV5.this.mCards) {
                LogUtil.i(CardViewV5.TAG, "for:" + en0Var2.a() + "");
            }
            LogUtil.i(CardViewV5.TAG, "position:" + i + " " + en0Var.a());
            textView3.setOnClickListener(new a(en0Var));
            viewInflate.setOnClickListener(new ViewOnClickListenerC1041b(en0Var));
            viewInflate.setOnLongClickListener(new c(en0Var));
            if (en0Var.a() != 3) {
                if (en0Var.b().c() < 100) {
                    textView3.setText("接受");
                    textView.setText(en0Var.b().a().getNickName());
                    textView2.setText(en0Var.b().a().getDescription());
                } else if (en0Var.c().size() > 0) {
                    int iAbs = (int) ((Math.abs(System.currentTimeMillis() - PreferenceManager.getDefaultSharedPreferences(AppContext.getContext()).getLong(k86.x(), 0L)) / CardViewV5.this.suggestCarouselDur) % ((long) en0Var.c().size()));
                    LogUtil.e(CardViewV5.TAG, "instantiateItem time : " + System.currentTimeMillis() + " index: " + iAbs);
                    en0Var.e(en0Var.c().get(iAbs));
                    textView3.setText("添加");
                    String nickName = en0Var.b().a().getNickName();
                    String localOrRealName = en0Var.b().b().getLocalOrRealName();
                    if (!TextUtils.isEmpty(localOrRealName)) {
                        nickName = nickName + "(" + localOrRealName + ")";
                    }
                    textView.setText(nickName);
                    textView2.setText(en0Var.b().b().recommendText);
                }
                gr2.j().h(en0Var.b().a().getIconURL(), socialPortraitView, bq6.s());
            }
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            CardViewV5 cardViewV5 = CardViewV5.this;
            cardViewV5.setVisibility(cardViewV5.mCards.size() == 0 ? 8 : 0);
            CardViewV5.this.initIndicatorPanel();
        }
    }

    public CardViewV5(Context context) {
        this(context, null);
    }

    private void initData() {
        this.mContactCards = new en0[]{null, null};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initIndicatorPanel() {
        LogUtil.i(TAG, "initIndicatorPanel");
        this.mIndicator.removeAllViews();
        if (this.mCards.size() > 1) {
            int i = 0;
            while (i < this.mCards.size()) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.width = me1.b(getContext(), 4);
                layoutParams.height = me1.b(getContext(), 4);
                layoutParams.setMargins(me1.b(getContext(), 4), 0, me1.b(getContext(), 4), 0);
                imageView.setImageResource(R.drawable.dot_selector);
                imageView.setLayoutParams(layoutParams);
                imageView.setSelected(i == 0);
                this.mIndicator.addView(imageView);
                i++;
            }
        }
    }

    private void initViews(Context context) {
        View viewInflate = View.inflate(context, R.layout.layout_thread_swipe_card_v5, this);
        this.mViewPager = (ViewPager) viewInflate.findViewById(R.id.viewPager);
        this.mIndicator = (LinearLayout) viewInflate.findViewById(R.id.lyt_indicator);
        this.mViewPager.setOnPageChangeListener(this);
        b bVar = new b(context);
        this.mAdapter = bVar;
        this.mViewPager.setAdapter(bVar);
    }

    public en0 getCard() {
        return this.mContactCards[1];
    }

    public boolean hasCards() {
        return this.mCards.size() > 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i != 0 || this.mCards.size() <= 1) {
            return;
        }
        if (this.mViewPager.getCurrentItem() >= this.mAdapter.getCount() - 1) {
            this.mViewPager.setCurrentItem(1, false);
        } else if (this.mViewPager.getCurrentItem() <= 0) {
            this.mViewPager.setCurrentItem(this.mCards.size(), false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        LogUtil.i(TAG, "onPageSelected:" + i);
        for (int i2 = 0; i2 < this.mIndicator.getChildCount(); i2++) {
            if (i2 == i % this.mCards.size()) {
                this.mIndicator.getChildAt(i2).setSelected(true);
            } else {
                this.mIndicator.getChildAt(i2).setSelected(false);
            }
        }
        this.mIndicator.requestLayout();
    }

    public void setOnCardListener(ThreadHeaderViewV5.d dVar) {
        this.mListener = dVar;
    }

    public synchronized void startSuggestCarousel() {
        en0 en0Var;
        stopSuggestCarousel();
        en0[] en0VarArr = this.mContactCards;
        if (en0VarArr != null && (en0Var = en0VarArr[1]) != null) {
            if (en0Var.a() != 2) {
                return;
            }
            if (this.mContactCards[1].c() != null && this.mContactCards[1].c().size() > 1) {
                if (TextUtils.isEmpty(rl0.h().c().b())) {
                    this.suggestCarouselDur = 120000L;
                } else {
                    try {
                        this.suggestCarouselDur = Integer.valueOf(r0).intValue() * 1000;
                    } catch (NumberFormatException unused) {
                        this.suggestCarouselDur = 120000L;
                    }
                }
                long j = this.suggestCarouselDur;
                if (j < 10000) {
                    j = 10000;
                }
                this.suggestCarouselDur = j;
                this.isSuggestCarousel = true;
                Message message = new Message();
                message.what = 101;
                long jAbs = Math.abs(System.currentTimeMillis() - PreferenceManager.getDefaultSharedPreferences(AppContext.getContext()).getLong(k86.x(), 0L));
                long j2 = this.suggestCarouselDur;
                long j3 = (j2 - (jAbs % j2)) + 1000;
                LogUtil.e(TAG, "instantiateItem startSuggestCarousel " + j3);
                this.mSuggestRefreshTask.sendMessageDelayed(message, j3);
            }
        }
    }

    public synchronized void stopSuggestCarousel() {
        this.isSuggestCarousel = false;
        this.mSuggestRefreshTask.removeMessages(101);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:5:0x0004, B:7:0x000a, B:10:0x0012, B:12:0x001c, B:14:0x0027, B:16:0x002b, B:17:0x0030, B:18:0x0033, B:20:0x003e, B:24:0x0066, B:21:0x0049, B:23:0x0061, B:11:0x0017), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:5:0x0004, B:7:0x000a, B:10:0x0012, B:12:0x001c, B:14:0x0027, B:16:0x002b, B:17:0x0030, B:18:0x0033, B:20:0x003e, B:24:0x0066, B:21:0x0049, B:23:0x0061, B:11:0x0017), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:5:0x0004, B:7:0x000a, B:10:0x0012, B:12:0x001c, B:14:0x0027, B:16:0x002b, B:17:0x0030, B:18:0x0033, B:20:0x003e, B:24:0x0066, B:21:0x0049, B:23:0x0061, B:11:0x0017), top: B:30:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateCard(en0 en0Var) {
        if (en0Var == null) {
            this.mContactCards[1] = null;
            this.mCards.clear();
            while (i < r1) {
            }
            this.mAdapter.notifyDataSetChanged();
            if (this.mContactCards[1] == null) {
            }
            startSuggestCarousel();
        } else if (en0Var.a() == 1 || en0Var.a() == 2) {
            this.mContactCards[1] = en0Var;
            this.mCards.clear();
            for (en0 en0Var2 : this.mContactCards) {
                if (en0Var2 != null) {
                    this.mCards.add(en0Var2);
                }
            }
            this.mAdapter.notifyDataSetChanged();
            if (this.mContactCards[1] == null) {
                this.mViewPager.setAdapter(this.mAdapter);
                initIndicatorPanel();
            } else {
                int currentItem = this.mViewPager.getCurrentItem();
                this.mViewPager.setAdapter(this.mAdapter);
                initIndicatorPanel();
                if (this.mCards.size() > 1) {
                    this.mViewPager.setCurrentItem(currentItem);
                }
            }
            startSuggestCarousel();
        } else {
            this.mContactCards[1] = null;
            this.mCards.clear();
            while (i < r1) {
            }
            this.mAdapter.notifyDataSetChanged();
            if (this.mContactCards[1] == null) {
            }
            startSuggestCarousel();
        }
    }

    public CardViewV5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardViewV5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCards = new CopyOnWriteArrayList<>();
        this.isSuggestCarousel = false;
        this.suggestCarouselDur = 120000L;
        this.mSuggestRefreshTask = new a();
        initData();
        initViews(context);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}

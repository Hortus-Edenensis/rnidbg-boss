package com.zenmen.square.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.activity.SquarePublishActivity;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.ui.widget.TabItemView;
import defpackage.a46;
import defpackage.d46;
import defpackage.e46;
import defpackage.er0;
import defpackage.hc2;
import defpackage.kc2;
import defpackage.qs5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SelectTabHeaderView extends LxRelativeLayout implements TabItemView.b, View.OnClickListener {
    private ImageView ImgMsgBox;
    int lastNearByState;
    private int lastPosition;
    private int lastToolIconState;
    private g listener;
    private List<TabItemView> mItemViews;
    private List<qs5> mItems;
    private View msgBoxView;
    private View nearByFilterView;
    private View publishView;
    private LinearLayout redTextLayout;
    private Map<String, Boolean> redTextShowItem;
    private View squareMsgDot;
    private LinearLayout tabLayout;
    private View toolLayout;
    private float translationX;
    private TextView tvRedDot;
    private d46 unReadMessageChangeListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SelectTabHeaderView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            SelectTabHeaderView.this.intRedText();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends e46 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f16556a;

            public a(boolean z) {
                this.f16556a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                SelectTabHeaderView.this.setItemRedTextShow("nearbyFeedTitle", this.f16556a);
            }
        }

        public b() {
        }

        @Override // defpackage.e46, defpackage.d46
        public void a(boolean z) {
            SelectTabHeaderView.this.updateRedDotAll();
        }

        @Override // defpackage.e46, defpackage.d46
        public void c(int i) {
            SelectTabHeaderView.this.updateRedDot();
        }

        @Override // defpackage.e46, defpackage.d46
        public void d(boolean z) {
            SelectTabHeaderView.this.post(new a(z));
        }

        @Override // defpackage.d46
        public void e(int i) {
            SelectTabHeaderView.this.updateRedDot();
        }

        @Override // defpackage.d46
        public void f(int i) {
            SelectTabHeaderView.this.updateRedDot();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16559a;

        public e(int i) {
            this.f16559a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            SelectTabHeaderView.this.nearByFilterView.setVisibility(this.f16559a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16560a;

        public f(int i) {
            this.f16560a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            SelectTabHeaderView.this.nearByFilterView.setVisibility(this.f16560a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void d();

        void g();

        void onItemSelected(int i);

        void s();
    }

    public SelectTabHeaderView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intRedText() {
        Iterator<TabItemView> it = this.mItemViews.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next().getTag()).intValue();
            if (iIntValue >= 0 && iIntValue < this.mItems.size()) {
                qs5 qs5Var = this.mItems.get(iIntValue);
                if (this.redTextLayout.getChildCount() != this.mItemViews.size()) {
                    if (!z) {
                        this.redTextLayout.removeAllViews();
                        z = true;
                    }
                    TextView textView = new TextView(getContext());
                    textView.setTextColor(-1);
                    textView.setTextSize(1, 9.0f);
                    textView.setGravity(17);
                    textView.setBackgroundResource(R$drawable.bg_text_dot_red);
                    textView.setText(qs5Var.e);
                    textView.setTag(qs5Var.d);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a46.b(getContext(), 30.0f), a46.b(getContext(), 16.0f));
                    layoutParams.leftMargin = this.mItemViews.get(iIntValue).getMeasuredWidth() - a46.b(getContext(), 15.0f);
                    this.redTextLayout.addView(textView, layoutParams);
                    textView.setVisibility((this.redTextShowItem.containsKey(qs5Var.d) && this.redTextShowItem.get(qs5Var.d).booleanValue()) ? 0 : 4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRedDotAll() {
        updateRedDot(SquareSingleton.getInstance().getMessageCountManager().g().booleanValue(), "friendFeedTitle");
        updateRedDot(SquareSingleton.getInstance().getMessageCountManager().e(), "nearbyFeedTitle");
    }

    private void updateRedTextVisibility() {
        int childCount = this.redTextLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.redTextLayout.getChildAt(i);
            if (childAt != null) {
                int i2 = 4;
                if (childAt.getTag() != null) {
                    String str = (String) childAt.getTag();
                    if (this.redTextShowItem.containsKey(str) && this.redTextShowItem.get(str).booleanValue()) {
                        i2 = 0;
                    }
                    childAt.setVisibility(i2);
                } else {
                    childAt.setVisibility(4);
                }
            }
        }
    }

    public void bindTableItems(List<qs5> list, String str) {
        if (list != null) {
            this.mItems = list;
            this.mItemViews.clear();
            this.tabLayout.removeAllViews();
            int i = 0;
            for (qs5 qs5Var : list) {
                TabItemView tabItemView = new TabItemView(getContext());
                tabItemView.setViewText(qs5Var.b);
                tabItemView.setTag(qs5Var);
                tabItemView.setTag(Integer.valueOf(i));
                tabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (i > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 15.0f);
                }
                this.tabLayout.addView(tabItemView, layoutParams);
                this.mItemViews.add(tabItemView);
                if (TextUtils.equals(qs5Var.c, str)) {
                    tabItemView.setCurrentSelected(true, false);
                }
                i++;
            }
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_select_tab_header, this);
        this.tabLayout = (LinearLayout) findViewById(R$id.square_tab_select_view);
        this.redTextLayout = (LinearLayout) findViewById(R$id.red_text_container);
        this.tvRedDot = (TextView) findViewById(R$id.tv_praise_count_red_dot);
        this.squareMsgDot = findViewById(R$id.square_msg_dot);
        int i = R$id.square_msg_box;
        this.ImgMsgBox = (ImageView) findViewById(i);
        this.msgBoxView = findViewById(i);
        this.publishView = findViewById(R$id.square_go_publish);
        this.toolLayout = findViewById(R$id.rl_tool_layout);
        this.nearByFilterView = findViewById(R$id.btn_nearby_filter);
        this.msgBoxView.setOnClickListener(this);
        this.publishView.setOnClickListener(this);
        this.nearByFilterView.setOnClickListener(this);
        this.translationX = a46.b(getContext(), 46.0f);
        getViewTreeObserver().addOnPreDrawListener(new a());
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SquareSingleton.getInstance().registerCountChangeListener(this.unReadMessageChangeListener);
        updateRedDot();
        updateRedDotAll();
        setItemRedTextShow("nearbyFeedTitle", SquareSingleton.getInstance().getMessageCountManager().m());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.listener == null) {
            return;
        }
        int id = view.getId();
        if (id == R$id.square_msg_box) {
            this.listener.s();
        }
        if (id == R$id.square_go_publish) {
            this.listener.g();
            SquarePublishActivity.D0 = 1;
        }
        if (id == R$id.btn_nearby_filter) {
            this.listener.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SquareSingleton.getInstance().unRegisterCountChangeListener(this.unReadMessageChangeListener);
    }

    @Override // com.zenmen.square.ui.widget.TabItemView.b
    public void onItemSelect(int i) {
        g gVar = this.listener;
        if (gVar != null) {
            gVar.onItemSelected(i);
        }
    }

    public void onSelect(int i) {
        selectedTargetItem(i, false);
    }

    public void selectedTargetItem(int i, boolean z) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof TabItemView) {
            ((TabItemView) viewFindViewWithTag).setCurrentSelected(false, z);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof TabItemView) {
            ((TabItemView) viewFindViewWithTag2).setCurrentSelected(true, z);
        }
        this.lastPosition = i;
    }

    public void setHeaderViewEventListener(g gVar) {
        this.listener = gVar;
    }

    public void setItemRedTextShow(String str, boolean z) {
        this.redTextShowItem.put(str, Boolean.valueOf(z));
        updateRedTextVisibility();
    }

    public void setNearByIconVisible(int i) {
        if (i == this.lastNearByState) {
            return;
        }
        this.nearByFilterView.clearAnimation();
        this.lastNearByState = i;
        if (i == 4) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nearByFilterView, "translationX", 0.0f, this.translationX).setDuration(200L);
            duration.addListener(new e(i));
            duration.start();
        } else {
            this.nearByFilterView.setVisibility(i);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nearByFilterView, "translationX", this.translationX, 0.0f).setDuration(200L);
            duration2.addListener(new f(i));
            duration2.start();
        }
    }

    public void setToolIconVisibility(int i) {
        if (i == this.lastToolIconState) {
            return;
        }
        this.toolLayout.clearAnimation();
        this.lastToolIconState = i;
        if (i != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new d(i));
            alphaAnimation.setRepeatCount(0);
            this.toolLayout.setAnimation(alphaAnimation);
            alphaAnimation.startNow();
            return;
        }
        this.toolLayout.setVisibility(i);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(200L);
        alphaAnimation2.setAnimationListener(new c(i));
        alphaAnimation2.setRepeatCount(0);
        this.toolLayout.setAnimation(alphaAnimation2);
        alphaAnimation2.startNow();
    }

    public void updateRedDot(boolean z, String str) {
        for (TabItemView tabItemView : this.mItemViews) {
            int iIntValue = ((Integer) tabItemView.getTag()).intValue();
            if (iIntValue >= 0 && iIntValue < this.mItems.size() && this.mItems.get(iIntValue).d.equals(str)) {
                tabItemView.updateDot(z ? 1 : 0);
            }
        }
    }

    public SelectTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItems = new ArrayList();
        this.mItemViews = new ArrayList();
        this.redTextShowItem = new HashMap();
        this.unReadMessageChangeListener = new b();
        this.lastPosition = 0;
        this.lastToolIconState = -1;
        this.lastNearByState = -1;
    }

    public void updateRedDot() {
        int iP = SquareSingleton.getInstance().getMessageCountManager().p();
        if (iP > 0) {
            this.tvRedDot.setVisibility(0);
            if (iP <= 99) {
                this.tvRedDot.setText(iP + "");
            } else {
                this.tvRedDot.setText("99+");
            }
            String strI = SquareSingleton.getInstance().getMessageCountManager().i();
            if (!TextUtils.isEmpty(strI)) {
                try {
                    kc2<Drawable> kc2VarDiskCacheStrategy = hc2.a(com.zenmen.palmchat.c.b()).load(strI).diskCacheStrategy(DiskCacheStrategy.DATA);
                    int i = R$drawable.icon_square_msg_box;
                    kc2VarDiskCacheStrategy.placeholder(i).error(i).transition(DrawableTransitionOptions.withCrossFade()).transform(new er0(0, 0)).into(this.ImgMsgBox);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                this.ImgMsgBox.setImageResource(R$drawable.icon_square_msg_box);
            }
        } else {
            if (SquareSingleton.getInstance().getMessageCountManager().n()) {
                this.squareMsgDot.setVisibility(0);
            } else {
                this.squareMsgDot.setVisibility(8);
            }
            this.tvRedDot.setVisibility(8);
            this.tvRedDot.setText("");
            this.ImgMsgBox.setImageResource(R$drawable.icon_square_msg_box);
        }
        View view = this.msgBoxView;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.tvRedDot.setVisibility(8);
    }

    @RequiresApi(api = 21)
    public SelectTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItems = new ArrayList();
        this.mItemViews = new ArrayList();
        this.redTextShowItem = new HashMap();
        this.unReadMessageChangeListener = new b();
        this.lastPosition = 0;
        this.lastToolIconState = -1;
        this.lastNearByState = -1;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16557a;

        public c(int i) {
            this.f16557a = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SelectTabHeaderView.this.toolLayout.setVisibility(this.f16557a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16558a;

        public d(int i) {
            this.f16558a = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SelectTabHeaderView.this.toolLayout.setVisibility(this.f16558a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}

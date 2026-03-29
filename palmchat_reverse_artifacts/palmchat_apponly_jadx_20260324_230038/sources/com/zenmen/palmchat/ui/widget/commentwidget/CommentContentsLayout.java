package com.zenmen.palmchat.ui.widget.commentwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import defpackage.dn0;
import defpackage.k36;
import defpackage.r64;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CommentContentsLayout extends LinearLayout implements ViewGroup.OnHierarchyChangeListener {
    private static final int DEFAULT_WRAP_COUNT = 10;
    private static final String TAG = "CommentContentsLayout";
    private h<CommentWidget> COMMENT_TEXT_POOL;
    private int commentLeftAndPaddintRight;
    private int commentTopAndPaddintBottom;
    private r64 mOnCommentUserClickListener;
    private int mWrapCount;
    private int mode;
    private e onCommentItemClickListener;
    private f onCommentItemLongClickListener;
    private View.OnLongClickListener onCommentLongClickListener;
    private View.OnClickListener onCommentWidgetClickListener;
    private g onCommentWidgetItemClickListener;
    private View.OnClickListener onShowClickListener;
    private TextView show;
    private boolean showMore;
    private boolean wrapAnimation;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentContentsLayout.this.mode != 1) {
                return;
            }
            CommentContentsLayout commentContentsLayout = CommentContentsLayout.this;
            commentContentsLayout.showMore = true ^ commentContentsLayout.showMore;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof CommentWidget) {
                CommentContentsLayout.access$200(CommentContentsLayout.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!(view instanceof CommentWidget)) {
                return false;
            }
            CommentContentsLayout.access$300(CommentContentsLayout.this);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<T>[] f15591a;
        public int b;
        public int c;

        public h(CommentContentsLayout commentContentsLayout) {
            this(5);
        }

        public void a() {
            int i = 0;
            while (true) {
                WeakReference<T>[] weakReferenceArr = this.f15591a;
                if (i >= weakReferenceArr.length) {
                    this.c = -1;
                    return;
                } else {
                    weakReferenceArr[i].clear();
                    this.f15591a[i] = null;
                    i++;
                }
            }
        }

        public synchronized T b() {
            int i = this.c;
            if (i != -1) {
                WeakReference<T>[] weakReferenceArr = this.f15591a;
                if (i <= weakReferenceArr.length) {
                    T t = weakReferenceArr[i].get();
                    WeakReference<T>[] weakReferenceArr2 = this.f15591a;
                    int i2 = this.c;
                    weakReferenceArr2[i2] = null;
                    this.c = i2 - 1;
                    return t;
                }
            }
            return null;
        }

        public synchronized boolean c(T t) {
            int i = this.c;
            if (i != -1 && i >= this.f15591a.length - 1) {
                return false;
            }
            int i2 = i + 1;
            this.c = i2;
            this.f15591a[i2] = new WeakReference<>(t);
            return true;
        }

        public int d() {
            WeakReference<T>[] weakReferenceArr = this.f15591a;
            if (weakReferenceArr == null) {
                return 0;
            }
            return weakReferenceArr.length;
        }

        public h(int i) {
            this.c = -1;
            this.b = i;
            this.f15591a = (WeakReference[]) Array.newInstance((Class<?>) WeakReference.class, i);
        }
    }

    public CommentContentsLayout(Context context) {
        super(context);
        this.mode = 0;
        this.mWrapCount = 10;
        this.showMore = false;
        this.wrapAnimation = true;
        this.commentTopAndPaddintBottom = k36.b(2.0f);
        this.commentLeftAndPaddintRight = k36.b(10.0f);
        this.onShowClickListener = new a();
        this.onCommentWidgetClickListener = new b();
        this.onCommentLongClickListener = new c();
        this.mOnCommentUserClickListener = new d();
        initView();
    }

    public static /* synthetic */ e access$200(CommentContentsLayout commentContentsLayout) {
        commentContentsLayout.getClass();
        return null;
    }

    public static /* synthetic */ f access$300(CommentContentsLayout commentContentsLayout) {
        commentContentsLayout.getClass();
        return null;
    }

    private void initShowTextView() {
        if (this.show == null) {
            TextView textView = new TextView(getContext());
            this.show = textView;
            textView.setText("更多评论↓");
            this.show.setTextSize(12.0f);
            this.show.setTextColor(-15066598);
            this.show.setPadding(32, 32, 32, 32);
        }
        this.show.setOnClickListener(this.onShowClickListener);
    }

    private void initView() {
        setOrientation(1);
        this.COMMENT_TEXT_POOL = new h<>(this);
        setPadding(0, k36.b(8.0f), 0, k36.b(8.0f));
    }

    private void onModeChanged(int i) {
        if (i == 0) {
            TextView textView = this.show;
            if (textView != null) {
                removeView(textView);
                return;
            }
            return;
        }
        if (i != 1) {
            return;
        }
        if (this.show == null) {
            initShowTextView();
        }
        ViewGroup.LayoutParams layoutParams = this.show.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
        if (this.show.getParent() != null) {
            addView(this.show, layoutParams);
        }
    }

    public boolean addComments(List<SquareSimpleComment> list, boolean z) {
        if (isListEmpty(list)) {
            return false;
        }
        List<?> arrayList = new ArrayList<>(list);
        if (z) {
            List<?> arrayList2 = new ArrayList<>();
            Iterator<?> it = arrayList.iterator();
            while (it.hasNext()) {
                SquareSimpleComment squareSimpleComment = (SquareSimpleComment) it.next();
                if (dn0.d(squareSimpleComment.fromUid)) {
                    arrayList2.add(squareSimpleComment);
                }
            }
            arrayList = arrayList2;
        }
        if (isListEmpty(arrayList)) {
            return false;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        int childCount = getChildCount();
        if (childCount < arrayList.size()) {
            int size = arrayList.size() - childCount;
            for (int i = 0; i < size; i++) {
                CommentWidget commentWidgetB = this.COMMENT_TEXT_POOL.b();
                if (commentWidgetB == null) {
                    commentWidgetB = new CommentWidget(getContext());
                    int i2 = this.commentLeftAndPaddintRight;
                    int i3 = this.commentTopAndPaddintBottom;
                    commentWidgetB.setPadding(i2, i3, i2, i3);
                    commentWidgetB.setLineSpacing(4.0f, 1.0f);
                    commentWidgetB.setLines(1);
                }
                ViewGroup.LayoutParams layoutParams = commentWidgetB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                addViewInLayout(commentWidgetB, i, layoutParams, true);
            }
        } else if (childCount > arrayList.size()) {
            removeViewsInLayout(arrayList.size(), childCount - arrayList.size());
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            CommentWidget commentWidget = (CommentWidget) getChildAt(i4);
            if (commentWidget != null) {
                commentWidget.setCommentText((SquareSimpleComment) arrayList.get(i4));
            }
        }
        requestLayout();
        return true;
    }

    public void clearCommentPool() {
        this.COMMENT_TEXT_POOL.a();
    }

    public e getOnCommentItemClickListener() {
        return null;
    }

    public f getOnCommentItemLongClickListener() {
        return null;
    }

    public g getOnCommentWidgetItemClickListener() {
        return null;
    }

    public boolean isListEmpty(List<?> list) {
        return list == null || list.size() <= 0;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        if (view2 instanceof CommentWidget) {
            Log.i(TAG, "捕获到一个评论removed，缓存池+1，当前缓存量  >>>  " + this.COMMENT_TEXT_POOL.d());
            this.COMMENT_TEXT_POOL.c((CommentWidget) view2);
        }
    }

    public void setMode(int i) {
        if (this.mode == i) {
            return;
        }
        this.mode = i;
        onModeChanged(i);
    }

    public CommentContentsLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 0;
        this.mWrapCount = 10;
        this.showMore = false;
        this.wrapAnimation = true;
        this.commentTopAndPaddintBottom = k36.b(2.0f);
        this.commentLeftAndPaddintRight = k36.b(10.0f);
        this.onShowClickListener = new a();
        this.onCommentWidgetClickListener = new b();
        this.onCommentLongClickListener = new c();
        this.mOnCommentUserClickListener = new d();
        initView();
    }

    public CommentContentsLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = 0;
        this.mWrapCount = 10;
        this.showMore = false;
        this.wrapAnimation = true;
        this.commentTopAndPaddintBottom = k36.b(2.0f);
        this.commentLeftAndPaddintRight = k36.b(10.0f);
        this.onShowClickListener = new a();
        this.onCommentWidgetClickListener = new b();
        this.onCommentLongClickListener = new c();
        this.mOnCommentUserClickListener = new d();
        initView();
    }

    public void setOnCommentItemClickListener(e eVar) {
    }

    public void setOnCommentItemLongClickListener(f fVar) {
    }

    public void setOnCommentWidgetItemClickListener(g gVar) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements r64 {
        public d() {
        }

        @Override // defpackage.r64
        public void a(@NonNull SquareSimpleComment squareSimpleComment, String str) {
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}

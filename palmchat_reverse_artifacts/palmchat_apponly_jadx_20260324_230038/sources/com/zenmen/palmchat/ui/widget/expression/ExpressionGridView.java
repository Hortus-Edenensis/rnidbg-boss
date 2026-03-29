package com.zenmen.palmchat.ui.widget.expression;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ExpressionGridView extends GridView implements AdapterView.OnItemClickListener {
    private static final String TAG = "ExpressionGridView";
    private static final long dragResponseMS = 500;
    private boolean isDrag;
    private boolean isDragEnable;
    private View mCurrentView;
    private int mDownX;
    private int mDownY;
    private ImageView mDragImageView;
    private int mDragPosition;
    private Handler mHandler;
    private Runnable mLongClickRunnable;
    private b mOnTouchChangeListener;
    private View mStartDragItemView;
    private int mStartItemId;
    private Vibrator mVibrator;
    private WindowManager.LayoutParams mWindowLayoutParams;
    private WindowManager mWindowManager;
    private int moveX;
    private int moveY;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(ExpressionGridView.TAG, "longClick");
            ExpressionGridView.this.isDrag = true;
            ExpressionGridView expressionGridView = ExpressionGridView.this;
            expressionGridView.mStartItemId = expressionGridView.mDragPosition;
            ExpressionGridView expressionGridView2 = ExpressionGridView.this;
            expressionGridView2.mCurrentView = expressionGridView2.mStartDragItemView;
            ExpressionGridView.access$500(ExpressionGridView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public ExpressionGridView(Context context) {
        super(context);
        this.isDragEnable = false;
        this.isDrag = false;
        this.mStartDragItemView = null;
        this.mStartItemId = -1;
        this.mHandler = new Handler();
        this.mLongClickRunnable = new a();
    }

    public static /* synthetic */ b access$500(ExpressionGridView expressionGridView) {
        expressionGridView.getClass();
        return null;
    }

    private boolean isTouchInItem(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int left = view.getLeft();
        int top = view.getTop();
        return i >= left && i <= left + view.getWidth() && i2 >= top && i2 <= top + view.getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.isDragEnable) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownX = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.mDownY = y;
            int iPointToPosition = pointToPosition(this.mDownX, y);
            this.mDragPosition = iPointToPosition;
            if (iPointToPosition == -1) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.mHandler.postDelayed(this.mLongClickRunnable, 500L);
            this.mStartDragItemView = getChildAt(this.mDragPosition - getFirstVisiblePosition());
        } else if (action == 1) {
            this.mHandler.removeCallbacks(this.mLongClickRunnable);
        } else if (action == 2) {
            if (!isTouchInItem(this.mStartDragItemView, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.mHandler.removeCallbacks(this.mLongClickRunnable);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isDrag) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            this.isDrag = false;
        } else if (action == 2) {
            this.moveX = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.moveY = y;
            pointToPosition(this.moveX, y);
        }
        return true;
    }

    public void removePopMessage() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void setDragEnable(boolean z) {
        this.isDragEnable = z;
    }

    public void setOnTouchChangeListener(b bVar) {
        setOnItemClickListener(this);
    }

    public ExpressionGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDragEnable = false;
        this.isDrag = false;
        this.mStartDragItemView = null;
        this.mStartItemId = -1;
        this.mHandler = new Handler();
        this.mLongClickRunnable = new a();
    }

    public ExpressionGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDragEnable = false;
        this.isDrag = false;
        this.mStartDragItemView = null;
        this.mStartItemId = -1;
        this.mHandler = new Handler();
        this.mLongClickRunnable = new a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }
}

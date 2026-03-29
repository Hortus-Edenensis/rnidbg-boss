package com.zenmen.palmchat.chat;

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
/* JADX INFO: loaded from: classes13.dex */
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
            if (ExpressionGridView.this.mOnTouchChangeListener != null) {
                ExpressionGridView.this.mOnTouchChangeListener.c(ExpressionGridView.this.mCurrentView, ExpressionGridView.this.mStartItemId);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(View view, int i);

        void b(View view, int i);

        void c(View view, int i);

        void onItemClick(AdapterView<?> adapterView, View view, int i, long j);
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

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = this.mOnTouchChangeListener;
        if (bVar != null) {
            bVar.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (!this.isDrag) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            b bVar2 = this.mOnTouchChangeListener;
            if (bVar2 != null) {
                bVar2.b(this.mCurrentView, this.mStartItemId);
            }
            this.isDrag = false;
        } else if (action == 2) {
            this.moveX = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.moveY = y;
            int iPointToPosition = pointToPosition(this.moveX, y);
            if (iPointToPosition != -1) {
                int i = this.mStartItemId;
                if (iPointToPosition != i && (bVar = this.mOnTouchChangeListener) != null) {
                    bVar.b(this.mCurrentView, i);
                    this.mStartItemId = iPointToPosition;
                    View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                    this.mCurrentView = childAt;
                    this.mOnTouchChangeListener.c(childAt, this.mStartItemId);
                }
            } else {
                b bVar3 = this.mOnTouchChangeListener;
                if (bVar3 != null) {
                    bVar3.a(this.mCurrentView, this.mStartItemId);
                }
            }
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
        this.mOnTouchChangeListener = bVar;
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
}

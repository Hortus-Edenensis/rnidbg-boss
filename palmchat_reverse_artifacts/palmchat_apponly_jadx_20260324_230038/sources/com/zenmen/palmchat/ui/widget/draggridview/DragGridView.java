package com.zenmen.palmchat.ui.widget.draggridview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import defpackage.fg1;
import defpackage.gg1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DragGridView extends GridView implements AdapterView.OnItemClickListener {
    private static final int MOVE_DURATION = 300;
    private boolean canDrag;
    private int currentPosition;
    private gg1 dragCallback;
    private int fingerDx;
    private int fingerDy;
    private f imgMoveCallback;
    private boolean isDetachedFromWindow;
    private boolean isDrag;
    private boolean isEdit;
    private boolean isSwap;
    private int mCurrentRawX;
    private int mCurrentRawY;
    private int mCurrentX;
    private int mCurrentY;
    private int originPosition;
    private View selectView;
    private ImageView virtualImage;
    private int winViewDx;
    private int winViewDy;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemLongClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == -1 || ((fg1) DragGridView.this.getAdapter()).b() == i) {
                return false;
            }
            DragGridView.this.resumeView();
            DragGridView dragGridView = DragGridView.this;
            dragGridView.selectView = dragGridView.getChildAt(i - dragGridView.getFirstVisiblePosition());
            if (DragGridView.this.selectView != null) {
                DragGridView.this.isDrag = true;
                DragGridView.this.isEdit = true;
                DragGridView.this.originPosition = i;
                DragGridView.this.currentPosition = i;
                DragGridView dragGridView2 = DragGridView.this;
                dragGridView2.fingerDx = dragGridView2.selectView.getLeft() - DragGridView.this.mCurrentX;
                DragGridView dragGridView3 = DragGridView.this;
                dragGridView3.fingerDy = dragGridView3.selectView.getTop() - DragGridView.this.mCurrentY;
                DragGridView dragGridView4 = DragGridView.this;
                dragGridView4.winViewDx = dragGridView4.mCurrentRawX - DragGridView.this.mCurrentX;
                DragGridView dragGridView5 = DragGridView.this;
                dragGridView5.winViewDy = dragGridView5.mCurrentRawY - DragGridView.this.mCurrentY;
                DragGridView.this.selectView.destroyDrawingCache();
                DragGridView.this.selectView.setDrawingCacheEnabled(true);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(DragGridView.this.selectView.getDrawingCache());
                DragGridView dragGridView6 = DragGridView.this;
                dragGridView6.virtualImage = dragGridView6.showVirtualView(bitmapCreateBitmap, dragGridView6.mCurrentRawX + DragGridView.this.fingerDx, DragGridView.this.mCurrentRawY + DragGridView.this.fingerDy);
                DragGridView.this.selectView.setVisibility(4);
                DragGridView.access$1600(DragGridView.this);
            }
            DragGridView.this.requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TypeEvaluator<Point> {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Point evaluate(float f, Point point, Point point2) {
            return new Point(b(point.x, point2.x, f), b(point.y, point2.y, f));
        }

        public int b(int i, int i2, float f) {
            return (int) (((i2 - i) * f) + i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DragGridView.this.virtualImage == null || DragGridView.this.isDetachedFromWindow) {
                return;
            }
            Point point = (Point) valueAnimator.getAnimatedValue();
            DragGridView.this.windowParams.x = point.x;
            DragGridView.this.windowParams.y = point.y;
            DragGridView.this.windowManager.updateViewLayout(DragGridView.this.virtualImage, DragGridView.this.windowParams);
            DragGridView.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void e0();
    }

    public DragGridView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ gg1 access$1600(DragGridView dragGridView) {
        dragGridView.getClass();
        return null;
    }

    private void animateSwap(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.currentPosition;
        if (i < i2) {
            for (int i3 = i + 1; i3 <= this.currentPosition; i3++) {
                View childAt = getChildAt(i3 - getFirstVisiblePosition());
                if (i3 % getNumColumns() == 0) {
                    arrayList.add(createTranslationAnimations(childAt, childAt.getWidth() * (getNumColumns() - 1), 0.0f, -childAt.getHeight(), 0.0f));
                } else {
                    arrayList.add(createTranslationAnimations(childAt, -childAt.getWidth(), 0.0f, 0.0f, 0.0f));
                }
            }
        } else {
            while (i2 < i) {
                View childAt2 = getChildAt(i2 - getFirstVisiblePosition());
                i2++;
                if (i2 % getNumColumns() == 0) {
                    arrayList.add(createTranslationAnimations(childAt2, (-childAt2.getWidth()) * (getNumColumns() - 1), 0.0f, childAt2.getHeight(), 0.0f));
                } else {
                    arrayList.add(createTranslationAnimations(childAt2, childAt2.getWidth(), 0.0f, 0.0f, 0.0f));
                }
            }
        }
        this.currentPosition = i;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private Animator createTranslationAnimations(View view, float f2, float f3, float f4, float f5) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f2, f3);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", f4, f5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    private void endDrag() {
        WindowManager.LayoutParams layoutParams = this.windowParams;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new c(), new Point(layoutParams.x, layoutParams.y), new Point(this.winViewDx + this.selectView.getLeft(), this.winViewDy + this.selectView.getTop()));
        valueAnimatorOfObject.setDuration(150L);
        valueAnimatorOfObject.setInterpolator(new LinearInterpolator());
        valueAnimatorOfObject.addUpdateListener(new d());
        valueAnimatorOfObject.addListener(new e());
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeView() {
        View view = this.selectView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void setOnItemClickListener(MotionEvent motionEvent) {
        if (this.canDrag) {
            setOnItemLongClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView showVirtualView(Bitmap bitmap, int i, int i2) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowParams = layoutParams;
        layoutParams.gravity = 51;
        layoutParams.x = i;
        layoutParams.y = i2;
        layoutParams.alpha = 1.0f;
        layoutParams.width = (int) (bitmap.getWidth() * 1.1f);
        this.windowParams.height = (int) (bitmap.getHeight() * 1.1f);
        WindowManager.LayoutParams layoutParams2 = this.windowParams;
        layoutParams2.flags = 408;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = 0;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(bitmap);
        this.windowManager.addView(imageView, this.windowParams);
        return imageView;
    }

    private void swapItems(int i, int i2) {
        int iPointToPosition = pointToPosition(i, i2);
        if (iPointToPosition == ((fg1) getAdapter()).b() || iPointToPosition == -1 || iPointToPosition == this.currentPosition) {
            return;
        }
        this.isSwap = true;
        this.isEdit = false;
        resumeView();
        ((fg1) getAdapter()).a(this.currentPosition, iPointToPosition);
        View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
        this.selectView = childAt;
        childAt.setVisibility(4);
        animateSwap(iPointToPosition);
    }

    public void clicked(int i) {
        if (this.isEdit) {
            this.isEdit = false;
        } else {
            resumeView();
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDetachedFromWindow = true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        clicked(i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mCurrentX = (int) motionEvent.getX();
            this.mCurrentY = (int) motionEvent.getY();
            this.mCurrentRawX = (int) motionEvent.getRawX();
            this.mCurrentRawY = (int) motionEvent.getRawY();
            setOnItemClickListener(motionEvent);
        } else if (action == 1) {
            if (this.isDrag) {
                endDrag();
                f fVar = this.imgMoveCallback;
                if (fVar != null) {
                    fVar.e0();
                }
            }
        } else if (action != 2) {
            if (action == 3) {
            }
        } else if (this.isDrag) {
            this.windowParams.x = ((int) motionEvent.getRawX()) + this.fingerDx;
            this.windowParams.y = ((int) motionEvent.getRawY()) + this.fingerDy;
            this.windowManager.updateViewLayout(this.virtualImage, this.windowParams);
            invalidate();
            if (this.isSwap) {
                return false;
            }
            swapItems((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDrag(boolean z) {
        this.canDrag = z;
    }

    public void setImgMoveListener(f fVar) {
        this.imgMoveCallback = fVar;
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.originPosition = -1;
        this.currentPosition = -1;
        this.canDrag = true;
        this.isDetachedFromWindow = false;
        this.windowManager = (WindowManager) getContext().getSystemService("window");
        setOnItemClickListener(this);
        setSelector(new ColorDrawable(0));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DragGridView.this.isSwap = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DragGridView.this.isDrag = false;
            if (DragGridView.this.currentPosition != DragGridView.this.originPosition) {
                DragGridView.this.resumeView();
                DragGridView dragGridView = DragGridView.this;
                dragGridView.originPosition = dragGridView.currentPosition;
            }
            if (DragGridView.this.virtualImage != null) {
                DragGridView.this.windowManager.removeView(DragGridView.this.virtualImage);
                DragGridView.this.virtualImage = null;
            }
            DragGridView.this.selectView.setVisibility(0);
            DragGridView.access$1600(DragGridView.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

package com.zenmen.palmchat.mine.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.zenmen.palmchat.R;
import defpackage.a46;
import defpackage.me1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LoopTextView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private static final int FLAG_START_AUTO_SCROLL = 0;
    private static final int FLAG_STOP_AUTO_SCROLL = 1;
    private boolean autoRemove;
    private boolean autoScrollEnabled;
    private boolean bold;
    private int currentId;
    private boolean ellipse;
    private boolean fixAnimConflict;
    private int gravity;
    private Handler handler;
    private boolean hasConflict;
    boolean hasStart;
    private d itemClickListener;
    private c mAutoScrollListener;
    private Drawable mCompoundDrawable;
    private Context mContext;
    private int mPadding;
    private float mTextSize;
    public boolean needClickEvent;
    private TextPaint oneTextPaint;
    private boolean showCompoundDrawable;
    private int textColor;
    private ArrayList<String> textList;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14760a;

        public a(long j) {
            this.f14760a = j;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                LoopTextView.this.handler.removeMessages(0);
                return;
            }
            boolean z = LoopTextView.this.hasConflict;
            LoopTextView.this.hasConflict = false;
            if (LoopTextView.this.textList.size() > 0) {
                LoopTextView.this.currentId++;
                String str = (String) LoopTextView.this.textList.get(LoopTextView.this.currentId % LoopTextView.this.textList.size());
                if (z && LoopTextView.this.fixAnimConflict) {
                    LoopTextView.this.setCurrentText(str);
                } else {
                    LoopTextView.this.setText(str);
                    if (LoopTextView.this.mAutoScrollListener != null) {
                        LoopTextView.this.mAutoScrollListener.b(LoopTextView.this.currentId % LoopTextView.this.textList.size());
                    }
                }
            }
            LoopTextView loopTextView = LoopTextView.this;
            if (loopTextView.hasStart) {
                loopTextView.handler.sendEmptyMessageDelayed(0, this.f14760a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LoopTextView.this.itemClickListener != null) {
                LoopTextView.this.itemClickListener.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void b(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();
    }

    public LoopTextView(Context context) {
        this(context, null);
    }

    public void enableAutoScroll(boolean z) {
        this.autoScrollEnabled = z;
    }

    public void fixAnimConflict(boolean z) {
        this.fixAnimConflict = z;
    }

    public TextPaint getTextPaint() {
        return this.oneTextPaint;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        Drawable drawable;
        TextView textView = new TextView(this.mContext);
        this.oneTextPaint = textView.getPaint();
        textView.setGravity(this.gravity | 16);
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        if (this.ellipse) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        int i = this.mPadding;
        textView.setPadding(i, i, i, i);
        textView.setTextColor(this.textColor);
        textView.setTextSize(this.mTextSize);
        if (this.showCompoundDrawable && (drawable = this.mCompoundDrawable) != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.mCompoundDrawable.getMinimumHeight());
            textView.setCompoundDrawables(null, null, this.mCompoundDrawable, null);
            textView.setCompoundDrawablePadding(a46.b(this.mContext, 6.0f));
        }
        if (this.needClickEvent) {
            textView.setClickable(true);
            textView.setOnClickListener(new b());
        }
        return textView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoScrollEnabled) {
            startAutoScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.autoScrollEnabled) {
            stopAutoScroll();
        }
        if (this.autoRemove) {
            remove();
        }
    }

    public void remove() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void setAnim() {
        setInAnimation(getContext(), R.anim.vip_text_des_enter);
        setOutAnimation(getContext(), R.anim.vip_text_des_exit);
    }

    public void setAnimTime(long j) {
        setFactory(this);
        setInAnimation(getContext(), R.anim.vip_text_des_enter);
        setOutAnimation(getContext(), R.anim.vip_text_des_exit);
    }

    public void setAutoRemove(boolean z) {
        this.autoRemove = z;
    }

    public void setAutoScrollListener(c cVar) {
        this.mAutoScrollListener = cVar;
    }

    public void setBold(boolean z) {
        this.bold = z;
    }

    public void setCompoundDrawableInfo(boolean z, Drawable drawable) {
        this.showCompoundDrawable = z;
        this.mCompoundDrawable = drawable;
    }

    public void setEllipsize(boolean z) {
        this.ellipse = z;
    }

    public void setFactory() {
        setFactory(this);
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    public void setNoAnim() {
        clearAnimation();
    }

    public void setOnItemClickListener(d dVar) {
        this.itemClickListener = dVar;
    }

    public void setText(float f, int i, int i2, int i3) {
        this.mTextSize = me1.p(this.mContext, f);
        this.mPadding = i;
        this.textColor = i2;
        this.gravity = i3;
    }

    public void setTextList(ArrayList<String> arrayList) {
        boolean zEquals = this.textList.equals(arrayList);
        this.textList.clear();
        this.textList.addAll(arrayList);
        if (zEquals && arrayList.size() >= 2 && this.currentId == 0) {
            this.currentId = 0;
        } else {
            this.currentId = -1;
        }
    }

    public void setTextStillTime(long j) {
        this.handler = new a(j);
    }

    public void startAutoScroll() {
        if (this.hasStart) {
            return;
        }
        this.hasStart = true;
        this.hasConflict = true;
        this.handler.sendEmptyMessage(0);
    }

    public void stopAutoScroll() {
        this.hasStart = false;
        this.handler.removeMessages(0);
    }

    public LoopTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextSize = 16.0f;
        this.mPadding = 5;
        this.textColor = -16777216;
        this.currentId = -1;
        this.needClickEvent = true;
        this.autoScrollEnabled = false;
        this.fixAnimConflict = false;
        this.hasConflict = false;
        this.showCompoundDrawable = false;
        this.bold = false;
        this.mCompoundDrawable = null;
        this.ellipse = true;
        this.autoRemove = true;
        this.hasStart = false;
        this.mContext = context;
        this.textList = new ArrayList<>();
    }
}

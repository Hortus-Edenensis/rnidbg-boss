package com.zenmen.palmchat.ui.widget.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.FullTextActivity;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$styleable;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e55;
import defpackage.k36;
import defpackage.mr;
import defpackage.vl1;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ClickShowMoreLayout extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    public static final int CLOSE = 0;
    public static final int FULL = 2;
    public static final int OPEN = 1;
    private static final String TAG = "ClickShowMoreLayout";
    public static final int TYPE_COPY = 2;
    private static final int TYPE_OPEN = 1;
    private boolean TEXT_sync;
    public f clickListener;
    private String clickText;
    private long feed;
    private Long feedId;
    private TextView mClickToShow;
    private Context mContext;
    private mr.f mDismissListener;
    private TextView mFullTextView;
    private boolean mHasLimit;
    private g mOnStateKeyGenerateListener;
    private TextView mTextView;
    private ViewTreeObserver.OnDrawListener onDrawListener;
    private boolean oneLineLimit;
    private e55 selectAllPopup;
    private int showMaxLine;
    private int suffixColor;
    private h textClickListener;
    private int textColor;
    private int textSize;
    private static final SparseIntArray TEXT_STATE = new SparseIntArray();
    public static Map<Long, Integer> TEXT = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickShowMoreLayout.this.textClickListener != null) {
                ClickShowMoreLayout.this.textClickListener.onClick();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickShowMoreLayout.this.textClickListener != null) {
                ClickShowMoreLayout.this.textClickListener.onClick();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewTreeObserver.OnDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            ClickShowMoreLayout.this.removeOnDrawListener();
            if (!ClickShowMoreLayout.this.mHasLimit) {
                ClickShowMoreLayout.this.mClickToShow.setVisibility(8);
                ClickShowMoreLayout.this.mTextView.setMaxLines(Integer.MAX_VALUE);
                return;
            }
            if (ClickShowMoreLayout.this.oneLineLimit && ClickShowMoreLayout.this.mTextView.getLineCount() > 20) {
                ClickShowMoreLayout.this.mTextView.setMaxLines(1);
                ClickShowMoreLayout.this.mClickToShow.setVisibility(8);
                ClickShowMoreLayout.this.setTextState(2);
            } else {
                if (ClickShowMoreLayout.this.mTextView.getLineCount() <= ClickShowMoreLayout.this.showMaxLine) {
                    ClickShowMoreLayout.this.mClickToShow.setVisibility(8);
                    ClickShowMoreLayout.this.mTextView.setMaxLines(Integer.MAX_VALUE);
                    return;
                }
                ClickShowMoreLayout.this.mClickToShow.setVisibility(0);
                ClickShowMoreLayout.this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
                ClickShowMoreLayout.this.mTextView.setMaxLines(ClickShowMoreLayout.this.showMaxLine);
                if (!ClickShowMoreLayout.this.TEXT_sync) {
                    ClickShowMoreLayout.this.setTextState(0);
                } else {
                    ClickShowMoreLayout clickShowMoreLayout = ClickShowMoreLayout.this;
                    clickShowMoreLayout.setTextState(ClickShowMoreLayout.TEXT.containsKey(Long.valueOf(clickShowMoreLayout.feed)) ? ClickShowMoreLayout.TEXT.get(Long.valueOf(ClickShowMoreLayout.this.feed)).intValue() : 0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = ClickShowMoreLayout.this.mTextView.getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return;
            }
            viewTreeObserver.removeOnDrawListener(ClickShowMoreLayout.this.onDrawListener);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends mr.f {
        public e() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ClickShowMoreLayout clickShowMoreLayout = ClickShowMoreLayout.this;
            if (clickShowMoreLayout.getState(clickShowMoreLayout.getText().toString()) == 2) {
                ClickShowMoreLayout.this.mTextView.setBackgroundColor(Color.parseColor("#f1f1f1"));
            } else {
                ClickShowMoreLayout.this.mTextView.setBackgroundColor(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        int a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void onClick();
    }

    public ClickShowMoreLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getState(String str) {
        int i = TEXT_STATE.get(getStateKey(str), -1);
        if (i != -1) {
            return i;
        }
        return 0;
    }

    private int getStateKey(String str) {
        if (str == null) {
            return -1;
        }
        ViewParent parent = getParent();
        int iHashCode = str.hashCode() + (parent != null ? parent.hashCode() : 0);
        g gVar = this.mOnStateKeyGenerateListener;
        return gVar != null ? gVar.a(iHashCode) : iHashCode;
    }

    private void initView(Context context) {
        this.mTextView = new TextView(context);
        this.mClickToShow = new TextView(context);
        this.mTextView.setTextSize(1, this.textSize);
        this.mTextView.setTextColor(this.textColor);
        this.mTextView.setMaxLines(this.showMaxLine);
        this.mTextView.setOnLongClickListener(this);
        this.mTextView.setOnClickListener(new a());
        this.mClickToShow.setBackgroundDrawable(getResources().getDrawable(R$drawable.selector_tx_show_more));
        this.mClickToShow.setTextSize(1, this.textSize);
        this.mClickToShow.setTextColor(this.suffixColor);
        this.mClickToShow.setText(this.clickText);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = k36.b(5.0f);
        this.mClickToShow.setLayoutParams(layoutParams);
        this.mClickToShow.setOnClickListener(this);
        setOrientation(1);
        addView(this.mTextView);
        addView(this.mClickToShow);
        TextView textView = new TextView(context);
        this.mFullTextView = textView;
        textView.setTextSize(1, this.textSize);
        this.mFullTextView.setTextColor(this.textColor);
        this.mFullTextView.setOnLongClickListener(this);
        this.mFullTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.mFullTextView.setSingleLine();
        this.mFullTextView.setBackgroundColor(Color.parseColor("#f1f1f1"));
        this.mFullTextView.setVisibility(8);
        addView(this.mFullTextView);
        if (this.selectAllPopup == null) {
            this.selectAllPopup = new e55((Activity) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOnDrawListener() {
        if (this.onDrawListener != null) {
            post(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextState(int i) {
        if (i == 0) {
            this.mTextView.setMaxLines(this.showMaxLine);
            this.mClickToShow.setText(this.clickText);
            this.mTextView.setBackgroundColor(0);
            this.mTextView.setOnClickListener(new b());
        } else if (i == 1) {
            this.mTextView.setMaxLines(Integer.MAX_VALUE);
            this.mClickToShow.setText("收起");
            this.mTextView.setBackgroundColor(0);
        } else if (i == 2) {
            this.mTextView.setMaxLines(1);
            this.mTextView.setBackgroundColor(Color.parseColor("#f1f1f1"));
            this.mTextView.setEnabled(true);
        }
        if (this.TEXT_sync) {
            TEXT.put(Long.valueOf(this.feed), Integer.valueOf(i));
        }
    }

    public CharSequence getText() {
        return this.mTextView.getText();
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public void gotoTextActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(this.mContext, FullTextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(FullTextActivity.u, str);
        intent.putExtras(bundle);
        this.mContext.startActivity(intent);
    }

    public boolean ismHasLimit() {
        return this.mHasLimit;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zEquals = TextUtils.equals(((TextView) view).getText().toString(), this.clickText);
        setTextState(zEquals ? 1 : 0);
        if (!zEquals || this.feedId == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feed_id", this.feedId);
            jSONObject.put("type", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("M33", "1", null, jSONObject.toString());
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        view.setBackgroundColor(Color.parseColor("#e4e4e4"));
        int height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height2 = (height - iArr[1]) - view.getHeight();
        LogUtil.i(TAG, "heightToBottom = " + height2);
        this.selectAllPopup.R(view, getText().toString(), ((float) height2) >= this.mContext.getResources().getDisplayMetrics().density * 60.0f);
        this.selectAllPopup.Q(this.feedId);
        this.selectAllPopup.J(this.mDismissListener);
        return true;
    }

    public void setFeedId(long j) {
        this.feedId = Long.valueOf(j);
    }

    public void setOnStateKeyGenerateListener(g gVar) {
        this.mOnStateKeyGenerateListener = gVar;
    }

    public void setText(CharSequence charSequence, long j) {
        this.mTextView.setEllipsize(null);
        this.feed = j;
        ViewTreeObserver viewTreeObserver = this.mTextView.getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            if (this.onDrawListener == null) {
                this.onDrawListener = new c();
            }
            viewTreeObserver.addOnDrawListener(this.onDrawListener);
        }
        this.mTextView.setText(vl1.c(charSequence, this.mContext, vl1.i));
        int iIntValue = TEXT.containsKey(Long.valueOf(this.feed)) ? TEXT.get(Long.valueOf(this.feed)).intValue() : 0;
        if (this.TEXT_sync) {
            setTextState(iIntValue);
        } else {
            setTextState(0);
        }
        this.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setTextClickListener(h hVar) {
        this.textClickListener = hVar;
    }

    public void setTextColor(int i) {
        this.textColor = i;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        this.textSize = i;
    }

    public void setmHasLimit(boolean z) {
        this.mHasLimit = z;
    }

    public ClickShowMoreLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickShowMoreLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasLimit = true;
        this.oneLineLimit = true;
        this.TEXT_sync = true;
        this.onDrawListener = null;
        this.mDismissListener = new e();
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClickShowMoreLayout);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ClickShowMoreLayout_text_color, -13684945);
        this.suffixColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ClickShowMoreLayout_suffix_color, -10058816);
        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClickShowMoreLayout_text_size, 16);
        this.clickText = typedArrayObtainStyledAttributes.getString(R$styleable.ClickShowMoreLayout_click_text);
        this.showMaxLine = typedArrayObtainStyledAttributes.getInt(R$styleable.ClickShowMoreLayout_show_line, 6);
        int i2 = R$styleable.ClickShowMoreLayout_oneline_limit;
        this.oneLineLimit = typedArrayObtainStyledAttributes.getBoolean(i2, true);
        this.TEXT_sync = typedArrayObtainStyledAttributes.getBoolean(i2, true);
        if (TextUtils.isEmpty(this.clickText)) {
            this.clickText = "全文";
        }
        typedArrayObtainStyledAttributes.recycle();
        initView(context);
    }

    public void setClickListener(f fVar) {
    }
}

package com.zenmen.palmchat.ui.widget.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.FullTextActivity;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$styleable;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.e55;
import defpackage.k36;
import defpackage.mr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NoClickShowMoreLayout extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    public static final int CLOSE = 0;
    public static final int FULL = 2;
    public static final int OPEN = 1;
    private static final String TAG = "ClickShowMoreLayout";
    private static final SparseIntArray TEXT_STATE = new SparseIntArray();
    public static final int TYPE_COPY = 2;
    private static final int TYPE_OPEN = 1;
    private String clickText;
    private Long feedId;
    private TextView mClickToShow;
    private Context mContext;
    private mr.f mDismissListener;
    private TextView mFullTextView;
    private e mOnStateKeyGenerateListener;
    private TextView mTextView;
    private e55 selectAllPopup;
    private int textColor;
    private int textSize;

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NoClickShowMoreLayout noClickShowMoreLayout = NoClickShowMoreLayout.this;
            noClickShowMoreLayout.gotoTextActivity(noClickShowMoreLayout.getText().toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends mr.f {
        public d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            NoClickShowMoreLayout noClickShowMoreLayout = NoClickShowMoreLayout.this;
            if (noClickShowMoreLayout.getState(noClickShowMoreLayout.getText().toString()) == 2) {
                NoClickShowMoreLayout.this.mTextView.setBackgroundColor(Color.parseColor("#f1f1f1"));
            } else {
                NoClickShowMoreLayout.this.mTextView.setBackgroundColor(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
    }

    public NoClickShowMoreLayout(Context context) {
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
        return str.hashCode() + (parent != null ? parent.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoTextActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(this.mContext, FullTextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(FullTextActivity.u, str);
        intent.putExtras(bundle);
        this.mContext.startActivity(intent);
    }

    private void initView(Context context) {
        this.mTextView = new TextView(context);
        this.mClickToShow = new TextView(context);
        this.mTextView.setTextSize(this.textSize);
        this.mTextView.setTextColor(this.textColor);
        this.mTextView.setOnLongClickListener(this);
        this.mClickToShow.setBackgroundDrawable(getResources().getDrawable(R$drawable.selector_tx_show_more));
        this.mClickToShow.setTextSize(this.textSize);
        this.mClickToShow.setTextColor(getResources().getColor(R$color.nick));
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
        textView.setTextSize(this.textSize);
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

    private void restoreState(String str) {
        int stateKey = getStateKey(str);
        int i = TEXT_STATE.get(stateKey, -1);
        if (i == -1) {
            i = 0;
        }
        setStateInternal(stateKey, i);
    }

    private void setStateInternal(int i, int i2) {
        if (i2 == 0) {
            this.mTextView.setMaxLines(6);
            this.mClickToShow.setText(this.clickText);
            this.mTextView.setBackgroundColor(0);
            this.mTextView.setOnClickListener(new a());
        } else if (i2 == 1) {
            this.mTextView.setMaxLines(Integer.MAX_VALUE);
            this.mClickToShow.setText("收起");
            this.mTextView.setBackgroundColor(0);
            this.mTextView.setOnClickListener(new b());
        } else if (i2 == 2) {
            this.mTextView.setMaxLines(1);
            this.mTextView.setBackgroundColor(Color.parseColor("#f1f1f1"));
            this.mTextView.setEnabled(true);
            this.mTextView.setOnClickListener(new c());
        }
        TEXT_STATE.put(i, i2);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zEquals = TextUtils.equals(((TextView) view).getText().toString(), this.clickText);
        setState(zEquals ? 1 : 0);
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

    public void setState(int i) {
        setStateInternal(getStateKey(getText().toString()), i);
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

    public NoClickShowMoreLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoClickShowMoreLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDismissListener = new d();
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClickShowMoreLayout);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ClickShowMoreLayout_text_color, -13684945);
        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClickShowMoreLayout_text_size, 15);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.ClickShowMoreLayout_click_text);
        this.clickText = string;
        if (TextUtils.isEmpty(string)) {
            this.clickText = "全文";
        }
        typedArrayObtainStyledAttributes.recycle();
        initView(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public void setOnStateKeyGenerateListener(e eVar) {
    }
}

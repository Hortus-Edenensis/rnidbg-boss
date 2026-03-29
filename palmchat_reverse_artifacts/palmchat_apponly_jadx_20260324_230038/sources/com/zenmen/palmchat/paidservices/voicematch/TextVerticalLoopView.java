package com.zenmen.palmchat.paidservices.voicematch;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TextVerticalLoopView extends ViewSwitcher implements ViewSwitcher.ViewFactory {
    private static final int FLAG_START_AUTO_SCROLL = 0;
    private static final int FLAG_STOP_AUTO_SCROLL = 1;
    private ArrayList<String> allDataList;
    private int allDataNum;
    private boolean autoScrollEnabled;
    private int currentId;
    private String currentShowTemplate;
    private boolean fixAnimConflict;
    private Handler handler;
    private boolean hasConflict;
    boolean hasStart;
    private c itemClickListener;
    private b mAutoScrollListener;
    private Context mContext;
    private int mTextColor;
    private float mTextSize;
    private boolean showClose;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14882a;

        public a(long j) {
            this.f14882a = j;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    TextVerticalLoopView.this.handler.removeMessages(0);
                    return;
                }
                boolean z = TextVerticalLoopView.this.hasConflict;
                TextVerticalLoopView.this.hasConflict = false;
                if (TextVerticalLoopView.this.allDataNum > 0) {
                    String itemForShow = TextVerticalLoopView.this.getItemForShow();
                    if ((z && TextVerticalLoopView.this.fixAnimConflict) || TextVerticalLoopView.this.allDataNum == 1) {
                        View currentView = TextVerticalLoopView.this.getCurrentView();
                        if (currentView instanceof TextView) {
                            ((TextView) currentView).setText(itemForShow);
                        }
                    } else {
                        View nextView = TextVerticalLoopView.this.getNextView();
                        if (nextView instanceof TextView) {
                            ((TextView) nextView).setText(itemForShow);
                            TextVerticalLoopView.this.showNext();
                        }
                        TextVerticalLoopView.e(TextVerticalLoopView.this);
                    }
                }
                TextVerticalLoopView textVerticalLoopView = TextVerticalLoopView.this;
                if (textVerticalLoopView.hasStart) {
                    textVerticalLoopView.handler.sendEmptyMessageDelayed(0, this.f14882a);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public TextVerticalLoopView(Context context, float f) {
        this(context, f, Color.parseColor("#999999"));
    }

    public static /* bridge */ /* synthetic */ b e(TextVerticalLoopView textVerticalLoopView) {
        textVerticalLoopView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getItemForShow() {
        int i = this.currentId + 1;
        this.currentId = i;
        if (i >= this.allDataNum || i < 0) {
            this.currentId = 0;
        }
        LogUtil.d("SuperExpose", "setTextStillTime handleMessage currentId " + this.currentId);
        String str = this.allDataList.get(this.currentId);
        this.currentShowTemplate = str;
        return str;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(1, this.mTextSize);
        textView.setTextColor(this.mTextColor);
        textView.setWidth(me1.g());
        textView.setGravity(17);
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
        remove();
    }

    public void remove() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void setAnimTime(long j) {
        setFactory(this);
        setInAnimation(getContext(), R.anim.super_expose_text_des_enter);
        setOutAnimation(getContext(), R.anim.super_expose_text_des_exit);
    }

    public void setDataList(ArrayList<String> arrayList) {
        try {
            this.allDataList.clear();
            this.allDataList.addAll(arrayList);
            this.allDataNum = this.allDataList.size();
            String str = this.currentShowTemplate;
            String str2 = arrayList.get(0);
            if (str == null || !str.equals(str2)) {
                this.currentId = -1;
                if (this.hasStart) {
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessage(0);
                }
            }
            LogUtil.d("SuperExpose", "SuperExposeAllLoopLayout setDataList allDataNum " + this.allDataNum);
        } catch (Exception unused) {
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
        this.handler.sendEmptyMessageDelayed(0, 2000L);
    }

    public void stopAutoScroll() {
        this.hasStart = false;
        this.handler.removeMessages(0);
    }

    public TextVerticalLoopView(Context context, float f, int i) {
        super(context);
        this.mTextSize = 12.0f;
        this.mTextColor = 0;
        this.currentId = -1;
        this.allDataNum = -1;
        this.autoScrollEnabled = false;
        this.fixAnimConflict = false;
        this.hasConflict = false;
        this.currentShowTemplate = null;
        this.hasStart = false;
        this.mContext = context;
        this.allDataList = new ArrayList<>();
        this.currentId = -1;
        this.mTextSize = f;
        this.mTextColor = i;
    }

    public void setAutoScrollListener(b bVar) {
    }

    public void setOnItemClickListener(c cVar) {
    }
}

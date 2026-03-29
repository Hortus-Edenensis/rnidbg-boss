package com.zenmen.palmchat.paidservices.superexpose.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ViewSwitcher;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.Template;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.vn5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeLoopAllLayout extends ViewSwitcher implements ViewSwitcher.ViewFactory {
    private static final int FLAG_START_AUTO_SCROLL = 0;
    private static final int FLAG_STOP_AUTO_SCROLL = 1;
    private ArrayList<Template> allDataList;
    private int allDataNum;
    private boolean autoScrollEnabled;
    private vn5 closeCall;
    private int currentId;
    private Template currentShowTemplate;
    private boolean fixAnimConflict;
    private Handler handler;
    private boolean hasConflict;
    boolean hasStart;
    private c itemClickListener;
    private b mAutoScrollListener;
    private Context mContext;
    private float mTextSize;
    private boolean showClose;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14872a;

        public a(long j) {
            this.f14872a = j;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    SuperExposeLoopAllLayout.this.handler.removeMessages(0);
                    return;
                }
                boolean z = SuperExposeLoopAllLayout.this.hasConflict;
                SuperExposeLoopAllLayout.this.hasConflict = false;
                if (SuperExposeLoopAllLayout.this.allDataNum > 0) {
                    Template itemForShow = SuperExposeLoopAllLayout.this.getItemForShow();
                    if ((!z || !SuperExposeLoopAllLayout.this.fixAnimConflict) && SuperExposeLoopAllLayout.this.allDataNum != 1) {
                        View nextView = SuperExposeLoopAllLayout.this.getNextView();
                        if (nextView instanceof SuperExposeLoopItemLayout) {
                            ((SuperExposeLoopItemLayout) nextView).setData(itemForShow);
                            SuperExposeLoopAllLayout.this.showNext();
                        }
                        SuperExposeLoopAllLayout.e(SuperExposeLoopAllLayout.this);
                    } else if (!itemForShow.isLoadData) {
                        View currentView = SuperExposeLoopAllLayout.this.getCurrentView();
                        if (currentView instanceof SuperExposeLoopItemLayout) {
                            ((SuperExposeLoopItemLayout) currentView).setData(itemForShow);
                        }
                    }
                }
                SuperExposeLoopAllLayout superExposeLoopAllLayout = SuperExposeLoopAllLayout.this;
                if (superExposeLoopAllLayout.hasStart) {
                    superExposeLoopAllLayout.handler.sendEmptyMessageDelayed(0, this.f14872a);
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

    public SuperExposeLoopAllLayout(Context context, float f, boolean z, vn5 vn5Var) {
        super(context);
        this.mTextSize = 12.0f;
        this.currentId = -1;
        this.allDataNum = -1;
        this.autoScrollEnabled = false;
        this.fixAnimConflict = false;
        this.hasConflict = false;
        this.closeCall = null;
        this.currentShowTemplate = null;
        this.hasStart = false;
        this.mContext = context;
        this.allDataList = new ArrayList<>();
        this.currentId = -1;
        this.mTextSize = f;
        this.showClose = z;
        this.closeCall = vn5Var;
    }

    public static /* bridge */ /* synthetic */ b e(SuperExposeLoopAllLayout superExposeLoopAllLayout) {
        superExposeLoopAllLayout.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Template getItemForShow() {
        int i = this.currentId + 1;
        this.currentId = i;
        if (i >= this.allDataNum || i < 0) {
            this.currentId = 0;
        }
        LogUtil.d("SuperExpose", "setTextStillTime handleMessage currentId " + this.currentId);
        Template template = this.allDataList.get(this.currentId);
        this.currentShowTemplate = template;
        return template;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        SuperExposeLoopItemLayout superExposeLoopItemLayout = new SuperExposeLoopItemLayout(this.mContext, this.showClose, this.closeCall);
        superExposeLoopItemLayout.setTextSize(this.mTextSize);
        return superExposeLoopItemLayout;
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

    public void setDataList(ArrayList<Template> arrayList) {
        try {
            this.allDataList.clear();
            this.allDataList.addAll(arrayList);
            this.allDataNum = this.allDataList.size();
            String strC = az2.c(this.currentShowTemplate);
            String strC2 = az2.c(arrayList.get(0));
            if (strC == null || !strC.equals(strC2)) {
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

    public void setAutoScrollListener(b bVar) {
    }

    public void setOnItemClickListener(c cVar) {
    }
}

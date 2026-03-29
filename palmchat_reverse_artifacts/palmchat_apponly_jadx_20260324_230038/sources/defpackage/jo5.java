package defpackage;

import android.content.Context;
import android.widget.FrameLayout;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTagCItemModel;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabUiViewA;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabUiViewB;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabUiViewC;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabUiViewTaiJiB;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadHeaderViewV5 f18456a;
    public Context b;
    public bo5 e;
    public FrameLayout c = null;
    public int d = -1;
    public MsgTabBaseUiView f = null;

    public jo5(Context context, ThreadHeaderViewV5 threadHeaderViewV5, bo5 bo5Var) {
        this.b = null;
        this.e = null;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabView start");
        this.b = context;
        this.f18456a = threadHeaderViewV5;
        this.e = bo5Var;
        b();
    }

    public void a(int i) {
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            if (i == 0) {
                if (frameLayout.getVisibility() == 8) {
                    this.c.setVisibility(0);
                }
            } else if (frameLayout.getVisibility() == 0) {
                this.c.setVisibility(8);
            }
        }
    }

    public final void b() {
        this.c = (FrameLayout) this.f18456a.findViewById(R.id.super_expose_msg_tab_root);
    }

    public void c() {
        MsgTabBaseUiView msgTabBaseUiView = this.f;
        if (msgTabBaseUiView != null) {
            msgTabBaseUiView.onDestroy();
        }
    }

    public void d(int i, SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        String str;
        ArrayList<SuperExposeMsgTagCItemModel> arrayList;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabView SuperExposeMsgTabViewT SuperExpose7TaiJi showTabUi type " + i + " msgTabInfo " + superExposeMsgTabInfo + " mCurShowType " + this.d + " mAllLayout " + this.c);
        FrameLayout frameLayout = this.c;
        if (frameLayout == null) {
            return;
        }
        if (i == -1) {
            frameLayout.removeAllViews();
            MsgTabBaseUiView msgTabBaseUiView = this.f;
            if (msgTabBaseUiView != null) {
                msgTabBaseUiView.onDestroy();
                return;
            }
            return;
        }
        MsgTabBaseUiView msgTabUiViewTaiJiB = null;
        if (this.d != i) {
            b05.d("0创建UI");
            this.c.removeAllViews();
            MsgTabBaseUiView msgTabBaseUiView2 = this.f;
            if (msgTabBaseUiView2 != null) {
                msgTabBaseUiView2.onDestroy();
            }
            if (i == 1) {
                msgTabUiViewTaiJiB = new MsgTabUiViewA(this.b);
            } else if (i == 2) {
                msgTabUiViewTaiJiB = new MsgTabUiViewB(this.b, true);
            } else if (i == 3) {
                msgTabUiViewTaiJiB = new MsgTabUiViewC(this.b, -1, true);
            } else if (i == 4) {
                msgTabUiViewTaiJiB = new MsgTabUiViewC(this.b, 1, true);
            } else if (i == 5) {
                msgTabUiViewTaiJiB = new MsgTabUiViewC(this.b, -1, false);
            } else if (i == 6) {
                msgTabUiViewTaiJiB = new MsgTabUiViewTaiJiB(this.b, WkAdxAdConfigMg.DSP_NAME_BAIDU);
            } else if (i == 7) {
                msgTabUiViewTaiJiB = new MsgTabUiViewTaiJiB(this.b, WkAdxAdConfigMg.DSP_NAME_CSJ);
            }
            if (msgTabUiViewTaiJiB != null) {
                msgTabUiViewTaiJiB.initItemView(this.e);
                this.d = i;
                this.c.addView(msgTabUiViewTaiJiB, new FrameLayout.LayoutParams(-1, -2));
                if (superExposeMsgTabInfo == null || (arrayList = superExposeMsgTabInfo.dataList) == null || arrayList.size() <= 0) {
                    str = "";
                } else {
                    str = "";
                    for (int i2 = 0; i2 < superExposeMsgTabInfo.dataList.size(); i2++) {
                        str = str + superExposeMsgTabInfo.dataList.get(i2).uid;
                        if (i2 != superExposeMsgTabInfo.dataList.size() - 1) {
                            str = str + ",";
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("showuid", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.g("boost_message_promotion_show", jSONObject);
            }
        } else {
            if (frameLayout.getChildCount() > 0 && (this.c.getChildAt(0) instanceof MsgTabBaseUiView)) {
                msgTabUiViewTaiJiB = (MsgTabBaseUiView) this.c.getChildAt(0);
            }
            b05.d("1创建UI");
        }
        LogUtil.d("", "SuperExposeMsgTabViewT requestSuperExposeInfo uiView " + msgTabUiViewTaiJiB);
        if (msgTabUiViewTaiJiB != null) {
            msgTabUiViewTaiJiB.setData(superExposeMsgTabInfo, superExposeInfo, z, z2);
        }
        this.f = msgTabUiViewTaiJiB;
    }

    public void e(boolean z) {
        MsgTabBaseUiView msgTabBaseUiView = this.f;
        if (msgTabBaseUiView != null) {
            msgTabBaseUiView.visibleShow(z);
        }
    }
}

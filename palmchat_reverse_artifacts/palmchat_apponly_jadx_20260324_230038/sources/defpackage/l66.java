package defpackage;

import android.app.Activity;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class l66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o22 f18918a;
    public int b = -1;
    public ArrayList<Float> c = null;
    public List<SquareFeed> d;

    public l66(Activity activity, o22 o22Var, List<SquareFeed> list, String str, int i) {
        this.f18918a = null;
        this.d = null;
        if (p66.b.size() == 0) {
            p66.b.add(Float.valueOf(-0.5f));
            p66.b.add(Float.valueOf(0.5f));
        }
        ds0.a().c(this);
        this.f18918a = o22Var;
        this.d = list;
        o22Var.w(this);
        q66.c = i;
        LogUtil.d("UserDetailAd", "UserDetailAdControlV2L init ");
        q66.d(activity, str, true);
    }

    public final void a(int i) {
        boolean z;
        if (i != -1) {
            try {
                ArrayList<Float> arrayList = this.c;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                float f = i;
                float f2 = f - 0.5f;
                float f3 = f + 0.5f;
                LogUtil.d("UserDetailAd", "UserDetailAdControlV2L checkAdPosition 开始判断上下位置是否满足 lastPosition " + f2 + " nextPosition " + f3 + " mAdStartPosition " + this.b);
                boolean zContains = this.c.contains(Float.valueOf(f2));
                boolean z2 = false;
                if (zContains) {
                    int i2 = i <= 0 ? 0 : i;
                    this.d.add(i2, b(i2));
                    LogUtil.d("UserDetailAd", "UserDetailAdControlV2L checkAdPosition 上个位置满足 lastSuccess adTargetP " + i2);
                    z = true;
                } else {
                    z = false;
                }
                if (this.c.contains(Float.valueOf(f3))) {
                    int size = i + 1;
                    if (z) {
                        size++;
                    }
                    if (size > this.d.size()) {
                        size = this.d.size();
                    }
                    this.d.add(size, b(size));
                    LogUtil.d("UserDetailAd", "UserDetailAdControlV2L checkAdPosition next 下个位置满足 adTargetP " + size);
                    z2 = true;
                }
                if (z2 || z) {
                    LogUtil.d("UserDetailAd", "UserDetailAdControlV2L checkAdPosition success 广告位置塞入成功");
                    this.f18918a.g(this.d);
                    if (z) {
                        this.f18918a.x(i + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final SquareFeed b(int i) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.adKey = Integer.valueOf(i + new Random().nextInt(10000));
        return squareFeed;
    }

    public final int c() {
        LogUtil.d("UserDetailAd", "UserDetailAdControlV2L createAdFirstPosition 获取广告的初始位置 " + q66.c + " mAdStartPosition " + this.b);
        int i = q66.c;
        if (i == -1 || this.b != -1) {
            return -1;
        }
        return i;
    }

    public final ArrayList<Float> d(int i) {
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < p66.b.size(); i2++) {
            float fFloatValue = p66.b.get(i2).floatValue() + i;
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L 获取新的广告位置 createRealAdPosition i " + i2 + " result " + fFloatValue);
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public final void e(int i) {
        if (this.b == -1) {
            int iC = c();
            this.b = iC;
            if (iC != -1) {
                this.c = d(iC);
            }
        }
        LogUtil.d("UserDetailAd", "UserDetailAdControlV2L insertAdData 准备塞入广告位置 起始位置为：" + this.b + " mAdpositionsV2New " + this.c + " curFeedPosition " + i);
        if (this.c != null) {
            a(i);
        }
    }

    public void f() {
        ds0.a().d(this);
        q66.c();
        if (!b6.d()) {
            if (b6.v) {
                SPCacheManager.INSTANCE.clearCacheAd(82);
            }
        } else if (b6.v || b6.e("UserDrawDetailV2")) {
            SPCacheManager.INSTANCE.clearCacheAd(82);
        }
    }

    @qm5
    public void onAdLoadEvent(s66 s66Var) {
        if (s66Var == null) {
            return;
        }
        int i = q66.c;
        LogUtil.d("UserDetailAd", "UserDetailAdControlV2L onAdLoadEvent 收到EventBus mAdStartPosition " + this.b + " event.getType() " + s66Var.a() + " curFeedPosition " + i);
        if (s66Var.a() == 1) {
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L onAdLoadEvent 有广告召回 ");
            e(i);
            return;
        }
        if (s66Var.a() == 2) {
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L onAdLoadEvent 若此时mAllData里有广告的占坑，先删除占坑 ");
            if (this.d != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < this.d.size(); i2++) {
                        SquareFeed squareFeed = this.d.get(i2);
                        if (squareFeed.adKey != null) {
                            arrayList.add(squareFeed);
                            if (i2 < i) {
                                arrayList2.add(squareFeed);
                            }
                        }
                    }
                    int size = arrayList.size();
                    int size2 = arrayList2.size();
                    if (size > 0) {
                        this.d.removeAll(arrayList);
                        this.f18918a.g(this.d);
                        i -= size2;
                        this.f18918a.x(i);
                    }
                    arrayList.clear();
                    arrayList2.clear();
                    LogUtil.d("UserDetailAd", "UserDetailAdControlV2L TYPE_ADREMOVE 删除结束 adFeeds size " + size + " UserDetailRequestManager.mCurAdData " + q66.b + " newCurPosition " + i + " lastSize " + size2);
                    if (q66.b != null) {
                        e(i);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}

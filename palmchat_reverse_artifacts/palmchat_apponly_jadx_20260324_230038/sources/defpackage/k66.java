package defpackage;

import android.app.Activity;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class k66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o22 f18586a;
    public int d;
    public ArrayList<Integer> b = new ArrayList<>();
    public ArrayList<Integer> c = new ArrayList<>();
    public int e = 0;
    public int f = 0;

    public k66(Activity activity, o22 o22Var, int i, int i2, String str) {
        this.f18586a = null;
        this.f18586a = o22Var;
        this.d = i;
        o22Var.v(this);
        LogUtil.d("UserDetailAd", "UserDetailAdControl mCurPosition " + this.d + " dataSize " + i2);
        d(i2);
        q66.d(activity, str, false);
    }

    public List<SquareFeed> a(List<SquareFeed> list) {
        if (list != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                try {
                    int iIntValue = this.b.get(i).intValue();
                    LogUtil.d("UserDetailAd", "addAdList insertPosition " + iIntValue);
                    list.add(iIntValue, b(iIntValue));
                } catch (Exception unused) {
                }
            }
        }
        return list;
    }

    public final SquareFeed b(int i) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.adKey = Integer.valueOf(i + new Random().nextInt(10000));
        return squareFeed;
    }

    public int c() {
        int i = this.d + this.f;
        LogUtil.d("UserDetailAd", "getNewCurPosition res " + i);
        return i;
    }

    public final void d(int i) {
        int i2;
        if (p66.f19950a.size() == 0) {
            p66.f19950a.add(-1);
            p66.f19950a.add(1);
        }
        if (p66.f19950a.size() > 0) {
            for (int i3 = 0; i3 < p66.f19950a.size(); i3++) {
                int iIntValue = p66.f19950a.get(i3).intValue();
                if (iIntValue < 0) {
                    i2 = this.d + iIntValue + 1 + this.f;
                } else {
                    i2 = this.d + iIntValue + this.e;
                    if (i2 > i + 1) {
                        this.c.add(Integer.valueOf(i2));
                        LogUtil.d("UserDetailAd", "initData mNoShowPositions no allow targetPosition " + i2);
                    }
                }
                if (i2 >= 0 && i2 <= i + 1) {
                    this.e++;
                    this.b.add(Integer.valueOf(i2));
                    if (iIntValue < 0) {
                        this.f++;
                    }
                }
                i += this.e;
                LogUtil.d("UserDetailAd", "initData mCurPosition " + this.d + " num " + iIntValue + " targetPosition " + i2 + " allSuccessNum " + this.e + " fuSuccessNum " + this.f + " dataSize " + i);
            }
        }
    }

    public void e() {
        q66.c();
        if (!b6.d()) {
            if (b6.v) {
                SPCacheManager.INSTANCE.clearCacheAd(82);
            }
        } else if (b6.v || b6.e("UserDrawDetail")) {
            SPCacheManager.INSTANCE.clearCacheAd(82);
        }
    }

    public List<BasePagerBean> f(List<BasePagerBean> list, int i, int i2) {
        ArrayList<Integer> arrayList;
        LogUtil.d("UserDetailAd", "onLoadMore mNoShowPositions addAdList fromPos " + i + " changeCount " + i2);
        if (list != null && (arrayList = this.c) != null && arrayList.size() > 0) {
            try {
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < this.c.size(); i4++) {
                    int iIntValue = this.c.get(i4).intValue() + i3;
                    LogUtil.d("UserDetailAd", "onLoadMore mNoShowPositions addAdList insertPosition " + iIntValue + " allSize " + size + " successNum " + i3);
                    if (iIntValue < list.size()) {
                        i3++;
                        list.add(iIntValue, b(iIntValue));
                        LogUtil.d("UserDetailAd", "onLoadMore mNoShowPositions success insertPosition " + iIntValue + " allSize " + size + " successNum " + i3);
                    }
                }
            } catch (Exception unused) {
            }
            this.c.clear();
        }
        return list;
    }
}

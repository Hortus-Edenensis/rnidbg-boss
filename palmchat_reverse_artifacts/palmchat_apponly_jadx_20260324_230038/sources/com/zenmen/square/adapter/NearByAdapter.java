package com.zenmen.square.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.holder.NearbyBottomGuideViewHolder;
import com.zenmen.find.holder.NearbyMapFinderGuideViewHolder;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.ad.find.FindAdViewHolder;
import com.zenmen.square.ad.find.FindAdViewHolder2;
import com.zenmen.square.ad.nearby.NearByLockTipViewHolder;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.mvp.holder.FootViewHolder;
import com.zenmen.square.mvp.holder.NearByViewHolder;
import com.zenmen.square.mvp.holder.NearbyDividerViewHolder;
import com.zenmen.square.mvp.holder.QualityFriendShipViewHolder;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.ai5;
import defpackage.du3;
import defpackage.fg6;
import defpackage.iu3;
import defpackage.jo6;
import defpackage.ju3;
import defpackage.ma3;
import defpackage.n6;
import defpackage.v4;
import defpackage.zt4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByAdapter extends BaseRecyclerAdapter<BaseViewHolder, NearByBean, iu3> {
    public int g;
    public Activity h;
    public int i = 0;

    public NearByAdapter(int i) {
        this.g = i;
    }

    @Override // com.zenmen.listui.list.BaseRecyclerAdapter
    public void b(List<NearByBean> list, int i, int i2) {
        d(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.listui.list.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        List<B> list;
        super.onBindViewHolder(baseViewHolder, i);
        if (this.f != 0 && (list = this.e) != 0 && list.size() > 0) {
            int iM = ((iu3) this.f).m();
            List<B> list2 = this.e;
            if (TextUtils.isEmpty(((NearByBean) list2.get(list2.size() - 1)).bottomTips) && iM > 0 && (this.e.size() - i <= iM / 2 || (this.e.size() - i == 1 && iM == 1))) {
                ma3.a("onBindViewHolder start auto load more ", new Object[0]);
                ((iu3) this.f).q();
            }
        }
        if (this.h != null) {
            int i2 = this.g;
            if (i2 == 48) {
                zt4.y().v(this.h, 2, i);
            } else if (i2 == 49) {
                du3.y().v(this.h, 2, i);
            }
            NearByFragment nearByFragment = (NearByFragment) ((iu3) this.f).p();
            if (nearByFragment != null && nearByFragment.S0()) {
                ju3.t(this.h, i);
            }
        }
        g(i);
    }

    public void f(Activity activity) {
        this.h = activity;
    }

    public final void g(int i) {
        if (jo6.I()) {
            ContactInfoItem contactInfoItemF = v4.f();
            if ((contactInfoItemF == null || fg6.g(contactInfoItemF.getExt()) == 0) && ai5.k().i().popEnable()) {
                if (i != ai5.k().i().getShowPosition() || this.i > i) {
                    this.i = i;
                } else {
                    this.i = i;
                    ConditionHelper.getInstance().checkFilterGuide();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        NearByBean nearByBean = (NearByBean) this.e.get(i);
        if (nearByBean.isBottomTip() && !nearByBean.isBottomGuide) {
            return 100;
        }
        if (nearByBean.adItem != null) {
            return 101;
        }
        if (nearByBean.isBottomGuide) {
            return 102;
        }
        if (nearByBean.lockTitle) {
            return 103;
        }
        if (nearByBean.isMapFindGuideItem) {
            return 104;
        }
        int i2 = nearByBean.itemType;
        if (i2 == 3) {
            return 3;
        }
        return (i2 == 1 || i2 == 0) ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder nearbyBottomGuideViewHolder;
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        if (i == 100) {
            nearbyBottomGuideViewHolder = new FootViewHolder(relativeLayout);
        } else if (i != 101) {
            nearbyBottomGuideViewHolder = i == 102 ? new NearbyBottomGuideViewHolder(relativeLayout) : i == 103 ? new NearByLockTipViewHolder(relativeLayout) : i == 104 ? new NearbyMapFinderGuideViewHolder(relativeLayout) : i == 2 ? new NearbyDividerViewHolder(relativeLayout) : i == 3 ? new QualityFriendShipViewHolder(relativeLayout) : new NearByViewHolder(relativeLayout);
        } else if (n6.a()) {
            nearbyBottomGuideViewHolder = n6.b(this.g == 49 ? 57 : 56) == n6.c ? new FindAdViewHolder2(relativeLayout, this.g) : new FindAdViewHolder(relativeLayout);
        } else {
            nearbyBottomGuideViewHolder = new FindAdViewHolder(relativeLayout);
        }
        nearbyBottomGuideViewHolder.n(this.f);
        return nearbyBottomGuideViewHolder;
    }
}

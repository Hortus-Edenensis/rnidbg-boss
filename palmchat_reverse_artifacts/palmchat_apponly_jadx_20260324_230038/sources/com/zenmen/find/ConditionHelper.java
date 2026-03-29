package com.zenmen.find;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.find.bean.FindFriendCondition;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.R$string;
import com.zenmen.square.tag.config.FindFriendFilterGuideConfig;
import defpackage.a46;
import defpackage.ai5;
import defpackage.az2;
import defpackage.b05;
import defpackage.bj5;
import defpackage.v4;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public enum ConditionHelper {
    mInstance;

    private DriftInfo mDriftInfo;
    private Set<a> mListeners = new HashSet();
    private FindFriendCondition mNearByCondition;
    private FindFriendCondition mRecommendCondition;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void H0();

        void d1(FindFriendCondition findFriendCondition);

        void j(FindFriendCondition findFriendCondition);

        void z0();
    }

    ConditionHelper() {
    }

    private static String getDriftString(Context context) {
        LocationEx locationExI;
        DriftInfo driftInfo = getInstance().getDriftInfo();
        return (driftInfo == null || !driftInfo.valid() || (locationExI = d.g().i(86400000L)) == null) ? "" : context.getString(R$string.find_map_selected_info, a46.a(driftInfo.location, locationExI), "", driftInfo.location.getAddress());
    }

    public static ConditionHelper getInstance() {
        return mInstance;
    }

    public static boolean isDrifting() {
        return !TextUtils.isEmpty(getDriftString(c.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setDriftInfo$0() {
        return "解锁后的DriftInfo====>" + az2.c(this.mDriftInfo);
    }

    public static void openFilterDialog(int i, Activity activity) {
        String str = "zenxin://activity?page=a0052&pkgId=sift&isTransParent=true";
        StringBuilder sb = new StringBuilder();
        if (i == 48) {
            sb.append("?page_type=1");
        } else if (i == 49) {
            sb.append("?page_type=2");
        } else if (i == 80) {
            sb.append("?page_type=3");
        } else if (i == 113) {
            sb.append("?page_type=2");
        }
        String driftString = getDriftString(activity);
        if (!TextUtils.isEmpty(driftString)) {
            sb.append("&drift_location=");
            sb.append(driftString);
        }
        try {
            str = "zenxin://activity?page=a0052&pkgId=sift&isTransParent=true&urlExtra=" + URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        bj5.b().a().c(activity, str, false);
    }

    public void addConditionChangeListener(a aVar) {
        this.mListeners.add(aVar);
    }

    public void checkFilterGuide() {
        FindFriendFilterGuideConfig findFriendFilterGuideConfigI = ai5.k().i();
        if (findFriendFilterGuideConfigI != null && findFriendFilterGuideConfigI.frequencyEnable()) {
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().H0();
            }
        }
    }

    public DriftInfo getDriftInfo() {
        if (this.mDriftInfo == null) {
            try {
                this.mDriftInfo = (DriftInfo) az2.a(SPUtil.f14322a.n(SPUtil.SCENE.SQUARE, "key_drift_info" + v4.e(c.b()), ""), DriftInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mDriftInfo == null) {
                this.mDriftInfo = new DriftInfo();
            }
        }
        return this.mDriftInfo;
    }

    public FindFriendCondition getNearByCond() {
        if (this.mNearByCondition == null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.JSAPI, "key_find_friend_condition_nearby" + v4.e(c.b()), "");
            if (!TextUtils.isEmpty(strN)) {
                try {
                    this.mNearByCondition = new FindFriendCondition(strN);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mNearByCondition == null) {
            this.mNearByCondition = new FindFriendCondition();
        }
        return this.mNearByCondition;
    }

    public FindFriendCondition getRecommendCond() {
        if (this.mRecommendCondition == null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.JSAPI, "key_find_friend_condition_recommend" + v4.e(c.b()), "");
            if (!TextUtils.isEmpty(strN)) {
                try {
                    this.mRecommendCondition = new FindFriendCondition(strN);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mRecommendCondition == null) {
            this.mRecommendCondition = new FindFriendCondition();
        }
        return this.mRecommendCondition;
    }

    public void removeConditionChangeListener(a aVar) {
        this.mListeners.remove(aVar);
    }

    public void resetCondition() {
        this.mRecommendCondition = null;
        this.mNearByCondition = null;
        this.mDriftInfo = null;
    }

    public void resetNearbyVipCondition() {
        getNearByCond().resetVipCond();
        setNearByCond(getNearByCond(), false);
    }

    public void resetRecommendVipCondition() {
        getRecommendCond().resetVipCond();
        setRecommendCond(getRecommendCond(), false);
    }

    public void setDriftInfo(LocationEx locationEx, boolean z, boolean z2, int i) {
        DriftInfo driftInfo = getDriftInfo();
        this.mDriftInfo = driftInfo;
        driftInfo.location = locationEx;
        driftInfo.firstDrift = z2;
        driftInfo.driftScene = i;
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_drift_info" + v4.e(c.b()), az2.c(this.mDriftInfo));
        b05.c(new b05.a() { // from class: kl0
            @Override // b05.a
            public final Object getValue() {
                return this.f18716a.lambda$setDriftInfo$0();
            }
        });
        if (z) {
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().z0();
            }
        }
    }

    public void setDriftInfoConsumed() {
        getDriftInfo().firstDrift = false;
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_drift_info" + v4.e(c.b()), az2.c(this.mDriftInfo));
    }

    public void setNearByCond(FindFriendCondition findFriendCondition) {
        setNearByCond(findFriendCondition, true);
    }

    public void setRecommendCond(FindFriendCondition findFriendCondition) {
        setRecommendCond(findFriendCondition, true);
    }

    public void setNearByCond(FindFriendCondition findFriendCondition, boolean z) {
        if (findFriendCondition == null) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.JSAPI, "key_find_friend_condition_nearby" + v4.e(c.b()), findFriendCondition.toString());
        this.mNearByCondition = findFriendCondition;
        if (z) {
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().j(this.mNearByCondition);
            }
        }
    }

    public void setRecommendCond(FindFriendCondition findFriendCondition, boolean z) {
        if (findFriendCondition == null) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.JSAPI, "key_find_friend_condition_recommend" + v4.e(c.b()), findFriendCondition.toString());
        this.mRecommendCondition = findFriendCondition;
        if (z) {
            Iterator<a> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().d1(this.mRecommendCondition);
            }
        }
    }
}

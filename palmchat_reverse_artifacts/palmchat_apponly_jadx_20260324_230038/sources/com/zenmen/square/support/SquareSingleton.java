package com.zenmen.square.support;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import defpackage.ai5;
import defpackage.an1;
import defpackage.ap3;
import defpackage.b66;
import defpackage.d46;
import defpackage.dn0;
import defpackage.ir5;
import defpackage.q46;
import defpackage.v4;
import defpackage.vi5;
import defpackage.vn3;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public enum SquareSingleton {
    mInstance;

    private vn3 messageCountManager = new vn3();
    private b66 usedTagHelper = null;
    private Set<Long> inScreenFeedIds = new HashSet();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private long lastRequestPraiseTime = 0;
    private int nearbyFilter = -1;

    SquareSingleton() {
    }

    public static SquareSingleton getInstance() {
        return mInstance;
    }

    public void addInScreenId(long j) {
        this.inScreenFeedIds.add(Long.valueOf(j));
    }

    public void checkUpdate(SquareFeed squareFeed) {
        try {
            Set<Long> set = this.inScreenFeedIds;
            if (set == null || set.size() <= 0) {
                return;
            }
            Iterator<Long> it = this.inScreenFeedIds.iterator();
            while (it != null) {
                if (!it.hasNext()) {
                    return;
                }
                if (squareFeed.id == it.next().longValue()) {
                    SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                    squareFeedEvent.eventType = 2;
                    squareFeedEvent.feed = squareFeed;
                    an1.c().l(squareFeedEvent);
                }
            }
        } catch (Exception unused) {
        }
    }

    public int getFriendMsgUnReadCount() {
        return this.messageCountManager.h();
    }

    public int getLastCommentUnReadCount() {
        return this.messageCountManager.j();
    }

    public int getLastPraiseUnReadCount() {
        return this.messageCountManager.k();
    }

    public int getLastUnReadCount() {
        return getLastPraiseUnReadCount() + getLastCommentUnReadCount() + getFriendMsgUnReadCount();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public vn3 getMessageCountManager() {
        return this.messageCountManager;
    }

    public int getNearByFilter() {
        if (this.nearbyFilter == -1) {
            this.nearbyFilter = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_filter_sex" + v4.e(c.b()), 2);
        }
        return this.nearbyFilter;
    }

    public synchronized b66 getUsedTagHelper() {
        if (this.usedTagHelper == null) {
            this.usedTagHelper = new b66();
        }
        return this.usedTagHelper;
    }

    public boolean isGenderBirthdayCompleted() {
        ContactInfoItem contactInfoItemA;
        String strE = v4.e(c.b());
        return (TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null || contactInfoItemA.getGender() < 0 || TextUtils.isEmpty(contactInfoItemA.getBirthday())) ? false : true;
    }

    public void onAppCreate() {
        onNetReady();
        vi5.b().h();
    }

    public void onLogin(int i) {
        LogUtil.i("SquareGuideManager", "guide=" + i);
        if (i == 1) {
            vi5.b().j();
        }
    }

    public void onNetReady() {
        if (ap3.a().i()) {
            ai5.k().r(c.b(), "initActivity", !vi5.b().f());
        }
    }

    public void registerCountChangeListener(d46 d46Var) {
        if (d46Var != null) {
            this.messageCountManager.w(d46Var);
        }
    }

    public void reloadLookMeCount() {
        this.messageCountManager.x();
    }

    public void reloadPraiseCount() {
        if (Math.abs(this.lastRequestPraiseTime - ir5.b()) >= 5000) {
            this.messageCountManager.y();
            this.lastRequestPraiseTime = ir5.b();
        }
    }

    public void removeInScreenId(long j) {
        this.inScreenFeedIds.remove(Long.valueOf(j));
    }

    public synchronized void reset() {
        this.usedTagHelper = null;
    }

    public void setFriendFeedsRedDot(boolean z) {
        this.messageCountManager.A(z);
    }

    public void setFriendUnReadMsgInfo(q46 q46Var) {
        this.messageCountManager.B(q46Var);
    }

    public void setLastCommentUnReadCount(int i) {
        this.messageCountManager.C(i);
    }

    public void setLastPraiseUnReadCount(int i) {
        this.messageCountManager.D(i);
    }

    public void setNearByFilter(int i) {
        this.nearbyFilter = i;
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_filter_sex" + v4.e(c.b()), Integer.valueOf(i));
    }

    public void unRegisterCountChangeListener(d46 d46Var) {
        this.messageCountManager.G(d46Var);
    }
}

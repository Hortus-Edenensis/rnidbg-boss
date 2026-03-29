package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.ActiveWrapper;
import com.cdo.oaps.ad.compatible.gamecenter.wrapper.StrategyWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f5458a = {Launcher.Path.HOME};
    static String[] b = {Launcher.Path.MALL, Launcher.Path.HOME};
    static String[] c = {Launcher.Path.HOME, Launcher.Path.MALL, Launcher.Path.VIP, Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, Launcher.Path.WEB, Launcher.Path.ONLINE_SERVICE, Launcher.Path.GIFTS};
    static String[] d = {Launcher.Path.HOME, Launcher.Path.MALL, Launcher.Path.VIP, Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.ORDER_DETAIL, Launcher.Path.TOPIC, Launcher.Path.CARD_STYLE, Launcher.Path.WEB, Launcher.Path.FORUM_POSTS_DT, Launcher.Path.GIFTS, Launcher.Path.COIN_TICKET, Launcher.Path.GAME_GIFTS, Launcher.Path.ACTIVITIES, Launcher.Path.GAME_ACTIVITIES, Launcher.Path.FORUM_BOARD_DT};

    public static boolean a(Context context, String str) {
        float fA = x.a(context);
        if (fA >= 2.1f) {
            for (String str2 : d) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } else if (fA >= 2.0f) {
            for (String str3 : c) {
                if (str3.equals(str)) {
                    return true;
                }
            }
        } else if (fA >= 1.2f || Math.abs(fA - 1.2f) < 1.0E-6d) {
            for (String str4 : b) {
                if (str4.equals(str)) {
                    return true;
                }
            }
        } else if (fA > 0.0f) {
            for (String str5 : f5458a) {
                if (str5.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(Context context, Map<String, Object> map) {
        BaseWrapper baseWrapperWrapper = BaseWrapper.wrapper(map);
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.HOME)) {
            return w.a(context, baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.DETAIL)) {
            return w.a(context, ResourceWrapper.wrapper(map).getId(), baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.GAME_GIFT_BAG)) {
            ActiveWrapper activeWrapperWrapper = ActiveWrapper.wrapper(map);
            int activeCode = activeWrapperWrapper.getActiveCode();
            long id = activeWrapperWrapper.getId();
            String str = "actCode=giftbag" + activeCode + "&actPage=GIFT_BAG_DETAIL#/actDetail";
            String enterId = baseWrapperWrapper.getEnterId();
            return id > 0 ? w.a(context, str, id, enterId) : w.a(context, str, enterId);
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.GAME_ACTIVE)) {
            ActiveWrapper activeWrapperWrapper2 = ActiveWrapper.wrapper(map);
            int activeCode2 = activeWrapperWrapper2.getActiveCode();
            long id2 = activeWrapperWrapper2.getId();
            String str2 = "actCode=activity" + activeCode2 + "&actPage=ACTIVITY_DETAIL#/actDetail";
            String enterId2 = baseWrapperWrapper.getEnterId();
            return id2 > 0 ? w.b(context, str2, id2, enterId2) : w.b(context, str2, enterId2);
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.TOPIC)) {
            return w.b(context, IDWrapper.wrapper(map).getId(), baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.STRATEGY)) {
            StrategyWrapper strategyWrapperWrapper = StrategyWrapper.wrapper(map);
            strategyWrapperWrapper.setTab(1);
            return w.c(context, strategyWrapperWrapper.getId(), baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals("/point")) {
            return w.b(context, baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.MALL)) {
            return w.c(context, baseWrapperWrapper.getEnterId());
        }
        if (baseWrapperWrapper.getPath().equals(Launcher.Path.ONLINE_SERVICE)) {
            return false;
        }
        baseWrapperWrapper.getPath().equals(Launcher.Path.WEB);
        return false;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }
}

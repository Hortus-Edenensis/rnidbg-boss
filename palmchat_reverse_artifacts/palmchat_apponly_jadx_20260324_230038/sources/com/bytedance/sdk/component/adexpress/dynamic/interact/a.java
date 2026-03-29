package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.umeng.analytics.pro.dn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static x u(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, com.bytedance.sdk.component.adexpress.nr.mv mvVar) {
        if (context == null || dynamicBaseWidget == null || xVar == null) {
            return null;
        }
        String strXw = xVar.xw();
        String strGi = mvVar.gi();
        strXw.hashCode();
        byte b = -1;
        switch (strXw.hashCode()) {
            case 48:
                if (strXw.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (strXw.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strXw.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strXw.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strXw.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strXw.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strXw.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (strXw.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (strXw.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strXw.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (strXw.equals(BaseWrapper.ENTER_ID_MARKET)) {
                    b = 10;
                }
                break;
            case 1570:
                if (strXw.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                    b = 11;
                }
                break;
            case 1571:
                if (strXw.equals(BaseWrapper.ENTER_ID_AD_SDK)) {
                    b = 12;
                }
                break;
            case 1573:
                if (strXw.equals("16")) {
                    b = dn.k;
                }
                break;
            case 1574:
                if (strXw.equals(BaseWrapper.ENTER_ID_17)) {
                    b = dn.l;
                }
                break;
            case 1575:
                if (strXw.equals(BaseWrapper.ENTER_ID_18)) {
                    b = 15;
                }
                break;
            case 1598:
                if (strXw.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                    b = 16;
                }
                break;
            case 1600:
                if (strXw.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
                    b = 17;
                }
                break;
            case 1601:
                if (strXw.equals(BaseWrapper.ENTER_ID_SHORTCUT)) {
                    b = 18;
                }
                break;
            case 1602:
                if (strXw.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strXw.equals("25")) {
                    b = 20;
                }
                break;
            case 1607:
                if (strXw.equals("29")) {
                    b = 21;
                }
                break;
        }
        switch (b) {
            case 0:
                return new pn(context, dynamicBaseWidget, xVar);
            case 1:
                return new fx(context, dynamicBaseWidget, xVar);
            case 2:
                return new nr(context, dynamicBaseWidget, xVar);
            case 3:
                return xVar.w() == 1 ? new o(context, dynamicBaseWidget, xVar, xVar.gc()) : new my(context, dynamicBaseWidget, xVar);
            case 4:
            case 9:
                return new mv(context, dynamicBaseWidget, xVar);
            case 5:
            case 12:
                return new t(context, dynamicBaseWidget, xVar);
            case 6:
                return new l(context, dynamicBaseWidget, xVar);
            case 7:
            case 13:
                return new s(context, dynamicBaseWidget, xVar, strXw, jkVar, mvVar.a(), mvVar.h(), mvVar.rh());
            case 8:
                return new b(context, dynamicBaseWidget, xVar);
            case 10:
                return new my(context, dynamicBaseWidget, xVar);
            case 11:
                return new o(context, dynamicBaseWidget, xVar);
            case 14:
            case 15:
                return new bg(context, dynamicBaseWidget, xVar, strXw, jkVar, mvVar.a(), mvVar.h(), mvVar.rh());
            case 16:
                if (com.bytedance.sdk.component.adexpress.b.u()) {
                    return new jk(context, dynamicBaseWidget, xVar, strGi + "static/lotties/glass-swipe/glass-swipe.json", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                }
                return new jk(context, dynamicBaseWidget, xVar, TextUtils.isEmpty(strGi) ? null : strGi + "brush_mask.json", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
            case 17:
                if (!com.bytedance.sdk.component.adexpress.b.u()) {
                    return new sx(context, dynamicBaseWidget, xVar);
                }
                return new jk(context, dynamicBaseWidget, xVar, strGi + "static/lotties/202327swiper-up-star/index.json", BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
            case 18:
                if (!com.bytedance.sdk.component.adexpress.b.u()) {
                    return null;
                }
                return new jk(context, dynamicBaseWidget, xVar, strGi + "static/lotties/202327swiper-up-star/click.json", BaseWrapper.ENTER_ID_SHORTCUT);
            case 19:
                if (com.bytedance.sdk.component.adexpress.b.u()) {
                    return new u(context, dynamicBaseWidget, xVar);
                }
                return new jk(context, dynamicBaseWidget, xVar, TextUtils.isEmpty(strGi) ? null : strGi + "swiper_up_star.json", "24");
            case 20:
                if (!com.bytedance.sdk.component.adexpress.b.u()) {
                    return null;
                }
                return new jk(context, dynamicBaseWidget, xVar, strGi + "static/lotties/gesture-slide.json", "25");
            case 21:
                return new iz(context, dynamicBaseWidget, xVar, jkVar, mvVar.a(), mvVar.h(), mvVar.rh());
            default:
                return null;
        }
    }
}

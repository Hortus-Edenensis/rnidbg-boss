package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.record.CacheEntity;
import com.opos.mobad.provider.record.ControlEntity;
import com.opos.mobad.provider.record.CookieData;
import com.opos.mobad.provider.record.SdKRecord;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class SdKRecord$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.record.SdKRecord";

    public static void init() {
        a.a().a(TARGET_CLASS, new SdKRecord$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        switch (i) {
            case 1:
                if (1 == objArr.length && ((obj = objArr[0]) == null || (obj instanceof CacheEntity))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((CacheEntity) objArr[0]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 2:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a(), CacheEntity.class);
            case 3:
                if (1 == objArr.length && ((obj2 = objArr[0]) == null || (obj2 instanceof CacheEntity))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).b((CacheEntity) objArr[0]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 4:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).b(), CacheEntity.class);
            case 5:
                ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).c();
                return BundleUtil.makeBundle(0, "");
            case 6:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).d(), ControlEntity.class);
            case 7:
                if (1 == objArr.length && ((obj3 = objArr[0]) == null || (obj3 instanceof ControlEntity))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((ControlEntity) objArr[0]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 8:
                return BundleUtil.packageBundle(Long.valueOf(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).e()), Long.TYPE);
            case 9:
                if (1 == objArr.length && ((obj4 = objArr[0]) == null || (obj4 instanceof String))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 10:
                return BundleUtil.packageBundle(Integer.valueOf(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).f()), Integer.TYPE);
            case 11:
                return BundleUtil.packageBundle(Long.valueOf(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).g()), Long.TYPE);
            case 12:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).h(), String.class);
            case 13:
                if (2 == objArr.length && (((obj5 = objArr[0]) == null || (obj5 instanceof String)) && ((obj6 = objArr[1]) == null || (obj6 instanceof String)))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], (String) objArr[1]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 14:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).i(), String.class);
            case 15:
                if (1 == objArr.length && ((obj7 = objArr[0]) == null || (obj7 instanceof CookieData))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((CookieData) objArr[0]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 16:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).j(), CookieData.class);
            case 17:
                if (2 == objArr.length && (((obj8 = objArr[0]) == null || (obj8 instanceof String)) && ((obj9 = objArr[1]) == null || (obj9 instanceof String)))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).b((String) objArr[0], (String) objArr[1]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 18:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).k(), String.class);
            case 19:
                return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).l(), String.class);
            case 20:
                if (2 == objArr.length && (((obj10 = objArr[0]) == null || (obj10 instanceof String)) && ((obj11 = objArr[1]) == null || (obj11 instanceof Boolean)))) {
                    return BundleUtil.packageBundle(((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], ((Boolean) objArr[1]).booleanValue()), String[].class);
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            case 21:
                if (2 == objArr.length && (((obj12 = objArr[0]) == null || (obj12 instanceof String)) && ((obj13 = objArr[1]) == null || (obj13 instanceof String)))) {
                    ((SdKRecord) SdKRecord.FACTORY.getInstance(context, iBridgeTargetIdentify)).c((String) objArr[0], (String) objArr[1]);
                    return BundleUtil.makeBundle(0, "");
                }
                c.a().a(TARGET_CLASS, str, 102003, "received params not match");
                return BundleUtil.makeBundle(102003, "received params not match");
            default:
                return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
    }
}

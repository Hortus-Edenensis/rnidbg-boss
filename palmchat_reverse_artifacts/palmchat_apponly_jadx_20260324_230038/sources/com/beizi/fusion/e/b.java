package com.beizi.fusion.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<AdSpacesBean.ForwardBean> a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str) {
        String content;
        ArrayList arrayList = new ArrayList();
        if (componentBean != null && list != null && list.size() != 0 && (content = componentBean.getContent()) != null) {
            switch (content) {
                case "random":
                    a(componentBean, arrayList);
                    break;
                case "fail":
                    a(componentBean, list, str, arrayList, "280.500");
                    break;
                case "show":
                    a(componentBean, list, str, arrayList, "280.300");
                    break;
                case "click":
                    a(componentBean, list, str, arrayList, "290.300");
                    break;
                case "request":
                    a(componentBean, list, str, arrayList, "200.000");
                    break;
            }
        } else {
            return arrayList;
        }
    }

    private static boolean b(List<AdSpacesBean.RulesBean> list, int i) {
        boolean z;
        if (list == null) {
            return false;
        }
        if (list.size() == 0) {
            aa.c("BeiZis", "enter rulesBeanList.size() == 0");
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a(list.get(i2), i)) {
                return true;
            }
        }
        return z;
    }

    private static String c(String str) {
        aa.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ao.b().equals(str) ? "BEIZI" : str;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) {
            return BeiZiBiddingConstant.Adn.ADN_BZ;
        }
        if (str.equals("ADSCOPE")) {
            return "8888";
        }
        return null;
    }

    private static void a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, String str, List<AdSpacesBean.ForwardBean> list2, String str2) {
        aa.c("BeiZis", "enter handleSpaceStrategyByEvent eventCode = " + str2);
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int iA = s.a(str, str2);
        if (!str2.equalsIgnoreCase("200.000")) {
            iA++;
        }
        for (int i = 0; i < forward.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean buyerBean = list.get(i2);
                if (buyerBean.getId() != null && buyerBean.getId().equalsIgnoreCase(forwardBean.getBuyerId()) && buyerBean.getBuyerSpaceUuId() != null && buyerBean.getBuyerSpaceUuId().equalsIgnoreCase(forwardBean.getBuyerSpaceUuId())) {
                    aa.c("BeiZis", forwardBean.getBuyerId() + " handleSpaceRequestStrategy buyerBean match");
                    if (b(forwardBean.getRules(), iA)) {
                        aa.c("BeiZis", forwardBean.getBuyerId() + " enter rulesMatch");
                        list2.add(forwardBean);
                    }
                }
            }
        }
    }

    public static void a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.ForwardBean> list) {
        List<AdSpacesBean.ForwardBean> forward = componentBean.getForward();
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        aa.a("BeiZis", "AdForward random:" + iRandom);
        if (forward == null || forward.size() <= 0) {
            return;
        }
        int size = forward.size();
        for (int i = 0; i < size; i++) {
            AdSpacesBean.ForwardBean forwardBean = forward.get(i);
            List<AdSpacesBean.RulesBean> rules = forwardBean.getRules();
            if (rules != null && rules.size() > 0) {
                int size2 = rules.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Integer[] results = rules.get(i2).getResults();
                    if (results != null && results.length >= 2) {
                        int iIntValue = results[0].intValue();
                        int iIntValue2 = results[1].intValue();
                        if (iIntValue <= iRandom && iRandom <= iIntValue2) {
                            list.add(forwardBean);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(AdSpacesBean.RulesBean rulesBean, int i) {
        boolean z = false;
        if (rulesBean == null) {
            return false;
        }
        try {
            String strReplace = rulesBean.getFormula().replace("x", i + "");
            int iA = c.a(strReplace);
            Integer[] results = rulesBean.getResults();
            aa.c("BeiZis", "formulaOrig = " + strReplace + ",isOneRuleMatch holderNum = " + i);
            if (results != null && results.length >= 2) {
                aa.c("BeiZis", "formulaResult = " + iA + ",results[0] = " + results[0] + ",results[1] = " + results[1]);
                if (iA >= results[0].intValue() && iA <= results[1].intValue()) {
                    z = true;
                }
            }
            return rulesBean.getRules() != null ? z & b(rulesBean.getRules(), i) : z;
        } catch (Exception unused) {
            aa.c("BeiZis", "execute formula error!");
            return z;
        }
    }

    public static void a(Context context, long j, AdSpacesBean.FilterBean filterBean, com.beizi.fusion.events.b bVar, String str, String str2, String str3, com.beizi.fusion.c.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (bVar != null) {
            aa.a("BeiZis", "channel = " + str2 + ",observer.mPlatformFilterStatus.getStatus() = " + bVar.c.a() + ",observer.mChannelFilterStatus.getStatus(channelId) = " + bVar.e.a(str2));
        }
        boolean zA = true;
        boolean z4 = !TextUtils.isEmpty(str2);
        if (bVar == null || !(bVar.c.a() == 1 || bVar.e.a(str2) == 2)) {
            if (bVar != null) {
                if (z4) {
                    bVar.e.a(str2, -2);
                    return;
                } else {
                    bVar.c.a(-2);
                    return;
                }
            }
            if (aVar == null || z4) {
                return;
            }
            aVar.a("status not PlatformFilterStatus.kPlatformFilterStatusBegin");
            return;
        }
        if (filterBean != null) {
            List<String> privilege = filterBean.getPrivilege();
            boolean zA2 = (privilege == null || privilege.size() <= 0) ? true : a(context, privilege);
            z3 = false;
            z2 = j > ((long) filterBean.getMinAdLoadTime());
            try {
                zA = s.a(filterBean.getFrequency(), str, c(str2), str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            z = zA;
            zA = zA2;
        } else {
            if (z4) {
                bVar.e.a(str2, 3);
            } else {
                bVar.c.a(2);
            }
            z = true;
            z2 = true;
            z3 = true;
        }
        if (!zA) {
            if (z4) {
                bVar.e.a(str2, 5);
            } else {
                bVar.c.a(4);
            }
        }
        if (!z2) {
            if (z4) {
                bVar.e.a(str2, 6);
            } else {
                bVar.c.a(5);
            }
        }
        if (!z) {
            if (z4) {
                bVar.e.a(str2, 7);
            } else {
                bVar.c.a(6);
            }
        }
        if (!z3 && zA && z2 && z) {
            if (z4) {
                bVar.e.a(str2, 3);
            } else {
                bVar.c.a(2);
            }
        }
    }

    public static int a(String str) {
        String strB;
        if (str == null || (strB = b(str)) == null) {
            return -1;
        }
        return Integer.parseInt(strB);
    }

    private static boolean a(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        for (String str : list) {
            if (-1 == packageManager.checkPermission(str, packageName)) {
                Log.d("lance", "required permission not granted . permission = " + str);
                return false;
            }
        }
        return true;
    }

    public static AdSpacesBean.BuyerBean a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("buyerBeans != null ? ");
        sb.append(list != null);
        aa.c("BeiZis", sb.toString());
        if (list != null) {
            aa.c("BeiZis", "buyerBeans.size() = " + list.size());
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.BuyerBean buyerBean = list.get(i);
            aa.c("BeiZis", "AdBuyer buyerBean.getUuid() = " + buyerBean.getBuyerSpaceUuId());
            if (buyerBean.getId() != null && buyerBean.getId().equals(str) && str2 != null && str2.equalsIgnoreCase(buyerBean.getBuyerSpaceUuId())) {
                return buyerBean;
            }
        }
        return null;
    }

    public static String a(List<AdSpacesBean.BuyerBean.RenderRulesBean> list, int i) {
        Integer[] results;
        if (list == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdSpacesBean.BuyerBean.RenderRulesBean renderRulesBean = list.get(i2);
                if (renderRulesBean != null && (results = renderRulesBean.getResults()) != null && results.length >= 2 && i >= results[0].intValue() && i <= results[1].intValue()) {
                    String type = renderRulesBean.getType();
                    aa.c("BeiZis", "type = " + type + ";holderNum:" + i);
                    return type;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

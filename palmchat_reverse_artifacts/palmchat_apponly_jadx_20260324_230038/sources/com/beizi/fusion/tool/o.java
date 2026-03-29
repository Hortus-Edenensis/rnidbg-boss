package com.beizi.fusion.tool;

import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class o {
    public static List<Pair<String, Integer>> a(List<AdSpacesBean.DpLinkUrlListBean> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (AdSpacesBean.DpLinkUrlListBean dpLinkUrlListBean : list) {
            arrayList.add(new Pair(dpLinkUrlListBean.getDpLinkUrL(), Integer.valueOf(dpLinkUrlListBean.getOptimizePercent())));
        }
        return arrayList;
    }
}

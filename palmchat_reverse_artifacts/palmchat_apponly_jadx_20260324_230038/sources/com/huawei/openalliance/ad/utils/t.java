package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class t {
    private static long Code = 0;
    private static final int I = 1500;
    private static long V;

    public static boolean Code() {
        if (Math.abs(System.currentTimeMillis() - Code) < 500 || Math.abs(System.currentTimeMillis() - V) < com.igexin.push.config.c.j) {
            return true;
        }
        Code = System.currentTimeMillis();
        return false;
    }

    public static void V() {
        V = System.currentTimeMillis();
    }

    public static boolean Code(List<FeedbackInfo> list) {
        if (ag.Code(list)) {
            return false;
        }
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && feedbackInfo.Z()) {
                return true;
            }
        }
        return false;
    }
}

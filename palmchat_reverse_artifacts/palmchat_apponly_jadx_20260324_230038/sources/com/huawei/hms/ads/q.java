package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface q {
    Location B();

    void B(Integer num);

    void B(String str);

    RequestOptions C();

    void C(Integer num);

    void C(String str);

    String Code();

    void Code(int i);

    void Code(Location location);

    void Code(App app);

    void Code(RequestOptions requestOptions);

    void Code(SearchInfo searchInfo);

    void Code(Integer num);

    void Code(String str);

    void Code(String str, BiddingParam biddingParam);

    void Code(List<Integer> list);

    void Code(Map<String, Bundle> map);

    void Code(boolean z);

    boolean Code(Context context);

    String D();

    void D(String str);

    String F();

    void F(Integer num);

    void F(String str);

    int I();

    void I(int i);

    void I(Integer num);

    void I(String str);

    void I(List<String> list);

    void I(boolean z);

    List<Integer> L();

    void L(String str);

    void S(Integer num);

    void S(String str);

    boolean S();

    String V();

    void V(int i);

    void V(Integer num);

    void V(String str);

    void V(List<String> list);

    void V(Map<String, BiddingParam> map);

    void V(boolean z);

    Set<String> Z();

    void Z(Integer num);

    void Z(String str);

    String a();

    void a(String str);

    BiddingParam b(String str);

    boolean b();
}

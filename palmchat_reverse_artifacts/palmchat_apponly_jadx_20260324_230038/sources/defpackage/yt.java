package defpackage;

import com.qq.e.comm.constants.ErrorCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Integer, Integer> f22265a;

    static {
        HashMap map = new HashMap();
        f22265a = map;
        map.put(64, 64);
        f22265a.put(65, 65);
        f22265a.put(66, 66);
        f22265a.put(67, 67);
        f22265a.put(68, 68);
        f22265a.put(69, 69);
        f22265a.put(5001, 5001);
        f22265a.put(5004, 5004);
        f22265a.put(5003, 5003);
        f22265a.put(5002, 5002);
        Map<Integer, Integer> map2 = f22265a;
        Integer numValueOf = Integer.valueOf(ErrorCode.PACKAGE_NAME_ERROR);
        map2.put(numValueOf, numValueOf);
        f22265a.put(5016, 5016);
        Map<Integer, Integer> map3 = f22265a;
        Integer numValueOf2 = Integer.valueOf(ErrorCode.AD_POS_ID_BLOCKED);
        map3.put(numValueOf2, numValueOf2);
        f22265a.put(62, 5062);
    }

    public static int a(int i) {
        return f22265a.containsKey(Integer.valueOf(i)) ? f22265a.get(Integer.valueOf(i)).intValue() : i;
    }
}

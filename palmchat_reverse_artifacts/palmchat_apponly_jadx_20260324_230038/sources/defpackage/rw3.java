package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class rw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, String> f20596a;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        f20596a = map;
        map.put(10000, "未知异常");
        f20596a.put(10001, "网络超时,请稍后重试");
        f20596a.put(10002, "当前网络未连接");
        f20596a.put(10003, "数据解析异常");
        f20596a.put(10004, "该接口只能在wifi环境下执行");
        f20596a.put(10005, "返回数据为空");
        f20596a.put(10006, "网络返回状态不正确");
        f20596a.put(10007, "业务异常");
    }

    public static String a(Integer num) {
        return f20596a.containsKey(num) ? f20596a.get(num) : "未定义错误信息";
    }
}

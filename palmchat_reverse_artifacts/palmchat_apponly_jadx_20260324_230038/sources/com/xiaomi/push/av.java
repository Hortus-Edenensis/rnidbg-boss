package com.xiaomi.push;

import android.net.NetworkInfo;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkInfo f11427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f137a = new ConcurrentHashMap<>();

    public av(NetworkInfo networkInfo) {
        this.f11427a = networkInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(String str) {
        Object objValueOf;
        if (!this.f137a.containsKey(str)) {
            synchronized (str) {
                if (!this.f137a.contains(str)) {
                    switch (str) {
                        case "getType":
                            objValueOf = Integer.valueOf(this.f11427a.getType());
                            break;
                        case "getTypeName":
                            objValueOf = this.f11427a.getTypeName();
                            break;
                        case "getSubtype":
                            objValueOf = Integer.valueOf(this.f11427a.getSubtype());
                            break;
                        case "getSubtypeName":
                            objValueOf = this.f11427a.getSubtypeName();
                            break;
                        case "isConnected":
                            objValueOf = Boolean.valueOf(this.f11427a.isConnected());
                            break;
                        case "getState":
                            objValueOf = this.f11427a.getState();
                            break;
                        case "getDetailedState":
                            objValueOf = this.f11427a.getDetailedState();
                            break;
                        default:
                            objValueOf = null;
                            break;
                    }
                    if (objValueOf != null) {
                        this.f137a.put(str, objValueOf);
                    }
                }
            }
        }
        return (T) this.f137a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m180b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m178a() {
        return (String) a("getTypeName");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m179a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m177a() {
        return (NetworkInfo.State) a("getState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m176a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}

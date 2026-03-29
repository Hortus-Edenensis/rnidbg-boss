package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import android.util.LruCache;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.server.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, IDispatcher> f10384a;
    private final AtomicBoolean b;

    /* JADX INFO: renamed from: com.opos.process.bridge.dispatch.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0823a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f10385a = new a();
    }

    private a() {
        this.f10384a = new LruCache<>(1000);
        this.b = new AtomicBoolean(false);
    }

    public Bundle a(Context context, String str, String str2, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        ProcessBridgeLog.d("Dispatcher", "dispatch:" + str + ", targetClassName:" + str2 + ", methodId:" + i);
        IDispatcher iDispatcher = this.f10384a.get(str2);
        if (iDispatcher != null) {
            ProcessBridgeLog.e("Dispatcher", "getDispathcer");
            try {
                return iDispatcher.dispatch(context, str, iBridgeTargetIdentify, i, objArr);
            } catch (Exception e) {
                ProcessBridgeLog.e("Dispatcher", "dispatcher:" + iDispatcher.getClass().getName(), e);
                c.a().a(str2, str, 101008, e.getMessage());
                return BundleUtil.makeBundle(101008, "targetClassName:" + str2);
            }
        }
        ProcessBridgeLog.e("Dispatcher", "dispatcher:" + str2 + " not found");
        String str3 = "com.opos.process.bridge.dispatch." + str2.substring(str2.lastIndexOf(".") + 1) + "$Dispatcher";
        try {
            Class<?> cls = Class.forName(str3);
            if (!IDispatcher.class.isAssignableFrom(cls)) {
                return BundleUtil.makeBundle(101007, "dispatch");
            }
            IDispatcher iDispatcher2 = (IDispatcher) cls.newInstance();
            ProcessBridgeLog.e("Dispatcher", "Reflect");
            this.f10384a.put(str2, iDispatcher2);
            return iDispatcher2.dispatch(context, str, iBridgeTargetIdentify, i, objArr);
        } catch (ClassNotFoundException e2) {
            ProcessBridgeLog.e("Dispatcher", "dispatcher:" + str3, e2);
            c.a().a(str2, str, 102001, e2.getMessage());
            return BundleUtil.makeBundle(102001, "targetClassName:" + str2);
        } catch (Exception e3) {
            ProcessBridgeLog.e("Dispatcher", "dispatcher:" + str3, e3);
            c.a().a(str2, str, 101008, e3.getMessage());
            return BundleUtil.makeBundle(101008, "targetClassName:" + str2);
        }
    }

    public void b() {
        if (this.b.get()) {
            return;
        }
        this.b.set(true);
    }

    public static a a() {
        return C0823a.f10385a;
    }

    public void a(String str, IDispatcher iDispatcher) {
        this.f10384a.put(str, iDispatcher);
    }
}

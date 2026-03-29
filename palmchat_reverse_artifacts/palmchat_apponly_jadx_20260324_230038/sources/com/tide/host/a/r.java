package com.tide.host.a;

import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.model.JsonFactory;
import com.tide.protocol.model.JsonTransformable;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class r {
    public static final ExecutorService f = Executors.newCachedThreadPool();
    public final String b;
    public final JsonTransformable d;
    public final JsonFactory e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10798a = 0;
    public final HashMap c = new HashMap();

    public r(String str, TideWholeConfig tideWholeConfig, z zVar) {
        this.b = str;
        this.d = tideWholeConfig;
        this.e = zVar;
    }
}

package com.igexin.base.a;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements a {
    public String e;
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<String> f7018a = new CopyOnWriteArrayList();
    public int b = 10;
    public long c = 30000;
    private final Pattern g = Pattern.compile("(.+)?[$][{](.+)?[}].+");
    private final AtomicBoolean h = new AtomicBoolean(true);
    long d = SystemClock.elapsedRealtime();

    public c() {
        b bVarA = b.a();
        if (bVarA.f7017a.contains(this)) {
            return;
        }
        bVarA.f7017a.add(this);
    }

    public final String a(String str) {
        try {
            Matcher matcher = this.g.matcher(str);
            return matcher.find() ? str.replaceFirst("[$][{](.+)?[}]", new SimpleDateFormat(matcher.group(2)).format(new Date())) : str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    @Override // com.igexin.base.a.a
    public final void enableLog(boolean z) {
        this.h.set(z);
    }

    @Override // com.igexin.base.a.a
    public final boolean isEnabled() {
        return this.h.get();
    }

    @Override // com.igexin.base.a.a
    public final void log(String str) {
        if (isEnabled()) {
            this.f7018a.add(str);
        }
    }
}

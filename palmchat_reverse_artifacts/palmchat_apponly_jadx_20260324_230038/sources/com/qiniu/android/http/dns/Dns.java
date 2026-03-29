package com.qiniu.android.http.dns;

import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface Dns {
    List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException;
}

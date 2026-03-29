package com.qiniu.android.http.dns;

import com.qiniu.android.common.Zone;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.transaction.TransactionManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DnsPrefetchTransaction {
    private static boolean isDnsLoaded = false;

    public static synchronized boolean addDnsCheckAndPrefetchTransaction(final Zone zone, final UpToken upToken) {
        String str;
        if (!DnsPrefetcher.getInstance().isDnsOpen()) {
            return false;
        }
        if (upToken != null && (str = upToken.token) != null && str.length() != 0) {
            TransactionManager transactionManager = TransactionManager.getInstance();
            if (transactionManager.existTransactionsForName(upToken.token)) {
                return false;
            }
            transactionManager.addTransaction(new TransactionManager.Transaction(upToken.token, 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.2
                @Override // java.lang.Runnable
                public void run() {
                    DnsPrefetcher.getInstance().checkAndPrefetchDnsIfNeed(zone, upToken);
                }
            }));
            return true;
        }
        return false;
    }

    public static synchronized boolean addDnsLocalLoadTransaction() {
        if (isDnsLoaded) {
            return false;
        }
        if (!DnsPrefetcher.getInstance().isDnsOpen()) {
            return false;
        }
        isDnsLoaded = true;
        TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction("loadDns", 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.1
            @Override // java.lang.Runnable
            public void run() {
                DnsPrefetcher.getInstance().recoverCache();
                DnsPrefetcher.getInstance().localFetch();
            }
        }));
        return true;
    }

    public static synchronized boolean setDnsCheckWhetherCachedValidTransactionAction() {
        if (!DnsPrefetcher.getInstance().isDnsOpen()) {
            return false;
        }
        TransactionManager transactionManager = TransactionManager.getInstance();
        if (transactionManager.existTransactionsForName("dnsCheckWhetherCachedValidTransaction")) {
            return false;
        }
        transactionManager.addTransaction(new TransactionManager.Transaction("dnsCheckWhetherCachedValidTransaction", 10, 120, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.4
            @Override // java.lang.Runnable
            public void run() {
                DnsPrefetcher.getInstance().checkWhetherCachedDnsValid();
            }
        }));
        return true;
    }

    public static synchronized boolean addDnsCheckAndPrefetchTransaction(final String[] strArr) {
        if (!DnsPrefetcher.getInstance().isDnsOpen()) {
            return false;
        }
        if (strArr != null && strArr.length != 0) {
            TransactionManager.getInstance().addTransaction(new TransactionManager.Transaction(null, 0, new Runnable() { // from class: com.qiniu.android.http.dns.DnsPrefetchTransaction.3
                @Override // java.lang.Runnable
                public void run() {
                    DnsPrefetcher.getInstance().addPreFetchHosts(strArr);
                }
            }));
            return true;
        }
        return false;
    }
}

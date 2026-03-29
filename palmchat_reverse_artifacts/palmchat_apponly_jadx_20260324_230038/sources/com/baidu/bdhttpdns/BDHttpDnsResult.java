package com.baidu.bdhttpdns;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BDHttpDnsResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResolveType f3346a;
    private final ResolveStatus b;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* JADX INFO: compiled from: SearchBox */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.f3346a = ResolveType.RESOLVE_NONE;
        this.b = resolveStatus;
    }

    public ArrayList<String> getIpv4List() {
        return this.c;
    }

    public ArrayList<String> getIpv6List() {
        return this.d;
    }

    public ResolveStatus getResolveStatus() {
        return this.b;
    }

    public ResolveType getResolveType() {
        return this.f3346a;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ResolveType resolveType2 = ResolveType.RESOLVE_NONE;
        this.f3346a = resolveType;
        this.b = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }
}

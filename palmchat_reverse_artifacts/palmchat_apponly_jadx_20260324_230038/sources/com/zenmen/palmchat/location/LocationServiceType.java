package com.zenmen.palmchat.location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public enum LocationServiceType {
    LOCATION(1),
    RE_GEO_CODE(2),
    SEARCH_BY_POINT(3),
    SEARCH_BY_KEYWORD(4),
    STATIC_MAP(5);

    public int value;

    LocationServiceType(int i) {
        this.value = i;
    }
}

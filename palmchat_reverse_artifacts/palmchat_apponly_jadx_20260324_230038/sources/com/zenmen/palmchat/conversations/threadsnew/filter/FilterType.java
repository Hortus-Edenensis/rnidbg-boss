package com.zenmen.palmchat.conversations.threadsnew.filter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum FilterType {
    ALL("msg_all"),
    NEW("msg_new"),
    HOT("msg_chatting"),
    INTIMACY("msg_close");

    public String value;

    FilterType(String str) {
        this.value = str;
    }

    public static FilterType findFilterType(String str) {
        for (FilterType filterType : values()) {
            if (filterType.value.equals(str)) {
                return filterType;
            }
        }
        return null;
    }
}

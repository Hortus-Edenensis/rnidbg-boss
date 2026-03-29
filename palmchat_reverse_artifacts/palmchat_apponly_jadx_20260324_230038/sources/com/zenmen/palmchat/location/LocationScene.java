package com.zenmen.palmchat.location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public enum LocationScene {
    DEFAULT(0),
    CHAT_SEND_LOCATION(1),
    PUBLISH_SQUARE(2),
    FIND_MAP(3),
    TAB_MSG(4),
    TBA_FIND_RECOMMEND(5),
    TBA_FIND_NEARBY(6),
    OLD_NEARBY(7),
    TBA_SQUARE_RECOMMEND(8),
    TBA_SQUARE_NEARBY(9),
    TINDER(10),
    CHAT_DETAIL(11),
    USER_DETAIL(12),
    GROUP_NEARBY(13),
    LOCATION_FIX_CITYCODE(14),
    WEB(15),
    LOVE_MATCH(16),
    SELECT_LOCATION(17),
    TBA_SQUARE_FRIEND(18),
    TBA_SQUARE_TOPIC(20),
    VOICE_MATCH_CITY(21),
    ONLINE_LOCATION(22),
    UNKNOWN_LOCATION_LIST(101);

    public int value;

    LocationScene(int i) {
        this.value = i;
    }
}

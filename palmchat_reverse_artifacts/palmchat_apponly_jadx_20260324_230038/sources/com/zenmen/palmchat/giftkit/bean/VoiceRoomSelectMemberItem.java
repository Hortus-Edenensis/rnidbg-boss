package com.zenmen.palmchat.giftkit.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceRoomSelectMemberItem {
    public boolean isRoomMaster;
    public boolean isSelected;
    public int seatIndex;
    public String userAvatarUrl;
    public String userId;
    public String userName;

    public VoiceRoomSelectMemberItem(String str, String str2, String str3, int i, boolean z, boolean z2) {
        this.userId = str;
        this.userName = str2;
        this.userAvatarUrl = str3;
        this.seatIndex = i;
        this.isRoomMaster = z;
        this.isSelected = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj || this.userId == null) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.userId.equals(((VoiceRoomSelectMemberItem) obj).userId);
    }

    public int hashCode() {
        return this.userId.hashCode();
    }
}

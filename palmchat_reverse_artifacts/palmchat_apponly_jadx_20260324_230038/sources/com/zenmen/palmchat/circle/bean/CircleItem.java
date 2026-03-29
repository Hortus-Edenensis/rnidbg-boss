package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleItem {
    public String groupCoverUrl;
    public boolean isNeedJoinAuth;
    public String location;
    public GroupInfoItem oldInfo;
    public String onLineInfo;
    public String welcomeContent;
    public String welcomeImg;
    public ArrayList<String> tags = new ArrayList<>();
    public boolean isOpenSuggestion = true;
}

package com.zenmen.palmchat.notification.group;

import androidx.annotation.Keep;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.w24;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class NotificationGroupConfig {
    public boolean enable;
    public int groupMaxCount;
    public List<GroupItem> list;
    public boolean newStyle;

    public int getGroupMaxCount(w24 w24Var) {
        List<GroupItem> list = this.list;
        int i = 3;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.list.size(); i2++) {
                GroupItem groupItem = this.list.get(i2);
                if (w24Var.a(groupItem) && (i = groupItem.groupMaxCount) <= 0) {
                    i = this.groupMaxCount;
                }
            }
        }
        return i;
    }

    public String getGroupName(w24 w24Var) {
        List<GroupItem> list = this.list;
        if (list == null || list.size() <= 0) {
            return "group_type_config_default";
        }
        for (int i = 0; i < this.list.size(); i++) {
            if (w24Var.a(this.list.get(i))) {
                if (!this.newStyle) {
                    return "group_type_config" + i;
                }
                return "group_type_config" + i + DomainHelper.j(w24Var.c);
            }
        }
        return "group_type_config_default";
    }
}

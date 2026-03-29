package com.zenmen.palmchat.maintab.dialog;

import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PopContact {
    public String age;
    public String exid;
    public String headImg;
    public String nickName;
    public int sex;
    public String uid;

    public static ContactInfoItem convert(PopContact popContact) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(popContact.uid);
        contactInfoItem.setExid(popContact.exid);
        contactInfoItem.setNickName(popContact.nickName);
        contactInfoItem.setIconURL(popContact.headImg);
        contactInfoItem.setGender(popContact.sex);
        contactInfoItem.setAge(popContact.age);
        return contactInfoItem;
    }

    public static List<ContactInfoItem> convert(List<PopContact> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<PopContact> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(convert(it.next()));
            }
        }
        return arrayList;
    }
}

package com.zenmen.palmchat.conversations.threadsnew.chatone.vo;

import androidx.annotation.Keep;
import defpackage.ir5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatOneVo {
    public int currentIndex;
    public boolean isChtEnd;
    public List<ChatOneItemVo> list;
    public long time;

    public static ChatOneVo genTest() {
        ChatOneVo chatOneVo = new ChatOneVo();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ChatOneItemVo());
        arrayList.add(new ChatOneItemVo());
        arrayList.add(new ChatOneItemVo());
        arrayList.add(new ChatOneItemVo());
        chatOneVo.list = arrayList;
        chatOneVo.time = ir5.b();
        return chatOneVo;
    }
}

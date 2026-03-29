package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleFirstCateList implements Serializable {
    public String cateName;
    public String id;
    public String parentId;
    public ArrayList<SecondCate> secondCate;

    /* JADX INFO: compiled from: SearchBox */
    public static class SecondCate implements Serializable {
        public String cateName;
        public String id;
        public String parentId;
    }
}

package com.zenmen.square.mvp.model.bean;

import com.zenmen.listui.list.BaseBean;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DeleteResBean implements BaseBean {
    public ArrayList<Long> resIds;
    public HashSet<Long> targetDelResIds;
    public int type;
    public long version;
}

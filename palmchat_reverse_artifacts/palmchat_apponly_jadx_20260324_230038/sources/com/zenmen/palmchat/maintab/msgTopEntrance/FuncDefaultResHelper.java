package com.zenmen.palmchat.maintab.msgTopEntrance;

import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FuncDefaultResHelper {

    /* JADX INFO: compiled from: SearchBox */
    public enum FuncDefaultRes {
        AUDIOMATCH("audiomatch", R.drawable.ic_entrance_vm_single, R.drawable.ic_entrance_vm_l, R.drawable.ic_entrance_vm_s),
        CHATMATE("chatmate", R.drawable.ic_entrance_mvpchat_single, R.drawable.ic_entrance_mvpchat_l, R.drawable.ic_entrance_mvpchat_s),
        AIMATCH("aimatch", R.drawable.ic_entrance_aichat_single, R.drawable.ic_entrance_aichat_l, R.drawable.ic_entrance_aichat_s),
        UNKNOW("UNKNOW", R.drawable.ic_entrance_unknow_single, R.drawable.ic_entrance_unknow_l, R.drawable.ic_entrance_unknow_s);

        public int longres;
        public int shortres;
        public int single;
        public String tag;

        FuncDefaultRes(String str, int i, int i2, int i3) {
            this.tag = str;
            this.single = i;
            this.longres = i2;
            this.shortres = i3;
        }

        public int getResId(int i) {
            return i == 1 ? this.longres : i == -100 ? this.single : i == 2 ? this.shortres : R.drawable.ic_entrance_unknow_l;
        }
    }

    public static int a(String str, int i) {
        FuncDefaultRes funcDefaultRes;
        FuncDefaultRes[] funcDefaultResArrValues = FuncDefaultRes.values();
        int length = funcDefaultResArrValues.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                funcDefaultRes = null;
                break;
            }
            funcDefaultRes = funcDefaultResArrValues[i2];
            if (funcDefaultRes.tag.equals(str)) {
                break;
            }
            i2++;
        }
        if (funcDefaultRes == null) {
            funcDefaultRes = FuncDefaultRes.UNKNOW;
        }
        return funcDefaultRes.getResId(i);
    }
}

package com.opos.mobad.ui.feedback.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum a {
    TAG_NOT_INTERESTED_CONTENT(10, "不感兴趣"),
    TAG_BLOCK_CONTENT(11, "屏蔽此广告"),
    TAG_CONTENT_COMPLAINT(12, "投诉举报"),
    TAG_TITLE_FAKE(13, "标题党"),
    TAG_CONTENT_LOW_QUALITY(14, "广告质量差"),
    TAG_CONTENT_REPEAT(15, "内容重复"),
    TAG_CONTENT_FAKE(16, "内容虚假"),
    TAG_REPEAT_CONTENT(0, "重复展示"),
    TAG_LOW_QUALITY_CONTENT(1, "内容质量低"),
    TAG_LOW_RELATIVE_CONTENT(2, "与我相关性低"),
    TAG_VULGAR_CONTENT(3, "内容低俗"),
    TAG_FAKE_CONTENT(4, "内容虚假"),
    TAG_AFFECT_OPERATION_CONTENT(5, "影响操作"),
    TAG_INDUCE_CLICK_CONTENT(6, "诱导点击"),
    TAG_OTHER_CONTENT(7, "其他反馈事项"),
    TAG_CANNOT_CLOSE(8, "无法关闭"),
    TAG_DISPLAY_EXCEPTION(9, "内容展示异常（黑屏/卡顿）");

    private int r;
    private String s;

    a(int i, String str) {
        this.r = i;
        this.s = str;
    }

    public int a() {
        return this.r;
    }

    public String b() {
        return this.s;
    }
}

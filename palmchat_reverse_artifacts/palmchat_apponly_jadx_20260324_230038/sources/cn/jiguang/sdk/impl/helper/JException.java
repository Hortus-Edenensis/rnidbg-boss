package cn.jiguang.sdk.impl.helper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class JException extends Exception {
    public final int code;

    public JException(int i, String str) {
        super(str);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.code + "):" + getLocalizedMessage();
    }
}

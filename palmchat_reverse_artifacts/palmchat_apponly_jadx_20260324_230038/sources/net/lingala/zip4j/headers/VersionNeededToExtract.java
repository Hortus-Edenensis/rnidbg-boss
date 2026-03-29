package net.lingala.zip4j.headers;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public enum VersionNeededToExtract {
    DEFAULT(10),
    DEFLATE_COMPRESSED(20),
    ZIP_64_FORMAT(45),
    AES_ENCRYPTED(51);

    private final int code;

    VersionNeededToExtract(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}

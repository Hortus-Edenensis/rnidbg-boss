package com.efs.sdk.base.protocol.file.section;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class JSONSection extends AbsSection {
    private String body;

    public JSONSection(String str) {
        super(BodyData.TYPE_JSON);
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(String str) {
        this.body = str;
    }
}

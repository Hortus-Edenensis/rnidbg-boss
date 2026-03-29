package defpackage;

import com.baidu.mapapi.http.HttpClient;
import defpackage.vy5;
import java.util.Arrays;
import kotlin.text.Typography;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zy5 {
    private static final /* synthetic */ zy5[] $VALUES;
    public static final zy5 AfterAttributeName;
    public static final zy5 AfterAttributeValue_quoted;
    public static final zy5 AfterDoctypeName;
    public static final zy5 AfterDoctypePublicIdentifier;
    public static final zy5 AfterDoctypePublicKeyword;
    public static final zy5 AfterDoctypeSystemIdentifier;
    public static final zy5 AfterDoctypeSystemKeyword;
    public static final zy5 AttributeName;
    public static final zy5 AttributeValue_doubleQuoted;
    public static final zy5 AttributeValue_singleQuoted;
    public static final zy5 AttributeValue_unquoted;
    public static final zy5 BeforeAttributeName;
    public static final zy5 BeforeAttributeValue;
    public static final zy5 BeforeDoctypeName;
    public static final zy5 BeforeDoctypePublicIdentifier;
    public static final zy5 BeforeDoctypeSystemIdentifier;
    public static final zy5 BetweenDoctypePublicAndSystemIdentifiers;
    public static final zy5 BogusComment;
    public static final zy5 BogusDoctype;
    public static final zy5 CdataSection;
    public static final zy5 CharacterReferenceInData;
    public static final zy5 CharacterReferenceInRcdata;
    public static final zy5 Comment;
    public static final zy5 CommentEnd;
    public static final zy5 CommentEndBang;
    public static final zy5 CommentEndDash;
    public static final zy5 CommentStart;
    public static final zy5 CommentStartDash;
    public static final zy5 Data;
    public static final zy5 Doctype;
    public static final zy5 DoctypeName;
    public static final zy5 DoctypePublicIdentifier_doubleQuoted;
    public static final zy5 DoctypePublicIdentifier_singleQuoted;
    public static final zy5 DoctypeSystemIdentifier_doubleQuoted;
    public static final zy5 DoctypeSystemIdentifier_singleQuoted;
    public static final zy5 EndTagOpen;
    public static final zy5 MarkupDeclarationOpen;
    public static final zy5 PLAINTEXT;
    public static final zy5 RCDATAEndTagName;
    public static final zy5 RCDATAEndTagOpen;
    public static final zy5 Rawtext;
    public static final zy5 RawtextEndTagName;
    public static final zy5 RawtextEndTagOpen;
    public static final zy5 RawtextLessthanSign;
    public static final zy5 Rcdata;
    public static final zy5 RcdataLessthanSign;
    public static final zy5 ScriptData;
    public static final zy5 ScriptDataDoubleEscapeEnd;
    public static final zy5 ScriptDataDoubleEscapeStart;
    public static final zy5 ScriptDataDoubleEscaped;
    public static final zy5 ScriptDataDoubleEscapedDash;
    public static final zy5 ScriptDataDoubleEscapedDashDash;
    public static final zy5 ScriptDataDoubleEscapedLessthanSign;
    public static final zy5 ScriptDataEndTagName;
    public static final zy5 ScriptDataEndTagOpen;
    public static final zy5 ScriptDataEscapeStart;
    public static final zy5 ScriptDataEscapeStartDash;
    public static final zy5 ScriptDataEscaped;
    public static final zy5 ScriptDataEscapedDash;
    public static final zy5 ScriptDataEscapedDashDash;
    public static final zy5 ScriptDataEscapedEndTagName;
    public static final zy5 ScriptDataEscapedEndTagOpen;
    public static final zy5 ScriptDataEscapedLessthanSign;
    public static final zy5 ScriptDataLessthanSign;
    public static final zy5 SelfClosingStartTag;
    public static final zy5 TagName;
    public static final zy5 TagOpen;
    private static final char[] attributeDoubleValueCharsSorted;
    private static final char[] attributeNameCharsSorted;
    private static final char[] attributeSingleValueCharsSorted;
    private static final char[] attributeValueUnquoted;
    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr;

    /* JADX INFO: compiled from: SearchBox */
    public enum k extends zy5 {
        public k(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.zy5
        public void read(yy5 yy5Var, b10 b10Var) {
            char cP = b10Var.p();
            if (cP == 0) {
                yy5Var.r(this);
                yy5Var.j(b10Var.c());
            } else {
                if (cP == '&') {
                    yy5Var.b(zy5.CharacterReferenceInData);
                    return;
                }
                if (cP == '<') {
                    yy5Var.b(zy5.TagOpen);
                } else if (cP != 65535) {
                    yy5Var.l(b10Var.d());
                } else {
                    yy5Var.k(new vy5.e());
                }
            }
        }
    }

    static {
        k kVar = new k("Data", 0);
        Data = kVar;
        zy5 zy5Var = new zy5("CharacterReferenceInData", 1) { // from class: zy5.v
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readCharRef(yy5Var, zy5.Data);
            }
        };
        CharacterReferenceInData = zy5Var;
        zy5 zy5Var2 = new zy5("Rcdata", 2) { // from class: zy5.g0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char cP = b10Var.p();
                if (cP == 0) {
                    yy5Var.r(this);
                    b10Var.a();
                    yy5Var.j((char) 65533);
                } else {
                    if (cP == '&') {
                        yy5Var.b(zy5.CharacterReferenceInRcdata);
                        return;
                    }
                    if (cP == '<') {
                        yy5Var.b(zy5.RcdataLessthanSign);
                    } else if (cP != 65535) {
                        yy5Var.l(b10Var.l(Typography.amp, Typography.less, 0));
                    } else {
                        yy5Var.k(new vy5.e());
                    }
                }
            }
        };
        Rcdata = zy5Var2;
        zy5 zy5Var3 = new zy5("CharacterReferenceInRcdata", 3) { // from class: zy5.r0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readCharRef(yy5Var, zy5.Rcdata);
            }
        };
        CharacterReferenceInRcdata = zy5Var3;
        zy5 zy5Var4 = new zy5("Rawtext", 4) { // from class: zy5.c1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readData(yy5Var, b10Var, this, zy5.RawtextLessthanSign);
            }
        };
        Rawtext = zy5Var4;
        zy5 zy5Var5 = new zy5("ScriptData", 5) { // from class: zy5.l1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readData(yy5Var, b10Var, this, zy5.ScriptDataLessthanSign);
            }
        };
        ScriptData = zy5Var5;
        zy5 zy5Var6 = new zy5("PLAINTEXT", 6) { // from class: zy5.m1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char cP = b10Var.p();
                if (cP == 0) {
                    yy5Var.r(this);
                    b10Var.a();
                    yy5Var.j((char) 65533);
                } else if (cP != 65535) {
                    yy5Var.l(b10Var.j((char) 0));
                } else {
                    yy5Var.k(new vy5.e());
                }
            }
        };
        PLAINTEXT = zy5Var6;
        zy5 zy5Var7 = new zy5("TagOpen", 7) { // from class: zy5.n1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char cP = b10Var.p();
                if (cP == '!') {
                    yy5Var.b(zy5.MarkupDeclarationOpen);
                    return;
                }
                if (cP == '/') {
                    yy5Var.b(zy5.EndTagOpen);
                    return;
                }
                if (cP == '?') {
                    yy5Var.b(zy5.BogusComment);
                    return;
                }
                if (b10Var.A()) {
                    yy5Var.h(true);
                    yy5Var.v(zy5.TagName);
                } else {
                    yy5Var.r(this);
                    yy5Var.j(Typography.less);
                    yy5Var.v(zy5.Data);
                }
            }
        };
        TagOpen = zy5Var7;
        zy5 zy5Var8 = new zy5("EndTagOpen", 8) { // from class: zy5.o1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.q()) {
                    yy5Var.q(this);
                    yy5Var.l("</");
                    yy5Var.v(zy5.Data);
                } else if (b10Var.A()) {
                    yy5Var.h(false);
                    yy5Var.v(zy5.TagName);
                } else if (b10Var.u(Typography.greater)) {
                    yy5Var.r(this);
                    yy5Var.b(zy5.Data);
                } else {
                    yy5Var.r(this);
                    yy5Var.b(zy5.BogusComment);
                }
            }
        };
        EndTagOpen = zy5Var8;
        zy5 zy5Var9 = new zy5("TagName", 9) { // from class: zy5.a
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                yy5Var.i.u(b10Var.i());
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.i.u(zy5.replacementStr);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 == '/') {
                        yy5Var.v(zy5.SelfClosingStartTag);
                        return;
                    }
                    if (c2 == '>') {
                        yy5Var.p();
                        yy5Var.v(zy5.Data);
                        return;
                    } else if (c2 == 65535) {
                        yy5Var.q(this);
                        yy5Var.v(zy5.Data);
                        return;
                    } else if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r') {
                        return;
                    }
                }
                yy5Var.v(zy5.BeforeAttributeName);
            }
        };
        TagName = zy5Var9;
        zy5 zy5Var10 = new zy5("RcdataLessthanSign", 10) { // from class: zy5.b
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.u('/')) {
                    yy5Var.i();
                    yy5Var.b(zy5.RCDATAEndTagOpen);
                    return;
                }
                if (b10Var.A() && yy5Var.c() != null) {
                    if (!b10Var.o("</" + yy5Var.c())) {
                        yy5Var.i = yy5Var.h(false).z(yy5Var.c());
                        yy5Var.p();
                        b10Var.G();
                        yy5Var.v(zy5.Data);
                        return;
                    }
                }
                yy5Var.l("<");
                yy5Var.v(zy5.Rcdata);
            }
        };
        RcdataLessthanSign = zy5Var10;
        zy5 zy5Var11 = new zy5("RCDATAEndTagOpen", 11) { // from class: zy5.c
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.A()) {
                    yy5Var.l("</");
                    yy5Var.v(zy5.Rcdata);
                } else {
                    yy5Var.h(false);
                    yy5Var.i.t(b10Var.p());
                    yy5Var.h.append(b10Var.p());
                    yy5Var.b(zy5.RCDATAEndTagName);
                }
            }
        };
        RCDATAEndTagOpen = zy5Var11;
        zy5 zy5Var12 = new zy5("RCDATAEndTagName", 12) { // from class: zy5.d
            {
                k kVar2 = null;
            }

            private void anythingElse(yy5 yy5Var, b10 b10Var) {
                yy5Var.l("</" + yy5Var.h.toString());
                b10Var.G();
                yy5Var.v(zy5.Rcdata);
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.A()) {
                    String strG = b10Var.g();
                    yy5Var.i.u(strG);
                    yy5Var.h.append(strG);
                    return;
                }
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    if (yy5Var.t()) {
                        yy5Var.v(zy5.BeforeAttributeName);
                        return;
                    } else {
                        anythingElse(yy5Var, b10Var);
                        return;
                    }
                }
                if (c2 == '/') {
                    if (yy5Var.t()) {
                        yy5Var.v(zy5.SelfClosingStartTag);
                        return;
                    } else {
                        anythingElse(yy5Var, b10Var);
                        return;
                    }
                }
                if (c2 != '>') {
                    anythingElse(yy5Var, b10Var);
                } else if (!yy5Var.t()) {
                    anythingElse(yy5Var, b10Var);
                } else {
                    yy5Var.p();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        RCDATAEndTagName = zy5Var12;
        zy5 zy5Var13 = new zy5("RawtextLessthanSign", 13) { // from class: zy5.e
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.u('/')) {
                    yy5Var.i();
                    yy5Var.b(zy5.RawtextEndTagOpen);
                } else {
                    yy5Var.j(Typography.less);
                    yy5Var.v(zy5.Rawtext);
                }
            }
        };
        RawtextLessthanSign = zy5Var13;
        zy5 zy5Var14 = new zy5("RawtextEndTagOpen", 14) { // from class: zy5.f
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readEndTag(yy5Var, b10Var, zy5.RawtextEndTagName, zy5.Rawtext);
            }
        };
        RawtextEndTagOpen = zy5Var14;
        zy5 zy5Var15 = new zy5("RawtextEndTagName", 15) { // from class: zy5.g
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.handleDataEndTag(yy5Var, b10Var, zy5.Rawtext);
            }
        };
        RawtextEndTagName = zy5Var15;
        zy5 zy5Var16 = new zy5("ScriptDataLessthanSign", 16) { // from class: zy5.h
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '!') {
                    yy5Var.l("<!");
                    yy5Var.v(zy5.ScriptDataEscapeStart);
                } else if (c2 == '/') {
                    yy5Var.i();
                    yy5Var.v(zy5.ScriptDataEndTagOpen);
                } else {
                    yy5Var.l("<");
                    b10Var.G();
                    yy5Var.v(zy5.ScriptData);
                }
            }
        };
        ScriptDataLessthanSign = zy5Var16;
        zy5 zy5Var17 = new zy5("ScriptDataEndTagOpen", 17) { // from class: zy5.i
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.readEndTag(yy5Var, b10Var, zy5.ScriptDataEndTagName, zy5.ScriptData);
            }
        };
        ScriptDataEndTagOpen = zy5Var17;
        zy5 zy5Var18 = new zy5("ScriptDataEndTagName", 18) { // from class: zy5.j
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.handleDataEndTag(yy5Var, b10Var, zy5.ScriptData);
            }
        };
        ScriptDataEndTagName = zy5Var18;
        zy5 zy5Var19 = new zy5("ScriptDataEscapeStart", 19) { // from class: zy5.l
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.u('-')) {
                    yy5Var.v(zy5.ScriptData);
                } else {
                    yy5Var.j('-');
                    yy5Var.b(zy5.ScriptDataEscapeStartDash);
                }
            }
        };
        ScriptDataEscapeStart = zy5Var19;
        zy5 zy5Var20 = new zy5("ScriptDataEscapeStartDash", 20) { // from class: zy5.m
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.u('-')) {
                    yy5Var.v(zy5.ScriptData);
                } else {
                    yy5Var.j('-');
                    yy5Var.b(zy5.ScriptDataEscapedDashDash);
                }
            }
        };
        ScriptDataEscapeStartDash = zy5Var20;
        zy5 zy5Var21 = new zy5("ScriptDataEscaped", 21) { // from class: zy5.n
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.q()) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                    return;
                }
                char cP = b10Var.p();
                if (cP == 0) {
                    yy5Var.r(this);
                    b10Var.a();
                    yy5Var.j((char) 65533);
                } else if (cP == '-') {
                    yy5Var.j('-');
                    yy5Var.b(zy5.ScriptDataEscapedDash);
                } else if (cP != '<') {
                    yy5Var.l(b10Var.l('-', Typography.less, 0));
                } else {
                    yy5Var.b(zy5.ScriptDataEscapedLessthanSign);
                }
            }
        };
        ScriptDataEscaped = zy5Var21;
        zy5 zy5Var22 = new zy5("ScriptDataEscapedDash", 22) { // from class: zy5.o
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.q()) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                    return;
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.j((char) 65533);
                    yy5Var.v(zy5.ScriptDataEscaped);
                } else if (c2 == '-') {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataEscapedDashDash);
                } else if (c2 == '<') {
                    yy5Var.v(zy5.ScriptDataEscapedLessthanSign);
                } else {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataEscaped);
                }
            }
        };
        ScriptDataEscapedDash = zy5Var22;
        zy5 zy5Var23 = new zy5("ScriptDataEscapedDashDash", 23) { // from class: zy5.p
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.q()) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                    return;
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.j((char) 65533);
                    yy5Var.v(zy5.ScriptDataEscaped);
                } else {
                    if (c2 == '-') {
                        yy5Var.j(c2);
                        return;
                    }
                    if (c2 == '<') {
                        yy5Var.v(zy5.ScriptDataEscapedLessthanSign);
                    } else if (c2 != '>') {
                        yy5Var.j(c2);
                        yy5Var.v(zy5.ScriptDataEscaped);
                    } else {
                        yy5Var.j(c2);
                        yy5Var.v(zy5.ScriptData);
                    }
                }
            }
        };
        ScriptDataEscapedDashDash = zy5Var23;
        zy5 zy5Var24 = new zy5("ScriptDataEscapedLessthanSign", 24) { // from class: zy5.q
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.A()) {
                    if (b10Var.u('/')) {
                        yy5Var.i();
                        yy5Var.b(zy5.ScriptDataEscapedEndTagOpen);
                        return;
                    } else {
                        yy5Var.j(Typography.less);
                        yy5Var.v(zy5.ScriptDataEscaped);
                        return;
                    }
                }
                yy5Var.i();
                yy5Var.h.append(b10Var.p());
                yy5Var.l("<" + b10Var.p());
                yy5Var.b(zy5.ScriptDataDoubleEscapeStart);
            }
        };
        ScriptDataEscapedLessthanSign = zy5Var24;
        zy5 zy5Var25 = new zy5("ScriptDataEscapedEndTagOpen", 25) { // from class: zy5.r
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.A()) {
                    yy5Var.l("</");
                    yy5Var.v(zy5.ScriptDataEscaped);
                } else {
                    yy5Var.h(false);
                    yy5Var.i.t(b10Var.p());
                    yy5Var.h.append(b10Var.p());
                    yy5Var.b(zy5.ScriptDataEscapedEndTagName);
                }
            }
        };
        ScriptDataEscapedEndTagOpen = zy5Var25;
        zy5 zy5Var26 = new zy5("ScriptDataEscapedEndTagName", 26) { // from class: zy5.s
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.handleDataEndTag(yy5Var, b10Var, zy5.ScriptDataEscaped);
            }
        };
        ScriptDataEscapedEndTagName = zy5Var26;
        zy5 zy5Var27 = new zy5("ScriptDataDoubleEscapeStart", 27) { // from class: zy5.t
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.handleDataDoubleEscapeTag(yy5Var, b10Var, zy5.ScriptDataDoubleEscaped, zy5.ScriptDataEscaped);
            }
        };
        ScriptDataDoubleEscapeStart = zy5Var27;
        zy5 zy5Var28 = new zy5("ScriptDataDoubleEscaped", 28) { // from class: zy5.u
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char cP = b10Var.p();
                if (cP == 0) {
                    yy5Var.r(this);
                    b10Var.a();
                    yy5Var.j((char) 65533);
                } else if (cP == '-') {
                    yy5Var.j(cP);
                    yy5Var.b(zy5.ScriptDataDoubleEscapedDash);
                } else if (cP == '<') {
                    yy5Var.j(cP);
                    yy5Var.b(zy5.ScriptDataDoubleEscapedLessthanSign);
                } else if (cP != 65535) {
                    yy5Var.l(b10Var.l('-', Typography.less, 0));
                } else {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                }
            }
        };
        ScriptDataDoubleEscaped = zy5Var28;
        zy5 zy5Var29 = new zy5("ScriptDataDoubleEscapedDash", 29) { // from class: zy5.w
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.j((char) 65533);
                    yy5Var.v(zy5.ScriptDataDoubleEscaped);
                } else if (c2 == '-') {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataDoubleEscapedDashDash);
                } else if (c2 == '<') {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataDoubleEscapedLessthanSign);
                } else if (c2 != 65535) {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataDoubleEscaped);
                } else {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                }
            }
        };
        ScriptDataDoubleEscapedDash = zy5Var29;
        zy5 zy5Var30 = new zy5("ScriptDataDoubleEscapedDashDash", 30) { // from class: zy5.x
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.j((char) 65533);
                    yy5Var.v(zy5.ScriptDataDoubleEscaped);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.j(c2);
                    return;
                }
                if (c2 == '<') {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataDoubleEscapedLessthanSign);
                } else if (c2 == '>') {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptData);
                } else if (c2 != 65535) {
                    yy5Var.j(c2);
                    yy5Var.v(zy5.ScriptDataDoubleEscaped);
                } else {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                }
            }
        };
        ScriptDataDoubleEscapedDashDash = zy5Var30;
        zy5 zy5Var31 = new zy5("ScriptDataDoubleEscapedLessthanSign", 31) { // from class: zy5.y
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (!b10Var.u('/')) {
                    yy5Var.v(zy5.ScriptDataDoubleEscaped);
                    return;
                }
                yy5Var.j('/');
                yy5Var.i();
                yy5Var.b(zy5.ScriptDataDoubleEscapeEnd);
            }
        };
        ScriptDataDoubleEscapedLessthanSign = zy5Var31;
        zy5 zy5Var32 = new zy5("ScriptDataDoubleEscapeEnd", 32) { // from class: zy5.z
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                zy5.handleDataDoubleEscapeTag(yy5Var, b10Var, zy5.ScriptDataEscaped, zy5.ScriptDataDoubleEscaped);
            }
        };
        ScriptDataDoubleEscapeEnd = zy5Var32;
        zy5 zy5Var33 = new zy5("BeforeAttributeName", 33) { // from class: zy5.a0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.B();
                    b10Var.G();
                    yy5Var.v(zy5.AttributeName);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 != '\"' && c2 != '\'') {
                        if (c2 == '/') {
                            yy5Var.v(zy5.SelfClosingStartTag);
                            return;
                        }
                        if (c2 == 65535) {
                            yy5Var.q(this);
                            yy5Var.v(zy5.Data);
                            return;
                        }
                        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r') {
                            return;
                        }
                        switch (c2) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                yy5Var.p();
                                yy5Var.v(zy5.Data);
                                break;
                            default:
                                yy5Var.i.B();
                                b10Var.G();
                                yy5Var.v(zy5.AttributeName);
                                break;
                        }
                        return;
                    }
                    yy5Var.r(this);
                    yy5Var.i.B();
                    yy5Var.i.o(c2);
                    yy5Var.v(zy5.AttributeName);
                }
            }
        };
        BeforeAttributeName = zy5Var33;
        zy5 zy5Var34 = new zy5("AttributeName", 34) { // from class: zy5.b0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                yy5Var.i.p(b10Var.m(zy5.attributeNameCharsSorted));
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.o((char) 65533);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 != '\"' && c2 != '\'') {
                        if (c2 == '/') {
                            yy5Var.v(zy5.SelfClosingStartTag);
                            return;
                        }
                        if (c2 == 65535) {
                            yy5Var.q(this);
                            yy5Var.v(zy5.Data);
                            return;
                        } else if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r') {
                            switch (c2) {
                                case '=':
                                    yy5Var.v(zy5.BeforeAttributeValue);
                                    break;
                                case '>':
                                    yy5Var.p();
                                    yy5Var.v(zy5.Data);
                                    break;
                            }
                            return;
                        }
                    }
                    yy5Var.r(this);
                    yy5Var.i.o(c2);
                    return;
                }
                yy5Var.v(zy5.AfterAttributeName);
            }
        };
        AttributeName = zy5Var34;
        zy5 zy5Var35 = new zy5("AfterAttributeName", 35) { // from class: zy5.c0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.o((char) 65533);
                    yy5Var.v(zy5.AttributeName);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 != '\"' && c2 != '\'') {
                        if (c2 == '/') {
                            yy5Var.v(zy5.SelfClosingStartTag);
                            return;
                        }
                        if (c2 == 65535) {
                            yy5Var.q(this);
                            yy5Var.v(zy5.Data);
                            return;
                        }
                        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r') {
                            return;
                        }
                        switch (c2) {
                            case '<':
                                break;
                            case '=':
                                yy5Var.v(zy5.BeforeAttributeValue);
                                break;
                            case '>':
                                yy5Var.p();
                                yy5Var.v(zy5.Data);
                                break;
                            default:
                                yy5Var.i.B();
                                b10Var.G();
                                yy5Var.v(zy5.AttributeName);
                                break;
                        }
                        return;
                    }
                    yy5Var.r(this);
                    yy5Var.i.B();
                    yy5Var.i.o(c2);
                    yy5Var.v(zy5.AttributeName);
                }
            }
        };
        AfterAttributeName = zy5Var35;
        zy5 zy5Var36 = new zy5("BeforeAttributeValue", 36) { // from class: zy5.d0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.q((char) 65533);
                    yy5Var.v(zy5.AttributeValue_unquoted);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 == '\"') {
                        yy5Var.v(zy5.AttributeValue_doubleQuoted);
                        return;
                    }
                    if (c2 != '`') {
                        if (c2 == 65535) {
                            yy5Var.q(this);
                            yy5Var.p();
                            yy5Var.v(zy5.Data);
                            return;
                        }
                        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r') {
                            return;
                        }
                        if (c2 == '&') {
                            b10Var.G();
                            yy5Var.v(zy5.AttributeValue_unquoted);
                            return;
                        }
                        if (c2 == '\'') {
                            yy5Var.v(zy5.AttributeValue_singleQuoted);
                            return;
                        }
                        switch (c2) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                yy5Var.r(this);
                                yy5Var.p();
                                yy5Var.v(zy5.Data);
                                break;
                            default:
                                b10Var.G();
                                yy5Var.v(zy5.AttributeValue_unquoted);
                                break;
                        }
                        return;
                    }
                    yy5Var.r(this);
                    yy5Var.i.q(c2);
                    yy5Var.v(zy5.AttributeValue_unquoted);
                }
            }
        };
        BeforeAttributeValue = zy5Var36;
        zy5 zy5Var37 = new zy5("AttributeValue_doubleQuoted", 37) { // from class: zy5.e0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                String strL = b10Var.l(zy5.attributeDoubleValueCharsSorted);
                if (strL.length() > 0) {
                    yy5Var.i.r(strL);
                } else {
                    yy5Var.i.E();
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.q((char) 65533);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.v(zy5.AfterAttributeValue_quoted);
                    return;
                }
                if (c2 != '&') {
                    if (c2 != 65535) {
                        return;
                    }
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                    return;
                }
                int[] iArrE = yy5Var.e(Character.valueOf(Typography.quote), true);
                if (iArrE != null) {
                    yy5Var.i.s(iArrE);
                } else {
                    yy5Var.i.q(Typography.amp);
                }
            }
        };
        AttributeValue_doubleQuoted = zy5Var37;
        zy5 zy5Var38 = new zy5("AttributeValue_singleQuoted", 38) { // from class: zy5.f0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                String strL = b10Var.l(zy5.attributeSingleValueCharsSorted);
                if (strL.length() > 0) {
                    yy5Var.i.r(strL);
                } else {
                    yy5Var.i.E();
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.q((char) 65533);
                    return;
                }
                if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                } else if (c2 != '&') {
                    if (c2 != '\'') {
                        return;
                    }
                    yy5Var.v(zy5.AfterAttributeValue_quoted);
                } else {
                    int[] iArrE = yy5Var.e('\'', true);
                    if (iArrE != null) {
                        yy5Var.i.s(iArrE);
                    } else {
                        yy5Var.i.q(Typography.amp);
                    }
                }
            }
        };
        AttributeValue_singleQuoted = zy5Var38;
        zy5 zy5Var39 = new zy5("AttributeValue_unquoted", 39) { // from class: zy5.h0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                String strM = b10Var.m(zy5.attributeValueUnquoted);
                if (strM.length() > 0) {
                    yy5Var.i.r(strM);
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.i.q((char) 65533);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 != '\"' && c2 != '`') {
                        if (c2 == 65535) {
                            yy5Var.q(this);
                            yy5Var.v(zy5.Data);
                            return;
                        }
                        if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r') {
                            if (c2 == '&') {
                                int[] iArrE = yy5Var.e(Character.valueOf(Typography.greater), true);
                                if (iArrE != null) {
                                    yy5Var.i.s(iArrE);
                                    return;
                                } else {
                                    yy5Var.i.q(Typography.amp);
                                    return;
                                }
                            }
                            if (c2 != '\'') {
                                switch (c2) {
                                    case '>':
                                        yy5Var.p();
                                        yy5Var.v(zy5.Data);
                                        break;
                                }
                                return;
                            }
                        }
                    }
                    yy5Var.r(this);
                    yy5Var.i.q(c2);
                    return;
                }
                yy5Var.v(zy5.BeforeAttributeName);
            }
        };
        AttributeValue_unquoted = zy5Var39;
        zy5 zy5Var40 = new zy5("AfterAttributeValue_quoted", 40) { // from class: zy5.i0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    yy5Var.v(zy5.BeforeAttributeName);
                    return;
                }
                if (c2 == '/') {
                    yy5Var.v(zy5.SelfClosingStartTag);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.p();
                    yy5Var.v(zy5.Data);
                } else if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                } else {
                    yy5Var.r(this);
                    b10Var.G();
                    yy5Var.v(zy5.BeforeAttributeName);
                }
            }
        };
        AfterAttributeValue_quoted = zy5Var40;
        zy5 zy5Var41 = new zy5("SelfClosingStartTag", 41) { // from class: zy5.j0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '>') {
                    yy5Var.i.i = true;
                    yy5Var.p();
                    yy5Var.v(zy5.Data);
                } else if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.v(zy5.Data);
                } else {
                    yy5Var.r(this);
                    b10Var.G();
                    yy5Var.v(zy5.BeforeAttributeName);
                }
            }
        };
        SelfClosingStartTag = zy5Var41;
        zy5 zy5Var42 = new zy5("BogusComment", 42) { // from class: zy5.k0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                b10Var.G();
                vy5.c cVar = new vy5.c();
                cVar.c = true;
                cVar.b.append(b10Var.j(Typography.greater));
                yy5Var.k(cVar);
                yy5Var.b(zy5.Data);
            }
        };
        BogusComment = zy5Var42;
        zy5 zy5Var43 = new zy5("MarkupDeclarationOpen", 43) { // from class: zy5.l0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.s(HttpClient.ENDFLAG)) {
                    yy5Var.f();
                    yy5Var.v(zy5.CommentStart);
                } else if (b10Var.t("DOCTYPE")) {
                    yy5Var.v(zy5.Doctype);
                } else if (b10Var.s("[CDATA[")) {
                    yy5Var.v(zy5.CdataSection);
                } else {
                    yy5Var.r(this);
                    yy5Var.b(zy5.BogusComment);
                }
            }
        };
        MarkupDeclarationOpen = zy5Var43;
        zy5 zy5Var44 = new zy5("CommentStart", 44) { // from class: zy5.m0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.n.b.append((char) 65533);
                    yy5Var.v(zy5.Comment);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.v(zy5.CommentStartDash);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else if (c2 != 65535) {
                    yy5Var.n.b.append(c2);
                    yy5Var.v(zy5.Comment);
                } else {
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        CommentStart = zy5Var44;
        zy5 zy5Var45 = new zy5("CommentStartDash", 45) { // from class: zy5.n0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.n.b.append((char) 65533);
                    yy5Var.v(zy5.Comment);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.v(zy5.CommentStartDash);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else if (c2 != 65535) {
                    yy5Var.n.b.append(c2);
                    yy5Var.v(zy5.Comment);
                } else {
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        CommentStartDash = zy5Var45;
        zy5 zy5Var46 = new zy5("Comment", 46) { // from class: zy5.o0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char cP = b10Var.p();
                if (cP == 0) {
                    yy5Var.r(this);
                    b10Var.a();
                    yy5Var.n.b.append((char) 65533);
                } else if (cP == '-') {
                    yy5Var.b(zy5.CommentEndDash);
                } else {
                    if (cP != 65535) {
                        yy5Var.n.b.append(b10Var.l('-', 0));
                        return;
                    }
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        Comment = zy5Var46;
        zy5 zy5Var47 = new zy5("CommentEndDash", 47) { // from class: zy5.p0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    StringBuilder sb = yy5Var.n.b;
                    sb.append('-');
                    sb.append((char) 65533);
                    yy5Var.v(zy5.Comment);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.v(zy5.CommentEnd);
                    return;
                }
                if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else {
                    StringBuilder sb2 = yy5Var.n.b;
                    sb2.append('-');
                    sb2.append(c2);
                    yy5Var.v(zy5.Comment);
                }
            }
        };
        CommentEndDash = zy5Var47;
        zy5 zy5Var48 = new zy5("CommentEnd", 48) { // from class: zy5.q0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    StringBuilder sb = yy5Var.n.b;
                    sb.append(HttpClient.ENDFLAG);
                    sb.append((char) 65533);
                    yy5Var.v(zy5.Comment);
                    return;
                }
                if (c2 == '!') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.CommentEndBang);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.r(this);
                    yy5Var.n.b.append('-');
                    return;
                }
                if (c2 == '>') {
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else {
                    yy5Var.r(this);
                    StringBuilder sb2 = yy5Var.n.b;
                    sb2.append(HttpClient.ENDFLAG);
                    sb2.append(c2);
                    yy5Var.v(zy5.Comment);
                }
            }
        };
        CommentEnd = zy5Var48;
        zy5 zy5Var49 = new zy5("CommentEndBang", 49) { // from class: zy5.s0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    StringBuilder sb = yy5Var.n.b;
                    sb.append("--!");
                    sb.append((char) 65533);
                    yy5Var.v(zy5.Comment);
                    return;
                }
                if (c2 == '-') {
                    yy5Var.n.b.append("--!");
                    yy5Var.v(zy5.CommentEndDash);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else if (c2 == 65535) {
                    yy5Var.q(this);
                    yy5Var.n();
                    yy5Var.v(zy5.Data);
                } else {
                    StringBuilder sb2 = yy5Var.n.b;
                    sb2.append("--!");
                    sb2.append(c2);
                    yy5Var.v(zy5.Comment);
                }
            }
        };
        CommentEndBang = zy5Var49;
        zy5 zy5Var50 = new zy5("Doctype", 50) { // from class: zy5.t0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    yy5Var.v(zy5.BeforeDoctypeName);
                    return;
                }
                if (c2 != '>') {
                    if (c2 != 65535) {
                        yy5Var.r(this);
                        yy5Var.v(zy5.BeforeDoctypeName);
                        return;
                    }
                    yy5Var.q(this);
                }
                yy5Var.r(this);
                yy5Var.g();
                yy5Var.m.e = true;
                yy5Var.o();
                yy5Var.v(zy5.Data);
            }
        };
        Doctype = zy5Var50;
        zy5 zy5Var51 = new zy5("BeforeDoctypeName", 51) { // from class: zy5.u0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.A()) {
                    yy5Var.g();
                    yy5Var.v(zy5.DoctypeName);
                    return;
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.g();
                    yy5Var.m.b.append((char) 65533);
                    yy5Var.v(zy5.DoctypeName);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 == 65535) {
                        yy5Var.q(this);
                        yy5Var.g();
                        yy5Var.m.e = true;
                        yy5Var.o();
                        yy5Var.v(zy5.Data);
                        return;
                    }
                    if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r') {
                        return;
                    }
                    yy5Var.g();
                    yy5Var.m.b.append(c2);
                    yy5Var.v(zy5.DoctypeName);
                }
            }
        };
        BeforeDoctypeName = zy5Var51;
        zy5 zy5Var52 = new zy5("DoctypeName", 52) { // from class: zy5.v0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.A()) {
                    yy5Var.m.b.append(b10Var.g());
                    return;
                }
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.m.b.append((char) 65533);
                    return;
                }
                if (c2 != ' ') {
                    if (c2 == '>') {
                        yy5Var.o();
                        yy5Var.v(zy5.Data);
                        return;
                    }
                    if (c2 == 65535) {
                        yy5Var.q(this);
                        yy5Var.m.e = true;
                        yy5Var.o();
                        yy5Var.v(zy5.Data);
                        return;
                    }
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r') {
                        yy5Var.m.b.append(c2);
                        return;
                    }
                }
                yy5Var.v(zy5.AfterDoctypeName);
            }
        };
        DoctypeName = zy5Var52;
        zy5 zy5Var53 = new zy5("AfterDoctypeName", 53) { // from class: zy5.w0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                if (b10Var.q()) {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (b10Var.w('\t', '\n', '\r', '\f', ' ')) {
                    b10Var.a();
                    return;
                }
                if (b10Var.u(Typography.greater)) {
                    yy5Var.o();
                    yy5Var.b(zy5.Data);
                } else if (b10Var.t("PUBLIC")) {
                    yy5Var.v(zy5.AfterDoctypePublicKeyword);
                } else {
                    if (b10Var.t("SYSTEM")) {
                        yy5Var.v(zy5.AfterDoctypeSystemKeyword);
                        return;
                    }
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.b(zy5.BogusDoctype);
                }
            }
        };
        AfterDoctypeName = zy5Var53;
        zy5 zy5Var54 = new zy5("AfterDoctypePublicKeyword", 54) { // from class: zy5.x0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    yy5Var.v(zy5.BeforeDoctypePublicIdentifier);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypePublicIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypePublicIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        AfterDoctypePublicKeyword = zy5Var54;
        zy5 zy5Var55 = new zy5("BeforeDoctypePublicIdentifier", 55) { // from class: zy5.y0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.v(zy5.DoctypePublicIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.v(zy5.DoctypePublicIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        BeforeDoctypePublicIdentifier = zy5Var55;
        zy5 zy5Var56 = new zy5("DoctypePublicIdentifier_doubleQuoted", 56) { // from class: zy5.z0
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.m.c.append((char) 65533);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.v(zy5.AfterDoctypePublicIdentifier);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.m.c.append(c2);
                    return;
                }
                yy5Var.q(this);
                yy5Var.m.e = true;
                yy5Var.o();
                yy5Var.v(zy5.Data);
            }
        };
        DoctypePublicIdentifier_doubleQuoted = zy5Var56;
        zy5 zy5Var57 = new zy5("DoctypePublicIdentifier_singleQuoted", 57) { // from class: zy5.a1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.m.c.append((char) 65533);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.v(zy5.AfterDoctypePublicIdentifier);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.m.c.append(c2);
                    return;
                }
                yy5Var.q(this);
                yy5Var.m.e = true;
                yy5Var.o();
                yy5Var.v(zy5.Data);
            }
        };
        DoctypePublicIdentifier_singleQuoted = zy5Var57;
        zy5 zy5Var58 = new zy5("AfterDoctypePublicIdentifier", 58) { // from class: zy5.b1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    yy5Var.v(zy5.BetweenDoctypePublicAndSystemIdentifiers);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                } else if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        AfterDoctypePublicIdentifier = zy5Var58;
        zy5 zy5Var59 = new zy5("BetweenDoctypePublicAndSystemIdentifiers", 59) { // from class: zy5.d1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                } else if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        BetweenDoctypePublicAndSystemIdentifiers = zy5Var59;
        zy5 zy5Var60 = new zy5("AfterDoctypeSystemKeyword", 60) { // from class: zy5.e1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    yy5Var.v(zy5.BeforeDoctypeSystemIdentifier);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.r(this);
                    yy5Var.v(zy5.DoctypeSystemIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        AfterDoctypeSystemKeyword = zy5Var60;
        zy5 zy5Var61 = new zy5("BeforeDoctypeSystemIdentifier", 61) { // from class: zy5.f1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.v(zy5.DoctypeSystemIdentifier_doubleQuoted);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.v(zy5.DoctypeSystemIdentifier_singleQuoted);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        BeforeDoctypeSystemIdentifier = zy5Var61;
        zy5 zy5Var62 = new zy5("DoctypeSystemIdentifier_doubleQuoted", 62) { // from class: zy5.g1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.m.d.append((char) 65533);
                    return;
                }
                if (c2 == '\"') {
                    yy5Var.v(zy5.AfterDoctypeSystemIdentifier);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.m.d.append(c2);
                    return;
                }
                yy5Var.q(this);
                yy5Var.m.e = true;
                yy5Var.o();
                yy5Var.v(zy5.Data);
            }
        };
        DoctypeSystemIdentifier_doubleQuoted = zy5Var62;
        zy5 zy5Var63 = new zy5("DoctypeSystemIdentifier_singleQuoted", 63) { // from class: zy5.h1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == 0) {
                    yy5Var.r(this);
                    yy5Var.m.d.append((char) 65533);
                    return;
                }
                if (c2 == '\'') {
                    yy5Var.v(zy5.AfterDoctypeSystemIdentifier);
                    return;
                }
                if (c2 == '>') {
                    yy5Var.r(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                    return;
                }
                if (c2 != 65535) {
                    yy5Var.m.d.append(c2);
                    return;
                }
                yy5Var.q(this);
                yy5Var.m.e = true;
                yy5Var.o();
                yy5Var.v(zy5.Data);
            }
        };
        DoctypeSystemIdentifier_singleQuoted = zy5Var63;
        zy5 zy5Var64 = new zy5("AfterDoctypeSystemIdentifier", 64) { // from class: zy5.i1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    return;
                }
                if (c2 == '>') {
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                } else if (c2 != 65535) {
                    yy5Var.r(this);
                    yy5Var.v(zy5.BogusDoctype);
                } else {
                    yy5Var.q(this);
                    yy5Var.m.e = true;
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        AfterDoctypeSystemIdentifier = zy5Var64;
        zy5 zy5Var65 = new zy5("BogusDoctype", 65) { // from class: zy5.j1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                char c2 = b10Var.c();
                if (c2 == '>') {
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                } else {
                    if (c2 != 65535) {
                        return;
                    }
                    yy5Var.o();
                    yy5Var.v(zy5.Data);
                }
            }
        };
        BogusDoctype = zy5Var65;
        zy5 zy5Var66 = new zy5("CdataSection", 66) { // from class: zy5.k1
            {
                k kVar2 = null;
            }

            @Override // defpackage.zy5
            public void read(yy5 yy5Var, b10 b10Var) {
                yy5Var.l(b10Var.k("]]>"));
                b10Var.s("]]>");
                yy5Var.v(zy5.Data);
            }
        };
        CdataSection = zy5Var66;
        $VALUES = new zy5[]{kVar, zy5Var, zy5Var2, zy5Var3, zy5Var4, zy5Var5, zy5Var6, zy5Var7, zy5Var8, zy5Var9, zy5Var10, zy5Var11, zy5Var12, zy5Var13, zy5Var14, zy5Var15, zy5Var16, zy5Var17, zy5Var18, zy5Var19, zy5Var20, zy5Var21, zy5Var22, zy5Var23, zy5Var24, zy5Var25, zy5Var26, zy5Var27, zy5Var28, zy5Var29, zy5Var30, zy5Var31, zy5Var32, zy5Var33, zy5Var34, zy5Var35, zy5Var36, zy5Var37, zy5Var38, zy5Var39, zy5Var40, zy5Var41, zy5Var42, zy5Var43, zy5Var44, zy5Var45, zy5Var46, zy5Var47, zy5Var48, zy5Var49, zy5Var50, zy5Var51, zy5Var52, zy5Var53, zy5Var54, zy5Var55, zy5Var56, zy5Var57, zy5Var58, zy5Var59, zy5Var60, zy5Var61, zy5Var62, zy5Var63, zy5Var64, zy5Var65, zy5Var66};
        char[] cArr = {'\'', Typography.amp, 0};
        attributeSingleValueCharsSorted = cArr;
        char[] cArr2 = {Typography.quote, Typography.amp, 0};
        attributeDoubleValueCharsSorted = cArr2;
        char[] cArr3 = {'\t', '\n', '\r', '\f', ' ', '/', '=', Typography.greater, 0, Typography.quote, '\'', Typography.less};
        attributeNameCharsSorted = cArr3;
        char[] cArr4 = {'\t', '\n', '\r', '\f', ' ', Typography.amp, Typography.greater, 0, Typography.quote, '\'', Typography.less, '=', '`'};
        attributeValueUnquoted = cArr4;
        replacementStr = String.valueOf((char) 65533);
        Arrays.sort(cArr);
        Arrays.sort(cArr2);
        Arrays.sort(cArr3);
        Arrays.sort(cArr4);
    }

    private zy5(String str, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(yy5 yy5Var, b10 b10Var, zy5 zy5Var, zy5 zy5Var2) {
        if (b10Var.A()) {
            String strG = b10Var.g();
            yy5Var.h.append(strG);
            yy5Var.l(strG);
            return;
        }
        char c2 = b10Var.c();
        if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ' && c2 != '/' && c2 != '>') {
            b10Var.G();
            yy5Var.v(zy5Var2);
        } else {
            if (yy5Var.h.toString().equals("script")) {
                yy5Var.v(zy5Var);
            } else {
                yy5Var.v(zy5Var2);
            }
            yy5Var.j(c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(yy5 yy5Var, b10 b10Var, zy5 zy5Var) {
        if (b10Var.A()) {
            String strG = b10Var.g();
            yy5Var.i.u(strG);
            yy5Var.h.append(strG);
            return;
        }
        boolean z2 = true;
        if (yy5Var.t() && !b10Var.q()) {
            char c2 = b10Var.c();
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                yy5Var.v(BeforeAttributeName);
            } else if (c2 == '/') {
                yy5Var.v(SelfClosingStartTag);
            } else if (c2 != '>') {
                yy5Var.h.append(c2);
            } else {
                yy5Var.p();
                yy5Var.v(Data);
            }
            z2 = false;
        }
        if (z2) {
            yy5Var.l("</" + yy5Var.h.toString());
            yy5Var.v(zy5Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(yy5 yy5Var, zy5 zy5Var) {
        int[] iArrE = yy5Var.e(null, false);
        if (iArrE == null) {
            yy5Var.j(Typography.amp);
        } else {
            yy5Var.m(iArrE);
        }
        yy5Var.v(zy5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(yy5 yy5Var, b10 b10Var, zy5 zy5Var, zy5 zy5Var2) {
        char cP = b10Var.p();
        if (cP == 0) {
            yy5Var.r(zy5Var);
            b10Var.a();
            yy5Var.j((char) 65533);
        } else if (cP == '<') {
            yy5Var.b(zy5Var2);
        } else if (cP != 65535) {
            yy5Var.l(b10Var.l(Typography.less, 0));
        } else {
            yy5Var.k(new vy5.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(yy5 yy5Var, b10 b10Var, zy5 zy5Var, zy5 zy5Var2) {
        if (b10Var.A()) {
            yy5Var.h(false);
            yy5Var.v(zy5Var);
        } else {
            yy5Var.l("</");
            yy5Var.v(zy5Var2);
        }
    }

    public static zy5 valueOf(String str) {
        return (zy5) Enum.valueOf(zy5.class, str);
    }

    public static zy5[] values() {
        return (zy5[]) $VALUES.clone();
    }

    public abstract void read(yy5 yy5Var, b10 b10Var);

    public /* synthetic */ zy5(String str, int i2, k kVar) {
        this(str, i2);
    }
}

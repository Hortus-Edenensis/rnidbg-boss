package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpMultipart extends AbstractMultipartForm {
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;

    /* JADX INFO: renamed from: org.apache.http.entity.mime.HttpMultipart$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode;

        static {
            int[] iArr = new int[HttpMultipartMode.values().length];
            $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = iArr;
            try {
                iArr[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        super(str, charset, str2);
        this.mode = httpMultipartMode;
        this.parts = new ArrayList();
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return;
        }
        this.parts.add(formBodyPart);
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        if (AnonymousClass1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[this.mode.ordinal()] != 1) {
            Iterator<MinimalField> it = header.iterator();
            while (it.hasNext()) {
                AbstractMultipartForm.writeField(it.next(), outputStream);
            }
        } else {
            AbstractMultipartForm.writeField(header.getField(MIME.CONTENT_DISPOSITION), this.charset, outputStream);
            if (formBodyPart.getBody().getFilename() != null) {
                AbstractMultipartForm.writeField(header.getField("Content-Type"), this.charset, outputStream);
            }
        }
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getBoundary() {
        return super.getBoundary();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ Charset getCharset() {
        return super.getCharset();
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getSubType() {
        return super.getSubType();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ long getTotalLength() {
        return super.getTotalLength();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
    }
}

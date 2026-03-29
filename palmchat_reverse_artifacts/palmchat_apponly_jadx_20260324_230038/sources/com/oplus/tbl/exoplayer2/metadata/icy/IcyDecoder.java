package com.oplus.tbl.exoplayer2.metadata.icy;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.MetadataInputBuffer;
import com.oplus.tbl.exoplayer2.metadata.SimpleMetadataDecoder;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.f10;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class IcyDecoder extends SimpleMetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private static final String STREAM_KEY_NAME = "streamtitle";
    private static final String STREAM_KEY_URL = "streamurl";
    private final CharsetDecoder utf8Decoder = f10.c.newDecoder();
    private final CharsetDecoder iso88591Decoder = f10.b.newDecoder();

    @Nullable
    private String decodeToString(ByteBuffer byteBuffer) {
        String string;
        CharsetDecoder charsetDecoder;
        try {
            string = this.utf8Decoder.decode(byteBuffer).toString();
            charsetDecoder = this.utf8Decoder;
        } catch (CharacterCodingException unused) {
            this.utf8Decoder.reset();
            byteBuffer.rewind();
            try {
                string = this.iso88591Decoder.decode(byteBuffer).toString();
                charsetDecoder = this.iso88591Decoder;
            } catch (CharacterCodingException unused2) {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.utf8Decoder.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return string;
    }

    @Override // com.oplus.tbl.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String strDecodeToString = decodeToString(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strDecodeToString == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = METADATA_ELEMENT.matcher(strDecodeToString);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String strGroup = matcher.group(2);
            if (lowerInvariant != null) {
                if (lowerInvariant.equals(STREAM_KEY_URL)) {
                    str2 = strGroup;
                } else if (lowerInvariant.equals(STREAM_KEY_NAME)) {
                    str = strGroup;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}

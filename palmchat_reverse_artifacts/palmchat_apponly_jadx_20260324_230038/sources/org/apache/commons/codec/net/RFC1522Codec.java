package org.apache.commons.codec.net;

import com.oplus.tblplayer.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
abstract class RFC1522Codec {
    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("=?") || !str.endsWith("?=")) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET, 2);
        if (iIndexOf == -1 || iIndexOf == length) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String strSubstring = str.substring(2, iIndexOf);
        if (strSubstring.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(Constants.STRING_VALUE_UNSET, i);
        if (iIndexOf2 == -1 || iIndexOf2 == length) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String strSubstring2 = str.substring(i, iIndexOf2);
        if (getEncoding().equalsIgnoreCase(strSubstring2)) {
            int i2 = iIndexOf2 + 1;
            return new String(doDecoding(str.substring(i2, str.indexOf(Constants.STRING_VALUE_UNSET, i2)).getBytes("US-ASCII")), strSubstring);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("This codec cannot decode ");
        stringBuffer.append(strSubstring2);
        stringBuffer.append(" encoded content");
        throw new DecoderException(stringBuffer.toString());
    }

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("=?");
        stringBuffer.append(str2);
        stringBuffer.append('?');
        stringBuffer.append(getEncoding());
        stringBuffer.append('?');
        stringBuffer.append(new String(doEncoding(str.getBytes(str2)), "US-ASCII"));
        stringBuffer.append("?=");
        return stringBuffer.toString();
    }

    public abstract String getEncoding();
}

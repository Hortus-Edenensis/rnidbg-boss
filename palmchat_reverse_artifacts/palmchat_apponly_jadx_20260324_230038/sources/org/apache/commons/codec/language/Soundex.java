package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Soundex implements StringEncoder {
    private int maxLength;
    private char[] soundexMapping;
    public static final Soundex US_ENGLISH = new Soundex();
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    public static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();

    public Soundex() {
        this(US_ENGLISH_MAPPING);
    }

    private char getMappingCode(String str, int i) {
        char cCharAt;
        char map = map(str.charAt(i));
        if (i > 1 && map != '0' && ('H' == (cCharAt = str.charAt(i - 1)) || 'W' == cCharAt)) {
            char cCharAt2 = str.charAt(i - 2);
            if (map(cCharAt2) == map || 'H' == cCharAt2 || 'W' == cCharAt2) {
                return (char) 0;
            }
        }
        return map;
    }

    private char[] getSoundexMapping() {
        return this.soundexMapping;
    }

    private char map(char c) {
        int i = c - 'A';
        if (i >= 0 && i < getSoundexMapping().length) {
            return getSoundexMapping()[i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The character is not mapped: ");
        stringBuffer.append(c);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    private void setSoundexMapping(char[] cArr) {
        this.soundexMapping = cArr;
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return soundex((String) obj);
        }
        throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = strClean.charAt(0);
        char mappingCode = getMappingCode(strClean, 0);
        int i = 1;
        int i2 = 1;
        while (i < strClean.length() && i2 < 4) {
            int i3 = i + 1;
            char mappingCode2 = getMappingCode(strClean, i);
            if (mappingCode2 != 0) {
                if (mappingCode2 != '0' && mappingCode2 != mappingCode) {
                    cArr[i2] = mappingCode2;
                    i2++;
                }
                mappingCode = mappingCode2;
            }
            i = i3;
        }
        return new String(cArr);
    }

    public Soundex(char[] cArr) {
        this.maxLength = 4;
        setSoundexMapping(cArr);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }
}

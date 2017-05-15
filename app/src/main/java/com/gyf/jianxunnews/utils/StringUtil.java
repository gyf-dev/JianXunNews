package com.gyf.jianxunnews.utils;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type String util.
 */
public class StringUtil {
    /**
     * The constant pyvalue.
     */
    private static int[] pyvalue = new int[]{-20319, -20317, -20304, -20295, -20292, -20283, -20265, -20257, -20242, -20230, -20051, -20036, -20032,
            -20026, -20002, -19990, -19986, -19982, -19976, -19805, -19784, -19775, -19774, -19763, -19756, -19751, -19746, -19741, -19739, -19728,
            -19725, -19715, -19540, -19531, -19525, -19515, -19500, -19484, -19479, -19467, -19289, -19288, -19281, -19275, -19270, -19263, -19261,
            -19249, -19243, -19242, -19238, -19235, -19227, -19224, -19218, -19212, -19038, -19023, -19018, -19006, -19003, -18996, -18977, -18961,
            -18952, -18783, -18774, -18773, -18763, -18756, -18741, -18735, -18731, -18722, -18710, -18697, -18696, -18526, -18518, -18501, -18490,
            -18478, -18463, -18448, -18447, -18446, -18239, -18237, -18231, -18220, -18211, -18201, -18184, -18183, -18181, -18012, -17997, -17988,
            -17970, -17964, -17961, -17950, -17947, -17931, -17928, -17922, -17759, -17752, -17733, -17730, -17721, -17703, -17701, -17697, -17692,
            -17683, -17676, -17496, -17487, -17482, -17468, -17454, -17433, -17427, -17417, -17202, -17185, -16983, -16970, -16942, -16915, -16733,
            -16708, -16706, -16689, -16664, -16657, -16647, -16474, -16470, -16465, -16459, -16452, -16448, -16433, -16429, -16427, -16423, -16419,
            -16412, -16407, -16403, -16401, -16393, -16220, -16216, -16212, -16205, -16202, -16187, -16180, -16171, -16169, -16158, -16155, -15959,
            -15958, -15944, -15933, -15920, -15915, -15903, -15889, -15878, -15707, -15701, -15681, -15667, -15661, -15659, -15652, -15640, -15631,
            -15625, -15454, -15448, -15436, -15435, -15419, -15416, -15408, -15394, -15385, -15377, -15375, -15369, -15363, -15362, -15183, -15180,
            -15165, -15158, -15153, -15150, -15149, -15144, -15143, -15141, -15140, -15139, -15128, -15121, -15119, -15117, -15110, -15109, -14941,
            -14937, -14933, -14930, -14929, -14928, -14926, -14922, -14921, -14914, -14908, -14902, -14894, -14889, -14882, -14873, -14871, -14857,
            -14678, -14674, -14670, -14668, -14663, -14654, -14645, -14630, -14594, -14429, -14407, -14399, -14384, -14379, -14368, -14355, -14353,
            -14345, -14170, -14159, -14151, -14149, -14145, -14140, -14137, -14135, -14125, -14123, -14122, -14112, -14109, -14099, -14097, -14094,
            -14092, -14090, -14087, -14083, -13917, -13914, -13910, -13907, -13906, -13905, -13896, -13894, -13878, -13870, -13859, -13847, -13831,
            -13658, -13611, -13601, -13406, -13404, -13400, -13398, -13395, -13391, -13387, -13383, -13367, -13359, -13356, -13343, -13340, -13329,
            -13326, -13318, -13147, -13138, -13120, -13107, -13096, -13095, -13091, -13076, -13068, -13063, -13060, -12888, -12875, -12871, -12860,
            -12858, -12852, -12849, -12838, -12831, -12829, -12812, -12802, -12607, -12597, -12594, -12585, -12556, -12359, -12346, -12320, -12300,
            -12120, -12099, -12089, -12074, -12067, -12058, -12039, -11867, -11861, -11847, -11831, -11798, -11781, -11604, -11589, -11536, -11358,
            -11340, -11339, -11324, -11303, -11097, -11077, -11067, -11055, -11052, -11045, -11041, -11038, -11024, -11020, -11019, -11018, -11014,
            -10838, -10832, -10815, -10800, -10790, -10780, -10764, -10587, -10544, -10533, -10519, -10331, -10329, -10328, -10322, -10315, -10309,
            -10307, -10296, -10281, -10274, -10270, -10262, -10260, -10256, -10254};

    /**
     * The constant pystr.
     */
    public static String[] pystr = new String[]{"a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian",
            "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che",
            "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan",
            "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du",
            "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang",
            "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang",
            "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian",
            "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken",
            "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng",
            "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "lv", "luan", "lue", "lun", "luo", "ma", "mai",
            "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai",
            "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nv", "nuan",
            "nue", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pu",
            "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re",
            "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha",
            "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun",
            "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao",
            "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi",
            "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi",
            "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha",
            "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui",
            "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"};


    /**
     * Gets chs ascii.
     * 汉字转成ASCII码
     *
     * @param chs the chs
     * @return the chs ascii
     */
    public static int getChsAscii(String chs) {
        int asc = 0;
        try {
            byte[] bytes = chs.getBytes("gb2312");
            /*if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                throw new RuntimeException("illegal resource string");
            }*/
            if (bytes.length == 1) {
                asc = bytes[0];
            }
            if (bytes.length == 2) {
                int hightByte = 256 + bytes[0];
                int lowByte = 256 + bytes[1];
                asc = (256 * hightByte + lowByte) - 256 * 256;
            }
        } catch (Exception e) {
            System.out.println("ERROR:ChineseSpelling.class-getChsAscii(String chs)" + e);
        }
        return asc;
    }

    /**
     * Convert string.
     * 单字解析
     *
     * @param str the str
     * @return the string
     */
    public static String convert(String str) {
        String result = null;
        int ascii = getChsAscii(str);
        if (ascii > 0 && ascii < 160) {
            result = String.valueOf((char) ascii);
        } else {
            for (int i = (pyvalue.length - 1); i >= 0; i--) {
                if (pyvalue[i] <= ascii) {
                    result = pystr[i];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Gets selling.
     * 词组解析
     *
     * @param chs the chs
     * @return the selling
     */
    public static String getSelling(String chs) {
        String key, value;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < chs.length(); i++) {
            key = chs.substring(i, i + 1);
            if (key.getBytes().length >= 2) {
                value = convert(key);
                if (value == null) {
                    value = "unknown";
                }
            } else {
                value = key;
            }
            buffer.append(value);
        }
        return buffer.toString();
    }

    /**
     * Parse empty string.
     * 将null转化为""
     *
     * @param str the str
     * @return the string
     */
    public static String parseEmpty(String str) {
        if (str == null || "null".equals(str.trim())) {
            str = "";
        }
        return str.trim();
    }

    /**
     * Is empty boolean.
     * 是否是空字符串
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * Str length int.
     * 字符串长度
     *
     * @param str the str
     * @return the int
     */
    public static int strLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    valueLength += 2;
                } else {
                    valueLength += 1;
                }
            }
        }
        return valueLength;
    }

    /**
     * Sub string length int.
     * 获取指定长度的字符所在位置
     *
     * @param str  the str
     * @param maxL the max l
     * @return the int
     */
    public static int subStringLength(String str, int maxL) {
        int currentIndex = 0;
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
            if (valueLength >= maxL) {
                currentIndex = i;
                break;
            }
        }
        return currentIndex;
    }

    /**
     * Str format 2 string.
     * 不足2位前面补0
     *
     * @param str the str
     * @return the string
     */
    public static String strFormat2(String str) {
        try {
            if (str.length() <= 1) {
                str = "0" + str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Convert 2 int int.
     * 类型安全转换
     *
     * @param value        the value
     * @param defaultValue the default value
     * @return the int
     */
    public static int convert2Int(Object value, int defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Double.valueOf(value.toString()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    /**
     * Decimal format string.
     * 指定小数输出
     *
     * @param s      the s
     * @param format the format
     * @return the string
     */
    public static String decimalFormat(String s, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(s);
    }


    /**
     * Byte 2 string string.
     * 字节按utf-8格式转字符串
     *
     * @param bytes the bytes
     * @return the string
     */
    public static String byte2String(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * Byte 2 string string.
     * 字节按code格式转字符串
     *
     * @param bytes       the bytes
     * @param charsetName the code
     * @return the string
     */
    public static String byte2String(byte[] bytes, String charsetName) {
        try {
            return new String(bytes, charsetName);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * Byte 2 hex string.
     * byte转化为十六进制
     *
     * @param bytes the b
     * @return the string
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String shaHex = Integer.toHexString(bytes[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }

    /**
     * Byte 2 hex string.
     * 字节转十六进制
     *
     * @param b the b
     * @return the string
     */
    public static String byte2Hex(byte b) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toHexString(b & 0xFF);
        if (s.length() == 1) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * String 2 hex string.
     * 字符串转十六进制
     *
     * @param str the str
     * @return the string
     */
    public static String string2Hex(String str) {
        return byte2Hex(str.getBytes());
    }


    /**
     * To first upper case string.
     * 首字母大写
     *
     * @param str the str
     * @return the string
     */
    public static String toFirstUpperCase(String str) {
        char[] cs = str.toCharArray();
        if (cs[0] >= 97 && cs[0] <= 122)
            cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * To first lower case string.
     * 首字母小写
     *
     * @param str the str
     * @return the string
     */
    public static String toFirstLowerCase(String str) {
        char[] cs = str.toCharArray();
        if (cs[0] >= 65 && cs[0] <= 90)
            cs[0] += 32;
        return String.valueOf(cs);
    }

    /**
     * To end upper case string.
     * 最后一个字母大写
     *
     * @param str the str
     * @return the string
     */
    public static String toEndUpperCase(String str) {
        char[] cs = str.toCharArray();
        if (cs[cs.length - 1] >= 97 && cs[cs.length - 1] <= 122)
            cs[cs.length - 1] -= 32;
        return String.valueOf(cs);
    }

    /**
     * To end lower case string.
     * 最后一个字母小写
     *
     * @param str the str
     * @return the string
     */
    public static String toEndLowerCase(String str) {
        char[] cs = str.toCharArray();
        if (cs[cs.length - 1] >= 65 && cs[cs.length - 1] <= 90)
            cs[cs.length - 1] += 32;
        return String.valueOf(cs);
    }

    /**
     * To all first upper case string.
     * 一句话首字母全大写,其余保存格式不变
     *
     * @param str the str
     * @return the string
     */
    public static String toAllFirstUpperCase(String str) {
        return toAllFirstUpperCase(str, true);
    }

    /**
     * To all first upper case string.
     * 一句话只有首字母全大写,其余全小写
     *
     * @param str the str
     * @param b   the b
     * @return the string
     */
    public static String toAllFirstUpperCase(String str, boolean b) {
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {
            if (!b) {
                m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2));
            } else {
                m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2).toLowerCase());
            }
        }
        return m.appendTail(sb).toString();
    }

    /**
     * To all first lower case string.
     * 一句话首字母全小写
     *
     * @param str the str
     * @return the string
     */
    public static String toAllFirstLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {

            m.appendReplacement(sb, m.group(1).toLowerCase() + m.group(2));
        }
        return m.appendTail(sb).toString();
    }

    /**
     * Lower and upper change string.
     * 大小写互转
     *
     * @param str the str
     * @return the string
     */
    public static String lowerAndUpperChange(String str) {
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {
            String s;
            if (Character.isUpperCase(m.group(1).charAt(0))) {
                s = m.group(1).toLowerCase();
            } else {
                s = m.group(1).toUpperCase();
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m.group(2).length(); i++) {
                char c = m.group(2).charAt(i);
                if (Character.isUpperCase(c)) {
                    stringBuilder.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    stringBuilder.append(Character.toUpperCase(c));
                }
            }
            m.appendReplacement(sb, s + stringBuilder);
        }
        return m.appendTail(sb).toString();
    }

    /**
     * Is mobile boolean.
     * 判断手机号码
     *
     * @param mobile the mobile
     * @return the boolean
     */
    public static boolean isMobile(String mobile) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[57])|(15[^4])|(17[013678])|(18[0-9]))\\d{8}$"); // 验证手机号
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * Is phone boolean.
     * 判断电话号码
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isPhone(String str) {
        str = str.replace("-", "").replaceAll(" ", "");
        Matcher matcher;
        boolean b = false;
        Pattern p1 = Pattern.compile("^[0][1-9]{2,3}[0-9]{5,10}$"); // 验证带区号的
        Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
        if (str.length() == 11 || str.length() == 12) {
            matcher = p1.matcher(str);
            b = matcher.matches();
        } else if (str.length() == 7 || str.length() == 8) {
            matcher = p2.matcher(str);
            b = matcher.matches();
        }
        return b;
    }

    /**
     * 判断是否为纯数字
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Chinese length int.
     * 中文长度
     *
     * @param str the str
     * @return the int
     */
    public static int chineseLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    valueLength += 2;
                }
            }
        }
        return valueLength;
    }

    /**
     * Is chinese boolean.
     * 是否是中文及中文符号
     *
     * @param str the str
     * @return the boolean
     */
    public static Boolean isChinese(String str) {
        Boolean isChinese = true;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(i, i + 1);
                isChinese = temp.matches(chinese);
            }
        }
        return isChinese;
    }

    /**
     * Is contain chinese boolean.
     * 是否包含中文字符和中文符号
     *
     * @param strName the str name
     * @return the boolean
     */
    public static boolean isContainChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Is con spe characters boolean.
     * 是否包含特殊字符
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isConSpeCharacters(String string) {
        if (string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            //不包含特殊字符
            return false;
        }
        return true;
    }

    /**
     * 生成6位随机数.
     *
     * @return the int
     */
    public static String randomFor6(){
        return String.valueOf((int) ((Math.random()*9+1)*100000));
    }

    /**
     * 生成4位随机数.
     *
     * @return the int
     */
    public static String randomFor4(){
        return String.valueOf((int) ((Math.random()*9+1)*1000));
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
}

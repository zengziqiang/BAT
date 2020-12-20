package com.bat.utils;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author iszengziqiang@163.com
 * @date 2020/12/19 11:55
 * @Version: 1.0
 * @desc //todo 获取拼音码
 */
public class PinyinHelper {

    public static void main(String[] args) {
        System.out.println(ToFirstChar("【").toUpperCase()); //转为首字母大写---->HZZHWPY
        System.out.println(ToFirstChar("齉字转换为拼音").toUpperCase()); //转为首字母大写---->HZZHWPY
    }

    /**
     * 获取字符串拼音的第一个字母
     *
     * @return 字符串中多个字符的拼音首字母
     */
    public static String ToFirstChar(String chinese) {
        if (StringUtils.isBlank(chinese)) {
            return "";
        }
        String filter = strFilter(chinese);

        StringBuilder pinyinStr = new StringBuilder();
        char[] newChar = filter.toCharArray();  //转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : newChar) {
            if (c > 128) {
                try {
                    pinyinStr.append(net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0].charAt(0));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr.append(c);
            }
        }
        return pinyinStr.toString();
    }

    /**
     * * 去除特殊字符
     */
    public static String strFilter(String str) throws PatternSyntaxException {
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\"]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


}

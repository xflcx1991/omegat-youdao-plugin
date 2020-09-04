package xyz.xffish.machinetranslators.util;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public final class OLang2YLang {
    /*
    大体遵照 ISO-639-1 标准
语言        OmegaT      有道
阿法文		aa
阿布哈西亚文	ab
阿维斯陀文	ae
南非荷兰文	af          af
库阿文		ak
阿姆哈拉文	am          am
阿拉贡文		an
阿拉伯文		ar          ar
阿萨姆文		as
阿瓦尔文		av
艾马拉文		ay
阿塞拜疆文	az          az
巴什客尔文	ba
白俄罗斯文	be          be
保加利亚文	bg          bg
比哈尔文		bh
比斯拉马文	bi
班巴拉文		bm
孟加拉文		bn          bn
西藏文		bo
布里多尼文	br
波斯尼亚文	bs          bs
加泰罗尼亚文	ca          ca
车臣文		ce
查莫罗文		ch
克里文		cr
捷克文		cs          cs
教会斯拉夫文	cu
楚瓦什文		cv
威尔士文		cy          cy
丹麦文		da          da
德文		    de          de
迪维希文		dv
不丹文		dz
埃维文		ee
希腊文		el          el
英文		    en          en
世界文		eo          eo
西班牙文		es          es
爱沙尼亚文	et          et
巴斯克文		eu          eu
波斯文		fa          fa
富拉文		ff
芬兰文		fi          fi
斐济文		fj          fj
法罗文		fo
法文		    fr          fr
弗里斯兰文	fy          fy
爱尔兰文		ga          ga
苏格兰-盖尔文 gd          gd
加利西亚文	gl          gl
瓜拉尼文		gn
古加拉提文	gu          gu
马恩文		gv
豪撒文		ha          ha
希伯来文		he          he
印地文		hi          hi
新里木托文	ho
克罗地亚文	hr          hr
海地文		ht          ht
匈牙利文		hu          hu
亚美尼亚文	hy          hy
赫雷罗文		hz
拉丁国际文	ia
印度尼西亚文	id          id
拉丁国际文	ie
伊博文		ig          ig
四川彝文		ii
依奴皮维克文	ik
伊多文		io
冰岛文		is          is
意大利文		it          it
爱斯基摩文	iu
日文		    ja          ja
爪哇文		jv          jw  //ISO-639-1 标准是 jv，但是有道官方确认就是jw，
格鲁吉亚文	ka          ka
刚果文		kg
吉库尤文		ki
卡湾亚马文	kj
哈萨克文		kk          kk
格陵兰文		kl
柬埔寨文		km          km
埃纳德文		kn          kn
朝鲜文		ko          ko
卡努里文		kr
克什米尔文	ks
库尔德文		ku          ku
科米文		kv
康沃尔文		kw
吉尔吉斯文	ky          ky
拉丁文		la          la
卢森堡文		lb          lb
干达文		lg
林加拉文		ln
老挝文		lo          lo
立陶宛文		lt          lt
卢巴-加丹加	lu
拉脱维亚文（列托）	lv      lv
马尔加什文	mg          mg
马绍尔文		mh
毛利文		mi          mi
马其顿文		mk          mk
马来亚拉姆文	ml          ml
蒙古文		mn          mn
摩尔多瓦文	mo
马拉地文		mr          mr
马来文		ms          ms
马耳他文		mt          mt
缅甸文		my          my
瑙鲁文		ma
挪威博克马尔文 nb
北恩德比利文	nd
尼泊尔文		ne          ne
恩东加文		ng
荷兰文		nl          nl
挪威尼诺斯克文 nn
挪威文		no          no
南恩德比利文	nr
纳瓦霍文		nv
尼扬扎文		ny          ny
奥西坦文		oc
奥吉布瓦文	oj
阿曼文		om
欧里亚		or
奥塞梯文		os
旁遮普文		pa          pa
巴利文		pi
波兰文		pl          pl
普什图文		ps          ps
葡萄牙文		pt          pt
盖丘亚文		qu
里托罗曼斯文	rm
基隆迪文		rn
罗马尼亚文	ro          ro
俄文		    ru          ru
卢旺达文		rw
梵文		    sa
撒丁文		sc
信德文		sd          sd
北沙密文		se
桑戈文		sg
sh			sh
僧伽罗文		si          si
斯洛伐克文	sk          sk
斯洛文尼亚文	sl          sl
萨摩亚文		sm          sm
塞内加尔文	sn          sn
索马里文		so          so
阿尔巴尼亚文	sq          sq
塞尔维亚文	sr          sr-Cyrl
辛辛那提文	ss
塞索托文		st          st
苏丹文		su          su          //维基百科翻译为“巽他语”，是印度尼西亚爪哇岛上使用的语言，和苏丹没关系，但是英文版又是sudanese不知哪里有问题
瑞典文		sv          sv
斯瓦希里文	sw          sw
泰米尔文		ta          ta
泰卢固文		te          te
塔吉克文		tg          tg
泰文		    th          th
提格里尼亚文	ti
土库曼文		tk
塔加路族文	tl          tl
突尼斯文		tn
汤加文		to          to
土耳其文		tr          tr
特松加文		ts
鞑靼文		tt
契维文		tw
塔希提文		ty          ty
维吾尔文		ug
乌克兰文		uk          uk
乌尔都文		ur          ur
乌兹别克文	uz          uz
文达文		ve
越南文		vi
沃拉普克文	vo
瓦龙文		wa
沃尔夫文		wo
班图文		xh          xh
依地文		yi          yi
约鲁巴文		yo          yo
壮族文	    za
中文		    zh          zh-CHS
祖鲁文		zu          zu
------------------------------------
粤语                      yue
白苗语                    mww
克林贡语                   tlh
克雷塔罗奥托米语            otq
塞尔维亚语(拉丁文)          sr-Latn
尤卡坦玛雅语               yua
宿务语                     ceb
科西嘉语                    co
夏威夷语                    haw

     */
    /**
     * OmegaT 语言代码和 Youdao 语言代码对应表
     * 参见<br>
     * http://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html#section-9 <br>
     * http://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/%E4%BA%A7%E5%93%81%E5%AE%9A%E4%BB%B7/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-%E4%BA%A7%E5%93%81%E5%AE%9A%E4%BB%B7.html <br>
     * 有道不区分具体那种英文，都是 en
     * TODO:还没有把所有语言代码转换完
     */
    private static final Map<String, String> oLang2yLangMap = MapUtil.<String, String>builder()
            .put("af", "af")
            .put("am", "am")
            .put("ar", "ar")
            .put("az", "az")
            .put("be", "be")
            .put("bg", "bg")
            .put("bn", "bn")
            .put("bs", "bs")
            .put("ca", "ca")
            .put("cs", "cs")
            .put("cy", "cy")
            .put("da", "da")
            .put("de", "de")
            .put("el", "el")
            .put("en", "en")
            .put("eo", "eo")
            .put("es", "es")
            .put("et", "et")
            .put("eu", "eu")
            .put("fa", "fa")
            .put("fi", "fi")
            .put("fj", "fj")
            .put("fr", "fr")
            .put("fy", "fy")
            .put("ga", "ga")
            .put("gd", "gd")
            .put("gl", "gl")
            .put("gu", "gu")
            .put("ha", "ha")
            .put("he", "he")
            .put("hi", "hi")
            .put("hr", "hr")
            .put("ht", "ht")
            .put("hu", "hu")
            .put("hy", "hy")
            .put("id", "id")
            .put("ig", "ig")
            .put("is", "is")
            .put("it", "it")
            .put("ja", "jw")  //有道官网就是坚持这样写 爪哇语
            .put("ka", "ka")
            .put("kk", "kk")
            .put("km", "km")
            .put("kn", "kn")
            .put("ko", "ko")
            .put("ku", "ku")
            .put("ky", "ky")
            .put("la", "la")
            .put("lb", "lb")
            .put("lo", "lo")
            .put("lt", "lt")
            .put("lv", "lv")
            .put("mg", "mg")
            .put("mi", "mi")
            .put("mk", "mk")
            .put("ml", "ml")
            .put("mn", "mn")
            .put("mr", "mr")
            .put("ms", "ms")
            .put("mt", "mt")
            .put("my", "my")
            .put("ne", "ne")
            .put("nl", "nl")
            .put("no", "no")
            .put("ny", "ny")
            .put("pa", "pa")
            .put("pl", "pl")
            .put("ps", "ps")
            .put("pt", "pt")
            .put("ro", "ro")
            .put("ru", "ru")
            .put("sd", "sd")
            .put("si", "si")
            .put("sk", "sk")
            .put("sl", "sl")
            .put("sm", "sm")
            .put("sn", "sn")
            .put("so", "so")
            .put("sq", "sq")
            .put("sr", "sr-Cyrl")
            .put("st", "st")
            .put("su", "su")
            .put("sv", "sv")
            .put("sw", "sw")
            .put("ta", "ta")
            .put("te", "te")
            .put("tg", "tg")
            .put("th", "th")
            .put("tl", "tl")
            .put("to", "to")
            .put("tr", "tr")
            .put("ty", "ty")
            .put("uk", "uk")
            .put("ur", "ur")
            .put("uz", "uz")
            .put("xh", "xh")
            .put("yi", "yi")
            .put("yo", "yo")
            .put("za", "za")
            .put("zh", "zh-CHS")
            .put("zu", "zu")
            .map();

    /**
     * 将 OmegaT 的语言代码转换成有道翻译识别的语言代码.
     * 找不到就输出 auto
     *
     * @param sLang OmegaT的语言代码
     * @return 转换后的有道翻译语言代码
     * @see "https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html#section-9"
     */
    public static String translateOLang2YLang(String sLang){
        String tLang = oLang2yLangMap.get(sLang);
        // 找不到就改成自动识别
        if (tLang == null) {
            tLang = "auto";
        }
        return tLang;
    }
}

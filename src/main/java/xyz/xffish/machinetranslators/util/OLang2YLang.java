package xyz.xffish.machinetranslators.util;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public final class OLang2YLang {
    /*
    阿法文		aa
阿布哈西亚文	ab
阿维斯陀文	ae
南非荷兰文	af
库阿文		ak
阿姆哈拉文	am
阿拉贡文		an
阿拉伯文		ar
阿萨姆文		as
阿瓦尔文		av
艾马拉文		ay
阿塞拜疆文	az
巴什客尔文	ba
白俄罗斯文	be
保加利亚文	bg
比哈尔文		bh
比斯拉马文	bi
班巴拉文		bm
孟加拉文		bn
西藏文		bo
布里多尼文	br
波斯尼亚文	bs
加泰罗尼亚文	ca
车臣文		ce
查莫罗文		ch
克里文		cr
捷克文		cs
教会斯拉夫文	cu
楚瓦什文		cv
威尔士文		cy
丹麦文		da
德文		de
迪维希文		dv
不丹文		dz
埃维文		ee
希腊文		el
英文		en
世界文		eo
西班牙文		es
爱沙尼亚文	et
巴斯克文		eu
波斯文		fa
富拉文		ff
芬兰文		fi
斐济文		fj
法罗文		fo
法文		fr
弗里斯兰文	fy
爱尔兰文		ga
苏格兰-盖尔文 gd
加利西亚文	gl
瓜拉尼文		gn
古加拉提文	gu
马恩文		gv
豪撒文		ha
希伯来文		he
印地文		hi
新里木托文	ho
克罗地亚文	hr
海地文		ht
匈牙利文		hu
亚美尼亚文	hy
赫雷罗文		hz
拉丁国际文	ia
印度尼西亚文	id
拉丁国际文	ie
伊博文		ig
四川彝文		ii
依奴皮维克文	ik
伊多文		io
冰岛文		is
意大利文		it
爱斯基摩文	iu
日文		ja
爪哇文		jv
格鲁吉亚文	ka
刚果文		kg
吉库尤文		ki
卡湾亚马文	kj
哈萨克文		kk
格陵兰文		kl
柬埔寨文		km
埃纳德		kn
朝鲜文		ko
卡努里文		kr
克什米尔文	ks
库尔德文		ku
科米文		kv
康沃尔文		kw
吉尔吉斯文	ky
拉丁文		la
卢森堡文		lb
干达文		lg
林加拉文		ln
老挝文		lo
立陶宛文		lt
卢巴-加丹加	lu
拉脱维亚文（列托）	lv
马尔加什文	mg
马绍尔文		mh
毛利文		mi
马其顿文		mk
马来亚拉姆文	ml
蒙古文		mn
摩尔多瓦文	mo
马拉地文		mr
马来文		ms
马耳他文		mt
缅甸文		my
瑙鲁文		ma
挪威博克马尔文 nb
北恩德比利文	nd
尼泊尔文		ne
恩东加文		ng
荷兰文		nl
挪威尼诺斯克文 nn
挪威文		no
南恩德比利文	nr
纳瓦霍文		nv
尼扬扎文		ny
奥西坦文		oc
奥吉布瓦文	oj
阿曼文		om
欧里亚		or
奥塞梯文		os
旁遮普文		pa
巴利文		pi
波兰文		pl
普什图文		ps
葡萄牙文		pt
盖丘亚文		qu
里托罗曼斯文	rm
基隆迪文		rn
罗马尼亚文	ro
俄文		ru
卢旺达文		rw
梵文		sa
撒丁文		sc
苏丹文		sd
北沙密文		se
桑戈文		sg
sh			sh
僧伽罗文		si
斯洛伐克文	sk
斯洛文尼亚文	sl
萨摩亚文		sm
塞内加尔文	sn
索马里文		so
阿尔巴尼亚文	sq
塞尔维亚文	sr
辛辛那提文	ss
塞索托文		st
苏丹文		su
瑞典文		sv
斯瓦西里文	sw
泰米尔文		ta
泰卢固文		te
塔吉克文		tg
泰文		th
提格里尼亚文	ti
土库曼文		tk
塔加路族文	tl
突尼斯文		tn
汤加文		to
土耳其文		tr
特松加文		ts
鞑靼文		tt
契维文		tw
塔希提文		ty
维吾尔文		ug
乌克兰文		uk
乌尔都文		ur
乌兹别克文	uz
文达文		ve
越南文		vi
沃拉普克文	vo
瓦龙文		wa
沃尔夫文		wo
班图文		xh
依地文		yi
约鲁巴文		yo
藏文		za
中文		zh
祖鲁文		zu
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
            .put("en", "en")
            .put("zh", "zh-CHS")
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

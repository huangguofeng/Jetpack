package com.example.framework.news;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/2/27
 * package :com.example.myapplication.bean
 * desc    :TODO:测试实体类
 */
public class News {

    /**
     * reason : 成功的返回!
     * result : {"stat":"1","data":[{"uniquekey":"03cc3f371c1a8875cd58e517fd3934ef","title":"查成绩啦！海南2021年全国硕士研究生招生考试成绩公布","date":"2021-02-27 09:56","category":"社会","author_name":"海口网","url":"https://mini.eastday.com/mobile/210227095640754792347.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095640_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03201609.jpeg"},{"uniquekey":"7cf1014adf8f91511e3883ab71761892","title":"元宵佳节 民警助力人月两团圆","date":"2021-02-27 09:56","category":"社会","author_name":"零距离","url":"https://mini.eastday.com/mobile/210227095614443277534.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095614_b450765ffa4eb8e620dd0a65e878df67_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095614_b450765ffa4eb8e620dd0a65e878df67_1_mwpm_03201609.png"},{"uniquekey":"ee212defacb8896fa54ceef68d7e8e4b","title":"你扔掉的快递包装可能泄露了你的隐私，这位全国人大代表为此提了一份建议","date":"2021-02-27 09:56","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227095612828389600.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095612_91ef0cbb394671e32b332c9eec24a597_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095612_91ef0cbb394671e32b332c9eec24a597_1_mwpm_03201609.jpeg"},{"uniquekey":"5f24c8db76442e86aada32d3ab0063e3","title":"\u201c台湾女婿\u201d留宁过年：在地亦故乡 父母莫挂忧","date":"2021-02-27 09:55","category":"社会","author_name":"中国新闻网","url":"https://mini.eastday.com/mobile/210227095521721662406.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_3_mwpm_03201609.jpeg"},{"uniquekey":"f794fdf443b6e4f6800c534879ceedff","title":"【新春走基层】\u201c我现在被管得牢牢的，幸福感也满满的！\u201d","date":"2021-02-27 09:51","category":"社会","author_name":"人民网-上海频道","url":"https://mini.eastday.com/mobile/210227095131801780892.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_2_mwpm_03201609.jpeg"},{"uniquekey":"0a175dc6daad907ee743e979bea3c516","title":"全面推动卫生健康事业高质量发展 郑州市召开2021年卫生健康工作会议","date":"2021-02-27 09:42","category":"社会","author_name":"映象网","url":"https://mini.eastday.com/mobile/210227094208357695539.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_3_mwpm_03201609.jpeg"},{"uniquekey":"0aae024356bd244e600df57f624f5565","title":"视频｜上海科学家利用新技术发现新生肝细胞来源","date":"2021-02-27 09:41","category":"社会","author_name":"看看新闻网","url":"https://mini.eastday.com/mobile/210227094103923246976.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094103_5ad4b8912bfbde67bed97e34e0595531_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094103_5ad4b8912bfbde67bed97e34e0595531_1_mwpm_03201609.jpeg"},{"uniquekey":"0cb2a214650934b3bf06803e976842f6","title":"贪便宜吃大亏！男子花27万买了一个假房产证","date":"2021-02-27 09:41","category":"社会","author_name":"第1眼","url":"https://mini.eastday.com/mobile/210227094102678212912.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_2_mwpm_03201609.jpeg"},{"uniquekey":"044fdc3241dad43916cd843ab3a6936e","title":"注意了！河南一男子涉嫌重大刑事犯罪，被警方悬赏缉拿","date":"2021-02-27 09:41","category":"社会","author_name":"映象网","url":"https://mini.eastday.com/mobile/210227094100696901684.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094100_358fc22e11e1898a9a52575c468d295f_1_mwpm_03201609.jpeg"},{"uniquekey":"8bae7d94ca7691dda37387d9ce4dcf6d","title":"行动轨迹公布 河北沧州运河区急寻与密接者接触人员","date":"2021-02-27 09:40","category":"社会","author_name":"中国新闻网","url":"https://mini.eastday.com/mobile/210227094011126373968.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094011_f8a38885531da49bed8d77d686f0b6ec_1_mwpm_03201609.jpeg"},{"uniquekey":"7b84b910f31b2bfde3177037ae9433ba","title":"\u201c连花呼吸健康公益行\u201d向长春高新区捐赠112万元防疫物资","date":"2021-02-27 09:38","category":"社会","author_name":"河北新闻网","url":"https://mini.eastday.com/mobile/210227093859233723404.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227093859_7e11a54505d93b27fabfe485f0216384_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227093859_7e11a54505d93b27fabfe485f0216384_2_mwpm_03201609.jpeg"},{"uniquekey":"e9236d460fcaa92a696026fbc67e5d32","title":"兴县蔚汾派出所破获一起\u201c埋地雷\u201d式零包贩毒案","date":"2021-02-27 09:19","category":"社会","author_name":"黄河新闻网吕梁频道","url":"https://mini.eastday.com/mobile/210227091904941948052.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091904_cf908bfb0b58b643923a05d3e56539e6_1_mwpm_03201609.jpeg"},{"uniquekey":"4ab43d4aeebb3a88240382de61bd4383","title":"过马路玩手机被撞曝安全隐患（图）","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-新法制报","url":"https://mini.eastday.com/mobile/210227091732592980356.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091732_0667bfad0f1810bde552571dd8381667_1_mwpm_03201609.jpeg"},{"uniquekey":"c7b74e41df75906683809ee38727257d","title":"大爷情况危急却\u201c失联\u201d 医生拨打110全城寻人（图）","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-江南都市报","url":"https://mini.eastday.com/mobile/210227091732328576264.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091732_bf441e5a9681053810d4492c285b8826_1_mwpm_03201609.jpeg"},{"uniquekey":"c05bc0d45046f5076ba9e4852f658730","title":"付费共享自习室在九江悄然兴起","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-江南都市报","url":"https://mini.eastday.com/mobile/210227091731206739144.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091731_a0e31de73061098dc302c442e81d75a3_1_mwpm_03201609.jpeg"},{"uniquekey":"b8c309ccc892c3a54958a2a87f5cb2c0","title":"海报 | 高考倒计时100天，愿你的所有努力都能如愿！","date":"2021-02-27 09:15","category":"社会","author_name":"南海网","url":"https://mini.eastday.com/mobile/210227091506387967829.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_3_mwpm_03201609.jpeg"},{"uniquekey":"ca2b51ab8f0123abb33063d051f82bf6","title":"女子捡到26万现金，警察打电话给取款人却不承认？","date":"2021-02-27 09:10","category":"社会","author_name":"人民日报客户端辽宁频道","url":"https://mini.eastday.com/mobile/210227091051400977271.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091051_698a074ef6cfa6037c36695b827c82df_0_mwpm_03201609.jpeg"},{"uniquekey":"9cbcc5152928ad6f5720dba05a8face3","title":"上海昨日新增1例境外输入病例，同航班密接者已集中隔离观察","date":"2021-02-27 08:55","category":"社会","author_name":"\u201c上海发布\u201d微信公号","url":"https://mini.eastday.com/mobile/210227085547306380567.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085547_bfd3bb17d2143c78f13d2ac56baad81b_0_mwpm_03201609.jpeg"},{"uniquekey":"75dfe62d45fb384b69b04a3abf2d2518","title":"花园洋房里猜灯谜吃汤圆听沪剧，传统元宵的热闹劲儿回来了！","date":"2021-02-27 08:55","category":"社会","author_name":"新民晚报","url":"https://mini.eastday.com/mobile/210227085546542646734.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_1_mwpm_03201609.png","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_2_mwpm_03201609.png"},{"uniquekey":"7a56dac2fd04ef7616b7cffe41c7de93","title":"断贫莫若学","date":"2021-02-27 08:53","category":"社会","author_name":"山西晚报","url":"https://mini.eastday.com/mobile/210227085351662746026.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085351_c63a48a8f97183c5c498a00d90f8e8ae_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085351_c63a48a8f97183c5c498a00d90f8e8ae_2_mwpm_03201609.jpeg"},{"uniquekey":"9afaa5f31375d4cb687bc6b23aa2aee3","title":"视频｜两男子地铁内上演\u201c全武行\u201d 互殴只因一个座位","date":"2021-02-27 08:40","category":"社会","author_name":"看看新闻网","url":"https://mini.eastday.com/mobile/210227084041108232839.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_1_mwpm_03201609.png","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_2_mwpm_03201609.png"},{"uniquekey":"1f57cc716220b2da56749027d508d9c1","title":"甘肃省各县市区2021年1月份空气质量改善（反弹）\u201c红黑榜\u201d名单","date":"2021-02-27 08:32","category":"社会","author_name":"每日甘肃网-甘肃日报","url":"https://mini.eastday.com/mobile/210227083238576681925.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227083238_856e09bcf3ba81a5de0f84e58be7144e_1_mwpm_03201609.jpeg"},{"uniquekey":"a6b1e6961a5bd3f539bca90c3694ff4e","title":"最美教师！这条百余米上学路她背着脚伤学生每天来回走四次","date":"2021-02-27 08:29","category":"社会","author_name":"厦门网","url":"https://mini.eastday.com/mobile/210227082912666134578.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082912_89fd5ecc9c74d47d002244e8f3769fc8_1_mwpm_03201609.jpeg"},{"uniquekey":"563d165be95a5fde553408370a4e6ed4","title":"惊心动魄！这是电影里才有的场景","date":"2021-02-27 08:25","category":"社会","author_name":"中央广电总台中国之声微信公号","url":"https://mini.eastday.com/mobile/210227082527871293274.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_2_mwpm_03201609.jpeg"},{"uniquekey":"98541ff2335b5ca56f94894c327ae972","title":"猜灯谜观大剧，看元宵灯光秀，武汉文旅名片《知音号》火爆复演","date":"2021-02-27 08:05","category":"社会","author_name":"楚天都市报-看楚天","url":"https://mini.eastday.com/mobile/210227080544984465769.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_3_mwpm_03201609.jpeg"},{"uniquekey":"5ba27b066ada6887c628275b2a7c3886","title":"上海为独居老人安装\u201c智慧六件套\u201d冲上热搜，哪些老人能申请？一套多少钱？","date":"2021-02-27 07:55","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227075512906539698.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_2_mwpm_03201609.jpeg"},{"uniquekey":"680f1b88dc1d6e961f72c6174121ea90","title":"造谣取快递女子出轨，两人被提起公诉，当事女子回应","date":"2021-02-27 07:50","category":"社会","author_name":"楚天都市报-看楚天","url":"https://mini.eastday.com/mobile/210227075042929211929.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_3_mwpm_03201609.jpg"},{"uniquekey":"1bd2ace243d3eaab37a58a7fadb43633","title":"不断完善大学生兵员征集政策机制","date":"2021-02-27 07:40","category":"社会","author_name":"解放军报","url":"https://mini.eastday.com/mobile/210227074008120446515.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227074008_17375b063f3a25347776dd9af4a1da66_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227074008_17375b063f3a25347776dd9af4a1da66_1_mwpm_03201609.jpeg"},{"uniquekey":"d194187fbcf3c65b3543e2b8094cc36f","title":"正月十五，央视百位主持人同唱\u201c难忘今宵\u201d，这台元宵晚会不一般","date":"2021-02-27 06:54","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227065440017676419.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_2_mwpm_03201609.jpeg"},{"uniquekey":"bd75b63404f56288f488784ed4e6049a","title":"上海原创杂技剧《战上海》片段昨晚亮相央视元宵晚会 掌声经久不息","date":"2021-02-27 06:39","category":"社会","author_name":"上观","url":"https://mini.eastday.com/mobile/210227063923041968767.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227063923_12c47aaf2ad1193ced2b930a28a5035c_0_mwpm_03201609.jpeg"}]}
     * error_code : 0
     * getNewsGet(@Query("type") String type, @Query("page") int page, @Query("page_size") int pageSize, @Query("key") String token);
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"03cc3f371c1a8875cd58e517fd3934ef","title":"查成绩啦！海南2021年全国硕士研究生招生考试成绩公布","date":"2021-02-27 09:56","category":"社会","author_name":"海口网","url":"https://mini.eastday.com/mobile/210227095640754792347.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095640_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03201609.jpeg"},{"uniquekey":"7cf1014adf8f91511e3883ab71761892","title":"元宵佳节 民警助力人月两团圆","date":"2021-02-27 09:56","category":"社会","author_name":"零距离","url":"https://mini.eastday.com/mobile/210227095614443277534.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095614_b450765ffa4eb8e620dd0a65e878df67_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095614_b450765ffa4eb8e620dd0a65e878df67_1_mwpm_03201609.png"},{"uniquekey":"ee212defacb8896fa54ceef68d7e8e4b","title":"你扔掉的快递包装可能泄露了你的隐私，这位全国人大代表为此提了一份建议","date":"2021-02-27 09:56","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227095612828389600.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095612_91ef0cbb394671e32b332c9eec24a597_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095612_91ef0cbb394671e32b332c9eec24a597_1_mwpm_03201609.jpeg"},{"uniquekey":"5f24c8db76442e86aada32d3ab0063e3","title":"\u201c台湾女婿\u201d留宁过年：在地亦故乡 父母莫挂忧","date":"2021-02-27 09:55","category":"社会","author_name":"中国新闻网","url":"https://mini.eastday.com/mobile/210227095521721662406.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_3_mwpm_03201609.jpeg"},{"uniquekey":"f794fdf443b6e4f6800c534879ceedff","title":"【新春走基层】\u201c我现在被管得牢牢的，幸福感也满满的！\u201d","date":"2021-02-27 09:51","category":"社会","author_name":"人民网-上海频道","url":"https://mini.eastday.com/mobile/210227095131801780892.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227095131_aca87b85ad4ba1083086549cfde75f24_2_mwpm_03201609.jpeg"},{"uniquekey":"0a175dc6daad907ee743e979bea3c516","title":"全面推动卫生健康事业高质量发展 郑州市召开2021年卫生健康工作会议","date":"2021-02-27 09:42","category":"社会","author_name":"映象网","url":"https://mini.eastday.com/mobile/210227094208357695539.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094208_c9a381e6aad9146ddc8c2e9250a4b43a_3_mwpm_03201609.jpeg"},{"uniquekey":"0aae024356bd244e600df57f624f5565","title":"视频｜上海科学家利用新技术发现新生肝细胞来源","date":"2021-02-27 09:41","category":"社会","author_name":"看看新闻网","url":"https://mini.eastday.com/mobile/210227094103923246976.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094103_5ad4b8912bfbde67bed97e34e0595531_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094103_5ad4b8912bfbde67bed97e34e0595531_1_mwpm_03201609.jpeg"},{"uniquekey":"0cb2a214650934b3bf06803e976842f6","title":"贪便宜吃大亏！男子花27万买了一个假房产证","date":"2021-02-27 09:41","category":"社会","author_name":"第1眼","url":"https://mini.eastday.com/mobile/210227094102678212912.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094102_1116c4c1fd01853b140ee3f0e4f674ce_2_mwpm_03201609.jpeg"},{"uniquekey":"044fdc3241dad43916cd843ab3a6936e","title":"注意了！河南一男子涉嫌重大刑事犯罪，被警方悬赏缉拿","date":"2021-02-27 09:41","category":"社会","author_name":"映象网","url":"https://mini.eastday.com/mobile/210227094100696901684.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094100_358fc22e11e1898a9a52575c468d295f_1_mwpm_03201609.jpeg"},{"uniquekey":"8bae7d94ca7691dda37387d9ce4dcf6d","title":"行动轨迹公布 河北沧州运河区急寻与密接者接触人员","date":"2021-02-27 09:40","category":"社会","author_name":"中国新闻网","url":"https://mini.eastday.com/mobile/210227094011126373968.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227094011_f8a38885531da49bed8d77d686f0b6ec_1_mwpm_03201609.jpeg"},{"uniquekey":"7b84b910f31b2bfde3177037ae9433ba","title":"\u201c连花呼吸健康公益行\u201d向长春高新区捐赠112万元防疫物资","date":"2021-02-27 09:38","category":"社会","author_name":"河北新闻网","url":"https://mini.eastday.com/mobile/210227093859233723404.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227093859_7e11a54505d93b27fabfe485f0216384_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227093859_7e11a54505d93b27fabfe485f0216384_2_mwpm_03201609.jpeg"},{"uniquekey":"e9236d460fcaa92a696026fbc67e5d32","title":"兴县蔚汾派出所破获一起\u201c埋地雷\u201d式零包贩毒案","date":"2021-02-27 09:19","category":"社会","author_name":"黄河新闻网吕梁频道","url":"https://mini.eastday.com/mobile/210227091904941948052.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091904_cf908bfb0b58b643923a05d3e56539e6_1_mwpm_03201609.jpeg"},{"uniquekey":"4ab43d4aeebb3a88240382de61bd4383","title":"过马路玩手机被撞曝安全隐患（图）","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-新法制报","url":"https://mini.eastday.com/mobile/210227091732592980356.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091732_0667bfad0f1810bde552571dd8381667_1_mwpm_03201609.jpeg"},{"uniquekey":"c7b74e41df75906683809ee38727257d","title":"大爷情况危急却\u201c失联\u201d 医生拨打110全城寻人（图）","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-江南都市报","url":"https://mini.eastday.com/mobile/210227091732328576264.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091732_bf441e5a9681053810d4492c285b8826_1_mwpm_03201609.jpeg"},{"uniquekey":"c05bc0d45046f5076ba9e4852f658730","title":"付费共享自习室在九江悄然兴起","date":"2021-02-27 09:17","category":"社会","author_name":"大江网-江南都市报","url":"https://mini.eastday.com/mobile/210227091731206739144.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091731_a0e31de73061098dc302c442e81d75a3_1_mwpm_03201609.jpeg"},{"uniquekey":"b8c309ccc892c3a54958a2a87f5cb2c0","title":"海报 | 高考倒计时100天，愿你的所有努力都能如愿！","date":"2021-02-27 09:15","category":"社会","author_name":"南海网","url":"https://mini.eastday.com/mobile/210227091506387967829.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091506_df02bf7311670f8c992a435d3be795bf_3_mwpm_03201609.jpeg"},{"uniquekey":"ca2b51ab8f0123abb33063d051f82bf6","title":"女子捡到26万现金，警察打电话给取款人却不承认？","date":"2021-02-27 09:10","category":"社会","author_name":"人民日报客户端辽宁频道","url":"https://mini.eastday.com/mobile/210227091051400977271.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227091051_698a074ef6cfa6037c36695b827c82df_0_mwpm_03201609.jpeg"},{"uniquekey":"9cbcc5152928ad6f5720dba05a8face3","title":"上海昨日新增1例境外输入病例，同航班密接者已集中隔离观察","date":"2021-02-27 08:55","category":"社会","author_name":"\u201c上海发布\u201d微信公号","url":"https://mini.eastday.com/mobile/210227085547306380567.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085547_bfd3bb17d2143c78f13d2ac56baad81b_0_mwpm_03201609.jpeg"},{"uniquekey":"75dfe62d45fb384b69b04a3abf2d2518","title":"花园洋房里猜灯谜吃汤圆听沪剧，传统元宵的热闹劲儿回来了！","date":"2021-02-27 08:55","category":"社会","author_name":"新民晚报","url":"https://mini.eastday.com/mobile/210227085546542646734.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_1_mwpm_03201609.png","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085546_9e5235cb4399370ededd9033e8ee1f0c_2_mwpm_03201609.png"},{"uniquekey":"7a56dac2fd04ef7616b7cffe41c7de93","title":"断贫莫若学","date":"2021-02-27 08:53","category":"社会","author_name":"山西晚报","url":"https://mini.eastday.com/mobile/210227085351662746026.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085351_c63a48a8f97183c5c498a00d90f8e8ae_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227085351_c63a48a8f97183c5c498a00d90f8e8ae_2_mwpm_03201609.jpeg"},{"uniquekey":"9afaa5f31375d4cb687bc6b23aa2aee3","title":"视频｜两男子地铁内上演\u201c全武行\u201d 互殴只因一个座位","date":"2021-02-27 08:40","category":"社会","author_name":"看看新闻网","url":"https://mini.eastday.com/mobile/210227084041108232839.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_0_mwpm_03201609.png","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_1_mwpm_03201609.png","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227084041_1f3f277e57f813dc1d5265709155693f_2_mwpm_03201609.png"},{"uniquekey":"1f57cc716220b2da56749027d508d9c1","title":"甘肃省各县市区2021年1月份空气质量改善（反弹）\u201c红黑榜\u201d名单","date":"2021-02-27 08:32","category":"社会","author_name":"每日甘肃网-甘肃日报","url":"https://mini.eastday.com/mobile/210227083238576681925.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227083238_856e09bcf3ba81a5de0f84e58be7144e_1_mwpm_03201609.jpeg"},{"uniquekey":"a6b1e6961a5bd3f539bca90c3694ff4e","title":"最美教师！这条百余米上学路她背着脚伤学生每天来回走四次","date":"2021-02-27 08:29","category":"社会","author_name":"厦门网","url":"https://mini.eastday.com/mobile/210227082912666134578.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082912_89fd5ecc9c74d47d002244e8f3769fc8_1_mwpm_03201609.jpeg"},{"uniquekey":"563d165be95a5fde553408370a4e6ed4","title":"惊心动魄！这是电影里才有的场景","date":"2021-02-27 08:25","category":"社会","author_name":"中央广电总台中国之声微信公号","url":"https://mini.eastday.com/mobile/210227082527871293274.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227082527_c93977ccc87a273a06a092b584c83580_2_mwpm_03201609.jpeg"},{"uniquekey":"98541ff2335b5ca56f94894c327ae972","title":"猜灯谜观大剧，看元宵灯光秀，武汉文旅名片《知音号》火爆复演","date":"2021-02-27 08:05","category":"社会","author_name":"楚天都市报-看楚天","url":"https://mini.eastday.com/mobile/210227080544984465769.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227080544_f8143d99d036e89c3c859e504a0d10e8_3_mwpm_03201609.jpeg"},{"uniquekey":"5ba27b066ada6887c628275b2a7c3886","title":"上海为独居老人安装\u201c智慧六件套\u201d冲上热搜，哪些老人能申请？一套多少钱？","date":"2021-02-27 07:55","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227075512906539698.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075512_fae6afa8e723b663ad680008014e022f_2_mwpm_03201609.jpeg"},{"uniquekey":"680f1b88dc1d6e961f72c6174121ea90","title":"造谣取快递女子出轨，两人被提起公诉，当事女子回应","date":"2021-02-27 07:50","category":"社会","author_name":"楚天都市报-看楚天","url":"https://mini.eastday.com/mobile/210227075042929211929.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_1_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_2_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227075042_e9c771a13a0ea6c83727ea8997d60606_3_mwpm_03201609.jpg"},{"uniquekey":"1bd2ace243d3eaab37a58a7fadb43633","title":"不断完善大学生兵员征集政策机制","date":"2021-02-27 07:40","category":"社会","author_name":"解放军报","url":"https://mini.eastday.com/mobile/210227074008120446515.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227074008_17375b063f3a25347776dd9af4a1da66_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227074008_17375b063f3a25347776dd9af4a1da66_1_mwpm_03201609.jpeg"},{"uniquekey":"d194187fbcf3c65b3543e2b8094cc36f","title":"正月十五，央视百位主持人同唱\u201c难忘今宵\u201d，这台元宵晚会不一般","date":"2021-02-27 06:54","category":"社会","author_name":"上观新闻","url":"https://mini.eastday.com/mobile/210227065440017676419.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_0_mwpm_03201609.jpeg","thumbnail_pic_s02":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_1_mwpm_03201609.jpeg","thumbnail_pic_s03":"https://dfzximg02.dftoutiao.com/news/20210227/20210227065440_4f72f29815e32bf919f17c18403371c6_2_mwpm_03201609.jpeg"},{"uniquekey":"bd75b63404f56288f488784ed4e6049a","title":"上海原创杂技剧《战上海》片段昨晚亮相央视元宵晚会 掌声经久不息","date":"2021-02-27 06:39","category":"社会","author_name":"上观","url":"https://mini.eastday.com/mobile/210227063923041968767.html","thumbnail_pic_s":"https://dfzximg02.dftoutiao.com/news/20210227/20210227063923_12c47aaf2ad1193ced2b930a28a5035c_0_mwpm_03201609.jpeg"}]
         */

        private String stat;
        private List<DataBean> data;

        public class DataBean {
            /**
             * uniquekey : 03cc3f371c1a8875cd58e517fd3934ef
             * title : 查成绩啦！海南2021年全国硕士研究生招生考试成绩公布
             * date : 2021-02-27 09:56
             * category : 社会
             * author_name : 海口网
             * url : https://mini.eastday.com/mobile/210227095640754792347.html
             * thumbnail_pic_s : https://dfzximg02.dftoutiao.com/news/20210227/20210227095640_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03201609.jpeg
             * thumbnail_pic_s02 : https://dfzximg02.dftoutiao.com/news/20210227/20210227095614_b450765ffa4eb8e620dd0a65e878df67_1_mwpm_03201609.png
             * thumbnail_pic_s03 : https://dfzximg02.dftoutiao.com/news/20210227/20210227095521_01717b61214373b288121ca8bb5c9157_3_mwpm_03201609.jpeg
             */

            public String uniquekey;
            public String title;
            public String date;
            public String category;
            public String author_name;
            public String url;
            public String thumbnail_pic_s;
            public String thumbnail_pic_s02;
            public String thumbnail_pic_s03;

            @Override
            public String toString() {
                return "DataBean{" +
                        "uniquekey='" + uniquekey + '\'' +
                        ", title='" + title + '\'' +
                        ", date='" + date + '\'' +
                        ", category='" + category + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", url='" + url + '\'' +
                        ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                        ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                        ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                        '}';
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public String getDate() {
                return date;
            }

            public String getCategory() {
                return category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public String getUrl() {
                return url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (DataBean bean : data) {
                stringBuilder.append(bean.toString() + "\n");
            }
            return "ResultBean{" +
                    "stat='" + stat + '\'' + "\n" +
                    ", data=" + stringBuilder.toString() + "\n" +
                    '}';
        }

        public String getStat() {
            return stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        return "News{" +
                "reason='" + reason + '\'' + "\n" +
                ", result=" + result.toString() + "\n" +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}

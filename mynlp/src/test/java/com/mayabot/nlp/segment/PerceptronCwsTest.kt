package com.mayabot.nlp.segment

import com.mayabot.nlp.Mynlps
import com.mayabot.nlp.segment.lexer.perceptron.PerceptronsSegmentService
import org.junit.Test



class CwsTest {

    val cws = Mynlps.instanceOf(PerceptronsSegmentService::class.java)

    @Test
    fun test2(){
//        println(cws.splitWord("检查settings.xml中的阿里云仓库地址正确"))
//        println("检查settings.xml中的阿里云仓库地址正确".lexer())
//
        println(Lexers.perceptronBuilder().build().scan("检查settings.xml中的阿里云仓库地址正确"))


        val builrder = Lexers.perceptronBuilder()
        val lexer = builrder // core分词构建器
                .withPos() // 开启词性

                .withNer()
                .withCustomDictionary()
                //    .keepOriCharOutput()
//                .withPersonName() // 开启人名
                .build() // 创建定制词法分析对象
//        val service = Mynlps.instanceOf(CwsService::class.java)
//        service.perceptron.learn("阿里云 仓库")
        val buffer = "检查settings.xml中的阿里云仓库地址正确"
        val sentence = lexer.scan(buffer)
        println(sentence.toList())
    }

    @Test
    fun testCwsService() {

        val text = """
            2017年2月5日先后视察了华鑫海欣楼宇党建（群团）服务站和江阴市顺天村项目
            南海地区的航行和飞越自由根本不存在问题，每年10万余艘各国各类船只能够在南海安全、顺利地通行，而中国南沙和西沙群岛远离国际航道。但在美方眼里这不叫航行自由，美方所谓“航行自由行动”，是按照自己对国际法的单方面解释，派出军舰挑战其它国家对海上领土主权和海洋权益的所谓“过度”主张和行使。
            放着宽阔的南海国际航道不走，美国军舰却屡次进入中国驻守的南海岛礁12海里之内宣示“航行自由”，实际上是别有用心。
            美国当地时间星期二，谷歌旗下流媒体视频网站YouTube在晚上6点左右陷入全球性宕机状态，直到7点20分才恢复功能。
            YouTube针对用户发表声明称:“感谢你们报告YouTube、YouTube TV和YouTube Music无法访问的问题。我们正在努力解决这个问题，一旦修好，我们会通知你们。对于由此造成的不便，我们深表歉意，并将继续保持更新。
            心肌上动“心机”
            心肌细胞是心脏泵血的动力来源，心肌细胞出问题可能会导致严重疾病甚至死亡。因此，如果能让心脏中长出新的心肌细胞，替换掉有问题的细胞，以此修复心脏，无疑是医学上的一大突破。
            安韦萨就在心肌上动起了“心机”。2001年，他还在纽约医学院工作时，在英国学术刊物《自然》上发表一篇论文，说可以用来自骨髓的c-kit干细胞使心肌再生。随后，他又于2003年在美国《细胞》杂志发文说不需要骨髓干细胞，使用成熟的心脏干细胞就能修复心肌。有研究人员曾对他的这两项研究成果提出质疑。
            我要购买一个双层芝士汉堡
            我要购买一个双层牛肉汉堡
            这是你买的第几套房子，这就是总统套房了，芝士汉堡是什么味道
            小孩多大学跳舞
            外地人生孩子
            被拆迁人为低收入
        """.trimIndent()

        text.lines().forEach {
            println(it + " \n" + cws.splitWord(it).joinToString(separator = " / "))
        }
    }


    @Test
    fun testLearn() {
        val txt = "小孩多大学跳舞"
        Mynlps.instanceOf(PerceptronsSegmentService::class.java).perceptron.learn("" +
                "多大 学")
        println(Lexers.perceptronBuilder().build().scan(txt))
    }
}

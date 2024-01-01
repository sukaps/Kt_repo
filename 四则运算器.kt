import kotlin.system.exitProcess

/*
    四则运算器:
        提示输入表达式
        读取控制台输入的文本，嵌入 try - catch
            使用 let 函数进行判空 {
                判断函数输入的加减乘除
                使用 trim 进行去除空格，split 进行字符切割
                传入方法进行运算返回结果
            }
        不知道为啥 let 函数无法判空，改用 isNullOrBlank 了
        取到返回值后进行输出
        再询问是否继续使用
        读取控制台输入的字符进行判断是否继续使用
        输入n则退出，输入任意字符/按下 Enter 键继续使用

*/

fun main() {
    while (true) {
        println("**********请输入算式**********")
        val read = readlnOrNull();
        try {
            if (!read.isNullOrBlank()) {
                val ret = calculate(read)
                if (ret == "error") {
                    println("输入的计算式有误！")
                } else {
                    println("$read 的结果为：$ret")
                }
            }else {
                println("未输入算式！")
            }
            println("按下Enter键使用，输入n退出计算")
            val cmd = readlnOrNull()
            cmd?.let {
                if (cmd == "n") {
                    exitProcess(-1)
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}

fun calculate(str: String): String {

    if (str.contains("+")) {
        val count = str.trim().split("+")
        return run(count[0].toDouble(), count[1].toDouble(), "+").toString()
    } else if (str.contains("-")){
        val count = str.trim().split("-")
        return run(count[0].toDouble(), count[1].toDouble(), "-").toString()
    } else if (str.contains("*")){
        val count = str.trim().split("*")
        return run(count[0].toDouble(), count[1].toDouble(), "*").toString()
    } else if (str.contains("/")){
        val count = str.trim().split("/")
        return run(count[0].toDouble(), count[1].toDouble(), "/").toString()
    }else {
        return "error"
    }
}

fun run(num1: Double, num2: Double, type: String): Double {
    return when(type) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num2 / num2
        else -> 0.0
    }
}


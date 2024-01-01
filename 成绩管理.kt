package project

import kotlin.system.exitProcess

fun main() {
    val scoresList = arrayListOf<Double>()
    while (true) {
        println("**********成绩管理系统**********")
        println("           1.录入成绩          ")
        println("           2.输出成绩          ")
        println("           3.求最大值          ")
        println("           4.求最小值          ")
        println("           5.成绩降序          ")
        println("           6.退出             ")
        print("请输入你的选项：")
        val read = readlnOrNull()
        divideCase(read, scoresList)
    }
}

fun divideCase(str : String?, list : ArrayList<Double>) = when(str) {
    "1" -> { InputScores().input(list) }
    "2" -> { outputScores(list) }
    "3" -> { maxScores(list) }
    "4" -> { minScores(list) }
    "5" -> { upScores(list) }
    "6" -> { exitProcess(-1) }
    else -> { println("输入的选项有误！") }
}

class InputScores {
    fun input(scoresList: ArrayList<Double>) {
        //录入分数
        println("=====请输入录入人数=====")
        val num = readlnOrNull()
        if (!num.isNullOrBlank()) {
            if (num.all { it.isDigit() }) putInList(num.toInt(), scoresList) else println("输入数据有误！")
        } else {
            println("未输入录入人数！")
        }
    }

    private fun putInList(num: Int, scoresList: ArrayList<Double>) {
        var count = 0
        while (num > count) {
            println("请输入第${count + 1}个学生的成绩")
            val scores = readlnOrNull()
            if (!scores.isNullOrBlank()) {
                if (scores.all { it.isDigit() }) scoresList.add(
                    count++,
                    scores.toDouble()
                ) else println("输入的数据有误!")
            } else {
                println("未输入成绩！")
            }
        }
    }
}

fun outputScores(list : ArrayList<Double>) {
    //输出分数
    list.forEachIndexed { index, d -> println("第${index+1}名学生的成绩是$d") }
}

fun maxScores(list : ArrayList<Double>) {
    //求最大值
    val max = list.maxBy { it }
    println("成绩最大值为：$max")
}

fun minScores(list : ArrayList<Double>) {
    //求最小值
    val min = list.minBy { it }
    println("成绩最小值为：$min")
}

private fun upScores(list: ArrayList<Double>) {
    //成绩升序
    val newList = ArrayList(list)
    newList.sortDescending()
    newList.forEachIndexed { index, d -> println("第${index + 1}个成绩是$d") }
}

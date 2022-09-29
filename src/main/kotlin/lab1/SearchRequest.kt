package lab1

import java.awt.Desktop
import java.net.URI
import java.net.URL
import java.net.URLEncoder
import com.google.gson.Gson

import java.beans.Encoder
import java.net.HttpURLConnection
import java.net.URLEncoder.*


//1.Считать введенные пользователем данные
//2.Сделать запрос к серверу
//3.Распарсить ответ
//4.Вывести результат поиска
//5.Открыть нужную страницу в браузере

// const
//val link = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
//val linkRes = "https://ru.wikipedia.org/w/index.php?curid="

class SearchRequest {

    private var result: List<StringSearch> = listOf()

    fun readQuest() {
        println("Input your quest")
        var quest: String
        quest = encode(readln(), "UTF-8")

        val linkQuestConnect =
            URL("https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=$quest").openConnection() as HttpURLConnection
        val inform = linkQuestConnect.inputStream.bufferedReader().readText()

        result = listOf(Gson().fromJson(inform, StringRequest::class.java).query.search)

        println("It can be found:")
        for (counter in result.indices)
            println("${counter + 1}:${result[counter].title}")
    }

    fun outputResult() {
        println("Counter of request")
        var counter = readln().toInt()

        if (counter < 0 || counter > result.size)
            throw IllegalArgumentException("It should be another!")
        else
            Desktop.getDesktop().browse(URI("https://ru.wikipedia.org/w/index.php?curid=${result[counter - 1].pageid}"))
    }
}
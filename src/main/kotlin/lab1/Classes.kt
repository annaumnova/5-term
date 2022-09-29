package lab1

//строка поиска
//..."search"= [ { "ns":...,..., "timestamp":...},... ]...
data class StringSearch(
    val ns: Int,
    val title: String,
    val pageid: Int,
    val size: Int,
    val wordcount: Int,
    val snippet: String,
    val timestamp: String,
)

//"query":{"searchinfo":{"totalhits":493},"search":[... }
data class StringQuery(
    val searchinfo: StringSearchInfo,
    val search: StringSearch,
)

//"searchinfo":{"totalhits":493},
data class StringSearchInfo(
    val totalhits: Int,
)

//"continue":{"sroffset":10,"continue":"-||"}
data class StringContinue(
    val sroffset: Int,
    val contin: String,
)

//{"batchcomplete":"","continue":...,"query":...}
data class StringRequest(
    val batchcomplete: String,
    val contin: StringContinue,
    val query: StringQuery,
)
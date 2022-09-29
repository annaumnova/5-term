package lab1

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

//serialization
object SerializableUtils {
    public val json = Json

    fun serialization(statement: SearchRequest) =
        json.encodeToString(statement)

    fun deserialization(statement: String) =
        json.decodeFromString<SearchRequest>(statement)

    fun serializationToFile(statement: SearchRequest, fileName: String) {
        File(fileName).writeText(serialization(statement))
    }

    fun deserializationFromFile(fileName: String): SearchRequest {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }
}
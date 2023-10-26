import kotlinx.browser.document
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import project_group.project_name.lib.Sample

suspend fun adding() {
    val map = mutableMapOf<Sample, Unit>()
    try {
        delay(1L)
        map[Sample("sample")] = Unit
        document.body ?.innerText = "Success put\n"
        document.body ?.innerText += map.toMap().toString() + "\n"
        document.body ?.innerText += map[Sample("sample")].toString() + "\n"
        document.body ?.innerText += Error("Not error").stackTraceToString() + "\n"
        document.body ?.innerText += Sample("sample").hashCode()
    } catch (e: Throwable) {
        document.body ?.innerText = e.stackTraceToString()
        throw e
    }
}

fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        adding()
    }
}
package id.co.orderfaz.core.util
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import java.text.NumberFormat
import java.util.Locale

fun formatThousand(amount: Int) : String {
   return NumberFormat.getNumberInstance(Locale.US)
        .format(amount)
        .replace(",", ".")
}

fun copyTextToClipboard(context:Context, textCopy: String, clipboardManager: ClipboardManager) {
    val clipData = ClipData.newPlainText("text", textCopy)
    clipboardManager.setPrimaryClip(clipData)
    Toast.makeText(context, "$textCopy copied to clipboard", Toast.LENGTH_SHORT).show()
}

fun ToastText(context: Context){
    Toast.makeText(context, "THIS IS TEST", Toast.LENGTH_SHORT).show()
}

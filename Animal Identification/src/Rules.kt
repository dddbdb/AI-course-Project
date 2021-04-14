import kotlin.String

class Rules {
    var rules: Map<Char, String> =
        mapOf(
            'a' to "ab cde qrst",
            'b' to "ab cde qrst",
            'c' to "ab cde fghi jk lmn",
            'd' to "ab cd fghi jk lmn op qrs",
            'e' to "ab ce fghi jk lmn op qrs",
            'f' to "cde fghi jk op qrst",
            'g' to "cde fg jk op qrst",
            'h' to "cde fh jk op qrst",
            'i' to "cde fi jk op qrst",
            'j' to "cde fghi jk l qrst",
            'k' to "cde fghi jk l qrst",
            'l' to "cde jk l op qrst",
            'm' to "cde mn qrst",
            'n' to "cde mn op qrst",
            'o' to "de fghi ln o st",
            'p' to "de fghi ln p st",
            'q' to "ab de fghi jk lmn q st",
            'r' to "ab de fghi jk lmn r t",
            't' to "ab fghi jk lmn op qrst",
        )
}
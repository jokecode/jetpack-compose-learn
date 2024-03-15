package com.example.basicscodelab.data

data class Message(val author: String, val body: String)

object SampleData {
    var conversationSample:List<Message> = listOf(
        Message("AAAQ", "注意：您需要添加以下导入内容才能正确使用 Kotlin 的委托属性语法（by 关键字）。按 Alt+Enter 键或 Option+Enter 键即可添加这些内容。"),
        Message("BBBB", "现在，您可以根据点击消息时消息的 isExpanded 状态，更改消息内容的背景颜色。您将使用 clickable 修饰符来处理可组合项上的点击事件。您会为背景颜色添加动画效果，使其值逐步从 MaterialTheme.colorScheme.surface 更改为 MaterialTheme.colorScheme.primary（反之亦然），而不只是切换 Surface 的背景颜色。为此，您将使用 animateColorAsState 函数。最后，您将使用 animateContentSize 修饰符顺畅地为消息容器大小添加动画效果："),
        Message("CCCC", "可组合函数可以使用 remember 将本地状态存储在内存中，并跟踪传递给 mutableStateOf 的值的变化。该值更新时，系统会自动重新绘制使用此状态的可组合项（及其子项）。这称为重组。"),
        Message("DDDD", "通过使用 Compose 的状态 API（如 remember 和 mutableStateOf），系统会在状态发生任何变化时自动更新界面。"),
        Message("EEEE", "对话变得更加有趣了。是时候添加动画效果了！您将添加展开消息以显示更多内容的功能，同时为内容大小和背景颜色添加动画效果。为了存储此本地界面状态，您需要跟踪消息是否已展开。为了跟踪这种状态变化，您必须使用 remember 和 mutableStateOf 函数。"),
    )
}

class Abc {
    companion object {
        var conversationSample:List<Message> = listOf(
            Message("AAAQ", "ddddddddddd"),
            Message("BBBB", "ddddddddddd"),
            Message("CCCC", "ddddddddddd"),
            Message("DDDD", "ddddddddddd"),
            Message("EEEE", "ddddddddddd"),
        )
    }
}

fun acd() {
    println(Abc.conversationSample)
}

fun main() {
    acd()
}
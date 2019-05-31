package jp.cloudace.tech.clean.demo.tasks.presenters.viewmodels;

import java.util.ArrayList;
import java.util.List;

public final class PrintViewModel {

    private final List<String> messages;
    private final Color messageColor;

    public PrintViewModel(List<String> messages, Color messageColor) {
        this.messages = messages;
        this.messageColor = messageColor;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public Color getMessageColor() {
        return messageColor;
    }

}

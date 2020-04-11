package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News implements PubSubMessage {
    private String title, content;
    private LocalDateTime createdOn;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public News(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdOn = LocalDateTime.now();
    }
    public void printNews() {
        System.out.println("------------- " + title + " -------------\n");
        System.out.println(content);
        System.out.println("------------- " + formatDateTime(createdOn) + " -------------\n");
    }
    private String formatDateTime(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return localDateTime.format(dateTimeFormatter);
    }
}

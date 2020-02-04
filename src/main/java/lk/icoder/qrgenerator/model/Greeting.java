package lk.icoder.qrgenerator.model;

/**
 * @Project qr-generator
 * @Author DILAN on 2/1/2020
 */
public class Greeting {

    private String content;

    public Greeting() {}

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class News implements Comparable<News>{
    String text;
    //from 1 to 10
    int priority;

    public News(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    @Override
    public int compareTo(News news) {
        if(this.priority > news.priority)
            return -1;
        else if (this.priority < news.priority)
            return 1;

        return this.text.length() - news.text.length();
    }
}

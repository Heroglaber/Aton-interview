import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static String[][] lyrics = {
        {"Cher", "They say we're young and we don't know \nWe won't find out until we grow"},
        {"Sonny", "Well I don't know if all that's true \n'Cause you got me, and baby I got you"},
        {"Sonny", "Babe"},
        {"Sonny, Cher", "I got you babe \nI got you babe"},
        {"Cher", "They say our love won't pay the rent \nBefore it's earned, our money's all been spent"},
        {"Sonny", "I guess that's so, we don't have a pot \nBut at least I'm sure of all the things we got"},
        {"Sonny", "Babe"},
        {"Sonny, Cher", "I got you babe \nI got you babe"},
        {"Sonny", "I got flowers in the spring \nI got you to wear my ring"},
        {"Cher", "And when I'm sad, you're a clown \nAnd if I get scared, you're always around"},
        {"Cher", "So let them say your hair's too long \n'Cause I don't care, with you I can't go wrong"},
        {"Sonny", "Then put your little hand in mine \nThere ain't no hill or mountain we can't climb"},
        {"Sonny", "Babe"},
        {"Sonny, Cher", "I got you babe \nI got you babe"},
        {"Sonny", "I got you to hold my hand"},
        {"Cher", "I got you to understand"},
        {"Sonny", "I got you to walk with me"},
        {"Cher", "I got you to talk with me"},
        {"Sonny", "I got you to kiss goodnight"},
        {"Cher", "I got you to hold me tight"},
        {"Sonny", "I got you, I won't let go"},
        {"Cher", "I got you to love me so"},
        {"Sonny, Cher", "I got you babe \nI got you babe \nI got you babe \nI got you babe \nI got you babe"}
    };

    static Deque<Map.Entry<String, String>> lyricsQueue;

    private static String FIRST_SINGER = "Cher";
    private static String SECOND_SINGER = "Sonny";
    private static String CHOIR = "Sonny, Cher";

    public static void main(String[] args) {
        lyricsQueue = Arrays.stream(lyrics)
            .map(row -> new AbstractMap.SimpleEntry<>(row[0], row[1])).collect(Collectors.toCollection(LinkedList::new));
        (new Singer(FIRST_SINGER)).start();
        (new Singer(SECOND_SINGER)).start();
    }

    static class Singer extends Thread{

        private String singerName;
        private String threadName;

        public Singer(String singerName) {
            this.singerName = singerName;
            this.threadName = singerName.toLowerCase() + "_thread:";
        }

        @Override
        public void run() {
                synchronized(Singer.class) {
                    while(!lyricsQueue.isEmpty()) {
                        Map.Entry<String, String> entry = lyricsQueue.element();
                        if (singerName.equals(entry.getKey())) {
                            System.out.println(threadName + " " + entry.getValue());
                            lyricsQueue.remove();
                        } else if (entry.getKey().contains(singerName)){
                            System.out.println(threadName + " " + entry.getValue());
                            lyricsQueue.remove();
                            String newKey = entry.getKey().replace(singerName, "");
                            //Удаляем из ключа названия потоков. Когда их (имен) не останется - окончательно удаляем строчку (Все потоки её спели)
                            if(newKey.matches("^\\W\\s$"))
                                continue;
                            lyricsQueue.addFirst(new AbstractMap.SimpleEntry(newKey, entry.getValue()));
                            Singer.class.notify();
                            try {
                                Singer.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Singer.class.notify();
                            try {
                                Singer.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        }
    }
}

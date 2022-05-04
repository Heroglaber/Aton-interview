# Aton-interview
Задача для собеседования в Атон:

##I got you

Два треда, Sonny и Cher, исполняют в консоли дуэтом хит 1965 года "I Got You Babe" (https://youtu.be/BERd61bDY7k). Каждый тред выводит своем имя,
двоеточие и слова песни, например так:
Cher: They say we're young and we don't know
We won't find out until we grow
Необходимо написать программу, в которой треды работают согласованно, так, чтобы строчки, исполняемые в один голос, выводились в консоль в
правильном порядке. Строчки припева (в 2 голоса, отмечены "Sonny, Cher") должны выводиться каждым тредом, но в любом порядке.
Весь текст задан структурой:
```java
String[][] lyrics = {
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
``` 

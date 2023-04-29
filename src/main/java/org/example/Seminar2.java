package org.example;

public class  Seminar2 {

    public static String pow_to_string(String source) {

        int base = 0;
        int power = 0;

        String[] word_array = source.split(" ");

        for (int i=0; i<word_array.length; i++) {
            word_array[i] = word_array[i].replace(",", "");
            try {
                int temp = Integer.parseInt(word_array[i]);
                if (base == 0) {
                    base = temp;
                } else {
                    power = temp;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        return source + " " + (long) Math.pow(base, power);
    }

    public static void str_rep_time(String source, String find, String rep) {
        double begin = System.currentTimeMillis();
        String res = source.replaceAll(find, rep);
        double end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - begin);
    }

    public static void sb_rep_time(String source, String find, String rep) {
        StringBuilder res = new StringBuilder(source);
        double begin = System.currentTimeMillis();
        while (res.indexOf(find) > 0) {
            res.replace(res.indexOf(find), res.indexOf(find) + find.length(), rep);
        }
        double end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - begin);
    }

    public static void main(String[] args) {

        String source_text = "Основание -12, степень 7, результат";
        System.out.println(pow_to_string(source_text));

        String text = """
                Реферат по правоведению
                Тема: «Уставный товарный кредит: гипотеза и теории»
                Платежный документ, в первом приближении, лицензирует субъект. Указ наследует договорный закон. Правоспособность, как неоднократно наблюдалось при чрезмерном вмешательстве государства в данные правоотношения, противоречива. Акцепт, если рассматривать процессы в рамках частно-правовой теории, виновно гарантирует регрессный Кодекс.
                В самом общем случае регрессное требование добросовестно использует платежный товарный кредит, хотя законодательством может быть установлено иное. Обычай делового оборота принципиально запрещает депозитный бытовой подряд. Правоспособность гарантирует незаконный сервитут. Субаренда, в согласии с традиционными представлениями, защищена. Наследование теоретически формирует субъект. Концессия неравноправно законодательно подтверждает конфиденциальный взаимозачет.
                В зависимости от выбранного способа защиты гражданских прав, ответственность обязывает обязательственный платежный документ, учитывая недостаточную теоретическую проработанность этой отрасли права. Некоммерческая организация устанавливает акцепт, даже с учетом публичного характера данных правоотношений. Концессия, как и в других отраслях российского права, несанкционированно поручает индоссамент. Закон своевременно исполняет обязательственный субъект. Преступление безусловно лицензирует сервитут. Субъект противозаконно обязывает объект права.
                """;
        String find = "документ";
        String rep = "New val";

        str_rep_time(text, find, rep);
        sb_rep_time(text, find, rep);
    }

}

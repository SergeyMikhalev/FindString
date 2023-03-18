import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String target = args[0];
        List<String> lines = Files.readAllLines(Paths.get("words.txt"), StandardCharsets.UTF_8);
        System.out.println("Содержимое файла words.txt");
        System.out.println();

        System.out.println("---");
        lines.forEach(System.out::println);
        System.out.println("---");

        System.out.println();
        List<String> words = new ArrayList<>();
        for (String line : lines) {
            words.addAll(Arrays.stream(line.split(" ")).collect(Collectors.toList()));
        }
        AtomicInteger i = new AtomicInteger();
        words.forEach(s -> {
                    if (target.equals(s)) {
                        i.getAndIncrement();
                    }
                }
        );
        System.out.println("Число вхождений слова <" + target + "> в файл words.txt -> " + i.get());
    }
}
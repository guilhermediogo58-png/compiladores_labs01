import java.util.regex.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class ScannerLivro {

    //funcao que quebra o texto em tokens
    public static List<String> tokenize(String texto) {
        List<String> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\w+|[^\\w\\s]");
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    public static void main(String[] args) throws IOException {

        //le o arquivo
        String texto = new String(Files.readAllBytes(Path.of("livro.txt")));

        //tokeniza
        List<String> tokens = tokenize(texto);

        //imprime no formato de lista
        System.out.print("[");

        for (int i = 0; i < tokens.size(); i++) {
            System.out.print("\"" + tokens.get(i) + "\"");

            // adiciona vírgula entre os elementos
            if (i < tokens.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        //salva no arquivo no mesmo formato
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < tokens.size(); i++) {
            sb.append("\"").append(tokens.get(i)).append("\"");

            if (i < tokens.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        Files.write(Path.of("tokens.txt"), sb.toString().getBytes());

        // quantidade total
        System.out.println("\nTotal de tokens: " + tokens.size());
    }
}
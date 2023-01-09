import entities.LogEntry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("==================================");
    //Caminho do arquivo:  C:\Users\Guest\Documents\projetos\curso java\ARQUIVOS\input file.txt
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter file full path: ");
    String path = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      //espero que tenha ficado claro o macete que agente fez de usar a estrutura set como ele nao aceita repitiçoes
      // sempre que vou ler um usuario que ja existi e tento enserir no conjunto a incerçao e barrada ai no final das contas
      //ele vai ter apenas uma ocorrencia de cada usuario por isso que no final das contas o tamanho do conjunto ficou valendo 4
      Set<LogEntry> set = new HashSet<>();

      String line = br.readLine();
      while (line != null) {
        String[] fields = line.split(" ");
        String username = fields[0];
        Date moment = Date.from(Instant.parse(fields[1]));

        set.add(new LogEntry(username, moment));

        line = br.readLine();
      }

      System.out.println("Total users: " + set.size());
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    System.out.println("==================================");
    sc.close();
  }
}

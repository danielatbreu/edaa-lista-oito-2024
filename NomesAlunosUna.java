import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NomesAlunosUna {

    public static void main(String[] args) {
        // Caminho do arquivo CSV
        String csvFile = "estudantes_una_2024.csv";
        // Delimitador utilizado no arquivo CSV
        String csvSplitBy = ",";
        // Variável para verificar se é a primeira linha do arquivo
        boolean primeiraLinha = true;

        List<String> nomesEstudantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String linha;
            // Lê cada linha do arquivo CSV
            while ((linha = br.readLine()) != null) {
                // Ignora a primeira linha (cabeçalho)
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Divide a linha em campos utilizando o delimitador
                String[] dadosEstudante = linha.split(csvSplitBy);
                // Obtém o nome do estudante e adiciona na lista
                String nomeEstudante = dadosEstudante[0].trim();
                nomesEstudantes.add(nomeEstudante);
            }

            Collections.sort(nomesEstudantes);

            for (String nome : nomesEstudantes) {
                String prefixo = "Nome: ";
                System.out.println(prefixo + nome);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.net.URI
import kotlin.system.exitProcess

fun main() {
    // Lista de URLs para o jogo
    val urls = listOf(
        "1",
        "3",
        "6",
        "15"
    )

    // Escolhe uma URL aleatória da lista
    val selectedUrl = URI(urls.random())

    // Mostra partes da URI para adivinhação
    println("Tente adivinhar as partes da URL escolhida!")
    println("Host: ${selectedUrl.host}")
    println("Path: ???")
    println("Query: ???")

    // Lê a entrada do usuário
    print("Digite seu palpite para o Path: ")
    val pathGuess = readLine()
    print("Digite seu palpite para a Query: ")
    val queryGuess = readLine()

    // Verifica as respostas
    if (pathGuess == selectedUrl.path && queryGuess == selectedUrl.query) {
        println("Parabéns! Você acertou tudo!")
    } else {
        println("Não foi dessa vez. O Path correto era '${selectedUrl.path}' e a Query era '${selectedUrl.query}'.")
    }

    // Pergunta se o jogador quer jogar novamente
    println("Você quer jogar novamente? (sim/não)")
    when (readLine()) {
        "sim" -> main()  // Reinicia o jogo
        else -> exitProcess(0)
    }
}
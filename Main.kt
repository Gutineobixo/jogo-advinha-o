import java.net.URI
import kotlin.system.exitProcess

fun main() {
    val urls = listOf(
        "3",
        "6",
        "9",
        "15"
    )

    var totalScore = 0
    val rounds = 3  // Número de rodadas

    for (round in 1..rounds) {
        println("\nRodada $round de $rounds")
        val selectedUrl = URI(urls.random())

        val maxPoints = 10
        var pointsForThisRound = maxPoints

        println("Host: ${selectedUrl.host}")
        println("Path: ???")
        println("Query: ???")

        println("Você pode pedir uma dica para Path ou Query (perde 3 pontos), ou tentar adivinhar.")
        print("Digite 'dica path', 'dica query' ou 'adivinhar': ")
        val choice = readLine()

        when (choice) {
            "dica path" -> {
                println("Dica - Path começa com: ${selectedUrl.path.take(5)}...")
                pointsForThisRound -= 3
            }
            "dica query" -> {
                println("Dica - Query começa com: ${selectedUrl.query?.take(5) ?: "N/A"}...")
                pointsForThisRound -= 3
            }
        }

        print("Digite seu palpite para o Path: ")
        val pathGuess = readLine()
        print("Digite seu palpite para a Query: ")
        val queryGuess = readLine()

        val correctPath = pathGuess == selectedUrl.path
        val correctQuery = queryGuess == selectedUrl.query

        if (correctPath && correctQuery) {
            println("Parabéns! Você acertou tudo!")
            totalScore += pointsForThisRound
        } else {
            println("Não foi dessa vez.")
            println("O Path correto era '${selectedUrl.path}' e a Query era '${selectedUrl.query}'.")
        }

        println("Pontos nesta rodada: $pointsForThisRound")
        println("Pontuação total: $totalScore")
    }

    println("Jogo concluído. Sua pontuação final é: $totalScore")
    println("Você quer jogar novamente? (sim/não)")
    when (readLine()) {
        "sim" -> main()  // Reinicia o jogo
        else -> exitProcess(0)
    }
}
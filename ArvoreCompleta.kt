class ArvoreBinariaCompleta {
    private val nos = mutableListOf<Int>()

    fun inserir(valor: Int) {
        nos.add(valor)
    }

    fun travessiaEmOrdem(indice: Int = 0) {
        if (indice >= nos.size) return

        val indiceEsquerda = 2 * indice + 1
        val indiceDireita = 2 * indice + 2

        travessiaEmOrdem(indiceEsquerda)
        print("${nos[indice]} ")
        travessiaEmOrdem(indiceDireita)
    }
}

fun main() {
    val arvoreCompleta = ArvoreBinariaCompleta()
    arvoreCompleta.inserir(1)
    arvoreCompleta.inserir(2)
    arvoreCompleta.inserir(3)
    arvoreCompleta.inserir(4)
    arvoreCompleta.inserir(5)
    arvoreCompleta.inserir(6)
    arvoreCompleta.inserir(7)

    println("Travessia em Ordem da Árvore Binária Completa:")
    arvoreCompleta.travessiaEmOrdem()  
}

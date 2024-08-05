class No(val valor: Int) {
    var esquerda: No? = null
    var direita: No? = null
}

class ArvoreBinariaDeBusca {
    private var raiz: No? = null

    fun inserir(valor: Int) {
        raiz = inserirRecursivo(raiz, valor)
    }

    private fun inserirRecursivo(no: No?, valor: Int): No {
        if (no == null) {
            return No(valor)
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor)
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor)
        }

        return no
    }

    fun travessiaEmOrdem() {
        travessiaEmOrdemRecursiva(raiz)
    }

    private fun travessiaEmOrdemRecursiva(no: No?) {
        if (no != null) {
            travessiaEmOrdemRecursiva(no.esquerda)
            print("${no.valor} ")
            travessiaEmOrdemRecursiva(no.direita)
        }
    }
}

fun main() {
    val arvore = ArvoreBinariaDeBusca()
    arvore.inserir(5)
    arvore.inserir(3)
    arvore.inserir(7)
    arvore.inserir(2)
    arvore.inserir(4)
    arvore.inserir(6)
    arvore.inserir(8)

    println("Travessia em Ordem da Árvore Binária de Busca:")
    arvore.travessiaEmOrdem()  
}

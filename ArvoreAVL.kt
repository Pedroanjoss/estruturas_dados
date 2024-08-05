class NoAVL(val valor: Int) {
    var esquerda: NoAVL? = null
    var direita: NoAVL? = null
    var altura: Int = 1
}

class ArvoreAVL {
    private var raiz: NoAVL? = null

    fun inserir(valor: Int) {
        raiz = inserirRecursivo(raiz, valor)
    }

    private fun inserirRecursivo(no: NoAVL?, valor: Int): NoAVL {
        if (no == null) {
            return NoAVL(valor)
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor)
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor)
        } else {
            return no
        }

        no.altura = 1 + maxOf(altura(no.esquerda), altura(no.direita))
        val equilibrio = obterEquilibrio(no)

        if (equilibrio > 1 && valor < no.esquerda!!.valor) {
            return rotacionarParaDireita(no)
        }

        if (equilibrio < -1 && valor > no.direita!!.valor) {
            return rotacionarParaEsquerda(no)
        }

        if (equilibrio > 1 && valor > no.esquerda!!.valor) {
            no.esquerda = rotacionarParaEsquerda(no.esquerda)
            return rotacionarParaDireita(no)
        }

        if (equilibrio < -1 && valor < no.direita!!.valor) {
            no.direita = rotacionarParaDireita(no.direita)
            return rotacionarParaEsquerda(no)
        }

        return no
    }

    private fun rotacionarParaEsquerda(z: NoAVL): NoAVL {
        val y = z.direita!!
        val T2 = y.esquerda

        y.esquerda = z
        z.direita = T2

        z.altura = 1 + maxOf(altura(z.esquerda), altura(z.direita))
        y.altura = 1 + maxOf(altura(y.esquerda), altura(y.direita))

        return y
    }

    private fun rotacionarParaDireita(y: NoAVL): NoAVL {
        val x = y.esquerda!!
        val T2 = x.direita

        x.direita = y
        y.esquerda = T2

        y.altura = 1 + maxOf(altura(y.esquerda), altura(y.direita))
        x.altura = 1 + maxOf(altura(x.esquerda), altura(x.direita))

        return x
    }

    private fun altura(no: NoAVL?): Int {
        return no?.altura ?: 0
    }

    private fun obterEquilibrio(no: NoAVL): Int {
        return altura(no.esquerda) - altura(no.direita)
    }

    fun travessiaEmOrdem() {
        travessiaEmOrdemRecursiva(raiz)
    }

    private fun travessiaEmOrdemRecursiva(no: NoAVL?) {
        if (no != null) {
            travessiaEmOrdemRecursiva(no.esquerda)
            print("${no.valor} ")
            travessiaEmOrdemRecursiva(no.direita)
        }
    }
}

fun main() {
    val arvoreAVL = ArvoreAVL()
    arvoreAVL.inserir(10)
    arvoreAVL.inserir(20)
    arvoreAVL.inserir(30)
    arvoreAVL.inserir(15)
    arvoreAVL.inserir(25)

    println("Travessia em Ordem da Árvore AVL:")
    arvoreAVL.travessiaEmOrdem()  // Saída: 10 15 20 25 30
}

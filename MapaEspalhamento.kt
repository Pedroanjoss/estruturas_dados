class MapaEspalhamento(private val tamanhoTabela: Int = 10) : Espalhavel {

    private var tabelaEspalhamento: Array<Listavel> = Array(tamanhoTabela) { ListaDinamica() }
    private var quantidade = 0

    private fun funcaoEspalhamento(chave: Any): Int {
        val chaveString = chave.toString()
        val letraInicial = chaveString.lowercase()[0]
        return letraInicial.code % tamanhoTabela
    }

    private fun funcaoEspalhamento2(chave: Any): Int {
        val chaveString = chave.toString()
        var total = 0
        for (i in 0 until chaveString.length) {
            val letra = chaveString.lowercase()[i]
            total += letra.code
        }
        return total % tamanhoTabela
    }

    override fun adicionar(mapa: Mapa) {
        val indice = funcaoEspalhamento(mapa.chave)
        val listaTemp = tabelaEspalhamento[indice]
        if (contemChave(mapa.chave)) {
            for (i in 0 until listaTemp.tamanho()) {
                val elementoLista = listaTemp.selecionar(i) as Mapa
                val chaveLista = elementoLista.chave
                if (chaveLista == mapa.chave) {
                    listaTemp.atualizar(i, mapa)
                    break
                }
            }
        } else {
            listaTemp.anexar(mapa)
            quantidade = quantidade.inc()
        }
    }

    override fun remover(chave: Any): Any? {
        var dadoAuxiliar: Any? = null
        if (!estaVazia()) {
            if (contemChave(chave)) {
                val indice = funcaoEspalhamento(chave)
                val listaTemp = tabelaEspalhamento[indice]
                for (i in 0 until listaTemp.tamanho()) {
                    val elementoLista = listaTemp.selecionar(i) as Mapa
                    val chaveLista = elementoLista.chave
                    if (chave == chaveLista) {
                        dadoAuxiliar = elementoLista.dado
                        listaTemp.apagar(i)
                        quantidade = quantidade.dec()
                        break
                    }
                }
            } else {
                println("Chave não existente.")
            }
        } else {
            println("A estrutura de dados está vazia.")
        }
        return dadoAuxiliar
    }

    override fun contemChave(chave: Any): Boolean {
        var chaveEncontrada = false
        if (!estaVazia()) {
            val indice = funcaoEspalhamento(chave)
            val listaTemp = tabelaEspalhamento[indice]
            for (i in 0 until listaTemp.tamanho()) {
                val elementoLista = listaTemp.selecionar(i) as Mapa
                val chaveLista = elementoLista.chave
                if (chave == chaveLista) {
                    chaveEncontrada = true
                    break
                }
            }
        } else {
            println("A estrutura de dados está vazia.")
        }
        return chaveEncontrada
    }

    override fun buscar(chave: Any): Any? {
        var dadoAuxiliar: Any? = null
        if (!estaVazia()) {
            if (contemChave(chave)) {
                val indice = funcaoEspalhamento(chave)
                val listaTemp = tabelaEspalhamento[indice]
                for (i in 0 until listaTemp.tamanho()) {
                    val elementoLista = listaTemp.selecionar(i) as Mapa
                    val chaveLista = elementoLista.chave
                    if (chave == chaveLista) {
                        dadoAuxiliar = elementoLista.dado
                        break
                    }
                }
            } else {
                println("Chave não existente.")
            }
        } else {
            println("A estrutura de dados está vazia")
        }
        return dadoAuxiliar
    }

    override fun tamanho(): Int {
        return quantidade
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in 0 until tabelaEspalhamento.size) {
            val listaTemp = tabelaEspalhamento[i]
            resultado += listaTemp.imprimir()
        }
        return "$resultado]"
    }
}

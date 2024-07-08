class ListaDinamica(private val tamanho: Int = 10): Listavel{
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun anexar(dado: Any?){
        if (!estaCheia()){
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
               if (!estaVazia())
                   ponteiroFim?.proximo = noTemp
                else
                ponteiroInicio = noTemp

            ponteiroFim = noTemp
            quantidade = quantidade.inc()

        }else{
            println("Lista Cheia")
        }

    }

    override fun selecionarTodos(): Array<Any?> {
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()){
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until quantidade){
                dadosAux[i] = ponteiroAuxiliar?.dado
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
        }else{prinln("Lista Vazia")}
        return dadosAux
    }

    override fun selecionar(posicao: Int): Any?{
        var dadosAux: Any? = null
        if (!estaVazia()){
            if (posicao>=0 && posicao < quantidade){
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao){
                    ponteiroAux = ponteiroAux?.proximo
                    dadosAux = ponteiroAux?.dado
                }
            }else{
                println("Indice Invalido")
            }
        }else{
            println("Lista Cheia")
        }
        return dadosAux
    }

    override fun atualizar(posicao: Int, dado: Any?){
        if (!estaVazia()){
            if (posicao >= 0 && posicao < quantidade ){
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao)
                    ponteiroAux = ponteiroAux?.proximo

                    ponteiroAux?.dado = dado

            }else(
                println("Indice invalido")
            )
        }else{
            println("lista vazia")
        }

    }

    override fun limpar(){
        ponteiroFim = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun apagarTodos(): Array<Any?>{
        var dadosAux: Array<Any?> = selecionarTodos()
        limpar()
        return dadosAux
    }

    override fun apagar(posicao: Int): Any?{
        var dadosAux: Any? = null
        if (!estaVazia()){
            if (posicao>=0 && posicao < quantidade){
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao){
                    ponteiroAux = ponteiroAux?.proximo
                }

                dadosAux = ponteiroAux?.dado

                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux.proximo

                if (ponteiroAnterior != null)
                    ponteiroAnterior.proximo = ponteiroProximo
                else
                    ponteiroInicio = ponteiroInicio?.proximo

                if (ponteiroProximo != null)
                    ponteiroProximo.anterior = ponteiroAnterior
                else
                    ponteiroFim = ponteiroFim?.anterior

                quantidade = quantidade.dec()

            }else{
                println("Indice Invalido")
            }
        }else{
            println("Vazia")
        }
        return dadosAux
    }

    override fun inserir(posicao: Int, dado: Any?){
        if (!estaCheia()){
            if (posicao>=0 && posicao<= quantidade){
                val noTemp = NoDuplo(dado)

              var ponteiroAnterior: NoDuplo? = null
              var ponteiroProximo = ponteiroInicio

              for (i in 0 until posicao){
                  ponteiroAnterior = ponteiroProximo
                  ponteiroProximo = ponteiroProximo?.proximo
              }

              if (ponteiroAnterior!=null)
                  ponteiroAnterior.proximo = noTemp
                else
                    ponteiroInicio = noTemp

             if (ponteiroProximo!= null){
                 ponteiroProximo.anterio = noTemp
             }   else
                 ponteiroFim = noTemp

                noTemp.proximo = ponteiroProximo
                noTemp.anterior = ponteiroAnterior

                quantidade= quantidade.inc()
            }else{
                println("Indice invalido")
            }


        }else{
            println("Lista Cheia")
        }
    }

    override fun estaCheia(): Boolean{
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean{
        return quantidade == 0
    }

    override fun tamanho(): Int{
        return quantidade
    }
}

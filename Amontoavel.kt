class ArvoreMinimaHeap (private val tamanho: Int = 10): Amontoavel{

    private var dados = LongArray(tamanho){0}
    private var ponteiroFim = -1


    override fun inserir(dado: Long){
        if (!estaCheia()){
            ponteiroFim = ponteiroFim.inc()

          dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        }else{
            println("cheia")
        }
    }

    override fun ajustarAcima(indice: Int){
        var indiceAtual = indice
        while (indiceAtual!=0){
            val indicePai = indicePai(indiceAtual)
            if (dados[indicePai] > dados[indiceAtual]){
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai

            }else{
                break
            }        }
    }


    override fun ajustarAbaixo(pai: Int){

        val filhoEsquerdo = indiceFilhoEsquerdo(pai)
        val filhoDireito = indiceFilhoDireito(pai)
        var menor = pai

        if (filhoEsquerdo<= ponteiroFim)
            if (dados[menor] > dados[filhoEsquerdo])
                menor = filhoEsquerdo

        if (filhoDireito <= ponteiroFim)
            if (dados[menor] > dados[filhoDireito])
                menor = filhoDireito

        if (menor != pai){
            trocar(pai, menor)
            ajustarAbaixo(menor)
        }
    }


    private fun trocar(i: Int, j:Int){
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun indicePai(indiceFilho: Int): Int{
        return (indiceFilho-1)/2
    }

    private fun indiceFilhoEsquerdo(indicePai: Int): Int{
        return 2 * indicePai +1
    }

    private fun indiceFilhoDireito(indicePai: Int): Int{
        return (2*indicePai+1)+1
    }

    override fun estaVazia(): Boolean{
        return ponteiroFim == -1
    }

    override fun estaCheia(): Boolean{
        return ponteiroFim = dados.size - 1
    }

    override fun imprimir(): String{
        var resultado = "["
        for (i in 0..ponteiroFim){
            resultado += "${dados[i]}"
              if (i != ponteiroFim)
                  resultado += ","
        }
        return "$resultado]"
    }

}
